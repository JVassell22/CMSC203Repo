package Assignment6;

public class Coffee extends Beverage {

	private boolean extraShot, extraSyrup;
	public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		super(bevName, Type.COFFEE, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
	}
	
	public Coffee(Coffee c) {
		super(c.getBevName(),c.getType(),c.getSize());
		this.extraShot = c.getExtraShot();
		this.extraSyrup = c.getExtraSyrup();
	}
	
//	*GETTERS*
	public boolean getExtraShot() {
		return extraShot;
	}
	
	public boolean getExtraSyrup() {
		return extraSyrup;
	}
	
//	*SETTERS*
	public void setExtraShot(boolean extraShot) {
		this.extraShot = extraShot;
	}
	
	public void setExtraSyrup(boolean extraSyrup) {
		this.extraSyrup = extraSyrup;
	}
//	*OVERRIDEN METHODS*
	@Override
	public double calcPrice() {
		double base = addSizePrice();
		if(extraShot) {
			base+= .5;
		}
		if(extraSyrup) {
			base += .5;
		}
		return base;
	}
	
	@Override
	public String toString() {
		if(extraShot && extraSyrup) {
			return(getBevName()+","+getSize()+", does have extra shot, does have extra syrup, $"+calcPrice());
		}
		else if(extraShot && !extraSyrup) {
			return(getBevName()+","+getSize()+", does have extra shot, does NOT have extra syrup, $"+calcPrice());
		}
		else if(!extraShot && extraSyrup) {
			return(getBevName()+","+getSize()+", does NOT have extra shot, does have extra syrup, $"+calcPrice());
		}
		else {
			return(getBevName()+","+getSize()+", does NOT have extra shot, does NOT have extra syrup, $"+calcPrice());
		}
	}
	
	@Override
	public boolean equals(Object anotherBev) {
		Coffee temp = null;
		if(anotherBev instanceof Coffee) {
			temp = (Coffee) anotherBev;
			return(super.equals(temp) && this.extraShot == temp.getExtraShot() && this.extraSyrup == temp.getExtraSyrup());
		}
		return false;
	}
}
