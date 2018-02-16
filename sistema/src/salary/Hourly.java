package salary;

public class Hourly {

	private double workHours;
	private double extraHours;
	private double wage;
	
	public Hourly() {
		this.workHours = 0;
		this.extraHours  = 0;
	}
	
	public Hourly(double wage) {
		this();
		this.wage = wage;
	}
	
	public void setWorkHours(double workHours) {
		this.workHours = workHours;
	}
	
	public double getWorkHours(){
		return workHours;
	}

	public double getExtraHours() {
		return extraHours;
	}

	public void setExtraHours(double extraHours) {
		this.extraHours = extraHours;
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	@Override
	public String toString() {
		return "Hourly [workHours=" + workHours + ", extraHours=" + extraHours
				+ ", wage=" + wage + "]";
	}

	

}