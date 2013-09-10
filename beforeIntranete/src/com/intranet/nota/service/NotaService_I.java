package com.intranet.nota.service;

import java.util.List;

import com.intranet.bean.Curso;
import com.intranet.bean.Detalle_cursoSeccion;
import com.intranet.bean.Detalle_tiponotacurso;
import com.intranet.bean.Inscripcion;
import com.intranet.bean.Nota;
import com.intranet.bean.Usuario;
import com.intranet.nota.bean.AlumnosNotaConNombre;
import com.intranet.nota.bean.NotaConNombre;
import com.intranet.nota.bean.NotaWithPorcentaje;

public interface NotaService_I {

	public List<NotaConNombre> buscarNotaDetalle(Usuario usi,Integer idCurso);
	
	public List<Detalle_tiponotacurso> buscarTiposDeNotas(Detalle_cursoSeccion dccurso);
	public List<AlumnosNotaConNombre> buscarAlumnosParaNota(Detalle_cursoSeccion dcs);
	public int sGenerarNota(Nota inota);
		
	public int sModificarNota(Nota inota);
	
	//secretaria
	public List<Inscripcion> buscarInscripcionesDelSemestre();
	public List<Detalle_cursoSeccion> buscarCursosDelAlumno(Inscripcion inscripcion);
	public List<NotaWithPorcentaje> buscarNotasDelCursoAlumno(Inscripcion inscripcion,Detalle_cursoSeccion curso);
	public int buscarCantidadDeCursosDelSemestre(Inscripcion inscripcion);

	public int rsIngresarPromedioDelCursoDelSemestre(Inscripcion inscri,Detalle_cursoSeccion dcs,String nota);
	public int rsIngresarPromedioGnralDelSemestre(Inscripcion inscri,String gnotal);
}
