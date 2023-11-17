package views;

import javax.swing.*;
import controller.BancoController;
import models.PessoaFisica;
import models.PessoaJuridica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ClienteListPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private JList<JPanel> clienteList;
    private DefaultListModel<JPanel> listModel;

    public ClienteListPanel() {
        listModel = new DefaultListModel<>();
        carregarDadosClientes();
    }

    private void carregarDadosClientes() {
        gerarBotoes();
        gerarPanelsClientes();
    }

    private void gerarBotoes() {
        JButton botaoCadastrar = new JButton("CADASTRAR");
        JButton botaoAtualizar = new JButton("ATUALIZAR");
        JButton botaoDeletar = new JButton("DELETAR");

        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ClienteCadastrarDialog(ClienteListPanel.this);
            }
        });

        botaoAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ClienteAtualizarDialog(ClienteListPanel.this);
            }
        });

        botaoDeletar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ClienteDeletarDialog(ClienteListPanel.this);
            }
        });

        JPanel botoesPanel = new JPanel();
        botoesPanel.add(botaoCadastrar);
        botoesPanel.add(botaoAtualizar);
        botoesPanel.add(botaoDeletar);

        setLayout(new BorderLayout());
        add(botoesPanel, BorderLayout.NORTH);
    }

    public void gerarPanelsClientes() {
        listModel.removeAllElements();

        BancoController controller = new BancoController();
        List<PessoaFisica> pessoaFisicaList = controller.readPessoaFisica();
        List<PessoaJuridica> pessoaJuridicaList = controller.readPessoaJuridica();

        JPanel panelHeader = criarHeaderPainelCliente();
        listModel.addElement(panelHeader);

        for (PessoaFisica pessoa : pessoaFisicaList) {
            JPanel panel = criarPainelCliente(pessoa.getCpf(), pessoa.getNomeCliente(), "Fisica");
            listModel.addElement(panel);
        }

        for (PessoaJuridica pessoa : pessoaJuridicaList) {
            JPanel panel = criarPainelCliente(pessoa.getCnpj(), pessoa.getNomeCliente(), "Juridica");
            listModel.addElement(panel);
        }

        clienteList = new JList<>(listModel);
        clienteList.setCellRenderer(new PanelListCellRenderer());
        JScrollPane scrollPane = new JScrollPane(clienteList);

        add(scrollPane, BorderLayout.CENTER);
    }

    private JPanel criarPainelCliente(String info, String nome, String categoria) {
        JPanel panel = new JPanel(new GridLayout(1, 3));
        JLabel infoLabel = new JLabel(info);
        JLabel nomeLabel = new JLabel(nome);
        JLabel categoriaLabel = new JLabel(categoria);

        panel.add(infoLabel);
        panel.add(nomeLabel);
        panel.add(categoriaLabel);

        return panel;
    }

    private JPanel criarHeaderPainelCliente() {
        JPanel panel = new JPanel(new GridLayout(1, 3));
        JLabel infoLabel = new JLabel("Documento");
        JLabel nomeLabel = new JLabel("Nome");
        JLabel categoriaLabel = new JLabel("Categoria");

        panel.add(infoLabel);
        panel.add(nomeLabel);
        panel.add(categoriaLabel);

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
