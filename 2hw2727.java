import java.util.Scanner; /*This line accesses the Scanner class.*/

public class hw2727 /*This line is necessary to run the java program, the public class has to be set equal to the name of the document.*/
{
		static double calcTriangleArea(double x, double y) /*This line creates the double method calcTriangleArea to accept two double arguments x and y. My method accepts integer variables and passes them through the double arguments in the method.*/ 
		{
			return ((x * y)/2); /*This line returns the value of argument x times argument y, then divided by 2.*/
		}

		static double calcCircleArea(double r) /*This line creates the double method calcCircleArea to accept one double argument r.*/
		{
			return (Math.PI*(r*r)); /*This line returns the value of argument r times argument r, then multiplied times pi.*/
		}
		  
		public static void main(String[] args) /*This line is a method main that is necessary to be a program (application).*/
		{
			Scanner in; /*This line declares the Scanner variable in.*/
			in = new Scanner(System.in); /*This line instantiates or represents as the Scanner object.*/
		    
			System.out.println("Please enter either 1 or 2:"); /*This line prompts the user to enter the number 1 or 2.*/
			double choice = in.nextDouble(); /*This line uses a method call to the in object to store the input in the double variable choice.*/
			
			if(choice == 1) /*This line checks to see if the variable choice is equal to 1. If it is, then the program proceeds inside the if statement. If it is not, the program skips over the if statement. In my code, if choice is not equal to 1, the program proceeds to the next if else statement.*/
			{
				System.out.println("Please enter two non-negative integers for base and height:"); /*This line prompts the user for two non-negative numbers as the base and height of the triangle.*/
				int b = in.nextInt(); /*This line uses a method call to the in object to store the input in the b integer variable.*/
				int h = in.nextInt(); /*This line uses a method call to the in object to store the input in the h integer variable.*/
				double trianglearea = calcTriangleArea(b, h); /*This line creates a double variable called trianglearea and sets it equal to the return value in the method of calcTriangleArea with variables b and h as arguments x and y respectively.*/
		    
				if(b >= 0 & h >= 0) /*This line checks to see if the variable b is positive and if the variable h is positive. The program runs inside the if statement if both are true. Otherwise, the program skips over the if statement.*/
				{
					System.out.println("Area of a triangle with base= " + b + ", height= " + h + ": " + trianglearea + "."); /*This line prints out a message that tells the user the value of the base (integer variable b), height (integer variable h), and area of the triangle (double variable trianglearea).*/
				}
				
				if(b < 0) /*This line checks to see if the variable b is negative. The program runs inside the if statement if it is true.*/
				{
					System.out.println("Number " + b + " entered is negative. Program exits."); /*This line prints out a message that tells the user the value of the base (integer variable b) and explains that the program will exit since the value was negative.*/
				}
				
				else if(h < 0) /*This line checks to see if the variable h is negative. The program runs inside the if statement if it is true.*/
				{
					System.out.println("Number " + h + " entered is negative. Program exits."); /*This line prints out a message that tells the user the value of the height (integer variable h) and explains that the program will exit since the value was negative.*/
				}
			}
		    
			else if(choice == 2) /*This line checks to see if the variable choice is equal to 2. If it is, then the program proceeds inside the if statement. If it is not, the program skips over the if statement.*/
		    {
				System.out.println("Please enter a non-negative number for radius:"); /*This line prompts the user for one non-negative numbers as the radius of the circle.*/
				double r = in.nextDouble(); /*This line uses a method call to the in object to store the input in the r double variable.*/
				double circlearea = calcCircleArea(r); /*This line creates a double variable called circlearea and sets it equal to the return value in the method of calcCircleArea with variable r as argument r.*/
		    
				if(r >= 0) /*This line checks to see if the variable r is positive. The program runs inside the if statement if it is true.*/
				{
					System.out.println("Area of a circle with radius= " + r + ": " + circlearea + "."); /*This line prints out a message that tells the user the value of the radius (double variable r) and area of the circle (double variable circlearea).*/
				}
				
				else if(r < 0) /*This line checks to see if the variable r is negative. The program runs inside the if statement if it is true.*/
				{
					System.out.println("Number " + r + " entered is negative. Program exits."); /*This line prints out a message that tells the user the value of the radius (double variable r) and explains that the program will exit since the value was negative.*/
				}
		    }
			
			else /*This line checks to see if the two previous if statements were true. If they were not true, the program proceeds inside the else statement. If they were true, the program skips over the else statement.*/
			{
				System.out.println("Please rerun the program entering either 1 or 2."); /*This line tells the user to rerun the program entering either 1 or 2 (they entered a number that was not 1 or 2 originally)*/
			}
		}
}