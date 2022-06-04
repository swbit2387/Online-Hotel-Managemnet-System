<%@page import="Beans.HotelImages"%>
<%@page import="java.io.File"%>
<%@page import="java.io.File"%>
<%@page import="ActionClasses.HotelAction"%>
<%@page import="HelperClasses.Loader"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Beans.Hotel"%>
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
    <link rel="stylesheet" href="css/style.css" />
    <link rel="stylesheet" href="css/login_cs.css"/>
    <title>Book Hotels</title>
  </head>
  <body>
    <!-- HEADER -->
    <section class="header" , id="header">
        <%! 
            user2 user;
            Hotel currHotel;
            private static final String UPLOAD_DIR = "uploads";
        %>
        <%
            user=(user2)session.getAttribute("loggedInUser");
            currHotel=(Hotel)session.getAttribute("currHotel");
            if(currHotel==null){
                response.sendRedirect("welcomePage.jsp");
                return;
            }
        %>
      <!-- NAVIGATION -->
      <%
          if(user==null){
      %>
      <nav >
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
<!--            <li><a href="logout" method="post">LOGOUT</a></li>-->
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

      <!-- ABOUT STARTS -->
      <section id="about">
      <div id="carouselExampleCaptions" class="hotel-img carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
          <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
          <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
          <li data-target="#carouselExampleCaptions" data-slide-to="3"></li>
        </ol>
        <div class="carousel-inner">
        <%
            String images[]=currHotel.getHotelImage().getFileName();
            String FirstImage=UPLOAD_DIR+"/"+images[0]+".jpg";
        %>
          <div class="carousel-item active" data-interval="2000">
            <img src="<%=FirstImage%>" class="d-block w-100" alt="...">
          </div>
          <%
              
              for(int i=1;i<images.length;i++){
              
                if(images[i]!=null){
                String image=UPLOAD_DIR+"/"+images[i]+".jpg";
              
          %>
          <div class="carousel-item" data-interval="2000">
            <img src="<%=image%>" class="d-block w-100" alt="...">
          </div>
          <%
              }
            }
          %>
        </div>
        <button class="carousel-control-prev" type="button" data-target="#carouselExampleCaptions" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-target="#carouselExampleCaptions" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </button>
      </div>
    </section>
      </section>
      <!-- ABOUT ENDS -->
<!--header-Ends-->

    <!--form data start-->
    <section class="form-data">
        <form action="viewBillSummary" method="get">
            <label class="hotelName" for="">Welcome to Hotel <em><%=currHotel.getHotelName()%></em></label><br>
            <label for="userName">Your Name:&nbsp;&nbsp;&nbsp;</label>
            <input type="text" id="userName" name="userName"><br><br>
            
            <!--radio groups-->
            <label for="hotelTable">Select Room Type</label>
                <table id="hotelTable" class="table table-striped hotelTable">
                    <thead>
                      <tr>
                        <th scope="col">#</th>
                        <th scope="col">Room Type</th>
                        <th scope="col">Price</th>
                      </tr>
                    </thead>
                    <tbody>
            <%
                int roomTypes[]=new int[4];
                String rooms[]=new String[4];
                int price[]=new int[4];
                price[0]=currHotel.getHotelCost().getAcSingleCost();
                price[1]=currHotel.getHotelCost().getAcDoubleCost();
                price[2]=currHotel.getHotelCost().getNonAcSingleCost();
                price[3]=currHotel.getHotelCost().getNonAcDoubleCost();
                rooms[0]="AC SINGLE";
                rooms[1]="AC DOUBLE";
                rooms[2]="NON AC SINGLE";
                rooms[3]="NON AC DOUBLE";
                roomTypes[0]=currHotel.getDetails().getAcSingle();
                roomTypes[1]=currHotel.getDetails().getAcDouble();
                roomTypes[2]=currHotel.getDetails().getNonAcSingle();
                roomTypes[3]=currHotel.getDetails().getNonAcDouble();
                for(int i=0;i<4;i++){
                
                if(roomTypes[i]>0){
            %>
                    <tr>
                      <td><input type="radio" id="html" name="roomType" value="<%=rooms[i]%>,<%=price[i]%>"></td>
                      <td><%=rooms[i]%></td>
                      <td><%=price[i]%></td>

                    </tr>
            <%
                    }
                }
            %>
                    </tbody>
                </table>
                <label for="noOFPeople">No. of People:&nbsp;&nbsp;&nbsp;</label>
                <input type="number" id="noOFPeople" name="noOFPeople"><br><br>
                
                <label for="bookingDate">Booking Date:&nbsp;&nbsp;&nbsp;</label>
                <input type="date" id="bookingDate" name="bookingDate"><br><br>
                
                <label for="checkInDate">Check In Date:&nbsp;&nbsp;&nbsp;</label>
                <input type="date" id="checkInDate" name="checkInDate"><br><br>
                
                <label for="checkOutDate">Check Out Date:&nbsp;&nbsp;&nbsp;</label>
                <input type="date" id="checkOutDate" name="checkOutDate"><br><br>
            
                <input class="btn btn-primary"type="submit" value="Proceed to Book">
        </form>
    </section>
    <!--form data end-->
      
    <!-- FOOTER -->

    <section class="footer" id="footer">
        <!-- Footer -->
        <footer
          class="text-center text-lg-start text-white"
          style="background-color: #1c2331"
        >
          <!-- Section: Social media -->
          <section
            class="d-flex justify-content-between p-4"
            style="background-color: rgba(0, 0, 0, 0.2)"
          >
            <!-- #6351ce -->
            <!-- Left -->
            <div class="me-5">
              <span>Get connected with us on social networks:</span>
            </div>
            <!-- Left -->
  
            <!-- Right -->
            <div>
              <a href="" class="social-icons text-white me-4">
                <i class="fa fa-facebook"></i>
              </a>
              <a href="" class="social-icons text-white me-4">
                <i class="fa fa-twitter"></i>
              </a>
              <a href="" class="social-icons text-white me-4">
                <i class="fa fa-instagram"></i>
              </a>
              <a href="" class="social-icons text-white me-4">
                <i class="fa fa-linkedin"></i>
              </a>
              <a href="" class="social-icons text-white me-4">
                <i class="fa fa-github"></i>
              </a>
            </div>
            <!-- Right -->
          </section>
          <!-- Section: Social media -->
  
          <!-- Section: Links  -->
          <section class="">
            <div class="container text-left text-md-start mt-5">
              <!-- Grid row -->
              <div class="row mt-3">
                <!-- Grid column -->
                <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
                  <!-- Content -->
                  <h6 class="text-uppercase fw-bold">INFINITY</h6>
                  <hr
                    class="mb-4 mt-0 d-inline-block mx-auto"
                    style="width: 60px; background-color: #7c4dff; height: 2px"
                  />
                  <p>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Ipsum
                    hic obcaecati nulla excepturi architecto esse nemo praesentium
                    alias dolorem ducimus mollitia debitis est, suscipit saepe
                    tenetur corrupti quia atque in!
                  </p>
                </div>
                <!-- Grid column -->
  
                <!-- Grid column -->
                <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
                  <!-- Links -->
                  <h6 class="text-uppercase fw-bold">Products</h6>
                  <hr
                    class="mb-4 mt-0 d-inline-block mx-auto"
                    style="width: 60px; background-color: #7c4dff; height: 2px"
                  />
                  <p>
                    <a href="#!" class="text-white">HOTEL</a>
                  </p>
                  <p>
                    <a href="#!" class="text-white">GYMS</a>
                  </p>
                  <p>
                    <a href="#!" class="text-white">SPA</a>
                  </p>
                  <p>
                    <a href="#!" class="text-white">ROOMS</a>
                  </p>
                </div>
                <!-- Grid column -->
  
                <!-- Grid column -->
                <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
                  <!-- Links -->
                  <h6 class="text-uppercase fw-bold">Useful links</h6>
                  <hr
                    class="mb-4 mt-0 d-inline-block mx-auto"
                    style="width: 60px; background-color: #7c4dff; height: 2px"
                  />
                  <p>
                    <a href="#!" class="text-white">CARRER</a>
                  </p>
                  <p>
                    <a href="#!" class="text-white">HOME</a>
                  </p>
                  <p>
                    <a href="#!" class="text-white">ABOUT</a>
                  </p>
                  <p>
                    <a href="#!" class="text-white">Help</a>
                  </p>
                </div>
                <!-- Grid column -->
  
                <!-- Grid column -->
                <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
                  <!-- Links -->
                  <h6 class="text-uppercase fw-bold">Contact</h6>
                  <hr
                    class="mb-4 mt-0 d-inline-block mx-auto"
                    style="width: 60px; background-color: #7c4dff; height: 2px"
                  />
                  <p>
                    <i class="contact-icons fa fa-home mr-3"></i> ASANSOL, WEST
                    BENGAL
                  </p>
                  <p>
                    <i class="contact-icons fa fa-envelope mr-3"></i>
                    email@gmail.com
                  </p>
                  <p>
                    <i class="contact-icons fa fa-phone mr-3"></i> 98 254 887 78
                  </p>
                  <p>
                    <i class="contact-icons fa fa-phone mr-3"></i> 98 254 887 78
                  </p>
                </div>
                <!-- Grid column -->
              </div>
              <!-- Grid row -->
            </div>
          </section>
          <!-- Section: Links  -->
  
          <!-- Copyright -->
          <div
            class="text-center p-3"
            style="background-color: rgba(0, 0, 0, 0.2)"
          >
            <p>
              Copyright &copy;
              <script>
                document.write(new Date().getFullYear());
              </script>
              All rights reserved.
            </p>
          </div>
          <!-- Copyright -->
        </footer>
        <!-- Footer -->
      </section>
      <!-- End of section-->
  
      <!-- FOOTER ENDS -->

       <!-- JAVASCRIPT -->
    <script>
        var navLinks = document.getElementById("navLinks");
        function showMenu() {
          navLinks.style.right = "0";
        }
        function hideMenu() {
          navLinks.style.right = "-200px";
        }
      </script>
  
      <!-- BOOTSTRAP -->
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