package Assignment6;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Order implements OrderInterface, Comparable<Order> {
	
	Scanner in = new Scanner(System.in);
	private int orderTime, orderNo;
	private Day orderDay;
	private Customer cust;
	
	private ArrayList<Beverage> beverages = new ArrayList<>();;
	
	public Order(int orderTime, Day orderDay, Customer cust) {
		this.orderTime = orderTime;
		while(orderTime > 23 || orderTime < 8) {
			System.out.println("Invalid hours please re-enter");
			this.orderTime = in.nextInt();
			in.close();
		}
		this.orderDay = orderDay;
		this.cust = new Customer(cust);
		this.orderNo = generateOrder();
	}
	
	public int generateOrder() {
		Random rand = new Random();
		return(rand.nextInt(10000, 90000));
	}
	
	public int getOrderNo() {
		return orderNo;
	}
	
	public int getOrderTime() {
		return orderTime;
	}
	
	public Day getDay() {
		return orderDay;
	}
	
	public Day getOrderDay() {
		return orderDay;
	}
	
	public Customer getCustomer() {
		return cust;
	}
	
	public int getTotalItems() {
		return beverages.size();
	}
	
	@Override
	public Beverage getBeverage(int itemNo) {
		if(itemNo < beverages.size() && itemNo > -1) {
			return beverages.get(itemNo);
		}
		System.out.println("Invalid Item number !!! Please re-enter");
		while(itemNo > beverages.size() || itemNo < -1) {
			itemNo = in.nextInt();
		}
		return beverages.get(itemNo);
	}
	
	@Override
	public boolean isWeekend() {
		if(orderDay.equals(Day.SATURDAY) || orderDay.equals(Day.SUNDAY)) {
			return true;
		}
		return false;
	}

	@Override
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		Coffee c = new Coffee(bevName, size, extraShot, extraSyrup);
		beverages.add(c);
	}

	@Override
	public void addNewBeverage(String bevName, Size size) {
		Alcohol a = new Alcohol(bevName, size,isWeekend());
		beverages.add(a);
	}

	@Override
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		Smoothie s = new Smoothie(bevName, size, numOfFruits, addProtein);
		beverages.add(s);
	}
	@Override
	public double calcOrderTotal() {
		double total = 0;
		for(Beverage b: beverages) {
			total += b.calcPrice();
		}
		return total;
	}

	@Override
	public int findNumOfBeveType(Type type) {
		int total = 0;
		for(Beverage b: beverages) {
			if(b.getType().equals(type)) {
				total++;
			}
		}
		return total;
	}

	@Override
	public int compareTo(Order o) {
		if(this.orderNo > o.getOrderNo()) {
			return 1;
		}
		else if(this.orderNo == o.getOrderNo()) {
			return 0;
		}
		else {
			return -1;
		}
	}
	
	@Override
	public String toString() {
		String temp = "Beverages ordered: \n";
		for(Beverage b: beverages) {
			temp += b.toString()+"\n";
		}
		return("Order number: "+orderNo+"\nOrder Time:"+orderTime+"\nOrder Day: "+orderDay+"\nCustomer Info:"+cust.toString()+"\n"+temp);
	}
}