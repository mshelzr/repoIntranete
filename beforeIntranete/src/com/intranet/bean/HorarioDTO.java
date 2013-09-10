package com.intranet.bean;

// Generated 10-sep-2013 6:50:20 by Hibernate Tools 4.0.0

/**
 * HorarioDTO generated by hbm2java
 */
public class HorarioDTO implements java.io.Serializable {

	private int idHorario;
	private AulaDTO aulaDTO;
	private CursoCompuestoDTO cursoCompuestoDTO;
	private String descHorario;
	private String horaIniciio;
	private String horaFin;

	public HorarioDTO() {
	}

	public HorarioDTO(AulaDTO aulaDTO, CursoCompuestoDTO cursoCompuestoDTO) {
		this.aulaDTO = aulaDTO;
		this.cursoCompuestoDTO = cursoCompuestoDTO;
	}

	public HorarioDTO(AulaDTO aulaDTO, CursoCompuestoDTO cursoCompuestoDTO,
			String descHorario, String horaIniciio, String horaFin) {
		this.aulaDTO = aulaDTO;
		this.cursoCompuestoDTO = cursoCompuestoDTO;
		this.descHorario = descHorario;
		this.horaIniciio = horaIniciio;
		this.horaFin = horaFin;
	}

	public int getIdHorario() {
		return this.idHorario;
	}

	public void setIdHorario(int idHorario) {
		this.idHorario = idHorario;
	}

	public AulaDTO getAulaDTO() {
		return this.aulaDTO;
	}

	public void setAulaDTO(AulaDTO aulaDTO) {
		this.aulaDTO = aulaDTO;
	}

	public CursoCompuestoDTO getCursoCompuestoDTO() {
		return this.cursoCompuestoDTO;
	}

	public void setCursoCompuestoDTO(CursoCompuestoDTO cursoCompuestoDTO) {
		this.cursoCompuestoDTO = cursoCompuestoDTO;
	}

	public String getDescHorario() {
		return this.descHorario;
	}

	public void setDescHorario(String descHorario) {
		this.descHorario = descHorario;
	}

	public String getHoraIniciio() {
		return this.horaIniciio;
	}

	public void setHoraIniciio(String horaIniciio) {
		this.horaIniciio = horaIniciio;
	}

	public String getHoraFin() {
		return this.horaFin;
	}

	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

}