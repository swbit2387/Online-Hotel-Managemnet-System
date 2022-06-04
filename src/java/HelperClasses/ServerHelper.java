/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HelperClasses;

import Beans.HotelImages;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.*;

public class ServerHelper {
    private Connection con;
    public ServerHelper(){
        con=ConnectionProvider.getConnection();
    }
    public HotelImages uploadImageToServer(String filePath,int id)
    {
        HotelImages res=null;
        byte[] fileBytes;
        String query;
        try{
            query = "select * from hotel_images where hotel_id='"+id+"'";
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(query);
            res=new HotelImages();
            res.setHotelId(id);
            while (rs.next())
           {
                fileBytes = rs.getBytes("hotel_image");
                String fileName=rs.getString("file_name");
                OutputStream targetFile=  
                new FileOutputStream(
                     filePath+fileName+".jpg");

                targetFile.write(fileBytes);
                targetFile.flush();
                int newIndex=Character.getNumericValue(fileName.charAt(fileName.length()-1))-1;
                targetFile.close();
                res.setFileNameByIndex(newIndex, fileName);
                 
           }        
           return res;

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return res;
        }
    }
}
