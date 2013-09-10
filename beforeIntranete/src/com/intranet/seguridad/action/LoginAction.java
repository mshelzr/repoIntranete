package com.intranet.seguridad.action;

import java.util.Map;

import com.intranet.bean.Perfil;
import com.intranet.bean.Usuario;
import com.intranet.seguridad.service.PerfilService;
import com.intranet.seguridad.service.PerfilService_I;
import com.intranet.seguridad.service.UsuarioService;
import com.intranet.seguridad.service.UsuarioService_I;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private Usuario usuario;
	private Perfil perfil;
	private Map<String,Object> sesion;
	private String mensaje="Sal pe";
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	public Map<String, Object> getSesion() {
		return sesion;
	}
	public void setSesion(Map<String, Object> sesion) {
		this.sesion = sesion;
	}
	public String getMensaje() {
		return mensaje;
	}
	public String execute(){
		//Modificando s
		UsuarioService_I uservice=new UsuarioService();
		PerfilService_I pservice=new PerfilService();
		
		Usuario usuario2=new Usuario();
		Perfil perfil2=new Perfil();
		try {
			usuario2=uservice.buscarUsuario(usuario);
			perfil2=pservice.obtenerPerfil(usuario2);
			if(usuario2!=null){
				
			sesion=ActionContext.getContext().getSession();
			sesion.put("a_usuario", usuario2);
				
				if(perfil2.getIdPerfil()==1)
					return "alumno";
				else if(perfil2.getIdPerfil()==2)
					return "profesor";
				else if(perfil2.getIdPerfil()==3)
					return "secretaria";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}


}
