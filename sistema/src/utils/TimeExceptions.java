package utils;

public class TimeExceptions {
	
	public static String invalidDay() {
		return "Invalid day!, the day either dont exist in this month or is smaller that 1";
	}
	
	public static String invalidMonth() {
		return "Invalid Month! must be between 1 - 12";
	}
	
	public static String invalidYear() {
		return "Invalid year! the year cannot be negative";
	}
	
	public static String invalidHour() {
		return "Invalid hour! must be between 0 - 23";
	}
	
	public static String invalidHourAM_PM() {
		return "Invalid hour! must be between 0 - 12";
	}
	
	public static String invalidMinute() {
		return "Invalid minute! must be between 0 - 59";
	}
}
