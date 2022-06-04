import ActionClasses.AdminAction;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import Beans.*; 
import HelperClasses.ConnectionProvider;

public class adminLogin extends HttpServlet
{
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");// it tells what kind of response the server will give
        PrintWriter pw=res.getWriter();// Initializing the writing response of the server
        String email=req.getParameter("email");
        String pass=req.getParameter("password");
        AdminAction u=new AdminAction(ConnectionProvider.getConnection());
        admin user= u.login(email,pass);
        System.out.println(email+pass);
        if(user!=null){
            HttpSession ses=req.getSession();
            ses.setAttribute("loggedInAdminUser",user);
//            ses.setAttribute("message","Name:"+user.getAdminName()+"\nEmail: "+user.getAdminEmail());
            res.sendRedirect("admin.jsp");
        }
        else{
            HttpSession ses=req.getSession();
            ses.setAttribute("message", "Email or password is Wrong");
            res.sendRedirect("admin_login.jsp");
        }
        
        
        
   }
}