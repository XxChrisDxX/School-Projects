//The goal of this program is to: 
//(1) Ask the user to enter
//    meal total value and tip percent
//(2) Program reads these two values and 
//(3) Program prints the total amount
//    if the user entered a negative meal amount 
//    program prints a message and exits
// Please fill in the blanks; also note that besides 
// the blanks, you also must correct the code given

import java.util.Scanner;


class CalcTipWhile{

	public static void main(String args[])
	{
		// variables //
		double mealTotal; 
		double tipPercent;
		
		//read meal total from user
		Scanner in = new Scanner(System.in);
		System.out.println("Please Enter Meal Total:  ");
		mealTotal = in.nextDouble();
		
		if(mealTotal > 0){ // user entered positive meal total value
			
			//read tip percent from user
			System.out.println("Please Enter Tip Percentage:  ");
			tipPercent = in.nextDouble();
			
			while(tipPercent < 0){
				System.out.println("Please enter a correct tip amount, the amount you entered was negative.");
				tipPercent = in.nextDouble();
			}	
			System.out.println("Meal Total Including Tip = " + (mealTotal * (1 + (tipPercent / 100))));
			
			/*else{
			// display meal total including tip   
			System.out.println("Meal Total Including Tip = " + (mealTotal * (1 + (tipPercent / 100))));
			}*/
		}
		else{
			System.out.println("The meal total was negative! Program exits");
		}

	}

}


