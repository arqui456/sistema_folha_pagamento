package utils;

public class Time {
	
	private Date date;
	private DateExtended dateExt;
	
	public Time(Date date, DateExtended dateExt){
		this.date = date;
		this.dateExt = dateExt;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public DateExtended getDateExt() {
		return dateExt;
	}

	public void setDateExt(DateExtended dateExt) {
		this.dateExt = dateExt;
	}
	
	public void printAM() {
		System.out.println("Time: " + date + " at " + dateExt.getHour() + ":" + dateExt.getMinute() + " " + dateExt.getPm_am());
	}
	
	//return hour + ":" + minute + " " + pm_am;

	@Override
	public String toString() {
		return "Time: " + date + " at " + dateExt;
	}
}
