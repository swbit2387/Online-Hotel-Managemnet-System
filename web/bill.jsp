<%@page import="Beans.HotelBooking"%>
<!DOCTYPE html>
<html>
  <head>
    <title>BILL</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
      integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
      crossorigin="anonymous"
    />

    <link rel="stylesheet" href="css/Book.css" />
  </head>
  <body>
      <%!
          HotelBooking hb;
      %>
      <%
          hb=(HotelBooking)session.getAttribute("hotelBook");
          if(hb==null){
                response.sendRedirect("welcomePage.jsp");
                return;
          }
      %>
    <div class="bg-img">
      <div class="content signup">
        <header>BILL</header>

        <form class="form" action="ConfirmPayment" method="post">
          <div class="container">
            <div class="row">

                <div class="">
                <div class="field">
                  <span class="fa fa-id-card"></span>
                  <label for="">Hotel Name:&nbsp;&nbsp;</label>
                  <input
                    type="text"
                    required
                    name="name"
                    value="<%=hb.getBookedHotelName()%>"
                    disabled
                  />
                </div>
              </div>
                            <div class="">
                <div class="field space">
                  <span class="fa fa-window-maximize"></span>
                  <label for="">Room Type:&nbsp;&nbsp;</label>
                  <input
                    type="text"
                    required
                    name="name"
                    value="<%=hb.getRoomType()%>"
                    disabled
                  />
                </div>
              </div>

              <div class="">
                <div class="field space">
                  <span class="fa fa-window-maximize"></span>
                  <label for="">Check in Date:&nbsp;&nbsp;</label>
                  <input
                    type="text"
                    required
                    name="name"
                    value="<%=hb.getCheckInDate()%>"
                    disabled
                  />
                </div>
              </div>
                <div class="">
                <div class="field space">
                  <span class="fa fa-window-maximize"></span>
                  <label for="">Check out Date:&nbsp;&nbsp;</label>
                  <input
                    type="text"
                    required
                    name="name"
                    value="<%=hb.getCheckOutDate()%>"
                    disabled
                  />
                </div>
              </div>
                            <div class="">
                <div class="field space">
                  <span class="fa fa-window-maximize"></span>
                  <label for="">No of People:&nbsp;&nbsp;</label>
                  <input
                    type="text"
                    required
                    name="name"
                    value="<%=hb.getNoOfPeople()%>"
                    disabled
                  />
                </div>
              </div>
                            <div class="">
                <div class="field space">
                  <span class="fa fa-window-maximize"></span>
                  <label for="">No of Days:&nbsp;&nbsp;</label>
                  <input
                    type="text"
                    required
                    name="name"
                    value="<%=hb.getNoOfDays()%>"
                    disabled
                  />
                </div>
              </div>
                            <div class="">
                <div class="field space">
                  <span class="fa fa-window-maximize"></span>
                  <label for="">Price per day:&nbsp;&nbsp;</label>
                  <input
                    type="text"
                    required
                    name="name"
                    value="<%=hb.getPricePerDay()%>"
                    disabled
                  />
                </div>
              </div>
                            <div class="">
                <div class="field space">
                  <span class="fa fa-window-maximize"></span>
                  <label for="">Total Fair:&nbsp;&nbsp;</label>
                  <input
                    type="text"
                    required
                    name="name"
                    value="<%=hb.getAmountPaid()%>"
                    disabled
                  />
                </div>
              </div>
                
            
              <div class="field space">
                <input type="submit" value="ConfirmPayment" />
              </div>
            </div>
          </div>
        </form>
      </div>
    </div>
    <script>
      document.getElementById("myfile").onclick = function () {
        document.getElementsByClassName("display1").style.display = "none";
        document.getElementsByClassName("display2").style.display = "block";
        return true;
      };
    </script>
    <script
      src="https://kit.fontawesome.com/2fa60bdc10.js"
      crossorigin="anonymous"
    ></script>
    <script type="text/javascript" src="javascript/login.js"></script>
  </body>
</html>
