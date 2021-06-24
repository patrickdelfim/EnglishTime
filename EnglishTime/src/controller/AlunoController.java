package controller;



import bo.Aluno;
import model.AlunoDAO;


public class AlunoController {

	//Regras de negocio
	
	public void create(Aluno aluno) {
		
		System.out.println("Incluir aluno Control!!");
		
		AlunoDAO model = new AlunoDAO();
		
		model.createAluno(aluno);
		
	}
	

	
	

}
