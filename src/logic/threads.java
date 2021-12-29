package logic;

import database.database;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class threads implements Runnable{
    ArrayList<String>seats;
    String username;
    @Override
    
    public void run() {
        try {
            database.updateAll(username,seats);
                    } catch (SQLException ex) {
            Logger.getLogger(threads.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public threads(String username,ArrayList<String>seats) {
        this.username = username;
        this.seats=seats;
    }
    
}
