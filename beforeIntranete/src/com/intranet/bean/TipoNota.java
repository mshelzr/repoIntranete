package com.intranet.bean;

public class TipoNota {

	private int idTipoNota;
	private String descTipoNota;
	public TipoNota(int idTipoNota, String descTipoNota) {
		super();
		this.idTipoNota = idTipoNota;
		this.descTipoNota = descTipoNota;
	}
	public TipoNota() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdTipoNota() {
		return idTipoNota;
	}
	public void setIdTipoNota(int idTipoNota) {
		this.idTipoNota = idTipoNota;
	}
	public String getDescTipoNota() {
		return descTipoNota;
	}
	public void setDescTipoNota(String descTipoNota) {
		this.descTipoNota = descTipoNota;
	}
	
	
	
}
