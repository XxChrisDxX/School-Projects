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
   // output a row of column headers
   //
%>
 <tr><th>30 years</th>
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
