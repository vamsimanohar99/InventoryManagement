package com.vamsi;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
public class Inventory {
	private ArrayList<Item> items, sales, discontinued;
	private Item temp;
	private Integer[] reportIndex;
	DecimalFormat df;
	public Inventory() {
		items = new ArrayList<>();
		sales = new ArrayList<>();
		discontinued = new ArrayList<>();
		temp = new Item();
		reportIndex = new Integer[] {-1, -1};
		df = new DecimalFormat("0.00");
	}
	public void createItem(String itemName, String costPrice, String sellingPrice) {
		temp.setItemName(itemName);
		if (items.contains(temp))
			System.out.print("Item already exists.\n");
		else
			try {items.add(new Item(itemName, Double.valueOf(costPrice), Double.valueOf(sellingPrice)));}
			catch(Exception ex) {System.out.print("Invalid parameters.\n");}
	}
	public void deleteItem(String itemName) {
		temp.setItemName(itemName);
		if(items.contains(temp)) {
			discontinued.add(items.get(items.indexOf(temp)));
			items.remove(temp);
		}
		else
			System.out.print("Could not find item in inventory.\n");
	}
	public void updateQuantity(String itemName, String count) {
		temp.setItemName(itemName);
		if(items.contains(temp))
			try {items.get(items.indexOf(temp)).addQuantity(Integer.valueOf(count));}
			catch(Exception ex) {System.out.print("Invalid parameters.\n");}
		else
			System.out.print("Could not find item in inventory.\n");
	}
	public void sellItem (String itemName, String count) {
		temp.setItemName(itemName);
		if(items.contains(temp)) {
			Item i = items.get(items.indexOf(temp));
			try {
				Integer sale = Integer.valueOf(count);
				if(sale <= i.getQuantity()) {
					sales.add(new Item(itemName, Integer.valueOf(count), i.getCostPrice(), i.getSellingPrice()));
					i.addQuantity(sale * -1);
				}
				else
					System.out.print("Item availability less than requested sale.\n");
			}
			catch(Exception ex) {System.out.print("Invalid parameters.\n");}
		}
		else
			System.out.print("Could not find item in inventory.\n");
	}
	public void updateSellingPrice(String itemName, String newSellingPrice) {
		temp.setItemName(itemName);
		if(items.contains(temp))
			try {items.get(items.indexOf(temp)).setSellingPrice(Double.valueOf(newSellingPrice));}
			catch(Exception ex) {System.out.print("Invalid parameters.\n");}
		else
			System.out.print("Could not find item in inventory.\n");
	}
	public void displayReport() {
		Collections.sort(items);
		System.out.print("###INVENTORY REPORT###\n");
		System.out.print("Item Name\t\tBought At\t\tSold At\t\tAvailable Qty\t\tValue\n");
		System.out.print("---------\t\t---------\t\t-------\t\t-------------\t\t-----\n");
		Double total = new Double(0);
		for(Item i: items) {
			System.out.print(i.getItemName() + "\t\t\t" + df.format(i.getCostPrice()) + "\t\t\t" + df.format(i.getSellingPrice()) + "\t\t\t" + i.getQuantity() + "\t\t\t\t" + df.format(i.getValue()) + "\n");
			total += i.getValue();
		}
		System.out.print("---------------------------------------------------------------------\n");
		System.out.print("Total value\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + df.format(total) + "\n");
		total = new Double(0);
		while(reportIndex[0] < sales.size() - 1) {
			total += sales.get(++reportIndex[0]).getProfit();
		}
		while(reportIndex[1] < discontinued.size() - 1) {
			total -= discontinued.get(++reportIndex[1]).getValue();
		}
		System.out.print("Profit since previous report\t\t\t\t\t\t\t\t\t" + df.format(total) + "\n");
	}
}