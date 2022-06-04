/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ActionClasses;

import Beans.admin;
import java.sql.*;

public class AdminAction {
    private Connection con=null;

    public AdminAction(Connection con) {
        this.con = con;
    }
    public boolean signUp(admin user){
        String query = "insert into admin_login values(null,?,?,?,?)";
        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1,user.getAdminEmail());
            pstmt.setString(2,user.getAdminPassword());
            pstmt.setString(3,user.getAdminAadhar());
            pstmt.setString(4,user.getAdminName());
            pstmt.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    public admin login(String email,String password){
        admin user = null;

        try {

            String query = "select * from admin_login where admin_email =? and admin_password=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, email);
            pstmt.setString(2, password);

            ResultSet set = pstmt.executeQuery();

            if (set.next()) {
                user=new admin();
                user.setAdminEmail(set.getString("admin_email"));
                user.setAdminAadhar(set.getString("admin_aadhar"));
                user.setAdminPassword(set.getString("admin_password"));
                user.setAdminName(set.getString("admin_name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
        
    }
    public boolean accept(String hotelId){
        String query="update hotel_login set status='true' where hotel_id="+hotelId;
        try {
            Statement stmt=con.createStatement();
            stmt.executeUpdate(query);
            return true;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    public boolean deny(String hotelId){
        String query="update hotel_login set status='denied' where hotel_id="+hotelId;
        try {
            Statement stmt=con.createStatement();
            stmt.executeUpdate(query);
            return true;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }  
    }
    
}
