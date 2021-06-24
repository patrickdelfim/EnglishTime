package view;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class MainScreen {

	private JFrame frame;
	private JPanel currentScreen;
	private LoginView telaLogin;
	private PanelMenuView telaMenu;
	private CadAlunoView cadAluno;
	private CadProfView cadprof;
	private CadNotasView cadnotas;
	private ListAltNotas listAltNotas;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public MainScreen() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		currentScreen = new JPanel();
		frame.setBounds(0, 0, 1198, 768);
		currentScreen.setBounds(0, 0, 1198, 768);
		frame.getContentPane().add(currentScreen);
		currentScreen.setLayout(null);
		
		
		telaLogin = new LoginView();
		telaMenu = new PanelMenuView();
		cadAluno = new CadAlunoView();
		cadprof = new CadProfView();
		cadnotas = new CadNotasView();
		listAltNotas = new ListAltNotas();
		
		//Botoes Navegacao Tela Login
		
		telaLogin.getBtnEntrar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loginClicked(telaMenu);
			}
		});
		
		
		//Botoes Navegacao MENU
		telaMenu.getCadAlunoPanel().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeScreens(cadAluno);
			}
		});
		
		telaMenu.getCadprofpanel().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeScreens(cadprof);
			}
		});
		
		telaMenu.getCadNotasPanel().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeScreens(cadnotas);
			}
		});
		
		telaMenu.getListAltNotasPanel().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listAltNotas.atualizarTable();
				changeScreens(listAltNotas);
				
			}
		});
		
		
		//Botoes Navegacao CadAluno
		cadAluno.getLblVoltar().addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						changeScreens(telaMenu);
					}
				});
				
		cadAluno.getBtnLogout().addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						changeScreens(telaLogin);
					}
				});
		
				
		//Botoes Navegacao CadProfessor
		cadprof.getLblVoltar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeScreens(telaMenu);
			}
		});
		
		cadprof.getBtnLogout().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeScreens(telaLogin);
			}
		});
		
		//Botoes Navegacao CadNotas
		cadnotas.getLblVoltar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeScreens(telaMenu);
			}
		});
		
		cadnotas.getBtnLogout().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeScreens(telaLogin);
			}
		});
		
		//Botoes Navegacao ListAltNotas
		listAltNotas.getLblVoltar().addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						changeScreens(telaMenu);
					}
				});
				
		listAltNotas.getBtnLogout().addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						changeScreens(telaLogin);
					}
				});
	
		
		
		currentScreen.add(telaLogin);
		currentScreen.add(telaMenu);
		currentScreen.add(cadAluno);
		currentScreen.add(cadprof);
		currentScreen.add(cadnotas);
		currentScreen.add(listAltNotas);
		
		
		changeScreens(telaLogin);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public void changeScreens(JPanel panel) {
		telaLogin.setVisible(false);
		telaMenu.setVisible(false);
		cadAluno.setVisible(false);
		cadprof.setVisible(false);
		cadnotas.setVisible(false);
		listAltNotas.setVisible(false);
		
		panel.setVisible(true);
	};
	
	
	public void loginClicked(JPanel panel) {
		
		String password = new String(telaLogin.getPasswordField().getPassword());
		String login = telaLogin.getLoginField().getText();
		
		if(login.equals("admin") &&  password.equals("admin")) {
			
			changeScreens(telaMenu);
		
		
		telaLogin.resetLoginField();
		telaLogin.resetPasswordField();
		
		} else {
			showMessageDialog(null,
				    "Senha incorreta!!",
				    "Algo deu errado :/",
				    JOptionPane.ERROR_MESSAGE);
			telaLogin.resetLoginField();
			telaLogin.resetPasswordField();
			
		}
	}
	

}
