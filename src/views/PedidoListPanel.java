package views;

import javax.swing.*;
import controller.*;
import models.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PedidoListPanel extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JList<JPanel> pedidoJList;

    public PedidoListPanel() {
        carregarDadosPedidos();
    }

    private void carregarDadosPedidos() {
        BancoController controller = new BancoController();
        List<Pedido> pedidoList = controller.readPedido();

        DefaultListModel<JPanel> listModel = new DefaultListModel<>();
        JPanel panelHeader = criarHeaderPainelPedido();
        listModel.addElement(panelHeader);
        
        for (Pedido pedido : pedidoList) {
            JPanel panel = criarPainelPedido(pedido);
            listModel.addElement(panel);
        }

        pedidoJList = new JList<>(listModel);
        pedidoJList.setCellRenderer(new PanelListCellRenderer());
        JScrollPane scrollPane = new JScrollPane(pedidoJList);

        JButton botaoCadastrar = new JButton("CADASTRAR");
        JButton botaoAtualizar = new JButton("ATUALIZAR");
        JButton botaoDeletar = new JButton("DELETAR");

        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new PedidoCadastrarDialog();
            }
        });

        botaoAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new PedidoAtualizarDialog();
            }
        });

        botaoDeletar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new PedidoDeletarDialog();
            }
        });

        JPanel botoesPanel = new JPanel();
        botoesPanel.add(botaoCadastrar);
        botoesPanel.add(botaoAtualizar);
        botoesPanel.add(botaoDeletar);

        setLayout(new BorderLayout());
        add(botoesPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private JPanel criarPainelPedido(Pedido pedido) {
        JPanel panel = new JPanel(new GridLayout(1, 6));

        String id = String.valueOf(pedido.getId());
        String quantidade = String.valueOf(pedido.getQuantidadeProduto());
        String preco = String.valueOf(pedido.getValorTotal());

        JLabel idLabel = new JLabel(id);
        JLabel codigoLabel = new JLabel(pedido.getCodigoProduto());
        JLabel documentoLabel = new JLabel(pedido.getDocumentoPessoa());
        JLabel precoLabel = new JLabel(preco);
        JLabel quantidadeLabel = new JLabel(quantidade);

        panel.add(idLabel);
        panel.add(codigoLabel);
        panel.add(documentoLabel);
        panel.add(precoLabel);
        panel.add(quantidadeLabel);

        return panel;
    }
    
    private JPanel criarHeaderPainelPedido() {
        JPanel panel = new JPanel(new GridLayout(1, 6));

        JLabel idLabel = new JLabel("Id");
        JLabel codigoLabel = new JLabel("Codigo");
        JLabel documentoLabel = new JLabel("Documento");
        JLabel precoLabel = new JLabel("Preço");
        JLabel quantidadeLabel = new JLabel("Quantidade");

        panel.add(idLabel);
        panel.add(codigoLabel);
        panel.add(documentoLabel);
        panel.add(precoLabel);
        panel.add(quantidadeLabel);

        return panel;
    }

    private static class PanelListCellRenderer implements ListCellRenderer<JPanel> {
        @Override
        public Component getListCellRendererComponent(JList<? extends JPanel> list, JPanel value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            return value;
        }
    }
}
