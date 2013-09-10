package com.intranet.bean;

public class Periodo {

	private int idPeriodo;
	private String descPeriodo;
	public Periodo(int idPeriodo, String descPeriodo) {
		super();
		this.idPeriodo = idPeriodo;
		this.descPeriodo = descPeriodo;
	}
	public int getIdPeriodo() {
		return idPeriodo;
	}
	public void setIdPeriodo(int idPeriodo) {
		this.idPeriodo = idPeriodo;
	}
	public String getDescPeriodo() {
		return descPeriodo;
	}
	public void setDescPeriodo(String descPeriodo) {
		this.descPeriodo = descPeriodo;
	}
	
}
