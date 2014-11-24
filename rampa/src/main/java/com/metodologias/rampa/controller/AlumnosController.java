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

import com.metodologias.rampa.model.Alumno;
import com.metodologias.rampa.service.AlumnoService;
import com.metodologias.rampa.util.naming.CommonNaming;

@Controller
@RequestMapping(value = "/alumnos")
public class AlumnosController {
	
    @Autowired
    private AlumnoService alumnoService;

    @Autowired
    private MessageSource msgSource;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView cargarListadoAlumnos() {

        final ModelAndView modelo = new ModelAndView("alumnos/alumnos");
        modelo.addObject("listaAlumnos", this.alumnoService.findAll());

        return modelo;
    }

    @RequestMapping(value = "/alta", method = RequestMethod.GET)
    public ModelAndView cargarAltaAlumno(final Model model) {

        final ModelAndView modelo = new ModelAndView("alumnos/alta_alumno");
        model.addAttribute("nuevoAlumno", new Alumno());
        return modelo;
    }

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

    @RequestMapping(value = "/perfil/{idAlumno}", method = RequestMethod.GET)
    public ModelAndView cargarPerfilAlumno(@PathVariable("idAlumno") final Long idAlumno) {

        final ModelAndView modelo = new ModelAndView("alumnos/ficha_alumno");
        modelo.addObject("alumno", this.alumnoService.findById(idAlumno));

        return modelo;
    }

}
