package employee;

import java.util.ArrayList;
import java.util.Scanner;

import salary.Hourly;
import salary.Sales;
import salary.Type;
import utils.LastChange;
import utils.PayMethod;

public class EmployeesManager {
	
	private ArrayList<Employee> employees = new ArrayList<Employee>();
	private Payroll pay = new Payroll();
	
	private int totalEmployees = 0;
	private int uniqueId = 0;
	private LastChange lastChange = LastChange.NO_CHANGE;
	private double aux = 0;
	
	private Employee lastRemovedEmployee;
	private String lastAddedEmployeeName;
	private Card previousCard;
	private int lastEmployeeThatSwitchedCards;
	private Sales previousSale;
	private int lastEmployeeThatAddedASale;
	private ServiceTax previousServiceTax;
	private int lastEmployeeThatAddedServiceTax;
	private Employee lastAlteredEmployee;
	private int lastAlteredEmployeeName;
	
	private static Scanner inputator = new Scanner(System.in);
	
	public EmployeesManager() {
		this.totalEmployees = 0;	
	}
	
	public void AddEmployee(Employee employee){
		lastAddedEmployeeName = employee.getName();
		employee.setId(generateId());
		this.employees.add(employee);
		this.totalEmployees++;
	}

	public void DeleteEmployee(String name) {
		for(int i = 0; i < this.employees.size(); i++){
			if(this.employees.get(i) != null && this.employees.get(i).getName().equals(name)){
				lastRemovedEmployee = employees.get(i);
				this.employees.remove(i);
				this.totalEmployees--;
				System.out.println("Employee deleted");
				break;
			}
			if(i == employees.size() - 1){
				System.out.println("The requested person is not employed");
			}
		}
	}
	
	public int FindEmployee(String name) {
		int index;
		for(int i = 0; i < this.employees.size(); i++){
			if(this.employees.get(i) != null && this.employees.get(i).getName().equals(name)){
				index = i;
				System.out.println("Employee found");
				return index;
			}
			if(i == employees.size() - 1){
				System.out.println("The requested person is not employed");
			}
		}
		return -1;
	}
	
	public void AltEmployee() {
		
		System.out.println("Type in the employee's name: ");
		String name = inputator.nextLine();
		int id = this.FindEmployee(name);
		if(id == -1) return;
		
		System.out.println("What attribute do you what to edit? ");
		System.out.println("    1. Employee's name");
		System.out.println("    2. Employee's adress");
		System.out.println("    3. Employee's payment type");
		System.out.println("    4. Employee's payment method");
		System.out.println("    5. Employee's syndicability");
		System.out.println("    6. Employee's syndicate id");
		System.out.println("    7. Employee's syndicate tax");
			
		int choice = inputator.nextInt();
		while(choice < 1 || choice > 7) {
			System.out.println("Invalid input, try again: ");
			choice = inputator.nextInt();
		}
		
		switch(choice) {
		    case 1:
		    	System.out.println("Type in the new employee name: ");
		    	name = inputator.nextLine();
		    	this.getEmployees().get(id).setName(name);
		    	break;
		    case 2:
		    	System.out.println("Type in the new employee adress: ");
		    	name = inputator.nextLine();
		    	this.getEmployees().get(id).setAdress(name);
		    	break;
		    case 3:
		    	System.out.println("Select the new type of payment for the employee: ");
				System.out.println("    1.Hourly wage");
				System.out.println("    2.Salaried");
				System.out.println("    3.Commissioned");
				choice = inputator.nextInt();
				while(choice < 1 || choice > 3) {
					System.out.println("Invalid input, try again: ");
					choice = inputator.nextInt();
				}
				double wage = this.getEmployees().get(id).getType().getWage();
				Type type = new Type(choice, wage);
				this.getEmployees().get(id).setType(type);
				break;
		    case 4:
		    	System.out.println("Select the new payment method for the employee: ");
		    	System.out.println("    1.Check send via mail");
				System.out.println("    2.Check in hand");
				System.out.println("    3.Bank account deposit");
				choice = inputator.nextInt();
				while(choice < 1 || choice > 3) {
					System.out.println("Invalid input, try again");
					choice = inputator.nextInt();
				}
				if(choice == 1)
					this.getEmployees().get(id).getType().setPayMethod(PayMethod.CHECK_SEND_BY_EMAIL);
				else if(choice == 2)
					this.getEmployees().get(id).getType().setPayMethod(PayMethod.CHECK_IN_HAND);
				else
					this.getEmployees().get(id).getType().setPayMethod(PayMethod.BANK_ACCOUNT_DEPOSIT);
		    	break;
		    case 5:
		    	System.out.println("Is the employee syndicated?");
		    	System.out.println("    1. Yes");
		    	System.out.println("    2. No");
		    	choice = inputator.nextInt();
		    	while(choice < 1 || choice > 2) {
		    		System.out.println("Invalid input, try again: ");
		    		choice = inputator.nextInt();
		    	}
		    	if(choice == 1)
		    		this.getEmployees().get(id).setSindicate();
		    	else
		    		this.getEmployees().get(id).setSindicate(null);
		    	break;
		    case 6:
		    	if(this.getEmployees().get(id).getSindicate() != null) {
		    		System.out.println("type in the syndicate id: ");
		    		name = inputator.nextLine();
		    		this.getEmployees().get(id).getSindicate().setSindicateId(name);
		    	}
		    	else
		    		System.out.println("Employee is not part of a syndicate!");
		    	break;
		    case 7:
		    	if(this.getEmployees().get(id).getSindicate() != null) {
		    		System.out.println("type in the syndicateTax: ");
		    		double tax = inputator.nextDouble();
		    		this.getEmployees().get(id).getSindicate().setSindicateTax(tax);
		    	}
		    	else
		    		System.out.println("Employee is not part of a syndicate!");
		    	break;
		}
	}

	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}

	public int getTotalEmployees() {
		return totalEmployees;
	}

	public void setTotalEmployees(int totalEmployees) {
		this.totalEmployees = totalEmployees;
	}
	
	public int generateId() {
		return uniqueId++;
	}

	public Employee getLastRemovedEmployee() {
		return lastRemovedEmployee;
	}

	public void setLastRemovedEmployee(Employee lastRemovedEmployee) {
		this.lastRemovedEmployee = lastRemovedEmployee;
	}

	public String getLastAddedEmployeeName() {
		return lastAddedEmployeeName;
	}

	public void setLastAddedEmployeeName(String lastAddedEmployeeName) {
		this.lastAddedEmployeeName = lastAddedEmployeeName;
	}
	
	public LastChange getLastChange() {
		return lastChange;
	}

	public void setLastChange(LastChange lastChange) {
		this.lastChange = lastChange;
	}
	
	public Payroll getPay() {
		return pay;
	}

	public void setPay(Payroll pay) {
		this.pay = pay;
	}
	
	public void getPayrolls() {
		ArrayList<String> lol =  this.pay.getPaymentAgenda();
		
		for(int i = 0;i < lol.size();i++) {
			System.out.println("Payroll: " + lol.get(i) + " - ");
			for(int j = 0;j < employees.size();j++) {
				if(this.employees.get(j).getPayday().equals(lol.get(i))) {
					System.out.println("\t  " + employees.get(j).getName());
				}
			}
		}
	}
	
	public boolean searchAgenda(String date) {

		for(int i = 0;i < employees.size();i++){
			if(employees.get(i).getPayday().equals(date)){
				System.out.println("Employee to be paid at this date found, paying...");
				this.aux += pay(employees.get(i));
			}
		}
		this.pay.setLastPayTotal(this.aux);
		if(this.aux != 0)
			return true;
		return false;
	}

	private double pay(Employee employee) {
		double cash = 0;
		if(employee.getType().getTypeIndex() == 1){
			employee.calculateHours();
			cash =  ((Hourly) employee.getType().getType()).getWorkHours() * employee.getType().getWage();
			cash += ((Hourly) employee.getType().getType()).getExtraHours() * (employee.getType().getWage() * 1.5);
		}
		else if(employee.getType().getTypeIndex() == 3){
			cash =  employee.calculateCommissions();
		}
		else {
			cash = employee.getType().getWage();
			if(employee.getTax() != null )
				cash -= employee.getTax().getTax();
			if(employee.getSindicate() != null)
				cash -= employee.getSindicate().getSindicateTax();
			this.pay.setToPay(cash);
		}
		return cash;
	}
	
	public Card getPreviousCard() {
		return previousCard;
	}

	public void setPreviousCard(Card previousCard) {
		this.previousCard = previousCard;
	}

	public int getLastEmployeeThatSwitchedCards() {
		return lastEmployeeThatSwitchedCards;
	}

	public void setLastEmployeeThatSwitchedCards(int lastEmployeeThatSwitchedCards) {
		this.lastEmployeeThatSwitchedCards = lastEmployeeThatSwitchedCards;
	}
	
	public Sales getPreviousSale() {
		return previousSale;
	}

	public void setPreviousSale(Sales previousSale) {
		this.previousSale = previousSale;
	}

	public int getLastEmployeeThatAddedASale() {
		return lastEmployeeThatAddedASale;
	}

	public void setLastEmployeeThatAddedASale(int lastEmployeeThatAddedASale) {
		this.lastEmployeeThatAddedASale = lastEmployeeThatAddedASale;
	}
	
	public ServiceTax getPreviousServiceTax() {
		return previousServiceTax;
	}

	public void setPreviousServiceTax(ServiceTax previousServiceTax) {
		this.previousServiceTax = previousServiceTax;
	}

	public int getLastEmployeeThatAddedServiceTax() {
		return lastEmployeeThatAddedServiceTax;
	}

	public void setLastEmployeeThatAddedServiceTax(int lastEmployeeThatAddedServiceTax) {
		this.lastEmployeeThatAddedServiceTax = lastEmployeeThatAddedServiceTax;
	}
	
	public Employee getLastAlteredEmployee() {
		return lastAlteredEmployee;
	}

	public void setLastAlteredEmployee(Employee lastAlteredEmployee) {
		this.lastAlteredEmployee = lastAlteredEmployee;
	}

	public int getLastAlteredEmployeeName() {
		return lastAlteredEmployeeName;
	}

	public void setLastAlteredEmployeeName(int lastAlteredEmployeeName) {
		this.lastAlteredEmployeeName = lastAlteredEmployeeName;
	}

	@Override
	public String toString() {
		return "EmployeesManager [employees=" + employees + ", totalEmployees=" + totalEmployees + "\n";
	}
}