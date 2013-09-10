package com.intranet.bean;

public class Horario {

	private int idHorario;
	private String descHorario;
	private String hora_inicio;
	private String hora_fin;
	private int idAula;
	private int idCursoSeccion;
	public Horario(int idHorario, String descHorario, String hora_inicio,
			String hora_fin, int idAula, int idCursoSeccion) {
		super();
		this.idHorario = idHorario;
		this.descHorario = descHorario;
		this.hora_inicio = hora_inicio;
		this.hora_fin = hora_fin;
		this.idAula = idAula;
		this.idCursoSeccion = idCursoSeccion;
	}
	public Horario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdHorario() {
		return idHorario;
	}
	public void setIdHorario(int idHorario) {
		this.idHorario = idHorario;
	}
	public String getDescHorario() {
		return descHorario;
	}
	public void setDescHorario(String descHorario) {
		this.descHorario = descHorario;
	}
	public String getHora_inicio() {
		return hora_inicio;
	}
	public void setHora_inicio(String hora_inicio) {
		this.hora_inicio = hora_inicio;
	}
	public String getHora_fin() {
		return hora_fin;
	}
	public void setHora_fin(String hora_fin) {
		this.hora_fin = hora_fin;
	}
	public int getIdAula() {
		return idAula;
	}
	public void setIdAula(int idAula) {
		this.idAula = idAula;
	}
	public int getIdCursoSeccion() {
		return idCursoSeccion;
	}
	public void setIdCursoSeccion(int idCursoSeccion) {
		this.idCursoSeccion = idCursoSeccion;
	}
	
	
	
}
