package com.intranet.inscripcion.bean;

public class DatosReqInscripcionDTO {

	private int idCarrera;
	private int ciclo;
	
	
	public DatosReqInscripcionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DatosReqInscripcionDTO(int idCarrera, int ciclo) {
		super();
		this.idCarrera = idCarrera;
		this.ciclo = ciclo;
	}
	public int getIdCarrera() {
		return idCarrera;
	}
	public void setIdCarrera(int idCarrera) {
		this.idCarrera = idCarrera;
	}
	public int getCiclo() {
		return ciclo;
	}
	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
	}
	
	
	
}
