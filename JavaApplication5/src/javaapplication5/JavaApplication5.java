/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication5;

/**
 *
 * @author Chris Decker
 */
public class JavaApplication5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    Foo f1 = new Foo();
    System.out.println("f1.i is " + f1.i + " f1.s is " + f1.s);
    Foo f2 = new Foo();
    System.out.println("f2.i is " + f2.i + " f2.s is " + f2.s);
    Foo f3 = new Foo();
    System.out.println("f3.i is " + f3.i + " f3.s is " + f3.s);
  }

  public Foo() {
    i++;
    s++;
  
    }
}
    
    

