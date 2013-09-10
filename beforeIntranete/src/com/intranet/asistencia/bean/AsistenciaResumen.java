package com.intranet.asistencia.bean;

public class AsistenciaResumen {

	private int idCursoSeccion;
	private String descCurso;
	private int cantAsistencias;
	
	public AsistenciaResumen(int idCurso, String descCurso, int cantAsistencias) {
		super();
		this.idCursoSeccion=idCurso;
		this.descCurso = descCurso;
		this.cantAsistencias = cantAsistencias;
	}

	public AsistenciaResumen(){
	}
	
	public int getIdCursoSeccion() {
		return idCursoSeccion;
	}
	public void setIdCursoSeccion(int idCurso) {
		this.idCursoSeccion = idCurso;
	}
	public String getDescCurso() {
		return descCurso;
	}
	public void setDescCurso(String descCurso) {
		this.descCurso = descCurso;
	}
	public int getCantAsistencias() {
		return cantAsistencias;
	}
	public void setCantAsistencias(int cantAsistencias) {
		this.cantAsistencias = cantAsistencias;
	}
	
	
	
}
