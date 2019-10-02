/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SalesTax;

import javax.swing.JOptionPane;

/**
 *
 * @author ctdecker2727
 */
public class WelcomeDemo {

    public static void main(String[] args) {
        
        String name = JOptionPane.showInputDialog("Enter your name here: ");
    
        JOptionPane.showMessageDialog(null, "Welcome to Java, " + name + ".");
        
    
    }  
}
