package com.finger.riesgos.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.finger.riesgos.app.models.entity.SeguUsuario;


public interface IUsuarioDao extends CrudRepository<SeguUsuario, Long>{

	public SeguUsuario findByNombreUsuario(String nombreUsuario);
}
