/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


 function checkForm()
 {
    var valid = true;
    var message = "Errors: \n";
    var bp=0, ep=0, pi=0, br=0, er=0, ri=0;

    with(document.inputform)
    {
     if(years.value == "" || isNaN(years.value))
     {
       valid = false;
       message = message + "years field is invalid\n";
     }
     else
     {
      var y = parseFloat(years.value);
      if(y <= 0)
       {
         valid = false;
         message = message + "years must be greater than 0\n";
       }
      }
      
     if(beginingprinciple.value == "" || isNaN(beginingprinciple.value))
     {
       valid = false;
       message = message + "first principle field is invalid\n";
     }
     else
     {
      bp = parseFloat(beginingprinciple.value);
      if(bp <= 0)
       {
         valid = false;
         message = message + "first principle must be greater than 0\n";
       }
      }
      
      
     if(endingprinciple.value == "" || isNaN(endingprinciple.value))
     {
       valid = false;
       message = message + "last principle field is invalid\n";
     }
     else
     {
      ep = parseFloat(endingprinciple.value);
      if(ep <= 0 || ep < bp)
       {
         valid = false;
         message = message + "last principle must be greater first principle\n";
       }
      }
      
     if(principleincrement.value == "" || isNaN(principleincrement.value))
     {
       valid = false;
       message = message + "principle increment field is invalid\n";
     }
     else
     {
      pi = parseFloat(principleincrement.value);
      if(pi <= 0)
       {
         valid = false;
         message = message + "principle increment must be greater than 0\n";
       }
      }
      
    if(beginingrate.value == "" || isNaN(beginingrate.value))
     {
       valid = false;
       message = message + "first rate field is invalid\n";
     }
     else
     {
      br = parseFloat(beginingrate.value);
      if(br <= 0)
       {
         valid = false;
         message = message + "first rate must be greater than 0\n";
       }
      }
     
     if(endingrate.value == "" || isNaN(endingrate.value))
     {
       valid = false;
       message = message + "last rate field is invalid\n";
     }
     else
     {
      er = parseFloat(endingrate.value);
      if(er <= 0 || er < br)
       {
         valid = false;
         message = message + "last rate must be greater first rate\n";
       }
      }
     
     if(rateincrement.value == "" || isNaN(rateincrement.value))
     {
       valid = false;
       message = message + "rate increment field is invalid\n";
     }
     else
     {
      ri = parseFloat(rateincrement.value);
      if(ri <= 0)
       {
         valid = false;
         message = message + "rate increment must be greater than 0\n";
       }
      }
     
    }
  if(!valid)
      alert(message);
  return valid;
 }