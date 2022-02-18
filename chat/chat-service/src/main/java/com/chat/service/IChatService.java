package com.chat.service;

import com.chat.dto.MensajeDTO;
import com.chat.dto.RespuestaDTO;

public interface IChatService {

	public RespuestaDTO enviarMensaje(MensajeDTO mensaje);
	
}
