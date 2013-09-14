package com.intranet.bean;

// Generated 14-sep-2013 7:16:37 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

/**
 * ProfesorDTO generated by hbm2java
 */
public class ProfesorDTO implements java.io.Serializable {

	private int idProfesor;
	private UsuarioDTO usuarioDTO;
	private PersonaDTO personaDTO;
	private String descProfesor;
	private Set<CursoCompuestoDTO> cursoCompuestoDTOs = new HashSet<CursoCompuestoDTO>(
			0);

	public ProfesorDTO() {
	}

	public ProfesorDTO(UsuarioDTO usuarioDTO, PersonaDTO personaDTO) {
		this.usuarioDTO = usuarioDTO;
		this.personaDTO = personaDTO;
	}

	public ProfesorDTO(UsuarioDTO usuarioDTO, PersonaDTO personaDTO,
			String descProfesor, Set<CursoCompuestoDTO> cursoCompuestoDTOs) {
		this.usuarioDTO = usuarioDTO;
		this.personaDTO = personaDTO;
		this.descProfesor = descProfesor;
		this.cursoCompuestoDTOs = cursoCompuestoDTOs;
	}

	public int getIdProfesor() {
		return this.idProfesor;
	}

	public void setIdProfesor(int idProfesor) {
		this.idProfesor = idProfesor;
	}

	public UsuarioDTO getUsuarioDTO() {
		return this.usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

	public PersonaDTO getPersonaDTO() {
		return this.personaDTO;
	}

	public void setPersonaDTO(PersonaDTO personaDTO) {
		this.personaDTO = personaDTO;
	}

	public String getDescProfesor() {
		return this.descProfesor;
	}

	public void setDescProfesor(String descProfesor) {
		this.descProfesor = descProfesor;
	}

	public Set<CursoCompuestoDTO> getCursoCompuestoDTOs() {
		return this.cursoCompuestoDTOs;
	}

	public void setCursoCompuestoDTOs(Set<CursoCompuestoDTO> cursoCompuestoDTOs) {
		this.cursoCompuestoDTOs = cursoCompuestoDTOs;
	}

}
