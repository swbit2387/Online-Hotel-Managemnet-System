/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HelperClasses;

import java.sql.*;

/**
 *
 * @author User
 */
public class ConnectionProvider {
     private static Connection con;

    public static Connection getConnection() {
        try {

            if (con == null) {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","niraj");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
    
}
