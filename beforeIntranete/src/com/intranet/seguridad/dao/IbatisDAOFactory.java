package com.intranet.seguridad.dao;

import com.intranet.asistencia.dao.AsistenciaDAO;
import com.intranet.asistencia.dao.AsistenciaDAO_I;
import com.intranet.horario.dao.HorarioDAO;
import com.intranet.horario.dao.HorarioDAO_I;
import com.intranet.inscripcion.dao.InscripcionDAO;
import com.intranet.inscripcion.dao.InscripcionDAO_I;
import com.intranet.nota.dao.CursoDAO;
import com.intranet.nota.dao.CursoDAO_I;
import com.intranet.nota.dao.NotaDAO;
import com.intranet.nota.dao.NotaDAO_I;

public class IbatisDAOFactory extends DAOFactory{

	@Override
	public PerfilDAO_I getPerfilDAO() {
		return new PerfilDAO();
	}
	@Override
	public UsuarioDAO_I getUsuarioDAO() {
		return new UsuarioDAO();
	}
	@Override
	public AsistenciaDAO_I getAsistenciaDAO() {
		return new AsistenciaDAO();
	}
	@Override
	public NotaDAO_I getNotaDAO() {
		return new NotaDAO();
	}
	@Override
	public CursoDAO_I getCursoDAO() {
		return new CursoDAO();
	}
	@Override
	public HorarioDAO_I getHorarioDAO() {
		
		return new HorarioDAO();
	}
	@Override
	public InscripcionDAO_I getInscripcionDAO() {
		return new InscripcionDAO();
	}

}
