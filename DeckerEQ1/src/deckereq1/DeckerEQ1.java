/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package deckereq1;
import java.util.Scanner;

/**
 *
 * @author ctdecker2727
 */
public class DeckerEQ1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int num = (int)(Math.random()*101);
        System.out.println("Guess an integer number between 0 and 100");
        Scanner input = new Scanner(System.in);
        
        int guess;
        do{
            System.out.println("Enter your guess number here: ");
            guess = input.nextInt();
            
            if(guess == num){
                System.out.println("You guessed right!");
            }
            else if(guess > num){
                System.out.println("You guessed too high. Try again.");
            }
            else {
                System.out.println("You guessed too low. Try again.");
            }
        }while(guess != num);
    
    }
    
}
