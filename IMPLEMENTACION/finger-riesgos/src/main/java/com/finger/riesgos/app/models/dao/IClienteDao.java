package com.finger.riesgos.app.models.dao;


import org.springframework.data.repository.CrudRepository;



import com.finger.riesgos.app.models.entity.SeguUsuario;
/**
 * Inteface para la gestion de Seguridad de Usuario
 * @author julian
 *
 */
public interface IClienteDao extends CrudRepository<SeguUsuario, Long> {


}
