public class hw2727 /*This line is necessary to run the java program, the public class has to be set equal to the name of the document.*/
{
	static void printATutorTotals(int[][] data, String[] names, String[] day, int r) 
		/*This line creates a void method printATutorTotals to accept one two dimensional integer array argument (data[][]), 
		two string array arguments (names, day), and one integer argument (r).*/
	{
		System.out.print(names[r] + " met "); /*This line prints out a message that tells the user the name
			in the names array argument at position r.*/
		
		for (int j = 0; j < data[r].length; j++)  /*This line initiates the integer variable j, sets it equal to 0, updates variable j by adding 1 at the end of each for loop run, and 
			runs the for loop as long as j is less than the argument data at row r.length (number of columns in the row r).*/
		{			
			System.out.print(data[r][j] + " (" + day[j] + ") "); /*This line prints out a message that tells the user the number of tutored students
				in the data array argument at row r, column j and the day those students were tutored in the day array argument at position j.*/
		}
			
		System.out.println("students."); /*This line prints out a message with a line break that only says students.*/
	}
	
	static int max1dArray(int[] array) /*This line creates an integer method max1dArray to accept one integer array argument, array[].*/
	{
		int arraymax = array[0]; /*This line creates an integer variable called arraymax and sets it equal to the argument array passed through method max1dArray at position 0.*/
		  
		for (int i = 0; i < array.length; i++) /*This line initiates the in variable i, sets it equal to 0, updates variable i by adding 1 at the end of each for loop run, and 
			runs the for loop as long as i is less than the argument array.length (number of positions in the array).*/
		{
			if(arraymax < array[i]) /*This line checks to see if the variable arraymax is less than the argument array at position i. The program runs inside the if statement if it is true.*/
			{
				arraymax = array[i]; /*This line sets the variable arraymax equal to the argument array at position i.*/
			}
		}
		  
		return arraymax; /*This line returns the double variable arraymax.*/
	}
	
	public static void main(String[] args) /*This line is a method main that is necessary to be a program (application).*/
	{
		int[][] tutorData = { // students per day (MTW) per tutor
			{ 25, 3, 0 },   // Amy
			{ 14, 5, 12 },  // John
			{ 33, 22, 10 }, // Nick
			{ 0, 20, 5 }};  // Maria 
			/*This block of code creates a two dimension integer array called tutorData and populates it with 4 rows and 3 columns of data to 
			correspond with the number of students each tutor tutored per day.*/
			
		String tutorNames[] = { "Amy", "John", "Nick", "Maria" };
			/*This line creates a string array called tutorNames and populates it with 4 tutor's names.*/
		String Weekday[] = {"M", "T", "W"};
			/*This line creates a string array called Weekday and populates it with 3 weekdays (MTW).*/
		
		int numOfDays = tutorData[0].length; /*This line creates an integer numOfDays and sets it equal to the number of columns in tutorData.*/
		int numOfTutors = tutorData.length; /*This line creates an integer numOfTutors and sets it equal to the number of rows in tutorData.*/
		int studentsTotal = 0; /*This line creates an integer studentsTotal and sets it equal to 0.*/
		int studentsPerDay; /*This line creates an integer studentsPerDay.*/
		int studentsPerTutor; /*This line creates an integer studentsPerTutor.*/
		
		int[] sumPerDay = new int [numOfDays]; /*This line creates an integer array called sumPerDay and gives it space to hold the 
			integer numOfDays number of integers (e.g. if numOfDays is 3, it will have 3 spaces to store integers).*/
		int[] sumPerTutor = new int [numOfTutors]; /*This line creates an integer array called sumPerTutor and gives it space to hold the 
			integer numOfTutors number of integers.*/
		 
		for (int j = 0; j < numOfDays; j++) /*This line initiates the integer variable j, sets it equal to 0, updates variable j by adding 1 at the end of each for loop run, and 
			runs the for loop as long as j is less than the integer numOfDays.*/
		{
			studentsPerDay = 0; /*This line sets the integer studentsPerDay equal to 0.*/
			
			for (int i = 0; i < numOfTutors; i++) /*This line initiates the integer variable i, sets it equal to 0, updates variable i by adding 1 at the end of each for loop run, and 
				runs the for loop as long as i is less than the integer numOfTutors.*/
			{
				studentsPerDay = studentsPerDay + tutorData[i][j]; /*This line sets the integer studentsPerDay equal to itself plus the integer stored in the 
					two dimensional array tutorData at row i, column j.*/
			}
			
			studentsTotal = studentsTotal + studentsPerDay; /*This line sets the integer studentsTotal equal to itself plus the integer studentsPerDay.*/
			sumPerDay[j] = studentsPerDay; /*This line sets the one dimensional array sumPerDay at position j equal to 
				studentsPerDay (storing the calculation in the sumPerDay array).*/
		}
		
		for (int i = 0; i < numOfTutors; i++) /*This line initiates the integer variable i, sets it equal to 0, updates variable i by adding 1 at the end of each for loop run, and 
			runs the for loop as long as i is less than the integer numOfTutors.*/
		{
			studentsPerTutor = 0; /*This line sets the integer studentsPerTutor equal to 0.*/
			
			for (int j = 0; j < numOfDays; j++) /*This line initiates the integer variable j, sets it equal to 0, updates variable j by adding 1 at the end of each for loop run, and 
				runs the for loop as long as j is less than the integer numOfDays.*/
			{
				studentsPerTutor = studentsPerTutor + tutorData[i][j]; /*This line sets the integer studentsPerTutor equal to itself plus the integer stored in the 
					two dimensional array tutorData at row i, column j.*/
			}
			
			sumPerTutor[i] = studentsPerTutor; 
				/*This line sets the one dimensional array sumPerTutor at position i equal to studentsPerTutor (storing the calculation in the sumPerTutor array).*/
		}

		/*  Printing Output */
		for (int tutor = 0; tutor < numOfTutors; tutor++) /*This line initiates the integer variable tutor, sets it equal to 0, updates variable tutor by adding 1 at the end of each for loop run, and 
			runs the for loop as long as tutor is less than the integer numOfTutors.*/
		{
			printATutorTotals(tutorData, tutorNames, Weekday, tutor); /*This line calls the method of printATutorTotals with the two dimensional integer array tutorData as argument data, 
				the one dimensional string array tutorNames as argument names, the one dimensional string array Weekday as argument day, and the integer variable tutor as argument r.*/
		}
		
		System.out.println("Total number of students using the center: " + studentsTotal); /*This line prints out a message with a line break that tells the user the total number of students
			using the tutor center.*/
		System.out.print("   "); /*This line prints out a message with 3 spaces serving as an indent.*/
		
		for (int i = 0, count = 1; i < numOfDays; i++, count++) /*This line initiates the integer variables i and count, sets variable i equal to 0 and count equal to 1, updates 
			variable i and count by adding 1 to each of them at the end of each for loop run, and 
			runs the for loop as long as i is less than the integer numOfDays.*/
		{
			System.out.print(Weekday[i] + ": " + sumPerDay[i]); /*This line prints out a message that tells the user the day in the one dimensional string array Weekday
				at position i and the total number of students tutored in that day stored in sumPerDay at position i.*/
			
			if(count == numOfDays) /*This line checks to see if the variable count is equal to the variable numOfDays. The program runs inside the if statement if it is true.*/
			{
				System.out.println(); /*This line only serves as a line break.*/
			}
			
			else /*The program run inside the else statement if the if statement above was false.*/
			{
				System.out.print(", "); /*This line prints out a comma to separate the weekdays and their corresponding student totals.*/
			}
		}
		
		System.out.print("   "); /*This line prints out a message with 3 spaces serving as an indent.*/
		
		for (int i = 0, count = 1; i < numOfTutors; i++, count++) /*This line initiates the integer variables i and count, sets variable i equal to 0 and count equal to 1, updates 
			variable i and count by adding 1 to each of them at the end of each for loop run, and 
			runs the for loop as long as i is less than the integer numOfTutors.*/
		{
			System.out.print(tutorNames[i] + ": " + sumPerTutor[i]); /*This line prints out a message that tells the user the name in the one dimensional string array tutorNames
				at position i and the total number of students tutored by that tutor stored in sumPerTutor at position i.*/
			
			if(count == numOfTutors) /*This line checks to see if the variable count is equal to the variable numOfTutors. The program runs inside the if statement if it is true.*/
			{
				System.out.println("."); /*This line prints out a period with a line break to end the totals block of information.*/
			}
			
			else /*The program run inside the else statement if the if statement above was false.*/
			{
				System.out.print(", "); /*This line prints out a comma to separate the tutor names and their corresponding tutored student totals.*/
			}
		}
		
		System.out.println("Max students per day: " + max1dArray(sumPerDay) + "."); /*This line prints out the max number of students tutored in one day with a line break
			by calling the max1dArray method and passing the sumPerDay integer array as the argument array.*/ 
		System.out.println("Max students per tutor: " + max1dArray(sumPerTutor) + "."); /*This line prints out the max number of students tutored by one tutor with a line break
			by calling the max1dArray method and passing the sumPerTutor integer array as the argument array.*/
	}
}
