package homework1;

//import libraries
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//creates the JEightPuzzleFrame class and extends the JFrame class 
public class JEightPuzzleFrame extends JFrame {
	//instance variables
	private BufferedImage image;
	private BufferedImage[] images = new BufferedImage[8];
	private JButton[] buttons = new JButton[8];
	private ImageIcon[] imageIcons = new ImageIcon[8];
	private Icon[] icons = new Icon[8];
	private JPanel panel;
	private Container container;
	private int[][] positionArray = new int[3][3];
	private ButtonHandler handler;
	private int width;
	private int height;
	
	//creates the JEightPuzzleFrame constructor with two String inputs
	public JEightPuzzleFrame(String title, String path) {
		//gets the title from the super constructor
		super(title);
		
		//exits the JFrame when it's closed
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//creates the 3 by 3 grid
		setLayout(new GridLayout(3, 3, 0, 0));
		
		//creates a new Container
		container = new Container();
		//fills the container with the content pane
		container = getContentPane();
		
		//creates a new JPanel
		panel = new JPanel();
		//creates a new Button Handler
		handler = new ButtonHandler();

		ImageIcon(path);

		// first time initial game.
		setSize(height, width); // set frame size
		initialGame();
	}
	//returns void and accepts a String input
	private void ImageIcon(String path) {
		//tries to read the image and get the size of the image
		try {
			image = ImageIO.read(new File(path));
			width = image.getWidth();
			height = image.getHeight();
		}
		//catches if there's an IOException
		catch (IOException e) {
			e.printStackTrace();
		}

		//files the image array with the sub images for the grid
		images[0] = image.getSubimage(0, 0, width / 3, height / 3);
		images[1] = image.getSubimage(width / 3, 0, width / 3, height / 3);
		images[2] = image.getSubimage(2 * width / 3, 0, width / 3, height / 3);
		images[3] = image.getSubimage(0, height / 3, width / 3, height / 3);
		images[4] = image.getSubimage(width / 3, height / 3, width / 3, height / 3);
		images[5] = image.getSubimage(2 * width / 3, height / 3, width / 3, height / 3);
		images[6] = image.getSubimage(0, 2 * height / 3, width / 3, height / 3);
		images[7] = image.getSubimage(width / 3, 2 * height / 3, width / 3, height / 3);

		//instantiates the object of the image icon
		for (int i = 0; i < 8; i++) {
			buttons[i] = new JButton();
			imageIcons[i] = new ImageIcon();
			imageIcons[i].setImage(images[i]);
			icons[i] = imageIcons[i];
			buttons[i] = new JButton(icons[i]);
			buttons[i].setSize(icons[0].getIconWidth(), icons[0].getIconHeight());
			buttons[i].addActionListener(handler);
		}
	}

	//returns void and initializes the first game
	private void initialGame() {

		//this array contains the image positions of the first game
		positionArray = new int[][] { { 8, 4, 3 }, { 0, 5, 6 }, { 1, 2, 7 } };

		//adds in the buttons and panel
		add(panel);
		add(buttons[0]);
		add(buttons[1]);
		add(buttons[4]);
		add(buttons[5]);
		add(buttons[2]);
		add(buttons[3]);
		add(buttons[6]);
		add(buttons[7]);
	}
	//ButtonHandler class that implements the ActionListener class
	private class ButtonHandler implements ActionListener {
		//returns void and accepts an ActionEvent as a parameter
		public void actionPerformed(ActionEvent e) {

			int num = -1;
			for (int i = 0; i < 8; i++) {
				if (e.getSource() == buttons[i]) {
					num = i;
					break;
				}
			}
			determineLocation(num);
			move();
			Congratulation(win());
			if (win()) {
				reInitializeGame();
				move();
			}
		}
	}

	//determines the location of the empty panel
	private void determineLocation(int num) {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (positionArray[j][i] == num) {
					determineMove(j, i);
					//returns here to stop processing
					return; 
				}
			}
		}
	}
	//returns void and accepts two int inputs, determines if the puzzle piece can move
	private void determineMove(int j, int i) {
		int a, b, c, d;
		int temp;
		a = j - 1;
		b = j + 1;
		c = i - 1;
		d = i + 1;
		if (a >= 0 && positionArray[a][i] == 8) {
			temp = positionArray[a][i];
			positionArray[a][i] = positionArray[j][i];
			positionArray[j][i] = temp;
		}
		else if (b <= 2 && positionArray[b][i] == 8) {
			temp = positionArray[b][i];
			positionArray[b][i] = positionArray[j][i];
			positionArray[j][i] = temp;
		} 
		else if (c >= 0 && positionArray[j][c] == 8) {
			temp = positionArray[j][c];
			positionArray[j][c] = positionArray[j][i];
			positionArray[j][i] = temp;
		} 
		else if (d <= 2 && positionArray[j][d] == 8) {
			temp = positionArray[j][d];
			positionArray[j][d] = positionArray[j][i];
			positionArray[j][i] = temp;
		}
	}
	//returns void and executes the move
	private void move() {
		container.removeAll();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (positionArray[j][i] == 8) {
					add(panel);
				} 
				else {
					add(buttons[positionArray[j][i]]);
				}
			}
		}
		getContentPane().validate();
	}
	//returns void and accepts boolean input, congratulations dialog if user wins
	private void Congratulation(boolean win) {
		if (win) {
			//shows the winning dialog message if user wins
			JOptionPane.showMessageDialog(this, "Congratulations!", "You solved the eight puzzle.", 1);
		} 
		else {
			//displays nothing if the user doesn't win
		}
	}
	//returns boolean, finds out if the user won the game, and returns whether or not the user did
	private boolean win() {
		int[][] Winarray = new int[3][3];
		int temp = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				Winarray[j][i] = temp;
				temp++;
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (Winarray[j][i] != positionArray[j][i]) {
					return false;
				}
			}
		}
		return true;
	}
	//returns void and reinitializes the game if the user won
	private void reInitializeGame() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Random random = new Random();
		Object[] value = new Object[8];

		//gets the random number from 0-9, can't get the same number twice
		while (true) {
			int number = random.nextInt(9);
			if (!list.contains(number)) {
				list.add(number);
			}
			if (list.size() == 9) {
				break;
			}
		}
		value = list.toArray();

		int count = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				positionArray[j][i] = (Integer) value[count];
				count++;
			}
		}
	}
}