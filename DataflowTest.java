package dates.test;

import dates.Dates;
import static org.junit.Assert.fail;
import org.junit.Test;

/**DataflowTest class
 * @author yshe735
 * Single test that tests the du path for boolean valid
 * The du-path is as follows: 
 * 	def: line 58, use(predicate): line 74
 * 	path (line numbers): (58, 59, 61, 63, 65, 66, 74)
 * This is the case when it is a leap year and is a correct date in February. 
 * Justification:
 * It is not covered in BranchTests because the test for a normal date is not in february, so does not
 * check the condition on line 65. The statement 65 is reached in BranchTests with an invalid date in February
 * (Feb 30th) and which subsequently covers lines 66, 67. Hence, 100% branch coverage is reached, but not with this
 * particular branch. 
 * Because this path has not been reached by both BranchTests and EquivalenceTest, this DataflowTest can ensure
 * that when the input is a valid date specifically in February, that valid remains true.
 * This improves the quality of the test class because even though when branch, conditional and equivalence classes 
 * are covered, some paths (such as this) are still not tested (because I have designed tests that are of its simplest form
 * i.e. a valid day not in February is equivalent to a valid day in February) and can cause potential faults. 
 * Specifically, the testing of the boolean variable valid is important because it can cause early termination 
 * of the program if the path of a valid date is correct.  */

public class DataflowTest {
	
	/**Test for du path (58, 59, 61, 63, 65, 66, 74) for the variable Boolean valid
	 * @link Dates#dayOfWeek(int, int, int)
	 * @return the test should pass if valid remains true through all the statements
	 * This means the test will fail if an Illegal Argument Exception is thrown */
	@Test 
	public void testDUPathBoolValid() {
		try{
			Dates.dayOfWeek(2000, 2, 29);
		   }
		   catch(Exception e){
		      fail("Should not have thrown any exception as it is a valid date in February for a leap");
		   }
	}
	
	

}
