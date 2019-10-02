package hw2chrisdecker;
import java.util.ArrayList;
import java.util.Date;

/*
 @author Chris Decker
*/

public class Account {
    private int accountID;
    private String name;
    private double balance;
    private double interestRate;
    private Date creationDate;
    private ArrayList<Transaction> transactions = new ArrayList<>();
    
    public Account(){
        accountID = 0;
        balance = 0;
        interestRate = 0;
        creationDate = new Date();
    }
    public Account(int newAccountID, String newName, double newBalance){
        accountID = newAccountID;
        name = newName;
        balance = newBalance;
        interestRate = 0;
        creationDate = new Date();
    }
    
    public int getAccountID(){
        return accountID;
    }
    public double getBalance(){
        return balance;
    }
    public double getInterestRate(){
        return interestRate;
    }
    public void setAccountID(int newAccountID){
        accountID = newAccountID;
    }
    public void setBalance(double newBalance){
        balance = newBalance;
    }
    public void setInterestRate(double newInterestRate){
        interestRate = newInterestRate;
    }
    public String getName(){
        return name;
    }
    public ArrayList getTransaction(){
        return transactions;
    }
    public Date getCreationDate(){
        return creationDate;
    }

    public double getMonthlyInterestRate(double interestRate){
        interestRate = (interestRate/12)/100;
        return interestRate;
    }
    public double getMonthlyInterest(double interestRate, double balance){
        double interest;
        interest = ((interestRate/100)/12)*balance;
        return interest;
    }
    public void withdraw(double withdraw, double newbalance, String description){
        balance = newbalance - withdraw;
        transactions.add(new Transaction('W', withdraw, balance, description));
    }
    public void deposit(double deposit, double newbalance, String description){
        balance = newbalance + deposit;
        transactions.add(new Transaction('W', deposit, balance, description));
    }
}
