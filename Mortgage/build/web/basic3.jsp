<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<html>
<head><title>JSP Page</title></head>
<body>


<%!
  
  java.text.DecimalFormat currency = new java.text.DecimalFormat("$#,###,###,##0.00");
  java.text.DecimalFormat interest = new java.text.DecimalFormat("0.0%");
  
  /*
   * Compute monthly payment given principle, yearly interest rate
   * and number of years for the loan
   */
  double computeMonthlyPayment(double principle, double rate, double years)
  {
   double monthlyRate = rate/12.0;
   
   double payment = principle * monthlyRate / (1 - 1 / Math.pow(1+monthlyRate,years * 12));
   return payment;
  }
%>
<h2>Monthly Payment Calculation Table </h2>
<table border = 1>

<%
  double beginingRate = .01;// first rate to use in the table
  double endingRate = .10; // last rate to use in the table
  double rateIncrement = .01; // amount to increment rate each time
  double beginingPrinciple = 100000.0; // first principle in table
  double endingPrinciple =   500000.0; // last principle in table
  double principleIncrement =100000.0; // amount to increment principle each time
  double years = 30;
   //
   // Retrieve parameters
   //
   String syears = request.getParameter("years"); // get the parameter
   if(syears != null) // if its null then don't parse, use default value
     years = Double.parseDouble(syears);

   String sbrate = request.getParameter("beginingrate");
   if(sbrate != null)
     beginingRate = Double.parseDouble(sbrate)/100;

   String serate = request.getParameter("endingrate");
   if(serate != null)
     endingRate = Double.parseDouble(serate)/100;
   
   String sratei = request.getParameter("rateincrement");
   if(sratei != null)
     rateIncrement = Double.parseDouble(sratei)/100;

   String sbprin = request.getParameter("beginingprinciple");
   if(sbprin != null)
     beginingPrinciple = Double.parseDouble(sbprin);

   String seprin = request.getParameter("endingprinciple");
   if(seprin != null)
     endingPrinciple = Double.parseDouble(seprin);
   
   String sprini = request.getParameter("principleincrement");
   if(sprini != null)
     principleIncrement = Double.parseDouble(sprini);


   //
   // output a row of column headers
   //
%>
 <tr><th><%= years+"" %> years</th>
 <%
   for(double principle = beginingPrinciple; principle <= endingPrinciple; principle += principleIncrement)
   {
%>
   <th><%= currency.format(principle) %> </th>
<%
    }
 %>
 </tr>
 <%
  for(double rate = beginingRate; rate <= endingRate; rate += rateIncrement)
  {
%>
 <tr>
 <th> <%= interest.format(rate) %> </th>
 <%
    for(double principle = beginingPrinciple; principle <= endingPrinciple; principle += principleIncrement)
    {
     double payment = computeMonthlyPayment(principle, rate, years);
     
 %>
 <td> <%= currency.format(payment) %> </td>
 <%
     }
 %>
 </tr>
 <%
    }
  %>
</table>
</body>
</html>
