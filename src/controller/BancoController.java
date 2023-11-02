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
	
	//METODOS PARA CREATE
	public void createPessoaFisica(String nome, String cpf) {
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
	public void createPessoaJuridica(String nome, String cnpj) {
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
	public void createPedido(int id, int id_produto,int id_pessoa,int quantidade_produto,float valor_total) {
	    try {
	        statement = criarBanco.getConnection().createStatement();
	        String insertDataSQL = "INSERT INTO pedido (id_produto, id_pessoa, quantidade_produto, valor_total) VALUES (?, ?, ?, ?)";
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
	public void createProduto(int id, String nome, int codigo, int quantidade, float preco) {
	    try {
	        statement = criarBanco.getConnection().createStatement();
	        String insertDataSQL = "INSERT INTO produto (nome, codigo, quantidade, preco) VALUES (?, ?, ?, ?)";
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
	
	//METODOS PARA UPDATE
	public void updatePessoaFisica(int id, String nome, String cpf) {
	    try {
	        String updateDataSQL = "UPDATE pessoa_fisica SET nome = ?, cpf = ? WHERE id = ?";
	        PreparedStatement preparedStatement = criarBanco.getConnection().prepareStatement(updateDataSQL);
	        preparedStatement.setString(1, nome);
	        preparedStatement.setString(2, cpf);
	        preparedStatement.setInt(3, id);
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public void updatePessoaJuridica(int id, String nome, String cnpj) {
	    try {
	        String updateDataSQL = "UPDATE pessoa_juridica SET nome = ?, cnpj = ? WHERE id = ?";
	        PreparedStatement preparedStatement = criarBanco.getConnection().prepareStatement(updateDataSQL);
	        preparedStatement.setString(1, nome);
	        preparedStatement.setString(2, cnpj);
	        preparedStatement.setInt(3, id);
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public void updatePedido(int id, int id_produto, int id_pessoa, int quantidade_produto, float valor_total) {
	    try {
	        String updateDataSQL = "UPDATE pedido SET id_produto = ?, id_pessoa = ?, quantidade_produto = ?, valor_total = ? WHERE id = ?";
	        PreparedStatement preparedStatement = criarBanco.getConnection().prepareStatement(updateDataSQL);
	        preparedStatement.setInt(1, id_produto);
	        preparedStatement.setInt(2, id_pessoa);
	        preparedStatement.setInt(3, quantidade_produto);
	        preparedStatement.setFloat(4, valor_total);
	        preparedStatement.setInt(5, id);
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public void updateProduto(int id, String nome, int codigo, int quantidade, float preco) {
	    try {
	        String updateDataSQL = "UPDATE produto SET nome = ?, codigo = ?, quantidade = ?, preco = ? WHERE id = ?";
	        PreparedStatement preparedStatement = criarBanco.getConnection().prepareStatement(updateDataSQL);
	        preparedStatement.setString(1, nome);
	        preparedStatement.setInt(2, codigo);
	        preparedStatement.setInt(3, quantidade);
	        preparedStatement.setFloat(4, preco);
	        preparedStatement.setInt(5, id);
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	//METODOS PARA DELETE
	public void deletePessoaFisica(int id) {
	    try {
	        String deleteDataSQL = "DELETE FROM pessoa_fisica WHERE id = ?";
	        PreparedStatement preparedStatement = criarBanco.getConnection().prepareStatement(deleteDataSQL);
	        preparedStatement.setInt(1, id);
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public void deletePessoaJuridica(int id) {
	    try {
	        String deleteDataSQL = "DELETE FROM pessoa_juridica WHERE id = ?";
	        PreparedStatement preparedStatement = criarBanco.getConnection().prepareStatement(deleteDataSQL);
	        preparedStatement.setInt(1, id);
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public void deletePedido(int id) {
	    try {
	        String deleteDataSQL = "DELETE FROM pedido WHERE id = ?";
	        PreparedStatement preparedStatement = criarBanco.getConnection().prepareStatement(deleteDataSQL);
	        preparedStatement.setInt(1, id);
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public void deleteProduto(int id) {
	    try {
	        String deleteDataSQL = "DELETE FROM produto WHERE id = ?";
	        PreparedStatement preparedStatement = criarBanco.getConnection().prepareStatement(deleteDataSQL);
	        preparedStatement.setInt(1, id);
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

}
