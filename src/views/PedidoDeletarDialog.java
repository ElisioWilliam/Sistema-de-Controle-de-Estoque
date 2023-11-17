package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import controller.PedidoController;

public class PedidoDeletarDialog extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField textFieldLabel1;
    private PedidoListPanel pedidoListPanel;
    
    public PedidoDeletarDialog(PedidoListPanel pedidoListPanel) {
    	this.pedidoListPanel = pedidoListPanel;
    	
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        // Adicionando rótulo e campo de entrada para o primeiro label
        JLabel label1 = new JLabel("Id:");
        contentPanel.add(label1);
        textFieldLabel1 = new JTextField();
        textFieldLabel1.setColumns(30);
        textFieldLabel1.setPreferredSize(new java.awt.Dimension(30, 20));
        contentPanel.add(textFieldLabel1);

        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton deletarButton = new JButton("Deletar");
                deletarButton.setActionCommand("Deletar");
                
                deletarButton.addActionListener(e -> onDeletar());
                buttonPane.add(deletarButton);
            }
            {
                JButton cancelButton = new JButton("Cancelar");
                cancelButton.setActionCommand("Cancelar");
                cancelButton.addActionListener(e -> onCancel());
                buttonPane.add(cancelButton);
            }
        }

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void onCancel() {
        dispose();
    }
    
    private void onDeletar() {
        String mensagem = "";

        int id;
        try {
            id = Integer.parseInt(textFieldLabel1.getText());
        } catch (NumberFormatException e) {
            mensagem = "Entrada inválida para id. Insira um valor inteiro";
            JOptionPane.showMessageDialog(null, mensagem);
            return;
        }

        PedidoController pedidoController = new PedidoController();
        pedidoController.cancelarPedido(id);
        pedidoListPanel.gerarPanelsPedidos();
        TelaPrincipal.produtosPanel.gerarPanelsProdutos();
    }
}