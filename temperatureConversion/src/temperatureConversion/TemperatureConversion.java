//Thomas Carney - CIS 406 - Temperature Conversion
package temperatureConversion;
import java.util.Scanner;
public class TemperatureConversion {

	private static double fahToCel(double f) {
		return (f - 32) * (5/9);
	}
	
	private static double celToFah(double c) {
		return c * (9/5) + 32;
	}
	
	public static void main(String[] args) {
		// output welcome message
		System.out.println("Welcome to the Temperature Converter");
		
		// create new scanner object
		Scanner input = new Scanner(System.in);
		
		// get fahrenheit and convert to celsius then output result
		System.out.print("\nEnter degrees in Fahrenheit: ");
		double degreesF = input.nextDouble();
		System.out.println("Degrees in Celsius: " + (int)fahToCel(degreesF));
		
		//get celsius and convert to fahrenheit then output result
		System.out.print("\nEnter degrees in Celsius: ");
		double degreesC = input.nextDouble();
		System.out.println("Degrees in Fahrenheit: " + (int)celToFah(degreesC));
		
		// close scanner object
		input.close();
		
		// print bye
		System.out.println("\nBye!!");
		
	}

}
