package com.intranet.inscripcion.service;

import java.util.List;

import com.intranet.bean.Curso;
import com.intranet.bean.Usuario;
import com.intranet.inscripcion.bean.DatosReqInscripcionDTO;

public interface InscripcionService_I {

	public List<Curso> buscarCursosAnt(Usuario usi);
	public List<Curso> buscarCursosAnt2(Usuario usi);
	public List<Curso> buscarCursosAct(Usuario usi);
	public List<Curso> buscarCursosAct2(Usuario usi);
	public List<Curso> buscarCursosFut(Usuario usi);
	public Curso buscarCursoBean(Curso cursi);
	public int buscarDAtosPreInscripcion(Usuario usi);
	public double buscarPromAntCiclo(Usuario usi);
	
}
