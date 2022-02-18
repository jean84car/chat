package com.chat.model;

public class Usuario {
	
	public Usuario() {
		// pendiente
	}

	public static final UsuarioEntity USUARIO = new UsuarioEntity();
	static {
		GrupoEntity grupo = new GrupoEntity();
		grupo.setIdGrupo(1L);
		grupo.setNombre("test");
		USUARIO.setGrupo(grupo);
		USUARIO.setIdUsuario(1L);
		USUARIO.setTelefono("3175225522");
	}
	
}
