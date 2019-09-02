package a1;

import java.util.Arrays;
import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int items = scan.nextInt();
		double[] price = new double[items];
		String[] itemName = new String[items];
		for (int i=0; i<items; i++) {
			itemName[i] = scan.next();
			price[i] = scan.nextDouble();
		}
		
		
		
		int customers = scan.nextInt();
		
		String[] roster = new String[customers * 2];
		
		int[] numberOfCustomers = new int[itemName.length];
		int[] quantityOfItems = new int[itemName.length];
		
		for (int c=0; c<customers; c++) {
			
			roster[c * 2] = scan.next();
			roster[(c * 2) + 1] = scan.next();
			
			int boughtItems = scan.nextInt();
			String[] repeatFood = new String[boughtItems];
			
			for (int z=0; z<boughtItems; z++) {
				int quantity = scan.nextInt();
				String food = scan.next();
				repeatFood[z] = food;
				for (int r=0; r<itemName.length; r++) {
					if (food.equals(itemName[r])) {
						quantityOfItems[r] += quantity;
						numberOfCustomers[r] += 1;
					}
				}
			}
		}
		
		int[] numberOfCustom = {0, 2, 1, 1, 1, 1};
		
		// printed output in for loop
		
		for (int p=0; p<itemName.length; p++) {
			if (numberOfCustom[p] == 0) {
				System.out.println("No customers bought " + itemName[p]);
			} else {
				System.out.println(numberOfCustom[p] + " customers bought " + 
						quantityOfItems[p] + " " + itemName[p]);
			}
		}
	}
	
	public static boolean repeater(String[] a) {
		
		for (int i=0; i<a.length; i++) {
			for (int j=0; j<a.length; j++) {
				if (a[i].equals(a[j])) {
					return true;
				}
			}
		}
		return false;
	}
}
