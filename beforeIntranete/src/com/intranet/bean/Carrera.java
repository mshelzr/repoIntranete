package com.intranet.bean;

public class Carrera {

	private int idCarrera;
	private String descCarrera;
	
	public Carrera(int idCarrera, String descCarrera) {
		super();
		this.idCarrera = idCarrera;
		this.descCarrera = descCarrera;
	}

	public Carrera() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(int idCarrera) {
		this.idCarrera = idCarrera;
	}

	public String getDescCarrera() {
		return descCarrera;
	}

	public void setDescCarrera(String descCarrera) {
		this.descCarrera = descCarrera;
	}
	
	
	
	
}
