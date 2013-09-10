package com.intranet.horario.service;

import java.util.List;

import com.intranet.bean.Horario;
import com.intranet.bean.Usuario;

public interface HorarioService_I {

	public List<Horario> buscarHorario(Usuario usi);
	
}
