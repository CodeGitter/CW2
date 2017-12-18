
package main;
import services.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Main {
    
    public static Account newAccount = null; 
    public static ArrayList<User> regUsers = null;
    public static void main(String[] args)
    {
         //registered users
        while(true){Menu();}
    }
    
    
    public static void Menu()
    {
        Scanner inReader = new Scanner(System.in);
        String UserInput;
        
        
        
        System.out.println("~~~~~~~Menu~~~~~~~");
        System.out.println("Please Select an option: ");
        System.out.println("1. Create a Bank Acount.");
        System.out.println("2. Create a User");
        System.out.println("3. Run Simulation");
        System.out.println("4. Exit ");
        
        UserInput = inReader.nextLine();
        
        
        if(UserInput.equals("1"))
        {

            newAccount = new Account(9876543210L, 1980.00 ); //hardcoded acc num and balance

            System.out.println("Your Account Was Successfully Created!");
            System.out.println("Your account number is: " + newAccount.getAccountNo());
            System.out.println("Your account balance is: " + newAccount.getAccountBalance());
        }
        else if(UserInput.equals("2"))
        {
            if(newAccount != null)
            {
                UserCreator();
            }
            else
            {
                System.out.println("Please Create An Account First");
            }  
        }
        else if(UserInput.equals("3")) //
        {
            if(newAccount != null)
            {
                for(int i=0; i < 4; i++)
                {
                    try
                    {
                        User tempUser = regUsers.get(i);
                        if(tempUser != null)
                        {
                           tempUser.start(); //thread will remain active even when  tempUser is ovewritten
                           tempUser.join(); // not letting the main thread exe
                           // anything until this thread is started
                           System.out.println("User Started");
                        }
                    }
                    catch(NullPointerException NullEx)
                    {
                        System.out.println("No Users Were Created!!!!");
                        System.out.println(NullEx.getMessage());
                    } catch (InterruptedException ex) {
                        System.out.println(ex.getMessage());
                        System.out.println(ex.getStackTrace()); //Gives the info on which stack the ex happened in

                    }
                }
            }
        }
    }
    
    public static ArrayList<User> UserCreator()
    {
        regUsers = new ArrayList(); 
        
        double[] tranUser1 = {50, 10, -20, 10, -20, 20, 10, 50, -10, 10, -10, 50};
        double[] tranUser2 = {20, 20, -20, 50, -20, 10, 50, 50, -20, 10, 10};
        double[] tranUser3 = {50, 10, 10, -10, -10, 50, 20, -10, -20};
        double[] tranUser4 = {50, 10, -20, 20, 10, -20};

        User user1 = new User("Saul", "Goodman", newAccount, tranUser1);
        User user2 = new User("Walter", "White", newAccount, tranUser2);
        User user3 = new User("Jessie", "Pinkman", newAccount, tranUser3);
        User user4 = new User("Hank", "Schrader", newAccount, tranUser4);

        regUsers.add(user1);
        regUsers.add(user2);
        regUsers.add(user3);
        regUsers.add(user4);
        
        return regUsers;

    }
}
