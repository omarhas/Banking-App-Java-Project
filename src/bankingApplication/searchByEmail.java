package bankingApplication;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import bankingApplication.client.Client;

import bankingApplication.agent.Agent;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class searchByEmail extends JPanel {
	private JTextField emailField;
	private JTable table;
	public void resultSetToTableModel(Client client, JTable table) throws SQLException{
        //Create new table model
        DefaultTableModel tableModel = new DefaultTableModel();
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
        for (int columnIndex = 0; columnIndex < columnCount; columnIndex++){
        	tableModel.addColumn(columns[columnIndex]);
        }
        Object[] row = new Object[columnCount];
        int i=0;
    	row[i] = client.getId(); i++;
    	row[i] = client.getNom(); i++;
    	row[i] = client.getPrenom(); i++;
    	row[i] = client.getEmail(); i++;
    	row[i] = client.getPassword(); i++;
    	row[i] = client.getBalance(); i++;
    	row[i] = client.getStatus(); i++;

    	tableModel.addRow(row);
        table.setModel(tableModel); 
	}

	

	/**
	 * Create the panel.
	 */
	public searchByEmail(Agent agent) {
		setLayout(null);
		setBounds(100, 100, 517, 460);
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 504, 446);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Email :");
		lblNewLabel.setFont(new Font("Courier New", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 10, 98, 32);
		panel.add(lblNewLabel);
		
		emailField = new JTextField();
		emailField.setFont(new Font("Courier New", Font.BOLD, 20));
		emailField.setBounds(118, 17, 205, 19);
		panel.add(emailField);
		emailField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 52, 488, 322);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton searchBtn = new JButton("Search");
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Client chosenOne = agent.getClient(emailField.getText());
					if (chosenOne != null) 
						resultSetToTableModel(chosenOne, table);
					else
			            JOptionPane.showMessageDialog(null, "Client with specified email does not exist.");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		searchBtn.setFont(new Font("Courier New", Font.PLAIN, 20));
		searchBtn.setBounds(348, 16, 134, 21);
		panel.add(searchBtn);

	}
}
