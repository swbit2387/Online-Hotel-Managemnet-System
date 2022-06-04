import ActionClasses.AdminAction;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import Beans.*; 
import HelperClasses.ConnectionProvider;

public class AcceptDeny extends HttpServlet
{
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");// it tells what kind of response the server will give
        String hotelId=req.getParameter("ActionButton");
        char action=hotelId.charAt(0);
        hotelId=hotelId.substring(1);
        AdminAction admin=new AdminAction(ConnectionProvider.getConnection());
        HttpSession ses=req.getSession();
        if(action=='A'){
            if(!admin.accept(hotelId)){
                ses.setAttribute("message", "Internal Error");
            }
            res.sendRedirect("admin.jsp");
        }
        else{
            if(!admin.deny(hotelId)){
                ses.setAttribute("message", "Internal Error");
            }
            res.sendRedirect("admin.jsp");
        }
        
   }
}