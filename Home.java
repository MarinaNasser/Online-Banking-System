package loginDemo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.Toolkit;
import javax.swing.BoxLayout;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

public class Home extends JFrame {

//	private JFrame Window;
	private JTextField balanceText;
	private JTextField creditText;
	private JTextField statusText;
	private JButton checkStatusButton;
	private JTextField withdrawlText;
	private JTextField balanceRemainingText;
	private JTextField depositAmountText;
	private JTextField newBalanceText;
	private JTextField recpientIdText;
	private JTextField amountTransferedText;
	private JTextField transferBalanceText;
	private JTextField dateWithdrawnText;
	private JTextField creditRemainingText;
	private JTextField creditBalanceText;
	private JTextField transferAmountTextField;
	private JTextField daysLeftText;
	private JTextField accountIdText;
	private JPanel contentPane;
	private JPasswordField accountPasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Home window = new Home(Account user);
//					window.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the application.
	 */

	/**
	 * Initialize the contents of the frame.
	 */
	public Home(Account user) {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Home.class.getResource("/image/internet-banking-vector-icon.jpg")));
//		Window = this;

		setTitle("Bank system");
		setBounds(100, 100, 729, 477);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(0, 206, 209));

		JPanel accountPanel = new JPanel();
		accountPanel.setBackground(UIManager.getColor("Button.light"));
		accountPanel.setName("Account");
		tabbedPane.addTab("Account", null, accountPanel, null);

		JLabel balanceLabel = new JLabel("Balance:");
		balanceLabel.setVisible(false);
		balanceLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

		balanceText = new JTextField();
		balanceText.setVisible(false);
		balanceText.setEditable(false);
		balanceText.setColumns(10);

		JLabel creditLabel = new JLabel("Credit Balance:");
		creditLabel.setVisible(false);
		creditLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

		creditText = new JTextField();
		creditText.setVisible(false);
		creditText.setEditable(false);
		creditText.setColumns(10);

		statusText = new JTextField();
		statusText.setText((user.getIsIndebtedStatus()) ? "indebited" : "not indebited");
		statusText.setVisible(false);
		statusText.setEditable(false);
		statusText.setColumns(10);

		JLabel statusLabel = new JLabel("Account Status:");
		statusLabel.setVisible(false);
		statusLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel daysLeftLabel = new JLabel("Days Left:");
		daysLeftLabel.setVisible(false);
		daysLeftLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

		daysLeftText = new JTextField();
		daysLeftText.setVisible(false);
		daysLeftText.setEditable(false);
		daysLeftText.setColumns(10);

		JLabel accountNameLabel = new JLabel(user.getName());
		accountNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel accounIdLabel = new JLabel("Id:");
		accounIdLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

		accountIdText = new JTextField();
		accountIdText.setText(user.getId());
		accountIdText.setText(user.getId());
		accountIdText.setColumns(10);

		JLabel accountPasswordLabel = new JLabel("Password:");
		accountPasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

		accountPasswordField = new JPasswordField();
		accountPasswordField.setText(user.getPassword());

		JRadioButton vipRadioButton = new JRadioButton("VIP");
		vipRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		vipRadioButton.setBackground(new Color(0, 206, 209));

		checkStatusButton = new JButton("Check Status");
		checkStatusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String idd = accountIdText.getText();
				String passText = new String(accountPasswordField.getPassword());

				try {

					Account userToBeChecked = (!vipRadioButton.isSelected()) ? Log.map.get(idd) : Log.vipMap.get(idd);

					if (userToBeChecked.getPassword().equals(passText)) {
						accountNameLabel.setText(userToBeChecked.getName());
						balanceText.setText(Float.toString(userToBeChecked.getBalance()));
						creditText.setText(Float.toString(userToBeChecked.getCreditCard()));
						daysLeftText.setText(Integer.toString(userToBeChecked.getDaysLeft()));

						balanceLabel.setVisible(true);
						balanceText.setVisible(true);

						creditLabel.setVisible(true);
						creditText.setVisible(true);

						statusLabel.setVisible(true);
						statusText.setVisible(true);

						if (userToBeChecked.getIsIndebtedStatus()) {
							statusText.setText("indebted");
							daysLeftLabel.setVisible(false);
							daysLeftText.setVisible(false);

						} else {

							daysLeftText.setText(Integer.toString(userToBeChecked.getDaysLeft()));
							statusText.setText("not indebted");
							if (userToBeChecked.getDaysLeft() > 0) {
								daysLeftLabel.setVisible(true);
								daysLeftText.setVisible(true);
							}
							else
							{
								daysLeftLabel.setVisible(false);
								daysLeftText.setVisible(false);
							}

						}

					} else {
						JOptionPane.showMessageDialog(null, "wrong password");
					}

				} catch (Exception ee) {
					JOptionPane.showMessageDialog(null, "ID not found");
				}

			}
		});
		checkStatusButton.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JSeparator separator_3 = new JSeparator();
		separator_3.setBackground(Color.BLACK);

		GroupLayout gl_accountPanel = new GroupLayout(accountPanel);
		gl_accountPanel
				.setHorizontalGroup(gl_accountPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_accountPanel.createSequentialGroup().addGap(244)
								.addComponent(checkStatusButton, GroupLayout.PREFERRED_SIZE, 139,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(639, Short.MAX_VALUE))
						.addGroup(gl_accountPanel.createSequentialGroup().addContainerGap()
								.addComponent(separator_3, GroupLayout.PREFERRED_SIZE, 696, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(316, Short.MAX_VALUE))
						.addGroup(gl_accountPanel.createSequentialGroup().addGap(30).addGroup(gl_accountPanel
								.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_accountPanel.createSequentialGroup().addGroup(gl_accountPanel
										.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_accountPanel.createSequentialGroup().addComponent(balanceLabel)
												.addGap(67))
										.addGroup(gl_accountPanel.createSequentialGroup()
												.addGroup(gl_accountPanel.createParallelGroup(Alignment.TRAILING)
														.addComponent(creditLabel, GroupLayout.PREFERRED_SIZE, 115,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(gl_accountPanel.createParallelGroup(Alignment.LEADING)
																.addComponent(daysLeftLabel).addComponent(statusLabel)))
												.addGap(18)))
										.addGroup(gl_accountPanel.createParallelGroup(Alignment.LEADING, false)
												.addGroup(gl_accountPanel.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(creditText, 92, 92, Short.MAX_VALUE))
												.addComponent(daysLeftText, 92, 92, Short.MAX_VALUE)
												.addComponent(balanceText, 0, 0, Short.MAX_VALUE)
												.addComponent(statusText, GroupLayout.PREFERRED_SIZE, 92,
														GroupLayout.PREFERRED_SIZE)))
								.addGroup(
										gl_accountPanel.createSequentialGroup()
												.addComponent(accounIdLabel, GroupLayout.PREFERRED_SIZE, 44,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_accountPanel.createParallelGroup(Alignment.LEADING)
														.addComponent(vipRadioButton, GroupLayout.PREFERRED_SIZE, 54,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(accountIdText, GroupLayout.PREFERRED_SIZE, 112,
																GroupLayout.PREFERRED_SIZE))))
								.addGap(16)
								.addComponent(accountNameLabel, GroupLayout.PREFERRED_SIZE, 97,
										GroupLayout.PREFERRED_SIZE)
								.addGap(92).addComponent(accountPasswordLabel).addGap(18)
								.addComponent(accountPasswordField, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
								.addGap(357)));
		gl_accountPanel.setVerticalGroup(gl_accountPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_accountPanel
				.createSequentialGroup().addGap(21)
				.addGroup(gl_accountPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(accountPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(accountPasswordLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(accounIdLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(accountIdText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(accountNameLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_accountPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_accountPanel.createSequentialGroup().addGap(18).addComponent(checkStatusButton))
						.addGroup(gl_accountPanel.createSequentialGroup().addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(vipRadioButton)))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(separator_3, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE).addGap(44)
				.addGroup(gl_accountPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(balanceLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(balanceText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(51)
				.addGroup(gl_accountPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(creditLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(creditText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(44)
				.addGroup(gl_accountPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(statusText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(statusLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
				.addGap(49)
				.addGroup(gl_accountPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(daysLeftLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(daysLeftText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(554)));
		accountPanel.setLayout(gl_accountPanel);
		accountPanel.setBackground(new Color(0, 206, 209));

		JPanel withdrawPanel = new JPanel();
		withdrawPanel.setBackground(new Color(0, 206, 209));
		tabbedPane.addTab("Withdraw", null, withdrawPanel, null);

		JLabel amountWithdrawLabel = new JLabel("Enter the amount of withdrawl:");
		amountWithdrawLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

		withdrawlText = new JTextField();
		withdrawlText.setColumns(10);

		JButton balanceWithdrawButton = new JButton("Balance withdraw");
		balanceWithdrawButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String withdrawText = withdrawlText.getText();
				try {
					float decrement = Float.parseFloat(withdrawText);
					if (decrement <= 0) {
						JOptionPane.showMessageDialog(null, "Please enter a valid number\n");
					} else if (decrement <= user.getBalance()) {
						user.balanceWithdraw(decrement);
						JOptionPane.showMessageDialog(null, "Withdraw done successfully");
					} else
						JOptionPane.showMessageDialog(null, "You can't withdraw more than the maximum limit");
				} catch (Exception E) {
					JOptionPane.showMessageDialog(null, "Please enter a valid number\n");
				}
				balanceRemainingText.setText(String.valueOf(user.getBalance()));
			}
		});
		balanceWithdrawButton.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel balanceRemainingLabel = new JLabel("Balance remaining:");
		balanceRemainingLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

		balanceRemainingText = new JTextField();
		balanceRemainingText.setEditable(false);
		balanceRemainingText.setColumns(10);
		String[] yearsString = { "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011",
				"2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002" };

//                creditWithdrawButton.addActionListener(new ActionListener() {
//                	public void actionPerformed(ActionEvent e) {
//                		int credit = Integer.parseInt(creditWithdrawButton.getText());
//                		if (credit == 10000) {
//                			yearBox.setVisible(true);
////                			Application.this.revalidate();
////                			Application.this.repaint();
//                		}
//
//                	}
//                });
		JLabel noWithdrawError = new JLabel(" ");
		noWithdrawError.setForeground(Color.RED);
		noWithdrawError.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel dateWithdrawnLabel = new JLabel("Date withdrawn(yyyy-mm-dd):");
		dateWithdrawnLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

		dateWithdrawnText = new JTextField();
		dateWithdrawnText.setColumns(10);

		JLabel wrongDateError = new JLabel();
		wrongDateError.setForeground(Color.BLACK);
		wrongDateError.setFont(new Font("Tahoma", Font.PLAIN, 16));

		dateWithdrawnLabel.setEnabled(false);
		dateWithdrawnText.setEnabled(false);

		JButton dateButton = new JButton("Enter date");
		dateButton.setEnabled(false);
		dateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// date validation
				boolean flag = DateHandling.isValid(dateWithdrawnText.getText());
				if (flag == false) {
					wrongDateError.setVisible(true);
					wrongDateError.setText("Please Enter a valid date");
					wrongDateError.setForeground(Color.RED);

					// output window that tells the user to input a valid date
				} else {
					// show the withdrawn text and decrement the balance
					wrongDateError.setForeground(Color.BLACK);
					wrongDateError.setVisible(false);

					user.setWithdrawalDate(dateWithdrawnText.getText());
					boolean vip = false;
					if (Log.vipMap.get(user.getId()) != null)
						vip = true;

					long days = ((vip) ? 120 : 60) - DateHandling.getDifference(user.getWithdrawalDate());
					user.setDaysLeft((int) days);

					user.creditWithdraw(Float.parseFloat(withdrawlText.getText()));
					JOptionPane.showMessageDialog(null, "Withdraw done successfully");

					// make a method set date
					creditRemainingText.setText(String.valueOf(user.getCreditCard()));
					dateWithdrawnLabel.setEnabled(false);
					dateWithdrawnText.setEnabled(false);
					dateButton.setEnabled(false);
					dateWithdrawnText.setText("");
				}
			}
		});
		dateButton.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel creditRemainingLabel = new JLabel("Credit remaining:");
		creditRemainingLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

		creditRemainingText = new JTextField();
		creditRemainingText.setEditable(false);
		creditRemainingText.setColumns(10);

		JButton creditWithdrawButton = new JButton("Credit withdraw");
		creditWithdrawButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					float decrement = Float.parseFloat(withdrawlText.getText());
					if (decrement <= 0) {
						JOptionPane.showMessageDialog(null, "Please enter a valid number");
					} else if (decrement <= user.getCreditCard() && user.getCreditCard() == user.getCreditCardLimit()) {
						wrongDateError.setVisible(true);
						wrongDateError.setText("Enter date of credit withdrawal");
						dateWithdrawnLabel.setEnabled(true);
						dateWithdrawnText.setEnabled(true);
						dateButton.setEnabled(true);
					} else if (decrement <= user.getCreditCard()) {
						user.creditWithdraw(decrement);
						
						creditRemainingText.setText(String.valueOf(user.getCreditCard()));
						JOptionPane.showMessageDialog(null, "Withdraw done successfully");
					} else
						JOptionPane.showMessageDialog(null, "You can't withdraw more than the maximum limit");
				} catch (Exception E) {
					JOptionPane.showMessageDialog(null, "Please enter a valid number");
				}

			}
		});
		creditWithdrawButton.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(Color.BLACK);

		GroupLayout gl_withdrawPanel = new GroupLayout(withdrawPanel);
		gl_withdrawPanel
				.setHorizontalGroup(gl_withdrawPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_withdrawPanel
						.createSequentialGroup().addGroup(gl_withdrawPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_withdrawPanel.createSequentialGroup().addGap(10)
										.addComponent(noWithdrawError, GroupLayout.PREFERRED_SIZE, 541,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_withdrawPanel.createSequentialGroup().addGap(162).addGroup(gl_withdrawPanel
										.createParallelGroup(Alignment.LEADING)
										.addComponent(wrongDateError, GroupLayout.PREFERRED_SIZE, 447,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_withdrawPanel.createParallelGroup(Alignment.LEADING, false)
												.addGroup(gl_withdrawPanel.createSequentialGroup()
														.addComponent(balanceWithdrawButton, GroupLayout.PREFERRED_SIZE,
																148, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(creditWithdrawButton, GroupLayout.PREFERRED_SIZE,
																135, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_withdrawPanel.createSequentialGroup()
														.addComponent(amountWithdrawLabel, GroupLayout.PREFERRED_SIZE,
																237, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED).addComponent(
																withdrawlText, GroupLayout.PREFERRED_SIZE, 111,
																GroupLayout.PREFERRED_SIZE)))
										.addGroup(gl_withdrawPanel.createSequentialGroup().addGroup(gl_withdrawPanel
												.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_withdrawPanel.createSequentialGroup()
														.addComponent(dateWithdrawnLabel).addGap(22)
														.addComponent(
																dateWithdrawnText, GroupLayout.PREFERRED_SIZE, 113,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_withdrawPanel.createSequentialGroup()
														.addGroup(
																gl_withdrawPanel.createParallelGroup(Alignment.LEADING)
																		.addComponent(balanceRemainingLabel,
																				GroupLayout.PREFERRED_SIZE, 150,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(creditRemainingLabel,
																				GroupLayout.PREFERRED_SIZE, 136,
																				GroupLayout.PREFERRED_SIZE))
														.addGap(92)
														.addGroup(gl_withdrawPanel
																.createParallelGroup(Alignment.TRAILING, false)
																.addComponent(creditRemainingText).addComponent(
																		balanceRemainingText, Alignment.LEADING))))
												.addGap(10).addComponent(dateButton, GroupLayout.PREFERRED_SIZE, 132,
														GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_withdrawPanel.createSequentialGroup().addContainerGap().addComponent(
										separator_2, GroupLayout.PREFERRED_SIZE, 697, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(319, Short.MAX_VALUE)));
		gl_withdrawPanel.setVerticalGroup(gl_withdrawPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_withdrawPanel.createSequentialGroup().addContainerGap()
						.addComponent(noWithdrawError, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addGap(5)
						.addGroup(gl_withdrawPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(amountWithdrawLabel, GroupLayout.PREFERRED_SIZE, 20,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(withdrawlText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_withdrawPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(balanceWithdrawButton).addComponent(creditWithdrawButton))
						.addGap(27)
						.addComponent(wrongDateError, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_withdrawPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(dateButton, 0, 0, Short.MAX_VALUE)
								.addGroup(gl_withdrawPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(dateWithdrawnLabel, GroupLayout.PREFERRED_SIZE, 20,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(dateWithdrawnText, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGap(34)
						.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(44)
						.addGroup(gl_withdrawPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(balanceRemainingLabel, GroupLayout.PREFERRED_SIZE, 20,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(balanceRemainingText, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(33)
						.addGroup(gl_withdrawPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(creditRemainingLabel, GroupLayout.PREFERRED_SIZE, 20,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(creditRemainingText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(83, Short.MAX_VALUE)));
		withdrawPanel.setLayout(gl_withdrawPanel);

		JPanel depositPanel = new JPanel();
		depositPanel.setBackground(new Color(0, 206, 209));
		tabbedPane.addTab("Deposit", null, depositPanel, null);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setToolTipText("");

		JLabel depositAmountLabel = new JLabel("Enter the deposit amount:\r\n");
		depositAmountLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

		depositAmountText = new JTextField();
		depositAmountText.setColumns(10);

		JButton balanceDepositButton = new JButton("Balance deposit");
		balanceDepositButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float num1 = 0;
				try {
					num1 = Float.parseFloat(depositAmountText.getText());
					user.depositBalance(num1);
//					Log.map.put(user.getId(), user);
					newBalanceText.setText(Float.toString(user.getBalance()));
					creditBalanceText.setText(Float.toString(user.getCreditCard()));
				} catch (Exception E) {
					JOptionPane.showMessageDialog(null, "Please enter a valid number");
				}

			}
		});
		balanceDepositButton.setFont(new Font("Tahoma", Font.PLAIN, 14));

		newBalanceText = new JTextField();
		newBalanceText.setEditable(false);
		newBalanceText.setColumns(10);

		JLabel newBalanceLabel = new JLabel("New balance:");
		newBalanceLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JButton creditDepositButton = new JButton("Credit deposit");
		creditDepositButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float num1 = 0;
				try {
					num1 = Float.parseFloat(depositAmountText.getText());
					user.depositCredit(num1);
//					Log.map.put(user.getId(), user);
					newBalanceText.setText(Float.toString(user.getBalance()));
					creditBalanceText.setText(Float.toString(user.getCreditCard()));
				} catch (Exception E) {
					JOptionPane.showMessageDialog(null, "Please enter a valid number");
				}

			}
		});
		creditDepositButton.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel creditBalanceLabel = new JLabel("Credit balance:");
		creditBalanceLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

		creditBalanceText = new JTextField();
		creditBalanceText.setEditable(false);
		creditBalanceText.setColumns(10);

		JLabel depositErrorLabel = new JLabel(" ");
		depositErrorLabel.setForeground(Color.RED);
		depositErrorLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		GroupLayout gl_depositPanel = new GroupLayout(depositPanel);
		gl_depositPanel.setHorizontalGroup(gl_depositPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_depositPanel.createSequentialGroup().addContainerGap().addGroup(gl_depositPanel
						.createParallelGroup(Alignment.LEADING)
						.addComponent(separator_1_1, GroupLayout.PREFERRED_SIZE, 1002, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_depositPanel.createSequentialGroup()
								.addGroup(gl_depositPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(depositAmountLabel, GroupLayout.PREFERRED_SIZE, 203,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(newBalanceLabel, GroupLayout.PREFERRED_SIZE, 150,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(creditBalanceLabel, GroupLayout.PREFERRED_SIZE, 150,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_depositPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_depositPanel.createSequentialGroup()
												.addComponent(depositAmountText, GroupLayout.PREFERRED_SIZE, 106,
														GroupLayout.PREFERRED_SIZE)
												.addGap(18)
												.addComponent(balanceDepositButton, GroupLayout.PREFERRED_SIZE, 143,
														GroupLayout.PREFERRED_SIZE)
												.addGap(35).addComponent(creditDepositButton))
										.addGroup(gl_depositPanel.createSequentialGroup()
												.addGroup(gl_depositPanel.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(creditBalanceText, Alignment.LEADING)
														.addComponent(newBalanceText, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(depositErrorLabel, GroupLayout.PREFERRED_SIZE, 541,
														GroupLayout.PREFERRED_SIZE))))
						.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 689, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(14, Short.MAX_VALUE)));
		gl_depositPanel.setVerticalGroup(gl_depositPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_depositPanel
				.createSequentialGroup().addGap(23)
				.addGroup(gl_depositPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(depositAmountLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_depositPanel.createSequentialGroup().addGap(3)
								.addGroup(gl_depositPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(balanceDepositButton).addComponent(creditDepositButton)
										.addComponent(depositAmountText, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
				.addGap(50).addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
				.addGap(37)
				.addGroup(gl_depositPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_depositPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(depositErrorLabel, GroupLayout.PREFERRED_SIZE, 20,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(newBalanceLabel, GroupLayout.PREFERRED_SIZE, 20,
										GroupLayout.PREFERRED_SIZE))
						.addComponent(newBalanceText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(54)
				.addGroup(gl_depositPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(creditBalanceLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(creditBalanceText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(672).addComponent(separator_1_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		depositPanel.setLayout(gl_depositPanel);

		JPanel transferPanel = new JPanel();
		transferPanel.setBackground(new Color(0, 206, 209));
		tabbedPane.addTab("Transfer", null, transferPanel, null);

		JLabel recpientIdLabel = new JLabel("Enter the ID of the recipient:\r\n");
		recpientIdLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

		recpientIdText = new JTextField();
		recpientIdText.setColumns(10);

		JLabel amountTransferedLabel = new JLabel("Amount transfered:");
		amountTransferedLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

		amountTransferedText = new JTextField();

		amountTransferedText.setEditable(false);
		amountTransferedText.setColumns(10);

		JLabel transferBalanceLabel = new JLabel("Your new balance:");

		transferBalanceLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

		transferBalanceText = new JTextField();

		transferBalanceText.setEditable(false);
		transferBalanceText.setColumns(10);

		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

		JLabel idErrorLabel = new JLabel(" ");
		idErrorLabel.setForeground(Color.RED);
		idErrorLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel transferAmountLabel = new JLabel("Transfer amount:");
		transferAmountLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

		transferAmountTextField = new JTextField();
		transferAmountTextField.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));

		JButton recpientTransferButton = new JButton("Transfer");
		recpientTransferButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		recpientTransferButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float num1;
				String id;
				try {
					id = recpientIdText.getText();
					num1 = Float.parseFloat(transferAmountTextField.getText());
					boolean exist = false;
					Account transferredTo = null;
					if (Log.map.get(id) != null) {
						transferredTo = Log.map.get(id);
						exist = true;
					} else if (Log.vipMap.get(id) != null) {
						transferredTo = Log.vipMap.get(id);
						exist = true;
					}

					if (exist) {

						float amount = user.transferAmount(num1, transferredTo);
//							Log.map.put(user.getId(), user);
//							Log.map.put(transferredTo.getId(), transferredTo);

						amountTransferedText.setText(Float.toString(amount));
						transferBalanceText.setText(Float.toString(user.getBalance()));

						amountTransferedLabel.setVisible(true);
						amountTransferedText.setVisible(true);
						transferBalanceLabel.setVisible(true);
						transferBalanceText.setVisible(true);

						if (amount != 0)
							JOptionPane.showInternalMessageDialog(null, "your transaction has been done successfully");
					} else
						JOptionPane.showMessageDialog(null, "This user does not exist");

				} catch (Exception E) {
					JOptionPane.showMessageDialog(null, "please enter valid inputs");
				}

			}
		});
		GroupLayout gl_transferPanel = new GroupLayout(transferPanel);
		gl_transferPanel.setHorizontalGroup(gl_transferPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_transferPanel.createSequentialGroup().addGroup(gl_transferPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_transferPanel.createSequentialGroup().addContainerGap().addGroup(gl_transferPanel
								.createParallelGroup(Alignment.LEADING)
								.addComponent(idErrorLabel, GroupLayout.PREFERRED_SIZE, 635, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_transferPanel.createSequentialGroup().addGroup(gl_transferPanel
										.createParallelGroup(Alignment.LEADING)
										.addComponent(recpientIdLabel, GroupLayout.PREFERRED_SIZE, 219,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(transferAmountLabel, GroupLayout.PREFERRED_SIZE, 161,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(amountTransferedLabel, GroupLayout.PREFERRED_SIZE, 164,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(transferBalanceLabel, GroupLayout.PREFERRED_SIZE, 150,
												GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_transferPanel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_transferPanel.createSequentialGroup().addGap(12)
														.addComponent(transferAmountTextField,
																GroupLayout.PREFERRED_SIZE, 112,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_transferPanel.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(recpientIdText, GroupLayout.PREFERRED_SIZE, 111,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_transferPanel.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_transferPanel
																.createParallelGroup(Alignment.TRAILING, false)
																.addComponent(transferBalanceText, Alignment.LEADING)
																.addComponent(amountTransferedText, Alignment.LEADING,
																		GroupLayout.DEFAULT_SIZE, 115,
																		Short.MAX_VALUE)))))))
						.addGroup(gl_transferPanel.createSequentialGroup().addGap(392).addComponent(
								recpientTransferButton, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_transferPanel.createSequentialGroup().addContainerGap().addComponent(separator,
								GroupLayout.PREFERRED_SIZE, 686, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(330, Short.MAX_VALUE)));
		gl_transferPanel.setVerticalGroup(gl_transferPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_transferPanel.createSequentialGroup().addContainerGap()
						.addComponent(idErrorLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_transferPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(recpientIdLabel, GroupLayout.PREFERRED_SIZE, 20,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(recpientIdText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(recpientTransferButton)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_transferPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(transferAmountLabel, GroupLayout.PREFERRED_SIZE, 20,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(transferAmountTextField, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(29).addComponent(separator, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addGap(28)
						.addGroup(gl_transferPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(amountTransferedLabel, GroupLayout.PREFERRED_SIZE, 20,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(amountTransferedText, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(38)
						.addGroup(gl_transferPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(transferBalanceLabel, GroupLayout.PREFERRED_SIZE, 20,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(transferBalanceText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(134, Short.MAX_VALUE)));
		transferPanel.setLayout(gl_transferPanel);
		contentPane.add(tabbedPane);
	}
}
