package is.ru.stringcalculator;


import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

public class CalculatorTest 
{

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }
    @Test
    public void testNewLineNumbers(){
    	assertEquals(6, Calculator.add("1,2\n3"));
    	assertEquals(10, Calculator.add("1\n2\n3,4"));
    }
    @Test
    public void testNegativeInput()
    {
    	    thrown.expect(IllegalArgumentException.class);
   		    thrown.expectMessage("Negative not allowed: -1");
   		    Calculator.add("-1,2\n3");
    }
        @Test
    public void testManyNegativeInput()
    {
    	    thrown.expect(IllegalArgumentException.class);
   		    thrown.expectMessage("Negative not allowed: -1,-5,-10");
   		    Calculator.add("-1,2\n3,-5,-10,5");
    }

}