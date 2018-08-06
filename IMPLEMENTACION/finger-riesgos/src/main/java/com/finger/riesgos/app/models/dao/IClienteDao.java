package com.finger.riesgos.app.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


import com.finger.riesgos.app.models.entity.SeguUsuario;

public interface IClienteDao extends PagingAndSortingRepository<SeguUsuario, Long> {


}
