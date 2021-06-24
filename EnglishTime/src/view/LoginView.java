package view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class LoginView  extends JPanel{

	
	private Image  img_login = new ImageIcon(LoginView.class.getResource("assets/Layout/login.png")).getImage().getScaledInstance(1198, 768, Image.SCALE_SMOOTH);
	private JTextField LoginField;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;
	private JLabel lblSenha;
	private JLabel btnEntrarText;
	private JPanel btnEntrar = new JPanel();


	
	

	
	public LoginView() {
	
		
		setBounds(0, 0, 1198, 768);
		setVisible(true);
		setLayout(null);
		
		
		lblNewLabel = new JLabel("Login:");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		lblNewLabel.setBounds(379, 337, 85, 46);
		add(lblNewLabel);
		
		lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		lblSenha.setBounds(379, 409, 85, 46);
		add(lblSenha);
		
		
		btnEntrar.setBackground(UIManager.getColor("Button.background"));
		btnEntrar.setBounds(546, 538, 117, 29);
		add(btnEntrar);
		btnEntrar.setLayout(null);
		
		btnEntrarText = new JLabel("Entrar");
		btnEntrarText.setHorizontalAlignment(SwingConstants.CENTER);
		btnEntrarText.setBounds(6, 0, 105, 29);
		btnEntrar.add(btnEntrarText);
		
		LoginField = new JTextField();
		LoginField.setBounds(476, 337, 266, 46);
		add(LoginField);
		LoginField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(476, 409, 266, 46);
		add(passwordField);
		
		
		JLabel lblimgLogin = new JLabel("");
		lblimgLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblimgLogin.setBounds(0, 0, 1198, 744);
		lblimgLogin.setIcon(new ImageIcon(img_login));
		add(lblimgLogin);
		
		
	
	}
	
	
	
	
	public JTextField getLoginField() {
		return LoginField;
	}


	public void resetLoginField() {
		LoginField.setText("");
	}


	public JPasswordField getPasswordField() {
		return passwordField;
	}


	public void resetPasswordField() {
		passwordField.setText("");
	}


	public JPanel getBtnEntrar() {
		return btnEntrar;
	}

	
	
	
	
	}
	
	
	


