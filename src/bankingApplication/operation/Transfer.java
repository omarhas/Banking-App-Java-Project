package bankingApplication.operation;

public class Transfer extends Operation{
    private int toId;

    public Transfer(int id, int idClient, int amount, String date, int toId) {
        setId(id);
        setIdClient(idClient);
        setAmount(amount);
        setDate(date);
        setToId(toId);
    }

    @Override
    public String getType() {
        return "Transfer";
    }

    public int getToId() {
        return toId;
    }

    public void setToId(int toId) {
        this.toId = toId;
    }
}
    