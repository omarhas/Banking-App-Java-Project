package bankingApplication.clientDash;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bankingApplication.client.Client;

import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import java.awt.Font;

public class amount extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					amount frame = new amount();
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
	public amount(Client client) {
		setTitle("Amount");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setForeground(SystemColor.window);
		btnNewButton.setBounds(10, 22, 149, 23);
		contentPane.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				home ho= new home(client);
				ho.setVisible(true);
				dispose();
				
				
			}
			
		});
		
		JButton btnNewButton_1 = new JButton("Transfert");
		btnNewButton_1.setForeground(SystemColor.window);
		btnNewButton_1.setBackground(SystemColor.textHighlight);
		btnNewButton_1.setBounds(10, 56, 149, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				transfert trans= new transfert(client);
				trans.setVisible(true);
				dispose();
				
				
			}
			
		});
		JButton btnNewButton_2 = new JButton("Amount");
		btnNewButton_2.setBackground(SystemColor.textHighlight);
		btnNewButton_2.setForeground(SystemColor.window);
		btnNewButton_2.setBounds(10, 90, 149, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Edit profile");
		btnNewButton_3.setBackground(SystemColor.textHighlight);
		btnNewButton_3.setForeground(SystemColor.window);
		btnNewButton_3.setBounds(10, 124, 149, 23);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					editprofile edit= new editprofile(client);
					edit.setVisible(true);
					dispose();
					
				}
	       });
		
		JButton btnNewButton_4 = new JButton("Reclamation");
		btnNewButton_4.setBackground(SystemColor.textHighlight);
		btnNewButton_4.setForeground(SystemColor.window);
		btnNewButton_4.setBounds(10, 158, 149, 23);
		contentPane.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				reclamation rec= new reclamation(client);
				rec.setVisible(true);
				dispose();
				
			}
       });
		
		JLabel lblNewLabel = new JLabel("Balance : ");
		lblNewLabel.setForeground(SystemColor.window);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(259, 58, 105, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(Integer.toString(client.getBalance()) + " DT");
		lblNewLabel_1.setForeground(SystemColor.window);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(270, 94, 88, 14);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(226, 35, 219, 180);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(0, 0, 182, 338);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_7 = new JButton("Logout");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login loginPage = new Login();
				loginPage.setVisible(true);
				dispose();
			}
		});
		btnNewButton_7.setBounds(10, 195, 149, 23);
		panel_1.add(btnNewButton_7);
		btnNewButton_7.setBackground(SystemColor.textHighlight);
		btnNewButton_7.setForeground(SystemColor.window);
	}

}
