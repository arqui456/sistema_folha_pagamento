package salary;


public class Commissioned {

	private boolean isCommissioned;
	private Sales[] sales;
	private int numberOfSales;

	public Commissioned() {
		this.isCommissioned = false;
		this.numberOfSales = 0;
	}
	
	public Commissioned(Sales sales){
		this.sales[this.numberOfSales] = sales;
	}
	
	public boolean isCommissioned() {
		return isCommissioned;
	}

	public void setCommissioned(boolean isCommissioned) {
		this.isCommissioned = isCommissioned;
	}

	public Sales[] getSales() {
		return sales;
	}

	public void setSales(Sales[] sales) {
		this.sales = sales;
	}

	public int getNumberOfSales() {
		return numberOfSales;
	}

	public void setNumberOfSales(int numberOfSales) {
		this.numberOfSales = numberOfSales;
	}
	
	
	
	

	
}
