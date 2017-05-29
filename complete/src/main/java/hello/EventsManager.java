package hello;

import java.util.ArrayList;
import java.sql.*;

public class EventsManager{

    public ArrayList<Event> GetEvents()throws Exception {
        ArrayList<Event> events = null;
        try {
            Database database = new Database();
            Connection conn = database.GetConnection();
            Events_ArrayList events_arrayList = new Events_ArrayList();
            events = events_arrayList.GetEvents(conn);
        }
        catch (Exception e) {
            throw e;
        }
        return events;
    }
}