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

public class ClienteDeletarDialog extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField textFieldLabel2;
    private ClienteListPanel clienteListPanel;

    public ClienteDeletarDialog(ClienteListPanel clienteListPanel) {
    	this.clienteListPanel = clienteListPanel;
    	
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);

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
        String documento = textFieldLabel2.getText();
        
        String apenasDigitos = documento.replaceAll("\\D", "");

        if (apenasDigitos.length() == 11) {
        	PessoaFisicaController pessoaFisica = new PessoaFisicaController();
        	pessoaFisica.deletarPessoaFisica(apenasDigitos);
        	clienteListPanel.gerarPanelsClientes();
        	
        } else if (apenasDigitos.length() == 14) {
        	PessoaJuridicaController pessoaJuridica = new PessoaJuridicaController();
        	pessoaJuridica.deletarPessoaJuridica(apenasDigitos);
        	clienteListPanel.gerarPanelsClientes();
        	
        } else {
        	String mensagem = "Documento inserido incorretamente";
			JOptionPane.showMessageDialog(null, mensagem);
        }
    }
}
