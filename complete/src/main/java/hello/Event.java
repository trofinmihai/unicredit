package hello;

public class Event {

    private final int idEvent;
    private final String name;
    private final String date;
    private final float ticketPrice;
    private final int ticketsNumber;
    private final String place;
    private final String city;
    private final String country;


    public Event(int idEvent, String name, String date,  float ticketPrice,int ticketsNumber, String place, String city, String country )
    {
        this.idEvent = idEvent;
        this.name = name;
        this.date = date;
        this.ticketPrice = ticketPrice;
        this.ticketsNumber = ticketsNumber;
        this.place = place;
        this.city = city;
        this.country = country;
    }

    public int getId() {
        return idEvent;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getPlace() {
        return place;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public float getTicketPrice() {
        return ticketPrice;
    }

    public int getTicketsNumber() {
        return ticketsNumber;
    }
}
