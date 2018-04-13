package main;

import java.util.Scanner;

public class Interface {
	
	private static Scanner inputator = new Scanner(System.in);
	
	public int printMenu() {
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
		return input;
	}

}
