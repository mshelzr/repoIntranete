package com.intranet.bean;

// Generated 14-sep-2013 7:16:37 by Hibernate Tools 4.0.0

/**
 * AsistenciaDTO generated by hbm2java
 */
public class AsistenciaDTO implements java.io.Serializable {

	private int idAsistencia;
	private CursoCompuestoDTO cursoCompuestoDTO;
	private PeriodoDTO periodoDTO;
	private int cantclases;
	private String fechaAsistencia;

	public AsistenciaDTO() {
	}

	public AsistenciaDTO(CursoCompuestoDTO cursoCompuestoDTO,
			PeriodoDTO periodoDTO) {
		this.cursoCompuestoDTO = cursoCompuestoDTO;
		this.periodoDTO = periodoDTO;
	}

	public AsistenciaDTO(CursoCompuestoDTO cursoCompuestoDTO,
			PeriodoDTO periodoDTO, int cantclases, String fechaAsistencia) {
		this.cursoCompuestoDTO = cursoCompuestoDTO;
		this.periodoDTO = periodoDTO;
		this.cantclases = cantclases;
		this.fechaAsistencia = fechaAsistencia;
	}

	public int getIdAsistencia() {
		return this.idAsistencia;
	}

	public void setIdAsistencia(int idAsistencia) {
		this.idAsistencia = idAsistencia;
	}

	public CursoCompuestoDTO getCursoCompuestoDTO() {
		return this.cursoCompuestoDTO;
	}

	public void setCursoCompuestoDTO(CursoCompuestoDTO cursoCompuestoDTO) {
		this.cursoCompuestoDTO = cursoCompuestoDTO;
	}

	public PeriodoDTO getPeriodoDTO() {
		return this.periodoDTO;
	}

	public void setPeriodoDTO(PeriodoDTO periodoDTO) {
		this.periodoDTO = periodoDTO;
	}

	public int getCantclases() {
		return this.cantclases;
	}

	public void setCantclases(int cantclases) {
		this.cantclases = cantclases;
	}

	public String getFechaAsistencia() {
		return this.fechaAsistencia;
	}

	public void setFechaAsistencia(String fechaAsistencia) {
		this.fechaAsistencia = fechaAsistencia;
	}

}
