package views;

import javax.swing.*;

import controller.*;
import models.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ProdutoListPanel extends JPanel {
    public ProdutoListPanel() {
        carregarDadosClientes();
    }

    private void carregarDadosClientes() {
        BancoController controller = new BancoController();
        List<Produto> produtoList = controller.readProduto();
        
        DefaultListModel<JPanel> listModel = new DefaultListModel<>();
        for (Produto produto : produtoList) {
            JPanel panel = new JPanel(new GridLayout(1, 5));
            
            String id = String.valueOf(produto.getId());
            String quantidade = String.valueOf(produto.getQuantidade());
            String preco = String.valueOf(produto.getPreco());
            
            JLabel nomeLabel = new JLabel(produto.getNome());
            JLabel codigoLabel = new JLabel(produto.getCodigo());
            JLabel precoLabel = new JLabel(preco);
            JLabel quantidadeLabel = new JLabel(quantidade);
            
            
            JButton button = new JButton("Atualizar");

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Lógica quando o botão é clicado
                    // Pode ser abrir uma nova janela, editar a pessoa, etc.
                }
            });

            panel.add(codigoLabel);
            panel.add(nomeLabel);
            panel.add(precoLabel);
            panel.add(quantidadeLabel);
            panel.add(button);

            listModel.addElement(panel);
        }
        
        JList<JPanel> clienteList = new JList<>(listModel);
        clienteList.setCellRenderer(new PanelListCellRenderer());
        JScrollPane scrollPane = new JScrollPane(clienteList);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
    }

    // Classe para personalizar a renderização do JPanel na JList
    private static class PanelListCellRenderer implements ListCellRenderer<JPanel> {
        @Override
        public Component getListCellRendererComponent(JList<? extends JPanel> list, JPanel value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            return value;
        }
    }
}

