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

import bo.Aluno;
import bo.Professor;
import controller.AlunoController;
import controller.ProfController;

public class CadProfView extends JPanel{

	
	private Image  img_CadAlunobg = new ImageIcon(LoginView.class.getResource("assets/Layout/login.png")).getImage().getScaledInstance(1198, 768, Image.SCALE_SMOOTH);
	private Image  img_Voltar = new ImageIcon(LoginView.class.getResource("assets/Layout/Botao/back-arrow.png")).getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);

	private JTextField MatriculaInput;
	private JTextField NomeInput;

	private JLabel lblVoltar = new JLabel("");
	private JButton btnLogout = new JButton("Logout");
	
	
	public JLabel getLblVoltar() {
		return lblVoltar;
	}







	public JButton getBtnLogout() {
		return btnLogout;
	}







	public CadProfView() {
	
		setBounds(0, 0, 1198, 747);
		setVisible(true);
		setLayout(null);
		
		
		lblVoltar.setBounds(25, 22, 38, 42);
		lblVoltar.setIcon(new ImageIcon(img_Voltar));
		add(lblVoltar);
		
		JLabel lblNewLabel = new JLabel("Cadastrar Professor");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 194, 1198, 61);
		add(lblNewLabel);
		
		JLabel lblFeedBack = new JLabel("Cod.Prof eh um campo obrigatorio");
		lblFeedBack.setForeground(Color.RED);
		lblFeedBack.setHorizontalAlignment(SwingConstants.CENTER);
		lblFeedBack.setBounds(484, 492, 352, 16);
		add(lblFeedBack);
		
		MatriculaInput = new JTextField();
		MatriculaInput.setToolTipText("Numero de matricula");
		MatriculaInput.setBounds(561, 313, 200, 35);
		add(MatriculaInput);
		MatriculaInput.setColumns(10);
		
		JLabel CodLabel = new JLabel("Cod. Professor* :");
		CodLabel.setBounds(419, 313, 130, 35);
		add(CodLabel);
		
		NomeInput = new JTextField();
		NomeInput.setToolTipText("Nome");
		NomeInput.setColumns(10);
		NomeInput.setBounds(561, 393, 200, 35);
		add(NomeInput);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(470, 393, 79, 35);
		add(lblNome);
		
		JButton btnEnviarForm = new JButton("Enviar");
		btnEnviarForm.setBounds(541, 568, 117, 35);
		add(btnEnviarForm);
		
btnEnviarForm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				if(!MatriculaInput.getText().isBlank()) {
					
					
					lblFeedBack.setVisible(true);
					
					
					Professor prof = new Professor();
					
					
					prof.setCodProf(MatriculaInput.getText());
					prof.setNome(NomeInput.getText());
					
					ProfController controller = new ProfController();
					controller.create(prof);
					
					
					
				
				lblFeedBack.setForeground(Color.black);
				lblFeedBack.setText("Formulario enviado com sucesso...");
				lblFeedBack.setVisible(true);
				
				}else {
					lblFeedBack.setText("Cod. Prof eh um campo obrigatorio");
					
					lblFeedBack.setForeground(Color.RED);
					lblFeedBack.setVisible(true);
					
				}
				
				MatriculaInput.setText("");
				NomeInput.setText("");
				
				
			}
			
		});
		
lblFeedBack.setVisible(false);
			
		btnLogout.setBounds(1075, 22, 117, 35);
		add(btnLogout);
		
		JLabel lblimgLogin = new JLabel("");
		lblimgLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblimgLogin.setBounds(0, 0, 1198, 744);
		lblimgLogin.setIcon(new ImageIcon(img_CadAlunobg));
		add(lblimgLogin);
	
		
		
	
	}	
}