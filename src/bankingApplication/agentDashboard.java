package bankingApplication;

import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.DatabaseMetaData;
import java.sql.ResultSetMetaData;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Insets;
import bankingApplication.agent.Agent;
import bankingApplication.client.Client;
import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class agentDashboard extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void resultToTableModel(ArrayList<Client> clients, JTable table) throws SQLException{
        //Create new table model
        DefaultTableModel tableModel = new DefaultTableModel();
        
        //Retrieve meta data from ResultSet
        //ResultSetMetaData metaData = rs.getMetaData();

        //Get number of columns from meta data
        int columnCount = 7;
        String[] columns = {
        		"id",
        		"prenom",
        		"nom",
        		"email",
        		"password",
        		"balance",
        		"status"
        };
        //Get all column names from meta data and add columns to table model
        for (int columnIndex = 0; columnIndex < columnCount; columnIndex++){
        	tableModel.addColumn(columns[columnIndex]);
        }

        //Create array of Objects with size of column count from meta data
        Object[] row = new Object[columnCount];
        int j = 0;
        //Scroll through result set
        while (j != clients.size()){
            //Get object from column with specific index of result set to array of objects
            int i=0;
        	row[i] = clients.get(j).getId(); i++;
        	row[i] = clients.get(j).getNom(); i++;
        	row[i] = clients.get(j).getPrenom(); i++;
        	row[i] = clients.get(j).getEmail(); i++;
        	row[i] = clients.get(j).getPassword(); i++;
        	row[i] = clients.get(j).getBalance(); i++;
        	row[i] = clients.get(j).getStatus(); i++;
            //Now add row to table model with that array of objects as an argument
            tableModel.addRow(row);
            j++;
        }

        //Now add that table model to your table and you are done :D
        table.setModel(tableModel); 
    }
	public agentDashboard(Agent agent) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 153, 51));
		panel.setBounds(10, 10, 172, 543);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(-113, 408, 285, 135);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\khali\\Downloads\\TIC BANK-logo\\default.png"));
		
		JButton btnNewButton_3_6 = new JButton("Withdrawal");
		btnNewButton_3_6.setBackground(new Color(102, 51, 51));
		btnNewButton_3_6.setForeground(new Color(255, 255, 255));
		btnNewButton_3_6.setMargin(new Insets(2, 5, 2, 5));
		btnNewButton_3_6.setFont(new Font("Courier New", Font.BOLD, 15));
		btnNewButton_3_6.setBounds(10, 367, 152, 31);
		panel.add(btnNewButton_3_6);
		
		JButton btnNewButton_3_6_1 = new JButton("Deposit");
		btnNewButton_3_6_1.setBackground(new Color(102, 51, 51));
		btnNewButton_3_6_1.setForeground(new Color(255, 255, 255));
		btnNewButton_3_6_1.setMargin(new Insets(2, 5, 2, 5));
		btnNewButton_3_6_1.setFont(new Font("Courier New", Font.BOLD, 15));
		btnNewButton_3_6_1.setBounds(10, 326, 152, 31);
		panel.add(btnNewButton_3_6_1);
		
		JButton searchByEmailBTN = new JButton("search by email");
		searchByEmailBTN.setBackground(new Color(102, 51, 51));
		searchByEmailBTN.setForeground(new Color(255, 255, 255));
		
		searchByEmailBTN.setMargin(new Insets(2, 5, 2, 5));
		searchByEmailBTN.setFont(new Font("Courier New", Font.BOLD, 15));
		searchByEmailBTN.setBounds(10, 67, 152, 31);
		panel.add(searchByEmailBTN);
		
		JButton btnNewButton_3_6_1_2 = new JButton("search by id");
		btnNewButton_3_6_1_2.setBackground(new Color(102, 51, 51));
		btnNewButton_3_6_1_2.setForeground(new Color(255, 255, 255));
		
		btnNewButton_3_6_1_2.setMargin(new Insets(2, 5, 2, 5));
		btnNewButton_3_6_1_2.setFont(new Font("Courier New", Font.BOLD, 15));
		btnNewButton_3_6_1_2.setBounds(10, 108, 152, 31);
		panel.add(btnNewButton_3_6_1_2);
		
		JButton btnNewButton_3_6_1_3 = new JButton("modify client");
		btnNewButton_3_6_1_3.setBackground(new Color(102, 51, 51));
		btnNewButton_3_6_1_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3_6_1_3.setMargin(new Insets(2, 5, 2, 5));
		btnNewButton_3_6_1_3.setFont(new Font("Courier New", Font.BOLD, 15));
		btnNewButton_3_6_1_3.setBounds(10, 219, 152, 31);
		panel.add(btnNewButton_3_6_1_3);
		
		JButton btnNewButton_3_6_1_4 = new JButton("add client");
		btnNewButton_3_6_1_4.setBackground(new Color(102, 51, 51));
		btnNewButton_3_6_1_4.setForeground(new Color(255, 255, 255));
		
		btnNewButton_3_6_1_4.setMargin(new Insets(2, 5, 2, 5));
		btnNewButton_3_6_1_4.setFont(new Font("Courier New", Font.BOLD, 15));
		btnNewButton_3_6_1_4.setBounds(10, 178, 152, 31);
		panel.add(btnNewButton_3_6_1_4);
		
		JButton btnNewButton_3_6_1_5 = new JButton("display clients");
		btnNewButton_3_6_1_5.setBackground(new Color(102, 51, 51));
		btnNewButton_3_6_1_5.setForeground(new Color(255, 255, 255));
		btnNewButton_3_6_1_5.setMargin(new Insets(2, 5, 2, 5));
		btnNewButton_3_6_1_5.setFont(new Font("Courier New", Font.BOLD, 15));
		
		btnNewButton_3_6_1_5.setBounds(10, 26, 152, 31);
		panel.add(btnNewButton_3_6_1_5);
		
		JButton btnNewButton_3_6_1_3_1 = new JButton("Complaints");
		btnNewButton_3_6_1_3_1.setMargin(new Insets(2, 5, 2, 5));
		btnNewButton_3_6_1_3_1.setForeground(Color.WHITE);
		btnNewButton_3_6_1_3_1.setFont(new Font("Courier New", Font.BOLD, 15));
		btnNewButton_3_6_1_3_1.setBackground(new Color(102, 51, 51));
		btnNewButton_3_6_1_3_1.setBounds(10, 285, 152, 31);
		panel.add(btnNewButton_3_6_1_3_1);
		
		JPanel display = new JPanel();
		display.setBounds(195, 10, 681, 543);
		contentPane.add(display);
		display.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("TIC BANK Management System");
		lblNewLabel_1.setFont(new Font("Courier New", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(10, 151, 679, 199);
		display.add(lblNewLabel_1);
		
		JLabel welcomeText = new JLabel("Welcome Agent " + agent.getPrenom());
		welcomeText.setFont(new Font("Courier New", Font.PLAIN, 30));
		welcomeText.setBounds(107, 301, 496, 60);
		display.add(welcomeText);
		searchByEmailBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.removeAll();
				searchByEmail searchBE = new searchByEmail(agent);
				display.setAlignmentY(TOP_ALIGNMENT);
				display.add(searchBE);
				display.revalidate();
				display.repaint();

				/*searchByEmail searchByEmail = new searchByEmail();
				searchByEmail.setVisible(true);
				contentPane.remove(display);
				contentPane.add(searchByEmail);*/
			}
		});
		btnNewButton_3_6_1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ArrayList<Client> clients = agent.getAllClients();
					display.removeAll();
			        //System.out.println("client 1 password is = " + clients.get(0).getPassword());
					resultToTableModel(clients, table);		
					//System.out.print(clients.get(0).getNom());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_3_6_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.removeAll();
				searchById searchBI = new searchById(agent);
				display.setAlignmentY(TOP_ALIGNMENT);
				display.add(searchBI);
				display.revalidate();
				display.repaint();
			}
		});
		btnNewButton_3_6_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.removeAll();
				addClientForm addClient = new addClientForm(agent);
				display.add(addClient);
				display.revalidate();
				display.repaint();
			}
		});
		btnNewButton_3_6_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.removeAll();
				modifyClientForm modifyClient = new modifyClientForm(agent);
				display.add(modifyClient);
				display.revalidate();
				display.repaint();
			}
		});
		btnNewButton_3_6_1_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.removeAll();
				complaintsPage comptPage = new complaintsPage(agent);
				display.add(comptPage);
				display.setAlignmentX(LEFT_ALIGNMENT);
				display.setAlignmentY(TOP_ALIGNMENT);
				display.revalidate();
				display.repaint();
			}
		});
		btnNewButton_3_6_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.removeAll();
				depositForm depForm = new depositForm(agent);
				display.add(depForm);
				display.revalidate();
				display.repaint();
			}
		});
		btnNewButton_3_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.removeAll();
				withdrawalForm withForm = new withdrawalForm(agent);
				display.add(withForm);
				display.revalidate();
				display.repaint();
			}
		});
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(192, 10, 684, 543);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
