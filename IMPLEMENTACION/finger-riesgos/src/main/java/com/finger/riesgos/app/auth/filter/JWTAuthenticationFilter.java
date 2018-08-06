package com.finger.riesgos.app.auth.filter;

import java.io.IOException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finger.riesgos.app.auth.service.IUsuarioService;
import com.finger.riesgos.app.auth.service.JWTService;
import com.finger.riesgos.app.auth.service.JWTServiceImpl;
import com.finger.riesgos.app.models.dao.IItemMenuDao;
import com.finger.riesgos.app.models.dao.IUsuarioDao;
import com.finger.riesgos.app.models.dto.SeguUsuarioDTO;
import com.finger.riesgos.app.models.entity.SeguItem;
import com.finger.riesgos.app.models.entity.SeguUsuario;
import com.finger.riesgos.app.models.service.IClienteService;
import com.finger.riesgos.app.models.service.IMenuService;




// hereda de UsernamePasswordAuthenticationFilter que es parte de spring
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	private AuthenticationManager authenticationManager;
	
	private JWTService jwtService;
	
	@Autowired
	private IMenuService menuService;
	
	/**
	 * Filtro de apoyo al filtro de autenticacion
	 * @param authenticationManager
	 */
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JWTService jwtService) {

		this.authenticationManager = authenticationManager;
		// Indica la ruta de acceso al login
		setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/api/login", "POST"));
		this.jwtService = jwtService;
	}

	/**
	 * Metodo que permite realizar la autenticacion e sun filtro
	 */
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		// Optiene el nombre del nombre de la variable de la peticion post del postman
		// es decir si se envia por variable los datos de peticion
		String username = obtainUsername(request); 
		String password = obtainPassword(request);
		
		if(username != null && password !=null) {
			logger.info("Username desde request parameter (form-data): " + username);
			logger.info("Password desde request parameter (form-data): " + password);
			
		} else { // Entra por aca por que se envia un raw o json
			SeguUsuario user = null;
			try {
				// request.getInputStream() aca esta el json del login
				// castea el json a la entidad
				user = new ObjectMapper().readValue(request.getInputStream(), SeguUsuario.class);
				
				username = user.getNombreUsuario();
				password = user.getUsuaClave();
				
				logger.info("Username desde request InputStream (raw) o json: " + username);
				logger.info("Password desde request InputStream (raw) o json: " + password);
				
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		username = username.trim();		
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);		
		return authenticationManager.authenticate(authToken);
	}

	/**
	 * Metodo que se llama cuando autentica correctamente lo ejecuta directamente spring
	 */
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		//List<SeguItem> menus=menuService.getItemsByUsuario("JROJAS");
		
		// Valida que exista el user name en la tabla de usuarios
		String token = jwtService.create(authResult);
		// Se pone en la respuesta de Autorization
		response.addHeader(JWTServiceImpl.HEADER_STRING, JWTServiceImpl.TOKEN_PREFIX + token);
		// Generamos un map , para pasar varios datos al body de la respuesta
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("token", token); // Se envia el token al body
		body.put("user", (User) authResult.getPrincipal()); // Se envia el usuario		
		body.put("token", token); // Se envia el token al body
		// se envia mensaje de aca
		//body.put("menus", menus); 
		// Escribe el body en la respuesta, en una estructura json
		// new ObjectMapper().writeValueAsString(body) // pasa a json el dato
		response.getWriter().write(new ObjectMapper().writeValueAsString(body));
		// Se envia el status 200 ok
		response.setStatus(HttpServletResponse.SC_OK);
		// Se responde en json
		response.setContentType("application/json");
	}

	/**
	 * Mteodo que se ejecuta cuando no se autentica correctamente
	 */
	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {

		// Se reduce la respuesta que se envia en el body de la contrasnia
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("mensaje", "Error de autenticación: Usuarió o password incorrecto!");
		// Se envia el mensaje de error que genera spring
		body.put("error", failed.getMessage());		
		response.getWriter().write(new ObjectMapper().writeValueAsString(body));
		// Se envia el status 201 No Autorizado
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // No autorizado
		response.setContentType("application/json");
	}

}
