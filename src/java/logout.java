import ActionClasses.UserAction;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import Beans.*;
import HelperClasses.ConnectionProvider;

public class logout extends HttpServlet
{
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        HttpSession ses=req.getSession();
        user2 user=(user2)ses.getAttribute("loggedInUser");
        ses.removeAttribute("loggedInHotelUser");
        ses.removeAttribute("loggedInAdminUser");
        if(user!=null){
            ses.removeAttribute("loggedInUser");
//            ses.setAttribute("message","Name: "+user.getName()+"\nEmail: "+user.getEmail()+"\nSecurity Question"+user.getSq());
            res.sendRedirect("welcomePage.jsp");
        }
        else{
            res.sendRedirect("welcomePage.jsp");
        }       
   }
}