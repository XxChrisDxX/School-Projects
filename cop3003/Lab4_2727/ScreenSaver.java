//import libraries
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JPanel;
import javax.swing.Timer;

//ScreenSaver class that extends JPanel and implements ActionListener and MouseWheelListener
public class ScreenSaver extends JPanel implements ActionListener, MouseWheelListener{
	//instance variables
	private int x[] = new int[60];
	private int y[] = new int[60];
	private int numOfPoints = 0;
	private int radius = 10;
	private int delay = 1000;
	private Timer timer = null; // javax.swing.timer

	//public constructor for ScreenSaver
	public ScreenSaver(){
		//initializes and starts the timer
		timer = new Timer(1000, this); // the interval is 1000 milliseconds
		timer.start();
	}

	//returns void and accepts ActionEvent input
	public void actionPerformed(ActionEvent e){
		//center points of frame
		int centerX = (int)(getSize().getWidth()/2);
		int centerY = (int)(getSize().getHeight()/2);

		//calculates lengths to be placed in array
		double X = centerX+Math.cos(numOfPoints*Math.PI/3)*radius;
		double Y = centerY+Math.sin(numOfPoints*Math.PI/3)*radius;

		//places X and Y into array
		this.x[numOfPoints] = (int)X;
		this.y[numOfPoints] = (int)Y;

		//increments array index
		numOfPoints++;

		//increments radius by 3
		radius += 3;

		//resets numOfPoints and radius if the array has 60 points
		if(numOfPoints == 60){
			numOfPoints = 0;
			radius = 10;
		}
		//determines if mouse wheel was moved
		addMouseWheelListener(this);

		//updates graphics
		repaint();
	}

	//returns void and accepts Graphics as an input
	public void paintComponent(Graphics g){
		//clears the image
		g.clearRect(0, 0, (int)getSize().getWidth(), (int)getSize().getHeight());

		//draws the line, inputs determine where to draw it
		g.drawPolyline(x, y, numOfPoints);
	}

	//returns void and accepts MouseWheelEvent input
	public void mouseWheelMoved(MouseWheelEvent e){
		/*
		 * e.getWheelRotation() returns the number of "clicks" the mouse wheel
		 * was rotated. Negative values if the mouse wheel was rotated up/away
		 * from the user, and positive values if the mouse wheel was rotated
		 * down/ towards the user
		 */
		//initializes int notches and sets it equal to 0 to start
		int notches = 0;

		//sets notches equal to e.getWheelRotation int, tells which direction the user scrolled
		notches = e.getWheelRotation();

		//if notches was negative, decrease delay to 200 milliseconds
		if(notches<0 && delay>=400){
			delay = delay-200;

			/* update delay */
			timer.setDelay(delay);
		}
		//if notches was positive, increase delay to 2000 milliseconds
		else if(notches>0){
			delay = delay+200;

			/* update delay */
			timer.setDelay(delay);
		}
	}
}