package com.metodologias.rampa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.metodologias.rampa.service.InscripcionService;

/**
 * The Class InscripcionesController.
 */
@Controller
@RequestMapping(value = "/inscripciones")
public class InscripcionesController {

	/** The inscripcion service. */
    @Autowired
    private InscripcionService inscripcionService;
	
	
	/**
     * Cargar listado Inscripciones.
     *
     * @return the model and view
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView cargarListadoInscripciones() {

        ModelAndView modelo = new ModelAndView("inscripciones/inscripciones");
        modelo.addObject("listaInscripciones", this.inscripcionService.findAll());
        
        return modelo;
    }
}
