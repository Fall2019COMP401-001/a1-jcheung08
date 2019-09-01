package a1;

import java.util.Scanner;
import java.util.Arrays;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int items = scan.nextInt();
		double[] price = new double[items];
		String[] itemName = new String[items];
		for (int i=0; i<items; i++) {
			itemName[i] = scan.next();
			price[i] = scan.nextDouble();
		}
		// customers
		int customers = scan.nextInt();
		
		double[] masterPrice = new double[customers];
		String[] winner = new String[2];
		String[] loser = new String[2];
		
		for (int c=0; c<customers; c++) {
			double findWinner = 0.0;
			double findLoser = 10000.0;
			String[] fullName = new String[2];
			for (int a=0; a<2; a++) {
				fullName[a] = scan.next();
			}
			
			int boughtItems = scan.nextInt();
			double[] cust = new double[boughtItems];
			for (int z=0; z<boughtItems; z++) {
				int quantity = scan.nextInt();
				String food = scan.next();
				double priceFinder = 0.0;
				for (int j=0; j<itemName.length; j++) {
					if (food.equals(itemName[j])) {
						priceFinder = price[j] * quantity;
						cust[z] = priceFinder;
					}
				}
			}
			masterPrice[c] = sum(cust);
			if (masterPrice[c] > findWinner) {
				winner = fullName;
			}
			if (masterPrice[c] < findLoser) {
				loser = fullName;
			}
			
		}
		
		
		scan.close();
		
		String biggestSpender = String.format("%.2f", maximum(masterPrice));
		String smallestSpender = String.format("%.2f", minimum(masterPrice));
		String totalAverage = String.format("%.2f", average(masterPrice));
		
		System.out.println("Biggest: " + winner + biggestSpender);
		System.out.println("Smallest: " + loser + smallestSpender);
		System.out.println("Average: " + totalAverage);
		
		
	}
	
	public static double sum(double[]a) {
		double sum = 0.0;
		for(int i=0; i<a.length; i++) {
			sum += a[i];
		}
		return sum;
	}
	
	public static double maximum(double[] a) {
		double constant = a[0];
		for (int i=1; i<a.length; i++) {
			if (a[i] > constant) {
				constant = a[i];
			} 
		}
		return constant;
	}
	
	public static double minimum(double[] a) {
		double constant = a[0];
		for (int i=1; i<a.length; i++) {
			if (a[i] < constant) {
				constant = a[i];
			}
		}
		return constant;
	}
	
	public static double average(double[] a) {
		double sum = 0;
		for (int i=0; i<a.length; i++) {
			sum += a[i];
		}
		return sum / a.length;
	}
}

