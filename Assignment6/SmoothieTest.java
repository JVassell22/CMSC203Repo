package Assignment6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SmoothieTest {
	Smoothie s1, s2, s3, s4;
	@BeforeEach
	void setUp() throws Exception {
		s1 = new Smoothie("Chocoberry",Size.MEDIUM,4,true);
		s2 = new Smoothie(s1);
		s3 = new Smoothie("Blueberry",Size.SMALL,1,false);
	}

	@AfterEach
	void tearDown() throws Exception {
		s1 = s2 = s3 = null;
	}

	@Test
	void testCalcPrice() {
		assertEquals(s1.calcPrice(),6,0.1);
		assertEquals(s3.calcPrice(),2.5,0.1);
		s3.setAddProtein(false);
		assertFalse(s1.calcPrice() == s3.calcPrice());
	}
	
	@Test
	void testToString() {
		String str1 = (s1.getBevName()+","+s1.getSize()+", DOES have protein, number of fruits: "+s1.getNumOfFruits()+", $"+s1.calcPrice());
		assertTrue(s1.toString().equals(str1));
		String str3 = (s3.getBevName()+","+s3.getSize()+", does NOT have protein, number of fruits: "+s3.getNumOfFruits()+", $"+s3.calcPrice());
		assertTrue(s3.toString().equals(str3));
	}
	
	@Test
	void testEquals() {
		assertTrue(s1.equals(s2));
		s2.setAddProtein(false);
		assertFalse(s1.equals(s2));
	}
	
	

}
