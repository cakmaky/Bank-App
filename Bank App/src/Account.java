
public class Account implements BankInterface {  // Account class implements all functions in BankInterface

	protected double balance; 				    // instance variable for the balance.
	
	public Account(){     // constructor method
		
	}
	public void deposit(double amount){    // to deposit a money
		
		balance += amount;
	
	}
	public void withdraw(double amount){  // to withdraw a money
	
		balance -= amount;
			
	}
	public double getBalance(){        // to get the current balance
	
		return balance;
		
	}
	public void setBalance(double amount){   // to set the balance
    	
    	balance = amount;
    	
    }	
}







