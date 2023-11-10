package views;

import javax.swing.*;

import controller.*;
import models.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ClienteListPanel extends JPanel {
    public ClienteListPanel() {
        carregarDadosClientes();
    }

    private void carregarDadosClientes() {
        BancoController controller = new BancoController();
        List<PessoaFisica> pessoaFisicaList = controller.readPessoaFisica();
        List<PessoaJuridica> pessoaJuridicaList = controller.readPessoaJuridica();
        
        DefaultListModel<JPanel> listModel = new DefaultListModel<>();
        for (PessoaFisica pessoa : pessoaFisicaList) {
            JPanel panel = new JPanel(new GridLayout(1, 4)); // 3 colunas: ID, Nome, Botão
            String pessoaInfo = String.valueOf(pessoa.getCpf());
            JLabel cpfLabel = new JLabel(pessoaInfo);
            JLabel nomeLabel = new JLabel(pessoa.getNomeCliente());
            JLabel categoriaLabel = new JLabel("Fisica");
            JButton button = new JButton("Atualizar");

            // Adicione um ActionListener ao botão, se necessário
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Lógica quando o botão é clicado
                    // Pode ser abrir uma nova janela, editar a pessoa, etc.
                }
            });

            panel.add(cpfLabel);
            panel.add(nomeLabel);
            panel.add(categoriaLabel);
            panel.add(button);

            listModel.addElement(panel);
        }
        
        for (PessoaJuridica pessoa : pessoaJuridicaList) {
            JPanel panel = new JPanel(new GridLayout(1, 4)); // 3 colunas: ID, Nome, Botão
            String pessoaInfo = String.valueOf(pessoa.getCnpj());
            JLabel cnpjLabel = new JLabel(pessoaInfo);
            JLabel nomeLabel = new JLabel(pessoa.getNomeCliente());
            String categoria = "Juridica";
            JLabel categoriaLabel = new JLabel(categoria);
            JButton button = new JButton("Atualizar");

            // Adicione um ActionListener ao botão, se necessário
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Lógica quando o botão é clicado
                    // Pode ser abrir uma nova janela, editar a pessoa, etc.
                }
            });

            panel.add(cnpjLabel);
            panel.add(nomeLabel);
            panel.add(categoriaLabel);
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

