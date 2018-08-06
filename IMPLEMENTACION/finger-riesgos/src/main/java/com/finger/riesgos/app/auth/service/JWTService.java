package com.finger.riesgos.app.auth.service;

import java.io.IOException;
import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import io.jsonwebtoken.Claims;

/**
 * Establece el comportamiento de las clases a crear
 * @author julian
 *
 */
public interface JWTService {
	
	/**
	 * Metodo que crea el token
	 */
	public String create(Authentication auth) throws IOException;
	/**
	 * Metodo que realiza la validacion edl Token
	 * @param token
	 * @return
	 */
	public boolean validate(String token);
	/**
	 * Metodo que obtiene la descripcion del token
	 * @param token
	 * @return
	 */
	public Claims getClaims(String token);
	/**
	 * Metodo que optiene el nombre que esta en el token
	 * @param token
	 * @return
	 */
	public String getUsername(String token);
	/**
	 * Metodo que optiene los roles que estan e n el token
	 * @param token
	 * @return
	 */
	public Collection<? extends GrantedAuthority> getRoles(String token) throws IOException;
	/**
	 * Metodo que valida el token
	 * @param token
	 * @return
	 */
	public String resolve(String token);

}
