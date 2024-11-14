
public class ManagementCompany {
	static final int MAX_PROPERTY = 5, MGMT_DEPTH = 10, MGMT_WIDTH = 10;
	private String name, taxId;
	private int numberOfProperties = 0;
	private double mgmFee;
	private Property[] properties = new Property[MAX_PROPERTY];
	private Plot plot;
	
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name = name;
		this.taxId = taxID;
		this.mgmFee = mgmFee;
		this.plot = new Plot(x,y,width,depth);
	}
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxId = taxID;
		this.mgmFee = mgmFee;
		this.plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
	}
	public ManagementCompany() {
		this.name = "";
		this.taxId = "";
		this.mgmFee = 0;
		this.plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
	}
	public ManagementCompany(ManagementCompany otherCompany) {
		this.name = otherCompany.name;
		this.taxId = otherCompany.taxId;
		this.mgmFee = otherCompany.mgmFee;
		this.plot = new Plot(otherCompany.plot);
	}
	
	public String getName() {
		return name;
	}
	public String getTaxID() {
		return taxId;
	}
	public Property[] getProperties() {
		return properties;
	}
	public double getMgmFeePer() {
		return mgmFee;
	}
	public Plot getPlot() {
		return plot;
	}
	
	public int addProperty(String name, String city, double rent, String owner) {
		Property temp = new Property(name,city,rent,owner);
		if(properties[MAX_PROPERTY-1] != null) {
			return -1;
		}
		if(temp == null) {
			return -2;
		}
		if(temp.getPlot().encomapsses()) {
			return -3;
		}
		for(int i = 0; i < properties.length; i++) {
			if(properties[i] != null && i != numberOfProperties) {
				if(temp.getPlot().overlaps(properties[i].getPlot())) {
					return -4;
				}
			}	
		}
		properties[numberOfProperties] = temp;
		numberOfProperties++;
		return numberOfProperties-1;
	}
	public int addProperty(String name,String city,double rent,String owner,int x,int y,int width,int depth) {
		Property temp = new Property(name,city,rent,owner,x,y,width,depth);
		if(properties[MAX_PROPERTY-1] != null) {
			return -1;
		}
		
		if(temp == null) {
			return -2;
		}
		if(temp.getPlot().encomapsses()) {
			return -3;
		}
		for(int i = 0; i < properties.length; i++) {
			if(properties[i] != null && i != numberOfProperties) {
				if(temp.getPlot().overlaps(properties[i].getPlot())) {
					return -4;
				}
			}	
		}
		properties[numberOfProperties] = temp;
		numberOfProperties++;
		return numberOfProperties-1;
	}
	public int addProperty(Property property) {
		if(properties[MAX_PROPERTY-1] != null) {
			return -1;
		}
		if(property == null) {
			return -2;
		}
		Property temp = new Property(property);
		if(temp.getPlot().encomapsses()) {
			return -3;
		}
		for(int i = 0; i < properties.length; i++) {
			if(properties[i] != null && i != numberOfProperties) {
				if(temp.getPlot().overlaps(properties[i].getPlot())) {
					return -4;
				}
			}	
		}
		properties[numberOfProperties] = temp;
		numberOfProperties++;
		return numberOfProperties-1;
	}
	
	public void removeLastProperty() {
		properties[numberOfProperties-1] = null;
		numberOfProperties--;
	}
	public boolean isPropertiesFull() {
		for(Property p: properties) {
			if(p == null) {
				return false;
			}
		}
		return true;
	}
	public int getPropertiesCount() {
		return numberOfProperties;
	}
	public double getTotalRent() {
		double total = 0;
		for(Property p: properties) {
			if(p != null) {
				total+=p.getRentAmount();
			}
		}
		return total;
	}
	public Property getHighestRentProperty() {
		int index = 0;
		double rent = 0;
		for(int i = 0; i < properties.length; i++) {
			if(properties[i].getRentAmount() > rent) {
				index = i;
				rent = properties[i].getRentAmount();
			}
		}
		return properties[index];
	}
	public boolean isManagementFeeValid() {
		return(mgmFee >= 0 && mgmFee <= 100);
	}
	@Override
	public String toString() {
		String propertyInfo = "";
		if(properties[0] == null) {
			return("No properties available");
		}
		for(Property p: properties) {
			if(p != null) {
				propertyInfo+="\n"+p.toString(); 
			}
		}
		
		
		return("List of the properties for "+name+", taxID: "+taxId+"\n______________________________________________________"+propertyInfo+"\n______________________________________________________\n"
		+"\n total management Fee: "+(.01*mgmFee*getTotalRent()));
	}

}
