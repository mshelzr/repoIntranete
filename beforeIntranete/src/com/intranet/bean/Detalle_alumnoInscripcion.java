package com.intranet.bean;

public class Detalle_alumnoInscripcion {

	private int idAlumno;
	private int idInscripcion;
	public Detalle_alumnoInscripcion(int idAlumno, int idInscripcion) {
		super();
		this.idAlumno = idAlumno;
		this.idInscripcion = idInscripcion;
	}
	
	public Detalle_alumnoInscripcion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}
	public int getIdInscripcion() {
		return idInscripcion;
	}
	public void setIdInscripcion(int idInscripcion) {
		this.idInscripcion = idInscripcion;
	}
	
	
}
