/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;
import java.sql.*;
import java.util.ArrayList;
import logic.AirPlane;
import logic.customer;
/**
 *
 * @author Hazem Elseify
 */
public class database {
   public static String username="root";
   public static String password="1234";
   public static String url="jdbc:mysql://localhost:3306/ars";
   public static String planeid;
   
   public static Connection connect() throws SQLException{
        Connection con=DriverManager.getConnection(url,username,password);
       return con;
   }
   public static ArrayList<String>getSeatslist(ArrayList<String> arrayList) throws SQLException{
           Connection con =connect();
           PreparedStatement statement=con.prepareStatement("SELECT seatno FROM seats WHERE planeid = ?");
           statement.setString(1, planeid);
           ResultSet resultSet=statement.executeQuery();
           while (resultSet.next()) {
               arrayList.add(resultSet.getString("seatno"));
          }
           return arrayList;
      }
   public static void PushPlane(AirPlane p1) throws SQLException{
       Connection con=connect();
       PreparedStatement statement=con.prepareStatement("insert into airplane (id,dest,date,seatsno)"
        + " values (?, ?, ?, ?)");
       statement.setString(1, p1.getPlaneId());
       statement.setString(2,p1.getPlaneDistination());
       statement.setString(3,p1.getPlaneDate());
       statement.setInt(4,p1.getPlaneSeatsNumber());
       statement.execute();
   }
   public static boolean GetPlaneId(String PlaneId) throws SQLException{
       Connection con =connect();
           PreparedStatement statement=con.prepareStatement("SELECT * FROM airplane WHERE id = ?");
           statement.setString(1, PlaneId);
           ResultSet resultSet=statement.executeQuery();
           return resultSet.next();
   }
   public static void PushPlaneSeat(String PlaneId,String SeatNo) throws SQLException{
       Connection con=connect();
       PreparedStatement statement=con.prepareStatement("insert into seats (planeid,seatno,csusername)"
        + " values (?, ?, ?)");
       statement.setString(1, PlaneId);
       statement.setString(2,SeatNo);
       statement.setString(3,"0");
       statement.execute();
   }
   public static void DeleteAirplane(String PlaneId) throws SQLException{
       Connection con=connect();
       PreparedStatement statement=con.prepareStatement("delete from seats where planeid = ?");
       statement.setString(1,PlaneId);
       statement.execute();
       statement=con.prepareStatement("delete from airplane where id = ?");
       statement.setString(1,PlaneId);
       statement.execute();
   }
   
   
   
   ///////////////////////////////////////// Abdallah /////////////////////////////////////////////////
   
    public static ArrayList<AirPlane> planeid_Customer(customer a) throws ClassNotFoundException, SQLException{
        Connection connect; 
        connect = connect();
        ArrayList<AirPlane> planeid = new ArrayList<AirPlane>(); 
        AirPlane s= null;
        if(connect!=null){  
            String Sql="SELECT * FROM seats INNER JOIN airplane ON seats.planeid = airplane.id WHERE seats.csusername='"+a.getUsernmae()+"' " ;
            Statement stmt= connect.createStatement();
            ResultSet rs =stmt.executeQuery(Sql);
            while (rs.next()) {
                s=new AirPlane( rs.getString("id") , rs.getString("dest") , rs.getString("date") , rs.getInt("seatno"));
                planeid.add(s); 
             }
            return planeid;
        }
        else return null;
    }   
    public static ArrayList<AirPlane> date_plane(String a) throws ClassNotFoundException, SQLException{
        Connection connect; 
        connect = connect();
        ArrayList<AirPlane> planeid = new ArrayList<AirPlane>(); 
        AirPlane s= null;
        if(connect!=null){  
            String Sql="SELECT * FROM airplane WHERE dest = '"+a +"' " ;
            Statement stmt= connect.createStatement();
            ResultSet rs =stmt.executeQuery(Sql);
            while (rs.next()) {
                s=new AirPlane( rs.getString("id") , rs.getString("date") );
                planeid.add(s); 
             }
            return planeid;
        }
        else return null;
    }  
   
    
   
   
   
   ////////////////////////////////////////////Abdallah/////////////////////////////////////////////////
   
}
