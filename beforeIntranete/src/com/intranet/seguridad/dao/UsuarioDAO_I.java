package com.intranet.seguridad.dao;

import com.intranet.bean.Usuario;

public interface UsuarioDAO_I {

	public Usuario validarUsuario(Usuario user) throws Exception;	
	
}
