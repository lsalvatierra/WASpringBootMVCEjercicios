package edu.pe.idat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import edu.pe.idat.model.ImcForm;

@Controller
public class ImcController {
	
	@GetMapping("/calculoimc")
	public ModelAndView calculoimc() {
		ModelAndView modelView = new ModelAndView();
		modelView.addObject("imcform", new ImcForm());
		modelView.addObject("visualizar", false);
		modelView.addObject("titulo", "Calculadora IMC");
		return modelView;
	}
	
	@PostMapping("/calculoimc")
	public String calculoimc(@ModelAttribute("imcform") ImcForm imcForm, 
			Model model) {
		Double tallam = imcForm.getTalla() / 100;
		Double valorImc = imcForm.getPeso() / (tallam * tallam);
		 
		String resultadoImc = "";
		String colorMsgImc = "alert-warning";
		if(valorImc <= 18.5){
			resultadoImc = "Por debajo del peso.";
			colorMsgImc = "alert-dark";
        }else if(valorImc <= 25){
        	resultadoImc = "Con peso normal.";
        	colorMsgImc = "alert-primary";
        }else if(valorImc <= 30){
        	resultadoImc = "Con Sobrepeso.";
        	colorMsgImc = "alert-warning";
        }else if(valorImc <= 35){
        	resultadoImc = "Obesidad leve.";        	
        }else if(valorImc <= 39){
        	resultadoImc = "Obesidad media.";
        } else{
        	resultadoImc = "Con obesidad mórbida.";
        }
		model.addAttribute("visualizar", true);
		model.addAttribute("resultado", "Su valor de IMC es: "+
	    String.format("%.2f", valorImc)	 +", usted se encuenta "+ resultadoImc);
		model.addAttribute("colormsgimc", colorMsgImc);
		model.addAttribute("titulo", "Calculadora IMC");
		return "calculoimc";
	}
}
