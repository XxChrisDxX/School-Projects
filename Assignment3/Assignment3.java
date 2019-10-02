import java.util.Scanner;
import java.util.InputMismatchException;

public class Assignment3 
{
	static double maxArray(double[] array)
	{
		double max = array[0];
		
		for (int i = 0; i< array.length; i++)
		{
		    if(max < array[i])
		    {
		    	max = array[i];
		    }
		}
		
		return max;
	}
	
	static double sumDiffArrays(double[] arrayA, double[] arrayB)
	{
		double sum = 0;
		
		for (int i = 0; i< arrayA.length || i< arrayB.length; i++)
		{
		    sum = sum + (arrayA[i] - arrayB[i]);
		}
		
		return sum;
	}

	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);/*This line declares the Scanner variable in.*/ /*This line instantiates or represents as the Scanner object.*/
	    int numElements = 0;
	    
	    try 
	    {
	    	numElements = Integer.parseInt(args[0]);
	    } 
	    catch(NumberFormatException e1) 
	    {
	    	System.out.println("Please enter an integer for the Command Line Parameter!");
	    	System.exit(1);
	    } 
	    catch(ArrayIndexOutOfBoundsException e2) 
	    {
	    	System.out.println("Command Line Parameter missing!");
	    	System.exit(1);
	    }
	    if(numElements < 0) 
	    {
	    	System.out.println("Please enter a positive integer for the Command Line Parameter!");
	    	System.exit(1);
	    }
	    if(numElements == 0)
	    {
	    	System.out.println("Command Line Parameter can not be 0!");
	    	System.exit(1);
	    }
	    
	    double[] array1 = new double[numElements]; 
    	double[] array2 = new double[numElements];
    	
		for(int i = 0; i < array1.length & i < array2.length; i++)
		{
			System.out.println("Please enter a double value for array1<" + i + "> and array2<" + i + ">:");
			
			try
			{
				array1[i] = in.nextDouble();
				array2[i] = in.nextDouble();
			}
			catch (InputMismatchException e4)
			{
				System.out.println("Please enter double values!");
				System.exit(1);
			}
		}
		
		System.out.println("Array1 max: " + maxArray(array1) + ", Array2 max: " + maxArray(array2));
		System.out.println("Sum of the array differences: " + sumDiffArrays(array1, array2));
		/*
			static void arrayprint(int[] array)  
	{
		// method prints each element of the array parameter array
		// does not calculate anything so it’s void

		   for (int i=0; i< array.length; i++)
		   {
		      System.out.println("array[" + i + "] = " + array[i]);
		   }
		   System.out.println();
	}
	static int arraysum(int[] array)
	{  
		// Calculates and returns the sum of all elements
		// in the array parameter array. Returns int for the sum

		  int sumtotal = 0;
		  for (int i = 0; i < array.length; i++) 
		  {
		    sumtotal = sumtotal + array[i];  //add each element to the total
		  }
		 
		  return sumtotal;  //return the summation result
	}
	static double average(int[] array)
	{ 
		  int averagetotal = 0;
		  int count = 0;
		  
		  for (int i = 0; i < array.length; i++) 
		  {
		    averagetotal = averagetotal + array[i];  //add each element to the total
		    count++;
		  }
		  
		  return averagetotal / ((double) count);  //return the summation result; you can also divide by ((double) array.length)
	}
	static int search(int[] array, int x)
	{	
		for(int i = 0; i < array.length; i++)
		{
			if(x == array[i])
			{
				return i;
			}
		}
			return -1;
	}
	
	 
		int[] array = {1, 3, 25, 0, 10, 5, 2, 1, 3, 6};
		int x = 2;
		int index = search(array, x);
		
		arrayprint(array);
		System.out.println("The sum of the elements in the array is " + arraysum(array) + ".");
		System.out.println("The average of the elements in the array is " + average(array) + ".");
		
		if(index == -1)
		{
			System.out.println("not found" + index);
		}
		else
		{
			System.out.println("The index of the first element equal to x when x is " + x + " is " + index + ".");
		}
		
		x = 1;
		index = search(array, x);
		
		if(index == -1)
		{
			System.out.println("not found" + index);
		}
		else
		{
			System.out.println("The index of the first element equal to x when x is " + x + " is " + index + ".");
		}
		
		x = 4;
		index = search(array, x);
		
		if(index == -1)
		{
			System.out.println("not found " + index);
		}
		else
		{
			System.out.println("The index of the first element equal to x when x is " + x + " is " + index + ".");
		}*/
	}
}