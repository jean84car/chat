package com.chat.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.chat.dto.MensajeDTO;
import com.chat.dto.MensajeOutDTO;
import com.chat.dto.RespuestaDTO;
import com.chat.model.UsuarioEntity;
import com.chat.model.repository.UsuarioRepository;
import com.chat.service.IChatService;
import com.google.gson.Gson;

@Service
public class ChatService implements IChatService {

	private static final Logger LOG = LoggerFactory.getLogger(ChatService.class); 
	
	private SimpMessagingTemplate simpMessagingTemplate;
	private UsuarioRepository usuarioRepository;

    public ChatService(SimpMessagingTemplate simpMessagingTemplate, UsuarioRepository usuarioRepository) {
        this.simpMessagingTemplate = simpMessagingTemplate;
        this.usuarioRepository = usuarioRepository;
    }
	
	@Override
	public RespuestaDTO enviarMensaje(MensajeDTO mensaje) {
		RespuestaDTO respuesta = new RespuestaDTO();
		try {
			List<UsuarioEntity> lusuario = usuarioRepository.findByTelefono(mensaje.getTelefono());	
			if(lusuario.isEmpty()) {
				LOG.error(new StringBuilder("CHAT :: ENVIO_MENSAJE :: ERROR : usuario ").append(mensaje.getTelefono())
					.append(" no existe").toString());
				respuesta.setExito(Boolean.FALSE);
				return respuesta;
			}
			
			UsuarioEntity usuario = lusuario.get(0);
			MensajeOutDTO response = new MensajeOutDTO(new Gson().toJson(mensaje));
			LOG.info(new StringBuilder("CHAT :: ENVIO_MENSAJE :: GRUPO : ").append(usuario.getGrupo().getNombre())
				.append(" : MENSAJE : ").append(mensaje).toString());
			simpMessagingTemplate.convertAndSend("/g/" + usuario.getGrupo().getIdGrupo(), response);
			respuesta.setExito(Boolean.TRUE);
		} catch(Exception e) {
			LOG.error("CHAT :: ENVIO_MENSAJE :: ERROR", e);
			respuesta.setExito(Boolean.FALSE);
		}
		
		return respuesta;
	}

}
