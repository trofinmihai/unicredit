package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.sql.*;
import java.io.*;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.ArrayList;
import hello.Ticket_Input;

@RestController
public class ServiceController {

    @RequestMapping("/list_events")
    public ArrayList<Event> eventing(){

        String events = null;
        ArrayList<Event> eventData = null;
        try{

            EventsManager eventsManager= new EventsManager();
            eventData = eventsManager.GetEvents();
        }catch (Exception e)
        {
            System.out.println("Exception Error");
        }
        return eventData;
    }

    @RequestMapping("/ticket_details")
    public Ticket greeting(@RequestParam(value="id", defaultValue="1") String id) throws Exception{

        TicketManager ticketManager = new TicketManager(id);
        return ticketManager.GetTicketDetails();
    }

    @RequestMapping(value = "/buy_ticket", method = RequestMethod.POST, produces = "application/json",consumes = "application/json")
    public ResponseEntity<Ticket> insert(@RequestBody Ticket_Input ticket) throws Exception{

        Database database = new Database();
        String username = ticket.getUsername();
        int idEvent = ticket.getIdEvent();
        int idTicket = 0;

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();

        try (
                Connection conn = database.GetConnection();
                Statement stmt = conn.createStatement();
        ) {
            if (ticket != null) {
                String sqlInsert = "insert into ticket "
                        + "values (NULL,'"+dateFormat.format(date)+"','"+username+"',"+idEvent+")";
                int rset = stmt.executeUpdate(sqlInsert);

                String strSelect = "select MAX(idTicket) from ticket";
                ResultSet rrset = stmt.executeQuery(strSelect);
                System.out.println(strSelect);
                while (rrset.next()) {
                    idTicket = rrset.getInt("MAX(idTicket)");
                }

                }
            }catch(SQLException ex){
                throw ex;
            }
        return new ResponseEntity<Ticket>(new Ticket(idTicket, username, dateFormat.format(date), idEvent), HttpStatus.OK);
    }

    @RequestMapping(value = "/cancel_ticket", method = RequestMethod.POST, produces = "application/json",consumes = "application/json")

        public ResponseEntity<Message> delete(@RequestBody Ticket_Input ticket) throws Exception{

        Database database = new Database();
        String username = ticket.getUsername();
        int idEvent = ticket.getIdEvent();
        int idTicket = ticket.getIdTicket();

        try (
                Connection conn = database.GetConnection();
                Statement stmt = conn.createStatement();
        ) {
            if (ticket != null) {
                String sqlDelete = "delete from ticket where idTicket="+idTicket;
                int rset = stmt.executeUpdate(sqlDelete);

            }
        }catch(SQLException ex){
            throw ex;
        }
        return new ResponseEntity<Message>(new Message("The ticket " + idTicket + " was canceled!"), HttpStatus.OK);
    }

}
