package bankingApplication.clientDash;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bankingApplication.client.Client;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.UIManager;

public class home extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home frame = new home();
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
	public home(Client client) {
		setTitle("Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setForeground(SystemColor.window);
		btnNewButton.setBounds(10, 23, 146, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Transfert");
		btnNewButton_1.setForeground(SystemColor.window);
		btnNewButton_1.setBackground(SystemColor.textHighlight);
		btnNewButton_1.setBounds(10, 57, 146, 23);
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
		btnNewButton_2.setBounds(10, 91, 146, 23);
		contentPane.add(btnNewButton_2);
        btnNewButton_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				amount amou= new amount(client);
				amou.setVisible(true);
				dispose();
				
			}
			
		});
		
		JButton btnNewButton_3 = new JButton("Edit Profile");
		btnNewButton_3.setForeground(SystemColor.window);
		btnNewButton_3.setBackground(SystemColor.textHighlight);
		btnNewButton_3.setBounds(10, 125, 146, 23);
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
		btnNewButton_4.setBounds(10, 159, 146, 23);
		contentPane.add(btnNewButton_4);
        btnNewButton_4.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				reclamation rec= new reclamation(client);
				rec.setVisible(true);
				dispose();
				
			}
       });
		
		
		JLabel lblNewLabel = new JLabel("Hello " + client.getPrenom());
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setBounds(226, 40, 146, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("welcome to TIC bank");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(219, 84, 134, 14);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 183, 380);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_5 = new JButton("logout");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login loginPage = new Login();
				loginPage.setVisible(true);
				dispose();
			}
		});
		btnNewButton_5.setBounds(10, 194, 146, 23);
		panel.add(btnNewButton_5);
		btnNewButton_5.setForeground(SystemColor.window);
		btnNewButton_5.setBackground(SystemColor.textHighlight);
	}
}
