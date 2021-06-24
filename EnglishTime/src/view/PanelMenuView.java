package view;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Image;

public class PanelMenuView extends JPanel {


	private JPanel CadAlunoPanel = new JPanel();
	private JPanel Cadprofpanel = new JPanel();
	private JPanel CadNotasPanel = new JPanel();
	JPanel ListAltNotasPanel = new JPanel();
	
	
	public JPanel getListAltNotasPanel() {
		return ListAltNotasPanel;
	}
	public JPanel getCadNotasPanel() {
		return CadNotasPanel;
	}
	public JPanel getCadprofpanel() {
		return Cadprofpanel;
	}
	public JPanel getCadAlunoPanel() {
		return CadAlunoPanel;
	}


	private Image  img_TelaInicial = new ImageIcon(PanelMenuView.class.getResource("assets/Layout/tela_inicial.png")).getImage().getScaledInstance(1198, 768, Image.SCALE_SMOOTH);
	
	private Image  img_CadAlunos = new ImageIcon(PanelMenuView.class.getResource("assets/Layout/Botao/Cad_aluno.png")).getImage();
	private Image  img_CadProfessor = new ImageIcon(PanelMenuView.class.getResource("assets/Layout/Botao/Cad_professor.png")).getImage();
	private Image  img_CadNotas = new ImageIcon(PanelMenuView.class.getResource("assets/Layout/Botao/Cad_notas.png")).getImage();
	private Image  img_ListAltNotas = new ImageIcon(PanelMenuView.class.getResource("assets/Layout/Botao/ListAltNotas.png")).getImage();

	
	public PanelMenuView() {
		
		setBounds(0, 0, 1198, 748);
		//setLayout(null);
		setVisible(true);
		setLayout(null);
		
		
		CadAlunoPanel.setBounds(420, 268, 402, 78);
		add(CadAlunoPanel);
		CadAlunoPanel.setLayout(null);
		CadAlunoPanel.setOpaque(false);
		
		JLabel lblimgCadAluno = new JLabel("");
		lblimgCadAluno.setBounds(0, 0, 399, 76);
		lblimgCadAluno.setIcon(new ImageIcon(img_CadAlunos));
		CadAlunoPanel.add(lblimgCadAluno);
		
	
		Cadprofpanel.setBounds(420, 370, 402, 78);
		add(Cadprofpanel);
		Cadprofpanel.setLayout(null);
		Cadprofpanel.setOpaque(false);
		
		JLabel lblCadProf = new JLabel("");
		lblCadProf.setBounds(0, 0, 399, 76);
		lblCadProf.setIcon(new ImageIcon(img_CadProfessor));
		Cadprofpanel.add(lblCadProf);
		
		
		
		CadNotasPanel.setBounds(420, 472, 402, 78);
		CadNotasPanel.setOpaque(false);
		add(CadNotasPanel);
		CadNotasPanel.setLayout(null);
		
		JLabel lblCadNota = new JLabel("");
		lblCadNota.setBounds(0, 0, 399, 76);
		lblCadNota.setIcon(new ImageIcon(img_CadNotas));
		CadNotasPanel.add(lblCadNota);
		
		
		ListAltNotasPanel.setBounds(420, 574, 402, 78);
		ListAltNotasPanel.setOpaque(false);
		add(ListAltNotasPanel);
		ListAltNotasPanel.setLayout(null);
		
		JLabel lblListAltNotas = new JLabel("");
		lblListAltNotas.setBounds(0, 0, 399, 76);
		lblListAltNotas.setIcon(new ImageIcon(img_ListAltNotas));
		ListAltNotasPanel.add(lblListAltNotas);
		
		
		
		
		JLabel lblimgTelaInicial = new JLabel("");
		lblimgTelaInicial.setHorizontalAlignment(SwingConstants.CENTER);
		lblimgTelaInicial.setBounds(0, 0, 1198, 744);
		lblimgTelaInicial.setIcon(new ImageIcon(img_TelaInicial));
		add(lblimgTelaInicial);
		
	}
}
