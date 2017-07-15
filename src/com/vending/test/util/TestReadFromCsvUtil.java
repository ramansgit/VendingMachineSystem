package com.vending.test.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.vending.model.Cash;
import com.vending.model.Item;
import com.vending.utils.CashEnum;

public class TestReadFromCsvUtil {

	public static Set<Item> readProductFromCsv() {
		String csvFile = "/Users/ramans/Documents/workspace-vendingmachine/VendingMachineSystem/product.csv";
		Set<Item> productStore = new HashSet<Item>();
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] products = line.split(cvsSplitBy);
				Item it = new Item();
				it.setProductId(products[0]);
				it.setName(products[1]);
				it.setPrice(Integer.parseInt(products[2]));
				it.setQty(Integer.parseInt(products[3]));

				productStore.add(it);
				System.out.println(it);
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

	public static Set<Cash> readCashAndDenominationsFromCsv() {
		String csvFile = "/Users/ramans/Documents/workspace-vendingmachine/VendingMachineSystem/cash.csv";
		Set<Cash> cashStore = new HashSet<Cash>();
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] cash = line.split(cvsSplitBy);
				Cash it = new Cash();
				try {
					it.setDenominations(CashEnum.valueOf(cash[0]));
					it.setQty(Integer.parseInt(cash[1]));
					cashStore.add(it);
					System.out.println(it);
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
