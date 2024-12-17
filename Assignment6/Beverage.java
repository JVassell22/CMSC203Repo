package Assignment6;

public abstract class Beverage {
	private String bevName;
	private Type type;
	private Size size;
	private final double BASEPRICE = 2, SIZEPRICE = 0.5;
	
	
	public Beverage(String bevName, Type type, Size size) {
		this.bevName = bevName;
		this.type = type;
		this.size = size;
	}
	
//	*GETTERS*
	public double getBasePrice() {
		return BASEPRICE;
	}
	public Type getType() {
		return type;
	}
	public String getBevName() {
		return bevName;
	}
	public Size getSize() {
		return size;
	}
//	*SETTERS*
	public void setSize(Size size) {
		this.size = size;
	}
	
	public void setBevName(String bevName) {
		this.bevName = bevName;
	}
	
	public void setType(Type type) {
		this.type = type;
	}
	
	public double addSizePrice() {
		if(size.equals(size.SMALL)) {
			return BASEPRICE;
		}
		else if(size.equals(size.MEDIUM)) {
			return BASEPRICE+SIZEPRICE;
		}
		else if(size.equals(size.LARGE)) {
			return BASEPRICE+(SIZEPRICE*2);
		}
		return -1;
	}
	
	public abstract double calcPrice();
	
	@Override
	public String toString() {
		return(bevName+","+size);
	}
	@Override
	public boolean equals(Object anotherBev) {
		Beverage temp = null;
		if(anotherBev instanceof Beverage) {
			temp = (Beverage) anotherBev;
			return(this.bevName.equals(temp.getBevName()) && this.type.equals(temp.getType()) && this.size.equals(temp.getSize()));
		}
		return false;
	}
	
}
