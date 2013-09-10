package com.intranet.asistencia.service;

import java.util.List;

import com.intranet.asistencia.bean.AlumnoPropAsistencia;
import com.intranet.asistencia.bean.AsistenciaResumen;
import com.intranet.asistencia.bean.CursoSeccionConNombre;
import com.intranet.bean.Asistencia;
import com.intranet.bean.Detalle_cursoSeccion;
import com.intranet.bean.Usuario;

public interface AsistenciaService_I {

	public List<AsistenciaResumen> listarCursosResumenido(Usuario user);
	public List<Asistencia> listarAsistenciaDetallada(Usuario usi, String idCurso);
	//profe
	public List<CursoSeccionConNombre> listarSeccionesXprofesor(Usuario usi);
	public List<AlumnoPropAsistencia> listarAlumnosDeSeccion(Detalle_cursoSeccion secc);
	public int sRegistrarAsistencia(Asistencia asist);
	public List<String> listarFechasParamAsistenciaXProfesor(Detalle_cursoSeccion dcs);
	public List<AlumnoPropAsistencia> listaAlumnosParamXProfesor(String fecha,Detalle_cursoSeccion dcs);
	public int sModificarAsistencia(Asistencia asist);
}
