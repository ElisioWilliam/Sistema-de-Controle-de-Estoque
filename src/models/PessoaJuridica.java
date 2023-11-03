package models;

import java.util.UUID;

public class PessoaJuridica extends Cliente {
    private String cpnj;

    public PessoaJuridica(int id, String nomeCliente, String cnpj) {
        super(id, nomeCliente, cnpj);
        this.cpnj = cnpj;
    }

    public String getCpnj() {
        return cpnj;
    }

}