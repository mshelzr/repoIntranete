package com.intranet.seguridad.action;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

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
		UsuarioDAO usuarioDao=new UsuarioDAO();
		
		UsuarioDTO usuarioValido=usuarioDao.validarUsuario(usuario);
		
		if(usuarioValido!=null){
			FacesContext fc=FacesContext.getCurrentInstance();
			fc.getExternalContext().getSessionMap().put("s_usuario",usuario);
			
			return "success";
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Logueo de usuario", "Cuenta incorrecta"));
		return "error";
	}


}
