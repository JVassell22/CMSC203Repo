import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HolidayBonusTest {
	double[][] data = { {1,2,3,4}, {10,11,12,13}, {6,7} }; 

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalculateHolidayBonus() {
		double[] result = HolidayBonus.calculateHolidayBonus(data);
		assertEquals(4000,result[0],.001);
		assertEquals(20000,result[1],.001);
		assertEquals(4000,result[2],.001);
	}
	@Test
	void testCalculateTotalHolidayBonus() {
		assertEquals(28000.0, HolidayBonus.calculateTotalHolidayBonus(data), .001);
	}

}
