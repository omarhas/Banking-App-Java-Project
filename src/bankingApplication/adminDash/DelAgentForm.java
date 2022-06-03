package bankingApplication.adminDash;

import javax.swing.JPanel;

import bankingApplication.agent.Admin;
import bankingApplication.agent.Agent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DelAgentForm extends JPanel {
	private JTextField idField;

	/**
	 * Create the panel.
	 */
	public DelAgentForm(Admin admin) {
		setLayout(null);
		setBounds(100, 100, 517, 460);
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 504, 446);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Agent Id : ");
		lblNewLabel.setFont(new Font("Courier New", Font.BOLD, 17));
		lblNewLabel.setBounds(10, 132, 135, 13);
		panel.add(lblNewLabel);
		
		idField = new JTextField();
		idField.setFont(new Font("Courier New", Font.BOLD, 20));
		idField.setBounds(144, 126, 212, 22);
		panel.add(idField);
		idField.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete Agent");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Agent selectedOne = admin.getAgent(Integer.parseInt(idField.getText()));
					admin.removeAgent(selectedOne);
		            JOptionPane.showMessageDialog(null, "Agent " + selectedOne.getPrenom() + " " + selectedOne.getNom() + " has been fired.");

		            idField.setText("");        
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Courier New", Font.PLAIN, 15));
		btnNewButton.setBounds(209, 172, 147, 29);
		panel.add(btnNewButton);
	}
}
