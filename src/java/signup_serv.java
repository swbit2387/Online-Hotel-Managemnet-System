import ActionClasses.UserAction;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import Beans.*;
import HelperClasses.ConnectionProvider;

public class signup_serv extends HttpServlet
{
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");// it tells what kind of response the server will give
        PrintWriter pw=res.getWriter();// Initializing the writing response of the server
        String name=req.getParameter("name");
        String email=req.getParameter("email");
        String pass=req.getParameter("password"); 
        String sq=req.getParameter("sq");
        String sa=req.getParameter("sa");
        String number=req.getParameter("mobile");
        String aadhar=req.getParameter("aadhar");
        UserAction u=new UserAction(ConnectionProvider.getConnection());
        user2 ob=new user2(email,pass,sq,sa,number,aadhar,name);
        boolean result=u.signUp(ob);
        if(result){
            System.out.print("<script>alert(\"SignUp successful\")</script>");
            HttpSession ses=req.getSession();
            ses.setAttribute("message", "SignUp successful");
            res.sendRedirect("notify.jsp");
            
        }
        else{
            System.out.print("<script>alert(\"SignUP UnSuccessful\")</script>");
            HttpSession ses=req.getSession();
            ses.setAttribute("message", "SignUp Unsuccessful");
            res.sendRedirect("notify.jsp");
        }        
   }
}