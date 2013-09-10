package com.intranet.asistencia.action;

import java.util.List;
import java.util.Map;

import com.intranet.asistencia.bean.AsistenciaResumen;
import com.intranet.asistencia.service.AsistenciaService;
import com.intranet.asistencia.service.AsistenciaService_I;
import com.intranet.bean.Usuario;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CursosAsistenciaAction extends ActionSupport{
	private List<AsistenciaResumen> listaAsistenciaResumen;
	
	public List<AsistenciaResumen> getListaAsistenciaResumen() {
		return listaAsistenciaResumen;
	}

	public String execute(){
		Map<String,Object> sesion=ActionContext.getContext().getSession();
		Usuario user=((Usuario)sesion.get("a_usuario"));
		
		AsistenciaService_I asistenciaService=new AsistenciaService();
		listaAsistenciaResumen=asistenciaService.listarCursosResumenido(user);		
//		for(AsistenciaResumen ss: listaAsistenciaResumen){
//			System.out.println(ss.getIdCurso()+"\t"+ss.getDescCurso()+"\t"+ss.getCantAsistencias());
//			}
			return "exito";
	}
}