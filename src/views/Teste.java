package views;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import conexao.CriarBanco;
import controller.*;
import models.*; 

public class Teste {

	public static void main(String[] args) {
        BancoController bancoController = new BancoController();
        ProdutoController produtoController = new ProdutoController();
        PessoaFisicaController pessoaFisicaController = new PessoaFisicaController();
        PessoaJuridicaController pessoaJuridicaController = new PessoaJuridicaController();
        
        PessoaFisica pessoaF = new PessoaFisica("Joao Manuel Gomes", "638.821.740-05");
        pessoaFisicaController.cadastrarPessoaFisica(pessoaF);    
        
        List<Produto> produtoList = bancoController.readProduto();
        for (Produto produto : produtoList) {
            System.out.println("ID: " + produto.getId());
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Código: " + produto.getCodigo());
            System.out.println("Quantidade: " + produto.getQuantidade());
            System.out.println("Preço: " + produto.getPreco());
            System.out.println(); 
        }
	}	
}