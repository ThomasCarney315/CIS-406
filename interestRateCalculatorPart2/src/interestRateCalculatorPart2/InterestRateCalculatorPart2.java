// Thomas Carney - CIS 406 - Interest Rate Calculator Part 2
package interestRateCalculatorPart2;
import java.util.Scanner;
import java.util.Locale;
import java.text.NumberFormat;

public class InterestRateCalculatorPart2 {
	
	public static double getNumericData(Scanner input, String prompt) {
		
		double number = 0;
		boolean valid = false;
		String inputString;
		
		while (!valid) {
			valid = true;
			try {
				System.out.print(prompt);
				inputString = input.nextLine();
				if (inputString.contains(",")) {
					throw new Exception();
				}
				number = Double.parseDouble(inputString);
			}
			catch (Exception e) {
			System.out.println("Error: input must only contain numbers");
			valid = false;
			}
		}
		
		return number;
	}
	
	public static double calcInterest(double loan, double rate) {
		return loan * (rate / 100);
	}

	public static void main(String[] args) {
		// print welcome message
		System.out.println("Welcome to the Interest Calculator");
				
		// new scanner object
		Scanner input = new Scanner(System.in);
				
		// define variables
		Locale usa = new Locale("en", "US");
		NumberFormat dollarFormat = NumberFormat.getCurrencyInstance(usa);
		var response = "catch the extra line";
		char toContinue = 'Y';
		double loanAmount;
		double interestRate;
		double interest;
		
		// while loop to run at least once then continue based on sentinel value
		while (Character.toUpperCase(toContinue) != 'N') {
			
			// get inputs
			loanAmount = getNumericData(input, "\nEnter loan amount:\t");
			interestRate = getNumericData(input, "Enter interest rate:\t");
			
			// calculate interest
			interest = calcInterest(loanAmount, interestRate);
			
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
			response = input.nextLine();
		}
		System.out.println("\nBye!!!");
		input.close();

	}

}