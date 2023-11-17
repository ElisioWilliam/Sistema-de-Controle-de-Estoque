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
		if(produto.getPreco() > 0) {
			if(produto.getQuantidade() > 0) {
				if(!bancoController.codigoExiste(produto.getCodigo())) {
					bancoController.createProduto(produto.getNome(), produto.getCodigo(), produto.getQuantidade(), produto.getPreco());
					mensagem = "Produto cadastrado com sucesso!";
					JOptionPane.showMessageDialog(null, mensagem);
				}else {
					mensagem = "Código indisponível!";
					JOptionPane.showMessageDialog(null, mensagem);
				}
			}else {
				mensagem = "Quantidade invalida";
				JOptionPane.showMessageDialog(null, mensagem);
			}
		}else {
			mensagem = "Preço invalido";
			JOptionPane.showMessageDialog(null, mensagem);
		}
	}
	
	public void atualizarProduto(Produto produto) {
		String mensagem = "";
		if(produto.getPreco()> 0) {
			if(produto.getQuantidade() > 0) {
				if(bancoController.codigoExiste(produto.getCodigo())) {
					bancoController.updateProduto(produto.getNome(), produto.getCodigo(), produto.getQuantidade(), produto.getPreco());
					mensagem = "Produto atualizado com sucesso!";
					JOptionPane.showMessageDialog(null, mensagem);
				}else {
					mensagem = "Código indisponível!";
					JOptionPane.showMessageDialog(null, mensagem);
				}
			}else {
				mensagem = "Quantidade invalido";
				JOptionPane.showMessageDialog(null, mensagem);
			}
		}else {
			mensagem = "Preço invalido";
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
		boolean produtoExiste = bancoController.produtoExiste(codigoProduto);
		
		if(produtoExiste) {
			Produto produto = bancoController.getProduto(codigoProduto);
			
			bancoController.updateQuantidadeProduto(produto.getId(),(produto.getQuantidade() + quantidade));
		}else {
			String mensagem = "Produto não existe";
			JOptionPane.showMessageDialog(null, mensagem);
		}
	}
	
	public void definirQuantidade(Produto produto, int quantidade) {
		boolean produtoExiste = bancoController.produtoExiste(produto.getCodigo());
		
		if(produtoExiste) {			
			bancoController.updateQuantidadeProduto(produto.getId(), quantidade);
		}else {
			String mensagem = "Produto não existe";
			JOptionPane.showMessageDialog(null, mensagem);
		}
		
	}
}