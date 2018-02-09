package employee.java;

import salary.Salary;
import sindicate.Sindicate;

public class Employee {
	
	private int id;
	private String name;
	private String adress;
	private Salary salary;
	private Sindicate sindicate;
	

	public Employee() {
		this.id++;
	}
	
	public Employee(String name, String adress) {
		this();
		this.name = name;
		this.adress = adress;
	}
	
	public Employee(String name, String adress, Salary salary){
		this(name, adress);
		this.salary = salary;
	}
	
	public Employee(String name, String adress, Salary salary, boolean isSindicated){
		this(name, adress,salary);
		if(isSindicated == true){
			this.sindicate = new Sindicate();
		}
	}
	
	public Employee(String name, String adress, Salary salary, Sindicate sindicate){
		this(name, adress,salary);
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

	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", adress=" + adress
				+ ", salary=" + salary + "]";
	}
}
