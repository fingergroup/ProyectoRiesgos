package com.finger.riesgos.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.finger.riesgos.app.auth.filter.JWTAuthenticationFilter;
import com.finger.riesgos.app.auth.filter.JWTAuthorizationFilter;
import com.finger.riesgos.app.auth.service.JWTService;
import com.finger.riesgos.app.models.service.JpaUserDetailsService;

/**
 * Clase Configuracion que establece la configuracion inicial de spring securiti
 * @author julian
 *
 */
@EnableGlobalMethodSecurity(securedEnabled=true, prePostEnabled=true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	
	@Autowired
	private JpaUserDetailsService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private JWTService jwtService;
	
	/**
	 * Metodo que realiza la configuracon del inicio de sesion
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// Establece las rutas publicas del aplicativo
		http.authorizeRequests().antMatchers("/", "/css/**", "/js/**", "/images/**", "/listar**", "/locale").permitAll()
		.anyRequest().authenticated()
		.and()
		.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtService))//  Adiciona el filtro de loguin
		.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtService))// Adiciona el filtro de autorizacion
		.csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	}

	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception
	{
		build.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder);

	}
}
