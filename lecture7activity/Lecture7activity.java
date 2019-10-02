class Lecture7activity
 {
  static double doSquare(double num)
   {
    return num * num;
   }
  static double modTwo(double inputVar)
   {
    return inputVar % 2;
   }
  public static void main(String args[]) 
   {
    double var = 5;
    double result = doSquare(var+1);
    double result2 = modTwo(var);
    System.out.print("The result of squaring the number " + (var+1) + " is: " + result);
    System.out.println("The result of taking the modulo 2 of the number " + var + " is: " + result2);
   }
}
