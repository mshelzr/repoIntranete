package com.intranet.asistencia.bean;

public class AlumnoPropAsistencia {

	private int idInscripcion;
	private String nompersona;
	private int cantAsistencias;
	
	public AlumnoPropAsistencia() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AlumnoPropAsistencia(int idInscripcion, String nompersona,
			int cantAsistencias) {
		super();
		this.idInscripcion = idInscripcion;
		this.nompersona = nompersona;
		this.cantAsistencias = cantAsistencias;
	}
	public int getIdInscripcion() {
		return idInscripcion;
	}
	public void setIdInscripcion(int idInscripcion) {
		this.idInscripcion = idInscripcion;
	}
	public String getNompersona() {
		return nompersona;
	}
	public void setNompersona(String nompersona) {
		this.nompersona = nompersona;
	}
	public int getCantAsistencias() {
		return cantAsistencias;
	}
	public void setCantAsistencias(int cantAsistencias) {
		this.cantAsistencias = cantAsistencias;
	}
	
	
	
}
