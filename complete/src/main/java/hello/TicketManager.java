package hello;

import java.sql.*;

public class TicketManager{

    String id;

    TicketManager(String id)
    {
        this.id = id;
    }

    public Ticket GetTicketDetails() throws Exception{
        Database database = new Database();
        int idTicket = 0 ;
        int idEvent = 0;
        String username = new String();
        String purchaseDate = new String();
        try (
                Connection conn = database.GetConnection();
                Statement stmt = conn.createStatement();
        ){
            String strSelect = "select * from ticket where idTicket="+Integer.parseInt(id);
            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next()) {
                idTicket = rset.getInt("idTicket");
                purchaseDate = rset.getString("purchaseDate");
                username = rset.getString("username");
                idEvent = rset.getInt("idEvent");
            }

            System.out.println(strSelect);

            Ticket ticketObject = new Ticket(idTicket, username, purchaseDate, idEvent);
            return ticketObject;

        }catch (SQLException ex){
            throw ex;
        }
    }
}

