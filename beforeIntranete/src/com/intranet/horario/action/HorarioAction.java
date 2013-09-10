package com.intranet.horario.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.intranet.bean.Horario;
import com.intranet.bean.Usuario;
import com.intranet.horario.service.HorarioService;
import com.intranet.horario.service.HorarioService_I;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class HorarioAction extends ActionSupport {

	private List<Horario> listaHorarioA;
	
	public List<Horario> getListaHorarioA() {
		return listaHorarioA;
	}

	public String execute(){
		Map<String, Object> sesion=new HashMap<String, Object>();
		sesion=ActionContext.getContext().getSession();
		Usuario usiO=(Usuario)sesion.get("a_usuario");
		
		HorarioService_I horarioservice=new HorarioService();
		listaHorarioA=horarioservice.buscarHorario(usiO);
		return "exito";
	}
	
}
