import ActionClasses.AdminAction;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import Beans.admin;
import HelperClasses.ConnectionProvider;

public class adminSignup extends HttpServlet
{
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");// it tells what kind of response the server will give
        PrintWriter pw=res.getWriter();// Initializing the writing response of the server
        String adminEmail=req.getParameter("adminEmail");
        String adminPassword=req.getParameter("adminPassword");
        String adminAadhar=req.getParameter("adminAadhar");
        String adminName=req.getParameter("adminName");
        
        if(adminAadhar.length()!=16){
            HttpSession ses=req.getSession();
            ses.setAttribute("message", "Invalid Aadhar number");
            res.sendRedirect("admin_signup.jsp");
            return;
        }
        AdminAction u=new AdminAction(ConnectionProvider.getConnection());
        admin user=new admin(adminEmail,adminPassword,adminAadhar,adminName);
        boolean result=u.signUp(user);
        if(result){
            System.out.print("<script>alert(\"SignUp successful\")</script>");
            HttpSession ses=req.getSession();
            ses.setAttribute("message", "HotelSignUp successful");
            res.sendRedirect("notify.jsp");
            
        }
        else{
            System.out.print("<script>alert(\"SignUP UnSuccessful\")</script>");
            HttpSession ses=req.getSession();
            ses.setAttribute("message", "You already have an account with that email");
            res.sendRedirect("admin_signup.jsp");
        }        
   }
}