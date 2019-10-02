/********************************************************************************************\
*****This program is designed to take a photo and create a puzzle game with the photo in *****
****which the user can rearrange the pieces to complete and figure out what the photo is. ****
\********************************************************************************************/
package homework1;

import java.io.IOException;

public class homework1test {
	public static void main(String args[]) throws IOException {
		//instantiates the String path and sets it equal to the image path
		String path = "src/homework1/FGCU_logo.png";
		
		//creates an instance of the JEightPuzzleFrame class and passes variables to it
		JEightPuzzleFrame jframe = new JEightPuzzleFrame("Eight Puzzle", path);
		//shows the display frame
		jframe.setVisible(true);
	}
}
