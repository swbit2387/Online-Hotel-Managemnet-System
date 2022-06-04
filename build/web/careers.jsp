<%-- 
    Document   : careers
    Created on : Apr 4, 2022, 8:49:02 PM
    Author     : User
--%>

<%@page import="Beans.user2"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    <link rel="stylesheet" href="css/style.css" />
    <title>CAREER</title>
  </head>
  <body>
    <!-- HEADER -->
    <section class="header" , id="header">
      <!-- NAVIGATION -->
      <%! user2 user;%>
        <%
            user=(user2)session.getAttribute("loggedInUser");
        %>
      <!-- NAVIGATION -->
      <%
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
            <li><a href="about.html">ABOUT</a></li>
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
            <li><a href="about.html">ABOUT</a></li>
            <li><a href="careers.jsp">CAREER</a></li>
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
                  <a class="logout-key dropdown-item" href="MyBookings.jsp">My Bookings</a><br>
                  <a class="logout-key dropdown-item" href="logout" method="post">LOGOUT</a>
                </div>
          </ul>
        </div>
        <span class="fa fa-bars" onclick="showMenu()" aria-hidden="true"></span>
      </nav>
      <%
          }
      %>
      <!-- NAVIGATION ENDS -->

      <div class="text-box">
        <h1>JOIN US</h1>
        <p>
          Want to enhance your career in the Hotel Industry? 
          <br>So what you are waiting for.
          <br>Join us now for a  inspiring journey and better career opportunities.
        </p>
        <a class="hero-btn" href="admin_login.jsp">JOIN</a>
      </div>
    </section>

    <!-- HEADER ENDS -->
    <script src="javascript/login.js"></script>
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
  </body>
  
</html>
