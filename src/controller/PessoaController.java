package controller;

public class PessoaController {
	
	public PessoaController() {
				
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
		
		// Verificar primeiro dígito verificador
		int soma = 0;
		for (int i = 0; i < 9; i++) {
		    soma += numeros[i] * (10 - i);
		}
		int resto = soma % 11;
		int digitoVerificador1 = (resto < 2) ? 0 : (11 - resto);
		
		if (digitoVerificador1 != numeros[9]) {
		    return false;
		}
	
		// Verificar segundo dígito verificador
	    soma = 0;
	    for (int i = 0; i < 10; i++) {
	        soma += numeros[i] * (11 - i);
	    }
	    resto = soma % 11;
	    int digitoVerificador2 = (resto < 2) ? 0 : (11 - resto);
	
	    return digitoVerificador2 == numeros[10];
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
		
		// Verificar primeiro dígito verificador
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
		
		// Verificar segundo dígito verificador
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
