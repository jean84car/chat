package com.chat.dto;

import com.chat.util.UtilString;

public class MensajeOutDTO {

	private String contenido;
	
	public MensajeOutDTO(String contenido) {
		this.contenido = contenido;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
	@Override
	public String toString() {
		return UtilString.objectToString(this);
	}
}
