package com.intranet.nota.action;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.intranet.bean.Detalle_cursoSeccion;
import com.intranet.bean.Inscripcion;
import com.intranet.nota.bean.NotaWithPorcentaje;
import com.intranet.nota.service.NotaService;
import com.intranet.nota.service.NotaService_I;
import com.opensymphony.xwork2.ActionSupport;

public class CerrarSemestreAction extends ActionSupport implements SessionAware{

//	private List<Inscripcion> listaInscripciones;
	
	public String execute(){
		return SUCCESS;
	}
	
	public String mCierreDeSemestre(){
		NotaService_I notaService=new NotaService();
		List<Inscripcion> listaInscripciones=notaService.buscarInscripcionesDelSemestre();
		//Itera en la lista de las inscripciones
		for(Inscripcion inscripcion:listaInscripciones){
			int cantidadSupres=notaService.buscarCantidadDeCursosDelSemestre(inscripcion);
			double cantidadGeneral=0;
			List<Detalle_cursoSeccion> ldcs=notaService.buscarCursosDelAlumno(inscripcion);	
			//itera cada curso
			for(Detalle_cursoSeccion curso :ldcs){
				List<NotaWithPorcentaje> lnwp=notaService.buscarNotasDelCursoAlumno(inscripcion, curso);
				double notaSupres=0;
				//itera cada nota
				for(NotaWithPorcentaje notaXporcentaje: lnwp){
					notaSupres+=notaXporcentaje.getVnota()*notaXporcentaje.getPesoNota();
					cantidadGeneral+=notaSupres;
				}
				String notaSupresString=Double.toString(notaSupres);
				notaService.rsIngresarPromedioDelCursoDelSemestre(inscripcion, curso, notaSupresString);
			
			}
			double notaGeneral=cantidadGeneral/cantidadSupres;
			DecimalFormat df=new DecimalFormat("0.00");
			String notaGeneralString=df.format(notaGeneral);
			notaGeneralString=notaGeneralString.replace(',','.');
			notaService.rsIngresarPromedioGnralDelSemestre(inscripcion, notaGeneralString);
		
		}
		
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
	}
}
