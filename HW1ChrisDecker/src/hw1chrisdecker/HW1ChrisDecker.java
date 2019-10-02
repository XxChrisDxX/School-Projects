package hw1chrisdecker;

/* 
  @author Chris Decker
*/

public class HW1ChrisDecker {
    public static double computeCommission(double salesAmount) {
        double commission;
        
        if(salesAmount <= 5000)
            commission = salesAmount*.08;
        else if(salesAmount <= 10000)
            commission = (salesAmount-5000)*.1+5000*.08;
        else
            commission = (salesAmount-10000)*.12+5000*.08+5000*.1;

        return commission;
    }

    public static double round(double value, int decPlaces) {//value is for number to be rounded
        java.math.BigDecimal bigDecimal = new java.math.BigDecimal(value);
        bigDecimal = bigDecimal.setScale(decPlaces, java.math.RoundingMode.HALF_UP);
        
        return bigDecimal.doubleValue();
    }
    
    public static void main(String[] args) {

        double base = 5000;
        double c = 0;//c is short for commission
        double sales = 0;
        
        while(c<25000){
            sales = sales + .01;
            c = computeCommission(sales);
        }
        sales = round(sales, 2);
        c = round(c, 2);
        
        System.out.println("You will need a sales amount of $" + sales + " to reach a salary of $" + (base + c) + ".");
        
        System.out.println("Sales Amount 10000 gives a commission of " + computeCommission(10000) + ".");
        System.out.println("Sales Amount 15000 gives a commission of " + computeCommission(15000) + ".");
        System.out.println("Sales Amount 25000 gives a commission of " + computeCommission(25000) + ".");
        System.out.println("Sales Amount 50000 gives a commission of " + computeCommission(50000) + ".");
        System.out.println("Sales Amount 95000 gives a commission of " + computeCommission(95000) + ".");
        System.out.println("Sales Amount 100000 gives a commission of " + computeCommission(100000) + ".");
    }
}
