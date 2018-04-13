package salary;

import java.util.ArrayList;

public class Commissioned extends Salary {

	private ArrayList<Sales> sales = new ArrayList<Sales>();
	private int numberOfSales;
	private double wage;
	private double commission = 0.20;

	public Commissioned() {
		this.numberOfSales = 0;
	}
	
	public Commissioned(double wage){
		this();
		this.wage = wage;
	}
	
	public Commissioned(Sales sales){
		this.sales.add(sales);
	}
	
	public double calculateSales (){
		double cash = 0;
		for(int i = 0; i < this.sales.size();i++){
			cash += (this.sales.get(i).getSaleValue() * 0.20);
		}
		cash += this.wage * 2;
		return cash;
	}
	
	public int getNumberOfSales() {
		return numberOfSales;
	}

	public void setNumberOfSales(int numberOfSales) {
		this.numberOfSales = numberOfSales;
	}
	
	public void addSale(Sales sale) {
		this.sales.add(sale);
	}
	
	public Sales getLastSale() {
		if(this.sales.size() != 0)
		    return this.sales.get(this.sales.size() - 1);
		else return null;
	}
	
	public void removeLastSale() {
		this.sales.remove(this.sales.size() - 1);
	}
	
	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}
	
	public ArrayList<Sales> getSales() {
		return sales;
	}

	public void setSales(ArrayList<Sales> sales) {
		this.sales = sales;
	}

	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}

	@Override
	public String toString() {
		return "Commissioned [sales=" + sales + ", numberOfSales="
				+ numberOfSales + ", wage=" + wage + "]";
	}
	
	
}