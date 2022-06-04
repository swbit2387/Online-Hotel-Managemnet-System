<%-- 
    Document   : error
    Created on : Apr 1, 2022, 8:38:12 PM
    Author     : User
--%>

<%@page import="java.util.Enumeration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Message from server</title>
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
          <%!
              String msg="";

          %>
          <%
              if(session==null){
                msg="Invalid request";
              }
              else{
                msg=(String)session.getAttribute("message");
                if(msg==null)
                    msg="Invalid Request";
                session.setAttribute("message",null);
              }
          %>
        <header><%=msg%></header>
        <form action="welcomePage.jsp">
          <div class="field space">
            <input type="submit" value="BACK TO HOME" />
          </div>
        </form>
      </div>
    </div>
    <script type="text/javascript" src="javascript/login.js"></script>
  </body>
</html>

