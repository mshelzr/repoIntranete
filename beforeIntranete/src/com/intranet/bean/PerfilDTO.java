package com.intranet.bean;

// Generated 10-sep-2013 6:50:20 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

/**
 * PerfilDTO generated by hbm2java
 */
public class PerfilDTO implements java.io.Serializable {

	private int idPerfil;
	private String descPerfil;
	private Set<UsuarioDTO> usuarioDTOs = new HashSet<UsuarioDTO>(0);

	public PerfilDTO() {
	}

	public PerfilDTO(String descPerfil, Set<UsuarioDTO> usuarioDTOs) {
		this.descPerfil = descPerfil;
		this.usuarioDTOs = usuarioDTOs;
	}

	public int getIdPerfil() {
		return this.idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getDescPerfil() {
		return this.descPerfil;
	}

	public void setDescPerfil(String descPerfil) {
		this.descPerfil = descPerfil;
	}

	public Set<UsuarioDTO> getUsuarioDTOs() {
		return this.usuarioDTOs;
	}

	public void setUsuarioDTOs(Set<UsuarioDTO> usuarioDTOs) {
		this.usuarioDTOs = usuarioDTOs;
	}

}