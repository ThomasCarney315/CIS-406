package orderEntryPhase1;
import java.util.Scanner;
import java.util.InputMismatchException;

public class OrderEntryPhase1 {
	
	// Instance variables
	private String itemNumber;
	private String itemDescription;
	private double itemPrice;
	private int quantity;
	private double totalTax;
	private double discount;
	private double calcNetAmount;
	private double netAmount;
	
	private void getData() {
		
		// Declare new scanner object to get data from console input
		Scanner input = new Scanner(System.in);
		
		//Prompt user and get data
		System.out.print("Enter item number: ");
		itemNumber = input.nextLine();
		System.out.print("Enter item description: ");
		itemDescription = input.nextLine();
		System.out.print("Enter item price: $");
		itemPrice = input.nextDouble();
		System.out.print("Enter quantity ordered: ");
		quantity = input.nextInt();
		System.out.print("Enter the total tax: $");
		totalTax = input.nextDouble();
		System.out.print("Enter the total discount: $");
		discount = input.nextDouble();
		// Calculate net amount
		calcNetAmount = itemPrice * quantity + totalTax - discount;
		// Continue prompting user for data
		System.out.print("Enter net amount (" + calcNetAmount + ") for item: $");
		netAmount = input.nextDouble();
				
		input.close();
		
	}
	// method for returning data formatted as a string table
	public String toString() {
		return 
				("\nOrder Details:\n"
						+ "\nItem Number \tItem Description \tItem Price "
						+ "\tQuantity \tTotal Tax \tDiscount \tNet Amount\n" +
					itemNumber +
					"\t\t" + itemDescription +
					"\t\t\t" + itemPrice +
					"\t\t" + quantity +
					"\t\t" + totalTax +
					"\t\t" + discount +
					"\t\t" + netAmount);
				  
	}
	public static void main(String[] args) {
		
		// Create new order instance
		OrderEntryPhase1 myOrder = new OrderEntryPhase1();
		
		try {
			// Call method to get data from user
			myOrder.getData();
			
			// Display details
			System.out.println(myOrder.toString());
		}
		catch(InputMismatchException e) {
			System.out.println("\nInput must be a number. Program ending.");
		}
		catch(Exception e) {
			System.out.println("\nAn error has occurred. Program ending.");
		}

	}

}
