package com.intranet.asistencia.bean;

public class CursoSeccionConNombre {

	private int IdCursoSeccion;
	private String descSeccion;
	private String descCurso;
	
	public CursoSeccionConNombre(int idCursoSeccion, String descSeccion,
			String descCurso) {
		super();
		IdCursoSeccion = idCursoSeccion;
		this.descSeccion = descSeccion;
		this.descCurso = descCurso;
	}
	public CursoSeccionConNombre() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdCursoSeccion() {
		return IdCursoSeccion;
	}
	public void setIdCursoSeccion(int idCursoSeccion) {
		IdCursoSeccion = idCursoSeccion;
	}
	public String getDescSeccion() {
		return descSeccion;
	}
	public void setDescSeccion(String descSeccion) {
		this.descSeccion = descSeccion;
	}
	public String getDescCurso() {
		return descCurso;
	}
	public void setDescCurso(String descCurso) {
		this.descCurso = descCurso;
	}
	
	
}
