package views;

import javax.swing.*;
import controller.*;
import models.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PedidoListPanel extends JPanel {
    public PedidoListPanel() {
        carregarDadosPedidos();
    }

    private void carregarDadosPedidos() {
        BancoController controller = new BancoController();
        List<Pedido> pedidoList = controller.readPedido();

        DefaultListModel<JPanel> listModel = new DefaultListModel<>();
        for (Pedido pedido : pedidoList) {
            JPanel panel = criarPainelPedido(pedido);
            listModel.addElement(panel);
        }

        JList<JPanel> pedidoJList = new JList<>(listModel);
        pedidoJList.setCellRenderer(new PanelListCellRenderer());
        JScrollPane scrollPane = new JScrollPane(pedidoJList);

        setLayout(new BorderLayout());
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

        JButton button = new JButton("Atualizar");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para atualizar o pedido
                // Pode envolver a abertura de uma nova janela de atualização, por exemplo.
                // Certifique-se de adicionar essa lógica conforme necessário.
            }
        });

        panel.add(idLabel);
        panel.add(codigoLabel);
        panel.add(documentoLabel);
        panel.add(precoLabel);
        panel.add(quantidadeLabel);
        panel.add(button);

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