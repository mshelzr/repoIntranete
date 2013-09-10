package com.intranet.bean;

public class Inscripcion {

	private int idInscripcion;
	private String fec_Inscrito;
	private double promedio_genral;
	private int idPeriodo;
	private int idCiclo;
	public Inscripcion(int idInscripcion, String fec_Inscrito,
			double promedio_genral, int idPeriodo, int idCiclo) {
		super();
		this.idInscripcion = idInscripcion;
		this.fec_Inscrito = fec_Inscrito;
		this.promedio_genral = promedio_genral;
		this.idPeriodo = idPeriodo;
		this.idCiclo = idCiclo;
	}
	public Inscripcion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdInscripcion() {
		return idInscripcion;
	}
	public void setIdInscripcion(int idInscripcion) {
		this.idInscripcion = idInscripcion;
	}
	public String getFec_Inscrito() {
		return fec_Inscrito;
	}
	public void setFec_Inscrito(String fec_Inscrito) {
		this.fec_Inscrito = fec_Inscrito;
	}
	public double getPromedio_genral() {
		return promedio_genral;
	}
	public void setPromedio_genral(double promedio_genral) {
		this.promedio_genral = promedio_genral;
	}
	public int getIdPeriodo() {
		return idPeriodo;
	}
	public void setIdPeriodo(int idPeriodo) {
		this.idPeriodo = idPeriodo;
	}
	public int getIdCiclo() {
		return idCiclo;
	}
	public void setIdCiclo(int idCiclo) {
		this.idCiclo = idCiclo;
	}
		
	
}
