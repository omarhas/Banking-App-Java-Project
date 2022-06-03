package bankingApplication.agent;

import bankingApplication.client.Client;
import bankingApplication.shared.Database;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Admin extends Agent {
    public static String getRole() {
        return "admin";
    }

    public Admin(String email, String password) throws Exception {
        super(email, password, getRole());
    }

    public static void main(String[] args) throws Exception {
        // get admin object from db :
        Admin admin = new Admin("khalil@gmail.com", "1234");
        System.out.println(admin.getPrenom());
        // create new agent :
        admin.addNewAgent("Zin abidin", "Ben Ali", "benali@gmail.com", "ali", "agent");

        // get all agents :
        ArrayList<Agent> agents = admin.getAllAgents();
        System.out.println(agents.size());

        // update agent :
        //Agent agent = agents.get(0);
        //agent.setPrenom("Hamza");
        //agent.setNom("Lahmar");
        //agent.setEmail("hamza@gmail.com");

        //admin.modifyAgent(agent);

        // remove agent :
        //admin.removeAgent(agents.get(0));
    }

    public ArrayList<Agent> getAllAgents() throws Exception {
        ResultSet resultSet = Database.executeSelectQuery(
                "select * from agent where role=\"agent\";"
        );
        ArrayList<Agent> agents = new ArrayList<Agent>();
        while (resultSet.next()) {
            Agent agent = new Agent(
                    resultSet.getString("email"),
                    resultSet.getString("password"),
                    "agent"
                    );
            agents.add(agent);
        }
        return agents;
    }

    public void addNewAgent(
            String prenom,
            String nom,
            String email,
            String password,
            String role
    ) throws Exception {
        // check if user exists
        ResultSet resultSet = Database.executeSelectQuery(
                "select * from agent where email=\""+email+"\";"
        );
        if(resultSet.next()){
            throw new Exception("User exists !");
        }
        // add agent
        Database.executeUpdateQuery(
                String.format(
                        "insert into agent (prenom, nom, email, password, role) values (\"%1$s\", \"%2$s\", \"%3$s\", \"%4$s\", \"%5$s\");",
                        prenom, nom, email, password, role
                )
        );
    }

    // pass the agent with modified attributes
    public void modifyAgent(Agent agent) {
        Database.executeUpdateQuery(
                String.format("update agent set prenom = \"%1$s\", nom = \"%2$s\", email = \"%3$s\", password = \"%4$s\" where id = %5$s",
                        agent.getPrenom(),
                        agent.getNom(),
                        agent.getEmail(),
                        agent.getPassword(),
                        agent.getId()
                )
        );
    }
    public Agent getAgent(int id) throws Exception {
        Agent agent = null;
        ResultSet resultSet = Database.executeSelectQuery(
                "select * from agent where id="+id+";"
        );
        if(resultSet.next()){
            agent = new Agent(
                    resultSet.getString("email"),
                    resultSet.getString("password"),
                    "agent"
            );
        } else {
        	JOptionPane.showMessageDialog(null, "Agent with specified id does not exist.");
            throw new Exception("Agent does not exists !");
        }
        return agent;
    }
    public void removeAgent(Agent agent) {
        Database.executeUpdateQuery("delete from agent where id="+ agent.getId());
    }
    public boolean isValid() {
    	return this != null;
    }
}
