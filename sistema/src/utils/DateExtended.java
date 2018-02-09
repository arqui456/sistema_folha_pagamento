package utils;

public class DateExtended {

	// Time //////////
	private int hour;
	private int minute;
	private boolean am_pm;
	private String pm_am;
	
	public DateExtended(int hour, int minute, boolean am_pm) {
		if(am_pm == false) {
			if(hour < 0 || hour > 23)
				System.err.println(TimeExceptions.invalidHour());
			else
				this.hour = hour;
			
			if(minute < 0 || minute > 59)
				System.err.println(TimeExceptions.invalidMinute());
			else
				this.minute = minute;
		}
		else {
			if(hour < 0 || hour > 12)
				System.err.println(TimeExceptions.invalidHourAM_PM());
			else
				this.hour = hour;
			if(minute < 0 || minute > 59)
				System.err.println(TimeExceptions.invalidMinute());
			else
				this.minute = minute;
		}
	}
	
	public DateExtended(int hour, int minute, boolean am_pm, String pm_am) {
		this(hour,minute,am_pm);
		this.pm_am = pm_am;
	}
	
	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public boolean isAm_pm() {
		return am_pm;
	}

	public void setAm_pm(boolean am_pm) {
		this.am_pm = am_pm;
	}

	public String getPm_am() {
		return pm_am;
	}

	public void setPm_am(String pm_am) {
		this.pm_am = pm_am;
	}

	@Override
	public String toString() {
		return hour + ":" + minute;
	}
}
