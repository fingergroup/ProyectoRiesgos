package com.finger.riesgos.app.models.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finger.riesgos.app.models.dao.ISeguUsuarioRolDao;
import com.finger.riesgos.app.models.entity.SeguUsuarioRol;

@Service
public class SeguUsuarioRolImpl implements ISeguUsuarioRolService {
	
	@Autowired
	private ISeguUsuarioRolDao usuarioRolDao;

	@Override
	public void save(SeguUsuarioRol us) {
		// TODO Auto-generated method stub
		usuarioRolDao.save(us);
		
	}

	@Override
	public SeguUsuarioRol findById(Long id) {
		// TODO Auto-generated method stub
		return usuarioRolDao.findById(id).orElse(null);
	}

	@Override
	public void delete(SeguUsuarioRol us) {
		// TODO Auto-generated method stub
		usuarioRolDao.delete(us);
	}

}
