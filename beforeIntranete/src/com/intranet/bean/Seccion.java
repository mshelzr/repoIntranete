package com.intranet.bean;

public class Seccion {

	private int idSeccion;
	private String descSeccion;
	public Seccion(int idSeccion, String descSeccion) {
		super();
		this.idSeccion = idSeccion;
		this.descSeccion = descSeccion;
	}
	
	public Seccion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdSeccion() {
		return idSeccion;
	}
	public void setIdSeccion(int idSeccion) {
		this.idSeccion = idSeccion;
	}
	public String getDescSeccion() {
		return descSeccion;
	}
	public void setDescSeccion(String descSeccion) {
		this.descSeccion = descSeccion;
	}
	
	
	
}
