package employee;

import java.util.ArrayList;

public class Payroll {
	
	private ArrayList<String> paymentAgenda = new ArrayList<String>();
	private double lastPayTotal = 0;
	private double toPay = 0;
	
	Payroll(){
		this.paymentAgenda.add("semanal 1 sexta");
		this.paymentAgenda.add("mensal $");
		this.paymentAgenda.add("semanal 2 sexta");
	}

	public ArrayList<String> getPaymentAgenda() {
		return paymentAgenda;
	}

	public void setPaymentAgenda(ArrayList<String> paymentAgenda) {
		this.paymentAgenda = paymentAgenda;
	}
	
	public void createNewPaymentAgenda(String paygenda) {
		this.paymentAgenda.add(paygenda);
	}
	
	public double getLastPayTotal() {
		return lastPayTotal;
	}

	public void setLastPayTotal(double lastPayTotal) {
		if(lastPayTotal > 0)
		    this.lastPayTotal = lastPayTotal;
	}

	public double getToPay() {
		return toPay;
	}

	public void setToPay(double toPay) {
		this.toPay += toPay;
	}

	@Override
	public String toString() {
		return "Payrolls:\n" + paymentAgenda + "\n";
	}
}