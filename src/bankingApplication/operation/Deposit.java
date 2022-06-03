package bankingApplication.operation;

public class Deposit extends Operation{

    public Deposit(int id, int idClient, int amount, String date) {
        setId(id);
        setIdClient(idClient);
        setAmount(amount);
        setDate(date);
    }

    @Override
    public String getType() {
        return "Deposit";
    }
}
