package com.codingdojo.javaoop.bankaccount;

import java.util.Random;
import java.io.*;

public class BankAccount {
//	[x] class member (static) that has the number of accounts created thus far
	private static int countOfAccounts = 0;
//	[] class member (static) that tracks total amount of money stored in every account created
	private static Double totalAllAccounts = 0.0;
//	[x] Users cannot see any attributes from the class
	//	attributes:
//	[x] (string) account number
	private String accountNumber = "";
//	[x] (double checking balance
	private Double checkingBalance = 0.0;
//	[x] (double) savings balance
	private Double savingsBalance = 0.0;
	
	public BankAccount() {
//	[x] call the private method so that each user has a random ten digit account
		this.accountNumber = this.generateAcctNumber();
		
//	[x] increment the count
		countOfAccounts++;
	}
//	[x] private method that returns a random ten digit account number
	private String generateAcctNumber() {
		String acctNumber = "";
		Random rand = new Random();
		for(int i = 0; i < 10; i++) {
			acctNumber += String.valueOf(rand.nextInt(10));
		}
		return acctNumber;
	}
//	[x] getter method for the user's checking account balance
	public Double getCheckingBalance() {
		return this.checkingBalance;
	}
	
//	[x] getter method for the user's saving account balance
	public double getSavingsBalance() {
		return this.savingsBalance;
	}
	
//	[x] method that will allow user to deposit money into either  checking or saving.
	public void depositMoney(int account, int money) {
//		String account = "";
//		try {
//			InputStreamReader isr = new InputStreamReader(System.in);
//			BufferedReader br = new BufferedReader(isr);
//			System.out.print("Choose an account (1 - checking or 2 - savings): ");
//			account = br.readLine();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("IO Exception raised!");
//		}
		if(account == 1) {
			this.checkingBalance += money;
		}
		if(account == 2) {
			this.savingsBalance += money;
		}
//	[x] add to total amount stored
		totalAllAccounts += money;	
	}
	
//	[x] method to withdraw money from one balance. Do not allow if insufficient funds
	public void withdrawMoney(int account, int money) {
//		[x] nest if statement to see if enough funds
		if(account == 1) {
			if(this.checkingBalance - money < 0) {
				System.out.println("Insufficient funds. Withdraw did not go through... Try a smaller amount.");
				return;
			} else {
			this.checkingBalance -= money;
			totalAllAccounts -= money;
			}
		}
		else if(account == 2) {
			if(this.savingsBalance - money < 0) {
				System.out.println("Insufficient funds. Withdraw did not go through... Try a smaller amount.");
				return;
			} else {
			this.savingsBalance -= money;
			totalAllAccounts -= money;	
			}
		}
//	[x] subtract from total amount stored
	}
	
//	[x] method to see total money from the checking and saving
	public void seeTotalMoney() {
		System.out.println("The total from both checking and savings is: " + this.getCheckingBalance() + " + " + this.getSavingsBalance() + " = " + totalAllAccounts);
	}
	
	public static int CountAccounts() {
		return countOfAccounts;
	}
}
