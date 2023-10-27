package models;

import java.util.UUID; //pra gerar id unico pra cada cliente

public class Cliente {
    private UUID id;
    private String nomeCliente;
    private String cpfCnpj;

    //construtor de cliente pra poder manipular o id
    public Cliente(UUID id, String nomeCliente, String documento) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.cpfCnpj = documento;
    }

    //construtor onde gera um id aleatorio unico
    public Cliente(String nomeCliente, String cpfCnpj) {
        this.id = UUID.randomUUID();
        this.nomeCliente = nomeCliente;
        this.cpfCnpj = cpfCnpj;
    }

    public UUID getId() {
        return id;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }
    
}