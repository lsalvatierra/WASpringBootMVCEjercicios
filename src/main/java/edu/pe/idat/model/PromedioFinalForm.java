package edu.pe.idat.model;

public class PromedioFinalForm {
	private Double evalcontinua1;
	private Double evalcontinua2;
	private Double evalcontinua3;
	private Double evalfinal;
	public Double getEvalcontinua1() {
		return evalcontinua1;
	}
	public void setEvalcontinua1(Double evalcontinua1) {
		this.evalcontinua1 = evalcontinua1;
	}
	public Double getEvalcontinua2() {
		return evalcontinua2;
	}
	public void setEvalcontinua2(Double evalcontinua2) {
		this.evalcontinua2 = evalcontinua2;
	}
	public Double getEvalcontinua3() {
		return evalcontinua3;
	}
	public void setEvalcontinua3(Double evalcontinua3) {
		this.evalcontinua3 = evalcontinua3;
	}
	public Double getEvalfinal() {
		return evalfinal;
	}
	public void setEvalfinal(Double evalfinal) {
		this.evalfinal = evalfinal;
	}
	public PromedioFinalForm(Double evalcontinua1, Double evalcontinua2, Double evalcontinua3, Double evalfinal) {
		super();
		this.evalcontinua1 = evalcontinua1;
		this.evalcontinua2 = evalcontinua2;
		this.evalcontinua3 = evalcontinua3;
		this.evalfinal = evalfinal;
	}
	public PromedioFinalForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
