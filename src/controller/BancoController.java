package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexao.CriarBanco;
import java.util.ArrayList;
import java.util.List;
import models.*;

public class BancoController {
    private CriarBanco criarBanco;

    public BancoController() {
        criarBanco = new CriarBanco();
    }

    // METODOS PARA CREATE
    protected void createPessoaFisica(String nome, String cpf) {
        try (Connection connection = criarBanco.getConnection()) {
            String insertDataSQL = "INSERT INTO pessoa_fisica (nome, cpf) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertDataSQL)) {
                preparedStatement.setString(1, nome);
                preparedStatement.setString(2, cpf);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    protected void createPessoaJuridica(String nome, String cnpj) {
        try (Connection connection = criarBanco.getConnection()) {
            String insertDataSQL = "INSERT INTO pessoa_juridica (nome, cnpj) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertDataSQL)) {
                preparedStatement.setString(1, nome);
                preparedStatement.setString(2, cnpj);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createPedido(String codigo_produto, String documento_pessoa, int quantidade_produto, float valor_total) {
        try (Connection connection = criarBanco.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO pedido (codigo_produto, documento_pessoa, quantidade_produto, valor_total) VALUES (?, ?, ?, ?)")) {

            preparedStatement.setString(1, codigo_produto);
            preparedStatement.setString(2, documento_pessoa);
            preparedStatement.setInt(3, quantidade_produto);
            preparedStatement.setFloat(4, valor_total);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Ou lançar uma exceção personalizada ou adicionar uma mensagem de log
        }
    }

    protected void createProduto(String nome, String codigo, int quantidade, float preco) {
        try (Connection connection = criarBanco.getConnection()) {
            String insertDataSQL = "INSERT INTO produto (nome, codigo, quantidade, preco) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertDataSQL)) {
                preparedStatement.setString(1, nome);
                preparedStatement.setString(2, codigo);
                preparedStatement.setInt(3, quantidade);
                preparedStatement.setFloat(4, preco);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	//METODOS PARA UPDATE
    protected void updatePessoaFisica(String nome, String cpf) {
        try (Connection connection = criarBanco.getConnection()) {
            String updateDataSQL = "UPDATE pessoa_fisica SET nome = ? WHERE cpf = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateDataSQL)) {
                preparedStatement.setString(1, nome);
                preparedStatement.setString(2, cpf);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void updatePessoaJuridica(String nome, String cnpj) {
        try (Connection connection = criarBanco.getConnection()) {
            String updateDataSQL = "UPDATE pessoa_juridica SET nome = ? WHERE cnpj = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateDataSQL)) {
                preparedStatement.setString(1, nome);
                preparedStatement.setString(2, cnpj);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void updatePedido(int id, String codigo_produto, String documento_pessoa, int quantidade_produto, float valor_total) {
        try (Connection connection = criarBanco.getConnection()) {
            String updateDataSQL = "UPDATE pedido SET codigo_produto = ?, documento_pessoa = ?, quantidade_produto = ?, valor_total = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateDataSQL)) {
                preparedStatement.setString(1, codigo_produto);
                preparedStatement.setString(2, documento_pessoa);
                preparedStatement.setInt(3, quantidade_produto);
                preparedStatement.setFloat(4, valor_total);
                preparedStatement.setInt(5, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void updateProduto(String nome, String codigo, int quantidade, float preco) {
        try (Connection connection = criarBanco.getConnection()) {
            String updateDataSQL = "UPDATE produto SET nome = ?, quantidade = ?, preco = ? WHERE codigo = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateDataSQL)) {
                preparedStatement.setString(1, nome);
                preparedStatement.setInt(2, quantidade);
                preparedStatement.setFloat(3, preco);
                preparedStatement.setString(4, codigo);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void updateQuantidadeProduto(int id, int quantidade) {
        try (Connection connection = criarBanco.getConnection()) {
            String updateDataSQL = "UPDATE produto SET quantidade = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateDataSQL)) {
                preparedStatement.setInt(1, quantidade);
                preparedStatement.setInt(2, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	//METODOS PARA DELETE
	protected void deletePessoaFisica(String cpf) {
	    try {
	        String deleteDataSQL = "DELETE FROM pessoa_fisica WHERE cpf = ?";
	        PreparedStatement preparedStatement = criarBanco.getConnection().prepareStatement(deleteDataSQL);
	        preparedStatement.setString(1, cpf);
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	protected void deletePessoaJuridica(String cnpj) {
	    try {
	        String deleteDataSQL = "DELETE FROM pessoa_juridica WHERE cnpj = ?";
	        PreparedStatement preparedStatement = criarBanco.getConnection().prepareStatement(deleteDataSQL);
	        preparedStatement.setString(1, cnpj);
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

	protected void deleteProduto(String codigo) {
	    try {
	        String deleteDataSQL = "DELETE FROM produto WHERE codigo = ?";
	        PreparedStatement preparedStatement = criarBanco.getConnection().prepareStatement(deleteDataSQL);
	        preparedStatement.setString(1, codigo);
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	//MÉTODOS READ
	public List<PessoaFisica> readPessoaFisica() {
	    List<PessoaFisica> pessoaFisicaList = new ArrayList<>();
	    try (Connection connection = criarBanco.getConnection()) {
	        String selectDataSQL = "SELECT * FROM pessoa_fisica";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(selectDataSQL);
	             ResultSet resultSet = preparedStatement.executeQuery()) {

	            while (resultSet.next()) {
	                int id = resultSet.getInt("id");
	                String nome = resultSet.getString("nome");
	                String cpf = resultSet.getString("cpf");

	                PessoaFisica pessoaFisica = new PessoaFisica(id, nome, cpf);
	                pessoaFisicaList.add(pessoaFisica);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return pessoaFisicaList;
	}
	
	public List<PessoaJuridica> readPessoaJuridica() {
	    List<PessoaJuridica> pessoaJuridicaList = new ArrayList<>();
	    try (Connection connection = criarBanco.getConnection()) {
	        String selectDataSQL = "SELECT * FROM pessoa_juridica";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(selectDataSQL);
	             ResultSet resultSet = preparedStatement.executeQuery()) {

	            while (resultSet.next()) {
	                int id = resultSet.getInt("id");
	                String nome = resultSet.getString("nome");
	                String cnpj = resultSet.getString("cnpj");

	                PessoaJuridica pessoaJuridica = new PessoaJuridica(id, nome, cnpj);
	                pessoaJuridicaList.add(pessoaJuridica);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return pessoaJuridicaList;
	}

	public List<Pedido> readPedido() {
	    List<Pedido> pedidoList = new ArrayList<>();
	    try (Connection connection = criarBanco.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM pedido");
	         ResultSet resultSet = preparedStatement.executeQuery()) {

	        while (resultSet.next()) {
	            int id = resultSet.getInt("id");
	            String codigo_produto = resultSet.getString("codigo_produto");
	            String documento_pessoa = resultSet.getString("documento_pessoa");
	            int quantidade_produto = resultSet.getInt("quantidade_produto");
	            Float valor_total = resultSet.getFloat("valor_total");

	            Pedido pedido = new Pedido(id, codigo_produto, documento_pessoa, quantidade_produto, valor_total);
	            pedidoList.add(pedido);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        // Ou lançar uma exceção personalizada ou adicionar uma mensagem de log
	    }
	    return pedidoList;
	}

	public List<Produto> readProduto() {
	    List<Produto> produtoList = new ArrayList<>();
	    try (Connection connection = criarBanco.getConnection()) {
	        String selectDataSQL = "SELECT * FROM produto";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(selectDataSQL);
	             ResultSet resultSet = preparedStatement.executeQuery()) {

	            while (resultSet.next()) {
	                int id = resultSet.getInt("id");
	                String nome = resultSet.getString("nome");
	                String codigo = resultSet.getString("codigo");
	                int quantidade = resultSet.getInt("quantidade");
	                Float preco = resultSet.getFloat("preco");

	                Produto produto = new Produto(id, nome, codigo, quantidade, preco);
	                produtoList.add(produto);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return produtoList;
	}

	protected Produto getProduto(int idPassado) {
	    try (Connection connection = criarBanco.getConnection()) {
	        String selectDataSQL = "SELECT * FROM produto WHERE id = ?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(selectDataSQL)) {
	            preparedStatement.setInt(1, idPassado);
	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                while (resultSet.next()) {
	                    int id = resultSet.getInt("id");
	                    String nome = resultSet.getString("nome");
	                    String codigo = resultSet.getString("codigo");
	                    int quantidade = resultSet.getInt("quantidade");
	                    Float preco = resultSet.getFloat("preco");

	                    Produto produto = new Produto(id, nome, codigo, quantidade, preco);
	                    return produto;
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	protected Produto getProduto(String codigoPassado) {
	    try (Connection connection = criarBanco.getConnection()) {
	        String selectDataSQL = "SELECT * FROM produto WHERE codigo = ?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(selectDataSQL)) {
	            preparedStatement.setString(1, codigoPassado);
	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                while (resultSet.next()) {
	                    int id = resultSet.getInt("id");
	                    String nome = resultSet.getString("nome");
	                    String codigo = resultSet.getString("codigo");
	                    int quantidade = resultSet.getInt("quantidade");
	                    Float preco = resultSet.getFloat("preco");

	                    Produto produto = new Produto(id, nome, codigo, quantidade, preco);
	                    return produto;
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	protected Pedido getPedido(int idPassado) {
	    try (Connection connection = criarBanco.getConnection()) {
	        String selectDataSQL = "SELECT * FROM pedido WHERE id = ?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(selectDataSQL)) {
	            preparedStatement.setInt(1, idPassado);
	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                while (resultSet.next()) {
	                    int id = resultSet.getInt("id");
	                    String documento = resultSet.getString("documento_pessoa");
	                    String codigo = resultSet.getString("codigo_produto");
	                    int quantidade = resultSet.getInt("quantidade_produto");
	                    Float preco = resultSet.getFloat("valor_total");

	                    Pedido pedido= new Pedido(id, codigo, documento, quantidade, preco);
	                    return pedido;
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	//MÉTODOS PARA VERIFICAR SE VALOR JA EXISTE NO BANCO DE DADOS
	protected boolean cpfExiste(String cpf) {
	    try (Connection connection = criarBanco.getConnection()) {
	        String checkCPFSQL = "SELECT COUNT(*) FROM pessoa_fisica WHERE cpf = ?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(checkCPFSQL)) {
	            preparedStatement.setString(1, cpf);
	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                if (resultSet.next()) {
	                    int count = resultSet.getInt(1);
	                    return count > 0;
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	protected boolean cnpjExiste(String cnpj) {
	    try (Connection connection = criarBanco.getConnection()) {
	        String checkCNPJSQL = "SELECT COUNT(*) FROM pessoa_juridica WHERE cnpj = ?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(checkCNPJSQL)) {
	            preparedStatement.setString(1, cnpj);
	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                if (resultSet.next()) {
	                    int count = resultSet.getInt(1);
	                    return count > 0;
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	protected boolean codigoExiste(String codigo) {
	    try (Connection connection = criarBanco.getConnection()) {
	        String checkCodigoSQL = "SELECT COUNT(*) FROM produto WHERE codigo = ?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(checkCodigoSQL)) {
	            preparedStatement.setString(1, codigo);
	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                if (resultSet.next()) {
	                    int count = resultSet.getInt(1);
	                    return count > 0;
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	protected boolean produtoExiste(int id) {
	    try (Connection connection = criarBanco.getConnection()) {
	        String checkCodigoSQL = "SELECT COUNT(*) FROM produto WHERE id = ?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(checkCodigoSQL)) {
	            preparedStatement.setInt(1, id);
	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                if (resultSet.next()) {
	                    int count = resultSet.getInt(1);
	                    return count > 0;
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	
	protected boolean produtoExiste(String codigo) {
	    try (Connection connection = criarBanco.getConnection()) {
	        String checkCodigoSQL = "SELECT COUNT(*) FROM produto WHERE codigo = ?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(checkCodigoSQL)) {
	            preparedStatement.setString(1, codigo);
	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                if (resultSet.next()) {
	                    int count = resultSet.getInt(1);
	                    return count > 0;
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	
	protected boolean pedidoExiste(int id) {
	    try (Connection connection = criarBanco.getConnection()) {
	        String checkCodigoSQL = "SELECT COUNT(*) FROM pedido WHERE id = ?";
	        try (PreparedStatement preparedStatement = connection.prepareStatement(checkCodigoSQL)) {
	            preparedStatement.setInt(1, id);
	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                if (resultSet.next()) {
	                    int count = resultSet.getInt(1);
	                    return count > 0;
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
}
