package com.stockTrading.collectionUtils;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.stockTrading.stock.Stock;

public class CollectionUtils {
	private static Map<String, Stock> stockMap = new HashMap<String, Stock>();
	
	public static Map<String, Stock> getStockMap(){
		return stockMap;
	}
	
	public static void addSampleStocks() {
		try {
			stockMap.put("S1", new Stock("S1", "Apple", "Apple Inc", 150.00, LocalDate.now().plusDays(1), 100));
			stockMap.put("S2", new Stock("S2", "Google", "Alphabet Inc", 2800.00, LocalDate.now().plusDays(1), 50));
			stockMap.put("S3", new Stock("S3", "Amazon", "Amazon Inc", 3400.00, LocalDate.now().plusDays(1), 30));
			stockMap.put("S4", new Stock("S4", "Microsoft", "Microsoft Inc", 299.00, LocalDate.now().plusDays(1), 200));
			stockMap.put("S5", new Stock("S5", "Tesla", "Tesla Inc", 750.00, LocalDate.now().plusDays(1), 80));
		}catch (Exception e) {
			
		}
	}
}
