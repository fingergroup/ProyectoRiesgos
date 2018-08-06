package com.finger.riesgos.app.auth.handler;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.FlashMap;

import org.springframework.web.servlet.support.SessionFlashMapManager;

/**
 * Componente personalizado que permite retonar la respuesta en el momento de loguearse
 * @author julian
 *
 */
@Component
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		SessionFlashMapManager flashMapManager = new SessionFlashMapManager();
		FlashMap flashMap = new FlashMap();
		String mensaje = "LOgin correcto por "+authentication.getName();		
		flashMap.put("success", mensaje);
		flashMapManager.saveOutputFlashMap(flashMap, request, response);		
		if(authentication != null) {
			logger.info(mensaje);
		}		
		super.onAuthenticationSuccess(request, response, authentication);
	}

	
}
