import ActionClasses.HotelAction;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import Beans.Hotel;
import HelperClasses.ConnectionProvider;

public class hotel_signup extends HttpServlet
{
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");// it tells what kind of response the server will give
        PrintWriter pw=res.getWriter();// Initializing the writing response of the server
        String mgrName=req.getParameter("mgrName");
        String mgrEmail=req.getParameter("mgrEmail");
        String mgrPassword=req.getParameter("mgrPassword"); 
        String hotelName=req.getParameter("hotelName");
        String hotelLoc=req.getParameter("hotelLoc");
        String mgrNumber=req.getParameter("mgrNumber");
        if(mgrNumber.length()!=10){
            HttpSession ses=req.getSession();
            ses.setAttribute("message", "Invalid mobile number");
            res.sendRedirect("hotel_signup.jsp");
            return;
        }
        HotelAction u=new HotelAction(ConnectionProvider.getConnection());
        Hotel user=new Hotel(mgrName,mgrEmail,mgrNumber,hotelName,hotelLoc,mgrPassword);
        boolean result=u.signUp(user);
        if(result){
            System.out.print("<script>alert(\"SignUp successful\")</script>");
            HttpSession ses=req.getSession();
            ses.setAttribute("message", "HotelSignUp successful login for proceeding further");
            res.sendRedirect("notify.jsp");
            
        }
        else{
            System.out.print("<script>alert(\"SignUP UnSuccessful\")</script>");
            HttpSession ses=req.getSession();
            ses.setAttribute("message", "You already have an account with that email");
            res.sendRedirect("hotel_signup.jsp");
        }        
   }
}