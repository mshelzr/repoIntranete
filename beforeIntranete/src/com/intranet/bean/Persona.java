package com.intranet.bean;

public class Persona {

	private int idPersona;
	private String nomPersona;
	private String apePersona;
	private int dniPersona;
	private int telfPersona;
	private String direcPersona;
	private String foto;
	
	public Persona(int idPersona, String nomPersona, String apePersona,
			int dniPersona, int telfPersona, String direcPersona, String foto) {
		super();
		this.idPersona = idPersona;
		this.nomPersona = nomPersona;
		this.apePersona = apePersona;
		this.dniPersona = dniPersona;
		this.telfPersona = telfPersona;
		this.direcPersona = direcPersona;
		this.foto = foto;
	}
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public String getNomPersona() {
		return nomPersona;
	}
	public void setNomPersona(String nomPersona) {
		this.nomPersona = nomPersona;
	}
	public String getApePersona() {
		return apePersona;
	}
	public void setApePersona(String apePersona) {
		this.apePersona = apePersona;
	}
	public int getDniPersona() {
		return dniPersona;
	}
	public void setDniPersona(int dniPersona) {
		this.dniPersona = dniPersona;
	}
	public int getTelfPersona() {
		return telfPersona;
	}
	public void setTelfPersona(int telfPersona) {
		this.telfPersona = telfPersona;
	}
	public String getDirecPersona() {
		return direcPersona;
	}
	public void setDirecPersona(String direcPersona) {
		this.direcPersona = direcPersona;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
}
