package HW3ChrisDecker;

/*
 @author ctdecker2727
*/

public class FutureValue {
    private double annualInterestRate;
    private int numberOfYears;
    private double investmentAmount;
    private java.util.Date loanDate;

    public FutureValue(){
        this(2.5, 1, 1000);
    }
    
    public FutureValue(double annualInterestRate, int numberOfYears, double investmentAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.investmentAmount = investmentAmount;
        loanDate = new java.util.Date();
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public double getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(double investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public double getFutureValue() {
        double r = (annualInterestRate/1200);
        int n = (numberOfYears*12);
        double futureValue = (investmentAmount * ((Math.pow((1+r), n) - 1)/r));

        return futureValue;
    }

    public java.util.Date getLoanDate() {
        return loanDate;
    }
}
