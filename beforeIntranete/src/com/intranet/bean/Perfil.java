package com.intranet.bean;

public class Perfil {

	private int idPerfil;
	private String descPerfil;
	
	public Perfil(int idPerfil, String descPerfil) {
		super();
		this.idPerfil = idPerfil;
		this.descPerfil = descPerfil;
	}
	public Perfil() {
		// TODO Auto-generated constructor stub
	}
	public int getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}
	public String getDescPerfil() {
		return descPerfil;
	}
	public void setDescPerfil(String descPerfil) {
		this.descPerfil = descPerfil;
	}
	
	
	
}
