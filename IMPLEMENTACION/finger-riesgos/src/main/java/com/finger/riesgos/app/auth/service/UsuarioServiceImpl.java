package com.finger.riesgos.app.auth.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finger.riesgos.app.models.dao.IUsuarioDao;
import com.finger.riesgos.app.models.entity.SeguUsuario;


@Service
public class UsuarioServiceImpl implements  IUsuarioService{
	
	@Autowired
	private IUsuarioDao usuarioDao;

	@Override
	@Transactional(readOnly = true)
	public SeguUsuario findByNombreUsuario(String nombreUsuario) {
		// TODO Auto-generated method stub
		return usuarioDao.findByNombreUsuario(nombreUsuario);
	}

	@Override
	public List<SeguUsuario> findAll() {
		// TODO Auto-generated method stub
		return (List<SeguUsuario>) usuarioDao.findAll();
	}

	@Override
	public void save(SeguUsuario cliente) {
		// TODO Auto-generated method stub
		usuarioDao.save(cliente);
		
	}

	@Override
	public SeguUsuario findById(Long id) {
		// TODO Auto-generated method stub
		return usuarioDao.findById(id).orElse(null);
	}

	@Override
	public void delete(SeguUsuario cliente) {
		// TODO Auto-generated method stub
		usuarioDao.delete(cliente);
		
	}

}
