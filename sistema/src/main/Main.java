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

public class Main {
	
	private static EmployeesManager manager = new EmployeesManager();
	private static Scanner inputator = new Scanner(System.in);
	private static Interface interfaceMain = new Interface();
	
	public static void main(String[] args) {
		boolean exit = false; 
		while(exit == false) {
		    exit = menu();
		}
		inputator.close();
	}
	
	private static boolean menu(){
		
		int input = interfaceMain.printMenu();
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
		Employee employee = new Employee();
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
		String name = inputator.nextLine();
		Card card = new Card();
		int id = manager.FindEmployee(name);
		if(manager.getEmployees().get(id).getCard().size() != 0)
		    manager.setPreviousCard(manager.getEmployees().get(id).getCard().get(manager.getEmployees().get(id).getCard().size() - 1));
		manager.getEmployees().get(id).addCard(card);
		manager.setLastEmployeeThatSwitchedCards(id);
	}
	
	private static void launchsale(){
		System.out.println("Type in the related employee name: ");
		String name = inputator.nextLine();
		int id = manager.FindEmployee(name);
		if(id == -1) return;
		
		Sales sale = new Sales();
		
		manager.setPreviousSale(((Commissioned) manager.getEmployees().get(id).getType().getType()).getLastSale());
		manager.setLastEmployeeThatAddedASale(id);
		((Commissioned) manager.getEmployees().get(id).getType().getType()).addSale(sale);
	}
	
	private static void launchServiceTax(){
		System.out.println("Type in the related employee name: ");
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
		manager.AltEmployee();
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
    
    @SuppressWarnings("unused")
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
}
