package models;

public class Testar {
    public static void main(String[] args) {
        String nomeCliente = "Maria";
        String cpfCnpj = "987654321";

        Cliente cliente = new Cliente(nomeCliente, cpfCnpj);

        System.out.println("Nome: " + cliente.getNomeCliente() + ", " + "CPF: " + cliente.getCpfCnpj());

    }

}