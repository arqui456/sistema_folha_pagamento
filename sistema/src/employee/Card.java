package employee;

import utils.Date;
import utils.DateExtended;

public class Card {
	
	private Date startDate;
	private DateExtended startHour;
	
	private Date endDate;
	private DateExtended endHour;
	
	public Card() {
		
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