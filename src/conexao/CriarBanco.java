package conexao;

import java.sql.*;

public class CriarBanco {
    private Connection connection;

    public CriarBanco() {
        // Não abra a conexão no construtor
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                // Abra uma nova conexão se ainda não estiver aberta ou se estiver fechada
                connection = DriverManager.getConnection("jdbc:sqlite:db_sistema_de_gerenciamento_de_estoque.db");
                criarTabelas();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public void fecharConexao() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void criarTabelas() {
        try {
            if (connection != null) {
                Statement statement = connection.createStatement();
                String createTablePessoaFisica = "CREATE TABLE IF NOT EXISTS pessoa_fisica (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, cpf TEXT)";
                String createTablePessoaJuridica = "CREATE TABLE IF NOT EXISTS pessoa_juridica (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, cnpj TEXT)";
                String createTablePedido = "CREATE TABLE IF NOT EXISTS pedido (id INTEGER PRIMARY KEY AUTOINCREMENT, documento_pessoa TEXT, codigo_produto TEXT, quantidade_produto INTEGER, valor_total FLOAT)";
                String createTableProduto = "CREATE TABLE IF NOT EXISTS produto (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, codigo TEXT, quantidade INTEGER, preco FLOAT)";

                statement.executeUpdate(createTablePessoaFisica);
                statement.executeUpdate(createTablePessoaJuridica);
                statement.executeUpdate(createTablePedido);
                statement.executeUpdate(createTableProduto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
