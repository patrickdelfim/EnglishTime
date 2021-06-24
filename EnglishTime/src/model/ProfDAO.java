package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import bo.Professor;
import jdbc.ConnectionFactory;

public class ProfDAO {

	public void createProf(Professor prof)  {
		
		//insert sql no banco
		
		Connection banco = ConnectionFactory.getConnection();
		
		PreparedStatement stmt = null;
		
		
		try {
			String sql = "insert into Professor(CodProfessor,nome) values (?,?)";
			
			stmt = banco.prepareStatement(sql);
			stmt.setString(1,prof.getCodProf());
			stmt.setString(2,prof.getNome());
			
			
			stmt.executeUpdate();
			
			System.out.println("Aluno inserido com sucesso!!");
		 	
		} catch(SQLException e) {
			System.out.println("Erro ao tentar incluir aluno");
		} finally {
			ConnectionFactory.closeConnection(banco,stmt);
			
		}
	}
	
}
