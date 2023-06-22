package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import db.DB;
import entities.Eleicao;
import entities.Pessoa;
import model.dao.DaoFactory;
import model.dao.EleicaoDao;

public class TelaPrincipal extends JFrame implements WindowListener {

	private Pessoa usuarioLogado;

	private JPanel contentPane;
	private JTextField txtVoto;
	private JList<String> listCandidatos;
	private JList<String> listEleicoes;
	private JTable tableresult;
	private JLabel fotoCandidato = new JLabel("");
	private JLabel jNomeCandidato = new JLabel("");
	private JLabel jpartidoCandidato = new JLabel("");
	private JLabel jNumeroPartido = new JLabel("");
	private JLabel jNumeroCandidato = new JLabel("");
	private JLabel jDescricaoChapa = new JLabel("");
	public JButton btnAcessoRestrito = new JButton("Acesso Restrito");
	public JButton btnRelatorio = new JButton("Relatorio");
	public JButton btnAtualizarList = new JButton("Elei\u00E7\u00F5es");

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pessoa usuarioLogado = new Pessoa();
					TelaPrincipal frame = new TelaPrincipal(usuarioLogado);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal(Pessoa usuarioLogado) {
		this.usuarioLogado = usuarioLogado;

		addWindowListener(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 976, 648);
		setResizable(false);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(btnAcessoRestrito);
		btnAcessoRestrito.setBorder(UIManager.getBorder("MenuItem.border"));
		btnAcessoRestrito.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/view/images/admin.png")));
		btnAcessoRestrito.setToolTipText("Acesso Admin");
		btnAcessoRestrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Cadastrro cad = new Cadastrro();
					cad.setVisible(true);
					cad.setLocationRelativeTo(null);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		btnAcessoRestrito.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Connection conn = null;
				PreparedStatement st = null;
				ResultSet rs = null;

				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Salvar relatório");

				int userSelection = fileChooser.showSaveDialog(btnRelatorio);

				if (userSelection == JFileChooser.APPROVE_OPTION) {
					File fileToSave = fileChooser.getSelectedFile();
					try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave))) {
						conn = DB.getConnection();
						st = conn.prepareStatement("SELECT * FROM view_relatorio_eleicao");
						rs = st.executeQuery();

						while (rs.next()) {
							writer.write(rs.getInt("id_candidato") + " | Nome: " + rs.getString("nome_candidato")
									+ " | Num candidato: " + rs.getInt("numeroCandidato") + " | Partido: "
									+ rs.getString("partido") + " | Tipo de elieção: " + rs.getString("tipo_eleicao")
									+ " | Qtd Votos: " + rs.getInt("qtdVotos") + " | " + rs.getString("dataInicio")
									+ " | " + rs.getString("dataFinal") + "\n");
						}
						JOptionPane.showMessageDialog(null, "Relatório salvo com sucesso!");
					} catch (IOException | SQLException ex) {
						ex.printStackTrace();
					}
				}
			}
		});

		btnRelatorio.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/view/images/relatorio.png")));
		btnRelatorio.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRelatorio.setBorder(UIManager.getBorder("MenuItem.border"));
		menuBar.add(btnRelatorio);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		String[] Canditatos = {};

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBounds(197, 11, 733, 219);
		contentPane.add(panel);
		panel.setLayout(null);

		JComboBox comboBoxResultados = new JComboBox();
		comboBoxResultados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String comboSelecionado = comboBoxResultados.getSelectedItem().toString();

				if (comboSelecionado.equals("Eleições Anteriores")) {
					DefaultTableModel model = buscarResultadosEleicoesAnteriores();
					tableresult.setModel(model);
				}

			}
		});
		comboBoxResultados.setModel(
				new DefaultComboBoxModel(new String[] { "Elei\u00E7\u00E3o Atual", "Elei\u00E7\u00F5es Anteriores" }));
		comboBoxResultados.setBounds(614, 293, 186, 43);
		contentPane.add(comboBoxResultados);

		JLabel lblNewLabel_3 = new JLabel("Informa\u00E7\u00F5es do candidato");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(327, 11, 191, 23);
		panel.add(lblNewLabel_3);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBackground(SystemColor.control);
		scrollPane_1.setBounds(0, 0, 148, 219);
		panel.add(scrollPane_1);
		listCandidatos = new JList(Canditatos);
		listCandidatos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane_1.setViewportView(listCandidatos);
		listCandidatos.setForeground(Color.BLACK);
		listCandidatos.setModel(new AbstractListModel() {
			String[] values = new String[] {};

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listCandidatos.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
		listCandidatos.setBackground(SystemColor.controlHighlight);
		listCandidatos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JLabel lblNewLabel_4 = new JLabel("Nomes dos candidatos:");
		lblNewLabel_4.setForeground(new Color(51, 51, 204));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		scrollPane_1.setColumnHeaderView(lblNewLabel_4);

		fotoCandidato.setBounds(337, 54, 120, 130);
		panel.add(fotoCandidato);

		jNomeCandidato.setBounds(467, 64, 253, 14);
		panel.add(jNomeCandidato);

		jpartidoCandidato.setBounds(467, 83, 250, 14);
		panel.add(jpartidoCandidato);

		jNumeroPartido.setBounds(472, 98, 46, 14);
		panel.add(jNumeroPartido);

		jNumeroCandidato.setBounds(467, 108, 46, 14);
		panel.add(jNumeroCandidato);

		jDescricaoChapa.setBounds(467, 121, 256, 63);
		panel.add(jDescricaoChapa);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.control);
		panel_1.setBounds(0, 0, 163, 619);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Elei\u00E7\u00F5es abertas");
		lblNewLabel_2.setForeground(new Color(0, 102, 51));
		lblNewLabel_2.setBounds(8, 11, 153, 25);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(lblNewLabel_2);

		listEleicoes = new JList();
		listEleicoes.setBounds(0, 37, 161, 424);
		panel_1.add(listEleicoes);
		listEleicoes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listEleicoes.setModel(new AbstractListModel() {
			String[] values = new String[] {};

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listEleicoes.setBackground(SystemColor.control);
		listEleicoes.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));

		btnAtualizarList.setToolTipText("Atualizar lista de eleições");
		btnAtualizarList.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/view/images/update.png")));
		btnAtualizarList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarListaEleicoes();
			}
		});
		btnAtualizarList.setBounds(10, 501, 143, 36);
		panel_1.add(btnAtualizarList);

		JLabel jLabelImg = new JLabel();
		jLabelImg.setBounds(233, 254, 103, 90);
		contentPane.add(jLabelImg);

		txtVoto = new JTextField();
		txtVoto.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {

				Connection conn = null;
				PreparedStatement st = null;
				ResultSet rs = null;

				try {

					if (!txtVoto.getText().isEmpty()) { // Verifica se o texto não está vazio

						conn = DB.getConnection();

						st = conn.prepareStatement("SELECT foto FROM candidato WHERE numeroCandidato = ?");

						st.setInt(1, Integer.parseInt(txtVoto.getText()));

						rs = st.executeQuery();

						if (rs.next()) {
							String caminhoImagem = rs.getString("foto");
							ImageIcon iconeCandidato = new ImageIcon(caminhoImagem);
							jLabelImg.setIcon(iconeCandidato);

						} else {
							jLabelImg.setIcon(null);

						}
					} else {
						jLabelImg.setIcon(null);
					}

				} catch (SQLException ex) {
					ex.printStackTrace();
				} finally {

					DB.closeStatement(st);
					DB.closeResultSet(rs);
				}
			}
		});

		txtVoto.setBounds(346, 293, 114, 43);
		contentPane.add(txtVoto);
		txtVoto.setColumns(10);

		JButton btnVotar = new JButton("Votar");
		btnVotar.setToolTipText("Votar");
		btnVotar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnVotar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				PreparedStatement st = null;
				ResultSet rs = null;

				EleicaoDao dao = DaoFactory.createEleicaoDao();
				String nomeEleicaoSelecionada = listEleicoes.getSelectedValue();
				Eleicao eleicaoSelecionada = dao.findByName(nomeEleicaoSelecionada);

				if (txtVoto.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo Vota");
				} else {
					Integer.parseInt(txtVoto.getText());

					try {
						conn = DB.getConnection();

						int numeroCandidato = Integer.parseInt(txtVoto.getText());

						st = conn.prepareStatement("SELECT candidato.id, eleicao.id AS eleicao_id FROM candidato "
								+ "INNER JOIN eleicao_candidato ON candidato.id = eleicao_candidato.candidato_id "
								+ "INNER JOIN eleicao ON eleicao_candidato.eleicao_id = eleicao.id "
								+ "WHERE candidato.numeroCandidato = ? AND eleicao.id = ?");

						st.setInt(1, numeroCandidato);
						st.setInt(2, eleicaoSelecionada.getId());

						rs = st.executeQuery();

						if (!rs.next()) {
							JOptionPane.showMessageDialog(null, "Candidato não encontrado");
							return;
						} else {
							// Candidato encontrado, verifica se o usuário já votou em alguma eleição antes
							int pessoaId = usuarioLogado.getId();
							int eleicaoId = rs.getInt("eleicao_id");
							int candidatoId = rs.getInt("id");

							st = conn.prepareStatement(
									"SELECT COUNT(*) FROM voto WHERE pessoa_id = ? AND eleicao_id = ?");
							st.setInt(1, pessoaId);
							st.setInt(2, eleicaoId);
							rs = st.executeQuery();

							if (rs.next()) {
								int qtdVotos = rs.getInt(1);

								if (qtdVotos > 0) {
									JOptionPane.showMessageDialog(null, "Você já votou nesta eleição");
									return;
								}
							}

							// Verifica se o usuário já votou neste candidato antes
							st = conn.prepareStatement(
									"SELECT COUNT(*) FROM voto WHERE pessoa_id = ? AND candidato_id = ? AND eleicao_id = ?");
							st.setInt(1, pessoaId);
							st.setInt(2, candidatoId);
							st.setInt(3, eleicaoId);
							rs = st.executeQuery();

							if (rs.next()) {
								int qtdVotos = rs.getInt(1);

								if (qtdVotos > 0) {
									JOptionPane.showMessageDialog(null, "Você já votou neste candidato nesta eleição");
									return;
								}
							}

							// Registra o voto do usuário para o candidato selecionado
							st = conn.prepareStatement(
									"INSERT INTO voto (qtdVotos, pessoa_id, candidato_id, eleicao_id) VALUES (?, ?, ?, ?)");
							st.setInt(1, 1);
							st.setInt(2, pessoaId);
							st.setInt(3, candidatoId);
							st.setInt(4, eleicaoId);
							st.executeUpdate();
							JOptionPane.showMessageDialog(null, "Voto registrado com sucesso!");

							st = conn.prepareStatement(
									"UPDATE eleicao SET qtdTotalVotos = qtdTotalVotos + 1 WHERE id = ?");
							st.setInt(1, eleicaoId);
							st.executeUpdate();
							txtVoto.setText("");
						}

					} catch (SQLException ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null, "Erro ao registrar voto");
					}

				}
			}

		});
		btnVotar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVotar.setBorderPainted(false);
		btnVotar.setForeground(new Color(0, 51, 0));
		btnVotar.setBackground(new Color(102, 255, 0));
		btnVotar.setBounds(470, 293, 89, 43);
		contentPane.add(btnVotar);

		JLabel lblNewLabel = new JLabel("Digite o numero do seu candidto");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(346, 269, 197, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Consultar eleicoes passadas");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(614, 269, 197, 14);
		contentPane.add(lblNewLabel_1);

		JScrollPane scrollPaneResultado = new JScrollPane();
		scrollPaneResultado.setBounds(197, 376, 733, 200);
		contentPane.add(scrollPaneResultado);

		tableresult = new JTable();
		tableresult.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Id", "Nome",
				"Numero do candidado", "Partido", "Tipo de eleição", "Qtd de votos", "Qtd total de votos" }));
		scrollPaneResultado.setColumnHeaderView(tableresult);
		scrollPaneResultado.setViewportView(tableresult);
		tableresult.setDefaultEditor(Object.class, null);
		tableresult.getTableHeader().setReorderingAllowed(false);
		tableresult.setSurrendersFocusOnKeystroke(true);

		JButton btnNewButton_1 = new JButton("Consultar");
		btnNewButton_1.setToolTipText("Consultar");
		btnNewButton_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/view/images/buscar.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Connection conn = null;
				PreparedStatement st = null;
				ResultSet rs = null;

				String eleicaoSelecionada = listEleicoes.getSelectedValue();

				String comboSelecionado = comboBoxResultados.getSelectedItem().toString();
				if (eleicaoSelecionada == null || eleicaoSelecionada.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, selecione uma eleição.");
				} else {

					if (comboSelecionado.equals("Eleição Atual")) {
						try {
							conn = DB.getConnection();

							st = conn.prepareStatement(
									"SELECT c.id AS id_candidato, p.nome AS nome_candidato, c.numeroCandidato, c.partido, e.tipo AS tipo_eleicao, "
											+ "COUNT(v.id) AS qtdVotos, e.qtdTotalVotos, e.dataFinal "
											+ "FROM eleicao e "
											+ "INNER JOIN eleicao_candidato ec ON e.id = ec.eleicao_id "
											+ "INNER JOIN candidato c ON ec.candidato_id = c.id "
											+ "INNER JOIN pessoa p ON c.pessoa_id = p.id "
											+ "LEFT JOIN voto v ON c.id = v.candidato_id AND e.id = v.eleicao_id "
											+ "WHERE e.tipo = ? "
											+ "GROUP BY c.id, p.nome, c.numeroCandidato, c.partido, e.tipo, e.qtdTotalVotos, e.dataFinal "
											+ "ORDER BY qtdVotos DESC ");

							st.setString(1, eleicaoSelecionada);

							rs = st.executeQuery();

							DefaultTableModel tabela = (DefaultTableModel) tableresult.getModel();
							tabela.setRowCount(0);

							int rowCount = 0;

							while (rs.next()) {
								int id = rs.getInt("id_candidato");
								String nome = rs.getString("nome_candidato");
								int numeroCandidato = rs.getInt("numeroCandidato");
								String partido = rs.getString("partido");
								String tipoEleicao = rs.getString("tipo_eleicao");
								int qtdVotos = rs.getInt("qtdVotos");
								int qtdTotalVotosCandidato = rs.getInt("qtdTotalVotos");
								Date dataAtual = new Date();
								if (dataAtual.before(rs.getDate("dataFinal"))) {
									JOptionPane.showMessageDialog(null, "Eleição ainda não foi encerrada.");
								} else {
									if (rowCount == 0) {
										tabela.addRow(new Object[] { id, nome, numeroCandidato, partido, tipoEleicao,
												qtdVotos, qtdTotalVotosCandidato });
									} else {
										tabela.addRow(new Object[] { id, nome, numeroCandidato, partido, tipoEleicao,
												qtdVotos });
									}

									rowCount++;

								}

							}

						} catch (SQLException ex) {
							ex.printStackTrace();
						}

					}

				}
			}

		});

		btnNewButton_1.setBorder(UIManager.getBorder("EditorPane.border"));
		btnNewButton_1.setBounds(810, 293, 120, 43);
		contentPane.add(btnNewButton_1);

	}

	// Metodo para atualizar a jlist de eleições na tela de admin
	private void atualizarListaEleicoes() {
		EleicaoDao dao = DaoFactory.createEleicaoDao();
		List<Eleicao> eleicoes = dao.findByType();
		DefaultListModel<String> model = new DefaultListModel<String>();
		for (Eleicao eleicao : eleicoes) {
			model.addElement(eleicao.getTipo());
		}
		listEleicoes.setModel(model);
		listEleicoes.revalidate();
	}

	// Metodo para preenche jtable com eleições passadas
	// esse metodo é chamado no evento do combobox
	private DefaultTableModel buscarResultadosEleicoesAnteriores() {
		DefaultTableModel model = new DefaultTableModel();

		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		model.addColumn("ID");
		model.addColumn("Nome");
		model.addColumn("Número do Candidato");
		model.addColumn("Partido");
		model.addColumn("Tipo de Eleição");
		model.addColumn("Data de Início");
		model.addColumn("Data de Término");
		model.addColumn("Qtd. de Votos");
		model.addColumn("Qtd. Total de Votos");

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		try {
			conn = DB.getConnection();
			st = conn.prepareStatement("SELECT * FROM view_buscar_eleicoes_anteriores");
			rs = st.executeQuery();

			int qtdTotalVotos = 0;

			while (rs.next()) {
				Object[] row = new Object[9];
				row[0] = rs.getInt("id_candidato");
				row[1] = rs.getString("nome_candidato");
				row[2] = rs.getInt("numeroCandidato");
				row[3] = rs.getString("partido");
				row[4] = rs.getString("tipo_eleicao");
				row[5] = dateFormat.format(rs.getDate("dataInicio"));
				row[6] = dateFormat.format(rs.getDate("dataFinal"));
				row[7] = rs.getInt("qtdVotos");
				qtdTotalVotos += rs.getInt("qtdVotos");
				row[8] = "";
				model.addRow(row);
			}

			Object[] totalRow = new Object[9];
			totalRow[7] = "Total:";
			totalRow[8] = qtdTotalVotos;
			model.addRow(totalRow);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return model;
	}

	@Override
	public void windowOpened(WindowEvent e) {

		EleicaoDao dao = DaoFactory.createEleicaoDao();
		List<Eleicao> eleicoes = dao.findByType();

		DefaultListModel<String> model = new DefaultListModel<String>();

		for (Eleicao eleicao : eleicoes) {
			model.addElement(eleicao.getTipo());
		}

		listEleicoes.setModel(model);

		listEleicoes.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					String eleicaoSelecionada = listEleicoes.getSelectedValue();
					preencherListaCandidatos(eleicaoSelecionada);

					jNomeCandidato.setText("");
					jpartidoCandidato.setText("");
					jNumeroCandidato.setText("");
					jDescricaoChapa.setText("");
					fotoCandidato.setIcon(null);

				}
			}

		});

		listCandidatos.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					String nomeCandidatoSelecionado = listCandidatos.getSelectedValue();
					preencherFotoCandidato(nomeCandidatoSelecionado);

				}
			}
		});

	}

	private void preencherListaCandidatos(String eleicao) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			conn = DB.getConnection();

			st = conn.prepareStatement(
					"SELECT pessoa.nome " + "FROM candidato " + "INNER JOIN pessoa ON candidato.pessoa_id = pessoa.id "
							+ "INNER JOIN eleicao ON candidato.eleicao_id = eleicao.id " + "WHERE eleicao.tipo = ? "
							+ "ORDER BY random()");
			st.setString(1, eleicao);

			rs = st.executeQuery();

			DefaultListModel<String> model = new DefaultListModel<String>();
			while (rs.next()) {
				model.addElement(rs.getString("nome"));
			}
			listCandidatos.setModel(model);

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	private void preencherFotoCandidato(String nomeCandidato) {

		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			conn = DB.getConnection();
			st = conn.prepareStatement("SELECT candidato.foto, candidato.partido, candidato.numeroPartido, "
					+ "candidato.numeroCandidato, pessoa.nome, eleicao.nome, chapa.nome, chapa.descricao "
					+ "FROM candidato " + "INNER JOIN pessoa ON candidato.pessoa_id = pessoa.id "
					+ "INNER JOIN eleicao_candidato ON candidato.id = eleicao_candidato.candidato_id "
					+ "INNER JOIN eleicao_chapa ON eleicao_candidato.eleicao_id = eleicao_chapa.eleicao_id "
					+ "INNER JOIN chapa ON eleicao_chapa.chapa_id = chapa.id "
					+ "INNER JOIN eleicao ON eleicao_candidato.eleicao_id = eleicao.id " + "WHERE pessoa.nome = ?");
			st.setString(1, nomeCandidato);

			rs = st.executeQuery();

			if (rs.next()) {
				String caminhoImagem = rs.getString("foto");
				String nomCandidato = rs.getString("nome");
				String pCandidato = rs.getString("partido");
				String nuCandidato = rs.getString("numeroCandidato");
				String descricaoChapa = rs.getString("descricao");

				ImageIcon imagemCandidato = new ImageIcon(caminhoImagem);
				fotoCandidato.setIcon(imagemCandidato);
				jNomeCandidato.setText(nomCandidato);
				jpartidoCandidato.setText(pCandidato);
				jNumeroCandidato.setText(nuCandidato);
				jDescricaoChapa.setText(descricaoChapa);
				jDescricaoChapa.setText("<html>" + descricaoChapa.replaceAll("\n", "<br>") + "</html>");

			} else {
				fotoCandidato.setIcon(null);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);

		}

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}
}
