package com.intranet.nota.service;

import java.util.List;

import com.intranet.bean.Curso;
import com.intranet.bean.Inscripcion;
import com.intranet.bean.Usuario;
import com.intranet.nota.dao.CursoDAO_I;
import com.intranet.seguridad.dao.DAOFactory;

public class CursoService implements CursoService_I {

	DAOFactory factory=DAOFactory.getDAOFactory(DAOFactory.IBATIS);
	CursoDAO_I cursodao=factory.getCursoDAO();

	@Override
	public List<Curso> buscarCursos(Usuario usi) {
		return cursodao.obtenerCursos(usi);
	}

	@Override
	public int obtenerCantidadDeCursosDelSemestre(Inscripcion inscripcion) {
		return 0;
	}

}
