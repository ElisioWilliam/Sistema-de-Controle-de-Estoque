package views;

import javax.swing.*;
import controller.BancoController;
import models.Produto;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ProdutoListPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private JList<JPanel> produtoList;
    private DefaultListModel<JPanel> listModel;

    public ProdutoListPanel() {
        listModel = new DefaultListModel<>();
        carregarDadosProdutos();
    }

    private void carregarDadosProdutos() {
        gerarBotoes();
        gerarPanelsProdutos();
    }

    private void gerarBotoes() {
        JButton botaoCadastrar = new JButton("CADASTRAR");
        JButton botaoAtualizar = new JButton("ATUALIZAR");
        JButton botaoDeletar = new JButton("DELETAR");

        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProdutoCadastrarDialog(ProdutoListPanel.this);
            }
        });

        botaoAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProdutoAtualizarDialog(ProdutoListPanel.this);
            }
        });

        botaoDeletar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProdutoDeletarDialog(ProdutoListPanel.this);
            }
        });

        JPanel botoesPanel = new JPanel();
        botoesPanel.add(botaoCadastrar);
        botoesPanel.add(botaoAtualizar);
        botoesPanel.add(botaoDeletar);

        setLayout(new BorderLayout());
        add(botoesPanel, BorderLayout.NORTH);
    }

    public void gerarPanelsProdutos() {
        listModel.removeAllElements(); 

        BancoController controller = new BancoController();
        List<Produto> produtosList = controller.readProduto();

        JPanel panelHeader = criarHeaderPainelProduto();
        listModel.addElement(panelHeader);

        for (Produto produto : produtosList) {
            JPanel panel = criarPainelProduto(produto);
            listModel.addElement(panel);
        }

        produtoList = new JList<>(listModel);
        produtoList.setCellRenderer(new PanelListCellRenderer());
        JScrollPane scrollPane = new JScrollPane(produtoList);

        add(scrollPane, BorderLayout.CENTER);
    }

    private JPanel criarPainelProduto(Produto produto) {
        JPanel panel = new JPanel(new GridLayout(1, 4));

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

    private JPanel criarHeaderPainelProduto() {
        JPanel panel = new JPanel(new GridLayout(1, 4));

        JLabel nomeLabel = new JLabel("Nome");
        JLabel codigoLabel = new JLabel("Codigo");
        JLabel precoLabel = new JLabel("Preco");
        JLabel quantidadeLabel = new JLabel("Quantidade");

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
