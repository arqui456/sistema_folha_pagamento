package employee;

import java.util.Scanner;

import utils.Date;
import utils.DateExtended;

public class Card {
	
	private Date startDate;
	private DateExtended startHour;
	
	private Date endDate;
	private DateExtended endHour;
	
	private static Scanner inputator = new Scanner(System.in);
	
	public Card() {
		
		int day = 0;
		int month = 0;
		int year = 0;
		int minutes = 0;
		int hours = 0;
		
		System.out.println("Type in the check-in date (d/m/y): ");
		String input = inputator.nextLine();
		String inputAux[] = input.split("/");
		day = Integer.parseInt(inputAux[0]);
		month = Integer.parseInt(inputAux[1]);
		year = Integer.parseInt(inputAux[2]);
		
		System.out.println("Type in the check-in hour (hour:minute)");
		String hourr = inputator.nextLine();
        String[] hourAux = hourr.split(":");
        hours = Integer.parseInt(hourAux[0]);
        minutes = Integer.parseInt(hourAux[1]);
        
        Date date = new Date(day, month,year);
        DateExtended ddate = new DateExtended(hours, minutes);
        this.startDate = date;
        this.startHour = ddate;
        
		System.out.println("Type in the check-out date (d/m/y)");
		input = inputator.nextLine();
		inputAux = input.split("/");
		day = Integer.parseInt(inputAux[0]);
		month = Integer.parseInt(inputAux[1]);
		year = Integer.parseInt(inputAux[2]);
		
		System.out.println("Type in the check-out hour (hour:minute)");
		hourr = inputator.nextLine();
        hourAux = hourr.split(":");
        hours = Integer.parseInt(hourAux[0]);
        minutes = Integer.parseInt(hourAux[1]);

        date = new Date(day, month,year);
        ddate = new DateExtended(hours, minutes);
        this.endDate = date;
        this.endHour = ddate;
        
        this.toString();
	}
	
	public Card(boolean isStartDate, int day, int month, int year, int hour, int minutes) {
		if(isStartDate == true) {
			this.startDate = new Date(day,month,year);
			this.startHour = new DateExtended(hour,minutes);
		}
		else {
			this.endDate = new Date(day,month,year);
			this.endHour = new DateExtended(hour,minutes);
		}
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public DateExtended getStartHour() {
		return startHour;
	}

	public void setStartHour(DateExtended startHour) {
		this.startHour = startHour;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public DateExtended getEndHour() {
		return endHour;
	}

	public void setEndHour(DateExtended endHour) {
		this.endHour = endHour;
	}
	
	@Override
	public String toString() {
		return "Card - \n"
				+ "startTime = " + startDate + " " + startHour + "\nendTime = " + endDate + " " + endHour;
	}
}