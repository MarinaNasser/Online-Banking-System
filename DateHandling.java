package loginDemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class DateHandling {

	public static String enteredDate = null;

	// method that checks if the inputed date is in the correct format
	public static boolean isValid(String date) {
		if (date.trim().equals("")) {// checks if the date is empty
			return false;
		}

		else {

			SimpleDateFormat theDateFormatWeUse = new SimpleDateFormat("yyyy-MM-dd");
			theDateFormatWeUse.setLenient(false);
			// setting the preferred date format to yyyy-MM-dd
			try {
				Date testDate = theDateFormatWeUse.parse(date);
				// Creates a Date object parse the string into date to see
				// if the date is inputed correctly
				if(getDifference(date)<0  || getDifference(date) > (40*365) ) {

					return false;
				}

			}

			catch (ParseException e) {
				return false;// if date format is invalid
			}
			
			return true;
			// if the date format is correct returns true
		}
	}

	// method that gets the difference between 2 dates in days
	public static long getDifference(String startDate) {
		// SimpleDateFormat converts the
		// string format to date object
		
		String pattern = "yyyy-MM-dd";

		String currentDate = new SimpleDateFormat(pattern).format(new Date());
		String endDate = currentDate;
		SimpleDateFormat ourDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		// Try the inputs
		try {

			// parsing string to date
			Date date1 = ourDateFormat.parse(startDate);
			Date date2 = ourDateFormat.parse(endDate);

			long differenceInTimes = date2.getTime() - date1.getTime(); // calculates the difference in time

			// calculates the difference between the start time and end time in days
			long differenceInDaysOg = TimeUnit.MILLISECONDS.toDays(differenceInTimes) % 365;
			long differenceInYears = TimeUnit.MILLISECONDS.toDays(differenceInTimes) / 365l;

			long differenceInDays = differenceInDaysOg + differenceInYears * 365;

			return differenceInDays;
			//

		} catch (ParseException e) {
			e.printStackTrace();
			return (Long) null;
		}
	}

	public static void inputDateOfTransaction(String input) {

		Scanner sc = new Scanner(System.in);
		boolean validityOfDate = true;


		do {
			enteredDate = input;

			if (DateHandling.isValid(enteredDate)) {

				validityOfDate = false;

				System.out.println("The date is valid.\n");
			} else {
				System.out.println("Please enter a valid date format 'yyyy-mm-dd' & check your input again.");
				continue;
			}

		} while (validityOfDate);
		// Checks whether the input is in the correct format or not

		System.out.println("The date of withdrawing from credit is: " + enteredDate);
		// takes the input of the date of the transaction from the user and stores it in
		// the variable "enteredDate"

	}

	public static void daysSinceIndebtion() {

		String pattern = "yyyy-MM-dd";
		String currentDate = new SimpleDateFormat(pattern).format(new Date());

		long daysWithdrawnFromCredit = DateHandling.getDifference(enteredDate);

//		boolean indebtionStatus = false;
//		float creditCard = 0f;
//		if (daysSinceCreditRanOut > 60 && creditCard == 0) {
//			indebtionStatus = true;
//			int daysSinceIndebtion = (int) (daysSinceCreditRanOut - 60);
//			System.out.println("You are in debt since " + daysSinceIndebtion + " days.");
//		} else {
//			int daysRemaining = (int) (60 - daysSinceCreditRanOut);
//			System.out.println("You are  " + daysRemaining + " days away from being indebted.");
//		}

	}
}
