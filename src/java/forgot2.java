import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import Beans.*;

public class forgot2 extends HttpServlet
{
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");// it tells what kind of response the server will give
        PrintWriter pw=res.getWriter();// Initializing the writing response of the server
        HttpSession ses=req.getSession(false);
        if(ses==null){
            res.sendRedirect("forgot.html");
            return;
        }
        user2 currUser=(user2)ses.getAttribute("Forgot_user");
        String originalAnswer=currUser.getSa();
        String userAnswer=req.getParameter("userInputAnswer");
        originalAnswer=originalAnswer.trim();
        userAnswer=userAnswer.trim();
        if(originalAnswer==null){
            ses.invalidate();
            res.sendRedirect("forgot.html");
            return;
        }
        String result="NO";
        
        if(originalAnswer.equals(userAnswer)){
            result="YES";
        }
        if(result=="YES"){
            ses.setAttribute("pass","true");
            res.sendRedirect("ChangePassword.jsp");
        }
        else{
            ses.setAttribute("message","Wrong Security Anwer");
            ses.removeAttribute("Forgot_user");
            res.sendRedirect("notify.jsp");
        }
        
        
   }
}