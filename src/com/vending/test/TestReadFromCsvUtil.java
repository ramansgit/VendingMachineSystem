package com.vending.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.vending.model.CashEnum;
import com.vending.model.Item;

public class TestReadFromCsvUtil {

	public static Map<String,Item> readProductFromCsv() {
		String csvFile = "/Users/ramans/Documents/workspace-vendingmachine/VendingMachineSystem/product.csv";
		Map<String,Item> productStore = new HashMap<String,Item>();
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] products = line.split(cvsSplitBy);
				Item it = new Item();
				it.setProductId(products[0].toString());
				it.setName(products[1]);
				it.setPrice(Integer.parseInt(products[2]));
				it.setQty(Integer.parseInt(products[3]));

				productStore.put(it.getProductId(),it);
				//System.out.println(it);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return productStore;
	}

	public static Map<CashEnum, Integer> readCashAndDenominationsFromCsv() {
		String csvFile = "/Users/ramans/Documents/workspace-vendingmachine/VendingMachineSystem/cash.csv";
		Map<CashEnum, Integer> cashStore = new HashMap<CashEnum, Integer>();
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				// use comma as separator
				String[] cash = line.split(cvsSplitBy);
				try {
					cashStore.put(CashEnum.valueOf(cash[0]), Integer.parseInt(cash[1]));
				} catch (Exception e) {
					e.printStackTrace();

				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return cashStore;
	}

}
