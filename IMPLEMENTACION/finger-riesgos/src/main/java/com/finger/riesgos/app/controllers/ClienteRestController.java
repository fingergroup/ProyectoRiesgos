package com.finger.riesgos.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.finger.riesgos.app.models.entity.SeguUsuario;
import com.finger.riesgos.app.models.service.IClienteService;



@RestController // Permite que sea una clase de controlador solo con respuestas rest es decir json o xml
@RequestMapping("/api/clientes") // Ruta de acceso al controlador REST
public class ClienteRestController {
	
	@Autowired
	private IClienteService clienteService;
	
	// SOlo tiene acceso el rol admin
	@Secured("ROLE_ADMIN")
	@GetMapping(value = "/listar")
	public List<SeguUsuario> listar() {
		return clienteService.findAll();
	}
	

}
