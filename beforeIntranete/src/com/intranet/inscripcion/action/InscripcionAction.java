package com.intranet.inscripcion.action;

import java.util.Calendar;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;

import com.intranet.bean.CursoCompuestoDTO;
import com.intranet.bean.HorarioDTO;
import com.intranet.bean.UsuarioDTO;
import com.intranet.inscripcion.dao.InscripcionDAO;

public class InscripcionAction implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private ScheduleModel eventModel= new DefaultScheduleModel(); 
	private InscripcionDAO inscripcionDao=new InscripcionDAO();
	private List<CursoCompuestoDTO> cursosJalados;
	private List<CursoCompuestoDTO> cursosFaltantesPorLlevar;
	private List<CursoCompuestoDTO> cursosDelSigtCiclo;
	private int cantCurPerm;
	private List<CursoCompuestoDTO> cursosMatriculados;
	
	public void executeDialog(ActionEvent e){
		CursoCompuestoDTO cc=new CursoCompuestoDTO();
		cc.setIdCursoCompuesto((int)e.getComponent().getAttributes().get("pcurso"));
		
		//Jalamos y cargamos el objeto usuario, logueado en la sesion
		FacesContext ctx=FacesContext.getCurrentInstance();
		UsuarioDTO usuario=(UsuarioDTO)ctx.getExternalContext().getSessionMap().get("s_usuario");
		
		List<HorarioDTO> listaDeHorario=obtenerHorarioAlumno(usuario);
		listaDeHorario.addAll(inscripcionDao.getHorarioPorCurso(usuario, cc));
		
		for(HorarioDTO horarioFor : listaDeHorario){
			
			Calendar c = Calendar.getInstance();
			c.setTime(horarioFor.getHoraIniciio());
			Calendar c2 = Calendar.getInstance();
			c2.setTime(horarioFor.getHoraFin());

			switch (horarioFor.getDescHorario()) {
			case "MARTES": 
				c.set(Calendar.DATE, c2.get(Calendar.DATE) + 1);
				c2.set(Calendar.DATE, c2.get(Calendar.DATE) + 1);break;
			default:
				break;
			}
			horarioFor.setHoraIniciio(c.getTime());
			horarioFor.setHoraFin(c2.getTime());

			eventModel.addEvent(new DefaultScheduleEvent("Desc",horarioFor.getHoraIniciio(),horarioFor.getHoraFin()));

		}

        RequestContext.getCurrentInstance().openDialog("HorarioMatricula");
	}
	
	public ScheduleModel getEventModel() {
		return eventModel;
	}

	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}
	
//	private Calendar today() {
//		Calendar calendar = Calendar.getInstance();
//		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 16, 0, 0, 0);
//
//		return calendar;
//	}

	public String preCargar(){
		String result="success";
		//Jalamos y cargamos el objeto usuario, logueado en la sesion
		FacesContext ctx=FacesContext.getCurrentInstance();
		UsuarioDTO usuario=(UsuarioDTO)ctx.getExternalContext().getSessionMap().get("s_usuario");
		//Recursos de inscripcionDao
		cursosParaMatricula(usuario);
//		cursosMatriculados=obtenerCursoMatriculado(usuario);

		return result;
	}
	
	//Es para la img mini horario
	private List<HorarioDTO> obtenerHorarioAlumno(UsuarioDTO usuario){
		List<HorarioDTO> horarioPrev=inscripcionDao.getHorarioAlumno(usuario);
		return horarioPrev;
	}
	
	//Para el Panel
	private void cursosParaMatricula(UsuarioDTO usuario){

		//Llenando los cursos que puede llevar el alumno
		cursosJalados=inscripcionDao.getCursosJalados(usuario);
		cursosFaltantesPorLlevar=inscripcionDao.getCursosRestantes(usuario);

		//Valores necesario para la formula
		int cantcurFalt4p=inscripcionDao.getCantidadDeCursosRestantes4Parameter(usuario);
		cantCurPerm=inscripcionDao.getCantidadDeCursosQuePuedeLlevar(usuario);

		boolean siguienteCiclo=(cursosJalados.size()+cantcurFalt4p)<cantCurPerm? true:false;

		if(siguienteCiclo){
			cursosDelSigtCiclo=inscripcionDao.getCursosSiguientes(usuario);
		}
	}
	
	private List<CursoCompuestoDTO> obtenerCursoMatriculado(UsuarioDTO usuario){
		List<CursoCompuestoDTO> cursocompuesto=inscripcionDao.getCursosRecienteMatriculado(usuario);
		return cursocompuesto;
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
		return cursosMatriculados;
	}

	public void setCursosMatriculados(List<CursoCompuestoDTO> cursosMatriculados) {
		this.cursosMatriculados = cursosMatriculados;
	}

}
