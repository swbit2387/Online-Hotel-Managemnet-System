import ActionClasses.AdminAction;
import ActionClasses.HotelAction;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import Beans.*; 
import HelperClasses.ConnectionProvider;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class viewBillSummary extends HttpServlet
{
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");// it tells what kind of response the server will give
        PrintWriter pw=res.getWriter();// Initializing the writing response of the server
        HttpSession ses=req.getSession();
        user2 user=(user2)ses.getAttribute("loggedInUser");
        Hotel hotel=(Hotel)ses.getAttribute("currHotel");
        if(user==null || hotel==null){
            System.out.println("Hotel or user is null");
            res.sendRedirect("welcomePage.jsp");
            return;
        }
        else{
            try {
                HotelBooking hb=new HotelBooking();
                hb.setUserEmail(user.getEmail());
                hb.setBookedHotelName(hotel.getHotelName());
                String temp[]=req.getParameter("roomType").split(",");
                hb.setRoomType(temp[0]);
                hb.setNoOfPeople(Integer.parseInt(req.getParameter("noOFPeople")));
                //getting dates
                java.util.Date bookingDate = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("bookingDate"));
                java.util.Date checkInDate = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("checkInDate"));
                java.util.Date checkOutDate = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("checkOutDate"));
                
                hb.setBookingDate(new java.sql.Date(bookingDate.getTime()));
                hb.setCheckInDate(new java.sql.Date(checkInDate.getTime()));
                hb.setCheckOutDate(new java.sql.Date(checkOutDate.getTime()));
                
                hb.setNoOfDays(Bill.calculate(checkInDate,checkOutDate,Integer.parseInt(temp[1])));
                hb.setPricePerDay(Integer.parseInt(temp[1]));
                hb.setBookedHotelId(hotel.getHotelId());
                hb.setAmountPaid(hb.getNoOfDays()*Integer.parseInt(temp[1]));
                
                ses.setAttribute("hotelBook",hb);
                res.sendRedirect("bill.jsp");
            } catch (ParseException ex) {
                Logger.getLogger(viewBillSummary.class.getName()).log(Level.SEVERE, null, ex);
            }

            
        }
        
   }
}