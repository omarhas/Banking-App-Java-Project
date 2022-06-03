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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class transfert extends JFrame {

	private JPanel contentPane;
	private JTextField emailField;
	private JTextField amountField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					transfert frame = new transfert();
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
	public transfert(Client client) {
		setTitle("Transfert");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Transfert :");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(269, 11, 125, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Account Email :");
		lblNewLabel_1.setForeground(SystemColor.window);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(267, 81, 139, 14);
		contentPane.add(lblNewLabel_1);
		
		emailField = new JTextField();
		emailField.setBounds(253, 102, 185, 20);
		contentPane.add(emailField);
		emailField.setColumns(10);
		
		amountField = new JTextField();
		amountField.setBounds(255, 163, 183, 20);
		contentPane.add(amountField);
		amountField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Amount : ");
		lblNewLabel_2.setForeground(SystemColor.window);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(263, 138, 72, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Transfert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					client.makeTransfer(emailField.getText(), Integer.parseInt(amountField.getText()));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(UIManager.getColor("ProgressBar.shadow"));
		btnNewButton.setForeground(SystemColor.window);
		btnNewButton.setBounds(272, 208, 95, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.setForeground(SystemColor.window);
		btnNewButton_1.setBackground(SystemColor.textHighlight);
		btnNewButton_1.setBounds(10, 33, 147, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				home ho= new home(client);
				ho.setVisible(true);
				dispose();
				
				
			}
			
		});
		
		JButton btnNewButton_2 = new JButton("Transfert");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setForeground(SystemColor.window);
		btnNewButton_2.setBackground(SystemColor.textHighlight);
		btnNewButton_2.setBounds(10, 67, 147, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Amount");
		btnNewButton_3.setForeground(SystemColor.window);
		btnNewButton_3.setBackground(SystemColor.textHighlight);
		btnNewButton_3.setBounds(10, 101, 147, 23);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					amount amou= new amount(client);
					amou.setVisible(true);
					dispose();
					
				}
				
			});
		
		JButton btnNewButton_4 = new JButton("Edit profile");
		btnNewButton_4.setForeground(SystemColor.window);
		btnNewButton_4.setBackground(SystemColor.textHighlight);
		btnNewButton_4.setBounds(10, 135, 147, 23);
		contentPane.add(btnNewButton_4);
        btnNewButton_4.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				editprofile edit= new editprofile(client);
				edit.setVisible(true);
				dispose();
				
			}
       });
		
		JButton btnNewButton_5 = new JButton("Reclamation");
		btnNewButton_5.setBackground(SystemColor.textHighlight);
		btnNewButton_5.setForeground(SystemColor.window);
		btnNewButton_5.setBounds(10, 169, 147, 23);
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
		panel.setBounds(0, 0, 175, 355);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_7 = new JButton("Operations");
		btnNewButton_7.setBounds(10, 201, 147, 23);
		panel.add(btnNewButton_7);
		btnNewButton_7.setBackground(SystemColor.textHighlight);
		btnNewButton_7.setForeground(SystemColor.window);
		
		JButton btnNewButton_8 = new JButton("Logout");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login loginPage = new Login();
				loginPage.setVisible(true);
				dispose();
			}
		});
		btnNewButton_8.setBounds(10, 234, 147, 23);
		panel.add(btnNewButton_8);
		btnNewButton_8.setBackground(SystemColor.textHighlight);
		btnNewButton_8.setForeground(SystemColor.window);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operations op= new operations(client);
				op.setVisible(true);
				dispose();
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textHighlight);
		panel_1.setBounds(206, 52, 294, 224);
		contentPane.add(panel_1);
	}
}
