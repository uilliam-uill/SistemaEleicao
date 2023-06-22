package gui;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private CardLayout cardLayout;
	JFrame mainFrame = new JFrame();
	LoginFrame loginFrame = new LoginFrame();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 746, 510);
		setLocationRelativeTo(null);

		// Cria o painel principal com o CardLayout
		contentPane = new JPanel();
		cardLayout = new CardLayout();
		contentPane.setLayout(cardLayout);
		setContentPane(contentPane);

		// Cria as telas de login e cadastro
		loginFrame = new LoginFrame();

		// Adiciona os painéis principais das telas de login e cadastro ao painel
		// principal
		contentPane.add(loginFrame, "login");

		mainFrame.pack();

	}

}
