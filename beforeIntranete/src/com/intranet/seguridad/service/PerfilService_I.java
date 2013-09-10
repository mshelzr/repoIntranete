package com.intranet.seguridad.service;

import com.intranet.bean.Perfil;
import com.intranet.bean.Usuario;

public interface PerfilService_I {

	public Perfil obtenerPerfil(Usuario user) throws Exception;
	
}
