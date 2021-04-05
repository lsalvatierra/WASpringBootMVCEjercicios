package edu.pe.idat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import edu.pe.idat.model.PromedioFinalForm;

@Controller
public class PromedioController {

	@GetMapping("/promedionotas")
	public ModelAndView promedionotas() {
		ModelAndView modelView = new ModelAndView();
		modelView.addObject("promediofinalform", new PromedioFinalForm());
		modelView.addObject("visualizar", false);
		modelView.addObject("titulo", "Promedio Final");
		return modelView;
	}
	
	@PostMapping("/promedionotas")
	public String promedionotas(@ModelAttribute("promediofinalform") PromedioFinalForm promedioFinalForm, 
			Model model) {
		Double valorEc1 = promedioFinalForm.getEvalcontinua1() * 0.04;
		Double valorEc2 = promedioFinalForm.getEvalcontinua2() * 0.12;
		Double valorEc3 = promedioFinalForm.getEvalcontinua3() * 0.24;
		Double valorEf = promedioFinalForm.getEvalfinal() * 0.6;
		Double valorPromFinal = valorEc1+valorEc2+valorEc3+valorEf; 
		String resultadoPromedio = "DESAPROBADO";
		String colorMsgImc = "alert-danger";
		if(valorPromFinal >= 12.5){
			resultadoPromedio = "APROBADO.";
			colorMsgImc = "alert-primary";
        }
		model.addAttribute("visualizar", true);
		model.addAttribute("resultado", "Su promedio final es: "+
	    String.format("%.2f", valorPromFinal)	 +", usted se encuenta "+ resultadoPromedio);
		model.addAttribute("colormsgpromedio", colorMsgImc);
		model.addAttribute("titulo", "Promedio Final");
		return "promedionotas";
	}	
}
