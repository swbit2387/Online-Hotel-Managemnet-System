import ActionClasses.UserAction;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import Beans.*;
import HelperClasses.ConnectionProvider;

public class login_serv extends HttpServlet
{
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");// it tells what kind of response the server will give
        PrintWriter pw=res.getWriter();// Initializing the writing response of the server
        String email=req.getParameter("email");
        String pass=req.getParameter("password");
        UserAction u=new UserAction(ConnectionProvider.getConnection());
        user2 user=u.login(email,pass);
        if(user!=null){
            HttpSession ses=req.getSession();
            ses.setAttribute("loggedInUser",user);
//            ses.setAttribute("message","Name: "+user.getName()+"\nEmail: "+user.getEmail()+"\nSecurity Question"+user.getSq());
            res.sendRedirect("welcomePage.jsp");
        }
        else{
            HttpSession ses=req.getSession();
            ses.setAttribute("message", "Email or password is Wrong");
            res.sendRedirect("index.jsp");
        }       
   }
}