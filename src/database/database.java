/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;
import java.sql.*;
import java.util.ArrayList;
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
           statement.setString(0, planeid);
           ResultSet resultSet=statement.executeQuery();
           while (resultSet.next()) {
               arrayList.add(resultSet.getString("seatno"));
          }
           return arrayList;
      }
   
}
