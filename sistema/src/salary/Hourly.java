package salary;

public class Hourly {

	private static String payDay = "every week friday";
	private int workHours;
	private int extraHours;
	
	public Hourly() {
		this.workHours = 0;
		this.extraHours  = 0;
	}
	
	public void setWorkHours(int workHours) {
		this.workHours += workHours;
	}
	
	public int getWorkHours(){
		return workHours;
	}

	public static String getPayDay() {
		return payDay;
	}

	public int getExtraHours() {
		return extraHours;
	}

	public void setExtraHours(int extraHours) {
		this.extraHours += extraHours;
	}

	@Override
	public String toString() {
		return "Hourly [workHours=" + workHours + ", extraHours=" + extraHours
				+ "]";
	}

}
