package com.finger.riesgos.app.auth.service;

import java.util.List;

import com.finger.riesgos.app.models.entity.SeguUsuario;

public interface IUsuarioService {
	
	public SeguUsuario findByNombreUsuario(String nombreUsuario);
	
	public List<SeguUsuario> findAll();
	
	public void save(SeguUsuario cliente);
	
	public SeguUsuario findById(Long id);
	
	public void delete(SeguUsuario cliente);

}
