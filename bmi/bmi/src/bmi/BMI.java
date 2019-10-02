/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bmi;

import java.util.Scanner;

/**
 *
 * @author ctdecker2727
 */
public class BMI {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter your weight in kilograms: ");
        double weight = input.nextDouble();
        System.out.println("Enter your weight in meters: ");
        double height = input.nextDouble();
        
        double bIndex = bmi(height, weight);
        String bmiStatus = status(bIndex);
        
        System.out.println("Your bmi index is " + bIndex + " and your bmi status is " + bmiStatus + ".");
    }
    
    public static double bmi(double height, double weight) {
        return weight / (height*height);
    }
    
    public static String status(double b) {
        String s;
        
        if(b<18.5)
            s = "Underweight";
        else if(b<25)
            s = "Normal";
        else if(b<30)
            s = "Overweight";
        else
            s = "Obese";
        
        return s;
    }
        
}
