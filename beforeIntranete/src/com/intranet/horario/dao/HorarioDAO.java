package com.intranet.horario.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.intranet.bean.Horario;
import com.intranet.bean.Usuario;
import com.intranet.ibatis.MyIbatisManager;

public class HorarioDAO implements HorarioDAO_I {

	@Override
	public List<Horario> obtenerHorario(Usuario usi) {
		SqlSession sesion=MyIbatisManager.getSqlSessionFactory().openSession(true);
		List<Horario> horarioList=sesion.selectList("buscarHorario",usi);
		
		return horarioList;
	}

}
