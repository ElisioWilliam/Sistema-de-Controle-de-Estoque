package models;

public class Cliente {
    private int id;
    private String nomeCliente;

    public Cliente(int id, String nomeCliente) {
        this.id = id;
        this.nomeCliente = nomeCliente;
    }
    public Cliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getId() {
        return id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setNomeCliente(String nome) {
        this.nomeCliente = nome;
    }
}