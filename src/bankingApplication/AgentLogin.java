package bankingApplication;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bankingApplication.agent.Agent;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class AgentLogin extends JFrame {

	private JPanel contentPane;
	private JTextField emailField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgentLogin frame = new AgentLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AgentLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel random = new JLabel("Email :");
		random.setForeground(new Color(255, 153, 51));
		random.setFont(new Font("Courier New", Font.BOLD, 26));
		random.setBounds(80, 340, 149, 112);
		contentPane.add(random);
		
		JLabel random2 = new JLabel("Password :");
		random2.setForeground(new Color(255, 153, 51));
		random2.setFont(new Font("Courier New", Font.BOLD, 26));
		random2.setBounds(80, 416, 221, 112);
		contentPane.add(random2);
		
		emailField = new JTextField();
		emailField.setBounds(277, 385, 302, 30);
		contentPane.add(emailField);
		emailField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Agent agent = new Agent(emailField.getText(), passwordField.getText(), "agent");
					if (agent.getNom() != null) 
				  	{
						contentPane.hide();
						agentDashboard  agentDash = new agentDashboard(agent);
				        agentDash.setVisible(true);
				  	} else {
				  		emailField.setText("");
				  		passwordField.setText("");
				  	}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLogin.setBackground(new Color(255, 153, 51));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("Courier New", Font.BOLD, 26));
		btnLogin.setBounds(623, 451, 155, 42);
		contentPane.add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(277, 461, 302, 30);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\khali\\Downloads\\TIC BANK-logo\\profile.png"));
		lblNewLabel.setBounds(-64, -79, 972, 664);
		contentPane.add(lblNewLabel);
	}

}
