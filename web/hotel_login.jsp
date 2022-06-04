<!DOCTYPE html>
<html>
  <head>
    <title>Hotel Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
      integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
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
            <li><a href="index.jsp">USER LOGIN</a></li>
          </ul>
        </div>
        <span class="fa fa-bars" onclick="showMenu()" aria-hidden="true"></span>
      </nav>
        
        <!--navbar ends-->
        
      <div class="content">
        <header>Hotel Login</header>
        <%
            String msg=(String)session.getAttribute("message");
            if(msg!=null){
            %>
        <script>swal("Try Again","<%=msg%>","error");</script>
        <%
            }
            session.removeAttribute("message");
        %>
        
        <form action="hotel_login" method="post">
          <div class="field">
            <span class="fa fa-user"></span>
            <input type="email" name="email" required placeholder="Email" />
          </div>
          <div class="field space">
            <span class="fa fa-lock"></span>
            <input type="password" name="password" class="pass-key" required placeholder="Password" />
            <!--<span class="show">SHOW</span>-->
          </div>
          <div class="note space">
              Note: This is only for hotel login
          </div>
          <div class="field">
            <input type="submit" value="LOGIN" />
          </div>
        </form>
        <div class="signup">
          Don't have Hotel Account?
          <a href="hotel_signup.jsp">SignUp Now</a>
        </div>
      </div>
    </div>
    <script type="text/javascript" src="javascript/login.js"></script>
  </body>
</html>
