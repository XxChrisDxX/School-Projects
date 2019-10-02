import java.util.Scanner;
public class Lecture5activity
 {
  public static void main(String[] args)
  {
   Scanner in;
   in = new Scanner(System.in);
   
   double x, root, var1, min;
   
   System.out.println("Enter a number for our x variable.");
   x = in.nextDouble();
   root = Math.sqrt(x);
   var1 = x/3;
   min = Math.min(root, var1);
   
   System.out.println("The square root of x is " + root + ".");
   System.out.println("The minimum between " + root + " and " + var1 + " equals " + min + ".");
  }
 }