/*
 * 
 */
package com.metodologias.rampa.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.metodologias.rampa.controller.conversion.ActividadConverter;
import com.metodologias.rampa.controller.conversion.AlumnoConverter;
import com.metodologias.rampa.model.Actividad;
import com.metodologias.rampa.model.Alumno;
import com.metodologias.rampa.model.Inscripcion;
import com.metodologias.rampa.service.ActividadService;
import com.metodologias.rampa.service.AlumnoService;
import com.metodologias.rampa.service.InscripcionService;
import com.metodologias.rampa.util.naming.CommonNaming;

/**
 * The Class InscripcionesController.
 */
@Controller
@RequestMapping(value = "/inscripciones")
public class InscripcionesController {

    /** The inscripcion service. */
    @Autowired
    private InscripcionService inscripcionService;

    /** The alumno service. */
    @Autowired
    private AlumnoService alumnoService;

    /** The actividad service. */
    @Autowired
    private ActividadService actividadService;

    /** The actividad converter. */
    @Autowired
    private ActividadConverter actividadConverter;

    /** The alumno converter. */
    @Autowired
    private AlumnoConverter alumnoConverter;

    /** The msg source. */
    @Autowired
    private MessageSource msgSource;

    /**
     * Cargar listado Inscripciones.
     *
     * @return the model and view
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView cargarListadoInscripciones() {

        final ModelAndView modelo = new ModelAndView("inscripciones/inscripciones");
        modelo.addObject("listaInscripciones", this.inscripcionService.findAll());

        return modelo;
    }

    /**
     * Cargar alta inscripcion.
     *
     * @param model
     *            the model
     * @return the model and view
     */
    @RequestMapping(value = "/alta", method = RequestMethod.GET)
    public ModelAndView cargarAltaInscripcion(final Model model) {

        model.addAttribute("nuevaInscripcion", new Inscripcion());

        final ModelAndView modelo = new ModelAndView("inscripciones/alta_inscripcion");
        modelo.addObject("listaAlumnos", this.alumnoService.findAll());
        modelo.addObject("listaActividades", this.actividadService.findAll());
        return modelo;
    }

    /**
     * Metodo que convierte el string que se recibe con el numero de alumno y de actividad al objeto alumno y actividad
     * para asociar a la inscripcion.
     *
     * @param binder
     *            the binder
     */
    @InitBinder
    public void initBinder(final WebDataBinder binder) {
        binder.registerCustomEditor(Alumno.class, this.alumnoConverter);
        binder.registerCustomEditor(Actividad.class, this.actividadConverter);
    }

    /**
     * Alta inscripcion.
     *
     * @param request
     *            the request
     * @param response
     *            the response
     * @param nuevaInscripcion
     *            the nueva inscripcion
     * @param result
     *            the result
     * @param model
     *            the model
     * @return the model and view
     */
    @RequestMapping(value = "/darAltaInscripcion", method = RequestMethod.POST)
    public ModelAndView altaInscripcion(final HttpServletRequest request, final HttpServletResponse response,
            @Valid @ModelAttribute("nuevaInscripcion") final Inscripcion nuevaInscripcion, final BindingResult result,
            final Model model) {

        // Seccion de codigo provisional para el tratamiento de fechas de la inscripcion
        final SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;
        try {
            if (request.getParameter("fechaAlta") != null && !"".equals(request.getParameter("fechaAlta"))) {
                fecha = formatoDelTexto.parse(request.getParameter("fechaAlta"));
                nuevaInscripcion.setFechaAlta(fecha);
                fecha = null;
            }
            if (request.getParameter("fechaBaja") != null && !"".equals(request.getParameter("fechaBaja"))) {

                fecha = formatoDelTexto.parse(request.getParameter("fechaBaja"));
                nuevaInscripcion.setFechaBaja(fecha);
            }

            nuevaInscripcion.setPagoAlDia(true);

        } catch (final ParseException ex) {

            ex.printStackTrace();

        }

        if (!result.hasErrors()) {
            this.inscripcionService.save(nuevaInscripcion);
            model.addAttribute("infoMsg",
                    this.msgSource.getMessage(CommonNaming.ALTA_CORRECTA_INSCRIPCION, null, Locale.getDefault()));
        }
        final ModelAndView modelo = new ModelAndView("inscripciones/alta_inscripcion");
        return modelo;
    }
}
