package Assignment2;

public class Procedure {
	private String procName, date, practName;
	private double cost;
	
	public Procedure() { // NO ARG CONSTRUCTOR
		
		procName = "No procedure given";
		date = "2000.01.01";
		practName = "Jonas Salk";
		cost = 0;
		
	}
	
	public Procedure(String procName, String date) { // CONSTRUCTOR FOR NAME OF PROCEDURE AND DATE OF PROCEDURE
		this.procName = procName;
		this.date = date;
		practName = "Jonas Salk";
		cost = 0;
	}
	public Procedure(String procName, String date, String practName, double cost) { // CONSTRUCTOR FOR ALL FIELDS
		this.procName = procName;
		this.date = date;
		this.practName = practName;
		this.cost = cost;
	}
	
	//************************************// // ALL ACCESSORS FOR FIELDS
	
	public String getProcName() {
		return procName;
	}
	public String getDate() {
		return date;
	}
	public String getPractName() {
		return practName;
	}
	public double getCost() {
		return cost;
	}
	
	//************************************// // ALL MUTATORS FOR FIELDS
	
	public void setProcName(String procName) {
		this.procName = procName;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setPractName(String practName) {
		this.practName = practName;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	//************************************//
	
	public String toString() { //FULL DISPLAY OF INFO IN A TOSTRING METHOD
		return("Procedure: "+procName+"\nDate: "+date+"\nPractictioner: "+practName+"\nCost of procedure: "+cost);
	}

}
