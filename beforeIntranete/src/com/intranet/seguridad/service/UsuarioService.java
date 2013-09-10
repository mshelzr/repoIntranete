package com.intranet.seguridad.service;

import com.intranet.bean.Usuario;
import com.intranet.seguridad.dao.DAOFactory;
import com.intranet.seguridad.dao.UsuarioDAO_I;

public class UsuarioService implements UsuarioService_I	{
	DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.IBATIS);
	UsuarioDAO_I usuariodao=fabrica.getUsuarioDAO();
		
	@Override
	public Usuario buscarUsuario(Usuario user) throws Exception {
		return usuariodao.validarUsuario(user);
	}

}
