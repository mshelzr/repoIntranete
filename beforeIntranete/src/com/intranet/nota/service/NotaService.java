package com.intranet.nota.service;

import java.util.List;

import com.intranet.bean.Curso;
import com.intranet.bean.Detalle_cursoSeccion;
import com.intranet.bean.Detalle_tiponotacurso;
import com.intranet.bean.Inscripcion;
import com.intranet.bean.Nota;
import com.intranet.bean.Usuario;
import com.intranet.inscripcion.dao.InscripcionDAO_I;
import com.intranet.nota.bean.AlumnosNotaConNombre;
import com.intranet.nota.bean.NotaConNombre;
import com.intranet.nota.bean.NotaWithPorcentaje;
import com.intranet.nota.dao.CursoDAO_I;
import com.intranet.nota.dao.NotaDAO_I;
import com.intranet.seguridad.dao.DAOFactory;

public class NotaService implements NotaService_I {

	DAOFactory factory=DAOFactory.getDAOFactory(DAOFactory.IBATIS);
	NotaDAO_I notadao=factory.getNotaDAO();
	InscripcionDAO_I inscripcionDAO=factory.getInscripcionDAO();
	CursoDAO_I cursoDAO=factory.getCursoDAO();
	
	@Override
	public List<NotaConNombre> buscarNotaDetalle(Usuario usi, Integer idCurso) {
		return notadao.obtenerNotasDetalladas(usi, idCurso);
	}

	@Override
	public List<Detalle_tiponotacurso> buscarTiposDeNotas(Detalle_cursoSeccion dccurso) {
		return notadao.obtenerTiposDeNotas(dccurso);
	}

	@Override
	public List<AlumnosNotaConNombre> buscarAlumnosParaNota(
			Detalle_cursoSeccion dcs) {
		return notadao.obtenerAlumnosParaNota(dcs);
	}

	@Override
	public int sGenerarNota(Nota inota) {
		return notadao.sdaoGenerarNota(inota);
	}

	@Override
	public int sModificarNota(Nota inota) {
		return notadao.sdaoModificarNota(inota);
	}

	//sesion de secretaria
	@Override
	public List<Inscripcion> buscarInscripcionesDelSemestre() {
		return inscripcionDAO.obtenerInscripcionesDelSemestre();
	}

	@Override
	public List<Detalle_cursoSeccion> buscarCursosDelAlumno(Inscripcion inscripcion) {
		return cursoDAO.obtenerCursosDelAlumno(inscripcion);
	}

	@Override
	public List<NotaWithPorcentaje> buscarNotasDelCursoAlumno(Inscripcion inscripcion,Detalle_cursoSeccion curso) {
		return notadao.obtenerNotasDelCursoAlumno(inscripcion,curso);
	}

	@Override
	public int buscarCantidadDeCursosDelSemestre(Inscripcion inscripcion) {
		return cursoDAO.obtenerCantidadDeCursosDelSemestre(inscripcion);
	}

	@Override
	public int rsIngresarPromedioDelCursoDelSemestre(Inscripcion inscri,Detalle_cursoSeccion dcs,String nota) {
		return notadao.rdIngresarPromedioDelCursoDelSemestre(inscri,dcs,nota);
	}

	@Override
	public int rsIngresarPromedioGnralDelSemestre(Inscripcion inscri,String gnotal) {
		return notadao.rdIngresarPromedioGnralDelSemestre(inscri,gnotal);
	}

}
