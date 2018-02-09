package utils;

public class Date {
	
	// Date //////////
	private int day;
	private int month;
	private int year;
	private static final int[] daysPerMonth = {0 ,31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30,31};
	
	public Date(int day, int month, int year) {
		
		if(day < 1 || (day > daysPerMonth[month] && !(month == 2 && day == 29)))
			System.err.println(TimeExceptions.invalidDay());
		else if(month == 2 && day == 29 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))
			System.err.println(TimeExceptions.invalidDay());
		else
			this.day = day;
		
		if(month < 1 || month > 12)
			System.err.println(TimeExceptions.invalidMonth());
		else
			this.month = month;
		
		if(year < 0)
			System.err.println(TimeExceptions.invalidYear());
		else
			this.year = year;
	}

	@Override
	public String toString() {
		return day + "/" + month + "/" + year;
	}
	

}
