package com.intranet.nota.dao;

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

public interface NotaDAO_I {

	//lado del alumno
	public List<NotaConNombre> obtenerNotasDetalladas(Usuario usi,int idCurso);
	
	//lado del profesor: agregar
	public List<Detalle_tiponotacurso> obtenerTiposDeNotas(Detalle_cursoSeccion dccurso);
	public List<AlumnosNotaConNombre> obtenerAlumnosParaNota(Detalle_cursoSeccion dcs);
	public int sdaoGenerarNota(Nota inota);
		
	//lado del profesor: agregar
	public int sdaoModificarNota(Nota inota);
	
	//s# de secretaria:
	public List<NotaWithPorcentaje> obtenerNotasDelCursoAlumno(Inscripcion inscripcion,Detalle_cursoSeccion curso);
	public int rdIngresarPromedioDelCursoDelSemestre(Inscripcion inscri,Detalle_cursoSeccion dcs,String nota);
	public int rdIngresarPromedioGnralDelSemestre(Inscripcion inscri,String gnotal);

}
