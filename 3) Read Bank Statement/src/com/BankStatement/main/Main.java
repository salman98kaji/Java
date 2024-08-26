package com.BankStatement.main;

import java.util.List;

import com.BankStatement.model.Transaction;
import com.BankStatement.service.BankStatementService;

public class Main {

	public static void main(String[] args) {
		String fileName = "E:\\Java\\Java programs\\3) Read Bank Statement\\src\\Jan2023.txt";
		BankStatementService service = new BankStatementService();
		
		List<Transaction> transactions = service.readTransactionsFromFile(fileName);
		
		double sumOfDeposits = service.getSumOfDeposits(transactions);
		//double t = service.getMaxDepositAmount(transactions);
		double maxDepositAmount=service.getMaxDepositAmount(transactions);
		double shoppingExpenses = service.getShoppingExpense(transactions);
		String dateOfMaxWithdrawal = service.getDateOfMaxWithdrawal(transactions);
		
		System.out.println("Sum of all deposits = " + sumOfDeposits);
        System.out.println("Max deposit amount = " + maxDepositAmount);
        System.out.println("Shopping expenses = " + shoppingExpenses);
        System.out.println("Date on which max amount withdrawn = " + dateOfMaxWithdrawal);
		//transactions.forEach(l->System.out.println(l));
    }
		
	

}
