// Thomas Carney - CIS46 - Vacation Diary Part 1 
package studentRegistration; 

import java.util.Scanner; 

public class StudentRegistration { 
	
	public static void main(String[] args) { 
		// Show form title 
		System.out.println("Student Registration Form");
		System.out.println(); 
		
		// Prompt user for input 
		Scanner input = new Scanner(System.in); 
		System.out.print("Enter first name: "); 
		String firstName = input.next(); 
		System.out.print("Enter last name: ");
		String lastName = input.next(); 
		System.out.print("Enter year of birth: ");
		String birthYear = input.next(); 
		System.out.println(); 
		input.close(); 
		
		// Create password variable 
		String password = firstName + "*" + birthYear;
		
		// Output student registration info 
		System.out.println("Welcome " + firstName + " " + lastName + "!"); 
		System.out.println("Your registration is complete. ");
		System.out.println("Your temporary password is: " + password); 

		
	}
	
}