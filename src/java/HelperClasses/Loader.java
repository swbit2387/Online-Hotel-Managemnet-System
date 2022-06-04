/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HelperClasses;

import Beans.Hotel;
import Beans.HotelBooking;
import Beans.HotelCost;
import Beans.HotelDetails;
import Beans.HotelImages;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Loader {
    private Connection con;
    public Loader(){
        this.con=ConnectionProvider.getConnection();
    }
    public ArrayList<Hotel> getHotels(String filePath){
        ArrayList<Hotel> result=new ArrayList<>();
        String q="select * from hotel_details natural join hotel_login where status='true'";
        try {
            //running the query
            
            ResultSet rs=con.createStatement().executeQuery(q);
            while(rs.next()){
                Hotel temp=new Hotel();
                //creating HotelObject
                temp.setHotelId(rs.getInt("hotel_id"));
                temp.setManagerName(rs.getString("manager_name"));
                temp.setManagerEmail(rs.getString("manager_email"));
                temp.setManagerNumber(rs.getString("manager_number"));
                temp.setHotelName(rs.getString("hotel_name"));
                temp.setHotelLocation(rs.getString("hotel_location"));
                temp.setManagerPassword("manager_password");
                temp.setStatus(rs.getString("status"));
                //setting hotel details
                    HotelDetails details=new HotelDetails();
                    details.setHotelId(rs.getInt("hotel_id"));//surrogate-key provided by server
                    details.setAcSingle(rs.getInt("ac_single"));
                    details.setAcDouble(rs.getInt("ac_double"));
                    details.setNonAcSingle(rs.getInt("ac_single"));
                    details.setNonAcDouble(rs.getInt("nonac_double"));
                    details.setWifi(rs.getString("wifi"));
                    details.setBalcony(rs.getString("balcony"));
                    details.setTv(rs.getString("tv"));
                //setting hotel Images and uploadting to server
                    HotelImages hotelImg=new ServerHelper().uploadImageToServer(filePath, temp.getHotelId());//filepath,hotel_id
                    
                temp.setHotelImage(hotelImg);
                temp.setDetails(details);
                result.add(temp);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public ArrayList<Hotel> getPendingHotel(){
        ArrayList<Hotel> result=new ArrayList<>();
        String q="select * from hotel_login where status='review'";
        try {
            //running the query
            
            ResultSet rs=con.createStatement().executeQuery(q);
            while(rs.next()){
                Hotel temp=new Hotel();
                //creating HotelObject
                temp.setHotelId(rs.getInt("hotel_id"));
                temp.setManagerName(rs.getString("manager_name"));
                temp.setManagerEmail(rs.getString("manager_email"));
                temp.setManagerNumber(rs.getString("manager_number"));
                temp.setHotelName(rs.getString("hotel_name"));
                temp.setHotelLocation(rs.getString("hotel_location"));
                temp.setManagerPassword("manager_password");
                temp.setStatus(rs.getString("status"));
                result.add(temp);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public ArrayList<HotelBooking> getMyBookings(String email){
        ArrayList<HotelBooking> result=new ArrayList<>();
        String q="select * from hotel_bookings where user_email='"+email+"'";
        try {
            //running the query
            ResultSet rs=con.createStatement().executeQuery(q);
            while(rs.next()){
                HotelBooking temp=new HotelBooking();
                //creating HotelObject
                temp.setUserEmail(email);
                temp.setBookedHotelName(rs.getString("BOOKED_HOTEL_NAME"));
                temp.setRoomType(rs.getString("ROOM_TYPE"));
                temp.setNoOfPeople(rs.getInt("NO_OF_PEOPLE"));
                temp.setBookingDate(rs.getDate("BOOKING_DATE"));
                temp.setCheckInDate(rs.getDate("CHECK_IN_DATE"));
                temp.setCheckOutDate(rs.getDate("CHECK_OUT_DATE"));
                temp.setAmountPaid(rs.getInt("AMOUNT_PAID"));
                temp.setBookedHotelId(rs.getInt("BOOKED_HOTEL_ID"));
                result.add(temp);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
