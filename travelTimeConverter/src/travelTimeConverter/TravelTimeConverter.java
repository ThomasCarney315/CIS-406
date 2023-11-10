//Thomas Carney - CIS 406 - Travel Time Converter
package travelTimeConverter;
import java.util.Scanner;
public class TravelTimeConverter {

	private static String calcTime(double miles, double mph) {
		// calculate hours and minutes by casting result in minutes to int type, then dividing for hours and modulus for minutes
		int time = (int)(miles / mph * 60);
		int hours = time / 60;
		int mins = time % 60;
		
		// format output string
		return "Hours:   " + hours +
			 "\nMinutes: " + mins;
		
	}
	
	public static void main(String[] args) {
		// Print welcome header
		System.out.println("Welcome to the Travel Time Calculator\n");
		
		// get date input from user 
		Scanner input = new Scanner(System.in);
		System.out.print("Enter miles:           ");
		double miles = input.nextInt();
		System.out.print("Enter miles per hour:  ");
		double mph = input.nextInt();
		
		// close scanner object
		input.close();
		
		// calculate estimated time, format output, and print output
		String time = calcTime(miles, mph);
		System.out.println("\nEstimated travel time"
						+  "\n---------------------");
		System.out.println(time);
		
		// print farewell
		System.out.println("\nBye!!");
	}

}
