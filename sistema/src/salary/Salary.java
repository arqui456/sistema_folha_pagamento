package salary;

import utils.Date;

public class Salary {
	
	private Type payroll;
	private double cash;
	private Date payDeadLine;

	public Salary() {
		
	}
	
	public Salary(Type payroll, double cash){
		this.payroll = payroll;
		this.cash = cash;
	}
	
	public Salary(Type payroll, double cash, Date payDeadLine){
		this(payroll, cash);
		this.payDeadLine = payDeadLine;
	}

	

}
