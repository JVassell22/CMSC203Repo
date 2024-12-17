package Assignment6;

public class Alcohol extends Beverage {

	private boolean isWeekend;
	
	public Alcohol(String bevName, Size size, boolean isWeekend) {
		super(bevName, Type.ALCOHOL, size);
		this.isWeekend = isWeekend;
	}
	
	
	public Alcohol(Alcohol a) {
		super(a.getBevName(), a.getType(), a.getSize());
		this.isWeekend = a.getIsWeekend();
	}
	
//	*GETTER*
	public boolean getIsWeekend() {
		return isWeekend;
	}
	
//	*SETTER*
	public void setIsWeekend(boolean isWeekend) {
		this.isWeekend = isWeekend;
	}
	
//	*OVERRIDEN METHODS*
	@Override
	public double calcPrice() {
		double base = addSizePrice();
		if(isWeekend) {
			base += 0.6;
		}
		return base;
	}
	
	@Override
	public String toString() {
		if(isWeekend) {
			return(getBevName()+","+getSize()+", IS offered during the weekend, $"+calcPrice());
		}
		return(getBevName()+","+getSize()+", is NOT offered during the weekend, $"+calcPrice());
	}
	
	@Override
	public boolean equals(Object anotherBev) {
		Alcohol temp = null;
		if(anotherBev instanceof Alcohol) {
			temp = (Alcohol) anotherBev;
			return(super.equals(temp) && this.isWeekend == temp.getIsWeekend());
		}
		return false;
	}
}
