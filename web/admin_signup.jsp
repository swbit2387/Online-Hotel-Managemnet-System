<%-- 
    Document   : admin_signup
    Created on : Apr 4, 2022, 9:30:21 PM
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
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
  </head>
  <body>
    <div class="bg-img">
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
        <form action="adminSignup" method="post">
            <div class="field">
            <span class="fa fa-envelope"></span>
            <input name="adminEmail" type="email" required placeholder="Email" />
          </div>
            <div class="field space">
            <span class="fa fa-id-card"></span>
            <input name="adminName" type="text" required placeholder="Name" />
          </div>
          <div class="field space">
            <span class="fa fa-user"></span>
            <input name="adminPassword" type="password" required placeholder="Password" />
          </div>
          
          <div class="field space">
            <span class="fa fa-id-card"></span>
            <input name="adminAadhar" type="text" required placeholder="Aadhar" />
          </div>
          <div class="field space">
            <input type="submit" value="NEXT" />
          </div>
        </form>
    </div>
    <script type="text/javascript" src="javascript/login.js"></script>
  </body>
</html>