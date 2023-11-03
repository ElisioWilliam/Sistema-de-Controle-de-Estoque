package models;

public class Cliente {
    private int id;
    private String nomeCliente;
    private String cpfCnpj;

    public Cliente(int id, String nomeCliente, String documento) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.cpfCnpj = documento;
    }

    public int getId() {
        return id;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }
    
}