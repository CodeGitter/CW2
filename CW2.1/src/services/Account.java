package services;

public class Account {

    private long accountNo; //9876543210
    private double accountBalance; //1980.00
    
    public Account(long accountNo, double accountBalance)
    {
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;
    }
    
    public long getAccountNo()
    {
        return this.accountNo;
    }
    
    public double getAccountBalance()
    {
        return this.accountBalance;
    }
    
    public void deposit(double value, User userIn)
    {
        double currentBal = this.accountBalance;
        double newBal = (currentBal + value);
        this.accountBalance = newBal;
        System.out.println("Deposit completed by user "+ userIn.getUserName());
        System.out.println("New Balance: "+ newBal);

    }
    
    public void withdraw(double value, User userIn)
    {
        double currentBal = this.accountBalance;
        double newBal = (currentBal + value);   // + because values are negative in list of transactions
        this.accountBalance = newBal;
        System.out.println("Withdraw completed by user "+ userIn.getUserName());
        System.out.println("New Balance: "+ newBal);

    }

    
}
