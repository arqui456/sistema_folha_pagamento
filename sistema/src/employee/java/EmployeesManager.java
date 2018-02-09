package employee.java;

public class EmployeesManager {
	
	private Employee[] employees;
	private int totalEmployees;

	public EmployeesManager() {
		this.employees = new Employee[0];
		this.totalEmployees = 0;	
	}
	
	public void AddEmployee(Employee employee){
		this.employees[this.totalEmployees++] = employee;
	}

	public void DeleteEmployee(int id) {
		
		for(int i = 0; i < this.employees.length; i++){
			if(this.employees[i] != null && this.employees[i].getId() == id){
				this.employees[i] = null;
				break;
			}
			
			if(i == employees.length - 1){
				System.out.println("The requested person is not employeed");
			}
		}
	}
}
