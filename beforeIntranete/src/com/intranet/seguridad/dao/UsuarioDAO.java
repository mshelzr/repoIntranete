package com.intranet.seguridad.dao;

import org.hibernate.Session;

import com.intranet.bean.UsuarioDTO;
import com.intranet.util.HbnConexion;

public class UsuarioDAO{

	public UsuarioDTO validarUsuario(UsuarioDTO user){
		Session s=HbnConexion.getSessionFactory().getCurrentSession();
		s.beginTransaction();
		UsuarioDTO usuario=(UsuarioDTO)s.get(UsuarioDTO.class, user.getIdUsuario());
		s.getTransaction().commit();
		
		return usuario;
	}

}
