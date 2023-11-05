package models;

public class PessoaFisica extends Cliente {
    private String cpf;
    
    public PessoaFisica(int id, String nomeCliente, String cpf) {
        super(id, nomeCliente);
        this.cpf = cpf;
    }
    public PessoaFisica(String nomeCliente, String cpf) {
        super(nomeCliente);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}