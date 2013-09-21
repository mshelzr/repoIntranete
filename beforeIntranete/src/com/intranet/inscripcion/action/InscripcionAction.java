package com.intranet.inscripcion.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;

import com.intranet.bean.CursoCompuestoDTO;
import com.intranet.bean.DetalleInscriCursoDTO;
import com.intranet.bean.HorarioDTO;
import com.intranet.bean.InscripcionAlumnoDTO;
import com.intranet.bean.UsuarioDTO;
import com.intranet.inscripcion.dao.InscripcionDAO;

@ManagedBean
@RequestScoped
public class InscripcionAction implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private ScheduleModel eventModel; 
	private InscripcionDAO inscripcionDao=new InscripcionDAO();
	private List<CursoCompuestoDTO> cursosJalados;
	private List<CursoCompuestoDTO> cursosFaltantesPorLlevar;
	private List<CursoCompuestoDTO> cursosDelSigtCiclo;
	private int cantCurPerm;
	private List<CursoCompuestoDTO> cursosMatriculados;
	private int boton=1;
	private List<CursoCompuestoDTO> cursosJaladosDetalle;
	private List<CursoCompuestoDTO> cursosRestantesDetalle;
	private List<CursoCompuestoDTO> cursosSiguienteCiclo;
	private int id4save;
	private static int contador;
	
	public void executeDialog(ActionEvent e){
		eventModel= new DefaultScheduleModel();

		CursoCompuestoDTO cc=new CursoCompuestoDTO();
		cc.setIdCursoCompuesto((int)e.getComponent().getAttributes().get("pcurso"));
		id4save=cc.getIdCursoCompuesto();
		System.out.println(id4save);
		boton=1;
		//Jalamos y cargamos el objeto usuario, logueado en la sesion
		FacesContext ctx=FacesContext.getCurrentInstance();
		UsuarioDTO usuario=(UsuarioDTO)ctx.getExternalContext().getSessionMap().get("s_usuario");

		List<HorarioDTO> listaDeHorario=obtenerHorarioAlumno(usuario);
		List<HorarioDTO> listaHorarioDelParametro=inscripcionDao.getHorarioPorCurso(usuario, cc);

		//Buscamos si se cruzan los horarios para desactivar el boton registrar
		for(HorarioDTO horarioFor : listaDeHorario){
			for(HorarioDTO horarioForAux : listaHorarioDelParametro){
				int i=horarioFor.getHoraIniciio().compareTo(horarioForAux.getHoraIniciio()); //a<c
				int i2=horarioFor.getHoraFin().compareTo(horarioForAux.getHoraIniciio());	//b<c

				int j=horarioFor.getHoraIniciio().compareTo(horarioForAux.getHoraFin()); // a<d
				int j2=horarioFor.getHoraFin().compareTo(horarioForAux.getHoraFin());	//b<d

				if(i==1 && i2==-1 || j==1 && j2==-1 || i==-1 && j2==1 || i==0 && j2==0){
					boton=0;
				}
			}
			// fin del sub-for
		}//fin del primer for

		//Lenamos el horario
		listaDeHorario.addAll(listaHorarioDelParametro);
		for(HorarioDTO hsetSchedule : listaDeHorario){
			eventModel.addEvent(new DefaultScheduleEvent("Desc",hsetSchedule.getHoraIniciio(),hsetSchedule.getHoraFin()));
		}
//		RequestContext.getCurrentInstance().openDialog("HorarioMatricula");
	}
	@PostConstruct
	public void init(){
		contador++;
		System.out.println("Contador: "+contador);
		//Jalamos y cargamos el objeto usuario, logueado en la sesion
		FacesContext ctx=FacesContext.getCurrentInstance();
		UsuarioDTO usuario=(UsuarioDTO)ctx.getExternalContext().getSessionMap().get("s_usuario");
		//Recursos de inscripcionDao
		cursosParaMatricula(usuario);

		cursosMatriculados=obtenerCursoMatriculado(usuario);
		cursosJalados=inscripcionDao.getCursosJalados(usuario);
		for(CursoCompuestoDTO cc : cursosMatriculados){
			for (int i = 0; i < cursosJalados.size(); i++) {
				if(cc.getIdCursoCompuesto()==cursosJalados.get(i).getIdCursoCompuesto())
					cursosJalados.remove(i);
			}
			for (int j = 0; j < cursosFaltantesPorLlevar.size(); j++) {
				if(cc.getIdCursoCompuesto()==cursosFaltantesPorLlevar.get(j).getIdCursoCompuesto())
					cursosFaltantesPorLlevar.remove(j);
			}
			for (int k = 0; k < cursosDelSigtCiclo.size(); k++) {
				if(cc.getIdCursoCompuesto()==cursosDelSigtCiclo.get(k).getIdCursoCompuesto())
					cursosDelSigtCiclo.remove(k);
			}
		}
	}

	//Es para la img mini horario
	private List<HorarioDTO> obtenerHorarioAlumno(UsuarioDTO usuario){
		List<HorarioDTO> horarioPrev=inscripcionDao.getHorarioAlumno(usuario);
		return horarioPrev;
	}
	
	//Para los paneles de los cursos disponibles a matricular
	private void cursosParaMatricula(UsuarioDTO usuario){

		//Llenando los cursos que puede llevar el alumno
		cursosJalados=inscripcionDao.getCursosJalados(usuario);
		List<Integer> idCursosJaladosDetalle=new ArrayList<Integer>();
		for(CursoCompuestoDTO cc : cursosJalados){
			idCursosJaladosDetalle.add(cc.getCursoDTO().getIdCurso());
		}
		cursosJaladosDetalle=inscripcionDao.getCursoCompuestoPorCurso(idCursosJaladosDetalle);

		//Procedimiento para obtener el cursoCompuesto de CursosFaltantes
		cursosFaltantesPorLlevar=inscripcionDao.getCursosRestantes(usuario);
		List<Integer> idCursosRestantes=new ArrayList<Integer>();
		for(CursoCompuestoDTO cc:cursosFaltantesPorLlevar){
			idCursosRestantes.add(cc.getCursoDTO().getIdCurso());
		}
		setCursosRestantesDetalle(inscripcionDao.getCursoCompuestoPorCurso(idCursosRestantes));

		//Valores necesario para la formula
		int cantcurFalt4p=inscripcionDao.getCantidadDeCursosRestantes4Parameter(usuario);
		cantCurPerm=inscripcionDao.getCantidadDeCursosQuePuedeLlevar(usuario);

		boolean siguienteCiclo=(cursosJalados.size()+cantcurFalt4p)<cantCurPerm? true:false;

		if(siguienteCiclo){
			cursosDelSigtCiclo=inscripcionDao.getCursosSiguientes(usuario);
			//Procedimiento para obtener el cursoCompuesto de CursosDelSigtCiclo
			List<Integer> idCursosSiguiente=new ArrayList<Integer>();
			for(CursoCompuestoDTO cc: cursosDelSigtCiclo){
				idCursosSiguiente.add(cc.getCursoDTO().getIdCurso());
				
			}
			setCursosSiguienteCiclo (inscripcionDao.getCursoCompuestoPorCurso(idCursosSiguiente));
		}
	}

	private List<CursoCompuestoDTO> obtenerCursoMatriculado(UsuarioDTO usuario){
		List<CursoCompuestoDTO> cursocompuesto=inscripcionDao.getCursosRecienteMatriculado(usuario);
		return cursocompuesto;
	}

	public String agregar(ActionEvent e){
		
		int idCursoCompuesto=(int)e.getComponent().getAttributes().get("idCursoCompuesto");
	
		//Jalamos y cargamos el objeto usuario, logueado en la sesion
		FacesContext ctx=FacesContext.getCurrentInstance();
		UsuarioDTO usuario=(UsuarioDTO)ctx.getExternalContext().getSessionMap().get("s_usuario");
		
		CursoCompuestoDTO cc=new CursoCompuestoDTO();
		cc.setIdCursoCompuesto(idCursoCompuesto);
		InscripcionAlumnoDTO ia=new InscripcionAlumnoDTO();
		int codInscripcionAlumno=inscripcionDao.ultimaInscripcion(null, usuario);
		if(codInscripcionAlumno!=0){
			ia.setIdInscripcionAlumno(codInscripcionAlumno);
		}
		
		DetalleInscriCursoDTO dic=new DetalleInscriCursoDTO();
		dic.setCursoCompuestoDTO(cc);
		dic.setInscripcionAlumnoDTO(ia);
		
		//dao save
		inscripcionDao.add(dic);
		
		return "success";
				
	}
	
	public void remove(CursoCompuestoDTO cc ){
//		int idCursoCompuesto=(int)e.getComponent().getAttributes().get("idCursoCompuesto");
//		int idCursoCompuesto=1;
//		System.out.println("remove: "+idCursoCompuesto);
		//Jalamos y cargamos el objeto usuario, logueado en la sesion
		FacesContext ctx=FacesContext.getCurrentInstance();
		UsuarioDTO usuario=(UsuarioDTO)ctx.getExternalContext().getSessionMap().get("s_usuario");
		
//		CursoCompuestoDTO cc=new CursoCompuestoDTO();
//		cc.setIdCursoCompuesto(idCursoCompuesto);
		InscripcionAlumnoDTO ia=new InscripcionAlumnoDTO();
		int codInscripcionAlumno=inscripcionDao.ultimaInscripcion(null, usuario);
		ia.setIdInscripcionAlumno(codInscripcionAlumno);
			
		DetalleInscriCursoDTO dic=new DetalleInscriCursoDTO();
		dic.setCursoCompuestoDTO(cc);
		dic.setInscripcionAlumnoDTO(ia);
		
		//dao remove
		inscripcionDao.remove(dic);
	}
	
	//Getters and Setters	
	public ScheduleModel getEventModel() {
		return eventModel;
	}

	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}
	public List<CursoCompuestoDTO> getCursosJalados() {
		return cursosJalados;
	}

	public void setCursosJalados(List<CursoCompuestoDTO> cursosJalados) {
		this.cursosJalados = cursosJalados;
	}

	public List<CursoCompuestoDTO> getCursosFaltantesPorLlevar() {
		return cursosFaltantesPorLlevar;
	}

	public void setCursosFaltantesPorLlevar(List<CursoCompuestoDTO> cursosFaltantesPorLlevar) {
		this.cursosFaltantesPorLlevar = cursosFaltantesPorLlevar;
	}

	public List<CursoCompuestoDTO> getCursosDelSigtCiclo() {
		return cursosDelSigtCiclo;
	}

	public void setCursosDelSigtCiclo(List<CursoCompuestoDTO> cursosDelSigtCiclo) {
		this.cursosDelSigtCiclo = cursosDelSigtCiclo;
	}

	public int getCantCurPerm() {
		return cantCurPerm;
	}

	public void setCantCurPerm(int cantCurPerm) {
		this.cantCurPerm = cantCurPerm;
	}

	public List<CursoCompuestoDTO> getCursosMatriculados() {
		System.out.println("getMatriculados");
		return cursosMatriculados;
	}

	public void setCursosMatriculados(List<CursoCompuestoDTO> cursosMatriculados) {
		this.cursosMatriculados = cursosMatriculados;
	}

	public int getBoton() {
		return boton;
	}

	public void setBoton(int boton) {
		this.boton = boton;
	}
	public List<CursoCompuestoDTO> getCursosJaladosDetalle() {
		return cursosJaladosDetalle;
	}

	public void setCursosJaladosDetalle(List<CursoCompuestoDTO> cursosJaladosDetalle) {
		this.cursosJaladosDetalle = cursosJaladosDetalle;
	}

	public List<CursoCompuestoDTO> getCursosRestantesDetalle() {
		return cursosRestantesDetalle;
	}

	public void setCursosRestantesDetalle(List<CursoCompuestoDTO> cursosRestantesDetalle) {
		this.cursosRestantesDetalle = cursosRestantesDetalle;
	}

	public List<CursoCompuestoDTO> getCursosSiguienteCiclo() {
		return cursosSiguienteCiclo;
	}

	public void setCursosSiguienteCiclo(List<CursoCompuestoDTO> cursosSiguienteCiclo) {
		this.cursosSiguienteCiclo = cursosSiguienteCiclo;
	}
	public int getId4save() {
		return id4save;
	}
	public void setId4save(int id4save) {
		this.id4save = id4save;
	}
}
