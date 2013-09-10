package com.intranet.nota.bean;

public class NotaConNombre {

	private String desctiponota;
	private double nota;
	private String fecpublicado_nota;

	public NotaConNombre(String desctiponota, double nota,
			String fecpublicado_nota) {
		super();
		this.desctiponota = desctiponota;
		this.nota = nota;
		this.fecpublicado_nota = fecpublicado_nota;
	}

	public NotaConNombre(){
		
	}
	
	public String getDesctiponota() {
		return desctiponota;
	}
	public void setDesctiponota(String desctiponota) {
		this.desctiponota = desctiponota;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	public String getFecpublicado_nota() {
		return fecpublicado_nota;
	}
	public void setFecpublicado_nota(String fecpublicado_nota) {
		this.fecpublicado_nota = fecpublicado_nota;
	}
	
	
}
