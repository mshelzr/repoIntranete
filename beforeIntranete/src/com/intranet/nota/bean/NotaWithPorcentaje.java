package com.intranet.nota.bean;

public class NotaWithPorcentaje {

	private int vnota;
	private double pesoNota;
	
	public NotaWithPorcentaje() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NotaWithPorcentaje(int vnota, double pesoNota) {
		super();
		this.vnota = vnota;
		this.pesoNota = pesoNota;
	}
	public int getVnota() {
		return vnota;
	}
	public void setVnota(int vnota) {
		this.vnota = vnota;
	}
	public double getPesoNota() {
		return pesoNota;
	}
	public void setPesoNota(double pesoNota) {
		this.pesoNota = pesoNota;
	}
	
	
}
