package com.intranet.horario.service;

import java.util.List;

import com.intranet.bean.Horario;
import com.intranet.bean.Usuario;
import com.intranet.horario.dao.HorarioDAO_I;
import com.intranet.seguridad.dao.DAOFactory;

public class HorarioService implements HorarioService_I {

	DAOFactory factory=DAOFactory.getDAOFactory(DAOFactory.IBATIS);
	HorarioDAO_I horariodao=factory.getHorarioDAO();
	
	@Override
	public List<Horario> buscarHorario(Usuario usi) {
		
		return horariodao.obtenerHorario(usi);
	}

}
