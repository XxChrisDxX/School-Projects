import java.util.Scanner; /*This line accesses the Scanner class.*/
import java.util.InputMismatchException; /*This line accesses the InputMismatchException class for use within the code(so the code will recognize the class).*/

public class hw2727 /*This line is necessary to run the java program, the public class has to be set equal to the name of the document.*/
{
	static double maxArray(double[] array) /*This line creates the double method maxArray to accept one double argument, array[].*/ 
	{
		double max = array[0]; /*This line creates a double variable called max and sets it equal to the argument array passed through method maxArray at position 0.*/
		
		for (int i = 0; i< array.length; i++) /*This line initiates the in variable i, sets it equal to 0, updates variable i by adding 1 at the end of each for loop run, and 
			runs the for loop as long as i is less than the argument array.length (number of positions in the array).*/
		{
		    if(max < array[i]) /*This line checks to see if the variable max is less than the argument array at position i. The program runs inside the if statement if it is true.*/
		    {
		    	max = array[i]; /*This line sets the variable max equal to the argument array at position i.*/
		    }
		}
		
		return max; /*This line returns the double variable max.*/
	}
	
	static double sumDiffArrays(double[] arrayA, double[] arrayB) /*This line creates the double method sumDiffArrays to accept two double arguments, arrayA[] and arrayB[].*/
	{
		double sum = 0; /*This line creates a double variable called sum and sets it equal to 0.*/
		
		for (int i = 0; i< arrayA.length || i< arrayB.length; i++) /*This line initiates the in variable i, sets it equal to 0, updates variable i by adding 1 at the end of each 
			for loop run, and runs the for loop as long as i is less than the argument arrayA.length (number of positions in arrayA) OR as long as i is less than the 
			argument arrayB.length (number of positions in arrayB).*/
		{
		    sum = sum + (arrayA[i] - arrayB[i]); /*This line sets the variable sum equal to sum plus arrayA at position i minus arrayB at position i.*/
		}
		
		return sum; /*This line returns the double variable sum.*/
	}

	public static void main(String args[]) /*This line is a method main that is necessary to be a program (application).*/
	{
		Scanner in = new Scanner(System.in);/*This line declares the Scanner variable in and represents as the Scanner object.*/
	    int numElements = 0; /*This line creates an integer variable called numElements and sets it equal to 0.*/
	    
	    try /*This line contains and runs a block of code that has possible exceptions that could cause errors.*/ 
	    {
	    	numElements = Integer.parseInt(args[0]); /*This line sets numElements equal to the Command Line user input and parses or changes the input into an integer.*/
	    } 
	    catch(NumberFormatException e1) /*This line catches the format exception where a non integer is entered such as 4.5 or hello and runs the code inside the catch statement if the 
	    	exception is caught. The catch is also assigned a unique identifier e1.*/
	    {
	    	System.out.println("Please enter an integer for the Command Line Parameter!"); /*This line prints out a message with a line break asking the user to please enter an integer 
	    		for the Command Line Parameter.*/
	    	System.exit(1); /*This line exits the program.*/
	    } 
	    catch(ArrayIndexOutOfBoundsException e2) /*This line catches the exception in which nothing is entered from the Command Line and runs the code inside the catch statement if 
	    	the exception is caught. The catch is also assigned a unique identifier e2.*/
	    {
	    	System.out.println("Command Line Parameter missing!"); /*This line prints out a message with a line break telling the user that the Command Line Parameter was missing.*/
	    	System.exit(1); /*This line exits the program.*/
	    }
	    if(numElements < 0) /*This line checks to see if the variable numElements is less than 0 (negative). If it is, then the program proceeds inside the if statement. If it is not, the 
	    	program skips over the if statement.*/
	    {
	    	System.out.println("Please enter a positive integer for the Command Line Parameter!"); /*This line prints out a message with a line break asking the user to enter a 
	    		positive integer for the Command Line Parameter.*/
	    	System.exit(1); /*This line exits the program.*/
	    }
	    if(numElements == 0) /*This line checks to see if the variable numElements is equal to 0. If it is, then the program proceeds inside the if statement. If it is not, the program 
	    	skips over the if statement.*/
	    {
	    	System.out.println("Command Line Parameter can not be 0!"); /*This line prints out a message with a line break telling the user that the Command Line Parameter can not be 0.*/
	    	System.exit(1); /*This line exits the program.*/
	    }
	    
	    double[] array1 = new double[numElements]; /*This line creates a double variable array called array1 and creates the array with the number of positions equal to the value of numElements.*/
    	double[] array2 = new double[numElements]; /*This line creates a double variable array called array2 and creates the array with the number of positions equal to the value of numElements.*/
    	
		for(int i = 0; i < array1.length & i < array2.length; i++) /*This line initiates the in variable i, sets it equal to 0, updates variable i by adding 1 at the end of each 
			for loop run, and runs the for loop as long as i is less than the argument array1.length (number of positions in array1) AND as long as i is less than the 
			argument array2.length (number of positions in array2).*/
		{
			System.out.println("Please enter a double value for array1<" + i + "> and array2<" + i + ">:"); /*This line prompts the user for two double values, one to be placed in 
				array1 at position i, and the other to be placed in array2 at position i.*/
			
			try /*This line contains and runs a block of code that has possible exceptions that could cause errors.*/
			{
				array1[i] = in.nextDouble(); /*This line uses a method call to the in object to store the first user input value in the double array, array1, at position i.*/
				array2[i] = in.nextDouble(); /*This line uses a method call to the in object to store the second user input value in the double array, array2, at position i.*/
			}
			catch (InputMismatchException e3) /*This line catches the input mismatch exception where a non double value is entered such hello and runs the code inside the catch statement if 
				the exception is caught. The catch is also assigned a unique identifier e3.*/
			{
				System.out.println("Please enter double values!"); /*This line prints out a message with a line break asking the user to please enter double values for the array1 and/or array2.*/
				System.exit(1); /*This line exits the program.*/
			}
		}
		
		System.out.println("Array1 max: " + maxArray(array1) + ", Array2 max: " + maxArray(array2)); /*This line prints out a message with a line break that tells the user the max value 
			in the array1 and the max value in the array2 arrays. This line tells the max values in array1 and array2 by calling the method of maxArray with variable array1 as argument array and then calling the method of maxArray again with variable array2 as argument array.*/
		System.out.println("Sum of the array differences: " + sumDiffArrays(array1, array2)); /*This line prints out a message with a line break that tells the user the sum of the 
			array differences by calling the method of sumDiffArrays with variable array1 as argument arrayA and variable array2 as argument arrayB.*/
	}
}