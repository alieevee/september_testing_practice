package dates.test;

import dates.Dates;
import dates.Dates.Day;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

/**Equivalence class testing
 * @author yshe735
 * Single test for the equivalence class doomsdaysByMonth
 * All the doomsdays in the int[][] should behave the same (i.e. all are classified as doomsdays).
 * When the input is a doomsday, int days2dd should be 0, and hence int position should just be the ordinal
 * value of doomsDay, with no counting required. 
 *
 * There are two equivalence classes for items in doomsdaysByMonth: 
 * (1) doomsday dates for non leap years
 * (2) doomsday dates for leap years (Jan 11th and Feb 29th)
 * 
 * Justification:
 *  Equivalence Test is designed to test (2), to see if on a leap year, Jan 11th is treated as a doomsday
 *  date. To save costs, just testing this one date means the other - Feb 29th - works too.
 *  This is not tested in either BranchTests (as testing a doomsday as the input was 4th April) and DataflowTest (where
 *  a path for the validity of the input was checked), so improves the test suite quality by checking another
 *  subtype of input that may act differently if the code is incorrect. Hence, it improves the correctness of the code
 *  in the most efficient manner (only testing one date because it is equivalent to the other)  */

public class EquivalenceTest {
	
	/**Test for checking that when the input is a leap year doomsday, that Jan 10th is no longer
	 * a doomsday and Jan 11th is
	 * @link Dates#dayOfWeek(int, int, int)
	 * @return Testing with three inputs to dayOfWeek(): 
	 * 			(1) Jan 10th 2000
	 * 			(2) June 6th 2000
	 * 			(3) Jan 11th 2000
	 * The test should pass if June 6th (doomsday for both leap and non-leap years) lands on weekday different to 
	 * Jan 10th (no longer a doomsday in a leap year) and if June 6th weekday is the same as Jan 11th on a leap year*/
	
	@Test
	public void testDoomsDaysByMonthLeapEqClass() {
		
		Day dayConstantDoomsday = Dates.dayOfWeek(2000, 6, 6);
		Day dayNoLongerDoomsdayWhenLeap = Dates.dayOfWeek(2000, 1, 10);
		Day dayDoomsdayWhenLeap = Dates.dayOfWeek(2000, 1, 11);
		
		assertNotEquals(dayConstantDoomsday, dayNoLongerDoomsdayWhenLeap);
		assertEquals(dayConstantDoomsday, dayDoomsdayWhenLeap);
		
	}
}
