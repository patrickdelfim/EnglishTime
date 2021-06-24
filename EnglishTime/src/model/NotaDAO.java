package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import bo.Nota;
import jdbc.ConnectionFactory;

public class NotaDAO {

	public void createNota(Nota nota)  {
		
		//insert sql no banco
		
		Connection banco = ConnectionFactory.getConnection();
		
		PreparedStatement stmt = null;
		
		
		try {
			String sql = "insert into Prova(CodProva,Matricula,Nota) values (?,?,?)";
			
			stmt = banco.prepareStatement(sql);
			stmt.setString(1,nota.getCodProva());
			stmt.setString(2,nota.getMatricula());
			stmt.setString(3,nota.getNota());
			
			
			
			stmt.executeUpdate();
			
			System.out.println("Prova inserida com sucesso!!");
		 	
		} catch(SQLException e) {
			System.out.println("Erro ao tentar incluir Prova");
		} finally {
			ConnectionFactory.closeConnection(banco,stmt);
			
		}
	}

	public List<Nota> read() {
		
		List<Nota> listaNotas = new ArrayList<Nota>();
		
		Connection banco = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet resultado = null;
		
		
		
		String sql = "Select CodProva,Matricula,Nota from Prova";
		
		try {
			stmt = banco.prepareStatement(sql);
			resultado = stmt.executeQuery();
			
			while(resultado.next()) {
				Nota nota = new Nota();
				nota.setCodProva(resultado.getString("CodProva"));
				nota.setMatricula(resultado.getString("Matricula"));
				nota.setNota(resultado.getString("Nota"));
				
				listaNotas.add(nota);
				
			}
		}
		catch(Exception e)
		{
			System.out.println("Erro ao tentar ler Nota...");
		}
		finally {
			ConnectionFactory.closeConnection(banco,stmt);
		}
		
		
		
		return listaNotas;
	}
	
	
	
public int updateNota(Nota nota)  {
		
		//update sql no banco
		
		Connection banco = ConnectionFactory.getConnection();
		
		PreparedStatement stmt = null;
		
		
		try {
			String sql = "update Prova SET Nota = ? Where CodProva = ?";
			
			stmt = banco.prepareStatement(sql);
			System.out.println("Entrou Update Nota DAO");
		
			stmt.setString(1,nota.getNota());
			stmt.setString(2,nota.getCodProva());
			int NdeDeletados = stmt.executeUpdate();
			
			
		 	return NdeDeletados;
		} catch(SQLException e) {
			
			return 0;
		} finally {
			ConnectionFactory.closeConnection(banco,stmt);
			
		}
	}

public int DeleteNota(String CodProva)  {
	
	
	Connection banco = ConnectionFactory.getConnection();
	
	PreparedStatement stmt = null;
	
	
	try {
		String sql = "DELETE FROM Prova WHERE CodProva = ?";
		
		stmt = banco.prepareStatement(sql);
		
		
		stmt.setString(1,CodProva);
		
		int NdeDeletados = stmt.executeUpdate();
		
		
		
		return NdeDeletados;
				
	 	
	} catch(SQLException e) {
		System.out.println("Erro ao tentar Deletar Prova");
		
		return 0;
				
	} finally {
		ConnectionFactory.closeConnection(banco,stmt);
		
	}
}
	
	
	
}
