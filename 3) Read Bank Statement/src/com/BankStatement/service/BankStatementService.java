package com.BankStatement.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import com.BankStatement.model.Transaction;

public class BankStatementService {
	
	public List<Transaction> readTransactionsFromFile (String fileName) {
		List<Transaction> transactions = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
			String line = br.readLine();//read the header line
			//if (line != null && line.trim().equals("TransactionDate,Narration,WithdrawalAmount,DepositAmount")) {
			while ((line = br.readLine())!=null) {
				String[] fields = line.split(",");
				String transactionDate = fields[0].trim();
				String narration = fields[1].trim();
				Double withdrawalAmount = fields[2].isEmpty() ? 0.0 : Double.parseDouble(fields[2].trim());
				Double depositAmount = fields[3].isEmpty() ? 0.0 : Double.parseDouble(fields[3].trim());
				
				Transaction transaction = new Transaction(transactionDate, narration, withdrawalAmount, depositAmount);
				transactions.add(transaction);
			
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
            System.err.println("Error parsing number from the file. Please check the file for invalid data.");
            e.printStackTrace();
        }
		return transactions;
	}
	
	public double getSumOfDeposits(List<Transaction> transactions) {
		return transactions.stream()
				.mapToDouble(Transaction::getDepositAmount)
				.sum();		
	}
	
	public double getMaxDepositAmount(List<Transaction> transactions) {
		return transactions.stream()
//				.max(Comparator.comparing(Transaction::getDepositAmount))
//				.orElseThrow(NoSuchElementException::new);
				.mapToDouble(Transaction::getDepositAmount)
				.max()
				.orElse(0.0);				
	}
	
	public double getShoppingExpense(List<Transaction> transactions) {
		return transactions.stream()
				.filter(t -> t.getNarration().toLowerCase().equals("shopping"))
				.mapToDouble(Transaction::getWithdrawalAmount)
				.sum();	
	}
	
	public String getDateOfMaxWithdrawal(List<Transaction> transactions) {
		return transactions.stream()
				.max((t1,t2)-> Double.compare(t1.getWithdrawalAmount(), t2.getWithdrawalAmount()))
				.map(Transaction :: getTransactionDate)
				.orElse("");		
	}
	
}
