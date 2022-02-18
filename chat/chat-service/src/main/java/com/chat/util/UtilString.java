package com.chat.util;

import com.google.gson.Gson;

public class UtilString {

	protected static final Gson GSON = new Gson();
	
	public UtilString() {
		//pendiente 
	}
	
	public static String objectToString(Object object) {
		return GSON.toJson(object);
	}
	
}
