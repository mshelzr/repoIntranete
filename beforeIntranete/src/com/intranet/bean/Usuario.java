package com.intranet.bean;

public class Usuario {

	private int idUsuario;
	private String user;
	private String password;
	private int idPerfil;
	
	public Usuario(int idUsuario, String user, String password,
			int idPerfil) {
		super();
		this.idUsuario = idUsuario;
		this.user = user;
		this.password = password;
		this.idPerfil = idPerfil;
	}
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}
	
}
