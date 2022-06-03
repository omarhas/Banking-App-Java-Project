package bankingApplication.reclamation;


public class Reclamation {
    private int id;
    private String date;
    private String title;
    private String text;
    private int idClient;

    public Reclamation(int id, String date, String title, String text, int idClient) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.text = text;
        this.idClient = idClient;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
}
