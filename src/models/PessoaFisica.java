package models;

public class PessoaFisica extends Cliente {
    private String cpf;
    
    public PessoaFisica(int id, String nomeCliente, String cpf) {
        super(id, nomeCliente, cpf);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
    
}