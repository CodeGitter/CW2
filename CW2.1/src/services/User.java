package services;

public class User extends Thread
{
    private String name;
    private String surname;
    private Account BankAccount;
    
    private double[] transactionList;
    
    public void run()
    {
        System.out.println("RUN IS RUNNING");//debugging/testing
        
        for(int i = 0; i < getTransactionList().length; i++)
        {
            if(getTransactionList()[i] > 0)
            {
                double valueIn = getTransactionList()[i];
                
                getBankAccount().deposit(valueIn, this);
                
            }
            else if(getTransactionList()[i] < 0) //انا حمار
            {
                double valueIn = getTransactionList()[i];
                
                getBankAccount().withdraw(valueIn, this);
            }
        }
    }
    public User(String nameIn, String surnameIn, Account userAccountIn, double[] transacListIn)
    {
        this.name = nameIn;
        this.surname = surnameIn;
        this.BankAccount = userAccountIn;
        this.transactionList = transacListIn;
        System.out.println("User Created! - User Object Confirmation");
    }

    /**
     * @return the name
     */
    public String getUserName() {
        return name;
    }

    /**
     * @return the surname
     */
    public String getUserSurname() {
        return surname;
    }

    /**
     * @return the BankAccount
     */
    public Account getBankAccount() {
        return BankAccount;
    }

    /**
     * @return the transactionList
     */
    public double[] getTransactionList() {
        return transactionList;
    }
    
}
