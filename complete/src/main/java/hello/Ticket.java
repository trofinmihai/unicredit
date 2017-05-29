package hello;

public class Ticket{

    private  int idTicket;
    private  String username;
    private  String purchaseDate;
    private  int idEvent;

    public Ticket(int idTicket, String username, String purchaseDate,  int idEvent){
        this.idTicket = idTicket;
        this.username = username;
        this.purchaseDate = purchaseDate;
        this.idEvent = idEvent;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public String getUsername() {
        return username;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void getIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public void getUsername(String usernAME) {
        this.username = username;
    }

    public void getPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void getIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

}