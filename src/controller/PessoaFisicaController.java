package controller;

import models.PessoaFisica;
import javax.swing.JOptionPane;

public class PessoaFisicaController {
	
	private BancoController bancoController;
	
	public PessoaFisicaController() {
		bancoController = new BancoController();
	}
	
	public void cadastrarPessoaFisica(PessoaFisica pessoaFisica) {
		String mensagem = "";
		pessoaFisica.setCpf(pessoaFisica.getCpf().replaceAll("[^0-9]", ""));
		
		if(!pessoaFisica.getNomeCliente().isEmpty()) {
			if(verificarCPF(pessoaFisica.getCpf())) {
				if(!bancoController.cpfExiste(pessoaFisica.getCpf())) {
					bancoController.createPessoaFisica(pessoaFisica.getNomeCliente(), pessoaFisica.getCpf());
					mensagem = "Pessoa Fisica cadastrada com sucesso!";
					JOptionPane.showMessageDialog(null, mensagem);
				}else {
					mensagem = "CPF indisponível!";
					JOptionPane.showMessageDialog(null, mensagem);
				}
			}else {
				mensagem = "CPF invalido";
				JOptionPane.showMessageDialog(null, mensagem);
			}
		}else {
			mensagem = "Preencha todos os campos";
			JOptionPane.showMessageDialog(null, mensagem);
		}
	}
	
	public void atualizarPessoaFisica(PessoaFisica pessoaFisica) {
		String mensagem = "";
		pessoaFisica.setCpf(pessoaFisica.getCpf().replaceAll("[^0-9]", ""));
		
		if(!pessoaFisica.getNomeCliente().isEmpty()) {
			if(verificarCPF(pessoaFisica.getCpf())) {
				if(bancoController.cpfExiste(pessoaFisica.getCpf())) {
					bancoController.updatePessoaFisica(pessoaFisica.getNomeCliente(), pessoaFisica.getCpf());
					
					mensagem = "Pessoa Fisica atualizada com sucesso!";
					JOptionPane.showMessageDialog(null, mensagem);
				}else {
					mensagem = "CPF indisponível!";
					JOptionPane.showMessageDialog(null, mensagem);
				}
			}else {
				mensagem = "CPF invalido";
				JOptionPane.showMessageDialog(null, mensagem);
			}
		}else {
			mensagem = "Preencha todos os campos";
			JOptionPane.showMessageDialog(null, mensagem);
		}
	}
	
	public void deletarPessoaFisica(String cpf) {
		String mensagem = "";
		
		if(verificarCPF(cpf)) {
			if(bancoController.cpfExiste(cpf)) {
				bancoController.deletePessoaFisica(cpf);
				
				mensagem = "Pessoa Fisica deletada com sucesso!";
				JOptionPane.showMessageDialog(null, mensagem);
			}else {
				mensagem = "CPF indisponível!";
				JOptionPane.showMessageDialog(null, mensagem);
			}
		}else {
			mensagem = "CPF invalido";
			JOptionPane.showMessageDialog(null, mensagem);
		}
	}
	
	public static boolean verificarCPF(String cpf) {
        String regex = "^[0-9]{11}$";
		if (!cpf.matches(regex)) {
		    return false;
		}
		
		int[] numeros = new int[11];
		
		for (int i = 0; i < 11; i++) {
		    numeros[i] = Integer.parseInt(cpf.substring(i, i + 1));
		}
		
		int soma = 0;
		for (int i = 0; i < 9; i++) {
		    soma += numeros[i] * (10 - i);
		}
		int resto = soma % 11;
		int digitoVerificador1 = (resto < 2) ? 0 : (11 - resto);
		
		if (digitoVerificador1 != numeros[9]) {
		    return false;
		}
	
	    soma = 0;
	    for (int i = 0; i < 10; i++) {
	        soma += numeros[i] * (11 - i);
	    }
	    resto = soma % 11;
	    int digitoVerificador2 = (resto < 2) ? 0 : (11 - resto);
	
	    return digitoVerificador2 == numeros[10];
	}
}
