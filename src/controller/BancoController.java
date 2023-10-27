package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import conexao.CriarBanco;

public class BancoController {
	private CriarBanco criarBanco;
	private Statement statement;
	
	public BancoController(){
		criarBanco = new CriarBanco();
	}
	
	public void create_pessoa_fisica(String nome, String cpf) {
	    try {
	        statement = criarBanco.getConnection().createStatement();
	        String insertDataSQL = "INSERT INTO pessoa_fisica (nome, cpf) VALUES (?, ?)";
	        PreparedStatement preparedStatement = criarBanco.getConnection().prepareStatement(insertDataSQL);
	        preparedStatement.setString(1, nome);
	        preparedStatement.setString(2, cpf);
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}
