package com.finger.riesgos.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.finger.riesgos.app.models.dao.ISeguRolDao;
import com.finger.riesgos.app.models.entity.SeguRol;

@Service
public class SeguRolServiceImpl implements ISeguRolService {
	
	@Autowired
	private ISeguRolDao rolDao;

	@Override
	public List<SeguRol> findAll() {
		// TODO Auto-generated method stub
		return (List<SeguRol>) rolDao.findAll();
	}

	@Override
	public SeguRol findByRolNombre(String nombreRol) {
		// TODO Auto-generated method stub
		return rolDao.findByRolNombre(nombreRol);
	}

}
