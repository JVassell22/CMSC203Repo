package Assignment6;

import java.util.ArrayList;

public class BevShop implements BevShopInterface {

	public static final int MAX_FRUIT = 5, 
			MAX_ORDER_FOR_ALCOHOL = 3, 
			MAX_TIME = 23, 
			MIN_AGE_FOR_ALCOHOL = 21, 
			MIN_TIME = 8;
	
	ArrayList<Order> orders = new ArrayList<>();
	
	public BevShop() {
		
	}
	
	@Override
	public boolean isValidTime(int time) {
		if(time > MAX_TIME || time < MIN_TIME) {
			return false;
		}
		return true;
	}

	@Override
	public int getMaxNumOfFruits() {
		return MAX_FRUIT;
	}

	@Override
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}

	@Override
	public boolean isMaxFruit(int numOfFruits) {
		if(numOfFruits > MAX_FRUIT) {
			return true;
		}
		return false;
	}

	@Override
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}

	@Override
	public boolean isEligibleForMore() {
		if(this.getNumOfAlcoholDrink() > 3) {
			return false;
		}
		return true;
	}

	@Override
	public int getNumOfAlcoholDrink() {
		return(orders.getLast().findNumOfBeveType(Type.ALCOHOL));
	}

	@Override
	public boolean isValidAge(int age) {
		if(age < MIN_AGE_FOR_ALCOHOL) {
			return false;
		}
		return true;
	}

	@Override
	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		orders.add(new Order(time, day, new Customer(customerName, customerAge)));
	}

	@Override
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		orders.getLast().addNewBeverage(bevName, size, extraShot, extraSyrup);
		
	}

	@Override
	public void processAlcoholOrder(String bevName, Size size) {
		orders.getLast().addNewBeverage(bevName, size);
		
	}

	@Override
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
		orders.getLast().addNewBeverage(bevName, size, numOfFruits, addProtein);
		
	}

	@Override
	public int findOrder(int orderNo) {
		for(int i = 0; i < orders.size(); i++) {
			if(orders.get(i).getOrderNo() == orderNo) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public double totalOrderPrice(int orderNo) {
		for(Order o: orders) {
			if(o.getOrderNo() == orderNo) {
				return o.calcOrderTotal();
			}
		}
		return -1;
	}

	@Override
	public double totalMonthlySale() {
		double total = 0;
		for(Order o: orders) {
			total+=o.calcOrderTotal();
		}
		return total;
	}

	@Override
	public int totalNumOfMonthlyOrders() {
		return orders.size();
	}

	@Override
	public Order getCurrentOrder() {
		return orders.getLast();
	}

	@Override
	public Order getOrderAtIndex(int index) {
		return orders.get(index);
	}

	@Override
	public void sortOrders() {
		orders.sort(null);
		
	}
	
}
