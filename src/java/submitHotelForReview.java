import ActionClasses.HotelAction;
import ActionClasses.ImageAction;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import Beans.Hotel;
import Beans.HotelCost;
import Beans.HotelDetails;
import Beans.HotelImages;
import HelperClasses.ConnectionProvider;
import javax.servlet.annotation.MultipartConfig;
@MultipartConfig
public class submitHotelForReview extends HttpServlet
{
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");// it tells what kind of response the server will give
        PrintWriter pw=res.getWriter();// Initializing the writing response of the server
        //taking hotel details
        int acSingle=Integer.parseInt(req.getParameter("acSingle"));
        int acDouble=Integer.parseInt(req.getParameter("acDouble"));
        int nonacDouble=Integer.parseInt(req.getParameter("nonacDouble"));
        int nonacSingle=Integer.parseInt(req.getParameter("nonacSingle"));
        
        int PriceAcSingle=Integer.parseInt(req.getParameter("PriceAcSingle"));
        int PriceAcDouble=Integer.parseInt(req.getParameter("PriceAcDouble"));
        int PriceNonacDouble=Integer.parseInt(req.getParameter("PriceNonacDouble"));
        int PriceNonacSingle=Integer.parseInt(req.getParameter("PriceNonacSingle"));
        
        String wifi=req.getParameter("wifi");
        String balcony=req.getParameter("balcony");
        String tv=req.getParameter("tv");
        
        
        //taking Images
        Part image1=req.getPart("image1");
        Part image2=req.getPart("image2");
        Part image3=req.getPart("image3");
        Part image4=req.getPart("image4");
        Part image5=req.getPart("image5");
        
        
        HttpSession ses=req.getSession();
        //assigning hotel details
        HotelAction u=new HotelAction(ConnectionProvider.getConnection());
        Hotel user=(Hotel)ses.getAttribute("loggedInHotelUser");
        HotelDetails hd=new HotelDetails(acSingle, acDouble, nonacSingle, nonacDouble, wifi, balcony, tv);
        hd.setHotelId(user.getHotelId());
        user.setDetails(hd);
        boolean result=u.submitHotelDetails(hd);
        
        //assigning hotel cost
        HotelCost hc=new HotelCost(PriceAcSingle,PriceAcDouble,PriceNonacSingle,PriceNonacDouble);
        u.setHotelCost(hc, user.getHotelId()); // setting hotel id for inserting hotelcost
        
        //assigning images
        HotelImages hotelImg=new HotelImages();
        hotelImg.setHotelId(user.getHotelId());
        ImageAction imgAct=new ImageAction(ConnectionProvider.getConnection());
        if(image1.getSize()>1){
            InputStream fis=image1.getInputStream();
            hotelImg.setHotelImageByIndex(fis, 0,"Hotel"+user.getHotelId()+""+1);
        }
        if(image2.getSize()>1){
            InputStream fis=image2.getInputStream();
            hotelImg.setHotelImageByIndex(fis, 1,"Hotel"+user.getHotelId()+""+2);
        }
        if(image3.getSize()>1){
            InputStream fis=image3.getInputStream();
            hotelImg.setHotelImageByIndex(fis, 2,"Hotel"+user.getHotelId()+""+3);
        }
        if(image4.getSize()>1){
            InputStream fis=image4.getInputStream();
            hotelImg.setHotelImageByIndex(fis, 3,"Hotel"+user.getHotelId()+""+4);
        }
        if(image5.getSize()>1){
            InputStream fis=image5.getInputStream();
            hotelImg.setHotelImageByIndex(fis, 4,"Hotel"+user.getHotelId()+""+5);
        }
        if(imgAct.saveImagesToDatabase(user.getHotelId(), hotelImg)){
            System.out.print("Images Inserted Successfully");
        }
        else{
            System.out.print("Failed to Insert Hotel Images");
        }
        
        
        
        
        if(result){
            System.out.print("<script>alert(\"SignUp successful\")</script>");
            //loggin out for now....after completing hotel details
            ses.removeAttribute("loggedInHotelUser");
            ses.setAttribute("message", "HotelDetails Updated successful login for proceeding further");
            res.sendRedirect("notify.jsp");
            
        }
        else{
            System.out.print("<script>alert(\"SignUP UnSuccessful\")</script>");
            //loggin out for now....after completing hotel details
            ses.removeAttribute("loggedInHotelUser");
            ses.setAttribute("message", "Failed to update hotel Details");
            res.sendRedirect("hotel_signup.jsp");
        }        
   }
}