package com.intranet.bean;

public class Detalle_cursoCarrera {

	private int idCurso;
	private int idCarrera;
	private int idCiclo;
	public Detalle_cursoCarrera(int idCurso, int idCarrera, int idCiclo) {
		super();
		this.idCurso = idCurso;
		this.idCarrera = idCarrera;
		this.idCiclo = idCiclo;
	}
	
	public Detalle_cursoCarrera() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public int getIdCarrera() {
		return idCarrera;
	}
	public void setIdCarrera(int idCarrera) {
		this.idCarrera = idCarrera;
	}
	public int getIdCiclo() {
		return idCiclo;
	}
	public void setIdCiclo(int idCiclo) {
		this.idCiclo = idCiclo;
	}
	
	
	
}

