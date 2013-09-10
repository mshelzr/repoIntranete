package com.intranet.bean;

public class Nota {

	private int idNota;
	private double vnota;
	private String fecPublicado_Nota;
	private int idDetalle_tiponotacurso;
	private int idInscripcion;
	private int idCursoSeccion;
	
	public Nota(int idNota, double vnota, String fecPublicado_Nota,
			int idDetalle_tiponotacurso, int idInscripcion, int idCursoSeccion) {
		super();
		this.idNota = idNota;
		this.vnota = vnota;
		this.fecPublicado_Nota = fecPublicado_Nota;
		this.idDetalle_tiponotacurso = idDetalle_tiponotacurso;
		this.idInscripcion = idInscripcion;
		this.idCursoSeccion = idCursoSeccion;
	}

	public Nota() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdNota() {
		return idNota;
	}

	public void setIdNota(int idNota) {
		this.idNota = idNota;
	}

	public double getVnota() {
		return vnota;
	}

	public void setVnota(double vnota) {
		this.vnota = vnota;
	}

	public String getFecPublicado_Nota() {
		return fecPublicado_Nota;
	}

	public void setFecPublicado_Nota(String fecPublicado_Nota) {
		this.fecPublicado_Nota = fecPublicado_Nota;
	}

	public int getIdDetalle_tiponotacurso() {
		return idDetalle_tiponotacurso;
	}

	public void setIdDetalle_tiponotacurso(int idDetalle_tiponotacurso) {
		this.idDetalle_tiponotacurso = idDetalle_tiponotacurso;
	}

	public int getIdInscripcion() {
		return idInscripcion;
	}

	public void setIdInscripcion(int idInscripcion) {
		this.idInscripcion = idInscripcion;
	}

	public int getIdCursoSeccion() {
		return idCursoSeccion;
	}

	public void setIdCursoSeccion(int idCursoSeccion) {
		this.idCursoSeccion = idCursoSeccion;
	}
	
	
}
