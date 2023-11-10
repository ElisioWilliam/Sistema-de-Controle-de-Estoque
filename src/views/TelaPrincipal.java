package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import controller.*;
import models.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal extends JFrame {
    private JTabbedPane tabbedPane;
    private JPanel produtosPanel;
    private JPanel clientesPanel;
    private JPanel pedidosPanel;
    private static final String[] columnNames = { "Nome", "Ação" };

    public TelaPrincipal() {
        setTitle("Sistema de Gerenciamento");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        tabbedPane = new JTabbedPane();
        clientesPanel = new ClienteListPanel(); 
        produtosPanel = new ProdutoListPanel();
        pedidosPanel = new PedidoListPanel();

        tabbedPane.addTab("Clientes", clientesPanel);
        tabbedPane.addTab("Produtos", produtosPanel);
        tabbedPane.addTab("Pedidos", pedidosPanel);

        add(tabbedPane);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	//PessoaFisicaController pf = new PessoaFisicaController();
                	//PessoaFisica pessoa = new PessoaFisica("Bebel", "112.772.440-14");
                	//pf.cadastrarPessoaFisica(pessoa);
                	
                	//ProdutoController pc = new ProdutoController();
                	//Produto produto = new Produto("Bomba de Frango", "123127", 10, (float) 2.50);
                	//pc.cadastrarProduto(produto);
                	
                	//BancoController controller = new BancoController();
                    //List<Pedido> pedidoList = controller.readPedido();
                    //for (Pedido pedido : pedidoList) {
                    //    System.out.println(pedido.getId());
                    //}
                	
                	//PedidoController pedidoController = new PedidoController();
                	//pedidoController.cadastrarPedido("11277244014", "123127", 2);
                	
                	TelaPrincipal frame = new TelaPrincipal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
