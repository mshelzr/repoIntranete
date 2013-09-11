package com.intranet.seguridad.action;

import java.util.Map;

import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.intranet.bean.UsuarioDTO;
import com.intranet.seguridad.dao.UsuarioDAO;

public class LoginAction {
	
//	private static final long serialVersionUID = 1L;
	private UsuarioDTO usuario;
	private String user;
	private String pwd;

	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public UsuarioDTO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	public String execute(){
		//Modificando s
//		System.out.println(usuario.getUser());
		UsuarioDAO usuarioDao=new UsuarioDAO();
//		PerfilDAO perfilDao=new PerfilDAO();
		
//		usuario=usuarioDao.validarUsuario(usuario);
//		usuario=new UsuarioDTO();
//		usuario.setUser("alu");
//		FacesContext fc=FacesContext.getCurrentInstance();
//		UsuarioDTO u=(UsuarioDTO)fc.getExternalContext().getSessionMap().get("usuario");
//		System.out.println(u.getUser());
//		PerfilDTO perfil2=perfilDao.buscarPerfil(usuario2);
//		FacesContext fcx=FacesContext.getCurrentInstance();
//		fcx.getExternalContext().getSessionMap().put("usuario", usuario);
//		if(usuario!=null){
			setUser("Juanon");
//			Logger.getLogger(LoginAction.class).info("Usuario!=null");
//			System.out.println(usuario.getUser());
			return "success";
//		}
//		return "error";
	}


}
