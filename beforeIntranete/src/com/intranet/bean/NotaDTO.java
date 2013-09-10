package com.intranet.bean;

// Generated 10-sep-2013 6:50:20 by Hibernate Tools 4.0.0

/**
 * NotaDTO generated by hbm2java
 */
public class NotaDTO implements java.io.Serializable {

	private int idNota;
	private CursoCompuestoDTO cursoCompuestoDTO;
	private InscripcionDTO inscripcionDTO;
	private PesoNotaDTO pesoNotaDTO;
	private double nota;
	private String fecPublicadoNota;

	public NotaDTO() {
	}

	public NotaDTO(CursoCompuestoDTO cursoCompuestoDTO,
			InscripcionDTO inscripcionDTO, PesoNotaDTO pesoNotaDTO) {
		this.cursoCompuestoDTO = cursoCompuestoDTO;
		this.inscripcionDTO = inscripcionDTO;
		this.pesoNotaDTO = pesoNotaDTO;
	}

	public NotaDTO(CursoCompuestoDTO cursoCompuestoDTO,
			InscripcionDTO inscripcionDTO, PesoNotaDTO pesoNotaDTO,
			double nota, String fecPublicadoNota) {
		this.cursoCompuestoDTO = cursoCompuestoDTO;
		this.inscripcionDTO = inscripcionDTO;
		this.pesoNotaDTO = pesoNotaDTO;
		this.nota = nota;
		this.fecPublicadoNota = fecPublicadoNota;
	}

	public int getIdNota() {
		return this.idNota;
	}

	public void setIdNota(int idNota) {
		this.idNota = idNota;
	}

	public CursoCompuestoDTO getCursoCompuestoDTO() {
		return this.cursoCompuestoDTO;
	}

	public void setCursoCompuestoDTO(CursoCompuestoDTO cursoCompuestoDTO) {
		this.cursoCompuestoDTO = cursoCompuestoDTO;
	}

	public InscripcionDTO getInscripcionDTO() {
		return this.inscripcionDTO;
	}

	public void setInscripcionDTO(InscripcionDTO inscripcionDTO) {
		this.inscripcionDTO = inscripcionDTO;
	}

	public PesoNotaDTO getPesoNotaDTO() {
		return this.pesoNotaDTO;
	}

	public void setPesoNotaDTO(PesoNotaDTO pesoNotaDTO) {
		this.pesoNotaDTO = pesoNotaDTO;
	}

	public double getNota() {
		return this.nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public String getFecPublicadoNota() {
		return this.fecPublicadoNota;
	}

	public void setFecPublicadoNota(String fecPublicadoNota) {
		this.fecPublicadoNota = fecPublicadoNota;
	}

}
