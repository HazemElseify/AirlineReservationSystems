/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import database.database;
import java.sql.SQLException;

/**
 *
 * @author OmarHA
 */
public class Admin {
    private String usernmae;
    private String Password;
    public String getUsernmae() {
        return usernmae;
    }

    public String getPassword() {
        return Password;
    }

    public void setUsernmae(String usernmae) {
        this.usernmae = usernmae;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    public void AddPlane(AirPlane P1) throws SQLException{
        database.PushPlane(P1);
        for(int i=1;i<=29;++i){
            if(i==4||(i>10&&i<17)){
                continue;
            }
            String s=Integer.toString(i);
            if(s.length()<2){
                s='0'+s;
            }
            for(char c='A';c<='F';++c){
                if((s.equals("01")||s.equals("02")||s.equals("03"))&&(c=='C'||c=='D')){
                    continue;
                }
                if((s.equals("17"))&&(c=='A'||c=='F')){
                    continue;
                }
                String res=s+'-'+c;
                database.PushPlaneSeat(P1.getPlaneId(), res);
            }
        }
    }
    public boolean CheckExist(String PlaneId) throws SQLException{
        return database.GetPlaneId(PlaneId);
    }
    public void RemovePlane(String PlaneId) throws SQLException{
        database.DeleteAirplane(PlaneId);
    }
}
