/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ActionClasses;

import Beans.HotelBooking;
import HelperClasses.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class HotelBookingAction {
    Connection con=null;
    public HotelBookingAction(){
        con=ConnectionProvider.getConnection();
    }
    public boolean bookHotel(HotelBooking hb){
        String query="insert into hotel_bookings values(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1,hb.getUserEmail());
            pstmt.setString(2,hb.getBookedHotelName());
            pstmt.setString(3,hb.getRoomType());
            pstmt.setInt(4,hb.getNoOfPeople());
            pstmt.setDate(5,hb.getBookingDate());
            pstmt.setDate(6,hb.getCheckInDate());
            pstmt.setDate(7, hb.getCheckOutDate());
            pstmt.setInt(8,hb.getAmountPaid());
            pstmt.setInt(9,hb.getBookedHotelId());
            pstmt.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }    
}
