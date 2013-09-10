package com.intranet.asistencia.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import com.intranet.asistencia.bean.AlumnoPropAsistencia;
import com.intranet.asistencia.bean.AsistenciaResumen;
import com.intranet.asistencia.bean.CursoSeccionConNombre;
import com.intranet.asistencia.service.AsistenciaService;
import com.intranet.asistencia.service.AsistenciaService_I;
import com.intranet.bean.Asistencia;
import com.intranet.bean.Detalle_cursoSeccion;
import com.intranet.bean.Usuario;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.IFEQ;

public class AsistenciaDetalladoAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private List<Asistencia> listaAsistencia;
	private AsistenciaResumen asistenciaResumi;
	private int inte;
	
	private AsistenciaService_I asistenciaS=new AsistenciaService();
	private Map<String,Object> sesion=ActionContext.getContext().getSession();
	private Usuario user=((Usuario)sesion.get("a_usuario"));

	//Agregar Asistencia por Profe
	private Detalle_cursoSeccion valora;
	private static List<CursoSeccionConNombre> listaSeccionesXprofesor=new ArrayList<CursoSeccionConNombre>();
	private static List<AlumnoPropAsistencia> listaAlumnoProdAsist=new ArrayList<AlumnoPropAsistencia>();
	//Modificar Asistencia por Profe
	private static List<String> lfechas=new ArrayList<String>();
	private static List<AlumnoPropAsistencia> listaAlumnoProdAsistTwo=new ArrayList<AlumnoPropAsistencia>();
	private String avFecha;
	
	
	private List<AlumnoPropAsistencia> listaVacia=new ArrayList<AlumnoPropAsistencia>();
		
	public String execute(){

		listaAsistencia =asistenciaS.listarAsistenciaDetallada(user, Integer.toString(inte));

		return "exito";
	}

	public String mIrAgregarAsistencia(){
		listaSeccionesXprofesor=asistenciaS.listarSeccionesXprofesor(user);

		return SUCCESS;
	}

	public String mCargarParamAgregarAsistencia(){
		sesion.put("sv_idCursoSeccion", valora);
		listaAlumnoProdAsist=asistenciaS.listarAlumnosDeSeccion(valora);
		return SUCCESS;
	}

	public String mAgregarAsistencia(){
		
		//Balance de las colecciones
		ListIterator<AlumnoPropAsistencia> litr = listaAlumnoProdAsist.listIterator(); 
		while(litr.hasNext()) {
			AlumnoPropAsistencia element = litr.next(); 
			ListIterator<AlumnoPropAsistencia> litr2 = listaVacia.listIterator(); 
			while(litr2.hasNext()) { 
				AlumnoPropAsistencia element2 = litr2.next();
				if(element.getIdInscripcion()==element2.getIdInscripcion()){
					litr.remove();
				}
			}
		}//fin while1
		Detalle_cursoSeccion stackdcs=(Detalle_cursoSeccion)sesion.get("sv_idCursoSeccion");
		
		SimpleDateFormat sd = new SimpleDateFormat("YYYY-MM-dd");
		Date d=new Date();
		String aux=sd.format(d);
		
		
		for(AlumnoPropAsistencia iapa: listaAlumnoProdAsist){
		
			Asistencia vAsistencia=new Asistencia();
			vAsistencia.setDescAsistencia("Falto");
			vAsistencia.setIdCursoSeccion(stackdcs.getIdCursoSeccion());
			vAsistencia.setIdInscripcion(iapa.getIdInscripcion());
			vAsistencia.setFechaAsistencia(aux);
			asistenciaS.sRegistrarAsistencia(vAsistencia);

		}
		
		for(AlumnoPropAsistencia iapa2: listaVacia){
			Asistencia vAsistencia=new Asistencia();
			vAsistencia.setDescAsistencia("Asistio");
			vAsistencia.setIdCursoSeccion(stackdcs.getIdCursoSeccion());
			vAsistencia.setIdInscripcion(iapa2.getIdInscripcion());
			vAsistencia.setFechaAsistencia(aux);
			asistenciaS.sRegistrarAsistencia(vAsistencia);

		}		
		return SUCCESS;
	}
	
	public String mCargarParamFechaAgregarAsistencia(){
		sesion.put("sv_idCursoSeccion", valora);
		lfechas=asistenciaS.listarFechasParamAsistenciaXProfesor(valora);

		return SUCCESS;
	}
	
	public String mCargarParamModificarAsistencia(){
		sesion.put("sv_fecha", avFecha);
		Detalle_cursoSeccion auxdcs=(Detalle_cursoSeccion)sesion.get("sv_idCursoSeccion");
		setListaAlumnoProdAsistTwo(asistenciaS.listaAlumnosParamXProfesor(avFecha, auxdcs));
		
		return SUCCESS;
	}
	public String mModificarAsistencia(){
		
		//Balance de las colecciones
		ListIterator<AlumnoPropAsistencia> litr = listaAlumnoProdAsistTwo.listIterator(); 
		while(litr.hasNext()) {
			AlumnoPropAsistencia element = litr.next(); 
			ListIterator<AlumnoPropAsistencia> litr2 = listaVacia.listIterator(); 
			while(litr2.hasNext()) { 
				AlumnoPropAsistencia element2 = litr2.next();
				if(element.getIdInscripcion()==element2.getIdInscripcion()){
					litr.remove();
				}
			}
		}//fin while1
		
		Detalle_cursoSeccion auxdcs=(Detalle_cursoSeccion)sesion.get("sv_idCursoSeccion");
				
		for(AlumnoPropAsistencia iapa: listaAlumnoProdAsistTwo){
		
			Asistencia vAsistencia=new Asistencia();
			vAsistencia.setDescAsistencia("Falto");
			vAsistencia.setIdInscripcion(iapa.getIdInscripcion());
			vAsistencia.setIdCursoSeccion(auxdcs.getIdCursoSeccion());
			asistenciaS.sModificarAsistencia(vAsistencia);
				
		}
		
		for(AlumnoPropAsistencia iapa2: listaVacia){
			Asistencia vAsistencia=new Asistencia();
			vAsistencia.setDescAsistencia("Asistio");
			vAsistencia.setIdInscripcion(iapa2.getIdInscripcion());
			vAsistencia.setIdCursoSeccion(auxdcs.getIdCursoSeccion());
			asistenciaS.sModificarAsistencia(vAsistencia);


		}		
		return SUCCESS;
	}
	//getters y setters para struts2
	public void setAsistenciaResumi(AsistenciaResumen asistenciaResumi) {
		this.asistenciaResumi = asistenciaResumi;
	}
	public void setInte(int inte) {
		this.inte = inte;
	}
	public List<Asistencia> getListaAsistencia() {
		return listaAsistencia;
	}

	public List<CursoSeccionConNombre> getListaSeccionesXprofesor() {
		return listaSeccionesXprofesor;
	}

	public void setListaSeccionesXprofesor(
			List<CursoSeccionConNombre> listaSeccionesXprofesor) {
		AsistenciaDetalladoAction.listaSeccionesXprofesor = listaSeccionesXprofesor;
	}

	public List<AlumnoPropAsistencia> getListaAlumnoProdAsist() {
		return listaAlumnoProdAsist;
	}

	public void setListaAlumnoProdAsist(List<AlumnoPropAsistencia> listaAlumnoProdAsist) {
		this.listaAlumnoProdAsist = listaAlumnoProdAsist;
	}

	public List<AlumnoPropAsistencia> getListaVacia() {
		return listaVacia;
	}

	public void setListaVacia(List<AlumnoPropAsistencia> listaVacia) {
		this.listaVacia = listaVacia;
	}

	public Detalle_cursoSeccion getValora() {
		return valora;
	}

	public void setValora(Detalle_cursoSeccion valora) {
		this.valora = valora;
	}

	public List<AlumnoPropAsistencia> getListaAlumnoProdAsistTwo() {
		return listaAlumnoProdAsistTwo;
	}

	public void setListaAlumnoProdAsistTwo(List<AlumnoPropAsistencia> listaAlumnoProdAsistTwo) {
		this.listaAlumnoProdAsistTwo = listaAlumnoProdAsistTwo;
	}

	public List<String> getLfechas() {
		return lfechas;
	}

	public void setLfechas(List<String> lfechas) {
		AsistenciaDetalladoAction.lfechas = lfechas;
	}

	public String getAvFecha() {
		return avFecha;
	}

	public void setAvFecha(String avFecha) {
		this.avFecha = avFecha;
	}



}
