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
		
		if((cpfExiste || cnpjExiste) && produtoExiste && produto.getQuantidade()>= quantidade) {
			
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
	
	public void cancelarPedido(Pedido pedido) {
		String mensagem = "";
			
		bancoController.deletePedido(pedido.getId());
		
		ProdutoController produtoController = new ProdutoController();
		produtoController.atualizarQuantidade(pedido.getCodigoProduto(), pedido.getQuantidadeProduto());
		
		mensagem = "Pedido realizado com sucesso!";
		JOptionPane.showMessageDialog(null, mensagem);		
	}
}
