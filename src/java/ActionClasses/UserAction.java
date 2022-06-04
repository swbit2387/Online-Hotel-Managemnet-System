/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ActionClasses;
import Beans.user2;
import java.sql.*;
/**
 *
 * @author User
 */
public class UserAction {
    private Connection con;

    public UserAction(Connection con) {
        this.con = con;
    }
    public boolean signUp(user2 user) {
        boolean f;
        try {
            String q1 ;
            if(user.getMobile()=="null" && user.getAadhar()=="null"){
                q1="insert into user_login values('"+user.getName()+"','"+user.getPass()+"','"+user.getEmail()+"',"+user.getMobile()+","+user.getAadhar()+",'"+user.getSq()+"','"+user.getSa()+"')";
            }
            else if(user.getMobile()=="null"){
                q1="insert into user_login values('"+user.getName()+"','"+user.getPass()+"','"+user.getEmail()+"',"+user.getMobile()+",'"+user.getAadhar()+"','"+user.getSq()+"','"+user.getSa()+"')";
            }
            else if(user.getAadhar()=="null"){
                q1="insert into user_login values('"+user.getName()+"','"+user.getPass()+"','"+user.getEmail()+"','"+user.getMobile()+"',"+user.getAadhar()+",'"+user.getSq()+"','"+user.getSa()+"')";
            }
            else
                q1="insert into user_login values('"+user.getName()+"','"+user.getPass()+"','"+user.getEmail()+"','"+user.getMobile()+"','"+user.getAadhar()+"','"+user.getSq()+"','"+user.getSa()+"')";
            int x=con.createStatement().executeUpdate(q1);
            if(x>0)
            {
                f=true;
            }
            else
            {
                f=false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            f=false;
        }
        return f;
    }
    public user2 login(String email, String password) {
        user2 user = null;

        try {

            String query = "select * from user_login where email =? and password=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, email);
            pstmt.setString(2, password);

            ResultSet set = pstmt.executeQuery();

            if (set.next()) {
                user = new user2();                
                user.setName(set.getString("name"));
                user.setEmail(set.getString("email"));
                user.setPass(set.getString("password"));
                user.setAadhar(set.getString("aadhar"));
                user.setMobile(set.getString("mobile_number"));
                user.setSq(set.getString("security_question"));
                user.setSa(set.getString("security_answer"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
    public user2 getUserByEmail(String email) {
        user2 user = null;

        try {

            String query = "select * from user_login where email =?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, email);
            ResultSet set = pstmt.executeQuery();

            if (set.next()) {
                user = new user2();                
                user.setName(set.getString("name"));
                user.setEmail(set.getString("email"));
                user.setPass(set.getString("password"));
                user.setAadhar(set.getString("aadhar"));
                user.setMobile(set.getString("mobile_number"));
                user.setSq(set.getString("security_question"));
                user.setSa(set.getString("security_answer"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
    public boolean ChangePassword(String email,String newPassword){
        String q1="update user_login set password='"+newPassword+"' where email='"+email+"'";
        
        try
        {
            Statement stmt=this.con.createStatement();
            int x=stmt.executeUpdate(q1);
            if(x>0)
               return true;
            else
                return false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
