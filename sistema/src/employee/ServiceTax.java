package employee;

public class ServiceTax {
	
	private String service;
	private double tax;
	
	public ServiceTax(String service, double tax) {
		this.service = service;
		this.tax = tax;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}
}