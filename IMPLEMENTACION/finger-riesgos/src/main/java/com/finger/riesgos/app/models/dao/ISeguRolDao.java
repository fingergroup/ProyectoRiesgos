package com.finger.riesgos.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.finger.riesgos.app.models.entity.SeguRol;


public interface ISeguRolDao extends CrudRepository<SeguRol, Long>{
	
	/**
	 * Busca el usuario por el Nombre
	 * @param nombreUsuario
	 * @return
	 */
	public SeguRol findByRolNombre(String nombreRol);

}
