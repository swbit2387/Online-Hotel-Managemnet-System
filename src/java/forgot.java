import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import Beans.*;
import HelperClasses.ConnectionProvider;
import ActionClasses.UserAction;

public class forgot extends HttpServlet
{
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");// it tells what kind of response the server will give
        PrintWriter pw=res.getWriter();// Initializing the writing response of the server
        String email=req.getParameter("email");
        UserAction action=new UserAction(ConnectionProvider.getConnection());
        user2 ob =action.getUserByEmail(email);
        if(ob!=null){
            HttpSession ses=req.getSession();
            ses.setAttribute("Forgot_user",ob);
            ses.setAttribute("pass","false");
            res.sendRedirect("forgot1.jsp");
        }
        else{
            HttpSession ses=req.getSession();
            ses.setAttribute("message","Email Does not exists");
            res.sendRedirect("notify.jsp");
            pw.print("<script>alert(\"Email Does not exists\")</script>");
        }       
   }
}