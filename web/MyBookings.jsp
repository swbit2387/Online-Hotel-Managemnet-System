 <%@page import="HelperClasses.Loader"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Beans.HotelBooking"%>
<%@page import="Beans.user2"%>  
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!-- BOOTSTRAP -->
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
      integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
      crossorigin="anonymous"
    />
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
    />
    <link rel="stylesheet" href="css/admin.css" />
      <link rel="stylesheet" href="css/style.css" />
    <title>Table</title>
  </head>
  <body>
    <!-- HEADER -->
    <section class="header"  id="header">
         <%!
             user2 user;
             ArrayList<HotelBooking> hb;
         %>
        <%
            user=(user2)session.getAttribute("loggedInUser");
            
            if(user==null){
                response.sendRedirect("index.jsp");
                return;
            }
        %> 
       NAVIGATION 
       <%
          String email=user.getEmail();
          hb=new Loader().getMyBookings(email);
          if(user==null){
      %> 
      <nav>
        <a class="logo-img" href="welcomePage.jsp"
          ><img src="css/whiteInfinity.png" alt="LOGO"
        /></a>
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
            <li><a href="index.jsp">LOGIN</a></li>
          </ul>
        </div>
        <span class="fa fa-bars" onclick="showMenu()" aria-hidden="true"></span>
      </nav>
       <%
          }
        else{
      %>
      <nav>
        <a class="logo-img" href="welcomePage.jsp"
          ><img src="css/whiteInfinity.png" alt="LOGO"
        /></a>
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
            <li><a href="careers.jsp">CAREERS</a></li>
            <li><a href="hotel_login.jsp">BUSINESS</a></li>

            <li>
              <div class="dropdown">
                <img
                  src="css/user.jpg"
                  class="user-img dropdown-toggle"
                  id="dropdownMenu2"
                  data-toggle="dropdown"
                  aria-expanded="false"
                />

                <div
                  class="dropdown-menu dropdown-menu-right"
                  aria-labelledby="dropdownMenu2"
                >
                  <p class="dropdown-item"><%=user.getName()%></p>
                  <p class="dropdown-item"><%=user.getEmail()%></p>
                  <p class="dropdown-item"><%=user.getMobile()%></p>
                  <a class="logout-key dropdown-item" href="logout" method="post">LOGOUT</a>
                </div>
              </div>
            </li>
          </ul>
        </div>
        <span class="fa fa-bars" onclick="showMenu()" aria-hidden="true"></span>
      </nav>
      <%
          }
      %> 
     <!-- NAVIGATION ENDS -->
     <div class="adminTable">
        <div class="container">
          <div class="row">
            <div class="col-12">
              <table
                class="
                  table table-dark table-bordered table-responsive table-hover
                "
              >
                <thead>
                  <tr>
                    <th scope="col">Hotel Name</th>
                    <th scope="col">Room Type</th>
                    <th scope="col">No of People</th>
                    <th scope="col">Booking Date</th>
                    <th scope="col">Check In Date</th>
                    <th scope="col">Check Out Date</th>
                    <th scope="col">Amount Paid</th>
                  </tr>
                </thead>
                <tbody>
                    <%
                        for(int i=0;i<hb.size();i++){
                    %>
                  <tr>
                    <th scope="row"><%=hb.get(i).getBookedHotelName()%></th>
                    <td><%=hb.get(i).getRoomType()%></td>
                    <td><%=hb.get(i).getNoOfPeople()%></td>
                    <td><%=hb.get(i).getBookingDate()%></td>
                    <td><%=hb.get(i).getCheckInDate()%></td>
                    <td><%=hb.get(i).getCheckOutDate()%></td>
                    <td><%=hb.get(i).getAmountPaid()%></td> 
                  </tr>
                  <%
                      }
                  %>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
          <script
      src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
      integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://kit.fontawesome.com/2fa60bdc10.js"
      crossorigin="anonymous"
    ></script>
    <script type="text/javascript" src="javascript/login.js"></script>
  </body>
</html>
