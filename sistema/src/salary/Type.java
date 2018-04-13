package salary;

import utils.PayMethod;

public class Type {
	
	private Object type;
	private int typeIndex;
	private double wage;
	private PayMethod payMethod;
	
	public Type(int typeIndex, double wage) {
		this.typeIndex = typeIndex;
		this.wage = wage;
		if(typeIndex == 1) 
			this.type = new Hourly(wage);
		else if(typeIndex == 2)
			this.type = new Salaried(wage);
		else
			this.type = new Commissioned(wage);	
	}

	public Object getType() {
		return type;
	}

	public void setType(Object type) {
		this.type = type;
	}
	
	public int getTypeIndex() {
		return typeIndex;
	}

	public void setTypeIndex(int typeIndex) {
		this.typeIndex = typeIndex;
	}
	
	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}
	
	public PayMethod getPayMethod() {
		return payMethod;
	}
	
	public void setPayMethod(PayMethod payMethod) {
		this.payMethod = payMethod;
	}

	@Override
	public String toString() {
		return "Type [type=" + type + "]";
	}
}