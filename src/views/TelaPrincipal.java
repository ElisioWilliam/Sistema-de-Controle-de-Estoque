package views;

import javax.swing.*;
import java.awt.*;

public class TelaPrincipal extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTabbedPane tabbedPane;
    private JPanel produtosPanel;
    private JPanel clientesPanel;
    private JPanel pedidosPanel;
    
    public TelaPrincipal() {
        setTitle("Sistema de Gerenciamento");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        tabbedPane = new JTabbedPane();
        clientesPanel = new ClienteListPanel(); 
        produtosPanel = new ProdutoListPanel();
        pedidosPanel = new PedidoListPanel();

        tabbedPane.addTab("Clientes", clientesPanel);
        tabbedPane.addTab("Produtos", produtosPanel);
        tabbedPane.addTab("Pedidos", pedidosPanel);

        add(tabbedPane);

    }
    
    public void reiniciar() {
        // Implemente aqui a lógica para reiniciar os componentes da tela

        // Por exemplo, você pode fechar a tela atual
        dispose();

        // E então criar uma nova instância da TelaPrincipal
        TelaPrincipal novaTela = new TelaPrincipal();
        novaTela.setVisible(true);
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {                	
                	TelaPrincipal frame = new TelaPrincipal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
