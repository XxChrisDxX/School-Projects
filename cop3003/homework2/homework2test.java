/************************************************************\
*Java program that converts Arabic Numbers to Roman Numerals *
****and vice versa. The number converted will be the same ****
***in value as its counterpart. The program will not accept***
\********** negative, incorrect, or invalid input.***********/

package homework2;

import javax.swing.JFrame;

public class homework2test {
    public static void main(String args[]) {
    	//initiates the converter class and passes the title
        Converter converter = new Converter("Roman <--> Arabic");
        converter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //sets the size of the window
        converter.setSize(300, 85);
        
        //doesn't allow users to change the size
        converter.setResizable(false);
        
        //allows the window to be seen
        converter.setVisible(true);   
    }
}
