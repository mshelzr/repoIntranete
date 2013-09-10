package com.intranet.nota.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.intranet.asistencia.bean.CursoSeccionConNombre;
import com.intranet.asistencia.service.AsistenciaService;
import com.intranet.asistencia.service.AsistenciaService_I;
import com.intranet.bean.Curso;
import com.intranet.bean.Detalle_cursoSeccion;
import com.intranet.bean.Detalle_tiponotacurso;
import com.intranet.bean.Usuario;
import com.intranet.nota.bean.AlumnosNotaConNombre;
import com.intranet.nota.bean.NotaConNombre;
import com.intranet.nota.service.CursoService;
import com.intranet.nota.service.CursoService_I;
import com.intranet.nota.service.NotaService;
import com.intranet.nota.service.NotaService_I;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class NotaAction extends ActionSupport{

	private List<Curso> listaCursosDetalle;
	private Map<String,Object> sesion=ActionContext.getContext().getSession();
	private Usuario usuO=(Usuario)sesion.get("a_usuario");	
	private AsistenciaService_I asistenciaS=new AsistenciaService();
	private NotaService_I notaservice=new NotaService();
	private int codCurso;
	private List<NotaConNombre> listaNotas;
	
	//variables reposedoras
	private Detalle_cursoSeccion stvDCS;
	private Detalle_tiponotacurso stvDTNC;
	
	private static List<Detalle_tiponotacurso> listaTipoNotaXProfesor=new ArrayList<Detalle_tiponotacurso>();
	private static List<AlumnosNotaConNombre> listaAlumnosParaGenNota=new ArrayList<AlumnosNotaConNombre>();
	private static List<CursoSeccionConNombre> listaSeccionesXprofesor2=new ArrayList<CursoSeccionConNombre>();
	
	public String execute(){
		CursoService_I cursoservice=new CursoService();
		listaCursosDetalle=cursoservice.buscarCursos(usuO);
		return "exito";
	}
	
	//gen
	public String mCargarSeccionesDelProfesorActGen(){
		setListaSeccionesXprofesor2(asistenciaS.listarSeccionesXprofesor(usuO));

		return SUCCESS;
	}
	public String notasDetalladas(){
		listaNotas=notaservice.buscarNotaDetalle(usuO, codCurso);
		return "exito";
	}
	
	public String mCargarTipoNota(){
		sesion.put("va_cursoseccion", stvDCS);
		listaTipoNotaXProfesor=notaservice.buscarTiposDeNotas(stvDCS);
		return SUCCESS;
	}
	public String mListarAlumnosConNota(){
		sesion.put("va_tiponota", stvDTNC);
		Detalle_cursoSeccion auxdcs=(Detalle_cursoSeccion)sesion.get("va_cursoseccion");
		listaAlumnosParaGenNota=notaservice.buscarAlumnosParaNota(auxdcs);
		for(AlumnosNotaConNombre auxfor:listaAlumnosParaGenNota)
			System.out.println(auxfor.getNomPersona());
		return SUCCESS;
	}
	
	public String mGenerarNota(){
		for(AlumnosNotaConNombre af :listaAlumnosParaGenNota)
			System.out.println("noa: \t"+af.getNota());
		return SUCCESS;
	}
	//modif
	public String mCargarSeccionesDelProfesorActMod(){
		return SUCCESS;
	}
	
	//getters y setters
	public List<Curso> getListaCursosDetalle() {
		return listaCursosDetalle;
	}

	public List<NotaConNombre> getListaNotas() {
		return listaNotas;
	}

	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}
	public Detalle_tiponotacurso getStvDTNC() {
		return stvDTNC;
	}

	public void setStvDTNC(Detalle_tiponotacurso stvDTNC) {
		this.stvDTNC = stvDTNC;
	}

	public Detalle_cursoSeccion getStvDCS() {
		return stvDCS;
	}

	public void setStvDCS(Detalle_cursoSeccion stvDCS) {
		this.stvDCS = stvDCS;
	}

	public List<Detalle_tiponotacurso> getListaTipoNotaXProfesor() {
		return listaTipoNotaXProfesor;
	}

	public void setListaTipoNotaXProfesor(List<Detalle_tiponotacurso> listaTipoNotaXProfesor) {
		this.listaTipoNotaXProfesor = listaTipoNotaXProfesor;
	}

	public List<AlumnosNotaConNombre> getListaAlumnosParaGenNota() {
		return listaAlumnosParaGenNota;
	}

	public void setListaAlumnosParaGenNota(List<AlumnosNotaConNombre> listaAlumnosParaGenNota) {
		this.listaAlumnosParaGenNota = listaAlumnosParaGenNota;
	}

	public List<CursoSeccionConNombre> getListaSeccionesXprofesor2() {
		return listaSeccionesXprofesor2;
	}

	public void setListaSeccionesXprofesor2(
			List<CursoSeccionConNombre> listaSeccionesXprofesor2) {
		NotaAction.listaSeccionesXprofesor2 = listaSeccionesXprofesor2;
	}
	
}
