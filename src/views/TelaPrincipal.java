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

    private void carregarDadosProdutos() {
        // Implemente a lógica para listar produtos aqui.
        // Pode ser uma JTable, JList ou outro componente para exibir a lista de produtos.
        // Adicione esse componente ao produtosPanel.
    }

    private void carregarDadosClientes() {
        // Chame seu método readPessoaFisica para obter a lista
    	BancoController controller = new BancoController();
	    // Chame seu método readPessoaFisica para obter a lista
	    List<PessoaFisica> pessoaFisicaList = controller.readPessoaFisica(); // Certifique-se de ajustar o nome do controlador

	    DefaultListModel<JPanel> listModel = new DefaultListModel<>();
	    for (PessoaFisica pessoa : pessoaFisicaList) {
	        JPanel panel = new JPanel(new GridLayout(1, 3)); // 3 colunas: ID, Nome, Botão
	        String pessoaInfo = String.valueOf(pessoa.getId());
	        JLabel idLabel = new JLabel(pessoaInfo);
	        JLabel nomeLabel = new JLabel(pessoa.getNomeCliente());
	        JButton button = new JButton("Atualizar");

	        // Adicione um ActionListener ao botão, se necessário
	        button.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Lógica quando o botão é clicado
	                // Pode ser abrir uma nova janela, editar a pessoa, etc.
	            }
	        });

	        panel.add(idLabel);
	        panel.add(nomeLabel);
	        panel.add(button);

	        listModel.addElement(panel);
	    }

	    JList<JPanel> clienteList = new JList<>(listModel);
	    clienteList.setCellRenderer(new PanelListCellRenderer());
	    JScrollPane scrollPane = new JScrollPane(clienteList);

	    clientesPanel.setLayout(new BorderLayout());
	    clientesPanel.add(scrollPane, BorderLayout.CENTER);
	}


    // Classe para personalizar a renderização do JPanel na JList
    class PanelListCellRenderer implements ListCellRenderer<JPanel> {
        @Override
        public Component getListCellRendererComponent(JList<? extends JPanel> list, JPanel value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            return value;
        }
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
