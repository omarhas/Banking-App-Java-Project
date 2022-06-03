package bankingApplication;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import bankingApplication.adminDash.AdminLogin;

import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JTextArea;

public class loginPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginPage window = new loginPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public loginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1062, 484);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setSize(900, 600);
		
		ImageIcon bg = new ImageIcon( "C:\\Users\\khali\\Downloads\\TIC BANK-logo\\default.png" ) ;
		Image img = bg.getImage();
		JButton btnNewButton = new JButton("Admin Login");
		btnNewButton.setBackground(new Color(255, 153, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogin adminLogin = new AdminLogin();
				frame.dispose();
				adminLogin.setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Courier New", Font.BOLD, 20));
		btnNewButton.setBounds(53, 428, 206, 70);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnAgentLogin = new JButton("Agent Login\r\n");
		btnAgentLogin.setForeground(new Color(255, 255, 255));
		btnAgentLogin.setBackground(new Color(255, 153, 51));
		btnAgentLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgentLogin agentL = new AgentLogin();
				frame.dispose();
				agentL.setVisible(true);
			}
		});
		btnAgentLogin.setFont(new Font("Courier New", Font.BOLD, 20));
		btnAgentLogin.setBounds(582, 428, 206, 70);
		frame.getContentPane().add(btnAgentLogin);
		
		JLabel lblNewLabel = new JLabel("kalis w baed ichki");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 153, 51));
		lblNewLabel.setFont(new Font("Courier New", Font.BOLD, 20));
		lblNewLabel.setBounds(567, 310, 233, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\khali\\Downloads\\TIC BANK-logo\\default.png"));
		lblNewLabel_1.setBounds(-73, -68, 970, 631);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
