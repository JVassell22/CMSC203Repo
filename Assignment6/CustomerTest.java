package Assignment6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {
	Customer c1, c2, c3;

	@BeforeEach
	void setUp() throws Exception {
		c1 = new Customer("Jon",21);
		c2 = new Customer("Paul",18);
		c3 = new Customer("Ringo",16);
	}

	@AfterEach
	void tearDown() throws Exception {
		c1 = c2 = c3 = null;
	}

	@Test
	void test() {
		String s = (c1.getName()+","+c1.getAge());
		assertTrue(c1.toString().equals(s));
	}

}
