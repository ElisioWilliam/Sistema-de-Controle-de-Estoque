package views;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import conexao.CriarBanco;
import controller.BancoController;
import controller.PessoaController;
import models.PessoaFisica; 

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String numero = "12345678909"; // Substitua este valor com o CPF ou CNPJ que você deseja verificar
        PessoaController pessoaController = new PessoaController();
        if (pessoaController.verificarCPF(numero)) {
            System.out.println("CPF válido!");
        } else if (pessoaController.verificarCNPJ(numero)) {
            System.out.println("CNPJ válido!");
        } else {
            System.out.println("Número inválido!");
        }
        
        BancoController bancoController;
        
        bancoController = new BancoController();
        
        List<PessoaFisica> pessoaFisicaList = bancoController.readPessoaFisica();
        for (PessoaFisica pessoaFisica : pessoaFisicaList) {
            System.out.println("ID: " + pessoaFisica.getId());
            System.out.println("Nome: " + pessoaFisica.getNomeCliente());
            System.out.println("CPF: " + pessoaFisica.getCpf());
            System.out.println(); 
        }
	}	
}