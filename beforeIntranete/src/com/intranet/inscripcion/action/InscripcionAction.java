package com.intranet.inscripcion.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import com.intranet.bean.CursoDTO;
import com.intranet.bean.UsuarioDTO;
import com.intranet.inscripcion.dao.InscripcionDAO;

public class InscripcionAction {
	
	private static final long serialVersionUID = 1L;
	private List<CursoDTO> listaCursosAnteriores;
	private List<CursoDTO> listaCursosActuales;
	private List<CursoDTO> listaCursosFuturos;
	private List<CursoDTO> listaVaciaA;
	private List<CursoDTO> listaVaciaB;
	private List<CursoDTO> listaVaciaC;
	private List<CursoDTO> listaB=new ArrayList<CursoDTO>();
	private int cantcursos=0;
	
	private Map<String,Object> sesion=new HashMap<String,Object>();
	private UsuarioDTO usuO=(UsuarioDTO)sesion.get("a_usuario");
	
	public String execute(){
		
			InscripcionDAO inscriService=new InscripcionDAO();
			
			//Llenando los cursos a poder matricularse
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
				for(CursoDTO curso: listaVaciaA){
					curso=inscriService.obtenerCursoBean(curso);
					listaB.add(curso);
					System.out.println("Lista A: "+listaB.size()+"\t"+curso.getIdCurso()+"\t"+curso.getDescCurso());
					
					ListIterator<CursoDTO> litr = listaCursosAnteriores.listIterator(); 
					while(litr.hasNext()) { 
					CursoDTO element = litr.next(); 
						ListIterator<CursoDTO> litr2 = listaB.listIterator(); 
						while(litr2.hasNext()) { 
						CursoDTO element2 = litr2.next();
							if(element.getIdCurso()==element2.getIdCurso()){
								litr.remove();
							}
						}
					}
				}
			}else if(!listaVaciaB.isEmpty()){
				if(!listaCursosAnteriores.isEmpty())
//					addActionError("Escoge uno de la lista A");
//				else {
				for(CursoDTO curso: listaVaciaB){
					curso=inscriService.obtenerCursoBean(curso);
					listaB.add(curso);
					System.out.println("Lista B: "+listaB.size()+"\t"+curso.getIdCurso()+"\t"+curso.getDescCurso());
					
					ListIterator<CursoDTO> litr = listaCursosActuales.listIterator(); 
					while(litr.hasNext()) { 
					CursoDTO element = litr.next(); 
						ListIterator<CursoDTO> litr2 = listaB.listIterator(); 
						while(litr2.hasNext()) { 
						CursoDTO element2 = litr2.next();
							if(element.getIdCurso()==element2.getIdCurso()){
								litr.remove();
							}
						}
					}
//				}
				}//if segundo
			}else if(!listaVaciaC.isEmpty()){
				if(!listaCursosAnteriores.isEmpty() ||!listaCursosActuales.isEmpty() )
//					addActionError("Completa el registro de la listas anteriores");
//				else {
				for(CursoDTO curso: listaVaciaB){
					curso=inscriService.obtenerCursoBean(curso);
					listaB.add(curso);
					System.out.println("Lista C: "+listaB.size()+"\t"+curso.getIdCurso()+"\t"+curso.getDescCurso());
					
					ListIterator<CursoDTO> litr = listaCursosFuturos.listIterator(); 
					while(litr.hasNext()) { 
					CursoDTO element = litr.next(); 
						ListIterator<CursoDTO> litr2 = listaB.listIterator(); 
						while(litr2.hasNext()) { 
						CursoDTO element2 = litr2.next();
							if(element.getIdCurso()==element2.getIdCurso()){
								litr.remove();
							}
						}
					}
//				}
			}}
		sesion.put("x_curso", listaB);
		
		return null;
	}
	public void validate(){
		System.out.println(listaB.size());
		if(listaB.size()>7){
//			addActionError("El Alumno debe matricularse exactamente en 7 cursos");
		}
	}
	
	public void setListaCursosAnteriores(List<CursoDTO> listaCursosAnteriores) {
		this.listaCursosAnteriores = listaCursosAnteriores;
	}
	public List<CursoDTO> getListaCursosAnteriores() {
		return listaCursosAnteriores;
	}
	
	public String inscribir(){
			System.out.println("Dentro de inscribirse");
		return null;
	}
	public int getCantcursos() {
		return cantcursos;
	}
	public void setCantcursos(int cantcursos) {
		this.cantcursos = cantcursos;
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
	public List<CursoDTO> getListaCursosActuales() {
		return listaCursosActuales;
	}
	public void setListaCursosActuales(List<CursoDTO> listaCursosActuales) {
		this.listaCursosActuales = listaCursosActuales;
	}
	public List<CursoDTO> getListaCursosFuturos() {
		return listaCursosFuturos;
	}
	public void setListaCursosFuturos(List<CursoDTO> listaCursosFuturos) {
		this.listaCursosFuturos = listaCursosFuturos;
	}

}
