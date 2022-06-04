/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

/**
 *
 * @author User
 */
public class HotelDetails {
    private int hotelId,acSingle,acDouble,nonAcSingle,nonAcDouble;
    private String wifi,balcony,tv;

    
//getter and setters
    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getAcSingle() {
        return acSingle;
    }

    public void setAcSingle(int acSingle) {
        this.acSingle = acSingle;
    }

    public int getAcDouble() {
        return acDouble;
    }

    public void setAcDouble(int acDouble) {
        this.acDouble = acDouble;
    }

    public int getNonAcSingle() {
        return nonAcSingle;
    }

    public void setNonAcSingle(int nonAcSingle) {
        this.nonAcSingle = nonAcSingle;
    }

    public int getNonAcDouble() {
        return nonAcDouble;
    }

    public void setNonAcDouble(int nonAcDouble) {
        this.nonAcDouble = nonAcDouble;
    }

    public String getBalcony() {
        return balcony;
    }

    public void setBalcony(String balcony) {
        this.balcony = balcony;
    }

    public String getTv() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }
    
//    Constructors
    public HotelDetails() { //To change body of generated methods, choose Tools | Templates.
    }

    public HotelDetails(int acSingle, int acDouble, int nonAcSingle, int nonAcDouble, String wifi, String balcony, String tv) {
        this.acSingle = acSingle;
        this.acDouble = acDouble;
        this.nonAcSingle = nonAcSingle;
        this.nonAcDouble = nonAcDouble;
        this.wifi = wifi;
        this.balcony = balcony;
        this.tv = tv;
    }
    
    
    
}
