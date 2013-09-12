package com.intranet.inscripcion.action;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import com.intranet.bean.CursoDTO;
import com.intranet.bean.UsuarioDTO;
import com.intranet.inscripcion.dao.InscripcionDAO;

public class InscripcionAction {

	private List<CursoDTO> cursosJalados;
	private List<CursoDTO> cursosFaltantesPorLlevar;
	private List<CursoDTO> cursosDelSigtCiclo;
	private int cursoFaltantesJust4Parameter;
	private List<CursoDTO> listaVaciaA;
	private List<CursoDTO> listaVaciaB;
	private List<CursoDTO> listaVaciaC;
	private List<CursoDTO> listaB=new ArrayList<CursoDTO>();
	private int cantCursosPermitidos=0;

	public String execute(){

		InscripcionDAO inscripcionDao=new InscripcionDAO();

		//Jalamos y cargamos el objeto usuario, logueado en la sesion
		FacesContext ctx=FacesContext.getCurrentInstance();
		UsuarioDTO usuario=(UsuarioDTO)ctx.getExternalContext().getSessionMap().get("s_usuario");

		//Llenando los cursos que puede llevar el alumno
		cursosJalados=inscripcionDao.getCursosJalados(usuario);
		cursosFaltantesPorLlevar=inscripcionDao.getCursosRestantes(usuario);

		//Valores necesario para la formula
		cursoFaltantesJust4Parameter=inscripcionDao.getCantidadDeCursosRestantes4Parameter(usuario);
		cantCursosPermitidos=inscripcionDao.getCantidadDeCursosRestantes4Parameter(usuario);
		//Si el resultado es afirmativo, se carga la sigt lista
		cursosDelSigtCiclo=inscripcionDao.getCursosSiguientes(usuario);
		
		return "exito";
	}
	public String verificarAgregarCursos(){
		return null;
	}
	public void validate(){
		System.out.println(listaB.size());
		if(listaB.size()>7){
			//			addActionError("El Alumno debe matricularse exactamente en 7 cursos");
		}
	}

	public String inscribir(){
		System.out.println("Dentro de inscribirse");
		return null;
	}
	public int getCantcursos() {
		return cantCursosPermitidos;
	}
	public void setCantcursos(int cantcursos) {
		this.cantCursosPermitidos = cantcursos;
	}
	public List<CursoDTO> getListaVaciaA() {
		return listaVaciaA;
	}
	public void setListaVaciaA(List<CursoDTO> listaVaciaA) {
		this.listaVaciaA = listaVaciaA;
	}
	public List<CursoDTO> getListaVaciaB() {
		return listaVaciaB;
	}
	public void setListaVaciaB(List<CursoDTO> listaVaciaB) {
		this.listaVaciaB = listaVaciaB;
	}
	public List<CursoDTO> getListaVaciaC() {
		return listaVaciaC;
	}
	public void setListaVaciaC(List<CursoDTO> listaVaciaC) {
		this.listaVaciaC = listaVaciaC;
	}

	//Nuevos getters y setters

	public List<CursoDTO> getCursosJalados() {
		return cursosJalados;
	}
	public void setCursosJalados(List<CursoDTO> cursosJalados) {
		this.cursosJalados = cursosJalados;
	}
	public List<CursoDTO> getCursosFaltantesPorLlevar() {
		return cursosFaltantesPorLlevar;
	}
	public void setCursosFaltantesPorLlevar(List<CursoDTO> cursosFaltantesPorLlevar) {
		this.cursosFaltantesPorLlevar = cursosFaltantesPorLlevar;
	}
	public List<CursoDTO> getCursosDelSigtCiclo() {
		return cursosDelSigtCiclo;
	}
	public void setCursosDelSigtCiclo(List<CursoDTO> cursosDelSigtCiclo) {
		this.cursosDelSigtCiclo = cursosDelSigtCiclo;
	}
	public int getCursoFaltantesJust4Parameter() {
		return cursoFaltantesJust4Parameter;
	}
	public void setCursoFaltantesJust4Parameter(int cursoFaltantesJust4Parameter) {
		this.cursoFaltantesJust4Parameter = cursoFaltantesJust4Parameter;
	}
	public List<CursoDTO> getListaB() {
		return listaB;
	}
	public void setListaB(List<CursoDTO> listaB) {
		this.listaB = listaB;
	}
	public int getCantCursosPermitidos() {
		return cantCursosPermitidos;
	}
	public void setCantCursosPermitidos(int cantCursosPermitidos) {
		this.cantCursosPermitidos = cantCursosPermitidos;
	}

}
