package bankingApplication.clientDash;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bankingApplication.client.Client;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class reclamation extends JFrame {

	private JPanel contentPane;
	private JTextField titleField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reclamation frame = new reclamation();
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
	public reclamation(Client client) {
		setTitle("Reclamation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(118, 51, 2, 2);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(191, 143, 304, 149);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client.addReclamation( titleField.getText(), textArea.getText());
				titleField.setText("");
				textArea.setText("");
			}
		});
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setForeground(SystemColor.window);
		btnNewButton.setBounds(296, 318, 113, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Send a reclamation : ");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(203, 39, 218, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.setForeground(SystemColor.window);
		btnNewButton_1.setBackground(SystemColor.textHighlight);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home ho= new home(client);
				ho.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(10, 11, 152, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Transfert");
		btnNewButton_2.setForeground(SystemColor.window);
		btnNewButton_2.setBackground(SystemColor.textHighlight);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transfert trans= new transfert(client);
				trans.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(10, 46, 152, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Amount");
		btnNewButton_3.setForeground(SystemColor.window);
		btnNewButton_3.setBackground(SystemColor.textHighlight);
		btnNewButton_3.setBounds(10, 80, 152, 23);
		contentPane.add(btnNewButton_3);
        btnNewButton_3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				amount amou= new amount(client);
				amou.setVisible(true);
				dispose();
				
			}
			
		});
		
		JButton btnNewButton_4 = new JButton("Edit Profile");
		btnNewButton_4.setForeground(SystemColor.window);
		btnNewButton_4.setBackground(SystemColor.textHighlight);
		btnNewButton_4.setBounds(10, 111, 152, 23);
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
		btnNewButton_5.setBounds(10, 144, 152, 23);
		contentPane.add(btnNewButton_5);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 176, 352);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_8 = new JButton("Operations");
		btnNewButton_8.setBounds(10, 179, 152, 23);
		panel.add(btnNewButton_8);
		btnNewButton_8.setForeground(SystemColor.window);
		btnNewButton_8.setBackground(SystemColor.textHighlight);
		
		
		JButton btnNewButton_6 = new JButton("Logout");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login loginPage = new Login();
				loginPage.setVisible(true);
				dispose();
			}
		});
		btnNewButton_6.setBounds(10, 212, 152, 23);
		panel.add(btnNewButton_6);
		btnNewButton_6.setForeground(SystemColor.window);
		btnNewButton_6.setBackground(SystemColor.textHighlight);
		
		titleField = new JTextField();
		titleField.setBounds(191, 101, 304, 20);
		contentPane.add(titleField);
		titleField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Title : ");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBounds(203, 76, 63, 14);
		contentPane.add(lblNewLabel_1);
	}
}
