package com.intranet.bean;

public class Curso {

	private int idCurso;
	private String descCurso;
	private int creditos;
	private int idTipoCurso;

	public Curso(int idCurso, String descCurso, int creditos, int idTipoCurso) {
		super();
		this.idCurso = idCurso;
		this.descCurso = descCurso;
		this.creditos = creditos;
		this.idTipoCurso = idTipoCurso;
	}

	public Curso(){}
	
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public String getDescCurso() {
		return descCurso;
	}
	public void setDescCurso(String descCurso) {
		this.descCurso = descCurso;
	}
	public int getCreditos() {
		return creditos;
	}
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	public int getIdTipoCurso() {
		return idTipoCurso;
	}
	public void setIdTipoCurso(int idTipoCurso) {
		this.idTipoCurso = idTipoCurso;
	}
	
	
	
}
