package com.intranet.seguridad.action;

import java.util.Map;

import org.apache.log4j.Logger;

import com.intranet.bean.PerfilDTO;
import com.intranet.bean.UsuarioDTO;
import com.intranet.seguridad.dao.UsuarioDAO;

public class LoginAction {
	
//	private static final long serialVersionUID = 1L;
	private UsuarioDTO usuario;
	private PerfilDTO perfil;
	private Map<String,Object> sesion;
	private String mensaje="Sal pe";

	public UsuarioDTO getUsuarioDTO() {
		return usuario;
	}
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	public PerfilDTO getPerfilDTO() {
		return perfil;
	}
	public void setPerfil(PerfilDTO perfil) {
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
		UsuarioDAO usuarioDao=new UsuarioDAO();
//		PerfilDAO perfilDao=new PerfilDAO();
		
		UsuarioDTO usuario2=usuarioDao.validarUsuario(usuario);
//		PerfilDTO perfil2=perfilDao.buscarPerfil(usuario2);
		
		if(usuario2!=null){
			
			sesion.put("s_usuario", usuario2);
			Logger.getLogger(LoginAction.class).info("Usuario!=null");
			return "success";
		}
		return "error";
	}


}
