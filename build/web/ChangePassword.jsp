<%@page import="Beans.user2"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Change Password</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
      integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="css/login_cs.css" />
  </head>
  <%!
      user2 currUser;
  %>
  <%
      currUser=(user2)session.getAttribute("Forgot_user");
      String chk=(String)session.getAttribute("pass");
      if(currUser==null || chk.equals("false")){
            response.sendRedirect("forgot.html");
            return;
      }
  %>
  <body>
    <div class="bg-img">
      <div class="content">
        <header>Change Password</header>
        <form action="ChangePassword" method="post">
          <div>
              <span class="fa fa-user"></span>
            <h1 style="color: white" style="font-size: 0.8em"><%out.print(""+currUser.getEmail());%></h1>
            <br>
          </div>
          <div class="field">
            <span class="fa fa-lock"></span>
            <input type="password" name="newPassword" required placeholder="New Password" />
          </div>
          <div class="field space">
            <input type="submit" value="Submit" />
          </div>
        </form>
      </div>
    </div>
    <script type="text/javascript" src="javascript/login.js"></script>
  </body>
</html>
