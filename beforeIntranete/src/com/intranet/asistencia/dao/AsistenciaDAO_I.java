package com.intranet.asistencia.dao;

import java.util.List;

import com.intranet.asistencia.bean.AlumnoPropAsistencia;
import com.intranet.asistencia.bean.AsistenciaResumen;
import com.intranet.asistencia.bean.CursoSeccionConNombre;
import com.intranet.bean.Asistencia;
import com.intranet.bean.Detalle_cursoSeccion;
import com.intranet.bean.Inscripcion;
import com.intranet.bean.Usuario;

public interface AsistenciaDAO_I {

	public List<AsistenciaResumen> listaCursosResumen(Usuario usi);
	public List<Asistencia> obtenerAsistenciasDetalladas(Usuario usi,String idCurso);
	public List<CursoSeccionConNombre> obtenerSeccionXProfesor(Usuario usi);
	public List<AlumnoPropAsistencia> obtenerAlumnowpAsistencia(Detalle_cursoSeccion inscri);
	public int resultadoRegistroAsistencia(Asistencia asist);
	
	public List<String> obtenerFechaSeccionXProfesor(Detalle_cursoSeccion dcs);
	public List<AlumnoPropAsistencia> obtenerAlumnosConParametros(String fecha,Detalle_cursoSeccion dcs);
	public int resultadoModifcarAsistencia(Asistencia asist);
	
}
