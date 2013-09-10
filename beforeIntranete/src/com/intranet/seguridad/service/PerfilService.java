package com.intranet.seguridad.service;

import com.intranet.bean.Perfil;
import com.intranet.bean.Usuario;
import com.intranet.seguridad.dao.DAOFactory;
import com.intranet.seguridad.dao.PerfilDAO_I;

public class PerfilService implements PerfilService_I {

	DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.IBATIS);
	PerfilDAO_I perfildao=fabrica.getPerfilDAO();
		
	@Override
	public Perfil obtenerPerfil(Usuario user) throws Exception {
		return perfildao.buscarPerfil(user);
	}

	
}
