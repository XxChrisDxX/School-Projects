/************************************************************\
****Small program that will add hydrogen and oxygen atoms ****
********into a reactor to create water molecules. The ********
*******program will synchronize some variables will be *******
****synchronized and the reactor will have a sleep period ****
************************upon starting.************************
\************************************************************/

//import libraries
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class lab6 implements Executor {
	public static void main(String[] args) throws InterruptedException {
		//class instantiations
		Timer timer = new Timer();
		ReactionArea Buff = new ReactionArea();
		Hydrogen hydrogen = new Hydrogen(Buff);
		Oxygen oxygen = new Oxygen(Buff);
		Reactor reactor = new Reactor(Buff);

		ExecutorService threadExecutor = Executors.newCachedThreadPool();

		threadExecutor.execute(hydrogen);
		threadExecutor.execute(oxygen);
		TimerTask thread = new TimerTask() {
			@Override
			//used by TimerTask
			public void run() {
				threadExecutor.execute(reactor);

			}
		};
		timer.schedule(thread, 1000);
	}
	public void execute(Runnable arg0) {
	}
}
class ReactionArea {
	//instance variables
	public int waitingHydrogen = 0;
	public int waitingOxygen = 0;

	//returns void, accepts int input, throws InterruptedException and is synchronized
	public synchronized void increWHydrogen(int index) throws InterruptedException {
		//waits when there are more than 5 Hydrogen atoms
		while(waitingHydrogen > 5) {
			wait();
		}
		//adds a new Hydrogen atom
		waitingHydrogen++;
		notifyAll();
		//if statement to ensure correct grammar is in place (ex. 0th, 1st, 2nd, 3rd, 4th)
		if(index == 1)
			System.out.println("The " + index + "st hydrogen atom was added.");
		else if(index == 2)
			System.out.println("The " + index + "nd hydrogen atom was added.");
		else if(index == 3)
			System.out.println("The " + index + "rd hydrogen atom was added.");
		else
			System.out.println("The " + index + "th hydrogen atom was added.");
	}
	//returns void, accepts int input, throws InterruptedException and is synchronized
	public synchronized void increWOxygen(int index) throws InterruptedException {
		//waits when there are more than 2 Oxygen atoms
		while(waitingOxygen > 2) {
			wait();
		}
		//adds a new Oxygen atom
		waitingOxygen++;
		notifyAll();
		if(index == 1)
			System.out.println("The " + index + "st oxygen atom was added.");
		else if(index == 2)
			System.out.println("The " + index + "nd oxygen atom was added.");
		else if(index == 3)
			System.out.println("The " + index + "rd oxygen atom was added.");
		else
			System.out.println("The " + index + "th oxygen atom was added.");
	}
	//returns void, accepts int input, throws InterruptedException and is synchronized
	public synchronized void react(int index) throws InterruptedException {
		//waits when there aren't enough Hydrogen or Oxygen atoms to create a water molecule
		while(waitingHydrogen < 2 || waitingOxygen < 1) {
			wait();
		}
		//subtracts the atoms that were used
		waitingHydrogen--;
		waitingHydrogen--;
		waitingOxygen--;
		notifyAll();
		if(index == 1)
			System.err.println("The " + index + "st water molecule was added.");
		else if(index == 2)
			System.err.println("The " + index + "nd water molecule was added.");
		else if(index == 3)
			System.err.println("The " + index + "rd water molecule was added.");
		else
			System.err.println("The " + index + "th water molecule was added.");
	}
}
//class Hydrogen that implements Runnable
class Hydrogen implements Runnable {
	//instance variable
	ReactionArea buff;

	//Hydrogen constructor that accepts RectionArea buff variable
	public Hydrogen(ReactionArea buff) {
		this.buff = buff;
	}
	public void run() {
		for(int i = 0; i < 20; i++) {
			try {
				buff.increWHydrogen(i);
				Thread.sleep(100);
			}catch(InterruptedException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}
}
//class Oxygen that implements Runnable
//same class as Hydrogen and Rector, just different sleep timer
class Oxygen implements Runnable {
	//instance variable
	ReactionArea buff;

	//Oxygen constructor that accepts RectionArea buff variable
	public Oxygen(ReactionArea buff) {
		this.buff = buff;
	}
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				buff.increWOxygen(i);
				Thread.sleep(200);
			}catch(InterruptedException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}
}
//class Reactor that implements Runnable
//same class as Hydrogen and Oxygen, just different sleep timer
class Reactor implements Runnable {
	//instance variable
	ReactionArea buff;

	//Reactor constructor that accepts RectionArea buff variable
	public Reactor(ReactionArea buff) {
		this.buff = buff;
	}
	public void run() {
		for(int i = 0; i < 10; i++) {
			try {
				buff.react(i);
				Thread.sleep(50);
			}catch(InterruptedException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}
}