package com.metodoloxias.rampa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PortadaController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView cargarPortada() {
		
		ModelAndView modelo = new ModelAndView("portada");
		
	    return modelo;
	}
}
