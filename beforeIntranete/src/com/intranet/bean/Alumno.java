package com.intranet.bean;

public class Alumno {

	private int idAlumno;
	private String descAlumno;
	private int idCarrera;
	private int idPersona;
	private int idUsuario;
	
	public Alumno(int idAlumno, String descAlumno, int idCarrera,
			int idPersona, int idUsuario) {
		super();
		this.idAlumno = idAlumno;
		this.descAlumno = descAlumno;
		this.idCarrera = idCarrera;
		this.idPersona = idPersona;
		this.idUsuario = idUsuario;
	}

	public Alumno() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getDescAlumno() {
		return descAlumno;
	}

	public void setDescAlumno(String descAlumno) {
		this.descAlumno = descAlumno;
	}

	public int getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(int idCarrera) {
		this.idCarrera = idCarrera;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
	
}
