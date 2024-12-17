package Assignment6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoffeeTest {
	Coffee c1, c2, c3;
	@BeforeEach
	void setUp() throws Exception {
		c1 = new Coffee("latte",Size.LARGE,false,true);
		c2 = new Coffee(c1);
		c3 = new Coffee("cappuchino",Size.LARGE,true,true);
	}

	@AfterEach
	void tearDown() throws Exception {
		c1 = c2 = c3 = null;
	}

	@Test
	void testCalcPrice() {
		assertEquals(c1.calcPrice(),3.5,0.1);
		c2.setExtraShot(true);
		assertEquals(c2.calcPrice(),4.0,0.1);
		assertFalse(c1.calcPrice() == c2.calcPrice());
	}
	
	@Test
	void testToString() {
		String s1 = (c1.getBevName()+","+c1.getSize()+", does NOT have extra shot, does have extra syrup, $"+c1.calcPrice());
		assertTrue(c1.toString().equals(s1));
		String s3 = (c3.getBevName()+","+c3.getSize()+", does have extra shot, does have extra syrup, $"+c3.calcPrice());
		assertTrue(c3.toString().equals(s3));
	}
	
	@Test
	void testEquals() {
		assertTrue(c1.equals(c2));
		assertFalse(c2.equals(c3));
	}

}
