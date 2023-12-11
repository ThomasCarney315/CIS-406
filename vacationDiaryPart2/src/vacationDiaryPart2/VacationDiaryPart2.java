// Thomas Carney - CIS406 - Vacation Diary Part 2
package vacationDiaryPart2;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;
public class VacationDiaryPart2 {

	public static String getDate(Scanner input, String prompt) {
		boolean valid = false;
		String dateString = "";
		
		while (!valid) {
			valid = true;
			try {
				System.out.print(prompt);
				dateString = input.nextLine();
				if (!dateString.equals("end")) {
					SimpleDateFormat sdfmt = new SimpleDateFormat("mmddyyyy");
					sdfmt.setLenient(true);
					Date date = sdfmt.parse(dateString);
					if (dateString.length() != 8) {
						throw new Exception();
					}
				}
				else {
					valid = false;
					return dateString;
				}
				
			}
			catch (Exception e) {
			System.out.println("Invalid date format. Please re-enter.");
			valid = false;
			}
		}
		
		return dateString;
	}
	
	public static String getCityOrCountry(Scanner input, String prompt) {
		String name;
		
		System.out.print(prompt);
		name = input.nextLine();
		int len = name.length();
		if (len < 15) {
			for (int i =len; i < 15; i++ ) {
				name += " ";
			}
		}
		if (len > 15) {
			name = name.substring(0, 15);
		}
		return name;
	}
	
	public static int getDays(Scanner input, String prompt) {
		boolean valid = false;
		int days = 0;
		
		while (!valid) {
			valid = true;
			try {
				System.out.print(prompt);
				days = input.nextInt();
				if (days < 1 || days > 30) {
					throw new Exception();
				}
				
			}
			catch (Exception e) {
			System.out.println("Days must be between 1 and 30.");
			valid = false;
			}
		}
		
		return days;
	}
	
	public static String getTravelMode(Scanner input, String prompt) {
		boolean valid = false;
		String travelMode = "";
		List<String> modes = Arrays.asList(new String[] {"car", "airplane", "ship", "train", "bus"});
		
		
		while (!valid) {
			valid = true;
			try {
				System.out.print(prompt);
				travelMode = input.nextLine();
				if (!modes.contains(travelMode)) {
					throw new Exception();
				}
			}
			catch (Exception e) {
			System.out.println("Please enter a valid travel mode.");
			valid = false;
			}
		}
		
		return travelMode;
	}
	
	public static void main(String[] args) {
		String moreInput ="";
		int stopCount = 0;
		final int MAX_STOPS = 10;
		String[] dateStarted = new String[MAX_STOPS];
		String[] city = new String[MAX_STOPS];
		String[] country = new String[MAX_STOPS];
		int[] days = new int[MAX_STOPS];
		String[] travelMode = new String[MAX_STOPS];
		
		Scanner input = new Scanner(System.in);
	
		while (moreInput != "end")  {

			//Prompt user for input data
			dateStarted[stopCount] = getDate(input, "Enter date vacation started (mmddyyyy) or end to quit: ");
			if (dateStarted[stopCount].equals("end")) {
				moreInput = "end";
				continue;
			}
			city[stopCount] = getCityOrCountry(input, "Enter City Visited: ");
			country[stopCount] = getCityOrCountry(input, "Enter Country Visited: ");
			days[stopCount] = getDays(input, "Enter number of days:  ");
			String catchExtraLine = input.nextLine();
			travelMode[stopCount] = getTravelMode(input, "Enter Mode of Travel (car, airplane, ship, train, bus): ");
			
			stopCount += 1;
		}	
		input.close();
		// Output trip details
		System.out.println("================================================================");
		System.out.println("========================= Vacation Diary =======================");
		System.out.println("Date\t\tCity\t\tCountry\t\tDays\tMode");
		System.out.println("==========\t===============\t===============\t====\t========");
		
		//print each line item
		for(int i = 0; i < stopCount; i++) {
			String date = dateStarted[i].substring(0, 2) + "/" + dateStarted[i].substring(2, 4) + "/" + dateStarted[i].substring(4) ;
			System.out.println(
							date +
							"\t" + city[i] +
							"\t" + country[i] +
							"\t" + days[i] +
							"\t" + travelMode[i]);
				}
	}

}
