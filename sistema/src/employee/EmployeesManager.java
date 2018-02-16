package employee;

import java.util.ArrayList;

import salary.Hourly;

public class EmployeesManager {
	
	private ArrayList<Employee> employees = new ArrayList<Employee>();
	private Payroll pay = new Payroll();
	private Employee lastRemovedEmployee;
	private String lastAddedEmployeeName;
	private int totalEmployees = 0;
	private int uniqueId = 0;
	private int lastChange = -1;
	private double aux = 0;
	/*
	 * @lastChange:
	 * if 1 = added employee
	 * if 2 = deleted employee
	 * if 3 = altered employee
	 * 
	 */

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
	
	public int getLastChange() {
		return lastChange;
	}

	public void setLastChange(int lastChange) {
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

	@Override
	public String toString() {
		return "EmployeesManager [employees=" + employees + ", totalEmployees=" + totalEmployees + "\n";
	}
	
	
	
	
}