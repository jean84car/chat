package com.chat.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chat.dto.MensajeDTO;
import com.chat.dto.RespuestaDTO;
import com.chat.service.IChatService;

@RestController
public class ChatController {
	
	private static final Logger LOG = LoggerFactory.getLogger(ChatController.class);
	
	private IChatService chatService;

    public ChatController(SimpMessagingTemplate simpMessagingTemplate, IChatService chatService) {
        this.chatService = chatService;
    }
	
	@PostMapping("/chat/message")
	public ResponseEntity<RespuestaDTO> enviarMensage(@RequestBody MensajeDTO mensaje) {
		LOG.info(new StringBuilder("CHAT :: ENVIAR_MENSAJE :: REQUEST : ").append(mensaje).toString());
		RespuestaDTO respuesta = chatService.enviarMensaje(mensaje);
		LOG.info(new StringBuilder("CHAT :: ENVIAR_MENSAJE :: RESPONSE : ").append(respuesta).toString());
		return new ResponseEntity<>(respuesta, 
			Boolean.TRUE.equals(respuesta.getExito()) ?  HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
