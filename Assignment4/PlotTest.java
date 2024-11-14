import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlotTest {
	private Plot plot1,plot2,plot3,plot4,plot5,plot6,plot7;

	@BeforeEach
	void setUp() throws Exception {
		plot1 = new Plot();
		plot2 = new Plot(plot1);
		plot3 = new Plot(0,0,2,2);
		plot4 = new Plot(1,1,2,2);
		plot5 = new Plot(9,9,2,2);
		plot6 = new Plot(3,3,4,5);
		plot7= new Plot(5,5,-7,-7);
	}

	@AfterEach
	void tearDown() throws Exception {
		plot1=plot2=plot3=plot4=plot5=plot6=null;
	}

	@Test 
	void testOverlap() {
		assertTrue(plot3.overlaps(plot4));
		assertTrue(plot1.overlaps(plot2));
	}
	@Test 
	void testEncompass() {
		assertTrue(plot5.encomapsses());
		assertTrue(plot7.encomapsses());
	}
	@Test 
	void test() {
		assertEquals("3,3,4,5",plot6.toString());
	}
}
