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

public class PedidoAtualizarDialog extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField textFieldLabel1, textFieldLabel2, textFieldLabel3, textFieldLabel4;

    public PedidoAtualizarDialog() {
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        
        // Adicionando rótulo e campo de entrada para o segundo label
        JLabel label4 = new JLabel("Id:");
        contentPanel.add(label4);
        textFieldLabel4 = new JTextField();
        textFieldLabel4.setColumns(30);
        textFieldLabel4.setPreferredSize(new java.awt.Dimension(30, 20));
        contentPanel.add(textFieldLabel4);

        // Adicionando rótulo e campo de entrada para o primeiro label
        JLabel label1 = new JLabel("Documento:");
        contentPanel.add(label1);
        textFieldLabel1 = new JTextField();
        textFieldLabel1.setColumns(30);
        textFieldLabel1.setPreferredSize(new java.awt.Dimension(30, 20));
        contentPanel.add(textFieldLabel1);

        // Adicionando rótulo e campo de entrada para o segundo label
        JLabel label2 = new JLabel("Codigo:");
        contentPanel.add(label2);
        textFieldLabel2 = new JTextField();
        textFieldLabel2.setColumns(30);
        textFieldLabel2.setPreferredSize(new java.awt.Dimension(30, 20));
        contentPanel.add(textFieldLabel2);
        
        // Adicionando rótulo e campo de entrada para o segundo label
        JLabel label3 = new JLabel("Quantidade:");
        contentPanel.add(label3);
        textFieldLabel3 = new JTextField();
        textFieldLabel3.setColumns(30);
        textFieldLabel3.setPreferredSize(new java.awt.Dimension(30, 20));
        contentPanel.add(textFieldLabel3);

        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton atualizarButton = new JButton("Atualizar");
                atualizarButton.setActionCommand("Atualizar");
                
                atualizarButton.addActionListener(e -> onCadastrar());
                buttonPane.add(atualizarButton);
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
    
    private void onCadastrar() {
    	String mensagem = "";
        String documento = textFieldLabel1.getText();
        String codigo = textFieldLabel2.getText();
        
        int quantidade;
        try {
            quantidade = Integer.parseInt(textFieldLabel3.getText());
        } catch (NumberFormatException e) {
            mensagem = "Entrada inválida para quantidade. Insira um valor inteiro";
            JOptionPane.showMessageDialog(null, mensagem);
            return;
        }
        
        int id;
        try {
            id = Integer.parseInt(textFieldLabel4.getText());
        } catch (NumberFormatException e) {
            mensagem = "Entrada inválida para id. Insira um valor inteiro";
            JOptionPane.showMessageDialog(null, mensagem);
            return;
        }
        
        String apenasDigitos = documento.replaceAll("\\D", "");

        if (apenasDigitos.length() == 11 || apenasDigitos.length() == 14) {
        	PedidoController pedidoController = new PedidoController();
        	pedidoController.atualizarPedido(id, apenasDigitos, codigo, quantidade);
        } else {
        	mensagem = "Documento inserido incorretamente";
			JOptionPane.showMessageDialog(null, mensagem);
        }
    }
}
