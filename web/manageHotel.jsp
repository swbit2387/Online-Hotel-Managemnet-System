<%-- 
    Document   : manageHotel
    Created on : Apr 5, 2022, 11:50:57 PM
    Author     : User
--%>

<%@page import="Beans.Hotel"%>
<%@page import="ActionClasses.HotelAction"%>
<%@page import="HelperClasses.ConnectionProvider"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
  <head>
    <title>MANAGE HOTEL</title>
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
      integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
      crossorigin="anonymous"
    />

    <link rel="stylesheet" href="css/hotel.css" />
    <link rel="stylesheet" href="css/style.css" />
  </head>
  <body>
      
      
      
      <%!
          Hotel user;
      %>
      <%
          user=(Hotel)session.getAttribute("loggedInHotelUser");
          if(user==null){
                response.sendRedirect("hotel_login.jsp");
                return;
          }
                
          HotelAction ac=new HotelAction(ConnectionProvider.getConnection());
          String status=ac.getConfirmationStatus(user);
          if(status.equalsIgnoreCase("true")){
                session.removeAttribute("loggedInHotelUser");
                session.setAttribute("message", "Your hotel is up and running");
                response.sendRedirect("notify.jsp");
                return;
          }
          else if(status.equalsIgnoreCase("denied")){
                session.removeAttribute("loggedInHotelUser");
                session.setAttribute("message", "Your hotel Request has been denied please try again");
                response.sendRedirect("notify.jsp");
                return;
          }
          else if(status.equalsIgnoreCase("review")){
                session.removeAttribute("loggedInHotelUser");
                session.setAttribute("message", "Your hotel is under review Kindly wait");
                response.sendRedirect("notify.jsp");
                return;
          }     
      %>
    <div class="bg-img">
        
        <!--navabar-->
       <nav style="position: relative; z-index: 9999">
            <a class="logo-img"><img src="css/whiteInfinity.png" alt="LOGO"/></a>
        <a class="logo" href="welcomePage.jsp">INFINITY</a>
        <div class="nav-links" id="navLinks">
          <span
            class="fa fa-times"
            onclick="hideMenu()"
            aria-hidden="true"
          ></span>
          <ul>
            <li><a href="welcomePage.jsp">HOME</a></li>
            <li><a href="about.jsp">ABOUT</a></li>
            <li><a href="careers.jsp">CAREER</a></li>
            <li><a href="hotel_login.jsp">BUSINESS</a></li>
            <li><a href="index.jsp">USER LOGIN</a></li>
          </ul>
        </div>
        <span class="fa fa-bars" onclick="showMenu()" aria-hidden="true"></span>
      </nav>
        
        <!--navbar ends-->
        
      <div class="content signup">
        <header>Manage Your Hotel</header>

        <form class="form" action="submitHotelForReview" method="post" enctype='multipart/form-data'>
          <div class="container">
            <div class="row">
              <div class="">
                <div class="field">
                  <span class="fa fa-id-card"></span>
                  <input
                    type="text"
                    required
                    placeholder="<%=user.getHotelId()%>"
                    name="hotelId"
                    disabled
                  />
                </div>
              </div>
              <div class="">
                <div class="field space">
                  <span class="fa fa-user"></span>
                  <input
                    type="text"
                    required
                    placeholder="<%=user.getHotelName()%>"
                    name="name"
                    disabled
                  />
                </div>
              </div>
              <div class="">
                <div class="field space">
                  <span class="fa fa-window-maximize"></span>
                  <input
                    type="number"
                    placeholder="No. of AC Single Room"
                    name="acSingle"
                  />
                </div>
              </div>
                    
              <div class="">
                <div class="field space">
                  <span class="fa fa-window-maximize"></span>
                  <input
                    type="number"
                    placeholder="Price of AC Single Room"
                    name="PriceAcSingle"
                  />
                </div>
              </div>
                    
              <div class="">
                <div class="field space">
                  <span class="fa fa-window-maximize"></span>
                  <input
                    type="number"
                    placeholder="No. of AC Double Room"
                    name="acDouble"
                  />
                </div>
              </div>
                    
              <div class="">
                <div class="field space">
                  <span class="fa fa-window-maximize"></span>
                  <input
                    type="number"
                    placeholder="Price of AC Double Room"
                    name="PriceAcDouble"
                  />
                </div>
              </div> 
              
              <div>
                <div class="field space">
                  <span class="fa fa-window-maximize"></span>
                  <input
                    type="number"
                    placeholder="No. of Non AC Single Room"
                    name="nonacSingle"
                  />
                </div>
              </div>
                    
              <div>
                <div class="field space">
                  <span class="fa fa-window-maximize"></span>
                  <input
                    type="number"
                    placeholder="Price of Non AC Single Room"
                    name="PriceNonacSingle"
                  />
                </div>
              </div>  
                 
              <div class="">
                <div class="field space">
                  <span class="fa fa-window-maximize"></span>
                  <input
                    type="number"
                    placeholder="No. of Non AC Double Room"
                    name="nonacDouble"
                  />
                </div>
              </div>
                 
              <div>
                <div class="field space">
                  <span class="fa fa-window-maximize"></span>
                  <input
                    type="number"
                    placeholder="Price of Non AC Double Room"
                    name="PriceNonacDouble"
                  />
                </div>
              </div>  
                  
              <div class="">
                <div class="field space">
                  <span class="fa fa-wifi"></span>
                  <select name="wifi" required class="field">
                    <option hidden>WIFI</option>
                    <option value="YES">YES</option>
                    <option value="NO">NO</option>
                  </select>
                </div>
              </div>
              <div class="">
                <div class="field space">
                  <span class="fa fa-home"></span>
                  <select name="balcony" required class="field">
                    <option hidden>BALCONY</option>
                    <option value="YES">YES</option>
                    <option value="NO">NO</option>
                  </select>
                </div>
              </div>
              <div class="">
                <div class="field space">
                  <span class="fa fa-television"></span>
                  <select name="tv" required class="field">
                    <option hidden>TV</option>
                    <option value="YES">YES</option>
                    <option value="NO">NO</option>
                  </select>
                </div>
              </div>
              <div class="">
                <div class="field space">
                  <span class="fa fa-picture-o" aria-hidden="true"></span>
                  <input
                    type="file"
                    id="myfile"
                    name="image1"
                    style=""
                    required
                  />
                  <label for="myfile">Click to Upload hotel image1</label>
                </div>
              </div>
              <div class="">
                <div class="field space">
                  <span class="fa fa-picture-o" aria-hidden="true"></span>
                  <input
                    type="file"
                    id="myfile"
                    name="image2"
                    style=""
                  />
                  <label for="myfile">Click to Upload hotel image2</label>
                </div>
              </div>
              <div class="">
                <div class="field space">
                  <span class="fa fa-picture-o" aria-hidden="true"></span>
                  <input
                    type="file"
                    id="myfile"
                    name="image3"
                    style=""
                  />
                  <label for="myfile">Click to Upload hotel image3</label>
                </div>
              </div>
              <div class="">
                <div class="field space">
                  <span class="fa fa-picture-o" aria-hidden="true"></span>
                  <input
                    type="file"
                    id="myfile"
                    name="image4"
                    style=""
                  />
                  <label for="myfile">Click to Upload hotel image4</label>
                </div>
              </div>
              <div class="">
                <div class="field space">
                  <span class="fa fa-picture-o" aria-hidden="true"></span>
                  <input
                    type="file"
                    id="myfile"
                    name="image5"
                    style=""
                  />
                  <label for="myfile">Click to Upload hotel image5</label>
                </div>
              </div>
<!--              <div class="" style="display: none">
                <div class="field space">
                  <span class="fa fa-user"></span>
                  <input
                    type="text"
                    required
                    placeholder="Status"
                    name="name"
                    disabled
                  />
                </div>
              </div>-->
              <div class="field space" >
                <input type="submit" value="SUBMIT FOR REVIEW" method="post" />
              </div>
            </div>
          </div>
        </form>
      </div>
    </div>
    <script
      src="https://kit.fontawesome.com/2fa60bdc10.js"
      crossorigin="anonymous"
    ></script>
    <script type="text/javascript" src="javascript/login.js"></script>
  </body>
</html>

