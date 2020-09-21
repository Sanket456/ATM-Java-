package ATM_Machine;

import java.io.IOException;
import java.util.*;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;


public class Accounts {
    
	private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;
	
	Scanner input = new Scanner(System.in);
    DecimalFormat moneyformat = new DecimalFormat("'$'###,##0.00");
    
    public int setCustomerNumber(int cusNum)
    {
     this.customerNumber = cusNum;
     return customerNumber;
    }
    
    public int getCustomerNumber()
    {
      return customerNumber;	
    }
    
    public int setPinNumber(int pinNumber){
    	this.pinNumber = pinNumber;
    	return pinNumber;
    }
    
    public int getPinNumber()
    {
      return pinNumber;	
    }
    
    public double getCheckingBalance()
    {
     return checkingBalance;	
    }
    
    public double getSavingBalance()
    {
     return savingBalance;	
    }
    
    public double calcCheckingWithdrawn(double amount)
    {
     checkingBalance = (checkingBalance - amount);
     return checkingBalance;
    }
    
    public double calcSavingWithdrawn(double amount)
    {
     savingBalance = (savingBalance - amount);
     return savingBalance;
    }
    
    public double calcCheckingDeposite(double amount)
    {
     checkingBalance = (checkingBalance + amount);
     return checkingBalance;
    }
    
    public double calcSavingDeposite(double amount)
    {
     savingBalance = (savingBalance + amount);
     return savingBalance;
    }
    
    public void getCheckingWithdrawnInput()
    {
     System.out.println("Checking Account Balance:" +moneyformat.format(checkingBalance));
     System.out.println("Amount you want to withdraw from Checking Account:");
     double amount = input.nextDouble();
     
     if((checkingBalance - amount)>0)
     {
      calcCheckingWithdrawn(amount);
      System.out.println("New Checking Account Balance:" +moneyformat.format(checkingBalance));
     }
     else
     {
    	 System.out.println("Balance Cannot be Negative: " + "\n");	 
     } 
    }
    
    public void getCheckingDepositInput()
    {
     System.out.println("Checking Account Balance:" +moneyformat.format(savingBalance));
     System.out.println("Amount you want to Deposite to Checking Account:");
     double amount = input.nextDouble();
         
         if((checkingBalance + amount)>=0)
         {
          calcCheckingWithdrawn(amount);
          System.out.println("Saving Account Balance:" +moneyformat.format(savingBalance));
         }
    }
    
    public void getSavingDepositInput()
    {
     System.out.println("Saving Account Balance:" +moneyformat.format(savingBalance));
     System.out.println("Amount you want to Deposite to Saving Account:");
     double amount = input.nextDouble();
         
         if((checkingBalance + amount)>=0)
         {
          calcCheckingWithdrawn(amount);
          System.out.println("Saving Account Balance:" +moneyformat.format(savingBalance));
         }
    }
    
    public void getSavingWithdrawnInput()
    {
     System.out.println("Saving Account Balance:" +moneyformat.format(savingBalance));
     System.out.println("Amount you want to Withdraw from Saving Account:");
     double amount = input.nextDouble();
         
         if((checkingBalance - amount)>0)
         {
          calcCheckingWithdrawn(amount);
          System.out.println("Saving Account Balance:" +moneyformat.format(savingBalance));
         }
         else
         {
        	 System.out.println("\n" + "Balance Cannot be Negative" + "\n");	 
         }
         	
    }

}
