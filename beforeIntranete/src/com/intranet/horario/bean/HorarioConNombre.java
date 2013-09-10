package com.intranet.horario.bean;

public class HorarioConNombre {

	private String descCurso;
	private String descHorario;
	private String hora_iniciio;
	private String hora_fin;
	
	public HorarioConNombre(String descCurso, String descHorario,
			String hora_iniciio, String hora_fin) {
		super();
		this.descCurso = descCurso;
		this.descHorario = descHorario;
		this.hora_iniciio = hora_iniciio;
		this.hora_fin = hora_fin;
	}
	
	public HorarioConNombre() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getDescCurso() {
		return descCurso;
	}
	public void setDescCurso(String descCurso) {
		this.descCurso = descCurso;
	}
	public String getDescHorario() {
		return descHorario;
	}
	public void setDescHorario(String descHorario) {
		this.descHorario = descHorario;
	}
	public String getHora_iniciio() {
		return hora_iniciio;
	}
	public void setHora_iniciio(String hora_iniciio) {
		this.hora_iniciio = hora_iniciio;
	}
	public String getHora_fin() {
		return hora_fin;
	}
	public void setHora_fin(String hora_fin) {
		this.hora_fin = hora_fin;
	}
	
	
	
}
