package salary;

import utils.Date;

public class Salary {
	
	private Type payroll;

	public Salary() {
	}
	
	public Salary(Type payroll, double cash){
		this.payroll = payroll;
	}
	
	public Salary(Type payroll, double cash, Date payDeadLine){
		this(payroll, cash);
	}

	public Type getPayroll() {
		return payroll;
	}

	public void setPayroll(Type payroll) {
		this.payroll = payroll;
	}
}