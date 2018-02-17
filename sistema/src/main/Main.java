package main;

import java.util.Scanner;

import employee.ServiceTax;

import employee.Card;
import employee.Employee;
import employee.EmployeesManager;
import salary.Commissioned;
import salary.Sales;
import salary.Type;
import sindicate.Sindicate;
import utils.Date;
import utils.DateExtended;

public class Main {
	
	private static EmployeesManager manager = new EmployeesManager();

	private static Scanner inputator = new Scanner(System.in);
	
	private static boolean menu(){
		
		System.out.println("Possible actions: ");
		System.out.println("    1. Add a employee");
		System.out.println("    2. Remove a employee");
		System.out.println("    3. Launch a point card");
		System.out.println("    4. Launch a sales result");
		System.out.println("    5. Launch a service tax");
		System.out.println("    6. alter a employee data");
		System.out.println("    7. Execute payroll");
		System.out.println("    8. Undo/redo");
		System.out.println("    9. payroll");
		System.out.println("    10. create a payroll");
		System.out.println("    11. Exit program");
		
		int input = inputator.nextInt();
		
		while(input <= 0 || input > 11){
			System.out.println("Invalid input, try again");
			input = inputator.nextInt();
		}
		boolean exit = false;
		switch(input){
			case 1:
				addEmployee();
				break;
			case 2:
				remEmployee();
				break;
			case 3:
				launchCard();
				break;
			case 4:
				launchsale();
				break;
			case 5:
				launchServiceTax();
				break;
			case 6:
				altEmployee();
				break;
			case 7:
				excPayroll();
				break;
			case 8:
				Undo();
				break;
			case 9:
				payroll();
				break;
			case 10:
				createPayroll();
				break;
			case 11:
				System.out.println("Exit program...");
				exit = true;
				break;
		}
		
		return exit;
	}
	
	private static void addEmployee(){
		System.out.println("Type in the employee's name: ");
		inputator.nextLine();
		String name = inputator.nextLine();
		System.out.println("Type in the employee's adress: ");
		String adress = inputator.nextLine();
		System.out.println("Select a type of payment for the employee: ");
		System.out.println("    1.Hourly wage");
		System.out.println("    2.Salaried");
		System.out.println("    3.Commissioned");
		
		int choice = inputator.nextInt();
		while(choice < 1 || choice > 3) {
			System.out.println("Invalid input, try again: ");
			choice = inputator.nextInt();
		}
		
		System.out.println("WARNING! defaults pay dates will be used according to the contract");
		System.out.println("Type in the employee's wage: ");
		double wage = inputator.nextDouble();
		Type type = new Type(choice, wage);
		
		Employee employee = new Employee(name, adress, type);
		if(choice == 1)
			employee.setPayday("semanal 1 sexta");
		else if (choice == 2)
			employee.setPayday("mensal $");
		else
			employee.setPayday("semanal 2 sexta");
		System.out.println("Select the type of payment for the employee: ");
		System.out.println("    1.Check send via mail");
		System.out.println("    2.Check in hand");
		System.out.println("    3.Bank account deposit");
		choice = inputator.nextInt();
		while(choice < 1 || choice > 3) {
			System.out.println("Invalid input, try again");
			choice = inputator.nextInt();
		}
		if(choice == 1)
		    employee.getType().setPayMethod("Check send via mail");
		else if(choice == 2)
			employee.getType().setPayMethod("Check in hand");
		else
			employee.getType().setPayMethod("Bank account deposit");
		
		manager.AddEmployee(employee);
		System.out.println("The employee below was added to the database");
		System.out.println(manager);
	}
	
	private static void remEmployee(){
		System.out.println("Type in the employee's name: ");
		inputator.nextLine();
		String name = inputator.nextLine();
		manager.DeleteEmployee(name);
	}
	
	private static void launchCard(){
		System.out.println("Type in the name of the employee that shall receive this card: ");
		inputator.nextLine();
		String name = inputator.nextLine();
		int day = 0;
		int month = 0;
		int year = 0;
		int minutes = 0;
		int hours = 0;
		System.out.println("Type in the check-in date (d/m/y): ");
		String input = inputator.nextLine();
		String inputAux[] = input.split("/");
		day = Integer.parseInt(inputAux[0]);
		month = Integer.parseInt(inputAux[1]);
		year = Integer.parseInt(inputAux[2]);
		System.out.println("Type in the check-in hour (hour:minute)");
		String hourr = inputator.nextLine();
        String[] hourAux = hourr.split(":");
        hours = Integer.parseInt(hourAux[0]);
        minutes = Integer.parseInt(hourAux[1]);
        Card card = new Card();
        Date date = new Date(day, month,year);
        DateExtended ddate = new DateExtended(hours, minutes);
        card.setStartDate(date);
        card.setStartHour(ddate);
		System.out.println("Type in the check-out date (d/m/y)");
		input = inputator.nextLine();
		inputAux = input.split("/");
		day = Integer.parseInt(inputAux[0]);
		month = Integer.parseInt(inputAux[1]);
		year = Integer.parseInt(inputAux[2]);
		System.out.println("Type in the check-out hour (hour:minute)");
		hourr = inputator.nextLine();
        hourAux = hourr.split(":");
        hours = Integer.parseInt(hourAux[0]);
        minutes = Integer.parseInt(hourAux[1]);
        date = new Date(day, month,year);
        ddate = new DateExtended(hours, minutes);
        card.setEndDate(date);
        card.setEndHour(ddate);
        System.out.println(card);
		int id = manager.FindEmployee(name);
		manager.setPreviousCard(manager.getEmployees().get(id).getCard().get(manager.getEmployees().get(id).getCard().size() - 1));
		manager.getEmployees().get(id).addCard(card);
		manager.setLastEmployeeThatSwitchedCards(id);
	}
	
	private static void launchsale(){
		System.out.println("Type in the related employee name: ");
		inputator.nextLine();
		String name = inputator.nextLine();
		int id = manager.FindEmployee(name);
		if(id == -1) return;
		
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
		Sales sale = new Sales(saleDate, saleValue);
		manager.setPreviousSale(((Commissioned) manager.getEmployees().get(id).getType().getType()).getLastSale());
		manager.setLastEmployeeThatAddedASale(id);
		((Commissioned) manager.getEmployees().get(id).getType().getType()).addSale(sale);
	}
	
	private static void launchServiceTax(){
		System.out.println("Type in the related employee name: ");
		inputator.nextLine();
		String name = inputator.nextLine();
		int id = manager.FindEmployee(name);
		if(id == -1) return;
		System.out.println("Type in the utilized service: ");
		String service = inputator.nextLine();
		System.out.println("Type in the service tax: ");
		double tax = inputator.nextDouble();
		
		manager.setPreviousServiceTax(manager.getEmployees().get(id).getTax());
		manager.setLastEmployeeThatAddedServiceTax(id);
		manager.getEmployees().get(id).setTax(new ServiceTax(service, tax));
	}
	
	private static void altEmployee(){
		System.out.println("Type in the employee's name: ");
		inputator.nextLine();
		String name = inputator.nextLine();
		int employeeIndex = manager.FindEmployee(name);
		if(employeeIndex == -1) return;
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
		    	manager.getEmployees().get(employeeIndex).setName(name);
		    	break;
		    case 2:
		    	System.out.println("Type in the new employee adress: ");
		    	name = inputator.nextLine();
		    	manager.getEmployees().get(employeeIndex).setAdress(name);
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
				double wage = manager.getEmployees().get(employeeIndex).getType().getWage();
				Type type = new Type(choice, wage);
				manager.getEmployees().get(employeeIndex).setType(type);
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
				    manager.getEmployees().get(employeeIndex).getType().setPayMethod("Check send via mail");
				else if(choice == 2)
					manager.getEmployees().get(employeeIndex).getType().setPayMethod("Check in hand");
				else
					manager.getEmployees().get(employeeIndex).getType().setPayMethod("Bank account deposit");
		    	/*inputator.nextLine();
		    	name = inputator.nextLine();
		    	int id = manager.getEmployees().get(employeeIndex).getType().getTypeIndex();
		    	if(id == 1) {
		    		((Hourly) manager.getEmployees().get(employeeIndex).getType().getType()).setPayDay(name);
		    	}
		    	else if(id == 2) {
		    		((Salaried) manager.getEmployees().get(employeeIndex).getType().getType()).setPayDay(name);
		    	}
		    	else if(id == 3) {
		    		((Commissioned) manager.getEmployees().get(employeeIndex).getType().getType()).setPayDay(name);
		    	} 
		    	*/
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
		    	    manager.getEmployees().get(employeeIndex).setSindicate();
		    	else
		    		manager.getEmployees().get(employeeIndex).setSindicate(null);
		    	break;
		    case 6:
		    	if(manager.getEmployees().get(employeeIndex).getSindicate() != null) {
		    		System.out.println("type in the syndicate id: ");
		    		name = inputator.nextLine();
		    		manager.getEmployees().get(employeeIndex).getSindicate().setSindicateId(name);
		    	}
		    	else
		    		System.out.println("Employee is not part of a syndicate!");
		    	break;
		    case 7:
		    	if(manager.getEmployees().get(employeeIndex).getSindicate() != null) {
		    		System.out.println("type in the syndicateTax: ");
		    		double tax = inputator.nextDouble();
		    		manager.getEmployees().get(employeeIndex).getSindicate().setSindicateTax(tax);
		    	}
		    	else
		    		System.out.println("Employee is not part of a syndicate!");
		    	break;
		}
	}
	
	private static void excPayroll(){
		System.out.println("Existing payrolls");
		payroll();
		System.out.println("Input a existing paying date:");
		String date = inputator.nextLine();
		if (manager.searchAgenda(date) == true){
			System.out.println("There are employee to be paid at this date");
		}
		else
			System.out.println("No employee to be paid at this date");
		System.out.println("Executing payroll");
	}
	
	private static void Undo(){
		System.out.println("What function do you wanna undo/redo ?");
		System.out.println("    1. Add a employee");
		System.out.println("    2. Remove a employee");
		System.out.println("    3. Launch a point card");
		System.out.println("    4. Launch a sales result");
		System.out.println("    5. Launch a service tax");
		System.out.println("    6. alter a employee data");
		System.out.println("    7. Execute payroll");
		int choice = inputator.nextInt();
		while(choice < 1 || choice > 7) {
			System.out.println("Invalid input, try again: ");
			choice = inputator.nextInt();
		}
		
		System.out.println("    1.Undo\n"
				         + "    2.Redo");
		int choice2 = inputator.nextInt();
		while(choice != 1 && choice != 2) {
			System.out.println("Invalid input, try again: ");
			choice2 = inputator.nextInt();
		}
		
		if(choice2 == 1) {
			switch(choice) {
		    case 1:
		    	manager.DeleteEmployee(manager.getLastAddedEmployeeName());
		    	break;
		    case 2:
		    	manager.AddEmployee(manager.getLastRemovedEmployee());
		    	break;
		    case 3:
		    	manager.getEmployees().get(manager.getLastEmployeeThatSwitchedCards()).removeCard();
		    	break;
		    case 4:
		    	((Commissioned) manager.getEmployees().get(manager.getLastEmployeeThatAddedASale()).getType().getType()).removeLastSale();
		    	break;
		    case 5:
		    	manager.getEmployees().get(manager.getLastEmployeeThatAddedServiceTax()).removeServiceTax();
		    	break;
		    case 6:
		    	manager.getEmployees().remove(manager.getLastAlteredEmployeeName());
		    	manager.AddEmployee(manager.getLastAlteredEmployee());
		    	break;
		    case 7:
		    	break;
		    }
		}
		else {
			switch(choice) {
		    case 1:
		    	manager.DeleteEmployee(manager.getLastAddedEmployeeName());
		    	addEmployee();
		    	break;
		    case 2:
		    	manager.AddEmployee(manager.getLastRemovedEmployee());
		    	remEmployee();
		    	break;
		    case 3:
		    	manager.getEmployees().get(manager.getLastEmployeeThatSwitchedCards()).addCard(manager.getPreviousCard());
		    	launchCard();
		    	break;
		    case 4:
		    	((Commissioned) manager.getEmployees().get(manager.getLastEmployeeThatAddedASale()).getType().getType()).addSale(manager.getPreviousSale());
		    	launchsale();
		    	break;
		    case 5:
		    	manager.getEmployees().get(manager.getLastEmployeeThatAddedServiceTax()).setTax(manager.getPreviousServiceTax());
		    	launchServiceTax();
		    	break;
		    case 6:
		    	manager.getEmployees().remove(manager.getLastAlteredEmployeeName());
		    	manager.AddEmployee(manager.getLastAlteredEmployee());
		    	altEmployee();
		    	break;
		    case 7:
		    	excPayroll();
		    	break;
		    }
		}
	}
	
    private static void payroll() {
    	manager.getPayrolls();
	}
    
    private static void testes(){
    	EmployeesManager tester = new EmployeesManager();
    	Employee employee = new Employee("arquimedes", "ic", new Type(1, 1000.0), new Sindicate("ze", 30.0));
    	tester.AddEmployee(employee);
    	employee = new Employee("Aurelio", "ic novo", new Type(2, 1000.0), new Sindicate("grande_ze", 666.0));
    	tester.AddEmployee(employee);
    	employee = new Employee("fedro", "ic velho", new Type(3, 5000.0), new Sindicate("ze2", 10.0));
    	tester.AddEmployee(employee);
    	employee = new Employee("juao", "ic perdido", new Type(1, 10000.0), new Sindicate("ze3", 50.0));
    	tester.AddEmployee(employee);
    	employee = new Employee("ander", "ic", new Type(1, 1250.0), new Sindicate("ze4", 100.0));
    	tester.AddEmployee(employee);
    	employee = new Employee("zica", "ic", new Type(2, 10.0), new Sindicate("ze5", 500.0));
    	tester.AddEmployee(employee);
    	employee = new Employee("marcos", "ic", new Type(1, 666.0), new Sindicate("ze6", 19.9));
    	tester.AddEmployee(employee);
    	
    	System.out.println(tester);
    	
    	excPayroll();
    }
	
	private static void createPayroll(){
		System.out.println("Type in the new payment agenda: ");
		String agenda = inputator.nextLine();
		manager.getPay().createNewPaymentAgenda(agenda);
		System.out.println(agenda);
	}
	
	public static void main(String[] args) {
		boolean exit = false; 
		while(exit == false) {
		    exit = menu();
		}
		//testes();
		inputator.close();
	}
}
