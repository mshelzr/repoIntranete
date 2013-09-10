package com.intranet.asistencia.service;

import java.util.List;

import com.intranet.asistencia.bean.AlumnoPropAsistencia;
import com.intranet.asistencia.bean.AsistenciaResumen;
import com.intranet.asistencia.bean.CursoSeccionConNombre;
import com.intranet.asistencia.dao.AsistenciaDAO_I;
import com.intranet.bean.Asistencia;
import com.intranet.bean.Detalle_cursoSeccion;
import com.intranet.bean.Usuario;
import com.intranet.seguridad.dao.DAOFactory;

public class AsistenciaService implements AsistenciaService_I{
	DAOFactory factory=DAOFactory.getDAOFactory(DAOFactory.IBATIS);
	AsistenciaDAO_I asisDAO=factory.getAsistenciaDAO();
	
	@Override
	public List<AsistenciaResumen> listarCursosResumenido(Usuario user) {
		return asisDAO.listaCursosResumen(user);
	}

	@Override
	public List<Asistencia> listarAsistenciaDetallada(Usuario usi,
			String idCurso) {
		return asisDAO.obtenerAsistenciasDetalladas(usi, idCurso);
	}

	@Override
	public List<CursoSeccionConNombre> listarSeccionesXprofesor(Usuario usi) {
		return asisDAO.obtenerSeccionXProfesor(usi);
	}

	@Override
	public List<AlumnoPropAsistencia> listarAlumnosDeSeccion(Detalle_cursoSeccion secc) {
		return asisDAO.obtenerAlumnowpAsistencia(secc);
	}

	@Override
	public int sRegistrarAsistencia(Asistencia asist) {
		return asisDAO.resultadoRegistroAsistencia(asist);
	}

	@Override
	public List<String> listarFechasParamAsistenciaXProfesor(
			Detalle_cursoSeccion dcs) {
		return asisDAO.obtenerFechaSeccionXProfesor(dcs);
	}

	@Override
	public List<AlumnoPropAsistencia> listaAlumnosParamXProfesor(String fecha,
			Detalle_cursoSeccion dcs) {
		return asisDAO.obtenerAlumnosConParametros(fecha, dcs);
	}

	@Override
	public int sModificarAsistencia(Asistencia asist) {
		return asisDAO.resultadoModifcarAsistencia(asist);
	}



}
