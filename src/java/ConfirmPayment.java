import ActionClasses.AdminAction;
import ActionClasses.HotelAction;
import ActionClasses.HotelBookingAction;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import Beans.*; 
import HelperClasses.ConnectionProvider;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfirmPayment extends HttpServlet
{
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");// it tells what kind of response the server will give
        PrintWriter pw=res.getWriter();// Initializing the writing response of the server
        HttpSession ses=req.getSession();
        user2 user=(user2)ses.getAttribute("loggedInUser");
        Hotel hotel=(Hotel)ses.getAttribute("currHotel");
        HotelBooking hb=(HotelBooking)ses.getAttribute("hotelBook");
        if(user==null || hotel==null || hb==null){
            System.out.println("Hotel or user is null");
            res.sendRedirect("welcomePage.jsp");
            return;
        }
        else{
            if(new HotelBookingAction().bookHotel(hb)){
                ses.setAttribute("message", "Hotel Booked Successully");
            }
            else{
                ses.setAttribute("message", "Failed to book Hotel");
            }
            res.sendRedirect("notify.jsp");
        }
        
   }
}