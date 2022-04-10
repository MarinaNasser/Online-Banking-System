package loginDemo;

import javax.swing.JOptionPane;

public class AccountVip extends Account {
	
	
	public AccountVip(String name, float balance, String id, String password, float creditCard,boolean indebtedStatus) {
		super(name, balance, id, password, creditCard,indebtedStatus);
		creditCardLimit=60000;
	}
	
	
	
@Override
public void depositBalance(float amount)
{
	if(amount > 0) {
		balance += amount;
		JOptionPane.showMessageDialog(null,"your transaction has been done successfully");
	}
	else JOptionPane.showMessageDialog(null,"please enter a positive number");
}
@Override
public void depositCredit(float amount)
{
	if(amount > 0) 
	{
		
		creditCard+=amount;
		
		if(creditCard > creditCardLimit)
		
		{
			creditCard -= amount;
			JOptionPane.showMessageDialog(null,"you can not exceed 60000 in the credit card, your transaction hasnot been done,"
					+ " you can deposit up to "+Float.toString(creditCardLimit - creditCard  ));
			
		}
		else if(creditCard == creditCardLimit) 
			{
				this.setDaysLeft(0);
				indebtedStatus = false;
				JOptionPane.showMessageDialog(null,"your transaaction has been done successfully");
			}
		else 
		{
			JOptionPane.showMessageDialog(null,"your transaaction has been done successfully");
		}
	}
	else JOptionPane.showMessageDialog(null,"please enter a positive number");
		
}
@Override
public float transferAmount(float amount,Account transferedTo)
{
	
	if( (amount > this.balance)  )
	{
		JOptionPane.showMessageDialog(null,"you must transfer an amount less than what you currently own\n");
		amount=0;
	}
	else if(amount <= 0) 
	{
		JOptionPane.showMessageDialog(null,"please enter a positive number");
		amount = 0;
	}
	this.balance -= amount;
	transferedTo.balance += amount;
	return(amount);
}



}
