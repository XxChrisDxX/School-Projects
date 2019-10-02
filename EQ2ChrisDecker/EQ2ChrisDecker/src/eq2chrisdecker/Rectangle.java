package eq2chrisdecker;

/*
 @author ctdecker2727
*/

public class Rectangle {
    private double length;
    private double width;
    
    public Rectangle(){ //non-argument (cannot pass values, define in body) constructor to set default length and width to 1
        length = 1;
        width = 1;
    }
    
    public Rectangle(double newLength, double newWidth){ //2nd constructor with specific length and width (pass values directly to the constructor)
        length = newLength;
        width = newWidth;
    }
    
    //4 get methods for length, width, perimeter, area
    double getLength(){
        return length;
    }
    double getWidth(){
        return width;
    }
    double getPerimeter(){
        return 2*length + 2*width;
    }
    double getArea(){
        return length*width;
    }
    
    //2 set methods for length, width
    void setLength(double newLength){
        length = newLength;
    }
    void setWidth(double newWidth){
        width = newWidth;
    }
    
}