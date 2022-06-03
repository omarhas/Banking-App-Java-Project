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

public class AddAgentForm extends JPanel {
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField emailField;
	private JPasswordField passwordField;
	private JTextField roleField;

	/**
	 * Create the panel.
	 */
	public AddAgentForm(Admin admin) {
		setLayout(null);
		setBounds(100, 100, 517, 460);
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 504, 446);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First Name : ");
		lblNewLabel.setFont(new Font("Courier New", Font.BOLD, 17));
		lblNewLabel.setBounds(10, 79, 135, 13);
		panel.add(lblNewLabel);
		
		firstNameField = new JTextField();
		firstNameField.setFont(new Font("Courier New", Font.BOLD, 20));
		firstNameField.setBounds(144, 73, 212, 22);
		panel.add(firstNameField);
		firstNameField.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name :");
		lblLastName.setFont(new Font("Courier New", Font.BOLD, 17));
		lblLastName.setBounds(10, 127, 135, 13);
		panel.add(lblLastName);
		
		lastNameField = new JTextField();
		lastNameField.setFont(new Font("Courier New", Font.BOLD, 20));
		lastNameField.setColumns(10);
		lastNameField.setBounds(144, 121, 212, 22);
		panel.add(lastNameField);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Courier New", Font.BOLD, 17));
		lblEmail.setBounds(10, 183, 135, 13);
		panel.add(lblEmail);
		
		emailField = new JTextField();
		emailField.setFont(new Font("Courier New", Font.BOLD, 20));
		emailField.setColumns(10);
		emailField.setBounds(144, 177, 212, 22);
		panel.add(emailField);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Courier New", Font.BOLD, 17));
		lblPassword.setBounds(10, 228, 135, 13);
		panel.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(144, 225, 212, 22);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("Add Agent");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					admin.addNewAgent(firstNameField.getText(), lastNameField.getText(), emailField.getText(), passwordField.getText(), roleField.getText());
		            JOptionPane.showMessageDialog(null, "Agent " + firstNameField.getText() + " " + lastNameField.getText() + " has been added.");
		            firstNameField.setText("");
		            lastNameField.setText("");
		            emailField.setText("");
		            passwordField.setText("");
		            roleField.setText("");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Courier New", Font.PLAIN, 15));
		btnNewButton.setBounds(209, 324, 147, 29);
		panel.add(btnNewButton);
		
		JLabel lblRole = new JLabel("Role : ");
		lblRole.setFont(new Font("Courier New", Font.BOLD, 17));
		lblRole.setBounds(10, 279, 135, 13);
		panel.add(lblRole);
		
		roleField = new JTextField();
		roleField.setFont(new Font("Courier New", Font.BOLD, 20));
		roleField.setColumns(10);
		roleField.setBounds(144, 277, 212, 22);
		panel.add(roleField);
	}
}
