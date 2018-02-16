package sindicate;

public class Sindicate {
	
	private String sindicateId;
	private double sindicateTax;

	public Sindicate() {
		this.sindicateTax = 0;
	}
	
	public Sindicate(String sindicateId, double sindicateTax){
		this.sindicateId = sindicateId;
		this.sindicateTax = sindicateTax;
	}

	public double getSindicateTax() {
		return sindicateTax;
	}

	public void setSindicateTax(double sindicateTax) {
		this.sindicateTax = sindicateTax;
	}

	public String getSindicateId() {
		return sindicateId;
	}

	public void setSindicateId(String sindicateId) {
		this.sindicateId = sindicateId;
	}

	@Override
	public String toString() {
		return "Sindicate [sindicateId=" + sindicateId + ", sindicateTax=" + sindicateTax + "]";
	}

	
	

}