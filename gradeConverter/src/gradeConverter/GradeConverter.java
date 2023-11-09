// Thomas Carney - CIS 406 - Grade Converter
package gradeConverter;
import java.util.Scanner;

public class GradeConverter {

	public char convertScore(int score) {
		if (score >= 90) {
			return 'A';
		}
		else if (score >= 80) {
			return 'B';
		}
		else if (score >= 70) {
			return 'C';
		}
		else if (score >= 60) {
			return 'D';
		}
		else {
			return 'F';
		}
	}
	
	public static void main(String[] args) {
		// print welcome message header
		System.out.println("Welcome to the Letter Grade Converter\n");
		
		//define new converter object instance
		GradeConverter myConverter = new GradeConverter();
		
		// new scanner object
		Scanner input = new Scanner(System.in);
		
		// define variables
		char toContinue = 'Y';
		int score;
		// while loop to run at least once then continue based on sentinel value
		while (Character.toUpperCase(toContinue) != 'N') {
			System.out.print("Enter numerical grade:  ");
			score = input.nextInt();
			
			// check for valid data
			while (score < 0 || score > 100) {
				System.out.println("Invalid score. Score must be between 0 and 100.");
				System.out.print("Enter numerical grade:  ");
				score = input.nextInt();
			}
			
			System.out.println("Letter Grade:  " + myConverter.convertScore(score));
			System.out.print("Continue? (y/n):  ");
			toContinue = input.next().charAt(0);
		}
		System.out.println("Bye!!");
		input.close();
	}

}
