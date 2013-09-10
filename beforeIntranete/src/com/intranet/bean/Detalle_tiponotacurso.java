package com.intranet.bean;

public class Detalle_tiponotacurso {

	private int idDetalle_tiponotacurso;
	private double pesoNota;
	private int idTipoNota;
	private int idCurso;
	public Detalle_tiponotacurso(int idDetalle_tiponotacurso, double pesoNota,
			int idTipoNota, int idCurso) {
		super();
		this.idDetalle_tiponotacurso = idDetalle_tiponotacurso;
		this.pesoNota = pesoNota;
		this.idTipoNota = idTipoNota;
		this.idCurso = idCurso;
	}
	public Detalle_tiponotacurso() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdDetalle_tiponotacurso() {
		return idDetalle_tiponotacurso;
	}
	public void setIdDetalle_tiponotacurso(int idDetalle_tiponotacurso) {
		this.idDetalle_tiponotacurso = idDetalle_tiponotacurso;
	}
	public double getPesoNota() {
		return pesoNota;
	}
	public void setPesoNota(double pesoNota) {
		this.pesoNota = pesoNota;
	}
	public int getIdTipoNota() {
		return idTipoNota;
	}
	public void setIdTipoNota(int idTipoNota) {
		this.idTipoNota = idTipoNota;
	}
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	
	
	
}
