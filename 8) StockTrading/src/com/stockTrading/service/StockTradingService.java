package com.stockTrading.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.stockTrading.collectionUtils.CollectionUtils;
import com.stockTrading.customExceptions.StockTradingException;
import com.stockTrading.ioUtils.IOUtils;
import com.stockTrading.stock.Stock;

public class StockTradingService {
	
	private Map<String, Stock> stockMap;
	
	public StockTradingService() {
		this.stockMap = CollectionUtils.getStockMap();
	}
	
	//Add New stock in the market
	public void addNewStock(String stockId, String stockName, String companyName, double price,LocalDate closingDate, int quantity) throws StockTradingException {
		if (stockMap.containsKey(stockId)) {
			throw new StockTradingException("Stock Id already exists");
		}
		if (closingDate.isBefore(LocalDate.now())) {
			throw new StockTradingException("Closing date must be future date");
		}
		Stock stock = new Stock(stockId, stockName, companyName, price, closingDate, quantity);
		stockMap.put(stockId, stock);
	}
	
	//View Available stocks by Company:
	public void viewStocksByCOmpany(String companyName) {
		String result = stockMap.values().stream()
				.filter(stock -> stock.getCompanyName().equalsIgnoreCase(companyName))
				.map(Stock :: toString)
				.collect(Collectors.joining("\n"));
		System.out.println(result.isEmpty() ? "NO stocks found in the company" : result);
	}
	
	// purchase stock
	public void purchaseStock(String stockId,int quantity) throws StockTradingException {
		Stock stock = Optional.ofNullable(stockMap.get(stockId)) 
				.orElseThrow(() -> new StockTradingException("Invalid stock ID."));
		
		if (stock.getQuantity() < quantity) {
			throw new StockTradingException("Insufficient quantity");
		}
		stock.setQuantity(stock.getQuantity() - quantity);
	}
	
	// sell stocks
	public void sellStock(String stockId, int quantity) throws StockTradingException {
		Stock stock = Optional.ofNullable(stockMap.get(stockId))
				.orElseThrow(()-> new StockTradingException("Invalid stock id"));
		stock.setQuantity(stock.getQuantity() + quantity);
	}
	
	//save and exit
	public void saveAndExit() {
		try {
			IOUtils.saveStocks(stockMap);
			System.out.println("stocks saved succesfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
