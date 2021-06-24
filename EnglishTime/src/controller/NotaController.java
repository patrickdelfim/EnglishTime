package controller;



import java.util.ArrayList;
import java.util.List;

import bo.Nota;
import model.NotaDAO;


public class NotaController {

	//Regras de negocio
	
	public void create(Nota nota) {
		
		System.out.println("Incluir nota Control!!");
		
		NotaDAO model = new NotaDAO();
		
		model.createNota(nota);
		
	}
	
	
	public List<Nota> read() {
		List<Nota> listaNotas = new ArrayList<Nota>();
		
		
		try {
			NotaDAO model = new NotaDAO();
			listaNotas = model.read();
			
		}catch(Exception e) {
			System.out.println("Erro no controller read");
		}
		
		return listaNotas;
	}
	
	
public int update(Nota nota) {
		
		System.out.println("Atualizar Nota CONTROL!!");
		
		NotaDAO model = new NotaDAO();
		
		int feedback = model.updateNota(nota);
		return feedback;
	}

public int delete(String CodProva) {
	
	System.out.println("Deletar Nota CONTROL!!");
	
	NotaDAO model = new NotaDAO();
	
	int feedback = model.DeleteNota(CodProva);
	
	return feedback;
}
}
