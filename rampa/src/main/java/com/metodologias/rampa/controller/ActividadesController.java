package com.metodologias.rampa.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.metodologias.rampa.model.Actividad;
import com.metodologias.rampa.service.ActividadService;
import com.metodologias.rampa.util.naming.CommonNaming;

/**
 * The Class ActividadesController.
 */
@Controller
@RequestMapping(value = "/actividades")
public class ActividadesController {

    /** The actividad service. */
    @Autowired
    private ActividadService actividadService;

    /** The msg source. */
    @Autowired
    private MessageSource msgSource;

    /**
     * Cargar listado actividades.
     *
     * @return the model and view
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView cargarListadoActividades() {

        final ModelAndView modelo = new ModelAndView("actividades/actividades");

        return modelo;
    }

    /**
     * Cargar alta actividad.
     *
     * @param model
     *            the model
     * @return the model and view
     */
    @RequestMapping(value = "/alta", method = RequestMethod.GET)
    public ModelAndView cargarAltaActividad(final Model model) {

        final ModelAndView modelo = new ModelAndView("actividades/alta_actividad");
        model.addAttribute("nuevaActividad", new Actividad());
        return modelo;
    }

    /**
     * Alta actividad.
     *
     * @param nuevaActividad
     *            the nueva actividad
     * @param result
     *            the result
     * @param model
     *            the model
     * @return the model and view
     */
    @RequestMapping(value = "/darAltaActividad", method = RequestMethod.POST)
    public ModelAndView altaActividad(@Valid @ModelAttribute("nuevaActividad") final Actividad nuevaActividad,
            final BindingResult result, final Model model) {
        if (!result.hasErrors()) {
            this.actividadService.save(nuevaActividad);
            model.addAttribute("infoMsg",
                    this.msgSource.getMessage(CommonNaming.ALTA_CORRECTA_ACTIVIDAD, null, Locale.getDefault()));
        }
        final ModelAndView modelo = new ModelAndView("actividades/alta_actividad");
        return modelo;
    }

    /**
     * Cargar perfil actividad.
     *
     * @param idSocio
     *            the id socio
     * @return the model and view
     */
    @RequestMapping(value = "/actividad/{idActividad}", method = RequestMethod.GET)
    public ModelAndView cargarPerfilActividad(@PathVariable("idActividad") final Integer idSocio) {

        final ModelAndView modelo = new ModelAndView("actividades/ficha_actividad");

        // modelo.addObject("idSocio", idSocio);

        return modelo;
    }

    /**
     * Cargar alta inscripcion.
     *
     * @return the model and view
     */
    @RequestMapping(value = "/actividad/{idActividad}/inscripciones/alta", method = RequestMethod.GET)
    public ModelAndView cargarAltaInscripcion() {

        final ModelAndView modelo = new ModelAndView("actividades/alta_inscripcion");

        return modelo;
    }

    /**
     * Cargar inscripciones actividad.
     *
     * @param idSocio
     *            the id socio
     * @return the model and view
     */
    @RequestMapping(value = "/actividad/{idActividad}/inscripciones", method = RequestMethod.GET)
    public ModelAndView cargarInscripcionesActividad(@PathVariable("idActividad") final Integer idSocio) {

        final ModelAndView modelo = new ModelAndView("actividades/inscripciones_actividad");

        // modelo.addObject("idSocio", idSocio);

        return modelo;
    }
}
