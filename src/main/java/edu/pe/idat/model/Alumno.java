package edu.pe.idat.model;

public class Alumno {

	private String nomAlumno;
	private String apeAlumno;
	private String genAlumno;
	public String getNomAlumno() {
		return nomAlumno;
	}
	public void setNomAlumno(String nomAlumno) {
		this.nomAlumno = nomAlumno;
	}
	public String getApeAlumno() {
		return apeAlumno;
	}
	public void setApeAlumno(String apeAlumno) {
		this.apeAlumno = apeAlumno;
	}
	public String getGenAlumno() {
		return genAlumno;
	}
	public void setGenAlumno(String genAlumno) {
		this.genAlumno = genAlumno;
	}
	public Alumno(String nomAlumno, String apeAlumno, String genAlumno) {
		super();
		this.nomAlumno = nomAlumno;
		this.apeAlumno = apeAlumno;
		this.genAlumno = genAlumno;
	}
	public Alumno() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
