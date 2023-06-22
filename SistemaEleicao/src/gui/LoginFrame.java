package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import db.DB;
import entities.Pessoa;

public class LoginFrame extends JPanel {

	private JTextField txtEmail;
	private JPasswordField senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setBackground(new Color(51, 51, 102));
		setBounds(100, 100, 728, 476);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 159, 476);
		add(panel);

		txtEmail = new JTextField();
		txtEmail.setBounds(259, 132, 287, 47);
		add(txtEmail);
		txtEmail.setColumns(10);

		JLabel txtema = new JLabel("Email:");
		txtema.setForeground(Color.WHITE);
		txtema.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtema.setBounds(259, 107, 46, 14);
		add(txtema);

		JLabel lblEmail = new JLabel("Senha:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(259, 211, 72, 14);
		add(lblEmail);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(
				new ImageIcon(LoginFrame.class.getResource("/view/images/1f23b6adc4aed523f3d33db244b0c3b1 (3).png")));
		lblNewLabel_1.setBounds(436, 68, 214, 312);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Login");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_2.setBounds(381, 28, 99, 54);
		add(lblNewLabel_2);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Connection conn = null;
				PreparedStatement st = null;
				ResultSet rs = null;

				String txtNome;

				try {
					conn = DB.getConnection();

					st = conn.prepareStatement("SELECT * FROM pessoa WHERE email = ? and senha = ?");

					st.setString(1, txtEmail.getText());
					st.setString(2, String.valueOf(senha.getPassword()));

					rs = st.executeQuery();

					if (rs.next()) {

						Pessoa usuarioLogado = new Pessoa();
						usuarioLogado.setId(rs.getInt("id"));
						usuarioLogado.setNome(rs.getString("nome"));
						txtNome = (rs.getString("nome"));
						String perfil = rs.getString(7);

						if (perfil.equals("admin")) {

							TelaPrincipal tela = new TelaPrincipal(usuarioLogado);
							tela.setVisible(true);
							tela.setLocationRelativeTo(null);
							Window window = SwingUtilities.getWindowAncestor(LoginFrame.this);
							window.dispose();
							JOptionPane.showMessageDialog(null, "Seja bem-vindo(a) " + txtNome);
						} else {
							TelaPrincipal tela = new TelaPrincipal(usuarioLogado);
							tela.setVisible(true);
							tela.setLocationRelativeTo(null);
							tela.btnAcessoRestrito.setVisible(false);
							tela.btnRelatorio.setVisible(false);
							tela.btnAtualizarList.setVisible(false);
							Window window = SwingUtilities.getWindowAncestor(LoginFrame.this);
							window.dispose();
							JOptionPane.showMessageDialog(null, "Seja bem-vindo(a)  " + txtNome);
						}
					} else {

						ImageIcon icon = new ImageIcon(getClass().getResource("/view/images/aviso.png"));
						JOptionPane.showMessageDialog(null, "Usuário Inválido !!", "Aviso", JOptionPane.PLAIN_MESSAGE,
								icon);

					}
				} catch (SQLException xp) {
					xp.printStackTrace();
				} finally {
					DB.closeStatement(st);
					DB.closeResultSet(rs);
				}

			}

		});
		btnEntrar.setBounds(259, 294, 119, 38);
		add(btnEntrar);

		senha = new JPasswordField();
		senha.setBounds(259, 236, 287, 47);
		add(senha);

	}

}
