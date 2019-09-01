package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int customers = scan.nextInt();
	
		String[] namesArray = new String[customers * 2];
		
		for (int i=0; i<namesArray.length; i++) {
			namesArray[i] = scan.next();
		}
		
		// number of items bought by customer
		int uniqueItems = scan.nextInt();
		
		
		
		// Initialize
		
		double[] itemPrice = new double[uniqueItems];
		
		
		for (int i=0; i<itemPrice.length; i++) {
			int quantity = scan.nextInt();
			String useless = scan.next();
			double price = scan.nextDouble();
			itemPrice[i] = quantity * price;
		}
		
		
		// Find total price
		double totalSum = 0;
		for (int i=0; i<itemPrice.length; i++) {
			totalSum = totalSum + itemPrice[i];
		}
		
		
		
		System.out.println(namesArray[0].charAt(0) + ". " + namesArray[1] + ": " + totalSum);
		
		
		
	}
}
