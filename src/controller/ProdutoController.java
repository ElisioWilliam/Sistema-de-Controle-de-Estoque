package controller;

import models.Produto; 
import javax.swing.JOptionPane;

public class ProdutoController {
	private BancoController bancoController;
	
	public ProdutoController() {
		bancoController = new BancoController();
	}
	
	public void cadastrarProduto(Produto produto) {
		String mensagem = "";
		if(produto.getCodigo() != null && produto.getNome() != null && produto.getPreco()> 0 && produto.getQuantidade() > 0) {
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
	
	public void atualizarProduto(Produto produto) {
		String mensagem = "";
		if(produto.getCodigo() != null && produto.getNome() != null && produto.getPreco()> 0 && produto.getQuantidade() > 0) {
			if(bancoController.codigoExiste(produto.getCodigo())) {
				bancoController.updateProduto(produto.getNome(), produto.getCodigo(), produto.getQuantidade(), produto.getPreco());
				mensagem = "Produto atualizado com sucesso!";
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
	
	public void deletarProduto(String codigo) {
		String mensagem = "";

		if(bancoController.codigoExiste(codigo)) {
			bancoController.deleteProduto(codigo);
			mensagem = "Produto deletado com sucesso!";
			JOptionPane.showMessageDialog(null, mensagem);
		}else {
			mensagem = "Código indisponível!";
			JOptionPane.showMessageDialog(null, mensagem);
		}
	}
	
	public void atualizarQuantidade(Produto produto, int quantidade) {
		bancoController.updateQuantidadeProduto(produto.getId(),(produto.getQuantidade() - quantidade));
	}
	
	public void atualizarQuantidade(String codigoProduto, int quantidade) {
		Produto produto = bancoController.getProduto(codigoProduto);
		
		bancoController.updateQuantidadeProduto(produto.getId(),(produto.getQuantidade() + quantidade));
	}
	
	public void definirQuantidade(Produto produto, int quantidade) {
		bancoController.updateQuantidadeProduto(produto.getId(), quantidade);
	}
}
