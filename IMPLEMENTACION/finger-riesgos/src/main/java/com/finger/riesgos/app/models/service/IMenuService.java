package com.finger.riesgos.app.models.service;

import java.util.List;

import com.finger.riesgos.app.models.entity.SeguItem;

public interface IMenuService {
	
	public List<SeguItem> getItemsByUsuario(String userName);

}
