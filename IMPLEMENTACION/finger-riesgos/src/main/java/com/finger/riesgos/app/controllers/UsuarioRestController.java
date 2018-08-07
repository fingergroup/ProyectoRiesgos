package com.finger.riesgos.app.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
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
import com.finger.riesgos.app.models.entity.SeguRol;
import com.finger.riesgos.app.models.entity.SeguUsuario;
import com.finger.riesgos.app.models.entity.SeguUsuarioRol;
import com.finger.riesgos.app.models.service.ISeguRolService;
import com.finger.riesgos.app.models.service.ISeguUsuarioRolService;



//@CrossOrigin(origins = { "http://localhost:4200" }) // Indica que solo puede acceder desde esta url
@RestController // IMPLEMENTA COMO UN API RES
@RequestMapping("/api") // URL DEL END
public class UsuarioRestController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private ISeguRolService rolService;
	
	@Autowired
	private ISeguUsuarioRolService usuarioRolService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;


	/**
	 * Metodo que permite la consulta de todos los usuarios
	 * @return
	 */
	@Secured({"ROLE_ADMIN","ROLE_USER"})
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

	/**
	 * Metodo que busca un usuario por id
	 * @param id
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	@GetMapping("/usuarios/{id}")// Se envi el id por parametro @PathVariable
	@ResponseStatus(HttpStatus.OK)// Responde el estado de correcto aunque este se asigna por defecto
	public SeguUsuarioDTO show(@PathVariable Long id) {
		return SeguUsuarioDTO.toDTO(this.usuarioService.findById(id));
	}

	/**
	 * Metodo que permite la creacion de usuarios
	 * @param usuario
	 * @return
	 */
	// Tipo post recibe el objeto cliente por parametro
	@Secured("ROLE_ADMIN")
	@PostMapping("/usuarios")// los datos bienen dentro de los datos de la peticion
	@ResponseStatus(HttpStatus.CREATED) // Responde el estatus de creado
	public SeguUsuario create(@RequestBody SeguUsuario usuario) {	
		String password = usuario.getUsuaClave();
		System.out.println(password);		
		String passEncript=passwordEncoder.encode(password);
		System.out.println(passEncript);
		usuario.setUsuaClave(passEncript);
		System.out.println(usuario.getUsuaClave());
		usuario.setFechaCreacion(new Date());
		usuario.setUsuarioCreacion("ADMIN");
		usuario.setUsuaEstado("A");
		this.usuarioService.save(usuario);
		// Buca el rol
		SeguRol rol=rolService.findByRolNombre("ROLE_ADMIN");
		// Guarda el rol con el usuario
		SeguUsuarioRol rolUsuario=new SeguUsuarioRol();
		rolUsuario.setSeguRol(rol);
		rolUsuario.setSeguUsuario(usuario);
		rolUsuario.setUsroEstado("A");
		this.usuarioRolService.save(rolUsuario);
		return usuario;
	}

	/**
	 * Metodo que permite la actualizacion de usuarios
	 * @param usuario
	 * @param id
	 * @return
	 */
	// Tipo Put la peticion, recibe el cliente que esta dentro del cuerpo del request
	// El id que se envia como variable
	@Secured("ROLE_ADMIN")
	@PutMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.CREATED)	
	public SeguUsuarioDTO update(@RequestBody SeguUsuario usuario, @PathVariable Long id) {
		SeguUsuario currentUsuario = this.usuarioService.findById(id);
		currentUsuario.setUsuaEmail(usuario.getUsuaEmail());
		currentUsuario.setUsuaClave(passwordEncoder.encode(usuario.getUsuaClave()));
		this.usuarioService.save(currentUsuario);
		return SeguUsuarioDTO.toDTO(currentUsuario);
	}

	/**
	 * Metodo que permite la eliminacion de usuarios
	 * @param id
	 */
	// Tipo delete
	@Secured("ROLE_ADMIN")
	@DeleteMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		SeguUsuario currentUsuario = this.usuarioService.findById(id);
		List<SeguUsuarioRol> listaRoles=currentUsuario.getSeguUsuarioRols();
		for(SeguUsuarioRol rl:listaRoles) {
			this.usuarioRolService.delete(rl);
		}
		this.usuarioService.delete(currentUsuario);
	}

}
