package hw2chrisdecker;
import java.util.ArrayList;

/*
 @author Chris Decker
*/

/* Create an instance of the Account class with an annual interest rate of 1.5%, a balance of 1000, an id of 1122, and a name as George.
 Deposit $30, $40, and $50 to the account and then withdraw $5, $4, and $2 from the account.
 Print an account summary that shows the account holder’s name, annual interest rate, balance, monthly interest, and all transactions.*/
public class HW2ChrisDecker {

    public static void main(String[] args) {
        Account a1 = new Account(1122,"George",1000);
        a1.setInterestRate(1.5);
        
        a1.deposit(30, a1.getBalance(), "");
        a1.deposit(40, a1.getBalance(), "");
        a1.deposit(50, a1.getBalance(), "");
        a1.withdraw(5, a1.getBalance(), "");
        a1.withdraw(4, a1.getBalance(), "");
        a1.withdraw(2, a1.getBalance(), "");
        
        System.out.print("Account summary: ");
        System.out.println("Account Holder's Name: " + a1.getName() + ", Annual Interest Rate: " + a1.getInterestRate() + "%, Balance $" + a1.getBalance() + ", Monthly Interest $" + a1.getMonthlyInterest(a1.getInterestRate(), a1.getBalance()) + ".");
        System.out.println("Transactions:");
        
        ArrayList<Transaction> transactions = a1.getTransaction();
        for(int i = 0; i < transactions.size(); i++){
            System.out.print(transactions.get(i).getType() + " ");
            System.out.print(transactions.get(i).getAmount() + " ");
            System.out.print(transactions.get(i).getBalance() + " ");
            System.out.print(transactions.get(i).getDescription() + " ");
            System.out.println(transactions.get(i).getDate());
        }
    }
}
