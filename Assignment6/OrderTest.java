package Assignment6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderTest {
	Order o1, o2;
	Customer c1 = new Customer("Jon",21);
	Customer c2 = new Customer("Paul",19);
	@BeforeEach
	void setUp() throws Exception {
		o1 = new Order(9,Day.FRIDAY,c1);
		o2 = new Order(10,Day.SATURDAY,c2);
	}

	@AfterEach
	void tearDown() throws Exception {
		o1 = o2 = null;
	}

	@Test
	void testAddBeverage() {
		o1.addNewBeverage("beer", Size.LARGE);
		o1.addNewBeverage("latte", Size.MEDIUM, false, true);
		assertEquals(o1.getTotalItems(),2);
	}
	
	@Test
	void testCalcOrderTotal() {
		o1.addNewBeverage("beer", Size.LARGE);
		o1.addNewBeverage("latte", Size.MEDIUM, false, true);
		o2.addNewBeverage("berryblast", Size.LARGE, 1, true);
		assertEquals(o1.calcOrderTotal(),6,0.1);
		assertEquals(o2.calcOrderTotal(),5,0.1);
	}
	
	@Test
	void testFindNumOfBeverageType() {
		o1.addNewBeverage("beer", Size.LARGE);
		o1.addNewBeverage("latte", Size.MEDIUM, false, true);
		o1.addNewBeverage("wine", Size.MEDIUM);
		assertEquals(o1.findNumOfBeveType(Type.ALCOHOL),2);
		assertEquals(o1.findNumOfBeveType(Type.COFFEE),1);
	}
	
	@Test
	void testGetBeverage() {
		o1.addNewBeverage("beer", Size.LARGE);
		o1.addNewBeverage("latte", Size.MEDIUM, false, true);
		o1.addNewBeverage("wine", Size.MEDIUM);
		Alcohol a1 = new Alcohol("beer",Size.LARGE,false);
		assertTrue(o1.getBeverage(0).equals(a1));
	}
	
	@Test
	void testIsWeekend() {
		assertTrue(o2.isWeekend());
		assertFalse(o1.isWeekend());
	}
	
	@Test
	void testCompareTo() {
		if(o1.getOrderNo() > o2.getOrderNo()) {
			assertTrue(o1.compareTo(o2) == 1);
		}
		else if(o1.getOrderNo() < o2.getOrderNo()) {
			assertTrue(o1.compareTo(o2) == -1);
		}
		else {
			assertTrue(o1.compareTo(o2) == 0);
		}
	}
}
