package Assignment6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlcoholTest {
	Alcohol a1, a2;
	@BeforeEach
	void setUp() throws Exception {
		a1 = new Alcohol("Modelo",Size.MEDIUM,true);
		a2 = new Alcohol(a1);
	}

	@AfterEach
	void tearDown() throws Exception {
		a1 = a2 = null;
	}

	@Test
	void testCalcPrice() {
		assertEquals(a1.calcPrice(),3.1,0.1);
		a2.setSize(Size.LARGE);
		assertEquals(a2.calcPrice(),3.6,0.1);
		assertEquals(a1.calcPrice(),3.1,0.1);
	}
	
	@Test
	void testToString() {
		String name = (a1.getBevName()+","+a1.getSize()+", IS offered during the weekend, $"+a1.calcPrice());
		assertTrue(name.equals(a1.toString()));
	}
	@Test
	void testEquals() {
		assertTrue(a1.equals(a2));
	}

}
