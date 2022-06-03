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

import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JInternalFrame;

public class operations extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					operations frame = new operations();
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
	public operations(Client client) {
		setTitle("Operations");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Operations : ");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(281, 23, 144, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setForeground(SystemColor.window);
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setBounds(10, 21, 152, 23);
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
		btnNewButton_1.setBounds(10, 55, 152, 23);
		contentPane.add(btnNewButton_1);
        btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				transfert trans= new transfert(client);
				trans.setVisible(true);
				dispose();
				
				
			}
			
		});
		
		JButton btnNewButton_2 = new JButton("Amount");
		btnNewButton_2.setForeground(SystemColor.window);
		btnNewButton_2.setBackground(SystemColor.textHighlight);
		btnNewButton_2.setBounds(10, 89, 152, 23);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					amount amou= new amount(client);
					amou.setVisible(true);
					dispose();
					
				}
				
			});
		
		JButton btnNewButton_3 = new JButton("Edit profile");
		btnNewButton_3.setBackground(SystemColor.textHighlight);
		btnNewButton_3.setForeground(SystemColor.window);
		btnNewButton_3.setBounds(10, 123, 152, 23);
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
		btnNewButton_4.setBounds(10, 157, 152, 23);
		contentPane.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				reclamation rec= new reclamation(client);
				rec.setVisible(true);
				dispose();
				
			}
       });
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 180, 376);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JButton btnNewButton_7 = new JButton("Logout");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login loginPage = new Login();
				loginPage.setVisible(true);
				dispose();
			}
		});
		btnNewButton_7.setBounds(10, 190, 152, 23);
		panel.add(btnNewButton_7);
		btnNewButton_7.setBackground(SystemColor.textHighlight);
		btnNewButton_7.setForeground(SystemColor.window);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(294, 185, -35, -72);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(364, 240, -131, -134);
		contentPane.add(scrollPane_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(364, 191, -131, -82);
		contentPane.add(scrollPane_2);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(281, 177, -35, -52);
		contentPane.add(scrollPane_3);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(243, 89, 194, 242);
		contentPane.add(scrollPane_4);
	}
}
