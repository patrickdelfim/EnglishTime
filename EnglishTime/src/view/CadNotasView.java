package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import bo.Nota;
import controller.NotaController;

public class CadNotasView extends JPanel{

	
	private Image  img_CadAlunobg = new ImageIcon(LoginView.class.getResource("assets/Layout/login.png")).getImage().getScaledInstance(1198, 768, Image.SCALE_SMOOTH);
	private Image  img_Voltar = new ImageIcon(LoginView.class.getResource("assets/Layout/Botao/back-arrow.png")).getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);

	private JTextField CodProvaInput;

	private	JLabel lblVoltar = new JLabel("");
	private JButton btnLogout = new JButton("Logout");
	private JTextField MatriculaInput;
	private JTextField NotaInput;
	
	public JLabel getLblVoltar() {
		return lblVoltar;
	}




	public JButton getBtnLogout() {
		return btnLogout;
	}




	

	

	
	public CadNotasView() {
	
		setBounds(0, 0, 1198, 747);
		setVisible(true);
		setLayout(null);
		
		
		lblVoltar.setBounds(25, 22, 38, 42);
		lblVoltar.setIcon(new ImageIcon(img_Voltar));
		add(lblVoltar);
		
		JLabel lblNewLabel = new JLabel("Cadastrar Notas");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 194, 1198, 61);
		add(lblNewLabel);
		
		
		CodProvaInput = new JTextField();
		CodProvaInput.setToolTipText("Numero de matricula");
		CodProvaInput.setBounds(564, 267, 200, 35);
		add(CodProvaInput);
		CodProvaInput.setColumns(10);
		
		JLabel MatriculaLabel = new JLabel("Cod. Prova* :");
		MatriculaLabel.setBounds(441, 267, 111, 35);
		add(MatriculaLabel);
		
		JLabel lblFeedBack = new JLabel("Cod.Prova eh um campo obrigatorio");
		lblFeedBack.setForeground(Color.RED);
		lblFeedBack.setHorizontalAlignment(SwingConstants.CENTER);
		lblFeedBack.setBounds(484, 492, 352, 16);
		add(lblFeedBack);
		
		MatriculaInput = new JTextField();
		MatriculaInput.setToolTipText("Nome");
		MatriculaInput.setColumns(10);
		MatriculaInput.setBounds(564, 314, 200, 35);
		add(MatriculaInput);
		
		JLabel lblMatricula = new JLabel("Matricula :");
		lblMatricula.setBounds(473, 314, 79, 35);
		add(lblMatricula);
		
		NotaInput = new JTextField();
		NotaInput.setToolTipText("Nome");
		NotaInput.setColumns(10);
		NotaInput.setBounds(564, 365, 200, 35);
		add(NotaInput);
		
		JLabel lblNota = new JLabel("Nota :");
		lblNota.setBounds(473, 365, 79, 35);
		add(lblNota);
		
		JButton btnEnviarForm = new JButton("Enviar");
		btnEnviarForm.setBounds(541, 568, 117, 35);
		add(btnEnviarForm);
		
		btnLogout.setBounds(1075, 22, 117, 35);
		add(btnLogout);
		
		
		
btnEnviarForm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				if(!CodProvaInput.getText().isBlank()) {
					
					
					lblFeedBack.setVisible(true);
					
					
					Nota nota = new Nota();
					
					
					nota.setCodProva(CodProvaInput.getText());
					nota.setMatricula(MatriculaInput.getText());
					nota.setNota(NotaInput.getText());
					
					
					NotaController controller = new NotaController();
					controller.create(nota);
					
					
					
				
				lblFeedBack.setForeground(Color.black);
				lblFeedBack.setText("Formulario enviado com sucesso...");
				lblFeedBack.setVisible(true);
				
				}else {
					lblFeedBack.setText("Cod. Prova eh um campo obrigatorio");
					
					lblFeedBack.setForeground(Color.RED);
					lblFeedBack.setVisible(true);
					
				}
				
				CodProvaInput.setText("");
				MatriculaInput.setText("");
				NotaInput.setText("");
				
			}
			
		});
		
lblFeedBack.setVisible(false);

		
		
		JLabel lblimgLogin = new JLabel("");
		lblimgLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblimgLogin.setBounds(0, 0, 1198, 744);
		lblimgLogin.setIcon(new ImageIcon(img_CadAlunobg));
		add(lblimgLogin);
		
		
	
		
		
	
	}	
}