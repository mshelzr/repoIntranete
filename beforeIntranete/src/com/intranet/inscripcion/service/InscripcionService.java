package com.intranet.inscripcion.service;

import java.util.List;

import org.eclipse.jdt.internal.compiler.flow.InsideSubRoutineFlowContext;

import com.intranet.bean.Curso;
import com.intranet.bean.Usuario;
import com.intranet.inscripcion.bean.DatosReqInscripcionDTO;
import com.intranet.inscripcion.dao.InscripcionDAO_I;
import com.intranet.seguridad.dao.DAOFactory;

public class InscripcionService implements InscripcionService_I {
	DAOFactory factoria=DAOFactory.getDAOFactory(DAOFactory.IBATIS);
	InscripcionDAO_I inscripciondao=factoria.getInscripcionDAO();	
	
	@Override
	public List<Curso> buscarCursosAnt(Usuario usi) {
		// TODO Auto-generated method stub
		return inscripciondao.obtenerCursosAnteriores(usi);
	}

	@Override
	public List<Curso> buscarCursosAct(Usuario usi) {
		// TODO Auto-generated method stub
		return inscripciondao.obtenerCursosActuales(usi);
	}

	@Override
	public List<Curso> buscarCursosFut(Usuario usi) {
		// TODO Auto-generated method stub
		return inscripciondao.obtenerCursosFuturos(usi);
	}

	@Override
	public Curso buscarCursoBean(Curso cursi) {
		// TODO Auto-generated method stub
		return inscripciondao.obtenerCursoBean(cursi);
	}

	@Override
	public int buscarDAtosPreInscripcion(Usuario usi) {
		// TODO Auto-generated method stub
		return inscripciondao.obtenerDatosPreInscripcion(usi);
	}

	@Override
	public double buscarPromAntCiclo(Usuario usi) {
		// TODO Auto-generated method stub
		return inscripciondao.obtenerPromAntCiclo(usi);
	}

	@Override
	public List<Curso> buscarCursosAnt2(Usuario usi) {
		// TODO Auto-generated method stub
		return inscripciondao.obtenerCursosAnteriores2(usi);
	}

	@Override
	public List<Curso> buscarCursosAct2(Usuario usi) {
		// TODO Auto-generated method stub
		return inscripciondao.obtenerCursosActuales2(usi);
	}

}
