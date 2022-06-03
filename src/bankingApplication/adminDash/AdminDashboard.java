package bankingApplication.adminDash;

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

import bankingApplication.agent.Admin;
import bankingApplication.agent.Agent;
import bankingApplication.client.Client;
import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class AdminDashboard extends JFrame {

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
	public void resultToTableModel(ArrayList<Agent> agents, JTable table) throws SQLException{
        //Create new table model
        DefaultTableModel tableModel = new DefaultTableModel();
        
        //Retrieve meta data from ResultSet
        //ResultSetMetaData metaData = rs.getMetaData();

        //Get number of columns from meta data
        int columnCount = 6;
        String[] columns = {
        		"id",
        		"prenom",
        		"nom",
        		"email",
        		"password",
        		"role",
        };
        //Get all column names from meta data and add columns to table model
        for (int columnIndex = 0; columnIndex < columnCount; columnIndex++){
        	tableModel.addColumn(columns[columnIndex]);
        }

        //Create array of Objects with size of column count from meta data
        Object[] row = new Object[columnCount];
        int j = 0;
        //Scroll through result set
        while (j != agents.size()){
            //Get object from column with specific index of result set to array of objects
            int i=0;
        	row[i] = agents.get(j).getId(); i++;
        	row[i] = agents.get(j).getPrenom(); i++;
        	row[i] = agents.get(j).getNom(); i++;
        	row[i] = agents.get(j).getEmail(); i++;
        	row[i] = agents.get(j).getPassword(); i++;
        	row[i] = agents.get(j).getRole(); i++;
            //Now add row to table model with that array of objects as an argument
            tableModel.addRow(row);
            j++;
        }

        //Now add that table model to your table and you are done :D
        table.setModel(tableModel); 
    }
	public AdminDashboard(Admin admin) {
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
		
		JButton modBtn = new JButton("Modify Agent");
		modBtn.setBackground(new Color(102, 51, 51));
		modBtn.setForeground(new Color(255, 255, 255));
		modBtn.setMargin(new Insets(2, 5, 2, 5));
		modBtn.setFont(new Font("Courier New", Font.BOLD, 15));
		modBtn.setBounds(10, 223, 152, 31);
		panel.add(modBtn);
		
		JButton addBtn = new JButton("Add Agent");
		addBtn.setBackground(new Color(102, 51, 51));
		addBtn.setForeground(new Color(255, 255, 255));
		
		addBtn.setMargin(new Insets(2, 5, 2, 5));
		addBtn.setFont(new Font("Courier New", Font.BOLD, 15));
		addBtn.setBounds(10, 182, 152, 31);
		panel.add(addBtn);
		
		JButton displayAllBtn = new JButton("display Agents");
		displayAllBtn.setBackground(new Color(102, 51, 51));
		displayAllBtn.setForeground(new Color(255, 255, 255));
		displayAllBtn.setMargin(new Insets(2, 5, 2, 5));
		displayAllBtn.setFont(new Font("Courier New", Font.BOLD, 15));
		
		displayAllBtn.setBounds(10, 141, 152, 31);
		panel.add(displayAllBtn);
		
		JButton delBtn = new JButton("Delete Agent");
		delBtn.setMargin(new Insets(2, 5, 2, 5));
		delBtn.setForeground(Color.WHITE);
		delBtn.setFont(new Font("Courier New", Font.BOLD, 15));
		delBtn.setBackground(new Color(102, 51, 51));
		delBtn.setBounds(10, 264, 152, 31);
		panel.add(delBtn);
		
		JPanel display = new JPanel();
		display.setBounds(195, 10, 681, 543);
		contentPane.add(display);
		display.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("TIC BANK Management System");
		lblNewLabel_1.setFont(new Font("Courier New", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(10, 151, 679, 199);
		display.add(lblNewLabel_1);
		
		JLabel welcomeText = new JLabel("Welcome Admin " + admin.getPrenom());
		welcomeText.setFont(new Font("Courier New", Font.PLAIN, 30));
		welcomeText.setBounds(107, 301, 496, 60);
		display.add(welcomeText);
		displayAllBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ArrayList<Agent> agents = admin.getAllAgents();
					display.removeAll();
			        //System.out.println("client 1 password is = " + clients.get(0).getPassword());
					resultToTableModel(agents, table);		
					//System.out.print(clients.get(0).getNom());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.removeAll();
				AddAgentForm addAgent = new AddAgentForm(admin);
				display.add(addAgent);
				display.revalidate();
				display.repaint();
			}
		});
		modBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.removeAll();
				ModifyAgentForm modifyAgent = new ModifyAgentForm(admin);
				display.add(modifyAgent);
				display.revalidate();
				display.repaint();
			}
		});
		delBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.removeAll();
				DelAgentForm delForm = new DelAgentForm(admin);
				display.add(delForm);
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
