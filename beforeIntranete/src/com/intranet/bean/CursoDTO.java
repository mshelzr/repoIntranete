package com.intranet.bean;

// Generated 14-sep-2013 7:16:37 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

/**
 * CursoDTO generated by hbm2java
 */
public class CursoDTO implements java.io.Serializable {

	private int idCurso;
	private CategoriaCursoDTO categoriaCursoDTO;
	private String descCurso;
	private int creditos;
	private Set<CursoCompuestoDTO> cursoCompuestoDTOs = new HashSet<CursoCompuestoDTO>(
			0);
	private Set<PesoNotaDTO> pesoNotaDTOs = new HashSet<PesoNotaDTO>(0);
	private Set<DetalleCursoCarreraCicloDTO> detalleCursoCarreraCicloDTOs = new HashSet<DetalleCursoCarreraCicloDTO>(
			0);

	public CursoDTO() {
	}

	public CursoDTO(CategoriaCursoDTO categoriaCursoDTO) {
		this.categoriaCursoDTO = categoriaCursoDTO;
	}

	public CursoDTO(CategoriaCursoDTO categoriaCursoDTO, String descCurso,
			int creditos, Set<CursoCompuestoDTO> cursoCompuestoDTOs,
			Set<PesoNotaDTO> pesoNotaDTOs,
			Set<DetalleCursoCarreraCicloDTO> detalleCursoCarreraCicloDTOs) {
		this.categoriaCursoDTO = categoriaCursoDTO;
		this.descCurso = descCurso;
		this.creditos = creditos;
		this.cursoCompuestoDTOs = cursoCompuestoDTOs;
		this.pesoNotaDTOs = pesoNotaDTOs;
		this.detalleCursoCarreraCicloDTOs = detalleCursoCarreraCicloDTOs;
	}

	public int getIdCurso() {
		return this.idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public CategoriaCursoDTO getCategoriaCursoDTO() {
		return this.categoriaCursoDTO;
	}

	public void setCategoriaCursoDTO(CategoriaCursoDTO categoriaCursoDTO) {
		this.categoriaCursoDTO = categoriaCursoDTO;
	}

	public String getDescCurso() {
		return this.descCurso;
	}

	public void setDescCurso(String descCurso) {
		this.descCurso = descCurso;
	}

	public int getCreditos() {
		return this.creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public Set<CursoCompuestoDTO> getCursoCompuestoDTOs() {
		return this.cursoCompuestoDTOs;
	}

	public void setCursoCompuestoDTOs(Set<CursoCompuestoDTO> cursoCompuestoDTOs) {
		this.cursoCompuestoDTOs = cursoCompuestoDTOs;
	}

	public Set<PesoNotaDTO> getPesoNotaDTOs() {
		return this.pesoNotaDTOs;
	}

	public void setPesoNotaDTOs(Set<PesoNotaDTO> pesoNotaDTOs) {
		this.pesoNotaDTOs = pesoNotaDTOs;
	}

	public Set<DetalleCursoCarreraCicloDTO> getDetalleCursoCarreraCicloDTOs() {
		return this.detalleCursoCarreraCicloDTOs;
	}

	public void setDetalleCursoCarreraCicloDTOs(
			Set<DetalleCursoCarreraCicloDTO> detalleCursoCarreraCicloDTOs) {
		this.detalleCursoCarreraCicloDTOs = detalleCursoCarreraCicloDTOs;
	}

}
