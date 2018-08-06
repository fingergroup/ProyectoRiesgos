package com.finger.riesgos.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.finger.riesgos.app.models.entity.SeguUsuario;


public interface IUsuarioDao extends CrudRepository<SeguUsuario, Long>{

	/**
	 * Busca el usuario por el Nombre
	 * @param nombreUsuario
	 * @return
	 */
	public SeguUsuario findByNombreUsuario(String nombreUsuario);
}
