package com.finger.riesgos.app.models.dto;

import com.finger.riesgos.app.models.entity.SeguRol;

public class SeguRolDTO {
	
	
	private Long rolId;
	private String rolNombre;
	private String rolDescripcion;	
	private String rolEstado;
	
	public static SeguRolDTO toDTO(SeguRol rl) {
		SeguRolDTO dto=new SeguRolDTO();
		dto.setRolDescripcion(rl.getRolDescripcion());
		dto.setRolEstado(rl.getRolEstado());
		dto.setRolId(rl.getRolId());
		dto.setRolNombre(rl.getRolNombre());
		return dto;
		
	}
	public final Long getRolId() {
		return rolId;
	}
	public final void setRolId(Long rolId) {
		this.rolId = rolId;
	}
	public final String getRolNombre() {
		return rolNombre;
	}
	public final void setRolNombre(String rolNombre) {
		this.rolNombre = rolNombre;
	}
	public final String getRolDescripcion() {
		return rolDescripcion;
	}
	public final void setRolDescripcion(String rolDescripcion) {
		this.rolDescripcion = rolDescripcion;
	}
	public final String getRolEstado() {
		return rolEstado;
	}
	public final void setRolEstado(String rolEstado) {
		this.rolEstado = rolEstado;
	}
	

}
