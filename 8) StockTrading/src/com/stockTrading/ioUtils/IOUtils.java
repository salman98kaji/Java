package com.stockTrading.ioUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import com.stockTrading.stock.Stock;

public class IOUtils {
	
	//This method serializes the stock map and writes it to a file named stocks.ser
	public static void saveStocks(Map<String, Stock> stockMap) throws IOException{
		try(ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream("stocks.ser"))){
			oss.writeObject(stockMap);
		}
	}
	
	//This method deserializes the stock map from the stocks.ser file.
	@SuppressWarnings("unchecked")
	public static Map<String, Stock> loadStocks() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("stocks.ser"))) {
            return (Map<String, Stock>) ois.readObject();
        }
    }
}
