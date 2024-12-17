package Assignment6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BevShopTest {
	BevShop b1;
	@BeforeEach
	void setUp() throws Exception {
		b1 = new BevShop();
		b1.startNewOrder(10, Day.FRIDAY, "Jon", 21);
		b1.processAlcoholOrder("beer", Size.LARGE);
		b1.processCoffeeOrder("latte", Size.MEDIUM, true, false);
		b1.processSmoothieOrder("berryblast", Size.LARGE, 5, true);
		b1.startNewOrder(11, Day.SATURDAY, "Paul", 23);
		b1.processAlcoholOrder("wine", Size.MEDIUM);
		b1.processAlcoholOrder("vodka tonic", Size.SMALL);
	}

	@AfterEach
	void tearDown() throws Exception {
		b1 = null;
	}

	@Test
	void testIsMaxFruit() {
		assertFalse(b1.isMaxFruit(4));
		assertTrue(b1.isMaxFruit(6));
	}
	
	@Test
	void testIsEligibleForMore() {
		assertTrue(b1.isEligibleForMore());
		b1.processAlcoholOrder(null, null);
		b1.processAlcoholOrder(null, null);
		assertFalse(b1.isEligibleForMore());
	}
	
	@Test
	void testGetNumOfAlcoholDrink() {
		assertTrue(b1.getNumOfAlcoholDrink() == 2);
		b1.processAlcoholOrder(null, null);
		assertTrue(b1.getNumOfAlcoholDrink() == 3);
	}
	
	@Test
	void testIsValidAge() {
		assertTrue(b1.isValidAge(21));
		assertFalse(b1.isValidAge(1));
	}
	
	@Test
	void testStartNewOrder() {
		b1.startNewOrder(10, Day.FRIDAY, "Peter", 10);
		assertEquals(b1.totalNumOfMonthlyOrders() ,3);
	}
	
	@Test
	void testProcessCoffeeOrder() {
		b1.processCoffeeOrder(null, null, false, false);
		assertEquals(b1.getCurrentOrder().findNumOfBeveType(Type.COFFEE), 1);	
	}
	
	@Test
	void testProcessAlcoholOrder() {
		b1.processAlcoholOrder("beer",Size.LARGE);
		assertEquals(b1.getCurrentOrder().findNumOfBeveType(Type.ALCOHOL), 3);	
	}
	
	@Test
	void testProcessSmoothieOrder() {
		b1.processSmoothieOrder("berrycherry", Size.MEDIUM, 1, false);
		assertEquals(b1.getCurrentOrder().findNumOfBeveType(Type.SMOOTHIE), 1);	
	}
	
	@Test
	void testFindOrder() {
		assertEquals(b1.findOrder(b1.getCurrentOrder().getOrderNo()), 1);
	}
	
	@Test
	void testTotalOrderPrice() {
		assertEquals(b1.totalOrderPrice(b1.getCurrentOrder().getOrderNo()), 5.7, 0.1);
	}
	
	@Test
	void testTotalMonthlySale() {
		assertEquals(b1.totalMonthlySale(), 18.7, 0.1);
	}
	
	@Test
	void testTotalNumOfMonthlyOrders() {
		assertEquals(b1.totalNumOfMonthlyOrders(), 2);
	}
	
	@Test
	void testGetCurrentOrder() {
		assertTrue(b1.getCurrentOrder().equals(b1.orders.getLast()));
	}
	
	@Test
	void testGetOrderAtIndex() {
		assertTrue(b1.getOrderAtIndex(0).equals(b1.orders.getFirst()));
	}

}
