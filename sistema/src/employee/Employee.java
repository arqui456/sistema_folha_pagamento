package employee;

import java.util.ArrayList;
import java.util.Scanner;

import salary.Commissioned;
import salary.Hourly;
import salary.Type;
import sindicate.Sindicate;
import utils.PayMethod;

public class Employee {
	
	private int id;
	private String name;
	private String adress;
	private Type type;
	private Sindicate sindicate;
	private ArrayList<Card> card = new ArrayList<Card>();
	private String payday;
	private ServiceTax tax;
	
	private static Scanner input = new Scanner(System.in);
	
	public Employee() {
		
		System.out.println("Type in the employee's name: ");
		 this.name = input.nextLine();
		
		System.out.println("Type in the employee's adress: ");
		this.adress = input.nextLine();
		
		System.out.println("Select a type of payment for the employee: ");
		System.out.println("    1.Hourly wage");
		System.out.println("    2.Salaried");
		System.out.println("    3.Commissioned");
		
		int choice = input.nextInt();
		while(choice < 1 || choice > 3) {
			System.out.println("Invalid input, try again: ");
			choice = input.nextInt();
		}
		
		System.out.println("WARNING! defaults pay dates will be used according to the contract");
		System.out.println("Type in the employee's wage: ");
		double wage = input.nextDouble();
		
		this.type = new Type(choice, wage);
		if(choice == 1)
			this.setPayday("semanal 1 sexta");
		else if (choice == 2)
			this.setPayday("mensal $");
		else
			this.setPayday("semanal 2 sexta");
		
		System.out.println("Select the type of payment for the employee: ");
		System.out.println("    1.Check send via mail");
		System.out.println("    2.Check in hand");
		System.out.println("    3.Bank account deposit");
		
		choice = input.nextInt();
		while(choice < 1 || choice > 3) {
			System.out.println("Invalid input, try again");
			choice = input.nextInt();
		}
		if(choice == 1)
		    this.getType().setPayMethod(PayMethod.CHECK_SEND_BY_EMAIL);
		else if(choice == 2)
			this.getType().setPayMethod(PayMethod.CHECK_IN_HAND);
		else
			this.getType().setPayMethod(PayMethod.BANK_ACCOUNT_DEPOSIT);	
	}
	
	public Employee(String name, String adress) {
		this.name = name;
		this.adress = adress;
	}
	
	public Employee(String name, String adress, Type type){
		this(name, adress);
		this.type = type;
	}
	
	public Employee(String name, String adress,Type type, boolean isSindicated){
		this(name, adress,type);
		if(isSindicated == true){
			this.sindicate = new Sindicate();
		}
	}
	
	public Employee(String name, String adress, Type type, Sindicate sindicate){
		this(name, adress,type);
		this.sindicate = sindicate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Sindicate getSindicate() {
		return sindicate;
	}
	
	public void setSindicate() {
		this.sindicate = new Sindicate();
	}

	public void setSindicate(Sindicate sindicate) {
		this.sindicate = sindicate;
	}
	
	public ArrayList<Card> getCard() {
		return card;
	}

	public void setCard(ArrayList<Card> card) {
		this.card = card;
	}
	
	public void addCard(Card card) {
		this.card.add(card);
	}
	
	public void removeCard() {
		this.card.remove(this.card.size() - 1);
	}
	
	public String getPayday() {
		return payday;
	}

	public void setPayday(String payday) {
		this.payday = payday;
	}
	
	public ServiceTax getTax() {
		return tax;
	}

	public void setTax(ServiceTax tax) {
		this.tax = tax;
	}
	
	public void removeServiceTax() {
		this.tax = null;
	}
	
	public void calculateHours(){
		double hours = 0;
		for(int i = 0;i < this.card.size();i++){
			hours = this.card.get(i).getEndHour().getHour() - this.card.get(i).getStartHour().getHour() + (
					Math.abs(this.card.get(i).getEndHour().getMinute() - this.card.get(i).getStartHour().getMinute())
					);
		}
		((Hourly) this.type.getType()).setWorkHours(hours);
		if(hours > 8.00){
			((Hourly) this.type.getType()).setExtraHours(hours - 8.00);
		}
		
	}
	
	public double calculateCommissions() {
		return ((Commissioned) this.getType().getType()).calculateSales();
	}

	@Override
	public String toString() {
		return "\nEmployee [id=" + id + ", name=" + name + ", adress=" + adress
				+ ", type=" + type + "]";
	}

	
}
