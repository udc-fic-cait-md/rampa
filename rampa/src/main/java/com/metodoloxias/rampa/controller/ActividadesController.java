package com.metodoloxias.rampa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/actividades")
public class ActividadesController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView cargarListadoActividades() {
		
		ModelAndView modelo = new ModelAndView("actividades/actividades");
		
	    return modelo;
	}
	
	@RequestMapping(value = "/alta", method = RequestMethod.GET)
	public ModelAndView cargarAltaActividad() {
		
		ModelAndView modelo = new ModelAndView("actividades/alta_actividad");
		
	    return modelo;
	}
	
	@RequestMapping(value = "/actividad/{idActividad}", method = RequestMethod.GET)
	public ModelAndView cargarPerfilActividad(@PathVariable("idActividad") Integer idSocio) {
		
		ModelAndView modelo = new ModelAndView("actividades/ficha_actividad");
		
		// modelo.addObject("idSocio", idSocio);
		
	    return modelo;
	}
	
	@RequestMapping(value = "/actividad/{idActividad}/inscripciones/alta", method = RequestMethod.GET)
	public ModelAndView cargarAltaInscripcion() {
		
		ModelAndView modelo = new ModelAndView("actividades/alta_inscripcion");
		
	    return modelo;
	}
	
	@RequestMapping(value = "/actividad/{idActividad}/inscripciones", method = RequestMethod.GET)
	public ModelAndView cargarInscripcionesActividad(@PathVariable("idActividad") Integer idSocio) {
		
		ModelAndView modelo = new ModelAndView("actividades/inscripciones_actividad");
		
		// modelo.addObject("idSocio", idSocio);
		
	    return modelo;
	}
}
