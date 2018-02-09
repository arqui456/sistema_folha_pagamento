package salary;

public class Salaried {
	
	private String payDay;
	private Commissioned comissioned;
	private double cash;

	public Salaried() {
		this.cash = 0;
		this.comissioned.setCommissioned(false);
	}
	
	public Salaried(double cash, boolean isCommissioned){
		this.cash = cash;
		
		if(isCommissioned == true){
			this.comissioned.setCommissioned(true);
		}
	}



}
