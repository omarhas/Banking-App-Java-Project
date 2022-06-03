package bankingApplication.client;

import bankingApplication.operation.Deposit;
import bankingApplication.operation.Operation;
import bankingApplication.operation.Transfer;
import bankingApplication.operation.Withdrawal;
import bankingApplication.reclamation.Reclamation;
import bankingApplication.shared.Database;
import bankingApplication.shared.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.JOptionPane;

public class Client extends Person {
    private byte status;
    private int balance;

    // get Client object from db :
    public Client(String email, String password) throws Exception {
        ResultSet resultSet = Database.executeSelectQuery(
                "select * from client where email = \"" + email +
                        "\" and password = \"" + password + "\";"
        );

        if (resultSet.next()) {
            setId(resultSet.getInt("id"));
            setNom(resultSet.getString("nom"));
            setPrenom(resultSet.getString("prenom"));
            setEmail(resultSet.getString("email"));
            setPassword(resultSet.getString("password"));
            setStatus(resultSet.getByte("status"));
            setBalance(resultSet.getInt("balance"));
        } else {
            JOptionPane.showMessageDialog(null, "Wrong password or client doesn't exist !");
            throw new Exception("Wrong password or agent doesn't exist !");
            
        }
    }

    public static void main(String[] args) throws Exception {
        // create Client object from db :
        Client client = new Client("ahmed@gmail.com", "new password");

        // change password :
        //client.changePassword("hello world");
        //System.out.println(client.getPassword());

        // reclamations
        //client.addReclamation("title rec", "text rec");
        //ArrayList<Reclamation> reclamations = client.getReclamations();
        //System.out.println(reclamations.size());

        // make a transfer
        //client.makeTransfer("kamal@gmail.com", 50);

        // get operations
        ArrayList<Operation> operations = client.getOperations();
        System.out.println(operations.size());
    }

    public void changePassword(String newPassword) {
        setPassword(newPassword);
        Database.executeUpdateQuery(
                String.format("update client set password = \"%1$s\" where id = %2$s",
                        newPassword,
                        getId()
                )
        );
    }

    public void addReclamation(String title, String text){
        LocalDate date = LocalDate.now();
        Database.executeUpdateQuery(
                String.format(
                        "insert into reclamation (title, text, date, idClient) values (\"%1$s\", \"%2$s\", \"%3$s\", %4$s);",
                        title, text, date.toString(), getId()
                )
        );
        JOptionPane.showMessageDialog(null, "Reclamation sent !");
        
    }

    public ArrayList<Reclamation> getReclamations() throws SQLException {
        ResultSet resultSet = Database.executeSelectQuery(
                "select * from reclamation where idClient  = " + getId() + ";"
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

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void makeTransfer(String toEmail, int amount) throws Exception {
        if(amount > getBalance()) {
            JOptionPane.showMessageDialog(null, "amount exceeds balance !");
            throw new Exception("amount exceeds balance");
        }

        Client receiver = null;
        ResultSet resultSet = Database.executeSelectQuery(
                "select * from client where email=\""+toEmail+"\";"
        );
        if(resultSet.next()){
            receiver = new Client(
                    resultSet.getString("email"),
                    resultSet.getString("password")
            );
        } else {
            JOptionPane.showMessageDialog(null, "Client does not exists !");
            throw new Exception("Client does not exists !");
        }

        Database.executeUpdateQuery(
                String.format(
                        "update client set balance = %1$s where id=%2$s;",
                        getBalance() - amount, getId()
                )
        );

        Database.executeUpdateQuery(
                String.format(
                        "update client set balance = %1$s where id=%2$s;",
                        receiver.getBalance() + amount, receiver.getId()
                )
        );

        LocalDate date = LocalDate.now();
        Database.executeUpdateQuery(
                String.format(
                        "insert into transfer (amount, date, idClientFrom, idClientto) values (%1$s, \"%2$s\", %3$s, %4$s);",
                        amount, date.toString(), getId(), receiver.getId()
                )
        );
        JOptionPane.showMessageDialog(null, "Transfer success <->");
        System.out.println("Transfer success <->");
    }

    public ArrayList<Operation> getOperations() throws Exception{
        ArrayList<Operation> operations = new ArrayList<Operation>();
        // get deposits
        ResultSet resultSet = Database.executeSelectQuery(
                "select * from deposit where idClient="+getId()+";"
        );
        while (resultSet.next()) {
            Deposit deposit = new Deposit(
                    resultSet.getInt("id"),
                    resultSet.getInt("idClient"),
                    resultSet.getInt("amount"),
                    resultSet.getString("date")
            );
            operations.add(deposit);
        }
        // get withdrawals
        resultSet = Database.executeSelectQuery(
                "select * from withdrawal where idClient="+getId()+";"
        );
        while (resultSet.next()) {
            Withdrawal withdrawal = new Withdrawal(
                    resultSet.getInt("id"),
                    resultSet.getInt("idClient"),
                    resultSet.getInt("amount"),
                    resultSet.getString("date")
            );
            operations.add(withdrawal);
        }
        // get transfers
        resultSet = Database.executeSelectQuery(
                "select * from transfer where idClientFrom="+getId()+" or idClientTo="+getId()+";"
        );
        while (resultSet.next()) {
            Transfer transfer = new Transfer(
                    resultSet.getInt("id"),
                    resultSet.getInt("idClientFrom"),
                    resultSet.getInt("amount"),
                    resultSet.getString("date"),
                    resultSet.getInt("idClientTo")
            );
            operations.add(transfer);
        }
        // order by date
        operations.sort(Comparator.comparing(o -> o.getDate()));
        return operations;
    }
}
