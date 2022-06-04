/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ActionClasses;

import Beans.Hotel;
import Beans.HotelCost;
import Beans.HotelDetails;
import Beans.HotelImages;
import HelperClasses.ServerHelper;
import java.io.FileInputStream;
import java.sql.*;

/**
 *
 * @author User
 */
public class HotelAction {
    private Connection con;

    public HotelAction(Connection con) {
        this.con = con;
    }
    public boolean signUp(Hotel user){
        String query = "insert into hotel_login values(null,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1,user.getManagerName());
            pstmt.setString(2,user.getManagerEmail());
            pstmt.setString(3,user.getManagerNumber());
            pstmt.setString(4,user.getHotelName());
            pstmt.setString(5,user.getHotelLocation());
            pstmt.setString(6,user.getManagerPassword());
            pstmt.setString(7, "incomplete");
            pstmt.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    public Hotel login(String email, String password) {
        Hotel user = null;

        try {

            String query = "select * from hotel_login where manager_email =? and password=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, email);
            pstmt.setString(2, password);

            ResultSet set = pstmt.executeQuery();

            if (set.next()) {
                user=new Hotel();
                user.setHotelId(set.getInt("hotel_id"));
                user.setHotelName(set.getString("hotel_name"));
                user.setHotelLocation(set.getString("hotel_location"));
                user.setManagerEmail(set.getString("manager_email"));
                user.setManagerName(set.getString("manager_name"));
                user.setManagerNumber(set.getString("manager_number"));
                user.setManagerPassword(set.getString("password"));
                user.setStatus(set.getString("status"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
    public int getIdByUser(Hotel user){
        try {

            String query = "select hotel_id from hotel_login where manager_email =?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, user.getManagerEmail());

            ResultSet set = pstmt.executeQuery();

            if (set.next()) {
                return set.getInt("hotel_id");
            }
            return -1;

        } catch (Exception e) {
          
            e.printStackTrace();
            return -1;
        }
    }
    public String getConfirmationStatus(Hotel user){
        try {
            String query = "select status from hotel_login where manager_email =?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, user.getManagerEmail());

            ResultSet set = pstmt.executeQuery();

            if (set.next()) {
                return set.getString("status");
            }
            return null;

        } catch (Exception e) {
          
            e.printStackTrace();
            return null;
        }
    }
    public static String getRoomTypes(Hotel k){
        String res="";
        if(k.getDetails().getAcSingle()>0){
            res+="AC Single, ";
        }
        if(k.getDetails().getAcDouble()>0)
                res+="AC Double, ";
        if(k.getDetails().getNonAcSingle()>0)
            res+="NonAC Single, ";
        if(k.getDetails().getNonAcDouble()>0)
            res+="NonAC Double";
        return res+".";
    }
    public static String getRoomFeatures(Hotel k){
        String res="";
        if(k.getDetails().getWifi().equalsIgnoreCase("YES")){
            res+="WIFI,";
        }
        if(k.getDetails().getBalcony().equalsIgnoreCase("YES"))
                res+="Balcony,";
        if(k.getDetails().getTv().equalsIgnoreCase("YES"))
            res+="Tv, ";
        return res+".";
    }
    public boolean submitHotelDetails(HotelDetails user){
        String query = "insert into hotel_details values(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1,user.getHotelId());
            pstmt.setInt(2,user.getAcSingle());
            pstmt.setInt(3,user.getAcDouble());
            pstmt.setInt(4,user.getNonAcSingle());
            pstmt.setInt(5,user.getNonAcDouble());
            pstmt.setString(6,user.getWifi());
            pstmt.setString(7, user.getBalcony());
            pstmt.setString(8, user.getTv());
            pstmt.executeUpdate();
            //updating the hotel as under review this line will run iff above statement work without error
            setHotelConfirmationStatus("review",user.getHotelId());
            return true;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    public void setHotelConfirmationStatus(String status,int id){
        try {

            String query = "update hotel_login set status=? where hotel_id =?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, status);
            pstmt.setInt(2,id);

            int x= pstmt.executeUpdate();

            if (x>0) {
                System.out.println("Updated status to review");
            }
            else
                System.out.println("Failed to Update status to review");

        } catch (Exception e) {
          
            e.printStackTrace();
            System.out.println("Failed to Update status to review");
        }
    }
    public void setHotelCost(HotelCost hc, int id){
        String query = "insert into hotel_cost values(?,?,?,?,?)";
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1,id);
            pstmt.setInt(2,hc.getAcSingleCost());
            pstmt.setInt(3,hc.getAcDoubleCost());
            pstmt.setInt(4,hc.getNonAcSingleCost());
            pstmt.setInt(5,hc.getNonAcDoubleCost());
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public Hotel getHotelById(int id,String filePath){
        /* I could have done this in loader as well but that wouldn't 
        make the page shareable to other people if user want
        share the page*/
        Hotel user=null;
        try {
            String query = "select * from hotel_login natural join hotel_details natural join hotel_cost where hotel_id =?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);

            ResultSet set = pstmt.executeQuery();
            user =new Hotel();
            if (set.next()) {
                //setting values for user
                user.setHotelId(set.getInt("hotel_id"));//surrogate-key provided by server
                user.setManagerName(set.getString("manager_name"));
                user.setManagerEmail(set.getString("manager_email"));
                user.setManagerNumber(set.getString("manager_number"));
                user.setHotelName(set.getString("hotel_name"));
                user.setStatus(set.getString("status"));
                //setting hotel details
                    HotelDetails details=new HotelDetails();
                    details.setHotelId(set.getInt("hotel_id"));//surrogate-key provided by server
                    details.setAcSingle(set.getInt("ac_single"));
                    details.setAcDouble(set.getInt("ac_double"));
                    details.setNonAcSingle(set.getInt("ac_single"));
                    details.setNonAcDouble(set.getInt("nonac_double"));
                    details.setWifi(set.getString("wifi"));
                    details.setBalcony(set.getString("balcony"));
                    details.setTv(set.getString("tv"));
                //setting hotel cost
                    HotelCost hc=new HotelCost();
                    hc.setAcSingleCost(set.getInt("ac_single_cost"));
                    hc.setAcDoubleCost(set.getInt("ac_double_cost"));
                    hc.setNonAcSingleCost(set.getInt("nonac_single_cost"));
                    hc.setNonAcDoubleCost(set.getInt("nonac_double_cost"));
                //setting hotelImage for single  hotel with id provided
                    HotelImages hotelImg=new ServerHelper().uploadImageToServer(filePath, id);//filepath,hotel_id
                //giving all the  values
                user.setHotelImage(hotelImg);
                user.setDetails(details);
                user.setHotelCost(hc);
                    
                return user;
            }
            else{
                System.out.println("No Values Found for hotel With Id="+id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return user;
    }
}
