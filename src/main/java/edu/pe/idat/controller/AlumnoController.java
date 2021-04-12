package edu.pe.idat.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.util.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import edu.pe.idat.model.Alumno;

@SuppressWarnings("unchecked")
@Controller
@RequestMapping("/Alumno")
public class AlumnoController {

	

	@GetMapping("/formAlumno")
	public String formAlumno(Model model) {
		model.addAttribute("alumnoform", new Alumno());
		model.addAttribute("visualizar", false);
		return "Alumno/formalumno";
	}
	

	@PostMapping("/registrarAlumno")
	public String registrarAlumno(
			@ModelAttribute("alumnoform") Alumno alumnoForm,
			final HttpServletRequest request,
			Model model) {
        List<Alumno> lstAlumnos = (List<Alumno>)request.getSession().getAttribute("lstAlumnos");
        if (CollectionUtils.isEmpty(lstAlumnos)) {
        	lstAlumnos = new ArrayList<Alumno>();
        }       
        lstAlumnos.add(alumnoForm);
        model.addAttribute("alumnoform", new Alumno());
        request.getSession().setAttribute("lstAlumnos", lstAlumnos);  
    	model.addAttribute("visualizar", true);
    	model.addAttribute("respuesta", "Alumno registrado en sesión.");
		return "Alumno/formalumno";
	}	
	
	@GetMapping("/listarAlumnos")
	public String listarAlumnos(Model model, final HttpSession session) {
		List<Alumno> lstAlumnos = (List<Alumno>)
				session.getAttribute("lstAlumnos");
		if (CollectionUtils.isEmpty(lstAlumnos)) {
        	lstAlumnos = new ArrayList<Alumno>();
        } 
		model.addAttribute("lstalumnos", lstAlumnos);
		return "Alumno/listaralumnos";
	}
	
}
