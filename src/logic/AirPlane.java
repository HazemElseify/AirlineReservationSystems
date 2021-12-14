/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

/**
 *
 * @author OmarHA
 */
public class AirPlane {
    private String PlaneIdNo;
    private String PlaneDistination;
    private String PlaneDate;
    private String SeatNum;
    private int PlaneSeatsNumber;

   
    
    public AirPlane(String PlaneIdNo, String PlaneDistination, String PlaneDate, int PlaneSeatsNumber) {
        this.PlaneIdNo = PlaneIdNo;
        this.PlaneDistination = PlaneDistination;
        this.PlaneDate = PlaneDate;
        this.PlaneSeatsNumber = PlaneSeatsNumber;
    }

    public AirPlane(String PlaneIdNo, String PlaneDistination, String PlaneDate, String SeatNum) {
        this.PlaneIdNo = PlaneIdNo;
        this.PlaneDistination = PlaneDistination;
        this.PlaneDate = PlaneDate;
        this.SeatNum = SeatNum;
    }
    
    
    public String getPlaneId() {
        return PlaneIdNo;
    }
    public String getPlaneDistination() {
        return PlaneDistination;
    }

    public String getPlaneDate() {
        return PlaneDate;
    }

    public int getPlaneSeatsNumber() {
        return PlaneSeatsNumber;
    }

    public void setPlaneId(String PlaneId) {
        this.PlaneIdNo = PlaneId;
    }

    public void setPlaneDistination(String PlaneDistination) {
        this.PlaneDistination = PlaneDistination;
    }

    public void setPlaneDate(String PlaneDate) {
        this.PlaneDate = PlaneDate;
    }

    public void setPlaneSeatsNumber(int PlaneSeatsNumber) {
        this.PlaneSeatsNumber = PlaneSeatsNumber;
    }
    
     public void setSeatNum(String SeatNum) {
        this.SeatNum = SeatNum;
    }

    public String getSeatNum() {
        return SeatNum;
    }
    
    
    
    
}
