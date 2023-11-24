// Thomas Carney - CIS 406 - Interest Rate Calculator Part 1
package interestRateCalculatorPart1;
import java.util.Scanner;
import java.util.Locale;
import java.text.NumberFormat;

public class InterestRateCalculatorPart1 {

	public static void main(String[] args) {
		// print welcome message
		System.out.println("Welcome to the Interest Calculator");
				
		// new scanner object
		Scanner input = new Scanner(System.in);
				
		// define variables
		Locale usa = new Locale("en", "US");
		NumberFormat dollarFormat = NumberFormat.getCurrencyInstance(usa);
		
		char toContinue = 'Y';
		int loanAmount;
		double interestRate;
		double interest;
		
		// while loop to run at least once then continue based on sentinel value
		while (Character.toUpperCase(toContinue) != 'N') {
			
			// get inputs
			System.out.print("\nEnter loan amount:\t");
			loanAmount = input.nextInt();
			System.out.print("Enter interest rate:\t");
			interestRate = input.nextDouble();
			
			// calculate interest
			interest = loanAmount * (interestRate / 100);
			
			// output results
			System.out.println();
			System.out.println("Loan amount:\t\t" +  dollarFormat.format(loanAmount));
			//if interest rate has any decimal point cast to integer else print as decimal
			if ((double)((int)interestRate) == interestRate) {
				System.out.println("Interest rate:\t\t" + (int)interestRate + "%");
			}
			else {
				System.out.println("Interest rate:\t\t" + interestRate + "%");
			}
			System.out.println("Interest:\t\t" + dollarFormat.format(interest));
			
			System.out.print("\nContinue? (y/n):  ");
			toContinue = input.next().charAt(0);
		}
		System.out.println("\nBye!!");
		input.close();

	}

}