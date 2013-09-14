package com.intranet.bean;

// Generated 14-sep-2013 7:16:37 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

/**
 * InscripcionAlumnoDTO generated by hbm2java
 */
public class InscripcionAlumnoDTO implements java.io.Serializable {

	private int idInscripcionAlumno;
	private CicloDTO cicloDTO;
	private AlumnoDTO alumnoDTO;
	private InscripcionDTO inscripcionDTO;
	private String fecInscrito;
	private double promedioGenral;
	private int aprobado;
	private Set<NotaDTO> notaDTOs = new HashSet<NotaDTO>(0);
	private Set<DetalleInscriCursoDTO> detalleInscriCursoDTOs = new HashSet<DetalleInscriCursoDTO>(
			0);

	public InscripcionAlumnoDTO() {
	}

	public InscripcionAlumnoDTO(CicloDTO cicloDTO, AlumnoDTO alumnoDTO,
			InscripcionDTO inscripcionDTO) {
		this.cicloDTO = cicloDTO;
		this.alumnoDTO = alumnoDTO;
		this.inscripcionDTO = inscripcionDTO;
	}

	public InscripcionAlumnoDTO(CicloDTO cicloDTO, AlumnoDTO alumnoDTO,
			InscripcionDTO inscripcionDTO, String fecInscrito,
			double promedioGenral, int aprobado, Set<NotaDTO> notaDTOs,
			Set<DetalleInscriCursoDTO> detalleInscriCursoDTOs) {
		this.cicloDTO = cicloDTO;
		this.alumnoDTO = alumnoDTO;
		this.inscripcionDTO = inscripcionDTO;
		this.fecInscrito = fecInscrito;
		this.promedioGenral = promedioGenral;
		this.aprobado = aprobado;
		this.notaDTOs = notaDTOs;
		this.detalleInscriCursoDTOs = detalleInscriCursoDTOs;
	}

	public int getIdInscripcionAlumno() {
		return this.idInscripcionAlumno;
	}

	public void setIdInscripcionAlumno(int idInscripcionAlumno) {
		this.idInscripcionAlumno = idInscripcionAlumno;
	}

	public CicloDTO getCicloDTO() {
		return this.cicloDTO;
	}

	public void setCicloDTO(CicloDTO cicloDTO) {
		this.cicloDTO = cicloDTO;
	}

	public AlumnoDTO getAlumnoDTO() {
		return this.alumnoDTO;
	}

	public void setAlumnoDTO(AlumnoDTO alumnoDTO) {
		this.alumnoDTO = alumnoDTO;
	}

	public InscripcionDTO getInscripcionDTO() {
		return this.inscripcionDTO;
	}

	public void setInscripcionDTO(InscripcionDTO inscripcionDTO) {
		this.inscripcionDTO = inscripcionDTO;
	}

	public String getFecInscrito() {
		return this.fecInscrito;
	}

	public void setFecInscrito(String fecInscrito) {
		this.fecInscrito = fecInscrito;
	}

	public double getPromedioGenral() {
		return this.promedioGenral;
	}

	public void setPromedioGenral(double promedioGenral) {
		this.promedioGenral = promedioGenral;
	}

	public int getAprobado() {
		return this.aprobado;
	}

	public void setAprobado(int aprobado) {
		this.aprobado = aprobado;
	}

	public Set<NotaDTO> getNotaDTOs() {
		return this.notaDTOs;
	}

	public void setNotaDTOs(Set<NotaDTO> notaDTOs) {
		this.notaDTOs = notaDTOs;
	}

	public Set<DetalleInscriCursoDTO> getDetalleInscriCursoDTOs() {
		return this.detalleInscriCursoDTOs;
	}

	public void setDetalleInscriCursoDTOs(
			Set<DetalleInscriCursoDTO> detalleInscriCursoDTOs) {
		this.detalleInscriCursoDTOs = detalleInscriCursoDTOs;
	}

}
