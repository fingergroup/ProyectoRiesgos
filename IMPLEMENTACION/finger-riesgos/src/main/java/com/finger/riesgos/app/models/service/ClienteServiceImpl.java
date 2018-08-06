package com.finger.riesgos.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.finger.riesgos.app.models.dao.IClienteDao;
import com.finger.riesgos.app.models.entity.SeguUsuario;


@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteDao clienteDao;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<SeguUsuario> findAll() {
		// TODO Auto-generated method stub
		return (List<SeguUsuario>) clienteDao.findAll();
	}	
}
