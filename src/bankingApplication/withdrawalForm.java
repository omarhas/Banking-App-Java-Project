package bankingApplication;

import javax.swing.JPanel;

import bankingApplication.agent.Agent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import bankingApplication.client.Client;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class withdrawalForm extends JPanel {
	private JTextField amountField;
	private JTextField emailField;

	/**
	 * Create the panel.
	 */
	public withdrawalForm(Agent agent) {
		setLayout(null);
		setBounds(100, 100, 517, 460);
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 504, 446);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblEmail = new JLabel("Amount :");
		lblEmail.setFont(new Font("Courier New", Font.BOLD, 17));
		lblEmail.setBounds(10, 183, 146, 13);
		panel.add(lblEmail);
		
		amountField = new JTextField();
		amountField.setFont(new Font("Courier New", Font.PLAIN, 12));
		amountField.setColumns(10);
		amountField.setBounds(158, 177, 212, 22);
		panel.add(amountField);
		
		JButton btnNewButton = new JButton("Withdraw");
		btnNewButton.setFont(new Font("Courier New", Font.PLAIN, 15));
		btnNewButton.setBounds(224, 221, 146, 29);
		panel.add(btnNewButton);
		
		emailField = new JTextField();
		emailField.setFont(new Font("Courier New", Font.PLAIN, 12));
		emailField.setColumns(10);
		emailField.setBounds(158, 132, 212, 22);
		panel.add(emailField);
		
		JLabel lblClientId = new JLabel("Client Email :");
		lblClientId.setFont(new Font("Courier New", Font.BOLD, 17));
		lblClientId.setBounds(10, 138, 146, 13);
		panel.add(lblClientId);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					agent.makeWithdrawal(emailField.getText(),  Integer. valueOf(amountField.getText()));
		            emailField.setText("");
		            amountField.setText("");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
