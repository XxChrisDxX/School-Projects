package hw2chrisdecker;
import java.util.Date;

/*
 @author Chris Decker
*/

public class Transaction {
    private Date date;
    private char type;
    private double amount;
    private double balance;
    private String description;
    
    public Transaction(char newType, double newAmount, double newBalance, String newDescription){
        type = newType;
        amount = newAmount;
        balance = newBalance;
        description = newDescription;
        date = new Date();
    }
    
    public Date getDate(){
        return date;
    }
    public char getType(){
        return type;
    }
    public double getAmount(){
        return amount;
    }
    public double getBalance(){
        return balance;
    }
    public String getDescription(){
        return description;
    }
}
