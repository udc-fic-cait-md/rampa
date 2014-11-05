package com.metodoloxias.rampa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/socios")
public class SociosController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView cargarListadoSocios() {
		
		ModelAndView modelo = new ModelAndView("socios/socios");
		
	    return modelo;
	}
	
	@RequestMapping(value = "/alta", method = RequestMethod.GET)
	public ModelAndView cargarAltaSocio() {
		
		ModelAndView modelo = new ModelAndView("socios/alta_socio");
		
	    return modelo;
	}
	
	@RequestMapping(value = "/perfil/{idSocio}", method = RequestMethod.GET)
	public ModelAndView cargarPerfilSocio(@PathVariable("idSocio") Integer idSocio) {
		
		ModelAndView modelo = new ModelAndView("socios/ficha_socio");
		
		// modelo.addObject("idSocio", idSocio);
		
	    return modelo;
	}
}
