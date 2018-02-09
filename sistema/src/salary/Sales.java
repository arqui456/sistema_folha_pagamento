package salary;

import utils.Date;

public class Sales {

	private Date saleDate;
	private double saleValue;
	
	public Sales() {
		this.saleDate = null;
		this.saleValue = 0.0;
	}
	
	public Sales(Date saleDate, double saleValue){
		this.saleDate = saleDate;
		this.saleValue = saleValue;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public double getSaleValue() {
		return saleValue;
	}

	public void setSaleValue(double saleValue) {
		this.saleValue = saleValue;
	}
	
	

	

}
