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
		
		boolean cpfExiste = bancoController.cpfExiste(documento);
		boolean cnpjExiste = bancoController.cnpjExiste(documento);
		boolean produtoExiste = bancoController.produtoExiste(produto.getId());
		
		if((cpfExiste || cnpjExiste) && produtoExiste && produto.getQuantidade()>= quantidade && quantidade > 0) {
			
			Pedido pedido = new Pedido(produto.getCodigo(), documento, quantidade, (float) quantidade * produto.getPreco());
			
			bancoController.createPedido(pedido.getCodigoProduto(), pedido.getDocumentoPessoa(), pedido.getQuantidadeProduto(), pedido.getValorTotal());
			
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
		Produto produto = bancoController.getProduto(codigo);
		System.out.println(produto.getCodigo());
		
		cadastrarPedido(documento, produto, quantidade);
	}
	
	public void atualizarPedido(int id, String documento, Produto produto, int quantidade) {
		String mensagem = "";
		
		boolean cpfExiste = bancoController.cpfExiste(documento);
		boolean cnpjExiste = bancoController.cnpjExiste(documento);
		boolean produtoExiste = bancoController.produtoExiste(produto.getId());
		boolean pedidoExiste = bancoController.pedidoExiste(id);
		
		if(pedidoExiste) {
			Pedido pedidoCadastrado = bancoController.getPedido(id);
			
			if(pedidoCadastrado.getQuantidadeProduto() + produto.getQuantidade() - quantidade >= 0) {
				if((cpfExiste || cnpjExiste)) {
					
					Pedido pedido = new Pedido(id, produto.getCodigo(), documento, quantidade, (float) quantidade * produto.getPreco());
					
					bancoController.updatePedido(pedido.getId(), pedido.getCodigoProduto(), pedido.getDocumentoPessoa(), pedido.getQuantidadeProduto(), pedido.getValorTotal());
					
					ProdutoController produtoController = new ProdutoController();
					produtoController.definirQuantidade(produto, pedidoCadastrado.getQuantidadeProduto() + produto.getQuantidade() - quantidade);
					
					mensagem = "Pedido atualizado com sucesso!";
					JOptionPane.showMessageDialog(null, mensagem);
				}else {
					mensagem = "Dados inseridos incorretamente";
					JOptionPane.showMessageDialog(null, mensagem);
				}
			}else {
				mensagem = "Quantidade invalida";
				JOptionPane.showMessageDialog(null, mensagem);
			}
		}else {
			mensagem = "Pedido não existe";
			JOptionPane.showMessageDialog(null, mensagem);
		}
	}
	
	public void atualizarPedido(int id, String documento, String codigo, int quantidade) {
		Produto produto = bancoController.getProduto(codigo);
	
		atualizarPedido(id, documento, produto, quantidade);
	}
	
	public void cancelarPedido(int id) {
		String mensagem = "";
		
		boolean pedidoExiste = bancoController.pedidoExiste(id);
		
		
		if(pedidoExiste) {			
			Pedido pedido = bancoController.getPedido(id);
			Produto produto = bancoController.getProduto(pedido.getCodigoProduto());
			System.out.println(pedido.getCodigoProduto());
			ProdutoController produtoController = new ProdutoController();
			produtoController.definirQuantidade(produto, pedido.getQuantidadeProduto() + produto.getQuantidade());
			
			bancoController.deletePedido(pedido.getId());
								
			mensagem = "Pedido deletado com sucesso!";
			JOptionPane.showMessageDialog(null, mensagem);
		}else {
			mensagem = "Pedido não existe!";
			JOptionPane.showMessageDialog(null, mensagem);
		}			
	}
}
