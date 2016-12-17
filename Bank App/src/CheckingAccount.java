
public class CheckingAccount extends Account{  // CheckingAccount inherits the Account class
	
	private double monthlyFee;				//  instance variable for the monthly fee
	
	public CheckingAccount(){              // constructor method initializes the monthly fee and balance
		
		monthlyFee = 1.00;
		this.balance = 1_000;
		
	}
	public double getMonthlyFee(){        // this method gets monthly fee
		
		return monthlyFee;
		
	}
	public void subtractFee(){           // this method subtracts monthly fee from the balance
		
		this.balance -= monthlyFee;
		 
	}
	@Override
	public void withdraw(double amount){   //this method withdraws amount from balance
		if((amount + monthlyFee) > this.balance){   // if balance will be negative after withdraw, do not do the transaction.
			System.out.println("Invalid transaction.Not enough money in the account");  // Inform the user that  there is not enough money in the account
		}
		else{
			super.withdraw(amount);   // if there is enough money, perform transaction.
		}
		
	}
	
	
}
