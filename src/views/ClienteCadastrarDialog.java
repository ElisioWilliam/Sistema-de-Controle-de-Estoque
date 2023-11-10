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

import controller.PessoaFisicaController;
import controller.PessoaJuridicaController;
import models.PessoaFisica;
import models.PessoaJuridica;

public class ClienteCadastrarDialog extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField textFieldLabel1;
    private JTextField textFieldLabel2;

    public ClienteCadastrarDialog() {
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        // Adicionando rótulo e campo de entrada para o primeiro label
        JLabel label1 = new JLabel("Nome:");
        contentPanel.add(label1);
        textFieldLabel1 = new JTextField();
        textFieldLabel1.setColumns(30);
        textFieldLabel1.setPreferredSize(new java.awt.Dimension(30, 20));
        contentPanel.add(textFieldLabel1);

        // Adicionando rótulo e campo de entrada para o segundo label
        JLabel label2 = new JLabel("Documento:");
        contentPanel.add(label2);
        textFieldLabel2 = new JTextField();
        textFieldLabel2.setColumns(30);
        textFieldLabel2.setPreferredSize(new java.awt.Dimension(30, 20));
        contentPanel.add(textFieldLabel2);

        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton cadastrarButton = new JButton("Cadastrar");
                cadastrarButton.setActionCommand("Cadastrar");
                
                cadastrarButton.addActionListener(e -> onCadastrar());
                buttonPane.add(cadastrarButton);
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
    	String nome = textFieldLabel1.getText();
        String documento = textFieldLabel2.getText();
        
        String apenasDigitos = documento.replaceAll("\\D", "");

        if (apenasDigitos.length() == 11) {
        	PessoaFisica pessoa = new PessoaFisica(nome, documento);
        	PessoaFisicaController pessoaFisica = new PessoaFisicaController();
        	pessoaFisica.cadastrarPessoaFisica(pessoa);
        	
        } else if (apenasDigitos.length() == 14) {
        	PessoaJuridica pessoa = new PessoaJuridica(nome, documento);
        	PessoaJuridicaController pessoaJuridica = new PessoaJuridicaController();
        	pessoaJuridica.cadastrarPessoaJuridica(pessoa);
        	
        } else {
        	String mensagem = "Documento inserido incorretamente";
			JOptionPane.showMessageDialog(null, mensagem);
        }
    }
}
