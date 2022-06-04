<%-- 
    Document   : forgot1
    Created on : Apr 3, 2022, 1:13:00 PM
    Author     : User
--%>

<%@page import="Beans.user2"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Forgot Password</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
      integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
      crossorigin="anonymous"
    />
    
    <link rel="stylesheet" href="css/login_cs.css" />
  </head>
  <body>
    <div class="bg-img">
      <div class="content">
        <header>Forgot Password</header>
        <%!
            user2 currUser;
        %>
        <%
            currUser=(user2) session.getAttribute("Forgot_user");
            if(currUser==null){
                response.sendRedirect("forgot.html");
                return;
            }
        %>
        <form action="forgot2" method="post">
          <div>
              <h1 style="color: white"><%=currUser.getSq()%></h1><br>
          </div>
          <div class="field">
            <span class="fa fa-user"></span>
            <input type="text" required placeholder="ANSWER" name="userInputAnswer" />
          </div>
          <div class="field space">
            <input type="submit" value="VERIFY" />
          </div>
        </form>
      </div>
    </div>
    <script type="text/javascript" src="javascript/login.js"></script>
  </body>
</html>
