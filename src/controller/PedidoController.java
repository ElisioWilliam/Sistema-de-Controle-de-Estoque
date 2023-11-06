package controller;

import models.Pedido;
import models.Produto;
import javax.swing.JOptionPane;

public class PedidoController {
	private BancoController bancoController;
	
	public PedidoController() {
		bancoController = new BancoController();
	}
	
	public void cadastrarPedido(String documento, Produto produto, int quantidade) {
		String mensagem = "";
		if((bancoController.cpfExiste(documento) || bancoController.cnpjExiste(documento)) && bancoController.produtoExiste(produto.getId()) && produto.getQuantidade()>= quantidade) {
			
			Pedido pedido = new Pedido(produto.getId(), documento, quantidade, (quantidade * produto.getPreco()));
			
			bancoController.createPedido(pedido.getIdProduto(), pedido.getDocumentoPessoa(), pedido.getQuantidadeProduto(), pedido.getValorTotal());
			
			ProdutoController produtoController = new ProdutoController();
			produtoController.atualizarQuantidade(produto, quantidade);
			
			mensagem = "Pedido realizado com sucesso!";
			JOptionPane.showMessageDialog(null, mensagem);
		}else {
			mensagem = "Dados inseridos incorretamente";
			JOptionPane.showMessageDialog(null, mensagem);
		}
	}
	
	public void cadastrarPedido(String documento, String codigo, int quantidade) {
		String mensagem = "";
		Produto produto = bancoController.getProduto(codigo);
		
		if((bancoController.cpfExiste(documento) || bancoController.cnpjExiste(documento)) && bancoController.produtoExiste(produto.getId()) && produto.getQuantidade()>= quantidade) {
			
			Pedido pedido = new Pedido(produto.getId(), documento, quantidade, (quantidade * produto.getPreco()));
			
			bancoController.createPedido(pedido.getIdProduto(), pedido.getDocumentoPessoa(), pedido.getQuantidadeProduto(), pedido.getValorTotal());
			
			ProdutoController produtoController = new ProdutoController();
			produtoController.atualizarQuantidade(produto, quantidade);
			
			mensagem = "Pedido realizado com sucesso!";
			JOptionPane.showMessageDialog(null, mensagem);
		}else {
			mensagem = "Dados inseridos incorretamente";
			JOptionPane.showMessageDialog(null, mensagem);
		}
	}
	
	public void cancelarPedido(Pedido pedido) {
		String mensagem = "";
			
		bancoController.deletePedido(pedido.getId());
		
		ProdutoController produtoController = new ProdutoController();
		produtoController.atualizarQuantidade(pedido.getIdProduto(), pedido.getQuantidadeProduto());
		
		mensagem = "Pedido realizado com sucesso!";
		JOptionPane.showMessageDialog(null, mensagem);		
	}
}
