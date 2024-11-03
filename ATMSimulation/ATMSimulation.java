/* This project is a basic ATM Simulation that allow users to: 
     1. Check Balance 
     2. Deposit Money 
     3. Withdraw Money 
     4. Exit Menu 
     
    And implement error handling for insufficient funds when withdrawing. */

package project.atmsimulation;

import java.util.Scanner;

//Declaring class ATM
class ATM {
    
    float totalBalance = 0.0f; // Initial total balance
    Scanner scan = new Scanner(System.in); //Initialize scanner

    //Constructor
    ATM (float initialBalance){
        this.totalBalance=initialBalance;
    }
    
    //Method for calculation of deposit
    float depositCalculation(float amount) {
        //calculate total Balance as user input new amount
        totalBalance += amount; //add amount to totalBalance
        return totalBalance; // return totalBalance
    }
    
    //Method for calculation of withdrawal
    float withdraw(float amountToWithdraw) {
        
        //Check if amount to withdraw is positive value
        if (amountToWithdraw <= 0){
            System.out.println("\t\tInvalid amount. Please enter a positive value.");
            return totalBalance;
        }
        
        //check if amount to withdraw is greater than the totalBalance
        if (amountToWithdraw > totalBalance) {
            System.out.println("\t\tInsufficient funds. Transaction failed.");
            return totalBalance; // totalBalance remains unchanged
        } else { //else if totalBalance have sufficient funds
            totalBalance -= amountToWithdraw; //totalBalance will be reduce my amountTo Withdraw
            return totalBalance; // Update the totalBalance 
        }
    }

    //Method for Checking Balance
    float checkBalance() {
        return totalBalance;
    }
    
    //Method to perform Deposit
    void performDeposit() {
        //Prompt User to input amount to deposit
        System.out.println("\n\t\t\t   DEPOSIT MONEY");
        System.out.print("\t\tEnter amount to deposit: Php ");
            float amount = scan.nextFloat();
       
                //Check if amount entered is positive value.
                if (amount <= 0) {
                    System.out.println("\t\tInvalid amount. Enter a positive value.");
                } else { //If amount is positive; amount is added to totalBalance
                    depositCalculation(amount); //call method for depositCalculation
                    System.out.println("\t\t    --SUCCESSFULLY DEPOSITED--");
                    System.out.printf("\t\tNew Balance: Php %.2f\n", totalBalance);
                }
    }

    //Method to perform Withdraw
    void performWithdraw() {
        //Prompt User to input amount to withdraw
        System.out.println("\n\t\t\t   WITHDRAW MONEY");
        System.out.print("\t\tEnter amount to withdraw: Php ");
            float amount = scan.nextFloat();
       
                //Check if amount entered is positive value.
                if (amount <= 0) {
                    System.out.println("\t\tInvalid amount. Enter a positive value.");
                } else {
                    float previousBalance = totalBalance; // initialze prev balance to totalbalance
                    float newBalance = withdraw(amount); //perform method withdraw for newBalance
                    
                    //Check if newBalance is equal to previousbalance
                    if (newBalance == previousBalance) {       
                        System.out.printf("\t\tBalance unchanged: Php %.2f\n", totalBalance);
                    } else { //if newBalance != to prev Balance, withdrawal is successful
                        System.out.println("\t\t    ----SUCCESSFULLY WITHDRAWN----");
                        System.out.printf("\t\tNew balance: Php %.2f\n", newBalance);
                    }
                }
    }
}

public class ATMSimulation {
    public static void main(String[] args) {
       
        Scanner scan = new Scanner(System.in); //Initialize scanner
        ATM atm = new ATM(0.0f); //Object Instantiation

        //Header
        System.out.println("\t___________________________________________________");
        System.out.println("\t\t           ATM SIMULATION ");
        System.out.println("\t___________________________________________________");

         do{
        //Menu Selection
            System.out.println("\n\t\t\t\tMENU");
            System.out.println("\t\t\t1. Check Balance");
            System.out.println("\t\t\t2. Deposit Money");
            System.out.println("\t\t\t3. Withdraw Money");
            System.out.println("\t\t\t4. Exit");
            System.out.print("\n\t\t\tSELECT OPTION: "); 
            //Prompt User to enter option
            int option = scan.nextInt();
            System.out.println("\t___________________________________________________");
            

            switch (option) {
                case 1: // 1. Check balance
                    System.out.println("\n\t\t\t   CHECK BALANCE");
                    System.out.printf("\t\t    Current Balance: Php %.2f\n", atm.checkBalance());
                    System.out.println("\t___________________________________________________");

                    break;
                case 2: // 2. Deposit Money
                    atm.performDeposit();
                    System.out.println("\t___________________________________________________");
                    break;
                case 3: // 3. Withdraw Money
                    atm.performWithdraw();
                    System.out.println("\t___________________________________________________");
                    break;
                case 4: // 4. Exit
                    System.out.println("\t\t\t  ....EXITING....");
                    System.out.println("\t___________________________________________________");

                    break; // Exit the loop
                default:
                    System.out.println("\t      Invalid option. Please choose between 1-4.");
                    System.out.println("\t___________________________________________________");
            }

               if (option == 4){
                   break;
               }
        } while (true); 

        scan.close();
    }
}
