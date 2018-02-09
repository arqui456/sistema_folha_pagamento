package main;

import java.util.Scanner;

public class Main {

	Scanner inputator = new Scanner(System.in);
	
	
	public int menu(){
		
		System.out.println("Possible actions:");
		System.out.println("	1. Add a employee");
		System.out.println("    2. Remove a employee");
		System.out.println("    3. Launch a point card");
		System.out.println("    4. Launch a sales result");
		System.out.println("    5. Launch a service tax");
		System.out.println("    6. alter a employee data");
		System.out.println("    7. Execute payroll");
		System.out.println("    8. Undo/redo");
		System.out.println("    9. create a payroll");
		System.out.println("    10. Exit program");
		
		int input = inputator.nextInt();
		
		while(input <= 0 || input > 10){
			System.out.println("Invalid input, try again");
			input = inputator.nextInt();
		}
		boolean exit = false;
		switch(input){
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				break;
			case 10:
				System.out.println("Exit program...");
				exit = true;
				break;
			case default:
				break;
		}
		
		return exit;
	}
	
	public void addEmployee(){
		
	}
	
	public void remEmployee(){
		
	}
	
	public void launchCard(){
		
	}
	
	public void launchsale(){
		
	}
	
	public void launchServiceTax(){
		
	}
	
	public void altEmployee(){
		
	}
	
	public void excPayroll(){
		
	}
	
	public void Undo(){
		
	}
	
	public void createPayroll(){
		
	}
	
	
	
	public static void main(String[] args) {
		

	}

}
