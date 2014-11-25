package com.metodologias.rampa.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.metodologias.rampa.controller.conversion.SocioConverter;
import com.metodologias.rampa.model.Alumno;
import com.metodologias.rampa.model.Socio;
import com.metodologias.rampa.service.AlumnoService;
import com.metodologias.rampa.service.SocioService;
import com.metodologias.rampa.util.naming.CommonNaming;

/**
 * The Class AlumnosController.
 */
@Controller
@RequestMapping(value = "/alumnos")
public class AlumnosController {

    /** The alumno service. */
    @Autowired
    private AlumnoService alumnoService;

    /** The socio service. */
    @Autowired
    private SocioService socioService;

    /** The socio converter. */
    @Autowired
    private SocioConverter socioConverter;

    /** The msg source. */
    @Autowired
    private MessageSource msgSource;

    /**
     * Cargar listado alumnos.
     *
     * @return the model and view
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView cargarListadoAlumnos() {

        final ModelAndView modelo = new ModelAndView("alumnos/alumnos");
        modelo.addObject("listaAlumnos", this.alumnoService.findAll());

        return modelo;
    }

    /**
     * Cargar alta alumno.
     *
     * @param model
     *            the model
     * @return the model and view
     */
    @RequestMapping(value = "/alta", method = RequestMethod.GET)
    public ModelAndView cargarAltaAlumno(final Model model) {

        model.addAttribute("nuevoAlumno", new Alumno());

        final ModelAndView modelo = new ModelAndView("alumnos/alta_alumno");
        modelo.addObject("listaSocios", this.socioService.findAll());

        return modelo;
    }

    /**
     * Metodo que convierte el string que se recibe con el numero de socio al objeto socio para asociar al alumno.
     *
     * @param binder
     *            the binder
     */
    @InitBinder
    public void initBinder(final WebDataBinder binder) {
        binder.registerCustomEditor(Socio.class, this.socioConverter);
    }

    /**
     * Alta alumno.
     *
     * @param nuevoAlumno
     *            the nuevo alumno
     * @param result
     *            the result
     * @param model
     *            the model
     * @return the model and view
     */
    @RequestMapping(value = "/darAltaAlumno", method = RequestMethod.POST)
    public ModelAndView altaAlumno(@Valid @ModelAttribute("nuevoAlumno") final Alumno nuevoAlumno,
            final BindingResult result, final Model model) {
        if (!result.hasErrors()) {
            this.alumnoService.save(nuevoAlumno);
            model.addAttribute("infoMsg",
                    this.msgSource.getMessage(CommonNaming.ALTA_CORRECTA_ALUMNO, null, Locale.getDefault()));
        }
        final ModelAndView modelo = new ModelAndView("alumnos/alta_alumno");
        return modelo;
    }

    /**
     * Cargar perfil alumno.
     *
     * @param idAlumno
     *            the id alumno
     * @return the model and view
     */
    @RequestMapping(value = "/perfil/{idAlumno}", method = RequestMethod.GET)
    public ModelAndView cargarPerfilAlumno(@PathVariable("idAlumno") final Long idAlumno) {

        final ModelAndView modelo = new ModelAndView("alumnos/ficha_alumno");
        modelo.addObject("alumno", this.alumnoService.findById(idAlumno));

        return modelo;
    }

}
