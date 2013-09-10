package com.intranet.bean;

public class Ciclo {

	private int idCiclo;
	private String creditos_dispon;
	
	public Ciclo(int idCiclo, String creditos_dispon) {
		super();
		this.idCiclo = idCiclo;
		this.creditos_dispon = creditos_dispon;
	}
	
	public Ciclo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdCiclo() {
		return idCiclo;
	}
	public void setIdCiclo(int idCiclo) {
		this.idCiclo = idCiclo;
	}
	public String getCreditos_dispon() {
		return creditos_dispon;
	}
	public void setCreditos_dispon(String creditos_dispon) {
		this.creditos_dispon = creditos_dispon;
	}
	
	
}

