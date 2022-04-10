package loginDemo;

import javax.swing.JOptionPane;

//import project.AccMain;
//import project.Account;

public class Account {

	private String name;
	protected float balance;
	protected float creditCard;
	private String id;
	private String password;
	private int daysLeft;
	protected boolean indebtedStatus;
	private String withdrawalDate;
	protected float creditCardLimit = 10000;

	public Account(String name, float balance, String id, String password, float creditCard, boolean indebtedStatus) {
		this.name = name;
		this.balance = balance;
		this.id = id;
		this.password = password;
		this.creditCard = creditCard;
		this.indebtedStatus = indebtedStatus;
	}

//getters
	public String getWithdrawalDate() {
		return withdrawalDate;
	}

	public boolean getIsIndebtedStatus() {
		return indebtedStatus;
	}

	public int getDaysLeft() {
		return daysLeft;
	}

	public String getName() {
		return (name);
	}

	public float getCreditCard() {
		return creditCard;
	}

	public float getBalance() {
		return (balance);
	}

	public String getId() {
		return (id);
	}

	public String getPassword() {
		return (password);
	}

	public float getCreditCardLimit() {
		return (creditCardLimit);
	}

//setters
	public void setWithdrawalDate(String withdrawalDate) {
		this.withdrawalDate = withdrawalDate;
	}

	public void setDaysLeft(int days) {
		this.daysLeft = days;
	}

	public void setCreditCard(float creditCard) {
		this.creditCard = creditCard;
	}

	public void depositBalance(float amount) {
		if (amount < 0) {
			JOptionPane.showMessageDialog(null, "please enter a positive number");
			amount = 0;
		} else if (amount > 5000 || amount < 50) {
			JOptionPane.showMessageDialog(null, "you must deposit between 50 and 5000 unnless you are VIP");
			amount = 0;
		} else
			JOptionPane.showMessageDialog(null, "your transaction has been done successfully");
		balance += amount;
	}

	public void depositCredit(float amount) {
		if (amount < 0) {
			JOptionPane.showMessageDialog(null, "please enter a positive number");
			amount = 0;
		}
		else if (amount > 5000 || amount < 50) {
			JOptionPane.showMessageDialog(null, "you must deposit between 50 and 5000 unnless you are VIP");
			amount = 0;
		}
		
		creditCard += amount;
		if (creditCard > 10000)

		{
			creditCard -= amount;
			JOptionPane.showMessageDialog(null,
					"you can not exceed 10000 in the credit card your transaction hasnot been done,"
							+ " you can deposit up to " + Float.toString(creditCardLimit - creditCard));

		} else if (creditCard == 10000 && amount != 0) {
			daysLeft = 0;
			indebtedStatus = false;
			JOptionPane.showMessageDialog(null,"your transaaction has been done successfully");
		}
		else if (amount >= 50 && amount <= 5000) 
		{
			JOptionPane.showMessageDialog(null,"your transaaction has been done successfully");
		}

	}

	public void balanceWithdraw(float decrement) {
		balance -= decrement;
	}

	public void creditWithdraw(float decrement) {
		creditCard -= decrement;
		if (creditCard < creditCardLimit && daysLeft <= 0)
			indebtedStatus = true;
	}

	public float transferAmount(float amount, Account transferedTo) {

		if ((amount > this.balance)) {
			JOptionPane.showMessageDialog(null, "you must transfer an amount less than what you currently own\n");
			amount = 0;
		} else if (amount <= 0) {
			JOptionPane.showMessageDialog(null, "please enter a positive number");
			amount = 0;
		} else if (amount > 150) {
			JOptionPane.showMessageDialog(null, "You cannot transfer more than 150L.E unless you are VIP");
			amount = 0;
		}
		this.balance -= amount;
		transferedTo.balance += amount;
		return (amount);
	}
}
