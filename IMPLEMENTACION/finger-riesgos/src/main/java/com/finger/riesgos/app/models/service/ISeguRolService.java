package com.finger.riesgos.app.models.service;

import java.util.List;

import com.finger.riesgos.app.models.entity.SeguRol;

public interface ISeguRolService {
	
	public List<SeguRol> findAll();
	
	public SeguRol findByRolNombre(String nombreRol);

}
