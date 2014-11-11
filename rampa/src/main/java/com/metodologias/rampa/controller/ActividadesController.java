package com.metodologias.rampa.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.metodologias.rampa.model.Actividad;

@Controller
@RequestMapping(value = "/actividades")
public class ActividadesController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView cargarListadoActividades() {

        final ModelAndView modelo = new ModelAndView("actividades/actividades");

        return modelo;
    }

    @RequestMapping(value = "/alta", method = RequestMethod.GET)
    public ModelAndView cargarAltaActividad(final Model model) {

        final ModelAndView modelo = new ModelAndView("actividades/alta_actividad");
        model.addAttribute("nuevaActividad", new Actividad());
        return modelo;
    }

    @RequestMapping(value = "/darAltaActividad", method = RequestMethod.POST)
    public ModelAndView altaActividad(@Valid @ModelAttribute("nuevaActividad") final Actividad nuevaActividad,
            final BindingResult result, final Model model) {
        if (!result.hasErrors()) {

            model.addAttribute("infoMsg", "Actividad creada correctamente");
        }
        final ModelAndView modelo = new ModelAndView("actividades/alta_actividad");
        return modelo;
    }

    @RequestMapping(value = "/actividad/{idActividad}", method = RequestMethod.GET)
    public ModelAndView cargarPerfilActividad(@PathVariable("idActividad") final Integer idSocio) {

        final ModelAndView modelo = new ModelAndView("actividades/ficha_actividad");

        // modelo.addObject("idSocio", idSocio);

        return modelo;
    }

    @RequestMapping(value = "/actividad/{idActividad}/inscripciones/alta", method = RequestMethod.GET)
    public ModelAndView cargarAltaInscripcion() {

        final ModelAndView modelo = new ModelAndView("actividades/alta_inscripcion");

        return modelo;
    }

    @RequestMapping(value = "/actividad/{idActividad}/inscripciones", method = RequestMethod.GET)
    public ModelAndView cargarInscripcionesActividad(@PathVariable("idActividad") final Integer idSocio) {

        final ModelAndView modelo = new ModelAndView("actividades/inscripciones_actividad");

        // modelo.addObject("idSocio", idSocio);

        return modelo;
    }
}