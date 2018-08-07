package com.finger.riesgos.app.models.service;


import com.finger.riesgos.app.models.entity.SeguUsuarioRol;

public interface ISeguUsuarioRolService {
	
	public void save(SeguUsuarioRol us);
	
	public SeguUsuarioRol findById(Long id);
	
	public void delete(SeguUsuarioRol us);

}
