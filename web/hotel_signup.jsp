<%-- 
    Document   : hotel_signup
    Created on : Apr 4, 2022, 12:09:48 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Hotel Sign Up</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
      integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="css/login_cs.css" />
    <link rel="stylesheet" href="css/style.css" />
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
  </head>
  <body>
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
        
      <div class="content">
        <header>Hotel Sign Up</header>
        <%!String msg;%>
        <%
            msg=(String)session.getAttribute("message");
            if(msg!=null){
            %>
                <script>swal("Try Again","<%=msg%>","error");</script>
        <%
            }
            session.removeAttribute("message");
        %>
        <form action="hotel_signup" method="post">
          <div class="field">
            <span class="fa fa-user"></span>
            <input name="mgrName" type="text" required placeholder="Manager Name" />
          </div>
          <div class="field space">
            <span class="fa fa-envelope"></span>
            <input name="mgrEmail" type="email" required placeholder="Email" />
          </div>
          <div class="field space">
            <span class="fa fa-envelope"></span>
            <input name="mgrPassword" type="password" required placeholder="Password" />
          </div>
          <div class="field space">
            <span class="fa fa-mobile"></span>
            <input name="mgrNumber" type="number" required placeholder="Contact Number" />
          </div>
          <div class="field space">
            <span class="fa fa-user"></span>
            <input name="hotelName" type="text" required placeholder="Hotel Name" />
          </div>
          <div class="field space">
            <span class="fa fa-user"></span>
            <input name="hotelLoc" type="text" required placeholder="Hotel Location" />
          </div>
          <div class="field space">
            <input type="submit" value="NEXT" />
          </div>
        </form>
    </div>
    </div>
    <script type="text/javascript" src="javascript/login.js"></script>
  </body>
</html>

