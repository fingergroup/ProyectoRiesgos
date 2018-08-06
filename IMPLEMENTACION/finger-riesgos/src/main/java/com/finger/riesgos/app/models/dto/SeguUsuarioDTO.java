package com.finger.riesgos.app.models.dto;

import java.io.Serializable;

import com.finger.riesgos.app.models.entity.SeguUsuario;


public class SeguUsuarioDTO implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String usuaAlias;
	private String usuaEmail;	
	private String nombreUsuario;
	
	public static SeguUsuarioDTO toDTO(SeguUsuario us) {
		SeguUsuarioDTO dto=new SeguUsuarioDTO();
		dto.setUsuaAlias(us.getUsuaAlias());
		dto.setUsuaEmail(us.getUsuaEmail());
		dto.setNombreUsuario(us.getNombreUsuario());		
		return  dto;
	}
	
	

	public final String getUsuaAlias() {
		return usuaAlias;
	}
	public final void setUsuaAlias(String usuaAlias) {
		this.usuaAlias = usuaAlias;
	}
	public final String getUsuaEmail() {
		return usuaEmail;
	}
	public final void setUsuaEmail(String usuaEmail) {
		this.usuaEmail = usuaEmail;
	}
	public final String getNombreUsuario() {
		return nombreUsuario;
	}
	public final void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

}
