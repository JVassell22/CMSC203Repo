import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyTest {
	Property property1, property2, property3, property4;
	Plot testPlot = new Plot(4,4,1,3);

	@BeforeEach
	void setUp() throws Exception {
		property1 = new Property("Lighthouse","Jamestown",500,"James Abbott",4,4,1,3);
		property2 = new Property("Hotel Lombardy","Washington", 1000, "Abigail Smith");
		property3 = new Property();
		property4 = new Property(property1);
	}

	@AfterEach
	void tearDown() throws Exception {
		property1 = property2 = property3 = property4 = null;
	}

	@Test 
	void testGetPlot() {
		assertEquals(testPlot.toString(),property1.getPlot().toString());
	}
	@Test  
	void testGetPropertyName() {
		assertEquals("",property3.getPropertyName());
	}
	@Test 
	void testGetRentAmount() {
		assertEquals(1000,property2.getRentAmount());
	}
	@Test 
	void testtoString() {
		assertEquals("Lighthouse,Jamestown,James Abbott,500.0",property1.toString());
	}

}
