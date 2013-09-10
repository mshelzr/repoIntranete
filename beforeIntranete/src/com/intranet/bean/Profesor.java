package com.intranet.bean;

public class Profesor {

	private int idProfesor;
	private String descProfesor;
	private int idPersona;
	private int idUsuario;
	public Profesor(int idProfesor, String descProfesor, int idPersona,
			int idUsuario) {
		super();
		this.idProfesor = idProfesor;
		this.descProfesor = descProfesor;
		this.idPersona = idPersona;
		this.idUsuario = idUsuario;
	}
	public Profesor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdProfesor() {
		return idProfesor;
	}
	public void setIdProfesor(int idProfesor) {
		this.idProfesor = idProfesor;
	}
	public String getDescProfesor() {
		return descProfesor;
	}
	public void setDescProfesor(String descProfesor) {
		this.descProfesor = descProfesor;
	}
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
	
}
