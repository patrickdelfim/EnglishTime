package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import bo.Aluno;
import jdbc.ConnectionFactory;

public class AlunoDAO {

	public void createAluno(Aluno aluno)  {
		
		//insert sql no banco
		
		Connection banco = ConnectionFactory.getConnection();
		
		PreparedStatement stmt = null;
		
		
		try {
			String sql = "insert into Aluno(matricula,nome) values (?,?)";
			
			stmt = banco.prepareStatement(sql);
			stmt.setString(1,aluno.getMatricula());
			stmt.setString(2,aluno.getNome());
			
			
			stmt.executeUpdate();
			
			System.out.println("Aluno inserido com sucesso!!");
		 	
		} catch(SQLException e) {
			System.out.println("Erro ao tentar incluir aluno");
		} finally {
			ConnectionFactory.closeConnection(banco,stmt);
			
		}
	}
	
}
