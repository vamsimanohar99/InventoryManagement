package com.vamsi;

import java.io.IOException;
import java.util.Scanner;
public class CodeApp {
	public static void main(String[] args) throws IOException {
		System.out.print("Enter 'exit' to terminate application.\n");
		Inventory inventory = new Inventory();
		Scanner sc = new Scanner(System.in);
		String command;
		Boolean flag = true;
		while(flag) {
			System.out.print("Command :: ");
			command = sc.next();
			if(command.equalsIgnoreCase("create"))
				inventory.createItem(sc.next(), sc.next(), sc.next());
			else if(command.equalsIgnoreCase("delete"))
				inventory.deleteItem(sc.next());
			else if(command.equalsIgnoreCase("updateBuy"))
				inventory.updateQuantity(sc.next(), sc.next());
			else if(command.equalsIgnoreCase("updateSell"))
				inventory.sellItem(sc.next(), sc.next());
			else if(command.equalsIgnoreCase("updateSellPrice"))
				inventory.updateSellingPrice(sc.next(), sc.next());
			else if(command.equalsIgnoreCase("report"))
				inventory.displayReport();
			else if(command.equalsIgnoreCase("exit"))
				flag = false;
			else {
				System.out.print("Unrecognised command.\n");
				sc.nextLine();
			}
		} sc.close();
		System.out.print("Exiting application.");
	}
}