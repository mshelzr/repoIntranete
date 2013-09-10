package com.intranet.horario.dao;

import java.util.List;

import com.intranet.bean.Horario;
import com.intranet.bean.Usuario;

public interface HorarioDAO_I {

	public List<Horario> obtenerHorario(Usuario usi); 
	
}
