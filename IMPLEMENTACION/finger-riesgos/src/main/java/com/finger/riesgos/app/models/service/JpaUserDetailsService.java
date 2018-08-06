package com.finger.riesgos.app.models.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finger.riesgos.app.models.dao.IUsuarioDao;
import com.finger.riesgos.app.models.entity.SeguUsuario;
import com.finger.riesgos.app.models.entity.SeguUsuarioRol;


@Service("jpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService{

	@Autowired
	private IUsuarioDao usuarioDao;
	
	private Logger logger = LoggerFactory.getLogger(JpaUserDetailsService.class);
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// Valida que exista el user name en la tabla de usuarios
        SeguUsuario usuario = usuarioDao.findByNombreUsuario(username);
        if(usuario == null) {
        	logger.error("Error en el Login: no existe el usuario '" + username + "' en el sistema!");
        	throw new UsernameNotFoundException("Username: " + username + " no existe en el sistema!");
        }
        
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        
        for(SeguUsuarioRol role: usuario.getSeguUsuarioRols()) {
        	logger.info("Role: ".concat(role.getSeguRol().getRolNombre()));
        	authorities.add(new SimpleGrantedAuthority(role.getSeguRol().getRolNombre()));
        }
        
        if(authorities.isEmpty()) {
        	logger.error("Error en el Login: Usuario '" + username + "' no tiene roles asignados!");
        	throw new UsernameNotFoundException("Error en el Login: usuario '" + username + "' no tiene roles asignados!");
        }
        
		return new User(usuario.getNombreUsuario(),usuario.getUsuaClave(), true, true, true, true, authorities);
	}

}
