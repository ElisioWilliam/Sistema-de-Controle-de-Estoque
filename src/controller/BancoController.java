package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexao.CriarBanco;
import java.util.ArrayList;
import java.util.List;
import models.*;

public class BancoController {
	private CriarBanco criarBanco;
	
	public BancoController(){
		criarBanco = new CriarBanco();
	}
	
	//METODOS PARA CREATE
	protected void createPessoaFisica(String nome, String cpf) {
	    try {
	        criarBanco.getConnection().createStatement();
	        String insertDataSQL = "INSERT INTO pessoa_fisica (nome, cpf) VALUES (?, ?)";
	        PreparedStatement preparedStatement = criarBanco.getConnection().prepareStatement(insertDataSQL);
	        preparedStatement.setString(1, nome);
	        preparedStatement.setString(2, cpf);
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	protected void createPessoaJuridica(String nome, String cnpj) {
	    try {
	        criarBanco.getConnection().createStatement();
	        String insertDataSQL = "INSERT INTO pessoa_juridica (nome, cnpj) VALUES (?, ?)";
	        PreparedStatement preparedStatement = criarBanco.getConnection().prepareStatement(insertDataSQL);
	        preparedStatement.setString(1, nome);
	        preparedStatement.setString(2, cnpj);
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	protected void createPedido(int id_produto, String documento_pessoa,int quantidade_produto,float valor_total) {
	    try {
	        criarBanco.getConnection().createStatement();
	        String insertDataSQL = "INSERT INTO pedido (id_produto, id_pessoa, quantidade_produto, valor_total) VALUES (?, ?, ?, ?)";
	        PreparedStatement preparedStatement = criarBanco.getConnection().prepareStatement(insertDataSQL);
	        preparedStatement.setInt(1, id_produto);
	        preparedStatement.setString(2, documento_pessoa);
	        preparedStatement.setInt(3, quantidade_produto);
	        preparedStatement.setFloat(4, valor_total);
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	protected void createProduto(String nome, String codigo, int quantidade, float preco) {
	    try {
	        criarBanco.getConnection().createStatement();
	        String insertDataSQL = "INSERT INTO produto (nome, codigo, quantidade, preco) VALUES (?, ?, ?, ?)";
	        PreparedStatement preparedStatement = criarBanco.getConnection().prepareStatement(insertDataSQL);
	        preparedStatement.setString(1, nome);
	        preparedStatement.setString(2, codigo);
	        preparedStatement.setInt(3, quantidade);
	        preparedStatement.setFloat(4, preco);
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	//METODOS PARA UPDATE
	protected void updatePessoaFisica(int id, String nome, String cpf) {
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

	protected void updatePessoaJuridica(int id, String nome, String cnpj) {
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

	protected void updatePedido(int id, int id_produto, String documento_pessoa, int quantidade_produto, float valor_total) {
	    try {
	        String updateDataSQL = "UPDATE pedido SET id_produto = ?, documento_pessoa = ?, quantidade_produto = ?, valor_total = ? WHERE id = ?";
	        PreparedStatement preparedStatement = criarBanco.getConnection().prepareStatement(updateDataSQL);
	        preparedStatement.setInt(1, id_produto);
	        preparedStatement.setString(2, documento_pessoa);
	        preparedStatement.setInt(3, quantidade_produto);
	        preparedStatement.setFloat(4, valor_total);
	        preparedStatement.setInt(5, id);
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	protected void updateProduto(int id, String nome, String codigo, int quantidade, float preco) {
	    try {
	        String updateDataSQL = "UPDATE produto SET nome = ?, codigo = ?, quantidade = ?, preco = ? WHERE id = ?";
	        PreparedStatement preparedStatement = criarBanco.getConnection().prepareStatement(updateDataSQL);
	        preparedStatement.setString(1, nome);
	        preparedStatement.setString(2, codigo);
	        preparedStatement.setInt(3, quantidade);
	        preparedStatement.setFloat(4, preco);
	        preparedStatement.setInt(5, id);
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	protected void updateQuantidadeProduto(int id, int quantidade) {
	    try {
	        String updateDataSQL = "UPDATE produto SET quantidade = ? WHERE id = ?";
	        PreparedStatement preparedStatement = criarBanco.getConnection().prepareStatement(updateDataSQL);
	        preparedStatement.setInt(1, quantidade);
	        preparedStatement.setInt(2, id);
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	//METODOS PARA DELETE
	protected void deletePessoaFisica(int id) {
	    try {
	        String deleteDataSQL = "DELETE FROM pessoa_fisica WHERE id = ?";
	        PreparedStatement preparedStatement = criarBanco.getConnection().prepareStatement(deleteDataSQL);
	        preparedStatement.setInt(1, id);
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	protected void deletePessoaJuridica(int id) {
	    try {
	        String deleteDataSQL = "DELETE FROM pessoa_juridica WHERE id = ?";
	        PreparedStatement preparedStatement = criarBanco.getConnection().prepareStatement(deleteDataSQL);
	        preparedStatement.setInt(1, id);
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	protected void deletePedido(int id) {
	    try {
	        String deleteDataSQL = "DELETE FROM pedido WHERE id = ?";
	        PreparedStatement preparedStatement = criarBanco.getConnection().prepareStatement(deleteDataSQL);
	        preparedStatement.setInt(1, id);
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	protected void deleteProduto(int id) {
	    try {
	        String deleteDataSQL = "DELETE FROM produto WHERE id = ?";
	        PreparedStatement preparedStatement = criarBanco.getConnection().prepareStatement(deleteDataSQL);
	        preparedStatement.setInt(1, id);
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	//MÉTODOS READ
	public List<PessoaFisica> readPessoaFisica() {
		List<PessoaFisica> pessoaFisicaList = new ArrayList<>();
        try {
            String selectDataSQL = "SELECT * FROM pessoa_fisica";
            PreparedStatement preparedStatement = criarBanco.getConnection().prepareStatement(selectDataSQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String cpf = resultSet.getString("cpf");
                
                PessoaFisica pessoaFisica = new PessoaFisica(id, nome, cpf);
                pessoaFisicaList.add(pessoaFisica);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pessoaFisicaList;
    }
	
	public List<PessoaJuridica> readPessoaJuridica() {
	    List<PessoaJuridica> pessoaJuridicaList = new ArrayList<>();
	    try {
	        String selectDataSQL = "SELECT * FROM pessoa_juridica";
	        PreparedStatement preparedStatement = criarBanco.getConnection().prepareStatement(selectDataSQL);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        
	        while (resultSet.next()) {
	            int id = resultSet.getInt("id");
	            String nome = resultSet.getString("nome");
	            String cnpj = resultSet.getString("cnpj");
	            
	            PessoaJuridica pessoaJuridica = new PessoaJuridica(id, nome, cnpj);
	            pessoaJuridicaList.add(pessoaJuridica);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return pessoaJuridicaList;
	}

	public List<Pedido> readPedido() {
	    List<Pedido> pedidoList = new ArrayList<>();
	    try {
	        String selectDataSQL = "SELECT * FROM pedido";
	        PreparedStatement preparedStatement = criarBanco.getConnection().prepareStatement(selectDataSQL);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        
	        while (resultSet.next()) {
	            int id = resultSet.getInt("id");
	            int id_produto = resultSet.getInt("id_produto");
	            String documento_pessoa = resultSet.getString("documento_pessoa");
	            int quantidade_produto = resultSet.getInt("quantidade_produto");
	            Float valor_total = resultSet.getFloat("valor_total");
	            
	            Pedido pedido = new Pedido(id, id_produto, documento_pessoa, quantidade_produto, valor_total);
	            pedidoList.add(pedido);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return pedidoList;
	}

	public List<Produto> readProduto() {
	    List<Produto> produtoList = new ArrayList<>();
	    try {
	        String selectDataSQL = "SELECT * FROM produto";
	        PreparedStatement preparedStatement = criarBanco.getConnection().prepareStatement(selectDataSQL);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        
	        while (resultSet.next()) {
	            int id = resultSet.getInt("id");
	            String nome = resultSet.getString("nome");
	            String codigo = resultSet.getString("codigo");
	            int quantidade = resultSet.getInt("quantidade");
	            Float preco = resultSet.getFloat("preco");
	            
	            Produto produto = new Produto(id, nome, codigo, quantidade, preco);
	            produtoList.add(produto);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return produtoList;
	}
	
	protected Produto getProduto(int idPassado) {
	    try {
	        String selectDataSQL = "SELECT * FROM produto WHERE id = ?";
	        PreparedStatement preparedStatement = criarBanco.getConnection().prepareStatement(selectDataSQL);
	        preparedStatement.setInt(1, idPassado);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        
	        while (resultSet.next()) {
	            int id = resultSet.getInt("id");
	            String nome = resultSet.getString("nome");
	            String codigo = resultSet.getString("codigo");
	            int quantidade = resultSet.getInt("quantidade");
	            Float preco = resultSet.getFloat("preco");
	            
	            Produto produto = new Produto(id, nome, codigo, quantidade, preco);
	            return produto;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	protected Produto getProduto(String codigoPassado) {
	    try {
	        String selectDataSQL = "SELECT * FROM produto WHERE codigo = ?";
	        PreparedStatement preparedStatement = criarBanco.getConnection().prepareStatement(selectDataSQL);
	        preparedStatement.setString(1, codigoPassado);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        
	        while (resultSet.next()) {
	            int id = resultSet.getInt("id");
	            String nome = resultSet.getString("nome");
	            String codigo = resultSet.getString("codigo");
	            int quantidade = resultSet.getInt("quantidade");
	            Float preco = resultSet.getFloat("preco");
	            
	            Produto produto = new Produto(id, nome, codigo, quantidade, preco);
	            return produto;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	//MÉTODOS PARA VERIFICAR SE VALOR JA EXISTE NO BANCO DE DADOS
	protected boolean cpfExiste(String cpf) {
	    try {
	        String checkCPFSQL = "SELECT COUNT(*) FROM pessoa_fisica WHERE cpf = ?";
	        PreparedStatement preparedStatement = criarBanco.getConnection().prepareStatement(checkCPFSQL);
	        preparedStatement.setString(1, cpf);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        
	        if (resultSet.next()) {
	            int count = resultSet.getInt(1);
	            return count > 0;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	protected boolean cnpjExiste(String cnpj) {
	    try {
	        String checkCNPJSQL = "SELECT COUNT(*) FROM pessoa_juridica WHERE cnpj = ?";
	        PreparedStatement preparedStatement = criarBanco.getConnection().prepareStatement(checkCNPJSQL);
	        preparedStatement.setString(1, cnpj);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        
	        if (resultSet.next()) {
	            int count = resultSet.getInt(1);
	            return count > 0;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	protected boolean codigoExiste(String codigo) {
	    try {
	        String checkCodigoSQL = "SELECT COUNT(*) FROM produto WHERE codigo = ?";
	        PreparedStatement preparedStatement = criarBanco.getConnection().prepareStatement(checkCodigoSQL);
	        preparedStatement.setString(1, codigo);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        
	        if (resultSet.next()) {
	            int count = resultSet.getInt(1);
	            return count > 0;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	protected boolean produtoExiste(int id) {
	    try {
	        String checkCodigoSQL = "SELECT COUNT(*) FROM produto WHERE id = ?";
	        PreparedStatement preparedStatement = criarBanco.getConnection().prepareStatement(checkCodigoSQL);
	        preparedStatement.setInt(1, id);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        
	        if (resultSet.next()) {
	            int count = resultSet.getInt(1);
	            return count > 0;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
}
