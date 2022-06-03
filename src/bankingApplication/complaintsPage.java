package bankingApplication;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bankingApplication.agent.Agent;
import bankingApplication.client.Client;
import bankingApplication.reclamation.Reclamation;
import javax.swing.JScrollPane;
import java.awt.Component;

public class complaintsPage extends JPanel {
	private JTable table;
	public void resultToTableModel(ArrayList<Reclamation> reclamations, JTable table) throws SQLException{
        //Create new table model
        DefaultTableModel tableModel = new DefaultTableModel();
        
        //Retrieve meta data from ResultSet
        //ResultSetMetaData metaData = rs.getMetaData();

        //Get number of columns from meta data
        int columnCount = 5;
        String[] columns = {
        		"id",
        		"title",
        		"date",
        		"text",
        		"idClient",
        };
        //Get all column names from meta data and add columns to table model
        for (int columnIndex = 0; columnIndex < columnCount; columnIndex++){
        	tableModel.addColumn(columns[columnIndex]);
        }

        //Create array of Objects with size of column count from meta data
        Object[] row = new Object[columnCount];
        int j = 0;
        //Scroll through result set
        while (j != reclamations.size()){
            //Get object from column with specific index of result set to array of objects
            int i=0;
        	row[i] = reclamations.get(j).getId(); i++;
        	row[i] = reclamations.get(j).getTitle(); i++;
        	row[i] = reclamations.get(j).getDate(); i++;
        	row[i] = reclamations.get(j).getText(); i++;
        	row[i] = reclamations.get(j).getIdClient(); i++;
            //Now add row to table model with that array of objects as an argument
            tableModel.addRow(row);
            j++;
        }

        //Now add that table model to your table and you are done :D
        table.setModel(tableModel); 
        
    }

	/**
	 * Create the panel.
	 */
	public complaintsPage(Agent agent) {
		setLayout(null);
		setBounds(100, 100, 533, 488);
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 521, 480);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setAlignmentY(Component.TOP_ALIGNMENT);
		scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		scrollPane.setBounds(0, 0, 518, 475);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		try {
			ArrayList<Reclamation> reclamations = agent.getAllReclamations();
			resultToTableModel(reclamations, table);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
