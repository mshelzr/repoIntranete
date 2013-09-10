package com.intranet.bean;

public class Detalle_inscriCurso {

	private int idInscripcion;
	private double promedio_c;
	private int idCursoSeccion;
	public Detalle_inscriCurso(int idInscripcion, double promedio_c,
			int idCursoSeccion) {
		super();
		this.idInscripcion = idInscripcion;
		this.promedio_c = promedio_c;
		this.idCursoSeccion = idCursoSeccion;
	}
	public Detalle_inscriCurso() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdInscripcion() {
		return idInscripcion;
	}
	public void setIdInscripcion(int idInscripcion) {
		this.idInscripcion = idInscripcion;
	}
	public double getPromedio_c() {
		return promedio_c;
	}
	public void setPromedio_c(double promedio_c) {
		this.promedio_c = promedio_c;
	}
	public int getIdCursoSeccion() {
		return idCursoSeccion;
	}
	public void setIdCursoSeccion(int idCursoSeccion) {
		this.idCursoSeccion = idCursoSeccion;
	}
	
	
}
