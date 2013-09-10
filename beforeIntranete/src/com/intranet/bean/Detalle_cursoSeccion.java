package com.intranet.bean;

public class Detalle_cursoSeccion {

	private int idCursoSeccion;
	private int idCurso;
	private int idSeccion;
	private int idProfesor;
	public Detalle_cursoSeccion(int idCursoSeccion, int idCurso, int idSeccion,
			int idProfesor) {
		super();
		this.idCursoSeccion = idCursoSeccion;
		this.idCurso = idCurso;
		this.idSeccion = idSeccion;
		this.idProfesor = idProfesor;
	}
	public Detalle_cursoSeccion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdCursoSeccion() {
		return idCursoSeccion;
	}
	public void setIdCursoSeccion(int idCursoSeccion) {
		this.idCursoSeccion = idCursoSeccion;
	}
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public int getIdSeccion() {
		return idSeccion;
	}
	public void setIdSeccion(int idSeccion) {
		this.idSeccion = idSeccion;
	}
	public int getIdProfesor() {
		return idProfesor;
	}
	public void setIdProfesor(int idProfesor) {
		this.idProfesor = idProfesor;
	}
	
	
}
