// Thomas Carney - CIS 406 - Power Tables
package powersTables;
import java.util.Scanner;

public class PowersTable {

	public static void main(String[] args) {
		// print welcome message
		System.out.println("Welcome to the Squares and Cubes table\n");
				
		// new scanner object
		Scanner input = new Scanner(System.in);
				
		// define variables
		char toContinue = 'Y';
		int num;
		// while loop to run at least once then continue based on sentinel value
		while (Character.toUpperCase(toContinue) != 'N') {
			System.out.print("Enter an integer:  ");
			num = input.nextInt();
			System.out.println();
			System.out.println("Number\tSquared\tCubed");
			System.out.println("======\t=======\t=====");
			for (int i = 1; i <= num; i++) {
				System.out.println(i + "\t" + i * i + "\t" + i * i * i);
			}
			
			System.out.print("Continue? (y/n):  ");
			toContinue = input.next().charAt(0);
		}
		System.out.println("\nBye!!");
		input.close();

	}

}
