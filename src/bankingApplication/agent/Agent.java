package bankingApplication.agent;

import bankingApplication.client.Client;
import bankingApplication.reclamation.Reclamation;
import bankingApplication.shared.Database;
import bankingApplication.shared.Person;
import javax.swing.JOptionPane;

import com.mysql.cj.x.protobuf.MysqlxResultset;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Agent extends Person {
    public static String getRole() {
        return "agent";
    }

    // create Agent object from db
    public Agent(String email, String motDePass, String role) throws Exception {
        ResultSet resultSet = Database.executeSelectQuery(
                "select * from agent where email = \"" + email +
                        "\" and password = \"" + motDePass +
                        "\" and role = \"" + role +"\";"
        );

        if (resultSet.next()) {
            setId(resultSet.getInt("id"));
            setNom(resultSet.getString("nom"));
            setPrenom(resultSet.getString("prenom"));
            setEmail(resultSet.getString("email"));
            setPassword(resultSet.getString("password"));
        } else {
            JOptionPane.showMessageDialog(null, "Wrong password or agent doesn't exist !");
        }
    }

    public static void main(String[] args) throws Exception {
        // get agent object from db :
        Agent agent = new Agent("benali@gmail.com", "ali", "agent");
        System.out.println(agent.getId());

        // add new client to db :
        agent.addNewClient("Ahmad", "Derbl", "ahmed@gmail.com", "ahmed123");
        agent.addNewClient("Kamal", "Mit", "kamal@gmail.com", "kamal13");

        // get all clients :
        //ArrayList<Client> clients = agent.getAllClients();
        //System.out.println("client 1 password is = " + clients.get(0).getPassword());

        // get client object from email :
        //Client client = agent.getClient("ahmed@gmail.com");

        // modify a client
        //client.setPassword("new password");
        //agent.modifyClient(client);

        //client = agent.getClient("ahmed@gmail.com");
        //System.out.println("new password : "+client.getPassword());

        // get all reclamations :
        //ArrayList<Reclamation> reclamations = agent.getAllReclamations();
        //System.out.println(reclamations.get(0).getTitle());

        // make deposit
        agent.makeDeposit("ahmed@gmail.com", 1000);

        // make withdrawal
        //agent.makeWithdrawal("ahmed@gmail.com", 850);

    }

    // create a new client and add to db :
    public void addNewClient(
            String prenom,
            String nom,
            String email,
            String password
    ) throws Exception {
        // check if client exists
        ResultSet resultSet = Database.executeSelectQuery(
                "select * from client where email=\""+email+"\";"
        );
        if(resultSet.next()){
            throw new Exception("User exists !");
        }
        // add client
        Database.executeUpdateQuery(
                String.format(
                        "insert into client (prenom, nom, email, password, status, balance) values (\"%1$s\", \"%2$s\", \"%3$s\", \"%4$s\", 1, 0);",
                        prenom, nom, email, password
                )
        );
    }

    public ArrayList<Client> getAllClients() throws Exception {
        ResultSet resultSet = Database.executeSelectQuery(
                "select * from client;"
        );
        ArrayList<Client> clients = new ArrayList<Client>();
        while (resultSet.next()) {
            Client client = new Client(
                    resultSet.getString("email"),
                    resultSet.getString("password")
            );
            clients.add(client);
        }
        return clients;
    }

    public void modifyClient(Client client) {
        Database.executeUpdateQuery(
                String.format("update client set prenom = \"%1$s\", nom = \"%2$s\", email = \"%3$s\", password = \"%4$s\", status = \"%5$s\" where id = %6$s",
                        client.getPrenom(),
                        client.getNom(),
                        client.getEmail(),
                        client.getPassword(),
                        client.getStatus(),
                        client.getId()
                )
        );
    }

    public Client getClient(String email) throws Exception {
        Client client = null;
        ResultSet resultSet = Database.executeSelectQuery(
                "select * from client where email=\""+email+"\";"
        );
        if(resultSet.next()){
            client = new Client(
                    resultSet.getString("email"),
                    resultSet.getString("password")
            );
        } else {
        	JOptionPane.showMessageDialog(null, "Client with specified email does not exist.");
            throw new Exception("Client does not exists !");
        }
        return client;
    }

    public Client getClient(int id) throws Exception {
        Client client = null;
        ResultSet resultSet = Database.executeSelectQuery(
                "select * from client where id="+id+";"
        );
        if(resultSet.next()){
            client = new Client(
                    resultSet.getString("email"),
                    resultSet.getString("password")
            );
        } else {
        	JOptionPane.showMessageDialog(null, "Client with specified id does not exist.");
            throw new Exception("Client does not exists !");
        }
        return client;
    }

    public ArrayList<Reclamation> getAllReclamations() throws SQLException {
        ResultSet resultSet = Database.executeSelectQuery(
                "select * from reclamation;"
        );
        ArrayList<Reclamation> reclamations = new ArrayList<Reclamation>();
        while (resultSet.next()) {
            Reclamation reclamation = new Reclamation(
                    resultSet.getInt("id"),
                    resultSet.getString("date"),
                    resultSet.getString("title"),
                    resultSet.getString("text"),
                    resultSet.getInt("idClient")
            );
            reclamations.add(reclamation);
        }
        return reclamations;
    }

    public void makeDeposit(String emailClient, int amount) throws Exception {
        Client client = getClient(emailClient);
        Database.executeUpdateQuery(
                String.format(
                        "update client set balance = %1$s where id=%2$s;",
                        client.getBalance() + amount, client.getId()
                )
        );
        LocalDate date = LocalDate.now();
        Database.executeUpdateQuery(
                String.format(
                        "insert into deposit (amount, date, idClient) values (%1$s, \"%2$s\", %3$s);",
                        amount, date.toString(), client.getId()
                )
        );
        System.out.println("Deposit successful +++");
    }

    public void makeWithdrawal(String emailClient, int amount) throws Exception {
        Client client = getClient(emailClient);
        if(amount > client.getBalance()) {
            JOptionPane.showMessageDialog(null, "Amount exceeds balance");
            throw new Exception("");

        }
        Database.executeUpdateQuery(
                String.format(
                        "update client set balance = %1$s where id=%2$s;",
                        client.getBalance() - amount, client.getId()
                )
        );
        LocalDate date = LocalDate.now();
        Database.executeUpdateQuery(
                String.format(
                        "insert into withdrawal (amount, date, idClient) values (%1$s, \"%2$s\", %3$s);",
                        amount, date.toString(), client.getId()
                )
        );
        JOptionPane.showMessageDialog(null, "Withdrawal successful +++");
    }
}
