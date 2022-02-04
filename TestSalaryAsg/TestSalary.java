package ece325_assignment4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestSalary {
	
	@Test
	void testForCorrectness() {
		// test these inputs for correct outputs (all inputs are valid)
		assertEquals(60d, Salary.pay(100d, 50d, 10), 0.001);
		assertEquals(495d, Salary.pay(500d, 30d, 5), 0.001);
		assertEquals(172.825, Salary.pay(203.75, 35d, 2), 0.001);
			// test case with salary = maximum ($1000)
		assertEquals(947.480, Salary.pay(1000d, 82.52, 3), 0.001);
		assertEquals(254.697, Salary.pay(325.93, 84.27, 4), 0.001);
			// test case with bonus = 0
		assertEquals(80d, Salary.pay(100d, 20d, 0), 0.001);
			// test case with snacksAmount = 0
		assertEquals(110d, Salary.pay(100d, 0d, 10), 0.001);
			// test case where total pay = 0
		assertEquals(0d, Salary.pay(100d, 110d, 10), 0.001);
	}
	
	@Test
	void testForInvalidInputs() {
		
		// test these inputs for correctly throwing IllegalArgumentException (inputs are invalid/illegal)
			// salary out of range
		assertThrows(IllegalArgumentException.class, () -> {
			Salary.pay(0d, 50d, 10);
		});
			// salary out of range
		assertThrows(IllegalArgumentException.class, () -> {
			Salary.pay(-10d, 20d, 10);
		});
			// bonus out of range
		assertThrows(IllegalArgumentException.class, () -> {
			Salary.pay(100d, 20d, -10);
		});
			// snacksAmount out of range
		assertThrows(IllegalArgumentException.class, () -> {
			Salary.pay(100d, -50d, 10);
		});
			// salary out of range
		assertThrows(IllegalArgumentException.class, () -> {
			Salary.pay(1001d, 40d, 5);
		});
			// bonus out of range
		assertThrows(IllegalArgumentException.class, () -> {
			Salary.pay(100d, 20d, 20);
		});
			// snackAmount > total earnings
		assertThrows(IllegalArgumentException.class, () -> {
			Salary.pay(200d, 205d, 0);
		});
		
	}
	
	@Test
	void testForNull() {
		
		// test these inputs for correctly throwing NullPointerException (input(s) are null)
			// salary is null
		assertThrows(NullPointerException.class, () -> {
			Salary.pay(null, 30d, 2);
		});
			// bonus is null
		assertThrows(NullPointerException.class, () -> {
			Salary.pay(800d, 40d, null);
		});
			// snacksAmount is null
		assertThrows(NullPointerException.class, () -> {
			Salary.pay(400d, null, 5);
		});
	}
}