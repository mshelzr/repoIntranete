package com.intranet.nota.dao;

import java.util.List;

import com.intranet.bean.Curso;
import com.intranet.bean.Detalle_cursoSeccion;
import com.intranet.bean.Inscripcion;
import com.intranet.bean.Usuario;

public interface CursoDAO_I {

	public List<Curso> obtenerCursos(Usuario usi);
	
	//s# de secretaria
	public List<Detalle_cursoSeccion> obtenerCursosDelAlumno(Inscripcion inscripcion);
	public int obtenerCantidadDeCursosDelSemestre(Inscripcion inscripcion);

}
