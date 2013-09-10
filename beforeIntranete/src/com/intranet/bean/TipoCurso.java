package com.intranet.bean;

public class TipoCurso {

	private int idTipoCurso;
	private String descTipoCurso;
	public TipoCurso(int idTipoCurso, String descTipoCurso) {
		super();
		this.idTipoCurso = idTipoCurso;
		this.descTipoCurso = descTipoCurso;
	}
	public int getIdTipoCurso() {
		return idTipoCurso;
	}
	public void setIdTipoCurso(int idTipoCurso) {
		this.idTipoCurso = idTipoCurso;
	}
	public String getDescTipoCurso() {
		return descTipoCurso;
	}
	public void setDescTipoCurso(String descTipoCurso) {
		this.descTipoCurso = descTipoCurso;
	}
	
	
	
}
