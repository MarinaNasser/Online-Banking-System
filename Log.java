package loginDemo;
//import java.util.*; 
import java.util.HashMap;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Toolkit;

public class Log {

	static HashMap<String,Account> map= new HashMap<String,Account>();
	static HashMap<String,Account> vipMap= new HashMap<String,Account>();
	
	static 
	{
		Account user = new Account("Mostafa",500,"123456","555",10000,false);
		map.put(user.getId(),user);
		Account user2 = new Account("Yousef",1000,"445566","666",10000,false);
		map.put(user2.getId(), user2);
		Account user3 = new Account("Marina",4500,"456789","444",10000,false);
		map.put(user3.getId(), user3);
		
		AccountVip user11 = new AccountVip("Michael",7000,"223344","111",60000,false);
		vipMap.put(user11.getId(), user11);
		AccountVip user22 = new AccountVip("Rawan",8000,"112233","222",60000,false);
		vipMap.put(user22.getId(), user22);
		AccountVip user33 = new AccountVip("Mohab",11000,"667788","333",60000,false);
		vipMap.put(user33.getId(), user33);
		
	}
	

	private JFrame frmBankSystem;
	private JTextField idTextField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Log window = new Log();
					window.frmBankSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Log() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBankSystem = new JFrame();
		frmBankSystem.getContentPane().setBackground(new Color(0, 206, 209));
		frmBankSystem.setIconImage(Toolkit.getDefaultToolkit().getImage(Log.class.getResource("/image/internet-banking-vector-icon.jpg")));
		frmBankSystem.setBounds(100, 100, 417, 331);
		frmBankSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBankSystem.getContentPane().setLayout(null);
		
		idTextField = new JTextField();
		idTextField.setBounds(152, 86, 140, 30);
		frmBankSystem.getContentPane().add(idTextField);
		idTextField.setColumns(10);
		
		JLabel idLabel = new JLabel("ID");
		idLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		idLabel.setBounds(52, 86, 90, 30);
		frmBankSystem.getContentPane().add(idLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordLabel.setBounds(52, 140, 90, 30);
		frmBankSystem.getContentPane().add(passwordLabel);
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(152, 140, 138, 27);
		frmBankSystem.getContentPane().add(passwordField);
		
		JRadioButton vipRadioButton = new JRadioButton("VIP");
		vipRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		vipRadioButton.setBackground(new Color(0, 206, 209));
		
		vipRadioButton.setBounds(294, 90, 55, 21);
		frmBankSystem.getContentPane().add(vipRadioButton);
		
		
		JButton LogInButton = new JButton("Log In");
		LogInButton.setForeground(new Color(0, 0, 0));
		LogInButton.setBackground(new Color(0, 206, 209));
		LogInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				String idd = idTextField.getText();
				String passText = new String(passwordField.getPassword());
				if(!vipRadioButton.isSelected())
				{
					
					
					
					try 
					{
						if(map.get(idd).getPassword().equals(passText))
						{
							frmBankSystem.dispose();
							
							Home temp = new Home(map.get(idd));
							temp.setVisible(true);
						}
						else
						{
							JOptionPane.showMessageDialog(null,"wrong password");
						}
							
					}
					catch(Exception ee)
					{
						JOptionPane.showMessageDialog(null,"ID not found");
					}
				}
				else
				{
					try 
					{
						if(vipMap.get(idd).getPassword().equals(passText))
						{
							frmBankSystem.dispose();
							Home temp = new Home(vipMap.get(idd));
							temp.setVisible(true);
						}
						else
						{
							JOptionPane.showMessageDialog(null,"wrong password");
						}
							
					}
					catch(Exception ee)
					{
						JOptionPane.showMessageDialog(null,"ID not found");
					}
				}
				
			}
		});
		LogInButton.setBounds(165, 199, 113, 30);
		frmBankSystem.getContentPane().add(LogInButton);
		
		JLabel lblNewLabel = new JLabel("Bank system");
		lblNewLabel.setFont(new Font("Unispace", Font.BOLD, 23));
		lblNewLabel.setBounds(131, 10, 161, 27);
		frmBankSystem.getContentPane().add(lblNewLabel);
		
		
	}
}
