
public class SavingsAccount extends Account{        // SavingsAccount inherits the Account class
	
	private double monthlyInterestRate; 			// instance variable for monthly interest rate
	private double monthlyInterestPayment;			// instance variable for monthly interest payment
	
	public SavingsAccount(){						// constructor method initializes the monthly interest rate and balance
		
		monthlyInterestRate = 0.01;
		this.balance = 1_000;
	
	}
	public void calculateMonthlyInterestPayment(){   // this method is to calculate monthly interest payment
		
		monthlyInterestPayment = this.balance * monthlyInterestRate;
	
	}
	public double getMonthlyInterestPayment(){  // this method is to get monthly interest payment
		
		return monthlyInterestPayment;

	}
	public void addMonthlyInterestPayment(){        // this method is to add monthly interest payment to balance
		
		this.balance += monthlyInterestPayment;
		
	}
	@Override
	public void withdraw(double amount){      //this method withdraws amount from balance. 
		if(amount > this.balance){            // if balance will be negative after withdraw, do not do the transaction.
			System.out.println("Invalid transaction.Not enough money in the account");  // Inform the user that  there is not enough money in the account
		}
		else{
			super.withdraw(amount);     // if there is enough money, perform transaction.
		}
		
	}
}
