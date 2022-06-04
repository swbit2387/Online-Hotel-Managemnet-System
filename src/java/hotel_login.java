import ActionClasses.HotelAction;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import Beans.*; 
import HelperClasses.ConnectionProvider;

public class hotel_login extends HttpServlet
{
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");// it tells what kind of response the server will give
        PrintWriter pw=res.getWriter();// Initializing the writing response of the server
        String email=req.getParameter("email");
        String pass=req.getParameter("password");
        HotelAction u=new HotelAction(ConnectionProvider.getConnection());
        Hotel user= u.login(email,pass);
        if(user!=null){
            HttpSession ses=req.getSession();
            user.setHotelId(u.getIdByUser(user));
            ses.setAttribute("loggedInHotelUser",user);
            //rest tasks pending
            res.sendRedirect("manageHotel.jsp");
        }
        else{
            HttpSession ses=req.getSession();
            ses.setAttribute("message", "Email or password is Wrong");
            res.sendRedirect("hotel_login.jsp");
        }     
   }
}