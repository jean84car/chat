package com.chat.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import com.chat.dto.MensajeDTO;
import com.chat.dto.RespuestaDTO;
import com.chat.model.Usuario;
import com.chat.model.UsuarioEntity;
import com.chat.model.repository.UsuarioRepository;
import com.chat.service.impl.ChatService;

@SpringBootTest
public class ChatControllerTest {
	
	private UsuarioRepository usuarioRepositorio;
	private ChatService chatService;
	private final List<UsuarioEntity> usuarios = new ArrayList<>();

	
	@BeforeEach
	void setUp() {
		usuarioRepositorio = mock(UsuarioRepository.class);
		SubscribableChannel channel = mock(SubscribableChannel.class);
		SimpMessagingTemplate simpMessagingTemplate = new SimpMessagingTemplate(channel);
		chatService = new ChatService(simpMessagingTemplate, usuarioRepositorio);
		usuarios.add(Usuario.USUARIO);
	}

	@Test
	void enviarMensageTest() {
		when(usuarioRepositorio.findByTelefono("3175225522")).thenReturn(usuarios);
		MensajeDTO mensaje = new MensajeDTO();
		mensaje.setMensaje("Hola!!");
		mensaje.setTelefono("3175225522");
		RespuestaDTO respuesta = chatService.enviarMensaje(mensaje);
		assertEquals(respuesta.getExito(), Boolean.FALSE);
	}
	
	@Test
	void enviarMensageUsuarioNoFoundTest() {
		when(usuarioRepositorio.findByTelefono("3175225522")).thenReturn(usuarios);
		MensajeDTO mensaje = new MensajeDTO();
		mensaje.setMensaje("Hola!!");
		mensaje.setTelefono("31752255221");
		RespuestaDTO respuesta = chatService.enviarMensaje(mensaje);
		assertEquals(respuesta.getExito(), Boolean.FALSE);
	}
	
}
