package com.intranet.inscripcion.action;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import com.intranet.bean.Curso;
import com.intranet.bean.Usuario;
import com.intranet.inscripcion.dao.InscripcionDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class InscripcionAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private List<Curso> listaCursosAnteriores;
	private List<Curso> listaCursosActuales;
	private List<Curso> listaCursosFuturos;
	private List<Curso> listaVaciaA;
	private List<Curso> listaVaciaB;
	private List<Curso> listaVaciaC;
	private List<Curso> listaB=new ArrayList<Curso>();
	private int cantcursos=0;
	
	private Map<String,Object> sesion=ActionContext.getContext().getSession();
	private Usuario usuO=(Usuario)sesion.get("a_usuario");
	
	public String execute(){
			InscripcionDAO inscriService=new InscripcionDAO();
			listaCursosAnteriores=inscriService.obtenerCursosActuales(usuO);
			listaCursosAnteriores.addAll(inscriService.obtenerCursosAnteriores2(usuO));
			listaCursosActuales=inscriService.obtenerCursosActuales(usuO);
			listaCursosActuales.addAll(inscriService.obtenerCursosActuales2(usuO));
			listaCursosFuturos=inscriService.obtenerCursosFuturos(usuO);

			cantcursos=inscriService.obtenerDatosPreInscripcion(usuO);
			
			if(inscriService.obtenerPromAntCiclo(usuO)<12.5)
				cantcursos=6;
		
		return "exito";
	}
	public String verificarAgregarCursos(){
		InscripcionDAO inscriService=new InscripcionDAO();
		System.out.println(listaB.size()+": es menor que 2");
		if(listaB.size()<2)
			if(!listaVaciaA.isEmpty()){
				for(Curso curso: listaVaciaA){
					curso=inscriService.obtenerCursoBean(curso);
					listaB.add(curso);
					System.out.println("Lista A: "+listaB.size()+"\t"+curso.getIdCurso()+"\t"+curso.getDescCurso());
					
					ListIterator<Curso> litr = listaCursosAnteriores.listIterator(); 
					while(litr.hasNext()) { 
					Curso element = litr.next(); 
						ListIterator<Curso> litr2 = listaB.listIterator(); 
						while(litr2.hasNext()) { 
						Curso element2 = litr2.next();
							if(element.getIdCurso()==element2.getIdCurso()){
								litr.remove();
							}
						}
					}
				}
			}else if(!listaVaciaB.isEmpty()){
				if(!listaCursosAnteriores.isEmpty())
					addActionError("Escoge uno de la lista A");
				else {
				for(Curso curso: listaVaciaB){
					curso=inscriService.obtenerCursoBean(curso);
					listaB.add(curso);
					System.out.println("Lista B: "+listaB.size()+"\t"+curso.getIdCurso()+"\t"+curso.getDescCurso());
					
					ListIterator<Curso> litr = listaCursosActuales.listIterator(); 
					while(litr.hasNext()) { 
					Curso element = litr.next(); 
						ListIterator<Curso> litr2 = listaB.listIterator(); 
						while(litr2.hasNext()) { 
						Curso element2 = litr2.next();
							if(element.getIdCurso()==element2.getIdCurso()){
								litr.remove();
							}
						}
					}
				}
				}//if segundo
			}else if(!listaVaciaC.isEmpty()){
				if(!listaCursosAnteriores.isEmpty() ||!listaCursosActuales.isEmpty() )
					addActionError("Completa el registro de la listas anteriores");
				else {
				for(Curso curso: listaVaciaB){
					curso=inscriService.obtenerCursoBean(curso);
					listaB.add(curso);
					System.out.println("Lista C: "+listaB.size()+"\t"+curso.getIdCurso()+"\t"+curso.getDescCurso());
					
					ListIterator<Curso> litr = listaCursosFuturos.listIterator(); 
					while(litr.hasNext()) { 
					Curso element = litr.next(); 
						ListIterator<Curso> litr2 = listaB.listIterator(); 
						while(litr2.hasNext()) { 
						Curso element2 = litr2.next();
							if(element.getIdCurso()==element2.getIdCurso()){
								litr.remove();
							}
						}
					}
				}
			}}
			else		
				addActionError("Elija los antecesores");				
		else//<2
			addActionError("Supero el máximo de cursos a inscribirse");

		sesion.put("x_curso", listaB);
		
		return SUCCESS;
	}
	@Override
	public void validate(){
		System.out.println(listaB.size());
		if(listaB.size()>7){
			addActionError("El Alumno debe matricularse exactamente en 7 cursos");
		}
	}
	
	public void setListaCursosAnteriores(List<Curso> listaCursosAnteriores) {
		this.listaCursosAnteriores = listaCursosAnteriores;
	}
	public List<Curso> getListaCursosAnteriores() {
		return listaCursosAnteriores;
	}
	
	public String inscribir(){
			System.out.println("Dentro de inscribirse");
		return SUCCESS;
	}
	public int getCantcursos() {
		return cantcursos;
	}
	public void setCantcursos(int cantcursos) {
		this.cantcursos = cantcursos;
	}
	public List<Curso> getListaVaciaA() {
		return listaVaciaA;
	}
	public void setListaVaciaA(List<Curso> listaVaciaA) {
		this.listaVaciaA = listaVaciaA;
	}
	public List<Curso> getListaVaciaB() {
		return listaVaciaB;
	}
	public void setListaVaciaB(List<Curso> listaVaciaB) {
		this.listaVaciaB = listaVaciaB;
	}
	public List<Curso> getListaVaciaC() {
		return listaVaciaC;
	}
	public void setListaVaciaC(List<Curso> listaVaciaC) {
		this.listaVaciaC = listaVaciaC;
	}
	public List<Curso> getListaCursosActuales() {
		return listaCursosActuales;
	}
	public void setListaCursosActuales(List<Curso> listaCursosActuales) {
		this.listaCursosActuales = listaCursosActuales;
	}
	public List<Curso> getListaCursosFuturos() {
		return listaCursosFuturos;
	}
	public void setListaCursosFuturos(List<Curso> listaCursosFuturos) {
		this.listaCursosFuturos = listaCursosFuturos;
	}

}
