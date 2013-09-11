package com.intranet.seguridad.action;

import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.intranet.bean.UsuarioDTO;
import com.intranet.seguridad.dao.UsuarioDAO;

public class LoginAction {

	private UsuarioDTO usuario;

	public UsuarioDTO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	public String execute(){
		//Modificando
		UsuarioDAO usuarioDao=new UsuarioDAO();
//		PerfilDAO perfilDao=new PerfilDAO();
		
		UsuarioDTO usuarioValido=usuarioDao.validarUsuario(usuario);
		FacesContext fc=FacesContext.getCurrentInstance();
		fc.getExternalContext().getSessionMap().put("usuario",usuario);
		
		if(usuarioValido!=null){
			Logger.getLogger(LoginAction.class).info("Usuario!=null");
			return "success";
		}
		return "error";
	}


}
