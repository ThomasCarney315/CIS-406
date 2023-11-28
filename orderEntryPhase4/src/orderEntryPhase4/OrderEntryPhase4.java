// Thomas Carney - CIS-406 - Course Project Phase 4
package orderEntryPhase4;
import java.util.Scanner;
import java.util.InputMismatchException;

public class OrderEntryPhase4 {
	
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
	
	private String invoiceDate;
	private String customerName;
	private String streetAddress;
	private String customerCity;
	private String customerState;
	private String customerZip ;
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
		
		// Prompt user for customer data and declare/initialize each variable
		System.out.print("Enter invoice date (MM/DD/YYYY):  ");
		invoiceDate = input.nextLine();
		System.out.print("Enter customer name:  ");
		customerName = input.nextLine();
		System.out.print("Enter customer street address:  ");
		streetAddress = input.nextLine();
		System.out.print("Enter customer city:  ");
		customerCity = input.nextLine();
		System.out.print("Enter customer state (2 letters):  ");
		customerState = input.nextLine();
		System.out.print("Enter customer zip code (5 digits):  ");
		customerZip = input.nextLine();
		
		while(Character.toUpperCase(moreInput) != 'N')  {

			//Prompt user for input data
			System.out.print("\nEnter item number: ");
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
		// print invoice header with customer info and date
		System.out.println("\nInvioce Date: " + invoiceDate + "\n");
		System.out.println( "Customer Name \t\tCustomer Street \tCustomer City \t\tCustomer State \t\tCustomer Zip Code\n"
						+   "------------- \t\t--------------- \t------------- \t\t-------------- \t\t-----------------");
		System.out.println(customerName + "\t\t" + streetAddress + "\t\t" + customerCity + "\t\t" + customerState + "\t\t\t" + customerZip );		
		
		//print line items header
		System.out.println(
						"\nItem Number \tItem Description \tItem Price \tQuantity \tGross Amt \tTax % \tTax Amt \tDiscount % \tDiscount Amt \tNet Amt\n"
					+   "----------- \t---------------- \t---------- \t-------- \t--------- \t----- \t------- \t---------- \t------------ \t-------");
		//print each line item
		for(int i = 0; i < itemCount; i++) {
			System.out.println(
					itemNumber[i] +
					"\t\t" + itemDescription[i] +
					"\t\t\t" + "$" + itemPrice[i] +
					"\t\t" + quantity[i] +
					"\t\t" + "$" + grossAmount[i] +
					"\t\t" + taxPercentage[i] +
					"\t" + "$" + taxAmount[i] +
					"\t\t" + discountPercentage[i] +
					"\t\t" + "$" + discountAmount[i] +
					"\t\t" + "$" + netAmount[i]);	
		}
		
		//print totals
		System.out.println();
		System.out.println(
				"Totals: \t# of items = " + itemCount + "\t\t\t\t\t\t" + "$" + totalGross + "\t\t\t" + "$" + totalTax + "\t\t\t\t" + "$" + totalDiscount + "\t\t" + "$" +totalNet
				);
				  
	}

	public static void main(String[] args) {

		OrderEntryPhase4 myOrder = new OrderEntryPhase4();
				
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