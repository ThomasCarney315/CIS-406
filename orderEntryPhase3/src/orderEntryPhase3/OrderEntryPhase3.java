// Thomas Carney - CIS-406 - Course Project Phase 3
package orderEntryPhase3;
import java.util.Scanner;
import java.util.InputMismatchException;

public class OrderEntryPhase3 {
	
	//Declare instance variables
	final int MAX_ITEMS = 10;
	private String[] itemNumber = new String[MAX_ITEMS];
	private String[] itemDescription = new String[MAX_ITEMS];
	private double[] itemPrice = new double[MAX_ITEMS];
	private int[] quantity = new int[MAX_ITEMS];
	private double[] grossAmount = new double[MAX_ITEMS];
	private double[] discountedGross = new double[MAX_ITEMS];
	private double[] taxPercentage = new double[MAX_ITEMS];
	private double[] taxAmount = new double[MAX_ITEMS];
	private double[] discountPercentage = new double[MAX_ITEMS];
	private double[] discountAmount = new double[MAX_ITEMS];
	private double[] netAmount = new double[MAX_ITEMS];
	// declare totals
	private double totalGross = 0;
	private double totalTax = 0;
	private double totalDiscount = 0;
	private double totalNet = 0;
	// declare item count
	private int itemCount = 0;
	
	private void getData() {
		char moreInput = 'Y';
		var response = "catch the extra line";
		
		Scanner input = new Scanner(System.in);
		
		while(Character.toUpperCase(moreInput) != 'N')  {

			//Prompt user for input data
			System.out.print("Enter item number: ");
			itemNumber[itemCount] = input.nextLine();
			
			System.out.print("Enter item description: ");
			itemDescription[itemCount] = input.nextLine();
			
			System.out.print("Enter item price: $");
			itemPrice[itemCount] = input.nextDouble();
			
			System.out.print("Enter quantity ordered: ");
			quantity[itemCount] = input.nextInt();
			
			System.out.print("Enter tax percentage: ");
			taxPercentage[itemCount] = input.nextDouble();
			
			System.out.print("Enter discount percentage: ");
			discountPercentage[itemCount] = input.nextDouble();
			
			// Calculate gross amount
			grossAmount[itemCount] = itemPrice[itemCount] * quantity[itemCount];
			
			// Calculate discount amount and discounted gross
			discountAmount[itemCount] = grossAmount[itemCount] * (discountPercentage[itemCount] / 100);
			discountedGross[itemCount] = grossAmount[itemCount] - discountAmount[itemCount];
			
			// Calculate tax amount after discount
			taxAmount[itemCount] = discountedGross[itemCount] * (taxPercentage[itemCount] / 100);
			
			// Calculate net amount
			netAmount[itemCount] = discountedGross[itemCount] + taxAmount[itemCount];
			
			//update totals and item count
			totalGross += grossAmount[itemCount];
			totalTax += taxAmount[itemCount];
			totalDiscount += discountAmount[itemCount];
			totalNet += netAmount[itemCount];
			itemCount += 1;
			
			//prompt user for continuation
			System.out.print("More line items? (y/n):  ");
			moreInput = input.next().charAt(0);
			response = input.nextLine();
			
		}

		input.close();
		
	}

	public void printData() {
		
		//print header
		System.out.println(
				"\nOrder Details:\n"
						+ "\nItem Number \tItem Description \tItem Price \tQuantity \tTax % \tTax Amt \tDiscount % \tDiscount Amt \tNet Amt\n"
						+   "----------- \t---------------- \t---------- \t-------- \t----- \t------- \t---------- \t------------ \t-------\n");
		//print each line item
		for(int i = 0; i < itemCount; i++) {
			System.out.println(
					itemNumber[i] +
					"\t\t" + itemDescription[i] +
					"\t\t\t" + "$" + itemPrice[i] +
					"\t\t" + quantity[i] +
					"\t\t" + taxPercentage[i] +
					"\t" + "$" + taxAmount[i] +
					"\t\t" + discountPercentage[i] +
					"\t\t" + "$" + discountAmount[i] +
					"\t\t" + "$" + netAmount[i]);	
		}
		
		//print totals
		System.out.println();
		System.out.println(
				"Total # of items = " + itemCount + "\t" + "Total Gross = " + "$" + totalGross + "\t\t\t\t\t" + "$" + totalTax + "\t\t\t\t" + "$" + "$" + totalDiscount + "\t\t" + totalNet
				);
				  
	}

	public static void main(String[] args) {

		OrderEntryPhase3 myOrder = new OrderEntryPhase3();
				
		try {
			// Get data from user
			myOrder.getData();
					
			// Print details
			myOrder.printData();
		}
		catch(InputMismatchException e) {
			System.out.println("\nInput format error!");
		}
		catch(Exception e) {
			System.out.println("\nAn error has occurred!");
		}
	
	}

}