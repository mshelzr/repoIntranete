package com.intranet.seguridad.dao;

import org.apache.ibatis.session.SqlSession;

import com.intranet.bean.Usuario;
import com.intranet.ibatis.MyIbatisManager;

public class UsuarioDAO implements UsuarioDAO_I{

	@Override
	public Usuario validarUsuario(Usuario user) throws Exception {
		
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		Usuario usuario=(Usuario) sesion.selectOne("buscarUsuario", user);
		sesion.close();
		
		return usuario;
	}

}
