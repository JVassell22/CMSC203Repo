import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MgmCompanyTest {
	Property property1,property2,property3,property4,property5,property6;
	ManagementCompany mgmCo1,mgmCo2;

	@BeforeEach
	void setUp() throws Exception {
		mgmCo1 = new ManagementCompany("Amazon","123",50);
		mgmCo2 = new ManagementCompany("Charity","999",-1);
		property1 = new Property("Hotel","Rockville",200,"Walter Jackson",1,2,2,2);
		property2 = new Property();
		property3 = new Property("Hotel","Rockville",300,"Walter Jackson",4,4,1,1);
		property4 = new Property("Hotel","Rockville",400,"Walter Jackson",5,5,1,1);
		property5 = new Property("Hotel","Rockville",500,"Walter Jackson",6,6,1,1);
		property6 = null;
	}

	@AfterEach
	void tearDown() throws Exception {
		mgmCo1 = mgmCo2 = null;
		property1 = property2 = property3 = property4 = property5 = property6 = null;
	}

	@Test 
	void testAddProperty() {
		assertEquals(mgmCo1.addProperty(property1),0);
		assertEquals(mgmCo1.addProperty(property6),-2);
		assertEquals(mgmCo1.addProperty("School","Athens",20,"Harold Smith",0,0,-2,-22),-3);
		assertEquals(mgmCo1.addProperty("Bank","Athens",50,"George Smith",0,0,3,3),-4);
		assertEquals(mgmCo1.addProperty(property1),-4);
		
	}
	@Test 
	void testRemoveLastProperty() {
		mgmCo1.addProperty(property1);
		mgmCo1.removeLastProperty();
		assertEquals(mgmCo1.getPropertiesCount(), 0);
		mgmCo1.addProperty(property1);
		assertEquals(mgmCo1.getPropertiesCount(),1);
	}
	@Test 
	void testIsPropertiesFull() {
		assertFalse(mgmCo1.isPropertiesFull());
		mgmCo1.addProperty(property1);
		mgmCo1.addProperty(property2);
		mgmCo1.addProperty(property3);
		mgmCo1.addProperty(property4);
		mgmCo1.addProperty(property5);
		assertTrue(mgmCo1.isPropertiesFull());
	}
	@Test 
	void testGetPropertiesCount() {
		mgmCo1.addProperty(property1);
		mgmCo1.addProperty(property2);
		mgmCo1.addProperty(property3);
		assertEquals(mgmCo1.getPropertiesCount(),3);
	}
	@Test 
	void testgetTotalRent() {
		mgmCo1.addProperty(property1);
		mgmCo1.addProperty(property3);
		assertEquals(mgmCo1.getTotalRent(),500);
	}
	@Test 
	void testGetHighestRentProperty() {
		mgmCo1.addProperty(property1);
		mgmCo1.addProperty(property2);
		mgmCo1.addProperty(property3);
		mgmCo1.addProperty(property4);
		mgmCo1.addProperty(property5);
		assertEquals(mgmCo1.getHighestRentProperty().toString(),property5.toString());
		
	}
	@Test 
	void testIsManagementFeeValid() {
		assertTrue(mgmCo1.isManagementFeeValid());
		assertFalse(mgmCo2.isManagementFeeValid());
		
	}
}
