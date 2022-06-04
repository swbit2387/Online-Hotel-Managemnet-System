/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

/**
 *
 * @author User
 */
public class Hotel {
    private String managerName,managerEmail,managerNumber,hotelName,hotelLocation,managerPassword,status;
    private HotelDetails details;
    private int hotelId;
    private HotelImages hotelImage;
    private HotelCost hotelCost;

    public HotelCost getHotelCost() {
        return hotelCost;
    }

    public void setHotelCost(HotelCost hotelCost) {
        this.hotelCost = hotelCost;
    }

    public HotelImages getHotelImage() {
        return hotelImage;
    }

    public void setHotelImage(HotelImages hotelImage) {
        this.hotelImage = hotelImage;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public HotelDetails getDetails() {
        return details;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public void setDetails(HotelDetails details) {
        this.details = details;
    }
    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail;
    }

    public String getManagerNumber() {
        return managerNumber;
    }

    public void setManagerNumber(String managerNumber) {
        this.managerNumber = managerNumber;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelLocation() {
        return hotelLocation;
    }

    public void setHotelLocation(String hotelLocation) {
        this.hotelLocation = hotelLocation;
    }

    public Hotel(String managerName, String managerEmail, String managerNumber, String hotelName, String hotelLocation, String managerPassword) {
        this.managerName = managerName;
        this.managerEmail = managerEmail;
        this.managerNumber = managerNumber;
        this.hotelName = hotelName;
        this.hotelLocation = hotelLocation;
        this.managerPassword = managerPassword;
        this.status="incomplete";
        this.details=null;
    }
    public Hotel(){
        
    }

        
}
