package bankingApplication.clientDash;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bankingApplication.client.Client;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class editprofile extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editprofile frame = new editprofile();
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
	public editprofile(Client client) {
		setTitle("Edit profile");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit profile : ");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(223, 21, 111, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("Password : ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(247, 71, 87, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Change");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client.changePassword(passwordField.getText());
				
			}
		});
		btnNewButton.setForeground(SystemColor.window);
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setBounds(277, 347, 101, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.setForeground(SystemColor.window);
		btnNewButton_1.setBackground(SystemColor.textHighlight);
		btnNewButton_1.setBounds(10, 56, 157, 23);
		contentPane.add(btnNewButton_1);
        btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				home ho= new home(client);
				ho.setVisible(true);
				dispose();
				
				
			}
			
		});
		
		JButton btnNewButton_2 = new JButton("Transfert");
		btnNewButton_2.setForeground(SystemColor.window);
		btnNewButton_2.setBackground(SystemColor.textHighlight);
		btnNewButton_2.setBounds(10, 89, 157, 23);
		contentPane.add(btnNewButton_2);
        btnNewButton_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				transfert trans= new transfert(client);
				trans.setVisible(true);
				dispose();
				
				
			}
			
		});
		
		JButton btnNewButton_3 = new JButton("Amount");
		btnNewButton_3.setForeground(SystemColor.window);
		btnNewButton_3.setBackground(SystemColor.textHighlight);
		btnNewButton_3.setBounds(10, 123, 157, 23);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				amount amou= new amount(client);
				amou.setVisible(true);
				dispose();
				
			}
			
		});
		JButton btnNewButton_4 = new JButton("Edit profile");
		btnNewButton_4.setBackground(SystemColor.textHighlight);
		btnNewButton_4.setForeground(SystemColor.window);
		btnNewButton_4.setBounds(10, 157, 157, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Reclamation");
		btnNewButton_5.setBackground(SystemColor.textHighlight);
		btnNewButton_5.setForeground(SystemColor.window);
		btnNewButton_5.setBounds(10, 191, 157, 23);
		contentPane.add(btnNewButton_5);
        btnNewButton_5.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				reclamation rec= new reclamation(client);
				rec.setVisible(true);
				dispose();
				
			}
       });
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 183, 393);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JButton btnNewButton_8 = new JButton("Logout");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login loginPage = new Login();
				loginPage.setVisible(true);
				dispose();
			}
		});
		btnNewButton_8.setBounds(10, 228, 157, 23);
		panel.add(btnNewButton_8);
		btnNewButton_8.setBackground(SystemColor.textHighlight);
		btnNewButton_8.setForeground(SystemColor.window);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(322, 70, 151, 19);
		contentPane.add(passwordField);
	}
}
