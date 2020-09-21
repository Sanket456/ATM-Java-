package ATM_Machine;
//Main Class

import java.io.IOException;
import java.util.*;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class OptionMenu extends Accounts 
 {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyformat = new DecimalFormat("'$'###,##0.00");
    
    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
    
    /* Data Validation */
    public void getLogin() throws IOException {
    int x = 1;
    
    do
    {
     try{
    	data.put(9876543,9876);
    	data.put(8989898,1890);
    	
    	System.out.println("Welcome to ATM Project");
    	
    	System.out.println("Enter Customer Number: ");
    	setCustomerNumber(menuInput.nextInt());
    	
    	System.out.println("Enter Pin Number: ");
    	setPinNumber(menuInput.nextInt());
     }
     catch(Exception e)
     {
    	 System.out.println("\n" + "Invalid Character(s). Only Number" + "\n");
    	 x=2;
     }
     
     for(Entry<Integer, Integer> entry: data.entrySet())
     {
      if(entry.getKey()==getCustomerNumber() && entry.getValue()==getPinNumber())
      {
       getAccountType();	  
      }
     }
     
     System.out.println("\n" + "Wrong Details" + "\n");
    }while(x==1);
   }
    
    /* Display Account type Menu with Selections*/
    
    public void getAccountType()
    {
     System.out.println("Select The Account you want to access: ");
     System.out.println("Type - 1: Checking Account ");
     System.out.println("Type - 2: Saving Account ");
     System.out.println("Type - 3: Exit");
     System.out.print("Choice: ");
     
     int selection = menuInput.nextInt();
     
     switch(selection){
     case 1: getChecking();
             break;
     case 2: getSaving();
             break;
     case 3: System.out.println("Thank you for using ATM");
             break;
     default: System.out.println("\n" + "Invalid Choice" + "\n");
             getChecking();
     }
    }
    
    public void getChecking()
    {
     System.out.println("Checking Account: ");
     System.out.println("Type - 1: View Balance ");
     System.out.println("Type - 2: Withdraw Funds ");
     System.out.println("Type - 3: Deposite Funds");
     System.out.println("Type - 4: Exit");
     System.out.print("Choice: ");
     
     int selections;
     selections =  menuInput.nextInt();
     
     switch(selections)
     {
     case 1: System.out.println("Saving Account Balance: " +moneyformat.format(getSavingBalance()));
             getAccountType();
             break;
     case 2: getCheckingWithdrawnInput();
             getAccountType();
             break;
     case 3: getCheckingDepositInput();
             getAccountType();
             break;
      
     case 4: System.out.println("Thank for Using ATM");        
             break;
     
     default: System.out.println("\n" + "Invalid Choice" + "\n");
              getSaving();
     }
     
    }
    
    public void getSaving()
    {
     System.out.println("Saving Account: ");
     System.out.println("Type - 1: View Balance ");
     System.out.println("Type - 2: Withdraw Funds ");
     System.out.println("Type - 3: Deposite Funds");
     System.out.println("Type - 4: Exit");
     System.out.print("Choice: ");
     
     int selections;
     selections =  menuInput.nextInt();
     
     switch(selections)
     {
     case 1: System.out.println("Saving Account Balance: " +moneyformat.format(getSavingBalance()));
             getAccountType();
             break;
     case 2: getSavingWithdrawnInput();
             getAccountType();
             break;
     case 3: getSavingDepositInput();
             getAccountType();
             break;
      
     case 4: System.out.println("Thank for Using ATM");        
             break;
     
     default: System.out.println("\n" + "Invalid Choice" + "\n");
              getSaving();
     }
     
    }
}
