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
		
		String[] roster = new String[customers * 2];
		double[] masterPrice = new double[customers];
		
		
		for (int c=0; c<customers; c++) {
			
			roster[c * 2] = scan.next();
			roster[(c * 2) + 1] = scan.next();
			
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
		}
		
		// System.out.println(Arrays.toString(masterPrice));
		System.out.println(Arrays.deepToString(roster));
		// find biggest spender through roster
		double maxt = 0.0;
		int element = 0;
		for (int i=0; i<masterPrice.length; i++) {
			if (masterPrice[i] > maxt) {
				maxt = masterPrice[i];
				element = i;
			}
		}
		
		
		double mint = 100000.0;
		int element2 = 0;
		for (int i=0; i<masterPrice.length; i++) {
			if (masterPrice[i] < mint) {
				mint = masterPrice[i];
				element2 = i;
			}
		}
		
		
		
		scan.close();
		
		String biggestSpender = String.format("%.2f", maximum(masterPrice));
		String smallestSpender = String.format("%.2f", minimum(masterPrice));
		String totalAverage = String.format("%.2f", average(masterPrice));
		
		System.out.println("Biggest: " + roster[element * 2] + " " + roster[(element * 2) + 1] + " " + "(" + biggestSpender + ")" );
		System.out.println("Smallest: " + roster[element2 * 2] + " " + roster[(element2 * 2) + 1] + " " + "(" + smallestSpender + ")" );
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

