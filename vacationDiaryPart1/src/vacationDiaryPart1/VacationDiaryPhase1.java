// Thomas Carney - CIS406 - Vacation Diary Part 1
package vacationDiaryPart1;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class VacationDiaryPhase1 {
//testing for commit settings
	public static void main(String[] args) {
		// Show title
		System.out.println("Vacation Diary");
		System.out.println();
		
		//Prompt user for input and create variables to store input data
		Scanner input = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy"); 
		System.out.print("Enter Date Vacation Started (mm/dd/yyyy): ");
		String date = input.next();
		LocalDate startDate = LocalDate.parse(date, formatter);
		System.out.print("Enter City Visited: ");
		String city = input.next();
		System.out.print("Enter Country Visited: ");
		String country = input.next();
		System.out.print("Enter number of days: ");
		String days = input.next();
		System.out.print("Enter Mode of Travel (car, airplane, ship, train, bus): ");
		String modeOfTravel = input.next();
		System.out.println();
		input.close();
		
		// Output trip details
		System.out.println("Details of your trip:");
		System.out.println("Date: " + startDate.format(formatter));
		System.out.println("City: " + city);
		System.out.println("Country: " + country);
		System.out.println("Number of Days: " + days);
		System.out.println("Traveled By: " + modeOfTravel);
		System.out.println("Bye!!!");	
	}

}
