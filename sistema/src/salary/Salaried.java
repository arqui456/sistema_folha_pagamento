package salary;

public class Salaried extends Salary {
	
	private double wage;

	public Salaried() {
		this.wage = 0;
	}
	
	public Salaried(double wage){
		this.wage = wage;
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	@Override
	public String toString() {
		return "Salaried [" + "wage: " + wage;
	}
	
	
}