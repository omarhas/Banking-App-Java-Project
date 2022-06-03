package bankingApplication.operation;

public class Withdrawal extends Operation{
    public Withdrawal(int id, int idClient, int amount, String date) {
        setId(id);
        setIdClient(idClient);
        setAmount(amount);
        setDate(date);
    }

    @Override
    public String getType() {
        return "Withdrawal";
    }
}
