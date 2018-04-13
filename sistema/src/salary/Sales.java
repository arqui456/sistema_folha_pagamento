package salary;

import java.util.Scanner;

import utils.Date;

public class Sales {

	private Date saleDate;
	private double saleValue;
	
	private static Scanner inputator = new Scanner(System.in);
	
	public Sales() {
		
		int day = 0;
		int month = 0;
		int year = 0;
		
		System.out.println("Type in the sale's date (d/m/y): ");
		String input = inputator.nextLine();
		String inputAux[] = input.split("/");
		day = Integer.parseInt(inputAux[0]);
		month = Integer.parseInt(inputAux[1]);
		year = Integer.parseInt(inputAux[2]);
		
		Date saleDate = new Date(day, month, year);
		
		System.out.println("Type in the sale's value: ");
		double saleValue = inputator.nextDouble();
		
		this.saleDate = saleDate;
		this.saleValue = saleValue;
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