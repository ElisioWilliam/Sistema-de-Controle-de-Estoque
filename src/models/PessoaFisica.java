package models;

import java.util.UUID;

public class PessoaFisica extends Cliente {
    private String cpf;
    
    public PessoaFisica(UUID id, String nomeCliente, String cpf) {
        super(id, nomeCliente, cpf);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
    
}