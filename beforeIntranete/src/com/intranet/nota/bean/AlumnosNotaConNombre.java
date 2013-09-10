package com.intranet.nota.bean;

public class AlumnosNotaConNombre {

	private int idInscripcion;
	private String nomPersona;
	private double nota;
	public AlumnosNotaConNombre(int idInscripcion, String nomPersona,
			double nota) {
		super();
		this.idInscripcion = idInscripcion;
		this.nomPersona = nomPersona;
		this.nota = nota;
	}
	public AlumnosNotaConNombre() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdInscripcion() {
		return idInscripcion;
	}
	public void setIdInscripcion(int idInscripcion) {
		this.idInscripcion = idInscripcion;
	}
	public String getNomPersona() {
		return nomPersona;
	}
	public void setNomPersona(String nomPersona) {
		this.nomPersona = nomPersona;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	
	
}
