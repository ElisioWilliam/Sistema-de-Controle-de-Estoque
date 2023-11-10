package controller;

import controller.BancoController;
import models.PessoaJuridica;
import javax.swing.JOptionPane;

public class PessoaJuridicaController {

	private BancoController bancoController;
	
	public PessoaJuridicaController() {
		bancoController = new BancoController();
	}
	
	public void cadastrarPessoaJuridica(PessoaJuridica pessoaJuridica) {
		String mensagem = "";
		pessoaJuridica.setCnpj(pessoaJuridica.getCnpj().replaceAll("[^0-9]", ""));
		
		if(pessoaJuridica.getNomeCliente() != "" && verificarCNPJ(pessoaJuridica.getCnpj())) {
			if(!bancoController.cnpjExiste(pessoaJuridica.getCnpj())) {
				bancoController.createPessoaJuridica(pessoaJuridica.getNomeCliente(), pessoaJuridica.getCnpj());
				mensagem = "Pessoa Juridica cadastrada com sucesso!";
				JOptionPane.showMessageDialog(null, mensagem);
			}else {
				mensagem = "CNPJ indisponível!";
				JOptionPane.showMessageDialog(null, mensagem);
			}
		}else {
			mensagem = "Dados inseridos incorretamente";
			JOptionPane.showMessageDialog(null, mensagem);
		}
	}
	
	public static boolean verificarCNPJ(String cnpj) {
	    String regex = "^[0-9]{14}$";
		if (!cnpj.matches(regex)) {
		    return false;
		}
		
		int[] numeros = new int[14];
		for (int i = 0; i < 14; i++) {
		    numeros[i] = Integer.parseInt(cnpj.substring(i, i + 1));
		}
		
		int soma = 0;
		int peso = 5;
		for (int i = 0; i < 12; i++) {
		    soma += numeros[i] * peso;
		    peso = (peso == 2) ? 9 : (peso - 1);
		}
		int resto = soma % 11;
		int digitoVerificador1 = (resto < 2) ? 0 : (11 - resto);
		
		if (digitoVerificador1 != numeros[12]) {
		    return false;
		}
		
	    soma = 0;
	    peso = 6;
	    for (int i = 0; i < 13; i++) {
	        soma += numeros[i] * peso;
	        peso = (peso == 2) ? 9 : (peso - 1);
	    }
	    resto = soma % 11;
	    int digitoVerificador2 = (resto < 2) ? 0 : (11 - resto);
	
	    return digitoVerificador2 == numeros[13];
	}

}
