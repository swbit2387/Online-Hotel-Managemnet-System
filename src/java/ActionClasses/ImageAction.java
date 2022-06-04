/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ActionClasses;

import Beans.Hotel;
import Beans.HotelImages;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

/**
 *
 * @author User
 */
public class ImageAction {
    private Connection con;

    public ImageAction(Connection conn) {
        this.con = conn;
    }
    public boolean saveImagesToDatabase(int id,HotelImages hotelImg) throws IOException{//to save file to Database
        
        for(int i=0;i<5;i++){
            if(hotelImg.getHotelImageByIndex(i)!=null){
                String query = "insert into hotel_images values(?,?,?)";
                try {
                    PreparedStatement pstmt = con.prepareStatement(query);
                    pstmt.setInt(1,id);
                    pstmt.setString(2,hotelImg.getFileNameByIndex(i));
                    pstmt.setBinaryStream(3, hotelImg.getHotelImageByIndex(i),hotelImg.getHotelImageByIndex(i).available());
                    pstmt.executeUpdate();

                } catch (SQLException ex) {
                    System.out.print("Failed to Upload");
                    ex.printStackTrace();
                    return false;
                }
            }
            
        }
        return true;
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
    public InputStream[] getImagesById(int id){
        InputStream is[]=new InputStream[5];
        try {

            String query = "select * from hotel_images where id =?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet set = pstmt.executeQuery();

            if (set.next()) {
                
            }

        } catch (Exception e) {
          
            e.printStackTrace();
        }
        return is;
    }
    
}
