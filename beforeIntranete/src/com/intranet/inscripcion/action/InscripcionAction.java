package com.intranet.inscripcion.action;

import java.util.List;

import javax.faces.context.FacesContext;

import com.intranet.bean.CursoDTO;
import com.intranet.bean.UsuarioDTO;
import com.intranet.inscripcion.dao.InscripcionDAO;

public class InscripcionAction {

	private List<CursoDTO> cursosJalados;
	private List<CursoDTO> cursosFaltantesPorLlevar;
	private List<CursoDTO> cursosDelSigtCiclo;
	private int cantCurPerm=0;

	public String execute(){

		InscripcionDAO inscripcionDao=new InscripcionDAO();

		//Jalamos y cargamos el objeto usuario, logueado en la sesion
		FacesContext ctx=FacesContext.getCurrentInstance();
		UsuarioDTO usuario=(UsuarioDTO)ctx.getExternalContext().getSessionMap().get("s_usuario");

		//Llenando los cursos que puede llevar el alumno
		cursosJalados=inscripcionDao.getCursosJalados(usuario);
		cursosFaltantesPorLlevar=inscripcionDao.getCursosRestantes(usuario);

		//Valores necesario para la formula
		int cantcurFalt4p=inscripcionDao.getCantidadDeCursosRestantes4Parameter(usuario);
		cantCurPerm=inscripcionDao.getCantidadDeCursosQuePuedeLlevar(usuario);

		boolean siguienteCiclo=(cursosJalados.size()+cantcurFalt4p)<cantCurPerm? true:false;

		if(siguienteCiclo){
			cursosDelSigtCiclo=inscripcionDao.getCursosSiguientes(usuario);

			//Eliminamos la misma categoria del curso del sigtCiclo con los cursosAtrazados 
//			for (int i = 0; i < cursosDelSigtCiclo.size(); i++) {
//				for (int j = 0; j < cursosFaltantesPorLlevar.size(); j++) {
//					if(cursosDelSigtCiclo.get(i).getCategoriaCursoDTO().getIdCategoriaCurso()==cursosFaltantesPorLlevar.get(j).getCategoriaCursoDTO().getIdCategoriaCurso()){
//						cursosDelSigtCiclo.remove(i);
//					} 
//				}//do for
//			}//1er for
		}// fin del if

		return "success";
	}
	public String verificarAgregarCursos(){
		return null;
	}
	public void validate(){
		//		System.out.println(listaB.size());
		//		if(listaB.size()>7){
		//			//			addActionError("El Alumno debe matricularse exactamente en 7 cursos");
		//		}
	}

	public String inscribir(){
		System.out.println("Dentro de inscribirse");
		return null;
	}
	public int getCantcursos() {
		return cantCurPerm;
	}
	public void setCantcursos(int cantcursos) {
		this.cantCurPerm = cantcursos;
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
	public int getCantCursosPermitidos() {
		return cantCurPerm;
	}
	public void setCantCursosPermitidos(int cantCursosPermitidos) {
		this.cantCurPerm = cantCursosPermitidos;
	}

}
