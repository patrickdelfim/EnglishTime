package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import bo.Nota;
import controller.NotaController;

public class ListAltNotas extends JPanel{

	
	private Image  img_CadAlunobg = new ImageIcon(LoginView.class.getResource("assets/Layout/login.png")).getImage().getScaledInstance(1198, 768, Image.SCALE_SMOOTH);
	private Image  img_Voltar = new ImageIcon(LoginView.class.getResource("assets/Layout/Botao/back-arrow.png")).getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);

	private	JLabel lblVoltar = new JLabel("");
	private JButton btnLogout = new JButton("Logout");
	
	DefaultTableModel tableModel = new DefaultTableModel();
	
	private JTextField textFieldCodProva;
	private JTextField textFieldNota;
	
	
	
	public JLabel getLblVoltar() {
		return lblVoltar;
	}




	public JButton getBtnLogout() {
		return btnLogout;
	}




	

	

	
	public ListAltNotas() {
	
		setBounds(0, 0, 1198, 747);
		setVisible(true);
		setLayout(null);
		
		
		lblVoltar.setBounds(25, 22, 38, 42);
		lblVoltar.setIcon(new ImageIcon(img_Voltar));
		add(lblVoltar);
		
		JLabel lblNewLabel = new JLabel("Listar e alterar notas");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 194, 1198, 61);
		add(lblNewLabel);
		
		
		
		
		
		
		
		
Object[] columns = {"CodProva","Matricula","Nota"};
		
		
		
		tableModel.setColumnIdentifiers(columns);
		
		

		
		JTable table = new JTable();
		table.setEnabled(false);
		table.setFillsViewportHeight(true);
		
		table.setBackground(Color.WHITE);
		table.setModel(tableModel);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(200, 250, 677, 181);
		add(scrollPane);
		
		JRadioButton RadioAtualizarProva = new JRadioButton("Atualizar Prova");
		RadioAtualizarProva.setSelected(true);
		RadioAtualizarProva.setBounds(389, 449, 141, 23);
		add(RadioAtualizarProva);
		
		JRadioButton RadioDeletarProva = new JRadioButton("Deletar Prova");
		RadioDeletarProva.setBounds(625, 449, 141, 23);
		add(RadioDeletarProva);
		
		ButtonGroup RadioGrupo = new ButtonGroup();
		
		RadioGrupo.add(RadioAtualizarProva);
		RadioGrupo.add(RadioDeletarProva);
		
		JLabel lblCodProva = new JLabel("Cod Prova*:");
		lblCodProva.setBounds(301, 547, 130, 16);
		add(lblCodProva);
		
		JLabel lblNota = new JLabel("Nova Nota*:");
		lblNota.setBounds(721, 547, 130, 16);
		add(lblNota);
		
		textFieldCodProva = new JTextField();
		textFieldCodProva.setBounds(301, 564, 130, 26);
		add(textFieldCodProva);
		textFieldCodProva.setColumns(10);
		
		textFieldNota = new JTextField();
		textFieldNota.setColumns(10);
		textFieldNota.setBounds(721, 564, 130, 26);
		add(textFieldNota);
		
		JButton btnDone = new JButton("Atualizar");
		btnDone.setBounds(649, 652, 117, 29);
		add(btnDone);
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(451, 652, 117, 29);
		add(btnCancel);
		
		JLabel lblFeedbackMSG = new JLabel(" ");
		lblFeedbackMSG.setHorizontalAlignment(SwingConstants.CENTER);
		lblFeedbackMSG.setBounds(300, 432, 550, 16);
		add(lblFeedbackMSG);
		 lblFeedbackMSG.setVisible(false);
	
		
		
		
		 RadioAtualizarProva.addActionListener(new ActionListener() {
				@Override
			    public void actionPerformed(ActionEvent e) {
					lblCodProva.setVisible(true);
					lblNota.setVisible(true);
					btnDone.setText("Atualizar");
					
					textFieldCodProva.setVisible(true);
					textFieldNota.setVisible(true);
					
			    }
			});
			
		 RadioDeletarProva.addActionListener(new ActionListener() {
				@Override
			    public void actionPerformed(ActionEvent e) {
					lblCodProva.setVisible(true);
					lblNota.setVisible(false);
					btnDone.setText("Deletar");
					
					textFieldCodProva.setVisible(true);
					textFieldNota.setVisible(false);
			    }
			});
		 
		 
		 
		 
		 btnDone.addActionListener(new ActionListener() {
				int feedbackMSG;
				NotaController controller = new NotaController();
				
				@Override
			    public void actionPerformed(ActionEvent e) {
					
					if(RadioDeletarProva.isSelected()) {
						
						 feedbackMSG = controller.delete(textFieldCodProva.getText());
						 
						 if(feedbackMSG == 1) {
						 lblFeedbackMSG.setText("Prova DeletadA com sucesso!!");
						 lblFeedbackMSG.setForeground(Color.black);
						 }
						 else {
							 lblFeedbackMSG.setText("Erro ao deletar Prova. Verifique se Codigo esta correta!");
							 lblFeedbackMSG.setForeground(Color.red);
						 }
						 
						 
						 
						 
					
					}else if(RadioAtualizarProva.isSelected()) {
						
						Nota nota = new Nota();
						nota.setCodProva(textFieldCodProva.getText());
						nota.setMatricula("");
						nota.setNota(textFieldNota.getText());
						feedbackMSG = controller.update(nota);
					
					
					if(feedbackMSG == 1) {
						 lblFeedbackMSG.setText("Prova Atualizado com sucesso!!");
						 lblFeedbackMSG.setForeground(Color.black);
						 }
						 else {
							 lblFeedbackMSG.setText("Erro ao Atualizar Prova. Verifique se Codigo esta correta!");
							 lblFeedbackMSG.setForeground(Color.red);
						 }
					
					}
					
					textFieldNota.setText("");
					textFieldCodProva.setText("");
					
					
					lblFeedbackMSG.setVisible(true);
					atualizarTable();
			    }
			});
		 
		 
		
		btnLogout.setBounds(1075, 22, 117, 35);
		add(btnLogout);
		
		JLabel lblimgLogin = new JLabel("");
		lblimgLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblimgLogin.setBounds(0, 0, 1198, 744);
		lblimgLogin.setIcon(new ImageIcon(img_CadAlunobg));
		add(lblimgLogin);
	
		
		
		
		atualizarTable();
		
	
	}	
	
	
	public void atualizarTable() {
		tableModel.setRowCount(0);
		Object[] row = new Object[3];
		
		NotaController controller = new NotaController();
		
		
		 
		
		for(Nota nota:controller.read()) {
			
			row[0] = nota.getCodProva();
			row[1] = nota.getMatricula();
			row[2] = nota.getNota();
			tableModel.addRow(row);
		}
	}
}
