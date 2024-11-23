package lab6;

public class SavingsAccount extends BankAccount{
	private double rate = .025;
	private int savingsNumber = 0;
	private String accountNumber;
	
	public SavingsAccount(String name, int balance) {
		super(name,balance);
		accountNumber = (numberOfAccounts-1+"-"+savingsNumber);
	}
	public SavingsAccount(SavingsAccount s, double balance) {
		super(s,balance);
		savingsNumber=s.savingsNumber+1;
		accountNumber = (numberOfAccounts-1+"-"+savingsNumber);
	}
	
	public void postInterest() {
		deposit(getBalance()*(rate/12));
	}
	@Override
	public String getAccountNumber() {
		return accountNumber;
	}
}
