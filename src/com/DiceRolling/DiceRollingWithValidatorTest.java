/**
 * 
 */
package com.DiceRolling;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author benja
 *
 */
class DiceRollingWithValidatorTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test1() {
		String expected = "Snake Eyes!";
		String actual = DiceRollingWithValidator.getSpecial("1", "1");
		assertEquals(expected, actual);
	}

	@Test
	void test2() {
		String expected = "Craps!";
		String actual = DiceRollingWithValidator.getSpecial("3", "4");
		assertEquals(expected, actual);
	}

	@Test
	void test3() {
		String expected = "Craps!";
		String actual = DiceRollingWithValidator.getSpecial("7", "4");
		assertEquals(expected, actual);
	}

	@Test
	void test4() {
		String expected = "Box Cars!";
		String actual = DiceRollingWithValidator.getSpecial("6", "6");
		assertEquals(expected, actual);
	}

	@Test
	void test5() {
		String expected = "";
		String actual = DiceRollingWithValidator.getSpecial("1", "2");
		assertEquals(expected, actual);
	}
}
