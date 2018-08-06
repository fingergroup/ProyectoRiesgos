package com.finger.riesgos.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.finger.riesgos.app.models.dao.IItemMenuDao;
import com.finger.riesgos.app.models.entity.SeguItem;

@Service
public class MenuServiceImpl implements IMenuService {
	
	@Autowired
	private IItemMenuDao menuDao;

	@Override
	@Transactional(readOnly = true)
	public List<SeguItem> getItemsByUsuario(String userName) {
		// TODO Auto-generated method stub
		return menuDao.getItemsByUsuario(userName);
	}

}
