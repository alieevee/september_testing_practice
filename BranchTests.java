package dates.test;

import dates.Dates;
import dates.Dates.Day;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

/**Test suite that has 100% branch coverage for dates.Dates
 * Conditional coverage is almost 100%. It is not fully 100% because of the for loop on line 92. 
 * This is because the test suite does not test every single doomsday date in doomsdaysByMonth. 
 * I have chosen not to reach 100% conditional coverage because if the test suite was designed to, 
 * it would be costly as it has to cover every single doomsday (14 different doomsdays), which means
 * 14 tests that would function the same. Therefore, I have only tested one doomsday, and consequently
 * the for loop does not iterate through all the doomsdays. 
 * @author yshe735
 * @link dates.Dates
 * 13 tests in total, separated by categories shown by single line comments*/

public class BranchTests {
	
	//Creating an object of type Dates
	/**Testing creation of Dates object
	 * @link Dates
	 * @result Creates a new Dates object. If correct, it should not catch an exception, i.e. not
	 * fail the test*/
	@Test
	public void testClass() {
		try {
		      new Dates();
		    } catch (Exception e) {
		      fail(e.getMessage());
		    }
	}
	
	//General case
	/**Testing a "normal" date for a general case (correct date)
	 * @link Dates#dayOfWeek(int, int, int)
	 * @result An object of type Dates will be instantiated correctly and method 
	 * dayOfWeek shall be invoked with a regular date (not a doomsday nor a leap year case)*/
	@Test
	public void testNormalDate() {
		Day dayReturned = Dates.dayOfWeek(2001, 9, 9);
		Day expectedDay = Dates.Day.Sunday;
		assertEquals(expectedDay, dayReturned);
	}
	
	//General cases - leap properties
	/**Testing a 00 non leap year (1900)
	 * @link Dates#dayOfWeek(int, int, int)
	 * @result Object of type Dates instantiated and dayOfWeek invoked with a 00 non leap year(correct)
	 * and should return a valid weekday */
	@Test
	public void test00NonLeapYear() {
		Day dayReturned = Dates.dayOfWeek(1900,2,10);
		Day expectedDay = Dates.Day.Saturday;
		assertEquals(expectedDay, dayReturned);
	}
	
	/**Testing a leap year date on an actual leap year (correct date)
	 * @link Dates#dayOfWeek(int, int, int)
	 * @result Object of type Dates instantiated and dayOfWeek invoked with February the 29th on 
	 * a leap year. */
	@Test
	public void testLeapYearDay() {
		Day dayReturned = Dates.dayOfWeek(2000, 2, 29);
		Day expectedDay = Dates.Day.Tuesday;
		assertEquals(expectedDay, dayReturned);
	}
	
	/**Testing a non 00 leap year (2004)
	 * @link Dates#dayOfWeek(int, int, int)
	 * @result Object of type Dates instantiated and dayOfWeek invoked with a leap year date (correct)
	 * and should return a valid weekday */
	@Test
	public void testNon00LeapYear() {
		Day dayReturned = Dates.dayOfWeek(2004,2,29);
		Day expectedDay = Dates.Day.Sunday;
		assertEquals(expectedDay, dayReturned);
	}
	
	//Testing doomsday properties
	/**Testing a doomsday date (correct date)
	 * @link Dates#dayOfWeek(int, int, int)
	 * @result Object of type Dates instantiated and dayOfWeek invoked with the 4th of April
	 * (a doomsday date) */
	@Test
	public void testDoomsDay() {
		Day dayReturned = Dates.dayOfWeek(2000, 4, 4);
		Day expectedDay = Dates.Day.Tuesday;
		assertEquals(expectedDay, dayReturned);
	}

	/**Testing a day before the first doomsday date (correct date)
	 * This tests whether dayOfWeek counts backwards correctly
	 * @link Dates#dayOfWeek(int, int, int)
	 * @result Object of type Dates instantiated and dayOfWeek invoked with the 9th of January
	 * (a day before the first doomsday date of the year)
	 * */
	@Test
	public void testCountingBackwardsFromDoomsDay() {
		Day dayReturned = Dates.dayOfWeek(2000,1,9);
		Day expectedDay = Dates.Day.Sunday;
		assertEquals(expectedDay, dayReturned);
	}
	
	//Testing invalid date inputs
	/**Testing an invalid year from before 1753
	 * This tests whether an exception is correctly thrown
	 * @link Dates#dayOfWeek(int, int, int)
	 * @result Object of type Dates instantiated and dayOfWeek invoked a date before 1753
	 * which dayOfWeek should throw an Illegal Argument Exception */
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidYear() {
		Dates.dayOfWeek(1600,1,9);
	}
	
	/**Testing an invalid month (less than 1)
	 * This tests whether an exception is correctly thrown
	 * @link Dates#dayOfWeek(int, int, int)
	 * @result Object of type Dates instantiated and dayOfWeek invoked a date before Jan (month 0)
	 * which dayOfWeek should throw an Illegal Argument Exception */
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidMonthBeforeJan() {
		Dates.dayOfWeek(2000,0,9);
	}
	
	/**Testing an invalid month (greater than 12)
	 * This tests whether an exception is correctly thrown
	 * @link Dates#dayOfWeek(int, int, int)
	 * @result Object of type Dates instantiated and dayOfWeek invoked a date before Jan (month 0)
	 * which dayOfWeek should throw an Illegal Argument Exception */
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidMonthAfterDec() {
		Dates.dayOfWeek(2000,13,9);
	}
	
	/**Testing an invalid day (less than 1)
	 * This tests whether an exception is correctly thrown
	 * @link Dates#dayOfWeek(int, int, int)
	 * @result Object of type Dates instantiated and dayOfWeek invoked with an invalid date (day 0)
	 * which dayOfWeek should throw an Illegal Argument Exception */
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidDayBeforeOne() {
		Dates.dayOfWeek(2000,9,0);
	}
	
	/**Testing an invalid day (greater than 31)
	 * This tests whether an exception is correctly thrown
	 * @link Dates#dayOfWeek(int, int, int)
	 * @result Object of type Dates instantiated and dayOfWeek invoked with an invalid date (day 0)
	 * which dayOfWeek should throw an Illegal Argument Exception */
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidDayAfter31() {
		Dates.dayOfWeek(2000,9,32);
	}
	
	/**Testing an invalid month date 
	 * This tests whether an exception is correctly thrown
	 * @link Dates#dayOfWeek(int, int, int)
	 * @result Object of type Dates instantiated and dayOfWeek invoked with an invalid date (day 30 in Feb)
	 * which dayOfWeek should throw an Illegal Argument Exception */
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidDayAfterFeb29() {
		Dates.dayOfWeek(2000,2,30);
	}
	
	

}
