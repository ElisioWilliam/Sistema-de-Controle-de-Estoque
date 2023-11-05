package controller;

import controller.BancoController;
import models.Pedido;
import javax.swing.JOptionPane;

public class PedidoController {
	private BancoController bancoController;
	
	public PedidoController() {
		bancoController = new BancoController();
	}
	
	public void cadastrarPedido(Pedido pedido) {
		String mensagem = "";
		
		if((bancoController.cpfExiste(pedido.getDocumentoPessoa()) || bancoController.cnpjExiste(pedido.getDocumentoPessoa())) && bancoController.produtoExiste(pedido.getIdProduto()) ) {	
			bancoController.createPedido(pedido.getIdProduto(), pedido.getDocumentoPessoa(), pedido.getQuantidadeProduto(), pedido.getValorTotal());
			mensagem = "Pedido realizado com sucesso!";
			JOptionPane.showMessageDialog(null, mensagem);
		}else {
			mensagem = "Dados inseridos incorretamente";
			JOptionPane.showMessageDialog(null, mensagem);
		}
		
	}
}
