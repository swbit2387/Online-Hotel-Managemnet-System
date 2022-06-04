/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

import java.io.InputStream;

/**
 *
 * @author User
 */
public class HotelImages {
    private int hotelId;
    private String fileName[];
    private InputStream hotelImage[];

    public HotelImages() {
        this.hotelImage=new InputStream[5];
        this.fileName=new String[5];
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String[] getFileName() {
        return fileName;
    }

    public void setFileName(String[] fileName) {
        this.fileName = fileName;
    }

    public InputStream[] getHotel_image() {
        return hotelImage;
    }

    public void setHotelImage(InputStream[] hotel_image) {
        this.hotelImage = hotel_image;
    }
    public boolean setHotelImageByIndex(InputStream fis,int index,String fName){
        
        if(index<5){
            hotelImage[index]=fis;
            fileName[index]=fName;
            return true;
        }
        return false;
    }
    public InputStream getHotelImageByIndex(int index){
        
        if(index<5){
            return hotelImage[index];
        }
        return null;
    }
    public String getFileNameByIndex(int index){
        if(index<5){
            return fileName[index];
        }
        return null;
    }
    public String setFileNameByIndex(int index,String fName){
        if(index<5){
            fileName[index]=fName;
        }
        return null;
    }
}
