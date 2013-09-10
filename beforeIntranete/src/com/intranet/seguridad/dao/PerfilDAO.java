package com.intranet.seguridad.dao;

import org.apache.ibatis.session.SqlSession;

import com.intranet.bean.Perfil;
import com.intranet.bean.Usuario;
import com.intranet.ibatis.MyIbatisManager;

public class PerfilDAO {

	public Perfil buscarPerfil(Usuario user) {
	
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		Perfil perfil=(Perfil) sesion.selectOne("traePerfil", user);
		sesion.close();
		
		return perfil;
	}

}
