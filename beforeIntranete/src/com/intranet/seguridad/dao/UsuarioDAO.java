package com.intranet.seguridad.dao;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.intranet.bean.UsuarioDTO;
import com.intranet.util.HbnConexion;

public class UsuarioDAO{

	public UsuarioDTO validarUsuario(UsuarioDTO user){
		Session s=HbnConexion.getSessionFactory().getCurrentSession();
		s.beginTransaction();
		UsuarioDTO usuario=(UsuarioDTO)s.createCriteria(UsuarioDTO.class)
										.add(Restrictions.eq("user", user.getUser()))
										.uniqueResult();
		s.getTransaction().commit();
		
		return usuario;
	}

}
