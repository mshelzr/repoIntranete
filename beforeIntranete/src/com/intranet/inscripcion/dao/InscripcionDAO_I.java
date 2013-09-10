package com.intranet.inscripcion.dao;

import java.util.List;

import com.intranet.bean.Curso;
import com.intranet.bean.Inscripcion;
import com.intranet.bean.Usuario;
import com.intranet.inscripcion.bean.DatosReqInscripcionDTO;

public interface InscripcionDAO_I {

	public List<Curso> obtenerCursosAnteriores(Usuario usi);
	public List<Curso> obtenerCursosAnteriores2(Usuario usi);
	public List<Curso> obtenerCursosActuales(Usuario usi);
	public List<Curso> obtenerCursosActuales2(Usuario usi);
	public List<Curso> obtenerCursosFuturos(Usuario usi);	
	public Curso obtenerCursoBean(Curso cursi);
	public int obtenerDatosPreInscripcion(Usuario usi);
	public double obtenerPromAntCiclo(Usuario usi);
	
	//sesion de secretaria:
	public List<Inscripcion> obtenerInscripcionesDelSemestre();
}
