package com.chat.dto;

import com.chat.util.UtilString;

public class MensajeDTO {

	private String mensaje;
	private String telefono;

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return UtilString.objectToString(this);
	}

}
