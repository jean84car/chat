package com.chat.dto;

import com.chat.util.UtilString;

public class RespuestaDTO {

	private Boolean exito;

	public Boolean getExito() {
		return exito;
	}

	public void setExito(Boolean exito) {
		this.exito = exito;
	}
	
	@Override
	public String toString() {
		return UtilString.objectToString(this);
	}
}
