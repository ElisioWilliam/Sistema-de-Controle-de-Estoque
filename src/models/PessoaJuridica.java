package models;

public class PessoaJuridica extends Cliente {
    private String cnpj;

    public PessoaJuridica(int id, String nomeCliente, String cnpj) {
        super(id, nomeCliente);
        this.cnpj = cnpj;
    }
    public PessoaJuridica(String nomeCliente, String cnpj) {
        super(nomeCliente);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}