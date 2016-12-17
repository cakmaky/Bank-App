import java.util.InputMismatchException;
import java.text.NumberFormat;
import java.util.Scanner;

public class AccountApp {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to the Account application\n");
		
		CheckingAccount checking = new CheckingAccount();   // creation of objects from classes
		SavingsAccount savings = new SavingsAccount();
		NumberFormat currency = NumberFormat.getCurrencyInstance();  // to write numbers in currency format
		
		String transactionType, accountType;
		double amount = -1;     // initialize amount to negative value
		String choice= "y";    // initialize choice to yes
		
		System.out.println("Starting Balances");
		
		System.out.println("Checking   : " + currency.format(checking.getBalance()));  // initial balances of checking and savings accounts
		System.out.println("Savings    : " + currency.format(savings.getBalance()));
		
		System.out.println("\nEnter the transactions for the month\n");
		
		while(choice.equalsIgnoreCase("y")){
		
		System.out.print("\nWithdrawal or deposit? (w/d): ");    // ask user the transaction type
		transactionType = input.nextLine();
		while(!(transactionType.equals("w") || transactionType.equals("d"))){   // If input is not valid, ask again
			System.out.print("Try again.Withdrawal or deposit? (w/d): ");
			transactionType = input.nextLine();	
		}
		
		System.out.print("Checking or savings? (c/s)  : ");      // ask user the account type
		accountType = input.nextLine();
		while(!(accountType.equals("c") || accountType.equals("s"))){     // If input is not valid, ask again
			System.out.print("Try again.Checking or savings? (c/s)  : ");
			accountType = input.nextLine();
		}
		
		while(amount < 0.0){         // get amount from user. If input is not valid, ask again.
			try {
				System.out.print("Amount?                     : ");
				amount = input.nextDouble();
			}
			catch(InputMismatchException e){
			    input.nextLine();
			}
		}
		
		if(transactionType.equals("w")){
			if(accountType.equals("c")){
				checking.withdraw(amount);	
			}
			else if(accountType.equals("s")){
				savings.withdraw(amount);  
				}	
		}											// perform transaction from suitable account
		else if(transactionType.equals("d")){
			if(accountType.equals("c")){
				checking.deposit(amount);	
			}
			else if(accountType.equals("s")){
				savings.deposit(amount);
			}
		}
			
		input.nextLine();
		System.out.print("\nContinue? (y/n)           : ");  // ask user to go on and check the input
		choice = input.nextLine();
		
		while(!(choice.equals("y") || choice.equals("n"))){  // if input is not valid, ask again
			System.out.print("Try again.Continue? (y/n) : ");
			choice = input.nextLine();
		}
		amount = -1;
  	
		}
		
		System.out.println("\nMonthly Payments and Fees");    // write outputs in currency format
		
		savings.calculateMonthlyInterestPayment();      // calculate monthly interest payment
		System.out.println("Checking fee            : " + currency.format(checking.getMonthlyFee()));   // write outputs in currency format
		System.out.println("Savings interest payment: " + currency.format(savings.getMonthlyInterestPayment()));
		
	
		System.out.println("\nFinal Balances ");
		
		checking.subtractFee();      // subtract monthly fee from balance
		savings.addMonthlyInterestPayment();     // add monthly interest payment to the balance
		
		System.out.println("Checking   : " + currency.format(checking.getBalance()));  // write final balances in currency format
		System.out.println("Savings    : " + currency.format(savings.getBalance()));
		
		System.out.println("\nProgram terminated!!!");  
		}
	}


