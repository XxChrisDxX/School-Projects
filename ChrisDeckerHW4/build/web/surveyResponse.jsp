<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@page import="java.io.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <script type="text/javascript"> 
            function searchfield_focus(obj)
            {
                obj.style.color=""
                obj.style.fontStyle=""
                if (obj.value=="Search hallowscare.com")
                    {
                        obj.value=""
                    }
            }
        </script>
        <link rel="stylesheet" type="text/css" href="maincss.css">
        <style type="text/css">
            img.small{
                width:300px;
                height:400px;
            }
            #italic{
                color:orange;
                font-style:italic;
            }
        </style>
    </head>
    <body>
        <!-- Main Table Start -->
        <table class="main" align="center">
            <tr>
                <td colspan="3">
                    <!-- Banner table start (top page) -->
                    <table class="banner" align="left">
                        <tr>
                            <td class="logo">
                                <img class="logo" src="./Images/halloween.jpg" alt="logo"/>
                                <!-- Search form start (will only search google right now since value is empty as this website is not actually published)-->
                                <form style="font-size:11px;" method="get" name="searchform" action="http://www.google.com/search" target="_blank">
                                    <table align="right">
                                        <tr>
                                            <td><input type="hidden" name="sitesearch" value="" /></td>
                                            <td><input onFocus="searchfield_focus(this)" style="width:150px; color:#808080; font-style:italic;" alt="search" type="text" name="as_q" size="20" value="Search hallowscare.com" /></td>
                                            <td><input type="submit" value="Search" title="Search" /></td>
                                        </tr>
                                    </table>
                                </form>
                                <!-- Search form end -->
                            </td>
                        </tr>
                    </table>
                    <!-- Banner table end (top page) -->
                </td>
            </tr>
            <tr>
                <td class="width2" valign="top">	
                    <!-- Sidescroller table start -->
                    <table class="sidescroller" align="left">
                        <tr><!-- Row 1 -->
                            <td class="width2">
                                <h2 class="red">Halloween <span id="orange">Costumes</span></h2>
                                <a href="index.html#werewolves">
                                    Werewolves
                                </a>
                                    <br />
                                <a href="index.html#vampires">
                                    Vampires
                                </a>
                                    <br />
                                <a href="index.html#ghouls">
                                    Ghouls
                                </a>
                                    <br />
                                <a href="index.html#ghosts">
                                    Ghosts
                                </a>
                                    <br />
                                <a href="index.html#grimReaper">
                                    Grim Reaper
                                </a>
                                    <br />
                                <a href="index.html#demons">
                                    Demons
                                </a>
                                    <br />
                                <a href="index.html#angels">
                                    Angels
                                </a>
                                    <br />
                                <a href="index.html#fairies">
                                    Fairies
                                </a>
                                    <br />
                                    <br />
                            </td>
                        </tr><!-- Row 1 end -->
                        <tr><!-- Row 2 -->
                            <td>
                                <h2 class="red">Halloween <span id="orange">Accessories</span></h2>
                                    <br />
                                <a class="accessories" href="">
                                    Necklaces
                                </a>
                                    <br />
                                <a class="accessories" href="">
                                    Pendants
                                </a>
                                    <br />
                                <a class="accessories" href="">
                                    Rings
                                </a>
                                    <br />
                                <a class="accessories" href="">
                                    Bracelets
                                </a>
                                    <br />
                                <a class="accessories" href="">
                                    Earings
                                </a>
                                    <br />
                                    <br />
                            </td>
                        </tr>
                        <tr><!-- Row 3 -->
                            <td>
                                <h2 class="red">Halloween <span id="orange">Requests</span></h2>
                                    <br />
                                <a href="survey.html">
                                    Survey request for new items
                                </a>
                                    <br />
                                    <br />
                            </td>
                        </tr>
                        <tr id="repeat">
                            <td>
                            </td>
                        </tr>
                    </table>
                    <!-- Sidescroller table end -->
                </td>
                <td valign="top">
                    <!-- Content table start -->
                    <table class="content">
                        <tr>
                            <td valign="top">
                                <h1 class="title">Your Survey Request</h1>
                                <p>I basically did the same thing with the JSP page as I did in our survey for EQ8. Everything seemed to fit and I wanted a page that allowed the users to request new
                                    products such as costumes and accessories. In addition to the request I thought it would be good to include all of the usual information asked in a survey
                                    as we did with the EQ. I asked for their names and information to send extra information on new products such as the ones they requested and special offers 
                                    because someone that would take the time to write a request would most likely take the time to read through information about new products or special deals. 
                                    The inputs displayed are first name, last name, email address, and postal address in text inputs. The radio button covers how the user heard about us. 
                                    The checkbox allows us to know if the user wants additional information while the combo box tells us how they want to receive that information. Finally, 
                                    the part I added was a request field as a text area giving the user more flexibility to request just about anything such as new products or new events to be added. 
                                    The inputs first name, last name, email address, postal address, date request was given, and the request field are placed in a surveyList.txt file in the WEB-INF folder. 
                                    I don't really know what regular java classes you were talking about so I added what I thought would be considered as a regular java class that went along with the 
                                    context which is the Date class. I called and used the Date class so that we know what current users are requesting and when the requests come in for filing purposes. 
                                    I will further my concerns with what class you were looking for in the comments section and I hope something along the lines of what I did was what you were looking for. 
                                </p>
                                <p>Here is a summary of your survey.</p>
                                <%
                                    String firstName = request.getParameter("firstName");
                                    String lastName = request.getParameter("lastName");
                                    String emailAddress = request.getParameter("emailAddress");
                                    String postalAddress = request.getParameter("postalAddress");
                                    String surveyRequest = request.getParameter("surveyRequest");
                                    
                                    java.util.Date date = new java.util.Date();
                                    String surveyDate = date.toString();
                                    
                                    ServletContext sc = getServletContext();
                                    String path = sc.getRealPath("/WEB-INF/surveyList.txt");
                                    File file = new File(path);
                                    PrintWriter output = new PrintWriter(new FileWriter(file, true));
                                    output.println(firstName + "|" + lastName + "|" + emailAddress + "|" + postalAddress + "|" + date + "|" + surveyRequest);
                                    output.close();
                                %>
                                <h2 id="orange">Your request was given on <%= surveyDate%>.</h2>
                                <h2 id="orange">Your information: </h2>
                                    <table>
                                        <tr>
                                            <td>First Name: </td>
                                            <td><%= firstName%></td>
                                        </tr>
                                        <tr>
                                            <td>Last Name: </td>
                                            <td><%= lastName%></td>
                                        </tr>
                                        <tr>
                                            <td>Email Address: </td>
                                            <td><%= emailAddress%></td>
                                        </tr>
                                        <tr>
                                            <td>Postal Address: </td>
                                            <td><%= postalAddress%></td>
                                        </tr>
                                    </table>
                                    <h2 id="orange">You heard about us from <%= request.getParameter("heardUs")%></h2>
                                    <%           
                                        String checkbox = request.getParameter("receiveInfo");
                                        if(checkbox != null){    
                                    %>
                                    <h2>You would like to receive announcements about new products and special offers.</h2>
                                    <%
                                        }
                                        else{
                                    %>
                                    <h2>You would not like to receive announcements about new products and special offers.
                                    <%
                                        }
                                    %>
                                    We can contact you by <%= request.getParameter("contactMe")%>.
                                        <br />
                                    <h2 id="orange">Your request for us is as follows:</h2>
                                    <%= request.getParameter("surveyRequest")%>
                                    <br />
                                    <p>Thank you for taking the survey.</p>
                                    <form action="survey.html">
                                        <input type="submit" value="return">&nbsp;&nbsp;Click button to return to the survey page.
                                    </form>
                            </td>
                        </tr>
                    </table>
                    <!-- Content table end -->
                </td>
                <td class="width1" valign="top">
                    <!-- Links table start -->
                    <table class="links" align="right" valign="top">
                        <tr ><!-- Row 1 -->
                                <td valign="top">
                                    <h2 class="red-orange">Costume Contest</h2>
                                    <a href="">Contest 1</a>
                                        <br />
                                    <a href="">Contest 2</a>
                                        <br />
                                        <br />
                                </td>
                        </tr><!-- Row 1 end-->
                        <tr><!-- Row 2 -->
                                <td valign="top">
                                    <h2 class="red-orange">Haunted Houses</h2>
                                    <a href="">Welcome to Hell</a>
                                        <br />
                                    <a href="">Hallowscream</a>
                                        <br />
                                    <a href="">Halloween Horror Nights</a>
                                        <br />
                                    <a href="">Death from Above</a>
                                        <br />
                                        <br />
                                </td>
                        </tr><!-- Row 2 end -->
                        <tr><!-- Row 3 -->
                                <td valign="top">
                                    <h2 class="red-orange">Best Trick or Treat Spots</h2>
                                    <a href="">Spot 1</a>
                                        <br />
                                    <a href="">Spot 2</a>
                                        <br />
                                    <a href="">Spot 3</a>
                                        <br />
                                    <a href="">Spot 4</a>
                                        <br />
                                        <br />
                                </td>
                        </tr><!-- Row 3 end -->
                        <tr><!-- Row 4 -->
                                <td valign="top">
                                    <h2 class="red-orange">Real Haunted Areas</h2>
                                    <a href="">Area 1</a>
                                        <br />
                                        <br />
                                </td>
                        </tr><!-- Row 4 end -->
                        <tr><!-- Row 5 -->
                                <td valign="top">
                                    <h2 class="red-orange">Graveyards</h2>
                                    <a href="">Indian Cemetery</a>
                                        <br />
                                    <a href="">Abandoned Cemetery 1</a>
                                        <br />
                                    <a href="">Abandoned Cemetery 2</a>
                                        <br />
                                    <a href="">Abandoned Cemetery 3</a>
                                        <br />
                                        <br />
                                </td>
                        </tr><!-- Row 5 end -->
                    </table>
                    <!-- Links table end -->
                </td>
            </tr>
            <tr>
                <td id="footer" colspan="3" valign="middle">
                    <div id="foottext"><a class="footer" href="index.html#top">Home Page</a>&nbsp;&nbsp;<a class="footer" href="contact.html">Contact Us</a>&nbsp;&nbsp;<a class="footer" href="survey.html">Survey Request for New Items</a></div>
                </td>
            </tr>
        </table>
        <!-- Main Table End -->
    </body>
</html>