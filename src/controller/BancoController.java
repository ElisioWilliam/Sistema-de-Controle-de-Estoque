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
	public void create_pessoa_juridica(String nome, String cnpj) {
	    try {
	        statement = criarBanco.getConnection().createStatement();
	        String insertDataSQL = "INSERT INTO pessoa_juridica (nome, cnpj) VALUES (?, ?)";
	        PreparedStatement preparedStatement = criarBanco.getConnection().prepareStatement(insertDataSQL);
	        preparedStatement.setString(1, nome);
	        preparedStatement.setString(2, cnpj);
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public void create_pedido(int id, int id_produto,int id_pessoa,int quantidade_produto,float valor_total) {
	    try {
	        statement = criarBanco.getConnection().createStatement();
	        String insertDataSQL = "INSERT INTO pessoa_fisica (id_produto, id_pessoa, quantidade_produto, valor_total) VALUES (?, ?, ?, ?)";
	        PreparedStatement preparedStatement = criarBanco.getConnection().prepareStatement(insertDataSQL);
	        preparedStatement.setInt(1, id_produto);
	        preparedStatement.setInt(2, id_pessoa);
	        preparedStatement.setInt(3, quantidade_produto);
	        preparedStatement.setFloat(4, valor_total);
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public void create_Produto(int id, String nome, int codigo, int quantidade, float preco) {
	    try {
	        statement = criarBanco.getConnection().createStatement();
	        String insertDataSQL = "INSERT INTO pessoa_fisica (nome, codigo, quantidade, preco) VALUES (?, ?, ?, ?)";
	        PreparedStatement preparedStatement = criarBanco.getConnection().prepareStatement(insertDataSQL);
	        preparedStatement.setString(1, nome);
	        preparedStatement.setInt(2, codigo);
	        preparedStatement.setInt(3, quantidade);
	        preparedStatement.setFloat(4, preco);
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}
