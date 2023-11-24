//Thomas Carney - CIS 406 - Tip Calculator
package tipCalculator;
import java.util.Scanner;
import java.util.Locale;
import java.text.NumberFormat;

public class TipCalculator {

	public static void main(String[] args) {
		// print title
		System.out.println("Tip Calculator\n");
				
		// new scanner object
		Scanner input = new Scanner(System.in);
				
		// define variables
		Locale usa = new Locale("en", "US");
		NumberFormat dollarFormat = NumberFormat.getCurrencyInstance(usa);
		
		char toContinue = 'Y';
		double mealCost;
		double tip15;
		double tip20;
		double tip25;

		// while loop to run at least once then continue based on sentinel value
		while (Character.toUpperCase(toContinue) != 'N') {
			
			// get inputs
			System.out.print("Cost of meal:\t");
			mealCost = input.nextDouble();
			
			// calculate tip amounts by percentage
			tip15 = mealCost * 0.15;
			tip20 = mealCost * 0.2;
			tip25 = mealCost * 0.20;
			
			// output tip and totals
			System.out.println("\n15%");
			System.out.println("Tip amount:\t" +  dollarFormat.format(tip15));
			System.out.println("Total amount:\t" + dollarFormat.format(mealCost + tip15));
			System.out.println("20%");
			System.out.println("Tip amount:\t" +  dollarFormat.format(tip20));
			System.out.println("Total amount:\t" + dollarFormat.format(mealCost + tip20));
			System.out.println("25%");
			System.out.println("Tip amount:\t" +  dollarFormat.format(tip25));
			System.out.println("Total amount:\t" + dollarFormat.format(mealCost + tip25));
			
			System.out.print("Continue? (y/n):  ");
			toContinue = input.next().charAt(0);
		}
		System.out.println("Bye!!!");
		input.close();

	}

}