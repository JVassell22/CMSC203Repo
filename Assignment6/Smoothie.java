package Assignment6;

public class Smoothie extends Beverage{

	private int numOfFruits;
	private boolean addProtein;
	
	public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein) {
		super(bevName, Type.SMOOTHIE, size);
		this.numOfFruits = numOfFruits;
		this.addProtein = addProtein;
	}
	
	public Smoothie(Smoothie s) {
		super(s.getBevName(), s.getType(), s.getSize());
		this.numOfFruits = s.getNumOfFruits();
		this.addProtein = s.getAddProtein();
	}
	
	
	public int getNumOfFruits() {
		return numOfFruits;
	}
	
	public boolean getAddProtein() {
		return addProtein;
	}
	
	public void setNumOfFruits(int numOfFruits) {
		this.numOfFruits = numOfFruits;
	}
	
	public void setAddProtein(boolean addProtein) {
		this.addProtein = addProtein;
	}
	@Override
	public double calcPrice() {
		double base = addSizePrice();
		base += (numOfFruits*.5);
		if(addProtein) {
			base+= 1.5;
		}
		return base;
 	}
	
	@Override
	public String toString() {
		if(addProtein) {
			return(getBevName()+","+getSize()+", DOES have protein, number of fruits: "+numOfFruits+", $"+calcPrice());
		}
		return(getBevName()+","+getSize()+", does NOT have protein, number of fruits: "+numOfFruits+", $"+calcPrice());
	}
	
	@Override
	public boolean equals(Object anotherBev) {
		Smoothie temp = null;
		if(anotherBev instanceof Smoothie) {
			temp = (Smoothie) anotherBev;
			return(super.equals(temp) && this.addProtein == temp.getAddProtein() && this.numOfFruits == temp.getNumOfFruits());
		}
		return false;
	}

}
