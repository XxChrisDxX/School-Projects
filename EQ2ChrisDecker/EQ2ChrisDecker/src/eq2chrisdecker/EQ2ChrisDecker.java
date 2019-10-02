package eq2chrisdecker;

/*
 @author ctdecker2727
*/

public class EQ2ChrisDecker {

    public static void main(String[] args) {
        
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(3,1); //width, length
        
        System.out.println("The length of Rectangle r1 is " + r1.getLength() + "."); //add the method
        System.out.println("The width of Rectangle r1 is " + r1.getWidth() + ".");
        System.out.println("The area of Rectangle r1 is " + r1.getArea() + ".");
        System.out.println("The perimeter of Rectangle r1 is " + r1.getPerimeter() + ".");
        
        r2.setLength(5);
        
        System.out.println("The length of Rectangle r2 is " + r2.getLength() + "."); //add the method
        System.out.println("The width of Rectangle r2 is " + r2.getWidth() + ".");
        System.out.println("The area of Rectangle r2 is " + r2.getArea() + ".");
        System.out.println("The perimeter of Rectangle r2 is " + r2.getPerimeter() + ".");
        
        r2.setWidth(3);
        
        System.out.println("The length of Rectangle r2 is " + r2.getLength() + "."); //add the method
        System.out.println("The width of Rectangle r2 is " + r2.getWidth() + ".");
        System.out.println("The area of Rectangle r2 is " + r2.getArea() + ".");
        System.out.println("The perimeter of Rectangle r2 is " + r2.getPerimeter() + ".");
    }
    
}
