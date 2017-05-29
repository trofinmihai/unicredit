package hello;

import java.util.ArrayList;
import hello.Event;
import hello.Database;
import java.sql.*;

public class Events_ArrayList {

    public ArrayList<Event> GetEvents(Connection conn) throws Exception {

        ArrayList<Event> eventData = new ArrayList<Event>();
        int rowCount = 0;
        try(
                Statement stmt = conn.createStatement();
        ){
            String strSelect = "select idEvent, name, date, ticketPrice, ticketsNumber, place, city, country from event";
            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next()) {
                int idEvent = rset.getInt("idEvent");
                String name = rset.getString("name");
                String date = rset.getString("date");
                float ticketPrice = rset.getInt("ticketPrice");
                int ticketsNumber = rset.getInt("ticketsNumber");
                String place = rset.getString("place");
                String city = rset.getString("city");
                String country = rset.getString("country");

                Event eventObject = new Event(idEvent, name, date, ticketPrice, ticketsNumber, place, city, country);
                eventData.add(eventObject);
                ++rowCount;
            }
            return eventData;

        }catch (SQLException ex){
            throw ex;
        }

    }
}
