package hello;

public class Ticket_Input{

    private String username;
    private int idEvent;
    private int idTicket;

//    public Ticket_Input(String username, int idEvent){
//        this.username = username;
//        this.idEvent = idEvent;
//    }

    public String getUsername() {
        return username;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket() {
        this.idTicket = idTicket;
    }

}