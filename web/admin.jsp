<%@page import="Beans.admin"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Beans.Hotel"%>
<%@page import="HelperClasses.Loader"%>
<!DOCTYPE html>
<html>
  <head>
    <title>ADMIN</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
      integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
      crossorigin="anonymous"
    />
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
    <link rel="stylesheet" href="css/admin.css" />
  </head>
  <body>
      
      <%
            admin a=(admin)session.getAttribute("loggedInAdminUser");
            if(a==null){
                response.sendRedirect("admin_login.jsp");
                return;
            }
            String msg=(String)session.getAttribute("message");
            if(msg!=null){
      %>
        <script>swal("Try Again","<%=msg%>","error");</script>
      <%
            }
            session.removeAttribute("message");
      %>
    <div class="bg-img">
        <nav style="position: relative; z-index: 9999">
            <a class="logo-img"><img src="css/whiteInfinity.png" alt="LOGO"/></a>
        <a class="logo" href="#">INFINITY</a>
        <div class="nav-links" id="navLinks">
          <span
            class="fa fa-times"
            onclick="hideMenu()"
            aria-hidden="true"
          ></span>
          <ul>
            <li><a href="logout" method="post">LOGOUT</a></li>
          </ul>
        </div>
        <span class="fa fa-bars" onclick="showMenu()" aria-hidden="true"></span>
      </nav>
      <div class="myTable">
        <div class="container">
          <div class="row">
            <div class="col-12">
              <table class="table table-dark table-bordered table-responsive table-hover">
                <thead>
                  <tr>
                    <th scope="col">Allocated Hotel Id</th>
                    <th scope="col">Manager Name</th>
                    <th scope="col">Manager Number</th>
                    <th scope="col">Hotel Name</th>
                    <th scope="col">Hotel Location</th>
                    <th scope="col">Action</th>
                  </tr>
                </thead>
                <tbody>
                    <!--table row start-->
                  <%
                      Loader loader=new Loader();
                      ArrayList<Hotel> pendingHotel=loader.getPendingHotel();
                      for(int i=0;i<pendingHotel.size();i++){
                  %>
                  <tr>
                    <th scope="row"><%=pendingHotel.get(i).getHotelId()%></th>
                    <td><%=pendingHotel.get(i).getManagerName()%></td>
                    <td><%=pendingHotel.get(i).getManagerNumber()%></td>
                    <td><%=pendingHotel.get(i).getHotelName()%></td>
                    <td><%=pendingHotel.get(i).getHotelLocation()%></td>
                    <td>
                        <form action="AcceptDeny" method="post">
                            <button name="ActionButton" value="A<%=pendingHotel.get(i).getHotelId()%>" type="submit" class="btn btn-success">
                              <i class="fa fa-check"></i>
                            </button>
                            <button name="ActionButton" value="D<%=pendingHotel.get(i).getHotelId()%>" type="submit" class="btn btn-danger">
                              <i class="fa fa-times"></i>
                            </button>
                        </form>
                    </td>
                  </tr>
                  <%
                      }
                  %>
                  <!--table row end-->
                </tbody>
              </table>
            </div>
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
