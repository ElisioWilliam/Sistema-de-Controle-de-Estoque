package views;

import javax.swing.*;
import controller.*;
import models.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ProdutoListPanel extends JPanel {
    private JList<JPanel> produtoList;

    public ProdutoListPanel() {
        carregarDadosProdutos();
    }

    private void carregarDadosProdutos() {
        BancoController controller = new BancoController();
        List<Produto> produtosList = controller.readProduto();

        DefaultListModel<JPanel> listModel = new DefaultListModel<>();
        for (Produto produto : produtosList) {
            JPanel panel = criarPainelProduto(produto);
            listModel.addElement(panel);
        }

        produtoList = new JList<>(listModel);
        produtoList.setCellRenderer(new PanelListCellRenderer());
        JScrollPane scrollPane = new JScrollPane(produtoList);

        JButton botaoCadastrar = new JButton("CADASTRAR");
        JButton botaoAtualizar = new JButton("ATUALIZAR");
        JButton botaoDeletar = new JButton("DELETAR");

        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new ProdutoCadastrarDialog();
            }
        });

        botaoAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new ProdutoAtualizarDialog();
            }
        });

        botaoDeletar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new ProdutoDeletarDialog();
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

    private JPanel criarPainelProduto(Produto produto) {
        JPanel panel = new JPanel(new GridLayout(1, 5));

        String id = String.valueOf(produto.getId());
        String quantidade = String.valueOf(produto.getQuantidade());
        String preco = String.valueOf(produto.getPreco());

        JLabel nomeLabel = new JLabel(produto.getNome());
        JLabel codigoLabel = new JLabel(produto.getCodigo());
        JLabel precoLabel = new JLabel(preco);
        JLabel quantidadeLabel = new JLabel(quantidade);

        panel.add(codigoLabel);
        panel.add(nomeLabel);
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
