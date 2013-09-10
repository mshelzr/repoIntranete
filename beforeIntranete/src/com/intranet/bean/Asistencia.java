package com.intranet.bean;

public class Asistencia {

	private int idAsistencia;
	private String descAsistencia;
	private String fechaAsistencia;
	private int idInscripcion;
	private int idCursoSeccion;
	

	public Asistencia(int idAsistencia, String descAsistencia,
			String fechaAsistencia, int idInscripcion, int idCursoSeccion) {
		super();
		this.idAsistencia = idAsistencia;
		this.descAsistencia = descAsistencia;
		this.fechaAsistencia = fechaAsistencia;
		this.setIdInscripcion(idInscripcion);
		this.setIdCursoSeccion(idCursoSeccion);
	}

	public Asistencia(){
		
	}
	
	public int getIdAsistencia() {
		return idAsistencia;
	}
	public void setIdAsistencia(int idAsistencia) {
		this.idAsistencia = idAsistencia;
	}
	public String getFechaAsistencia() {
		return fechaAsistencia;
	}
	public void setFechaAsistencia(String fechaAsistencia) {
		this.fechaAsistencia = fechaAsistencia;
	}
	public String getDescAsistencia() {
		return descAsistencia;
	}
	public void setDescAsistencia(String descAsistencia) {
		this.descAsistencia = descAsistencia;
	}

	public int getIdInscripcion() {
		return idInscripcion;
	}

	public void setIdInscripcion(int idInscripcion) {
		this.idInscripcion = idInscripcion;
	}

	public int getIdCursoSeccion() {
		return idCursoSeccion;
	}

	public void setIdCursoSeccion(int idCursoSeccion) {
		this.idCursoSeccion = idCursoSeccion;
	}
	
	
	
}
