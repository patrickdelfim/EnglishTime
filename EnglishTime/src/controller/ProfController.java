package controller;



import bo.Professor;
import model.ProfDAO;


public class ProfController {

	//Regras de negocio
	
	public void create(Professor prof) {
		
		System.out.println("Incluir prof Control!!");
		
		ProfDAO model = new ProfDAO();
		
		model.createProf(prof);
		
	}
	

	
	

}
