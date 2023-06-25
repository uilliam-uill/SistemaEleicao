package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import db.DB;

public class Cadastrro extends JDialog {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtdCpf;
	private JTextField txtEmail;
	private JTextField txtTitulo;
	private JTextField txtCep;
	private JTextField txtCidade;
	private JPasswordField txtSenha;
	private JPasswordField txtConfirmeSenha;
	private JTextField txtEstado;
	private JTextField txtBairro;
	private JTextField txtLogradouro;
	private JTextField txtNumeroEnd;
	private JTextField txtPartido;
	private JTextField txtNumeroPartido;
	private JTextField txtNumCandidato;
	private JTextField txtNomeEleicao;
	private JTextField txtTipoEleicao;
	private JTextField txtDataInicio;
	private JTextField txtDataInicio_1;
	private JTextField txtDataFinal;
	private JTextField txtDataFinal_1;
	private JTextField txtFoto;
	private JTextField txtNomeChapa;
	private JTable tableAdmin;
	private JTextField textCrudFieldName;
	private JTextField textCrudFieldCpf;
	private JTextField textCrudFieldTitulo;
	private JTextField textCrudFieldEmail;
	private JTextField textCrudFieldSenha;
	private JTextField textNomeCandidatoCrud;
	private JTextField textCpfCandidatoCrud;
	private JTextField textTituloCandidatoCrud;
	private JTextField textEmailCandidatoCrud;
	private JTextField textSenhaCandidatoCrud;
	private JTextField textNomePartidoCandidatoCrud;
	private JTextField textNumeroPartidoCandidatoCrud;
	private JTextField textFotoCandidatoCrud;
	private JTextField textNumeroCCandidatoCrud;
	private JTextField textFieldCrudNomeEleicao;
	private JTextField textFieldFieldTipoEleicao;
	private JTextField textFieldCidadeCrud;
	private JTextField textFieldBairroCrud;
	private JTextField textFieldCepCrud;
	private JTextField textFieldNumeroCasaCrud;
	private JTextField textFieldLogradouroCrud;
	private JTextField textFieldEstadoCrud;
	private JTextField textFieldNomeChapaCrud;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastrro frame = new Cadastrro();
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
	 * 
	 * @throws ParseException
	 */
	public Cadastrro() throws ParseException {

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 943, 573);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 186, 534);
		Color rgb = new Color(51, 51, 102);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(192, 5, 725, 525);
		panel_3.setLayout(new CardLayout(0, 0));

		JPanel panelCadastro = new JPanel();
		panel_3.add(panelCadastro, "name_4758210161436100");
		panelCadastro.setBackground(rgb);

		JLabel lblNewLabel_6 = new JLabel("Cadastro");
		lblNewLabel_6.setBounds(251, 3, 153, 48);
		lblNewLabel_6.setFont(new Font("Segoe UI Black", Font.PLAIN, 35));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));

		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(60, 104, 66, 15);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));

		txtNome = new JTextField();
		txtNome.setBounds(60, 122, 181, 29);
		txtNome.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Cpf:");
		lblNewLabel_1.setBounds(61, 206, 42, 15);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		MaskFormatter cpfformato = new MaskFormatter("###.###.###-##");
		txtdCpf = new JFormattedTextField(cpfformato);
		txtdCpf.setBounds(59, 224, 120, 31);

		JLabel lblNewLabel_3 = new JLabel("Titulo:");
		lblNewLabel_3.setBounds(60, 258, 83, 15);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));

		txtTitulo = new JTextField();
		txtTitulo.setBounds(59, 276, 120, 29);
		txtTitulo.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Email:");
		lblNewLabel_2.setBounds(60, 153, 67, 15);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));

		txtEmail = new JTextField();
		txtEmail.setBounds(60, 170, 181, 31);
		txtEmail.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Senha:");
		lblNewLabel_4.setBounds(58, 306, 42, 15);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblNewLabel_5 = new JLabel("Confimar Senha:");
		lblNewLabel_5.setBounds(58, 357, 130, 15);
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblPartido = new JLabel("Nome Partido:");
		lblPartido.setBounds(493, 99, 92, 15);
		lblPartido.setForeground(new Color(255, 255, 255));
		lblPartido.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblNumeroPartido = new JLabel("Numero Partido:");
		lblNumeroPartido.setBounds(493, 153, 107, 15);
		lblNumeroPartido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNumeroPartido.setForeground(new Color(255, 255, 255));

		JLabel lblNumeroCandidato = new JLabel("Numero Candidato:");
		lblNumeroCandidato.setBounds(493, 206, 124, 15);
		lblNumeroCandidato.setForeground(new Color(255, 255, 255));
		lblNumeroCandidato.setFont(new Font("Tahoma", Font.PLAIN, 12));

		txtPartido = new JTextField();
		txtPartido.setBounds(493, 117, 107, 29);
		txtPartido.setColumns(10);

		txtNumeroPartido = new JTextField();
		txtNumeroPartido.setBounds(493, 171, 97, 29);
		txtNumeroPartido.setColumns(10);

		txtNumCandidato = new JTextField();
		txtNumCandidato.setBounds(493, 225, 97, 29);
		txtNumCandidato.setColumns(10);

		JLabel lblEleicao = new JLabel("Eli\u00E7\u00E3o:");
		lblEleicao.setBounds(494, 312, 52, 15);
		lblEleicao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEleicao.setForeground(new Color(255, 255, 255));
		panelCadastro.setLayout(null);

		JLabel lblFotoDoCandidato = new JLabel("Foto Do candidato");
		lblFotoDoCandidato.setBounds(496, 259, 124, 15);
		lblFotoDoCandidato.setForeground(Color.WHITE);
		lblFotoDoCandidato.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCadastro.add(lblFotoDoCandidato);

		txtCep = new JTextField();
		txtCep.setBounds(281, 121, 86, 29);
		txtCep.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Cep");
		lblNewLabel_7.setBounds(282, 103, 36, 15);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_7.setForeground(new Color(255, 255, 255));

		JLabel lblNewLabel_8 = new JLabel("Cidade:");
		lblNewLabel_8.setBounds(283, 154, 66, 15);
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 12));

		txtCidade = new JTextField();
		txtCidade.setBounds(283, 170, 138, 29);
		txtCidade.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Logradouro:");
		lblNewLabel_9.setBounds(283, 262, 83, 15);
		lblNewLabel_9.setForeground(new Color(255, 255, 255));
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblNewLabel_11 = new JLabel("Bairro:");
		lblNewLabel_11.setBounds(284, 210, 65, 15);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_11.setForeground(Color.WHITE);

		JLabel lblNewLabel_10 = new JLabel("Numero:");
		lblNewLabel_10.setBounds(284, 310, 64, 15);
		lblNewLabel_10.setForeground(new Color(255, 255, 255));
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 12));

		txtSenha = new JPasswordField();
		txtSenha.setBounds(58, 324, 122, 29);
		txtConfirmeSenha = new JPasswordField();
		txtConfirmeSenha.setBounds(58, 376, 124, 29);

		txtEstado = new JTextField();
		txtEstado.setBounds(380, 120, 51, 29);
		txtEstado.setColumns(10);

		txtBairro = new JTextField();
		txtBairro.setBounds(283, 226, 139, 29);
		txtBairro.setColumns(10);

		txtLogradouro = new JTextField();
		txtLogradouro.setBounds(283, 278, 139, 29);
		txtLogradouro.setColumns(10);

		txtNumeroEnd = new JTextField();
		txtNumeroEnd.setBounds(282, 328, 51, 29);
		txtNumeroEnd.setColumns(10);
		JComboBox comboBoxEleicao = new JComboBox();
		comboBoxEleicao.setBounds(494, 330, 127, 29);

		try {
			Connection conn = null;
			Statement st = null;
			ResultSet rs = null;

			conn = DB.getConnection();

			st = conn.createStatement();
			rs = st.executeQuery("select id, tipo from eleicao WHERE dataFinal >= DATE(NOW()) ");

			while (rs.next()) {
				String nomeEleicao = rs.getString("tipo");
				comboBoxEleicao.addItem(nomeEleicao);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(62, 68, 122, 29);
		comboBox.addItem("CANDIDATO");
		comboBox.addItem("ELEITOR");
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String itemSelecionado = comboBox.getSelectedItem().toString();
				if (itemSelecionado.equals("ELEITOR")) {

					lblNumeroCandidato.setVisible(false);
					txtNumCandidato.setVisible(false);
					lblNumeroPartido.setVisible(false);
					txtNumeroPartido.setVisible(false);
					lblPartido.setVisible(false);
					txtPartido.setVisible(false);
					lblEleicao.setVisible(false);
					comboBoxEleicao.setVisible(false);
					txtFoto.setVisible(false);
					lblFotoDoCandidato.setVisible(false);

				} else if (itemSelecionado.equals("CANDIDATO")) {

					lblNumeroCandidato.setVisible(true);
					txtNumCandidato.setVisible(true);
					lblNumeroPartido.setVisible(true);
					txtNumeroPartido.setVisible(true);
					lblPartido.setVisible(true);
					txtPartido.setVisible(true);
					lblEleicao.setVisible(true);
					comboBoxEleicao.setVisible(true);
					txtFoto.setVisible(true);
					lblFotoDoCandidato.setVisible(true);
				}
			}
		});

		JLabel lblNewLabel_12 = new JLabel("Estado:");
		lblNewLabel_12.setBounds(381, 103, 51, 15);
		lblNewLabel_12.setForeground(new Color(255, 255, 255));
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JButton btnNewButton = new JButton("SALVAR");
		btnNewButton.setBounds(271, 463, 146, 48);
		btnNewButton.setToolTipText("SALVAR");

		JComboBox txtPerfilAdmin = new JComboBox();
		txtPerfilAdmin.setBounds(58, 424, 121, 29);
		txtPerfilAdmin.setModel(new DefaultComboBoxModel(new String[] { "comun", "admin" }));
		panelCadastro.add(txtPerfilAdmin);

		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("null")
			public void actionPerformed(ActionEvent e) {

			String itemSelecionado = comboBox.getSelectedItem().toString();
			String getNome = txtNome.getText();
			String getCpf = txtdCpf.getText();
			String getEmail = txtEmail.getText();
			String getTitulo = txtTitulo.getText();
			String perfilE = "eleitor";
			String getCidade = txtCidade.getText();
			String getCep = txtCep.getText();
			String getBairro = txtBairro.getText();
			String getNumero = txtNumeroEnd.getText();
			String getLogradouro = txtLogradouro.getText();
			String getEstado = txtEstado.getText();
			String getPartido = txtPartido.getText();

			int getNumPartido = 0;
			if (!txtNumeroPartido.getText().isEmpty()) {
			getNumPartido = Integer.parseInt(txtNumeroPartido.getText());
			}
			int getNumCandidato = 0;
			if (!txtNumCandidato.getText().isEmpty()) {
			getNumCandidato = Integer.parseInt(txtNumCandidato.getText());
			}
			String txtFotos = txtFoto.getText();
			String Ssenha = new String(txtSenha.getPassword());
			String CSenha = new String(txtConfirmeSenha.getPassword());
			String perfilSelecionado = txtPerfilAdmin.getSelectedItem().toString();

			Connection conn = null;
			ResultSet rs = null;
			PreparedStatement st = null;

			if (itemSelecionado.equals("ELEITOR")) {

			if (txtNome.getText().isEmpty() || txtdCpf.getText().isEmpty() || txtEmail.getText().isEmpty()
			|| txtTitulo.getText().isEmpty() || txtSenha.getPassword().length == 0
			|| txtConfirmeSenha.getPassword().length == 0 || txtCidade.getText().isEmpty()
			|| txtBairro.getText().isEmpty() || txtCep.getText().isEmpty()
			|| txtEstado.getText().isEmpty() || txtLogradouro.getText().isEmpty()
			|| txtNumeroEnd.getText().isEmpty()) {

			JOptionPane.showMessageDialog(null, "Preencha todos os campos");

			} else if (Ssenha.equals(CSenha)) {

			try {

			conn = DB.getConnection();

			st = conn.prepareStatement(
			"INSERT INTO pessoa (nome, cpf, titulo, email, senha, perfil, candidatoElietor)"
			+ "VALUES (?,?,?,?,?,?,?) ",
			Statement.RETURN_GENERATED_KEYS);

			st.setString(1, getNome);
			st.setString(2, getCpf);
			st.setString(3, getTitulo);
			st.setString(4, getEmail);
			st.setString(5, CSenha);
			st.setString(6, perfilSelecionado);
			st.setString(7, perfilE);
			st.execute();

			MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

			MongoDatabase database = mongoClient.getDatabase("SistemaEleicao");

			MongoCollection<Document> collection = database.getCollection("Pessoa");

			Document documento = new Document();
			documento.append("nome", getNome);
			documento.append("cpf", getCpf);
			documento.append("titulo", getTitulo);
			documento.append("email", getEmail);
			documento.append("senha", CSenha);
			documento.append("perfil", perfilSelecionado);
			documento.append("candidatoElietor", perfilE);

			documento.append("endereco",
			new Document().append("cidade", getCidade).append("cep", getCep)
			.append("bairro", getBairro).append("numero", getNumero)
			.append("logradouro", getLogradouro).append("estado", getEstado));

			collection.insertOne(documento);

			mongoClient.close();

			rs = st.getGeneratedKeys();
			int pessoaId = -1;
			if (rs.next()) {
			pessoaId = rs.getInt(1);
			}

			st = conn.prepareStatement(
			"Insert into endereco (cidade, cep, bairro, numero, logradouro, pessoa_id, estado)"
			+ "values (?,?,?,?,?,?,?) ");

			st.setString(1, getCidade);
			st.setString(2, getCep);
			st.setString(3, getBairro);
			st.setString(4, getNumero);
			st.setString(5, getLogradouro);
			st.setInt(6, pessoaId);
			st.setString(7, getEstado);
			st.execute();

			txtNome.setText("");
			txtdCpf.setText("");
			txtTitulo.setText("");
			txtEmail.setText("");
			txtConfirmeSenha.setText("");
			txtSenha.setText("");
			txtCep.setText("");
			txtCidade.setText("");
			txtBairro.setText("");
			txtLogradouro.setText("");
			txtNumeroEnd.setText("");

			JOptionPane.showMessageDialog(null, "SALVO COM SUCESSO");

			} catch (SQLException e1) {
			e1.printStackTrace();
			}

			} else {
			JOptionPane.showMessageDialog(null, "SENHAS DIFERENTES");
			}
			} else if (itemSelecionado.equals("CANDIDATO")) {
			String perfilC = "candidato";
			if (txtNome.getText().isEmpty() || txtdCpf.getText().isEmpty() || txtEmail.getText().isEmpty()
			|| txtTitulo.getText().isEmpty() || txtSenha.getPassword().length == 0
			|| txtConfirmeSenha.getPassword().length == 0 || txtCidade.getText().isEmpty()
			|| txtBairro.getText().isEmpty() || txtCep.getText().isEmpty()
			|| txtEstado.getText().isEmpty() || txtLogradouro.getText().isEmpty()
			|| txtNumeroEnd.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos");
			} else if (Ssenha.equals(CSenha)) {

			try {
			conn = DB.getConnection();

			st = conn.prepareStatement(
			"Insert into pessoa (nome, cpf, titulo, email, senha,perfil,candidatoElietor)"
			+ "values (?,?,?,?,?,?,?) ",
			Statement.RETURN_GENERATED_KEYS);
			st.setString(1, getNome);
			st.setString(2, getCpf);
			st.setString(3, getTitulo);
			st.setString(4, getEmail);
			st.setString(5, CSenha);
			st.setString(6, perfilSelecionado);
			st.setString(7, perfilC);
			st.execute();

			rs = st.getGeneratedKeys();

			int pessoaId = -1;
			if (rs.next()) {
			pessoaId = rs.getInt(1);
			}
			st = conn.prepareStatement(
			"Insert into endereco (cidade, cep, bairro, numero, logradouro, pessoa_id, estado)"
			+ "values (?,?,?,?,?,?,?) ");

			st.setString(1, getCidade);
			st.setString(2, getCep);
			st.setString(3, getBairro);
			st.setString(4, getNumero);
			st.setString(5, getLogradouro);
			st.setInt(6, pessoaId);
			st.setString(7, getEstado);
			st.execute();

			String nomeEleicaoSelecionada = comboBoxEleicao.getSelectedItem().toString();
			int idEleicaoSelecionada = 0;

			try {
			conn = DB.getConnection();

			Statement stmtId = conn.createStatement();
			ResultSet rsId = stmtId.executeQuery(
			"SELECT id FROM eleicao WHERE tipo = '" + nomeEleicaoSelecionada + "'");
			if (rsId.next()) {
			idEleicaoSelecionada = rsId.getInt("id");
			}

			} catch (SQLException ex) {
			ex.printStackTrace();
			}

			// inserir na tabela candidato
			st = conn.prepareStatement(
			"INSERT INTO candidato (partido, numeroPartido, numeroCandidato, foto, eleicao_id, pessoa_id) "
			+ "VALUES (?, ?, ?, ?, ?, ?)",
			Statement.RETURN_GENERATED_KEYS);
			st.setString(1, getPartido);
			st.setInt(2, getNumPartido);
			st.setInt(3, getNumCandidato);
			st.setString(4, txtFotos);
			st.setInt(5, idEleicaoSelecionada);
			st.setInt(6, pessoaId);
			st.execute();

			// recuperar o id gerado automaticamente na tabela candidato
			int candidatoId = -1;
			rs = st.getGeneratedKeys();
			if (rs.next()) {
			candidatoId = rs.getInt(1);
			}

			// inserir na tabela eleicao_candidato
			st = conn.prepareStatement(
			"INSERT INTO eleicao_candidato (eleicao_id, candidato_id) VALUES (?, ?)");
			st.setInt(1, idEleicaoSelecionada);
			st.setInt(2, candidatoId);
			st.execute();

			MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

			MongoDatabase database = mongoClient.getDatabase("SistemaEleicao");

			MongoCollection<Document> collection = database.getCollection("documentoCandidato");

			Document documentoCandidato = new Document();
			documentoCandidato.append("nome", getNome);
			documentoCandidato.append("cpf", getCpf);
			documentoCandidato.append("titulo", getTitulo);
			documentoCandidato.append("email", getEmail);
			documentoCandidato.append("senha", CSenha);
			documentoCandidato.append("perfil", perfilSelecionado);
			documentoCandidato.append("candidatoElietor", perfilC);

			documentoCandidato.append("endereco",
			new Document().append("cidade", getCidade).append("cep", getCep)
			.append("bairro", getBairro).append("numero", getNumero)
			.append("logradouro", getLogradouro).append("estado", getEstado));

			documentoCandidato.append("eleicao",
			new Document().append("nomeEleicao", nomeEleicaoSelecionada));

			documentoCandidato.append("candidato",
			new Document().append("partido", getPartido).append("numeroPartido", getNumPartido)
			.append("numeroCandidato", getNumCandidato).append("foto", txtFotos)
			.append("eleicao_id", idEleicaoSelecionada).append("pessoa_id", pessoaId));

			collection.insertOne(documentoCandidato);

			mongoClient.close();

			txtNome.setText("");
			txtdCpf.setText("");
			txtTitulo.setText("");
			txtEmail.setText("");
			txtConfirmeSenha.setText("");
			txtSenha.setText("");
			txtCep.setText("");
			txtCidade.setText("");
			txtBairro.setText("");
			txtLogradouro.setText("");
			txtNumeroEnd.setText("");
			txtPartido.setText("");
			txtNumeroPartido.setText("");
			txtNumCandidato.setText("");
			txtFoto.setText("");

			JOptionPane.showMessageDialog(null, "SALVO COM SUCESSO");

			} catch (SQLException ex) {
			if (ex.getMessage().contains("cpf_unique")) {
			JOptionPane.showMessageDialog(null, "O CPF deve ser único.");
			} else if (ex.getMessage().contains("candidato_unique")) {
			JOptionPane.showMessageDialog(null, "O candidato já está associado a uma eleição.");
			} else {
			ex.printStackTrace();
			}
			}

			} else {
			JOptionPane.showMessageDialog(null, "SENHAS DIFERENTES");
			}
			}
			}
			});

		btnNewButton.setIcon(new ImageIcon(Cadastrro.class.getResource("/view/images/salve.png")));
		panelCadastro.add(lblNewLabel_6);
		panelCadastro.add(lblNewLabel_4);
		panelCadastro.add(lblNewLabel_3);
		panelCadastro.add(lblNewLabel_1);
		panelCadastro.add(lblNewLabel_5);
		panelCadastro.add(lblNewLabel);
		panelCadastro.add(lblNewLabel_2);
		panelCadastro.add(txtTitulo);
		panelCadastro.add(txtdCpf);
		panelCadastro.add(txtConfirmeSenha);
		panelCadastro.add(txtEmail);
		panelCadastro.add(txtNome);
		panelCadastro.add(txtSenha);
		panelCadastro.add(lblNewLabel_12);
		panelCadastro.add(lblNewLabel_7);
		panelCadastro.add(lblNewLabel_8);
		panelCadastro.add(txtCidade);
		panelCadastro.add(btnNewButton);
		panelCadastro.add(lblNewLabel_11);
		panelCadastro.add(txtBairro);
		panelCadastro.add(txtCep);
		panelCadastro.add(lblNewLabel_9);
		panelCadastro.add(lblNewLabel_10);
		panelCadastro.add(lblPartido);
		panelCadastro.add(lblNumeroPartido);
		panelCadastro.add(lblNumeroCandidato);
		panelCadastro.add(lblEleicao);
		panelCadastro.add(comboBoxEleicao);
		panelCadastro.add(txtNumCandidato);
		panelCadastro.add(txtNumeroEnd);
		panelCadastro.add(txtNumeroPartido);
		panelCadastro.add(txtPartido);
		panelCadastro.add(comboBox);
		panelCadastro.add(txtLogradouro);
		panelCadastro.add(txtEstado);

		JLabel lblNewLabel_18 = new JLabel("Eleitor/Candidato");
		lblNewLabel_18.setBounds(62, 45, 135, 14);
		lblNewLabel_18.setForeground(Color.WHITE);
		lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelCadastro.add(lblNewLabel_18);

		txtFoto = new JTextField();
		txtFoto.setBounds(494, 278, 149, 29);
		txtFoto.setColumns(10);
		panelCadastro.add(txtFoto);

		JLabel lblPerfilAdmin = new JLabel("Perfil:");
		lblPerfilAdmin.setBounds(58, 407, 100, 15);
		lblPerfilAdmin.setForeground(Color.WHITE);
		lblPerfilAdmin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelCadastro.add(lblPerfilAdmin);

		JPanel panelEleicaoo = new JPanel();
		Color rgbcolor = new Color(51, 51, 102);
		panelEleicaoo.setBackground(rgbcolor);
		panel_3.add(panelEleicaoo, "name_4758241682554900");

		JLabel lblNewLabel_13 = new JLabel("Elei��o");
		lblNewLabel_13.setBounds(287, 15, 120, 48);
		lblNewLabel_13.setForeground(new Color(255, 255, 255));
		lblNewLabel_13.setFont(new Font("Segoe UI Black", Font.PLAIN, 35));

		JLabel lblNewLabel_14 = new JLabel("Nome da Elei��o:");
		lblNewLabel_14.setBounds(124, 125, 94, 15);
		lblNewLabel_14.setForeground(new Color(255, 255, 255));
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 12));

		txtNomeEleicao = new JTextField();
		txtNomeEleicao.setBounds(123, 145, 169, 29);
		txtNomeEleicao.setColumns(10);

		JLabel lblNewLabel_15 = new JLabel("Tipo de Elei��o:");
		lblNewLabel_15.setBounds(123, 181, 104, 15);
		lblNewLabel_15.setForeground(new Color(255, 255, 255));
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 12));

		txtTipoEleicao = new JTextField();
		txtTipoEleicao.setBounds(124, 198, 171, 29);
		txtTipoEleicao.setColumns(10);

		JLabel lblNewLabel_16 = new JLabel("Data de inicio:");
		lblNewLabel_16.setBounds(124, 235, 77, 15);
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_16.setForeground(new Color(255, 255, 255));

		txtDataInicio = new JTextField();
		txtDataInicio.setColumns(10);

		JLabel lblNewLabel_17 = new JLabel("Data final:");
		lblNewLabel_17.setBounds(126, 290, 54, 15);
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_17.setForeground(new Color(255, 255, 255));

		txtDataFinal = new JTextField();
		txtDataFinal.setColumns(10);

		JTextArea textAreaChapa = new JTextArea();
		textAreaChapa.setBounds(356, 200, 301, 108);
		panelEleicaoo.add(textAreaChapa);

		MaskFormatter date = new MaskFormatter("##/##/####");
		txtDataInicio_1 = new JFormattedTextField(date);
		txtDataInicio_1.setBounds(124, 254, 111, 29);
		txtDataFinal_1 = new JFormattedTextField(date);
		txtDataFinal_1.setBounds(125, 309, 111, 29);

		JButton btnNewButton_4 = new JButton("SALVAR");
		btnNewButton_4.setToolTipText("Salvar");
		btnNewButton_4.setBounds(299, 430, 136, 48);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String sNome = txtNomeEleicao.getText();
				String sTipo = txtTipoEleicao.getText();
				String sDataInicio = txtDataInicio_1.getText();
				String sDataFinal = txtDataFinal_1.getText();

				Connection conn = null;
				PreparedStatement st = null;
				ResultSet rs = null;

				if (sNome.isEmpty() || sTipo.isEmpty() || sDataInicio.trim().isEmpty() || sDataFinal.trim().isEmpty()
						|| txtNomeChapa.getText().isEmpty() || textAreaChapa.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "PREENCHA TODOS OS DADOS");
				} else {
					try {
						conn = DB.getConnection();

						SimpleDateFormat parseDate = new SimpleDateFormat("dd/MM/yyyy");
						Date dataInicio = parseDate.parse(sDataInicio);
						Date dataAtual = new Date();
						Date dataFinal = parseDate.parse(sDataFinal);

						/*
						 * if (dataInicio.before(dataAtual) || dataFinal.before(dataAtual)) {
						 * JOptionPane.showMessageDialog(null,
						 * "As datas n�o podem ser anteriores � data atual."); }
						 */

						st = conn.prepareStatement(
								"INSERT INTO eleicao (nome, tipo, dataInicio, dataFinal) VALUES (?, ?, ?, ?)",
								Statement.RETURN_GENERATED_KEYS);
						st.setString(1, sNome);
						st.setString(2, sTipo);
						st.setDate(3, new java.sql.Date(dataInicio.getTime()));
						st.setDate(4, new java.sql.Date(dataFinal.getTime()));
						st.execute();

						rs = st.getGeneratedKeys();
						int idEleicao = -1;
						if (rs.next()) {
							idEleicao = rs.getInt(1);
						}

						st = conn.prepareStatement("INSERT INTO chapa (nome, descricao) VALUES (?, ?)",
								Statement.RETURN_GENERATED_KEYS);
						st.setString(1, txtNomeChapa.getText());
						st.setString(2, textAreaChapa.getText());
						st.execute();

						rs = st.getGeneratedKeys();
						if (rs.next()) {
							int idChapa = rs.getInt(1);

							st = conn
									.prepareStatement("INSERT INTO eleicao_chapa (eleicao_id, chapa_id) VALUES (?, ?)");
							st.setInt(1, idEleicao);
							st.setInt(2, idChapa);
							st.execute();
						}

						txtNomeEleicao.setText("");
						txtTipoEleicao.setText("");
						txtDataInicio_1.setText("");
						txtDataFinal_1.setText("");
						txtNomeChapa.setText("");
						textAreaChapa.setText("");

						JOptionPane.showMessageDialog(null, "SALVO COM SUCESSO");

					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (ParseException e1) {
						JOptionPane.showMessageDialog(null, "Data inv�lida. Informe a data no formato yyyy/MM/dd.");
						e1.printStackTrace();
					}
				}
			}
		});
		panelEleicaoo.setLayout(null);
		btnNewButton_4.setIcon(new ImageIcon(Cadastrro.class.getResource("/view/images/salve.png")));
		panelEleicaoo.add(btnNewButton_4);
		panelEleicaoo.add(lblNewLabel_14);
		panelEleicaoo.add(lblNewLabel_15);
		panelEleicaoo.add(lblNewLabel_17);
		panelEleicaoo.add(lblNewLabel_16);
		panelEleicaoo.add(txtNomeEleicao);
		panelEleicaoo.add(txtTipoEleicao);
		panelEleicaoo.add(txtDataInicio_1);
		panelEleicaoo.add(txtDataFinal_1);
		panelEleicaoo.add(lblNewLabel_13);

		txtNomeChapa = new JTextField();
		txtNomeChapa.setColumns(10);
		txtNomeChapa.setBounds(356, 145, 169, 29);
		panelEleicaoo.add(txtNomeChapa);

		JLabel lblNewLabel_14_1 = new JLabel("Nome da chapa:");
		lblNewLabel_14_1.setForeground(Color.WHITE);
		lblNewLabel_14_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_14_1.setBounds(357, 125, 94, 15);
		panelEleicaoo.add(lblNewLabel_14_1);

		JLabel lblNewLabel_15_1 = new JLabel("Descri\u00E7\u00E3o da Chapa:");
		lblNewLabel_15_1.setForeground(Color.WHITE);
		lblNewLabel_15_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_15_1.setBounds(356, 181, 186, 15);
		panelEleicaoo.add(lblNewLabel_15_1);

		JPanel panelAtualizar = new JPanel();
		panel_3.add(panelAtualizar, "name_4809791634129700");
		panelAtualizar.setBackground(rgbcolor);
		panelAtualizar.setLayout(null);

		JLabel lblNewLabel_13_1 = new JLabel("Gerenciar");
		lblNewLabel_13_1.setBounds(224, 0, 166, 48);
		lblNewLabel_13_1.setForeground(Color.WHITE);
		lblNewLabel_13_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 35));
		panelAtualizar.add(lblNewLabel_13_1);

		JPanel panelTxtUsuario = new JPanel();
		panelTxtUsuario.setBounds(37, 60, 670, 240);
		panelAtualizar.add(panelTxtUsuario);
		panelTxtUsuario.setLayout(new CardLayout(0, 0));

		JPanel panelCrudUsuario = new JPanel();
		panelCrudUsuario.setBackground(new Color(51, 51, 102));
		panelTxtUsuario.add(panelCrudUsuario, "name_63220130488700");
		panelCrudUsuario.setLayout(null);

		textCrudFieldName = new JTextField();
		textCrudFieldName.setBounds(11, 17, 213, 29);
		panelCrudUsuario.add(textCrudFieldName);
		textCrudFieldName.setColumns(10);

		JLabel lblCrudName = new JLabel("Nome:");
		lblCrudName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrudName.setForeground(Color.WHITE);
		lblCrudName.setBounds(13, 0, 117, 14);
		panelCrudUsuario.add(lblCrudName);

		textCrudFieldCpf = new JTextField();
		textCrudFieldCpf.setColumns(10);
		textCrudFieldCpf.setBounds(10, 69, 213, 29);
		panelCrudUsuario.add(textCrudFieldCpf);

		JLabel lblCrudCpf = new JLabel("Cpf:");
		lblCrudCpf.setForeground(Color.WHITE);
		lblCrudCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrudCpf.setBounds(12, 52, 117, 14);
		panelCrudUsuario.add(lblCrudCpf);

		textCrudFieldTitulo = new JTextField();
		textCrudFieldTitulo.setColumns(10);
		textCrudFieldTitulo.setBounds(11, 121, 213, 29);
		panelCrudUsuario.add(textCrudFieldTitulo);

		JLabel lblCrudTitulo = new JLabel("Titulo:");
		lblCrudTitulo.setForeground(Color.WHITE);
		lblCrudTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrudTitulo.setBounds(13, 104, 117, 14);
		panelCrudUsuario.add(lblCrudTitulo);

		textCrudFieldEmail = new JTextField();
		textCrudFieldEmail.setColumns(10);
		textCrudFieldEmail.setBounds(303, 20, 239, 29);
		panelCrudUsuario.add(textCrudFieldEmail);

		JLabel lblCrudEmail = new JLabel("Email:");
		lblCrudEmail.setForeground(Color.WHITE);
		lblCrudEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrudEmail.setBounds(305, 3, 117, 14);
		panelCrudUsuario.add(lblCrudEmail);

		textCrudFieldSenha = new JTextField();
		textCrudFieldSenha.setColumns(10);
		textCrudFieldSenha.setBounds(303, 71, 213, 29);
		panelCrudUsuario.add(textCrudFieldSenha);

		JLabel lblCrudSenha = new JLabel("Senha:");
		lblCrudSenha.setForeground(Color.WHITE);
		lblCrudSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrudSenha.setBounds(305, 54, 117, 14);
		panelCrudUsuario.add(lblCrudSenha);

		JLabel lblCrudPerfil = new JLabel("Perfil:");
		lblCrudPerfil.setForeground(Color.WHITE);
		lblCrudPerfil.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrudPerfil.setBounds(306, 104, 117, 14);
		panelCrudUsuario.add(lblCrudPerfil);

		JLabel lblCrudCandidatoOrElitor = new JLabel("Candidato/Eleito");
		lblCrudCandidatoOrElitor.setForeground(Color.WHITE);
		lblCrudCandidatoOrElitor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrudCandidatoOrElitor.setBounds(12, 155, 117, 14);
		panelCrudUsuario.add(lblCrudCandidatoOrElitor);

		JPanel panelCrudEleicao = new JPanel();
		panelCrudEleicao.setBackground(new Color(51, 51, 102));
		panelCrudEleicao.setForeground(Color.RED);
		panelTxtUsuario.add(panelCrudEleicao, "name_63220141758100");
		panelCrudEleicao.setLayout(null);

		textFieldCrudNomeEleicao = new JTextField();
		textFieldCrudNomeEleicao.setBounds(129, 68, 199, 29);
		panelCrudEleicao.add(textFieldCrudNomeEleicao);
		textFieldCrudNomeEleicao.setColumns(10);

		JLabel lblNewLabel_22 = new JLabel("Nome:");
		lblNewLabel_22.setForeground(Color.WHITE);
		lblNewLabel_22.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_22.setBounds(129, 50, 69, 14);
		panelCrudEleicao.add(lblNewLabel_22);

		textFieldFieldTipoEleicao = new JTextField();
		textFieldFieldTipoEleicao.setColumns(10);
		textFieldFieldTipoEleicao.setBounds(129, 126, 199, 29);
		panelCrudEleicao.add(textFieldFieldTipoEleicao);

		JLabel lblNewLabel_22_1 = new JLabel("Tipo:");
		lblNewLabel_22_1.setForeground(Color.WHITE);
		lblNewLabel_22_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_22_1.setBounds(129, 108, 69, 14);
		panelCrudEleicao.add(lblNewLabel_22_1);

		MaskFormatter dateEleicaoCrud = new MaskFormatter("##/##/####");
		JFormattedTextField txtDataInicioCrudEleicao = new JFormattedTextField(dateEleicaoCrud);
		txtDataInicioCrudEleicao.setBounds(358, 69, 111, 29);
		panelCrudEleicao.add(txtDataInicioCrudEleicao);

		JFormattedTextField txtDataFinalCrudEleicao = new JFormattedTextField(dateEleicaoCrud);
		txtDataFinalCrudEleicao.setBounds(359, 124, 111, 29);
		panelCrudEleicao.add(txtDataFinalCrudEleicao);

		JLabel lblNewLabel_16_1 = new JLabel("Data de inicio:");
		lblNewLabel_16_1.setForeground(Color.WHITE);
		lblNewLabel_16_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_16_1.setBounds(358, 50, 111, 15);
		panelCrudEleicao.add(lblNewLabel_16_1);

		JLabel lblNewLabel_17_1 = new JLabel("Data final:");
		lblNewLabel_17_1.setForeground(Color.WHITE);
		lblNewLabel_17_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_17_1.setBounds(360, 105, 109, 15);
		panelCrudEleicao.add(lblNewLabel_17_1);

		JPanel panelCrudEndereco = new JPanel();
		panelCrudEndereco.setBackground(new Color(51, 51, 102));
		panelCrudEndereco.setForeground(Color.DARK_GRAY);
		panelTxtUsuario.add(panelCrudEndereco, "name_63220152636900");
		panelCrudEndereco.setLayout(null);

		textFieldCidadeCrud = new JTextField();
		textFieldCidadeCrud.setBounds(125, 56, 184, 29);
		panelCrudEndereco.add(textFieldCidadeCrud);
		textFieldCidadeCrud.setColumns(10);

		JLabel lblNewLabel_23 = new JLabel("Cidade:");
		lblNewLabel_23.setForeground(Color.WHITE);
		lblNewLabel_23.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_23.setBounds(125, 38, 120, 14);
		panelCrudEndereco.add(lblNewLabel_23);

		textFieldBairroCrud = new JTextField();
		textFieldBairroCrud.setColumns(10);
		textFieldBairroCrud.setBounds(125, 109, 184, 29);
		panelCrudEndereco.add(textFieldBairroCrud);

		JLabel lblNewLabel_23_1 = new JLabel("Bairro:");
		lblNewLabel_23_1.setForeground(Color.WHITE);
		lblNewLabel_23_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_23_1.setBounds(125, 91, 120, 14);
		panelCrudEndereco.add(lblNewLabel_23_1);

		textFieldCepCrud = new JTextField();
		textFieldCepCrud.setColumns(10);
		textFieldCepCrud.setBounds(125, 167, 120, 29);
		panelCrudEndereco.add(textFieldCepCrud);

		JLabel lblNewLabel_23_2 = new JLabel("Cep:");
		lblNewLabel_23_2.setForeground(Color.WHITE);
		lblNewLabel_23_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_23_2.setBounds(125, 149, 120, 14);
		panelCrudEndereco.add(lblNewLabel_23_2);

		textFieldNumeroCasaCrud = new JTextField();
		textFieldNumeroCasaCrud.setColumns(10);
		textFieldNumeroCasaCrud.setBounds(336, 167, 75, 29);
		panelCrudEndereco.add(textFieldNumeroCasaCrud);

		JLabel lblNewLabel_23_3 = new JLabel("Numero:");
		lblNewLabel_23_3.setForeground(Color.WHITE);
		lblNewLabel_23_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_23_3.setBounds(336, 149, 120, 14);
		panelCrudEndereco.add(lblNewLabel_23_3);

		textFieldLogradouroCrud = new JTextField();
		textFieldLogradouroCrud.setColumns(10);
		textFieldLogradouroCrud.setBounds(336, 56, 184, 29);
		panelCrudEndereco.add(textFieldLogradouroCrud);

		JLabel lblNewLabel_23_4 = new JLabel("Logradouro:");
		lblNewLabel_23_4.setForeground(Color.WHITE);
		lblNewLabel_23_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_23_4.setBounds(336, 38, 120, 14);
		panelCrudEndereco.add(lblNewLabel_23_4);

		textFieldEstadoCrud = new JTextField();
		textFieldEstadoCrud.setColumns(10);
		textFieldEstadoCrud.setBounds(336, 109, 75, 29);
		panelCrudEndereco.add(textFieldEstadoCrud);

		JLabel lblNewLabel_23_5 = new JLabel("Estato:");
		lblNewLabel_23_5.setForeground(Color.WHITE);
		lblNewLabel_23_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_23_5.setBounds(336, 91, 120, 14);
		panelCrudEndereco.add(lblNewLabel_23_5);

		JPanel panelCrudChapa = new JPanel();
		panelCrudChapa.setBackground(new Color(51, 51, 102));
		panelCrudChapa.setForeground(Color.PINK);
		panelTxtUsuario.add(panelCrudChapa, "name_65372631586400");
		panelCrudChapa.setLayout(null);

		textFieldNomeChapaCrud = new JTextField();
		textFieldNomeChapaCrud.setBounds(185, 43, 148, 29);
		panelCrudChapa.add(textFieldNomeChapaCrud);
		textFieldNomeChapaCrud.setColumns(10);

		JLabel lblNewLabel_24 = new JLabel("Nome:");
		lblNewLabel_24.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_24.setForeground(Color.WHITE);
		lblNewLabel_24.setBounds(185, 23, 106, 14);
		panelCrudChapa.add(lblNewLabel_24);

		JTextArea textAreaChapaCrud = new JTextArea();
		textAreaChapaCrud.setBounds(185, 113, 297, 105);
		panelCrudChapa.add(textAreaChapaCrud);

		JLabel lblNewLabel_24_1 = new JLabel("Descri\u00E7\u00E3o:");
		lblNewLabel_24_1.setForeground(Color.WHITE);
		lblNewLabel_24_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_24_1.setBounds(185, 94, 106, 14);
		panelCrudChapa.add(lblNewLabel_24_1);

		JPanel panelCrudCandidato = new JPanel();
		panelCrudCandidato.setBackground(new Color(51, 51, 102));
		panelCrudCandidato.setForeground(Color.WHITE);
		panelTxtUsuario.add(panelCrudCandidato, "name_63220163126400");
		panelCrudCandidato.setLayout(null);

		textNomeCandidatoCrud = new JTextField();
		textNomeCandidatoCrud.setColumns(10);
		textNomeCandidatoCrud.setBounds(1, 17, 213, 29);
		panelCrudCandidato.add(textNomeCandidatoCrud);

		JLabel lblCrudName_1 = new JLabel("Nome:");
		lblCrudName_1.setForeground(Color.WHITE);
		lblCrudName_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrudName_1.setBounds(3, 0, 117, 14);
		panelCrudCandidato.add(lblCrudName_1);

		JLabel lblCrudCpf_1 = new JLabel("Cpf:");
		lblCrudCpf_1.setForeground(Color.WHITE);
		lblCrudCpf_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrudCpf_1.setBounds(2, 52, 117, 14);
		panelCrudCandidato.add(lblCrudCpf_1);

		textCpfCandidatoCrud = new JTextField();
		textCpfCandidatoCrud.setColumns(10);
		textCpfCandidatoCrud.setBounds(0, 69, 213, 29);
		panelCrudCandidato.add(textCpfCandidatoCrud);

		JLabel lblCrudTitulo_1 = new JLabel("Titulo:");
		lblCrudTitulo_1.setForeground(Color.WHITE);
		lblCrudTitulo_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrudTitulo_1.setBounds(3, 104, 117, 14);
		panelCrudCandidato.add(lblCrudTitulo_1);

		textTituloCandidatoCrud = new JTextField();
		textTituloCandidatoCrud.setColumns(10);
		textTituloCandidatoCrud.setBounds(1, 121, 213, 29);
		panelCrudCandidato.add(textTituloCandidatoCrud);

		JLabel lblCrudCandidatoOrElitor_1 = new JLabel("Candidato/Eleito");
		lblCrudCandidatoOrElitor_1.setForeground(Color.WHITE);
		lblCrudCandidatoOrElitor_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrudCandidatoOrElitor_1.setBounds(2, 155, 117, 14);
		panelCrudCandidato.add(lblCrudCandidatoOrElitor_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 353, 705, 161);
		panelAtualizar.add(scrollPane);

		tableAdmin = new JTable();
		tableAdmin.setFocusTraversalKeysEnabled(false);
		tableAdmin.setFocusable(false);
		tableAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = tableAdmin.getSelectedRow();

				if (tableAdmin.getRowCount() > 0 && tableAdmin.getColumnCount() > 5) {

					if (row >= 0) {

						textCrudFieldName.setText(tableAdmin.getValueAt(row, 1).toString());
						textCrudFieldCpf.setText(tableAdmin.getValueAt(row, 2).toString());
						textCrudFieldTitulo.setText(tableAdmin.getValueAt(row, 3).toString());
						textCrudFieldEmail.setText(tableAdmin.getValueAt(row, 4).toString());
						textCrudFieldSenha.setText(tableAdmin.getValueAt(row, 5).toString());
					}
				}

				if (tableAdmin.getRowCount() > 0 && tableAdmin.getColumnCount() > 2) {

					if (row >= 0) {
						textFieldNomeChapaCrud.setText(tableAdmin.getValueAt(row, 1).toString());
						textAreaChapaCrud.setText(tableAdmin.getValueAt(row, 2).toString());
					}
				}

				if (tableAdmin.getRowCount() > 0 && tableAdmin.getColumnCount() > 9) {

					if (row >= 0) {

						textNomeCandidatoCrud.setText(tableAdmin.getValueAt(row, 1).toString());
						textCpfCandidatoCrud.setText(tableAdmin.getValueAt(row, 2).toString());
						textTituloCandidatoCrud.setText(tableAdmin.getValueAt(row, 3).toString());
						textEmailCandidatoCrud.setText(tableAdmin.getValueAt(row, 4).toString());
						textSenhaCandidatoCrud.setText(tableAdmin.getValueAt(row, 5).toString());
						textNomePartidoCandidatoCrud.setText(tableAdmin.getValueAt(row, 8).toString());
						textNumeroPartidoCandidatoCrud.setText(tableAdmin.getValueAt(row, 9).toString());
						textNumeroCCandidatoCrud.setText(tableAdmin.getValueAt(row, 10).toString());
						textFotoCandidatoCrud.setText(tableAdmin.getValueAt(row, 12).toString());

						textFieldCidadeCrud.setText(tableAdmin.getValueAt(row, 1).toString());
						textFieldCepCrud.setText(tableAdmin.getValueAt(row, 2).toString());
						textFieldBairroCrud.setText(tableAdmin.getValueAt(row, 3).toString());
						textFieldNumeroCasaCrud.setText(tableAdmin.getValueAt(row, 4).toString());
						textFieldLogradouroCrud.setText(tableAdmin.getValueAt(row, 5).toString());
						textFieldEstadoCrud.setText(tableAdmin.getValueAt(row, 6).toString());

					}
				}

				if (tableAdmin.getRowCount() > 0 && tableAdmin.getColumnCount() > 8) {

					if (row >= 0) {

						textFieldCidadeCrud.setText(tableAdmin.getValueAt(row, 1).toString());
						textFieldCepCrud.setText(tableAdmin.getValueAt(row, 2).toString());
						textFieldBairroCrud.setText(tableAdmin.getValueAt(row, 3).toString());
						textFieldNumeroCasaCrud.setText(tableAdmin.getValueAt(row, 4).toString());
						textFieldLogradouroCrud.setText(tableAdmin.getValueAt(row, 5).toString());
						textFieldEstadoCrud.setText(tableAdmin.getValueAt(row, 6).toString());

					}
				}

				if (tableAdmin.getRowCount() > 0 && tableAdmin.getColumnCount() > 4) {

					if (row >= 0) {
						textFieldCrudNomeEleicao.setText(tableAdmin.getValueAt(row, 1).toString());
						textFieldFieldTipoEleicao.setText(tableAdmin.getValueAt(row, 2).toString());
						txtDataInicioCrudEleicao.setText(tableAdmin.getValueAt(row, 3).toString());
						txtDataFinalCrudEleicao.setText(tableAdmin.getValueAt(row, 4).toString());
					}
				}

			}
		});
		tableAdmin.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Id", "Nome", "Cpf", "Titulo", "Email", "Senha", "Perfil", "Informa��o" }));
		scrollPane.setViewportView(tableAdmin);

		JComboBox comboBoxInfoCandidatoCrud = new JComboBox();
		comboBoxInfoCandidatoCrud.setModel(new DefaultComboBoxModel(new String[] { "Candidato", "Eleitor" }));
		comboBoxInfoCandidatoCrud.setBounds(1, 174, 213, 29);
		panelCrudCandidato.add(comboBoxInfoCandidatoCrud);

		textEmailCandidatoCrud = new JTextField();
		textEmailCandidatoCrud.setColumns(10);
		textEmailCandidatoCrud.setBounds(235, 17, 213, 29);
		panelCrudCandidato.add(textEmailCandidatoCrud);

		JLabel lblCrudEmail_1 = new JLabel("Email:");
		lblCrudEmail_1.setForeground(Color.WHITE);
		lblCrudEmail_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrudEmail_1.setBounds(237, 0, 117, 14);
		panelCrudCandidato.add(lblCrudEmail_1);

		JLabel lblCrudSenha_1 = new JLabel("Senha:");
		lblCrudSenha_1.setForeground(Color.WHITE);
		lblCrudSenha_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrudSenha_1.setBounds(237, 51, 117, 14);
		panelCrudCandidato.add(lblCrudSenha_1);

		textSenhaCandidatoCrud = new JTextField();
		textSenhaCandidatoCrud.setColumns(10);
		textSenhaCandidatoCrud.setBounds(235, 68, 213, 29);
		panelCrudCandidato.add(textSenhaCandidatoCrud);

		JLabel lblCrudPerfil_1 = new JLabel("Perfil:");
		lblCrudPerfil_1.setForeground(Color.WHITE);
		lblCrudPerfil_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrudPerfil_1.setBounds(235, 152, 117, 14);
		panelCrudCandidato.add(lblCrudPerfil_1);

		JComboBox comboBoxCrudPerfilCandidatoCrud = new JComboBox();
		comboBoxCrudPerfilCandidatoCrud.setModel(new DefaultComboBoxModel(new String[] { "comun", "admin" }));
		comboBoxCrudPerfilCandidatoCrud.setBounds(235, 171, 213, 29);
		panelCrudCandidato.add(comboBoxCrudPerfilCandidatoCrud);

		textNomePartidoCandidatoCrud = new JTextField();
		textNomePartidoCandidatoCrud.setColumns(10);
		textNomePartidoCandidatoCrud.setBounds(235, 118, 101, 29);
		panelCrudCandidato.add(textNomePartidoCandidatoCrud);

		textNumeroPartidoCandidatoCrud = new JTextField();
		textNumeroPartidoCandidatoCrud.setColumns(10);
		textNumeroPartidoCandidatoCrud.setBounds(346, 118, 102, 29);
		panelCrudCandidato.add(textNumeroPartidoCandidatoCrud);

		JLabel lblNewLabel_20 = new JLabel("Nome Partido:");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_20.setForeground(Color.WHITE);
		lblNewLabel_20.setBounds(235, 103, 109, 14);
		panelCrudCandidato.add(lblNewLabel_20);

		JLabel lblNewLabel_20_1 = new JLabel("Numero Partido:");
		lblNewLabel_20_1.setForeground(Color.WHITE);
		lblNewLabel_20_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_20_1.setBounds(346, 103, 109, 14);
		panelCrudCandidato.add(lblNewLabel_20_1);

		textFotoCandidatoCrud = new JTextField();
		textFotoCandidatoCrud.setColumns(10);
		textFotoCandidatoCrud.setBounds(465, 16, 195, 29);
		panelCrudCandidato.add(textFotoCandidatoCrud);

		JLabel lblCrudEmail_1_1 = new JLabel("Foto:");
		lblCrudEmail_1_1.setForeground(Color.WHITE);
		lblCrudEmail_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrudEmail_1_1.setBounds(465, 0, 70, 14);
		panelCrudCandidato.add(lblCrudEmail_1_1);

		textNumeroCCandidatoCrud = new JTextField();
		textNumeroCCandidatoCrud.setColumns(10);
		textNumeroCCandidatoCrud.setBounds(465, 68, 134, 29);
		panelCrudCandidato.add(textNumeroCCandidatoCrud);

		JLabel lblCrudEmail_1_1_1 = new JLabel("Numero Candidato:");
		lblCrudEmail_1_1_1.setForeground(Color.WHITE);
		lblCrudEmail_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCrudEmail_1_1_1.setBounds(465, 52, 134, 14);
		panelCrudCandidato.add(lblCrudEmail_1_1_1);

		tableAdmin.setDefaultEditor(Object.class, null);
		tableAdmin.getTableHeader().setReorderingAllowed(false);

		JComboBox comboBoxCrudSelect = new JComboBox();
		comboBoxCrudSelect.setBounds(453, 308, 130, 34);
		comboBoxCrudSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String itemSelecionadoCombox = comboBoxCrudSelect.getSelectedItem().toString();

				if (itemSelecionadoCombox.equals("Usuario")) {
					panelCrudUsuario.setVisible(true);
					panelCrudCandidato.setVisible(false);
					panelCrudEleicao.setVisible(false);
					panelCrudEndereco.setVisible(false);
					panelCrudChapa.setVisible(false);
				} else if (itemSelecionadoCombox.equals("Candidato")) {
					panelCrudCandidato.setVisible(true);
					panelCrudUsuario.setVisible(false);
					panelCrudEleicao.setVisible(false);
					panelCrudEndereco.setVisible(false);
					panelCrudChapa.setVisible(false);
				} else if (itemSelecionadoCombox.equals("Elei��o")) {
					panelCrudEleicao.setVisible(true);
					panelCrudCandidato.setVisible(false);
					panelCrudUsuario.setVisible(false);
					panelCrudEndereco.setVisible(false);
					panelCrudChapa.setVisible(false);
				} else if (itemSelecionadoCombox.equals("Endere�o")) {
					panelCrudEndereco.setVisible(true);
					panelCrudEleicao.setVisible(false);
					panelCrudCandidato.setVisible(false);
					panelCrudUsuario.setVisible(false);
					panelCrudChapa.setVisible(false);
				} else if (itemSelecionadoCombox.equals("Chapa")) {
					panelCrudChapa.setVisible(true);
					panelCrudEndereco.setVisible(false);
					panelCrudEleicao.setVisible(false);
					panelCrudCandidato.setVisible(false);
					panelCrudUsuario.setVisible(false);
				}

			}
		});

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setIcon(new ImageIcon(Cadastrro.class.getResource("/view/images/delete.png")));
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String itemSelecionadoCombox = comboBoxCrudSelect.getSelectedItem().toString();

				Connection conn = null;
				PreparedStatement st = null;

				int row = tableAdmin.getSelectedRow();

				if (itemSelecionadoCombox.equals("Usuario")) {
					try {

						if (row == -1) {
							JOptionPane.showMessageDialog(null, "Selecione a linha que deseja excluir");
						} else {
							int id = Integer.parseInt(tableAdmin.getValueAt(row, 0).toString());

							if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover?", "Remover",
									JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

								conn = DB.getConnection();

								st = conn.prepareStatement("SELECT id FROM candidato WHERE pessoa_id = ?");
								st.setInt(1, id);
								ResultSet rs = st.executeQuery();
								boolean isCandidato = rs.next();
								rs.close();

								if (isCandidato) {

									st = conn.prepareStatement(
											"DELETE FROM eleicao_candidato WHERE candidato_id IN (SELECT id FROM candidato WHERE pessoa_id = ?)");
									st.setInt(1, id);
									st.executeUpdate();

									st = conn.prepareStatement("DELETE FROM candidato WHERE pessoa_id = ?");
									st.setInt(1, id);
									st.executeUpdate();
								}

								st = conn.prepareStatement("DELETE FROM endereco WHERE pessoa_id = ?");
								st.setInt(1, id);
								st.executeUpdate();

								st = conn.prepareStatement("DELETE FROM pessoa WHERE id = ?");
								st.setInt(1, id);
								st.executeUpdate();

								((DefaultTableModel) tableAdmin.getModel()).removeRow(row);
								JOptionPane.showMessageDialog(null, "Candidato exclu�do com sucesso");

							}
						}
					} catch (SQLException ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null, "Erro ao remover tarefa: " + ex.getMessage(), "Erro",
								JOptionPane.ERROR_MESSAGE);
					}

				} else if (itemSelecionadoCombox.equals("Candidato")) {
					try {
						if (row == -1) {
							JOptionPane.showMessageDialog(null, "Selecione a linha que deseja excluir");
						} else {
							int id = Integer.parseInt(tableAdmin.getValueAt(row, 0).toString());

							if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover?", "Remover",
									JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

								conn = DB.getConnection();

								st = conn.prepareStatement("SELECT id FROM candidato WHERE pessoa_id = ?");
								st.setInt(1, id);
								ResultSet rs = st.executeQuery();
								boolean isCandidato = rs.next();
								rs.close();

								if (isCandidato) {

									st = conn.prepareStatement(
											"DELETE FROM eleicao_candidato WHERE candidato_id IN (SELECT id FROM candidato WHERE pessoa_id = ?)");
									st.setInt(1, id);
									st.executeUpdate();

									st = conn.prepareStatement("DELETE FROM candidato WHERE pessoa_id = ?");
									st.setInt(1, id);
									st.executeUpdate();
								}

								st = conn.prepareStatement("DELETE FROM endereco WHERE pessoa_id = ?");
								st.setInt(1, id);
								st.executeUpdate();

								st = conn.prepareStatement("DELETE FROM pessoa WHERE id = ?");
								st.setInt(1, id);
								st.executeUpdate();

								JOptionPane.showMessageDialog(null, "Candidato exclu�do com sucesso");

								((DefaultTableModel) tableAdmin.getModel()).removeRow(row);

							}
						}
					} catch (SQLException ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null, "Erro ao remover Candidato: " + ex.getMessage(), "Erro",
								JOptionPane.ERROR_MESSAGE);
					}
				}

				else if (itemSelecionadoCombox.equals("Elei��o")) {
					try {
						if (row == -1) {
							JOptionPane.showMessageDialog(null, "Selecione a linha que deseja excluir");
						} else {
							int id = Integer.parseInt(tableAdmin.getValueAt(row, 0).toString());

							if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover?", "Remover",
									JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

								conn = DB.getConnection();

								// Excluir as refer�ncias na tabela "eleicao_candidato"
								st = conn.prepareStatement("DELETE FROM eleicao_candidato WHERE eleicao_id = ?");
								st.setInt(1, id);
								st.executeUpdate();

								st = conn.prepareStatement("DELETE FROM voto WHERE eleicao_id = ?");
								st.setInt(1, id);
								st.executeUpdate();

								st = conn.prepareStatement("DELETE FROM candidato WHERE eleicao_id = ?");
								st.setInt(1, id);
								st.executeUpdate();

								st = conn.prepareStatement("DELETE FROM eleicao_chapa WHERE eleicao_id = ?");
								st.setInt(1, id);
								st.executeUpdate();

								st = conn.prepareStatement(
										"DELETE FROM chapa WHERE id IN (SELECT chapa_id FROM eleicao_chapa WHERE eleicao_id = ?)");
								st.setInt(1, id);
								st.executeUpdate();

								st = conn.prepareStatement("DELETE FROM eleicao WHERE id = ?");
								st.setInt(1, id);
								st.executeUpdate();
								((DefaultTableModel) tableAdmin.getModel()).removeRow(row);
								JOptionPane.showMessageDialog(null, "Candidato exclu�do com sucesso");
							}
						}
					} catch (SQLException ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null, "Erro ao remover Candidato: " + ex.getMessage(), "Erro",
								JOptionPane.ERROR_MESSAGE);
					}
				}

				else if (itemSelecionadoCombox.equals("Endere�o")) {
					try {
						if (row == -1) {
							JOptionPane.showMessageDialog(null, "Selecione a linha que deseja excluir");
						} else {
							int id = Integer.parseInt(tableAdmin.getValueAt(row, 0).toString());

							if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover?", "Remover",
									JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

								conn = DB.getConnection();

								st = conn.prepareStatement("DELETE FROM endereco WHERE id = ?");
								st.setInt(1, id);
								st.executeUpdate();

								((DefaultTableModel) tableAdmin.getModel()).removeRow(row);
								JOptionPane.showMessageDialog(null, "Candidato exclu�do com sucesso");
							}
						}

					} catch (SQLException ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null, "Erro ao remover Candidato: " + ex.getMessage(), "Erro",
								JOptionPane.ERROR_MESSAGE);
					}
				}

				else if (itemSelecionadoCombox.equals("Chapa")) {
					try {
						if (row == -1) {
							JOptionPane.showMessageDialog(null, "Selecione a linha que deseja excluir");
						} else {
							int id = Integer.parseInt(tableAdmin.getValueAt(row, 0).toString());

							if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover?", "Remover",
									JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

								conn = DB.getConnection();

								st = conn.prepareStatement("DELETE FROM eleicao_chapa WHERE chapa_id = ?");
								st.setInt(1, id);
								st.executeUpdate();

								st = conn.prepareStatement("DELETE FROM chapa WHERE id = ?");
								st.setInt(1, id);
								st.executeUpdate();

								((DefaultTableModel) tableAdmin.getModel()).removeRow(row);
								JOptionPane.showMessageDialog(null, "Candidato exclu�do com sucesso");
							}
						}

					} catch (SQLException ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null, "Erro ao remover Candidato: " + ex.getMessage(), "Erro",
								JOptionPane.ERROR_MESSAGE);
					}
				}

			}

		});
		btnDeletar.setBounds(137, 304, 125, 38);
		btnDeletar.setToolTipText("Deletar");
		panelAtualizar.add(btnDeletar);

		JButton btnListar = new JButton("Listar");
		btnListar.setIcon(new ImageIcon(Cadastrro.class.getResource("/view/images/buscar.png")));
		btnListar.setBounds(602, 305, 113, 37);
		btnListar.setToolTipText("Buscar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String itemSelecionadoCombox = comboBoxCrudSelect.getSelectedItem().toString();

				Connection conn = null;
				Statement st = null;
				ResultSet rs = null;

				DefaultTableModel tabela = (DefaultTableModel) tableAdmin.getModel();
				tabela.setRowCount(0);

				try {
					conn = DB.getConnection();

					if (itemSelecionadoCombox.equals("Usuario")) {

						st = conn.createStatement();

						rs = st.executeQuery("SELECT * FROM pessoa");

						DefaultTableModel tabelaUsuario = (DefaultTableModel) tableAdmin.getModel();
						tabelaUsuario.setColumnCount(0);
						tabelaUsuario.addColumn("Id");
						tabelaUsuario.addColumn("Nome");
						tabelaUsuario.addColumn("Cpf");
						tabelaUsuario.addColumn("Titulo");
						tabelaUsuario.addColumn("Email");
						tabelaUsuario.addColumn("Senha");
						tabelaUsuario.addColumn("Perfil");
						tabelaUsuario.addColumn("Informa��o");

						while (rs.next()) {
							int id = rs.getInt("id");
							String nome = rs.getString("nome");
							String cpf = rs.getString("cpf");
							String titulo = rs.getString("titulo");
							String email = rs.getString("email");
							String senha = rs.getString("senha");
							String perfil = rs.getString("perfil");
							String candidatoElietor = rs.getString("candidatoElietor");

							Object[] rowData = { id, nome, cpf, titulo, email, senha, perfil, candidatoElietor };
							tabelaUsuario.addRow(rowData);
						}
					} else if (itemSelecionadoCombox.equals("Candidato")) {

						st = conn.createStatement();

						rs = st.executeQuery(
								"SELECT p.*, c.partido, c.numeroPartido, c.numeroCandidato, c.foto, e.tipo "
										+ "FROM pessoa p INNER JOIN candidato c ON p.id = c.pessoa_id "
										+ "INNER JOIN eleicao_candidato ec ON c.id = ec.candidato_id "
										+ "INNER JOIN eleicao e ON ec.eleicao_id = e.id");

						DefaultTableModel tabelaCandidato = (DefaultTableModel) tableAdmin.getModel();
						tabelaCandidato.setColumnCount(0);
						tabelaCandidato.addColumn("Id");
						tabelaCandidato.addColumn("Nome");
						tabelaCandidato.addColumn("Cpf");
						tabelaCandidato.addColumn("Titulo");
						tabelaCandidato.addColumn("Email");
						tabelaCandidato.addColumn("Senha");
						tabelaCandidato.addColumn("Perfil");
						tabelaCandidato.addColumn("Informa��o");
						tabelaCandidato.addColumn("Partido");
						tabelaCandidato.addColumn("N�mero do Partido");
						tabelaCandidato.addColumn("N�mero do Candidato");
						tabelaCandidato.addColumn("Elei��o");
						tabelaCandidato.addColumn("Foto");

						while (rs.next()) {
							int id = rs.getInt("id");
							String nome = rs.getString("nome");
							String cpf = rs.getString("cpf");
							String titulo = rs.getString("titulo");
							String email = rs.getString("email");
							String senha = rs.getString("senha");
							String perfil = rs.getString("perfil");
							String candidatoElietor = rs.getString("candidatoElietor");
							String partido = rs.getString("partido");
							String numeroPartido = rs.getString("numeroPartido");
							String numeroCandidato = rs.getString("numeroCandidato");
							String foto = rs.getString("foto");
							String eleicao = rs.getString("tipo");

							Object[] rowData = { id, nome, cpf, titulo, email, senha, perfil, candidatoElietor, partido,
									numeroPartido, numeroCandidato, eleicao, foto };
							tabelaCandidato.addRow(rowData);

						}

					} else if (itemSelecionadoCombox.equals("Elei��o")) {
						st = conn.createStatement();

						rs = st.executeQuery("SELECT * FROM eleicao");

						DefaultTableModel tabelaEleicao = (DefaultTableModel) tableAdmin.getModel();
						tabelaEleicao.setColumnCount(0);
						tabelaEleicao.addColumn("Id");
						tabelaEleicao.addColumn("Nome");
						tabelaEleicao.addColumn("tipo");
						tabelaEleicao.addColumn("Data de inicio");
						tabelaEleicao.addColumn("Data de termino");

						while (rs.next()) {
							int id = rs.getInt("id");
							String nome = rs.getString("nome");
							String tipo = rs.getString("tipo");
							String dataInicio = rs.getString("dataInicio");
							String dataFinal = rs.getString("dataFinal");

							Object[] rowData = { id, nome, tipo, dataInicio, dataFinal };
							tabelaEleicao.addRow(rowData);

						}
					}

					else if (itemSelecionadoCombox.equals("Endere�o")) {
						st = conn.createStatement();

						rs = st.executeQuery("SELECT endereco.*, pessoa.nome, pessoa.cpf " + "FROM endereco "
								+ "INNER JOIN pessoa ON endereco.pessoa_id = pessoa.id");

						DefaultTableModel tabelaEndereco = (DefaultTableModel) tableAdmin.getModel();
						tabelaEndereco.setColumnCount(0);
						tabelaEndereco.addColumn("Id");
						tabelaEndereco.addColumn("Cidade");
						tabelaEndereco.addColumn("Cep");
						tabelaEndereco.addColumn("Bairro");
						tabelaEndereco.addColumn("Numero");
						tabelaEndereco.addColumn("Logradouro");
						tabelaEndereco.addColumn("Estado");
						tabelaEndereco.addColumn("Propietario");
						tabelaEndereco.addColumn("Cpf");

						while (rs.next()) {
							int id = rs.getInt("id");
							String cidade = rs.getString("cidade");
							String cep = rs.getString("cep");
							String bairro = rs.getString("bairro");
							String numero = rs.getString("numero");
							String logradouro = rs.getString("logradouro");
							String estado = rs.getString("estado");
							String nome = rs.getString("nome");
							String cpf = rs.getString("cpf");

							Object[] rowData = { id, cidade, cep, bairro, numero, logradouro, estado, nome, cpf };
							tabelaEndereco.addRow(rowData);
						}
					}

					else if (itemSelecionadoCombox.equals("Chapa")) {
						st = conn.createStatement();

						rs = st.executeQuery("SELECT * FROM chapa");

						DefaultTableModel tabelaChapa = (DefaultTableModel) tableAdmin.getModel();
						tabelaChapa.setColumnCount(0);
						tabelaChapa.addColumn("Id");
						tabelaChapa.addColumn("Nome");
						tabelaChapa.addColumn("Descri��o");

						while (rs.next()) {
							int id = rs.getInt("id");
							String nome = rs.getString("nome");
							String descricao = rs.getString("descricao");

							Object[] rowData = { id, nome, descricao };
							tabelaChapa.addRow(rowData);

						}
					}

				} catch (SQLException ex) {
					ex.printStackTrace();
				}

			}
		});
		panelAtualizar.add(btnListar);

		comboBoxCrudSelect.setModel(new DefaultComboBoxModel(
				new String[] { "Usuario", "Candidato", "Elei\u00E7\u00E3o", "Endere\u00E7o", "Chapa" }));
		panelAtualizar.add(comboBoxCrudSelect);

		JComboBox comboBoxCrudPerfil = new JComboBox();
		comboBoxCrudPerfil.setModel(new DefaultComboBoxModel(new String[] { "comun", "admin" }));
		comboBoxCrudPerfil.setBounds(303, 124, 213, 29);
		panelCrudUsuario.add(comboBoxCrudPerfil);

		JComboBox comboBoxCrudInfo = new JComboBox();
		comboBoxCrudInfo.setModel(new DefaultComboBoxModel(new String[] { "Eleitor", "Candidato" }));
		comboBoxCrudInfo.setBounds(11, 174, 213, 29);
		panelCrudUsuario.add(comboBoxCrudInfo);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setIcon(new ImageIcon(Cadastrro.class.getResource("/view/images/update.png")));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Connection conn = null;
				PreparedStatement st = null;
				ResultSet rs = null;

				String selectComboBoxCrudInfo = comboBoxCrudInfo.getSelectedItem().toString();
				String selectComboBoxCrudPerfil = comboBoxCrudPerfil.getSelectedItem().toString();
				String itemSelecionadoCombox = comboBoxCrudSelect.getSelectedItem().toString();

				String ComboBoxCandidato = comboBoxInfoCandidatoCrud.getSelectedItem().toString();
				String comboBoxCrudPerfilCandidato = comboBoxCrudPerfilCandidatoCrud.getSelectedItem().toString();

				DefaultTableModel tabela = (DefaultTableModel) tableAdmin.getModel();

				conn = DB.getConnection();

				int row = tableAdmin.getSelectedRow();
				if (row == -1) {
					JOptionPane.showMessageDialog(null, "Selecione um registro para atualizar!");
					return;
				}
				int id = Integer.parseInt(tabela.getValueAt(row, 0).toString());

				if (itemSelecionadoCombox.equals("Usuario")) {
					try {

						if (textCrudFieldCpf.getText().isEmpty() || textCrudFieldEmail.getText().isEmpty()
								|| textCrudFieldName.getText().isEmpty() || textCrudFieldSenha.getText().isEmpty()
								|| textCrudFieldTitulo.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
						} else {

							st = conn.prepareStatement("UPDATE pessoa SET nome = ?, cpf = ?, titulo = ?, email = ?, "
									+ "senha = ?, perfil = ?, candidatoElietor = ?  WHERE id = ?");

							st.setString(1, textCrudFieldName.getText());
							st.setString(2, textCrudFieldCpf.getText());
							st.setString(3, textCrudFieldTitulo.getText());
							st.setString(4, textCrudFieldEmail.getText());
							st.setString(5, textCrudFieldSenha.getText());
							st.setString(6, selectComboBoxCrudPerfil);
							st.setString(7, selectComboBoxCrudInfo);
							st.setInt(8, id);

							st.executeUpdate();

							tabela.setValueAt(textCrudFieldName.getText(), row, 1);
							tabela.setValueAt(textCrudFieldCpf.getText(), row, 2);
							tabela.setValueAt(textCrudFieldTitulo.getText(), row, 3);
							tabela.setValueAt(textCrudFieldEmail.getText(), row, 4);
							tabela.setValueAt(textCrudFieldSenha.getText(), row, 5);
							tabela.setValueAt(selectComboBoxCrudPerfil, row, 6);
							tabela.setValueAt(ComboBoxCandidato, row, 7);

							JOptionPane.showMessageDialog(null, "Dados atualizado com sucesso!");

							textCrudFieldName.setText("");
							textCrudFieldCpf.setText("");
							textCrudFieldTitulo.setText("");
							textCrudFieldEmail.setText("");
							textCrudFieldSenha.setText("");

							textCrudFieldName.requestFocus();

						}
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				}

				else if (itemSelecionadoCombox.equals("Candidato")) {
					try {
						if (textNomeCandidatoCrud.getText().isEmpty() || textCpfCandidatoCrud.getText().isEmpty()
								|| textTituloCandidatoCrud.getText().isEmpty()
								|| textEmailCandidatoCrud.getText().isEmpty()
								|| textSenhaCandidatoCrud.getText().isEmpty()
								|| textNomePartidoCandidatoCrud.getText().isEmpty()
								|| textNumeroPartidoCandidatoCrud.getText().isEmpty()
								|| textNumeroCCandidatoCrud.getText().isEmpty()
								|| textFotoCandidatoCrud.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Preencha todos os campos!");

						} else {

							conn.setAutoCommit(false);

							// Atualizar tabela pessoa
							st = conn.prepareStatement(
									"UPDATE pessoa SET nome = ?, cpf = ?, titulo = ?, email = ?, senha = ?, perfil = ?, candidatoElietor = ? WHERE id = ?");
							st.setString(1, textNomeCandidatoCrud.getText());
							st.setString(2, textCpfCandidatoCrud.getText());
							st.setString(3, textTituloCandidatoCrud.getText());
							st.setString(4, textEmailCandidatoCrud.getText());
							st.setString(5, textSenhaCandidatoCrud.getText());
							st.setString(6, comboBoxCrudPerfilCandidato);
							st.setString(7, ComboBoxCandidato);
							st.setInt(8, id);
							st.executeUpdate();

							st = conn.prepareStatement(
									"UPDATE candidato SET partido = ?, numeroPartido = ?, numeroCandidato = ?, foto = ? WHERE id = ?");
							st.setString(1, textNomePartidoCandidatoCrud.getText());
							st.setInt(2, Integer.parseInt(textNumeroPartidoCandidatoCrud.getText()));
							st.setInt(3, Integer.parseInt(textNumeroCCandidatoCrud.getText()));
							st.setString(4, textFotoCandidatoCrud.getText());
							st.setInt(5, id);
							st.executeUpdate();

							tabela.setValueAt(textNomeCandidatoCrud.getText(), row, 1);
							tabela.setValueAt(textCpfCandidatoCrud.getText(), row, 2);
							tabela.setValueAt(textTituloCandidatoCrud.getText(), row, 3);
							tabela.setValueAt(textEmailCandidatoCrud.getText(), row, 4);
							tabela.setValueAt(textSenhaCandidatoCrud.getText(), row, 5);
							tabela.setValueAt(comboBoxCrudPerfilCandidato, row, 6);
							tabela.setValueAt(ComboBoxCandidato, row, 7);
							tabela.setValueAt(textNomePartidoCandidatoCrud.getText(), row, 9);
							tabela.setValueAt(textNumeroPartidoCandidatoCrud.getText(), row, 10);
							tabela.setValueAt(textNumeroCCandidatoCrud.getText(), row, 11);
							tabela.setValueAt(textFotoCandidatoCrud.getText(), row, 12);

							conn.commit();
							JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!");

							textNomeCandidatoCrud.setText("");
							textCpfCandidatoCrud.setText("");
							textTituloCandidatoCrud.setText("");
							textEmailCandidatoCrud.setText("");
							textSenhaCandidatoCrud.setText("");
							textNomePartidoCandidatoCrud.setText("");
							textNumeroPartidoCandidatoCrud.setText("");
							textNumeroCCandidatoCrud.setText("");
							textNumeroCCandidatoCrud.setText("");
							textFotoCandidatoCrud.setText("");

							textNomeCandidatoCrud.requestFocus();
						}
					} catch (SQLException ex) {
						ex.printStackTrace();
					}

				} else if (itemSelecionadoCombox.equals("Elei��o")) {
					try {
						if (textFieldCrudNomeEleicao.getText().isEmpty()
								|| textFieldFieldTipoEleicao.getText().isEmpty()
								|| txtDataInicioCrudEleicao.getText().isEmpty()
								|| txtDataFinalCrudEleicao.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
						} else {
							String dataDeInicio = txtDataInicioCrudEleicao.getText();
							String dataDeTermino = txtDataFinalCrudEleicao.getText();

							SimpleDateFormat parseDate = new SimpleDateFormat("dd/MM/yyyy");
							Date dataInicio = parseDate.parse(dataDeInicio);
							Date dataAtual = new Date();
							Date dataFinal = parseDate.parse(dataDeTermino);

							Calendar calendar = Calendar.getInstance();
							calendar.add(Calendar.DATE, -1); // Subtrai 1 dia da data atual
							Date dataAnterior = calendar.getTime();

							if (dataInicio.before(dataAnterior) || dataInicio.after(dataFinal)
									|| dataFinal.before(dataAtual)) {
								JOptionPane.showMessageDialog(null, "As datas informadas s�o inv�lidas.");
							} else {
								st = conn.prepareStatement(
										"UPDATE eleicao SET nome = ?, tipo = ?, dataInicio = ?, dataFinal = ? WHERE id = ?");

								st.setString(1, textFieldCrudNomeEleicao.getText());
								st.setString(2, textFieldFieldTipoEleicao.getText());
								st.setDate(3, new java.sql.Date(dataInicio.getTime()));
								st.setDate(4, new java.sql.Date(dataFinal.getTime()));
								st.setInt(5, id);

								st.executeUpdate();

								tabela.setValueAt(textFieldCrudNomeEleicao.getText(), row, 1);
								tabela.setValueAt(textFieldFieldTipoEleicao.getText(), row, 2);
								tabela.setValueAt(txtDataInicioCrudEleicao.getText(), row, 3);
								tabela.setValueAt(txtDataFinalCrudEleicao.getText(), row, 4);

								JOptionPane.showMessageDialog(null, "Dados atualizado com sucesso!");

								textFieldCrudNomeEleicao.setText("");
								textFieldFieldTipoEleicao.setText("");
								txtDataInicioCrudEleicao.setText("");
								txtDataFinalCrudEleicao.setText("");

								textFieldCrudNomeEleicao.requestFocus();
							}
						}
					} catch (SQLException ex) {
						ex.printStackTrace();
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
				}

				else if (itemSelecionadoCombox.equals("Endere�o")) {
					try {
						if (textFieldCidadeCrud.getText().isEmpty() || textFieldCepCrud.getText().isEmpty()
								|| textFieldBairroCrud.getText().isEmpty()
								|| textFieldNumeroCasaCrud.getText().isEmpty()
								|| textFieldLogradouroCrud.getText().isEmpty()
								|| textFieldEstadoCrud.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
						} else {

							st = conn.prepareStatement(
									"UPDATE endereco SET cidade = ?, cep = ?, bairro = ?, numero = ?, logradouro = ?, estado = ?  WHERE id = ?");

							st.setString(1, textFieldCidadeCrud.getText());
							st.setString(2, textFieldCepCrud.getText());
							st.setString(3, textFieldBairroCrud.getText());
							st.setString(4, textFieldNumeroCasaCrud.getText());
							st.setString(5, textFieldLogradouroCrud.getText());
							st.setString(6, textFieldEstadoCrud.getText());
							st.setInt(7, id);

							st.executeUpdate();

							tabela.setValueAt(textFieldCidadeCrud.getText(), row, 1);
							tabela.setValueAt(textFieldCepCrud.getText(), row, 2);
							tabela.setValueAt(textFieldBairroCrud.getText(), row, 3);
							tabela.setValueAt(textFieldNumeroCasaCrud.getText(), row, 4);
							tabela.setValueAt(textFieldLogradouroCrud.getText(), row, 5);
							tabela.setValueAt(textFieldEstadoCrud.getText(), row, 6);

							JOptionPane.showMessageDialog(null, "Dados atualizado com sucesso!");

							textFieldCidadeCrud.setText("");
							textFieldCepCrud.setText("");
							textFieldBairroCrud.setText("");
							textFieldNumeroCasaCrud.setText("");
							textFieldLogradouroCrud.setText("");
							textFieldEstadoCrud.setText("");

							textFieldCidadeCrud.requestFocus();
						}
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				}

				else if (itemSelecionadoCombox.equals("Chapa")) {
					try {
						if (textFieldNomeChapaCrud.getText().isEmpty() || textAreaChapaCrud.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
						} else {

							st = conn.prepareStatement("UPDATE chapa SET nome = ?, descricao = ? WHERE id = ?");

							st.setString(1, textFieldNomeChapaCrud.getText());
							st.setString(2, textAreaChapaCrud.getText());
							st.setInt(3, id);

							st.executeUpdate();

							tabela.setValueAt(textFieldNomeChapaCrud.getText(), row, 1);
							tabela.setValueAt(textAreaChapaCrud.getText(), row, 2);

							JOptionPane.showMessageDialog(null, "Dados atualizado com sucesso!");

							textFieldNomeChapaCrud.setText("");
							textAreaChapaCrud.setText("");

							textFieldNomeChapaCrud.requestFocus();
						}
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				}

			}
		});
		btnAtualizar.setBounds(10, 304, 117, 38);
		btnAtualizar.setToolTipText("Atualizar");
		panelAtualizar.add(btnAtualizar);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(Cadastrro.class.getResource("/view/images/atualizar.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCadastro.setVisible(false);
				panelEleicaoo.setVisible(false);
				panelAtualizar.setVisible(true);
			}
		});
		btnNewButton_1.setToolTipText("ATUALIZAR USUARIO");

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEleicaoo.setVisible(false);
				panelAtualizar.setVisible(false);
				panelCadastro.setVisible(true);

				try {
					Connection conn = null;
					Statement st = null;
					ResultSet rs = null;

					conn = DB.getConnection();

					st = conn.createStatement();
					rs = st.executeQuery("select id, tipo from eleicao WHERE dataFinal >= DATE(NOW()) ");

					comboBoxEleicao.removeAllItems();
					while (rs.next()) {
						String nomeEleicao = rs.getString("tipo");
						comboBoxEleicao.addItem(nomeEleicao);
					}

				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_2.setToolTipText("CADASTRAR NOVO USUARIO");
		btnNewButton_2.setIcon(new ImageIcon(Cadastrro.class.getResource("/view/images/forma.png")));

		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCadastro.setVisible(false);
				panelAtualizar.setVisible(false);
				panelEleicaoo.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		btnNewButton_3.setToolTipText("CRIAR ELEI��O");
		btnNewButton_3.setIcon(new ImageIcon(Cadastrro.class.getResource("/view/images/eleicao.png")));

		JLabel lblNewLabel_19 = new JLabel("Menu");
		lblNewLabel_19.setForeground(new Color(51, 0, 153));
		lblNewLabel_19.setFont(new Font("Tahoma", Font.BOLD, 17));

		JButton btnSair = new JButton("Sair");
		btnSair.setToolTipText("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setIcon(new ImageIcon(Cadastrro.class.getResource("/view/images/sair.png")));
		btnSair.setForeground(Color.BLACK);
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap(69, Short.MAX_VALUE)
						.addComponent(lblNewLabel_19, GroupLayout.PREFERRED_SIZE, 79,
								GroupLayout.PREFERRED_SIZE)
						.addGap(38))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup().addGap(23).addGroup(gl_panel
						.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnSair, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(btnNewButton_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 137,
										Short.MAX_VALUE)))
						.addContainerGap(26, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addComponent(lblNewLabel_19, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE).addGap(11)
				.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE).addGap(148)
				.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(37, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		contentPane.add(panel);
		contentPane.add(panel_3);
	}
}