package com.intranet.nota.service;

import java.util.List;

import com.intranet.bean.Curso;
import com.intranet.bean.Inscripcion;
import com.intranet.bean.Usuario;

public interface CursoService_I {

	public List<Curso> buscarCursos(Usuario usi);
	
	//s# de secretaria
	public int obtenerCantidadDeCursosDelSemestre(Inscripcion inscripcion);

}
