package sindicate;

public class Sindicate {
	
	private int sindicateId;
	private double sindicateTax;

	public Sindicate() {
		this.sindicateId++;
		this.sindicateTax = 0;
	}
	
	public Sindicate(double sindicateTax){
		this.sindicateTax = sindicateTax;
	}

	public double getSindicateTax() {
		return sindicateTax;
	}

	public void setSindicateTax(double sindicateTax) {
		this.sindicateTax = sindicateTax;
	}

	public int getSindicateId() {
		return sindicateId;
	}
	
	

}
