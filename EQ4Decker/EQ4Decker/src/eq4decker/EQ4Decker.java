package eq4decker;
import java.io.*;
import java.util.Scanner;

/*
 @author ctdecker2727
*/

public class EQ4Decker {

    public static void main(String[] args) throws Exception {
        
        File file = new File("Chris.txt");
        
        if(file.exists()) {
            System.out.println("File already exists");
            System.exit(0);
        }
        
        PrintWriter output = new PrintWriter(file);
        output.println("Chris Decker 4");
        output.println("Chris Decker 5");
        
        output.close();
        
        try {
            Scanner input = new Scanner(file);
            
            while (input.hasNext()) {
                String firstName = input.next();
                String lastName = input.next();
                double grade = input.nextDouble();
            
                System.out.println(firstName + " " + lastName + " " + grade);
            }

            input.close();
        }
        catch(Exception ex){
            System.out.println(ex); 
        }
    }
}
