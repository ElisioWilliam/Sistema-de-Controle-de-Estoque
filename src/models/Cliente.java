package models;

import java.util.UUID; //pra gerar id unico pra cada cliente

public class Cliente {
    private int id;
    private String nomeCliente;
    private String cpfCnpj;

    //construtor de cliente pra poder manipular o id
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