package controller;

import controller.BancoController;
import models.Produto; 
import javax.swing.JOptionPane;

public class ProdutoController {
	private BancoController bancoController;
	
	public ProdutoController() {
		bancoController = new BancoController();
	}
	
	public void cadastrarProduto(Produto produto) {
		String mensagem = "";
		
		if(produto.getCodigo() != "" && produto.getNome() != "" && produto.getPreco()> 0 && produto.getQuantidade() > 0) {
			if(!bancoController.codigoExiste(produto.getCodigo())) {
				bancoController.createProduto(produto.getNome(), produto.getCodigo(), produto.getQuantidade(), produto.getPreco());
				mensagem = "Produto cadastrado com sucesso!";
				JOptionPane.showMessageDialog(null, mensagem);
			}else {
				mensagem = "Código indisponível!";
				JOptionPane.showMessageDialog(null, mensagem);
			}
		}else {
			mensagem = "Dados inseridos incorretamente";
			JOptionPane.showMessageDialog(null, mensagem);
		}
	}
}
