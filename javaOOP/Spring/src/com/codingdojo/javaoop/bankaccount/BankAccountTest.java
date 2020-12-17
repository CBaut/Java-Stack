package com.codingdojo.javaoop.bankaccount;

public class BankAccountTest {

	public static void main(String[] args) {
		BankAccount account1 = new BankAccount();
//		System.out.println(account1.CountAccounts());
		account1.depositMoney(1, 500);
		account1.seeTotalMoney();
		account1.depositMoney(2, 400);
		account1.seeTotalMoney();
		account1.withdrawMoney(1, 200);
		account1.seeTotalMoney();
	}

}
