import ActionClasses.UserAction;
import Beans.user2;
import HelperClasses.ConnectionProvider;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ChangePassword extends HttpServlet
{
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");// it tells what kind of response the server will give
        PrintWriter pw=res.getWriter();// Initializing the writing response of the server
        HttpSession ses=req.getSession();
        user2 currUser=(user2)ses.getAttribute("Forgot_user");
        String email=currUser.getEmail();
        email=email.trim();
        String newPassword=req.getParameter("newPassword");
        newPassword=newPassword.trim();
        UserAction action=new UserAction(ConnectionProvider.getConnection());
        ses.removeAttribute("Forgot_user");
        if(action.ChangePassword(email, newPassword)){
            ses.setAttribute("message","Password Changed Succefully");
            res.sendRedirect("notify.jsp");
            
        }
        else{
            ses.setAttribute("message", "Failed to change Password");
            res.sendRedirect("notify.jsp");
        }
   }
}