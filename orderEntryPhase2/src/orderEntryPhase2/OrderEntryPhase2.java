// Thomas Carney - CIS-406 - Course Project Phase 2
package orderEntryPhase2;
import java.util.Scanner;
import java.util.InputMismatchException;

public class OrderEntryPhase2 {
	
	//Declare instance variables
	private String itemNumber;
	private String itemDescription;
	private double itemPrice;
	private int quantity;
	private double grossAmount;
	private double discountedGross;
	private double taxPercentage;
	private double taxAmount;
	private double discountPercentage;
	private double discountAmount;
	private double netAmount;
	
	private void getData() {

		Scanner input = new Scanner(System.in);
		
		//Prompt user for input data
		System.out.print("Enter item number: ");
		itemNumber = input.nextLine();
		
		System.out.print("Enter item description: ");
		itemDescription = input.nextLine();
		
		System.out.print("Enter item price: $");
		itemPrice = input.nextDouble();
		
		System.out.print("Enter quantity ordered: ");
		quantity = input.nextInt();
		
		System.out.print("Enter tax percentage: ");
		taxPercentage = input.nextDouble();
		
		System.out.print("Enter discount percentage: ");
		discountPercentage = input.nextDouble();
		
		// Calculate gross amount
		grossAmount = itemPrice * quantity;
		
		// Calculate discount amount and discounted gross
		discountAmount = grossAmount * (discountPercentage / 100);
		discountedGross = grossAmount - discountAmount;
		
		// Calculate tax amount after discount
		taxAmount = discountedGross * (taxPercentage / 100);
		
		// Calculate net amount
		netAmount = discountedGross + taxAmount;

		input.close();
		
	}

	public String toString() {
		return 
				("\nOrder Details:\n"
						+ "\nItem Number \tItem Description \tItem Price \tQuantity \tTax % \tTax Amt \tDiscount % \tDiscount Amt \tNet Amt\n"
						+   "----------- \t---------------- \t---------- \t-------- \t----- \t------- \t---------- \t------------ \t-------\n"
						+
					itemNumber +
					"\t\t" + itemDescription +
					"\t\t\t" + "$" + itemPrice +
					"\t\t" + quantity +
					"\t\t" + taxPercentage +
					"\t" + "$" + taxAmount +
					"\t\t" + discountPercentage +
					"\t\t" + "$" + discountAmount +
					"\t\t" + "$" + netAmount);
				  
	}

	public static void main(String[] args) {

		OrderEntryPhase2 myOrder = new OrderEntryPhase2();
				
		try {
			// Get data from user
			myOrder.getData();
					
			// Print details
			System.out.println(myOrder.toString());
		}
		catch(InputMismatchException e) {
			System.out.println("\nInput format error!");
		}
		catch(Exception e) {
			System.out.println("\nAn error has occurred!");
		}
	
	}

}
