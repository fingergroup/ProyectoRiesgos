package com.finger.riesgos.app.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.finger.riesgos.app.auth.service.IUsuarioService;
import com.finger.riesgos.app.models.dto.SeguUsuarioDTO;
import com.finger.riesgos.app.models.entity.SeguUsuario;


//@CrossOrigin(origins = { "http://localhost:4200" }) // Indica que solo puede acceder desde esta url
@RestController // IMPLEMENTA COMO UN API RES
@RequestMapping("/api") // URL DEL END
public class UsuarioRestController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	// Tipo get
	@GetMapping("/usuarios") // Mapeo de la url de tipo Get
	@ResponseStatus(HttpStatus.OK)// Responde el estado de correcto
	public List<SeguUsuarioDTO> index() {
		
		List<SeguUsuario> ls=usuarioService.findAll();
		List<SeguUsuarioDTO> lst=new ArrayList<>();
		for(SeguUsuario us:ls) {
			lst.add(SeguUsuarioDTO.toDTO(us));
		}
		return lst;
	}

	@GetMapping("/usuarios/{id}")// Se envi el id por parametro @PathVariable
	@ResponseStatus(HttpStatus.OK)// Responde el estado de correcto aunque este se asigna por defecto
	public SeguUsuarioDTO show(@PathVariable Long id) {
		return SeguUsuarioDTO.toDTO(this.usuarioService.findById(id));
	}

	// Tipo post recibe el objeto cliente por parametro
	@PostMapping("/usuarios")// los datos bienen dentro de los datos de la peticion
	@ResponseStatus(HttpStatus.CREATED) // Responde el estatus de creado
	public SeguUsuario create(@RequestBody SeguUsuario usuario) {		
		usuario.setUsuaClave(passwordEncoder.encode(usuario.getUsuaClave()));
		usuario.setFechaCreacion(new Date());
		usuario.setUsuarioCreacion("ADMIN");
		usuario.setUsuaEstado("A");
		this.usuarioService.save(usuario);
		return usuario;
	}

	// Tipo Put la peticion, recibe el cliente que esta dentro del cuerpo del request
	// El id que se envia como variable
	@PutMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.CREATED)	
	public SeguUsuarioDTO update(@RequestBody SeguUsuario usuario, @PathVariable Long id) {
		SeguUsuario currentUsuario = this.usuarioService.findById(id);
		currentUsuario.setUsuaEmail(usuario.getUsuaEmail());
		currentUsuario.setUsuaClave(passwordEncoder.encode(usuario.getUsuaClave()));
		this.usuarioService.save(currentUsuario);
		return SeguUsuarioDTO.toDTO(currentUsuario);
	}

	// Tipo delete
	@DeleteMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		SeguUsuario currentUsuario = this.usuarioService.findById(id);
		this.usuarioService.delete(currentUsuario);
	}

}
