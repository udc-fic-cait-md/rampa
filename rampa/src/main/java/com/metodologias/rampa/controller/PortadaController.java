package com.metodologias.rampa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * The Class PortadaController.
 */
@Controller
public class PortadaController {

    /**
     * Cargar portada.
     *
     * @return the model and view
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView cargarPortada() {

        ModelAndView modelo = new ModelAndView("portada");

        return modelo;
    }
}
