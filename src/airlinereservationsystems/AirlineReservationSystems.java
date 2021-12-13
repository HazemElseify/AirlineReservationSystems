package airlinereservationsystems;
import java.sql.SQLException;
import logic.Admin;
import logic.AirPlane;
import logic.customer;
import database.database;
import gui.Customer.Booking;
import gui.Customer.Main_Customer;
import java.util.ArrayList;

public class AirlineReservationSystems {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ArrayList<String> planeid = null;
        
        
        customer a=new customer("a", "Password", "email", "a", 0);
 
        Main_Customer c=new Main_Customer("a");
        c.show(); 
       
    }
}
