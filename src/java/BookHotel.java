import ActionClasses.AdminAction;
import ActionClasses.HotelAction;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import Beans.*; 
import HelperClasses.ConnectionProvider;

public class BookHotel extends HttpServlet
{
    private static final String UPLOAD_DIR = "uploads";
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");// it tells what kind of response the server will give
        PrintWriter pw=res.getWriter();// Initializing the writing response of the server
        HttpSession ses=req.getSession();
        user2 user=(user2)ses.getAttribute("loggedInUser");
        if(user==null){
            res.sendRedirect("index.jsp");
            return;
        }
        else{
            int hotelId=Integer.parseInt(req.getParameter("hotel"));
            //setting application Path
            String applicationPath = req.getServletContext().getRealPath("");
            // constructs path of the directory to save uploaded file
            String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
            File fileSaveDir = new File(uploadFilePath);
            if (!fileSaveDir.exists()) {//create directory if directory doesn't already exists
                fileSaveDir.mkdirs();
            }

            uploadFilePath=uploadFilePath+File.separator;
            Hotel hotel=new HotelAction(ConnectionProvider.getConnection()).getHotelById(hotelId, uploadFilePath);
            String sampleImage="<img src=\""+UPLOAD_DIR+"/"+hotel.getHotelImage().getFileNameByIndex(0)+".jpg\""+" alt=\"...\" />";
            ses.setAttribute("currHotel",hotel);
            res.sendRedirect("hotel_booking.jsp");
        }
        
   }
}