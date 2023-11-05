package conexao;

import java.sql.*;

public class CriarBanco {
	private Connection connection;

    public CriarBanco() {
        try {
            // Conectar ao banco de dados (ou criá-lo se não existir)
            connection = DriverManager.getConnection("jdbc:sqlite:db_sistema_de_gerenciamento_de_estoque.db");
            criarTabelas();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void criarTabelas() {
        try {
            if (connection != null) {
                Statement statement = connection.createStatement();
                String createTablePessoaFisica = "CREATE TABLE IF NOT EXISTS pessoa_fisica (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, cpf TEXT)";
                String createTablePessoaJuridica = "CREATE TABLE IF NOT EXISTS pessoa_juridica (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, cnpj TEXT)";
                String createTablePedido = "CREATE TABLE IF NOT EXISTS pedido (id INTEGER PRIMARY KEY AUTOINCREMENT, documento_pessoa TEXT, id_produto INTEGER, quantidade_produto INTEGER, valor_total FLOAT)";
                String createTableProduto = "CREATE TABLE IF NOT EXISTS produto (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, codigo TEXT, quantidade INTEGER, preco FLOAT)";
                statement.executeUpdate(createTablePessoaFisica);
                statement.executeUpdate(createTablePessoaJuridica);
                statement.executeUpdate(createTablePedido);
                statement.executeUpdate(createTableProduto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Connection getConnection() {
    	return connection;
    }

    public void fecharConexao() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}