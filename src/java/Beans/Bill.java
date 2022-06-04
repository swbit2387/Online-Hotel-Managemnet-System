/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

import java.util.Date;

/**
 *
 * @author User
 */
public class Bill {
    public static int calculate(Date date1, Date date2, int price) {
        long date1InMs = date1.getTime();
        long date2InMs = date2.getTime();

        // getting the diff between two dates.
        long timeDiff = 0;
        if(date1InMs > date2InMs) {
                timeDiff = date1InMs - date2InMs;
        } else {
                timeDiff = date2InMs - date1InMs;
        }

        // converting diff into days
        int daysDiff = (int) (timeDiff / (1000 * 60 * 60* 24));
        return  daysDiff;
    }
    
}
