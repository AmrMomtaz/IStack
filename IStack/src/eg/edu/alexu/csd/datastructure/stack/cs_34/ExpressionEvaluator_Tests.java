package eg.edu.alexu.csd.datastructure.stack.cs_34;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExpressionEvaluator_Tests 
{
	@Test
	void test1() 
	{
		//Evaluator test
		ExpressionEvaluator test = new ExpressionEvaluator();
		String expression = "6 2 / 3 - 4 2 * +";
		assertEquals(8, test.evaluate(expression));
		expression = "3 2 1++";
		assertEquals(6, test.evaluate(expression));
		expression = "2 3 +";
		assertEquals(5, test.evaluate(expression));
		expression = "2 3 4 * +";
		assertEquals(14, test.evaluate(expression));
		expression = "1 2+7*";
		assertEquals(21, test.evaluate(expression));
		expression = "3 3 3 3 * * *";
		assertEquals(81, test.evaluate(expression));
		expression = "2 2 /";
		assertEquals(1, test.evaluate(expression));
		expression = "5 4 1 2 0 * * * *";
		assertEquals(0, test.evaluate(expression));
		expression = "5 5 5 + -";
		assertEquals(-5, test.evaluate(expression));
		expression = "8 8 - 8 +";
		assertEquals(8, test.evaluate(expression));
		expression = "8 5 + 3 *";
		assertEquals(39, test.evaluate(expression));
		expression = "13 2 +";
		assertEquals(15, test.evaluate(expression));
		expression = "0 5 - 3 +";
		assertEquals(-2, test.evaluate(expression));
		expression = "15 0 15 --";
		assertEquals(30, test.evaluate(expression));
		expression = "10000 1+";
		assertEquals(10001, test.evaluate(expression));
	}
	@Test
	void test2()
	{
		//Evaluator tests (error tests)
		ExpressionEvaluator test = new ExpressionEvaluator();
		String expectedMessage;
		String actualMessage;
		
		//Dividing by zero error
		Exception ArithmeticException;
	    expectedMessage = "Error: Can't divide by zero";
	    
	    ArithmeticException = assertThrows(ArithmeticException.class, () -> 
	    {
	    	String expression = "5 0 /";
			test.evaluate(expression);
		});
	    actualMessage = ArithmeticException.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
		
		//Wrong Expression error
	    Exception IllegalArgumentException;
	    expectedMessage = "Error: Wrong expression";
		
	    IllegalArgumentException = assertThrows(IllegalArgumentException.class, () -> 
	    {
			String expression = "2 2 3 + + +";
			test.evaluate(expression);
		});
	    actualMessage = IllegalArgumentException.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	    
		IllegalArgumentException = assertThrows(IllegalArgumentException.class, () -> 
	    {
	    	String expression = "+ +";
			test.evaluate(expression);
		});
	    actualMessage = IllegalArgumentException.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));

	    IllegalArgumentException = assertThrows(IllegalArgumentException.class, () -> 
	    {
	    	String expression = "A";
			test.evaluate(expression);
		});
	    actualMessage = IllegalArgumentException.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));

	    IllegalArgumentException = assertThrows(IllegalArgumentException.class, () -> 
	    {
	    	String expression = "2 2 2";
			test.evaluate(expression);
		});
	    actualMessage = IllegalArgumentException.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));

	    IllegalArgumentException = assertThrows(IllegalArgumentException.class, () -> 
	    {
	    	String expression = "5 5 d";
			test.evaluate(expression);
		});
	    actualMessage = IllegalArgumentException.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));

	    IllegalArgumentException = assertThrows(IllegalArgumentException.class, () -> 
	    {
	    	String expression = "5 + 3 - 3";
			test.evaluate(expression);
		});
	    actualMessage = IllegalArgumentException.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	@Test
	void test3()
	{
		//Convertion between infix and postfix tests
		ExpressionEvaluator test = new ExpressionEvaluator();
		String expression = "3 + 2";
		assertEquals("3 2 +",test.infixToPostfix(expression));
		expression = "5 * 6";
		assertEquals("5 6 *",test.infixToPostfix(expression));
		expression = "13 + 21";
		assertEquals("13 21 +",test.infixToPostfix(expression));
		expression = "563 + 1002 + 339";
		assertEquals("563 1002 + 339 +",test.infixToPostfix(expression));
		expression = "- 5 + 2";
		assertEquals("0 5 - 2 +",test.infixToPostfix(expression));
		expression = "-15 + 3 + 4";
		assertEquals("0 15 - 3 + 4 +",test.infixToPostfix(expression));
		expression = "-17 - 3 + 2";
		assertEquals("0 17 - 3 - 2 +",test.infixToPostfix(expression));
		expression = "32-5";
		assertEquals("32 5 -",test.infixToPostfix(expression));
		expression = "39*5*3*4";
		assertEquals("39 5 * 3 * 4 *",test.infixToPostfix(expression));
		expression = "-5 * 3 +2";
		assertEquals("0 5 - 3 * 2 +",test.infixToPostfix(expression));
		expression = "-3 / 2 - 7";
		assertEquals("0 3 - 2 / 7 -",test.infixToPostfix(expression));
		expression = "5* 2 / 3";
		assertEquals("5 2 * 3 /",test.infixToPostfix(expression));
		expression = "5 + 4 * 3";
		assertEquals("5 4 3 * +",test.infixToPostfix(expression));
		expression = "-1 * 5 + 2 - 3 / 4 + 159";
		assertEquals("0 1 - 5 * 2 + 3 4 / - 159 +",test.infixToPostfix(expression));
		expression = "-17*2 + 10/3";
		assertEquals("0 17 - 2 * 10 3 / +",test.infixToPostfix(expression));
		expression = "5 *( 2 + 3)";
		assertEquals("5 2 3 + *",test.infixToPostfix(expression));
		expression = "( 3 + 2 ) * 5";
		assertEquals("3 2 + 5 *",test.infixToPostfix(expression));
		expression = "( - 5  * 3 + 2 ) - 3";
		assertEquals("0 5 - 3 * 2 + 3 -",test.infixToPostfix(expression));
		expression = "3 * 2 + 5 * ( 10 - 5 + 2 )";
		assertEquals("3 2 * 5 10 5 - 2 + * +",test.infixToPostfix(expression));
		expression = "(5+ 2 ) *( 1 + 3 )";
		assertEquals("5 2 + 1 3 + *",test.infixToPostfix(expression));
		expression = "-5";
		assertEquals("0 5 -",test.infixToPostfix(expression));
		expression = "(5+ 2* ( 2+1 ) ) -5";
		assertEquals("5 2 2 1 + * + 5 -",test.infixToPostfix(expression));
		expression = " -1 * ( 2 * ( 3 + 4 ))";
		assertEquals("0 1 - 2 3 4 + * *",test.infixToPostfix(expression));
		expression = " 5 * - 2";
		assertEquals("5 0 2 - *",test.infixToPostfix(expression));
		expression = "-5 * -2";
		assertEquals("0 5 - 0 2 - *",test.infixToPostfix(expression));
		expression = "(-123+456)*- 986";
		assertEquals("0 123 - 456 + 0 986 - *",test.infixToPostfix(expression));
		expression = "(((3 + 5)))";
		assertEquals("3 5 +",test.infixToPostfix(expression));
		expression = "2 + 3 * 4";
		assertEquals("2 3 4 * +",test.infixToPostfix(expression));
		expression = "a * b + 5";
		assertEquals("a b * 5 +",test.infixToPostfix(expression));
		expression = "(1 + 2) * 7";
		assertEquals("1 2 + 7 *",test.infixToPostfix(expression));
		expression = "a * b / c";
		assertEquals("a b * c /",test.infixToPostfix(expression));
		expression = "(a / (b - c + d)) * (e - a) * c";
		assertEquals("a b c - d + / e a - * c *",test.infixToPostfix(expression));
		expression = "a / b - c + d * e - a * c";
		assertEquals("a b / c - d e * + a c * -",test.infixToPostfix(expression));
		expression = "a * (b + c) * d";
		assertEquals("a b c + * d *",test.infixToPostfix(expression));
	}
	@Test
	void test4()
	{
		//Conversion error tests
		ExpressionEvaluator test = new ExpressionEvaluator();
		String expectedMessage = "Error: Wrong expression";
		String actualMessage;
		Exception IllegalArgumentException;
		
		IllegalArgumentException = assertThrows(IllegalArgumentException.class, () -> 
	    {
	    	String expression = "-";
			test.infixToPostfix(expression);
		});
	    actualMessage = IllegalArgumentException.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	    
	    IllegalArgumentException = assertThrows(IllegalArgumentException.class, () -> 
	    {
	    	String expression = "( 5 + 2 ) )";
			test.infixToPostfix(expression);
		});
	    actualMessage = IllegalArgumentException.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	    
	    IllegalArgumentException = assertThrows(IllegalArgumentException.class, () -> 
	    {
	    	String expression = "((5+2+3)*2";
			test.infixToPostfix(expression);
		});
	    actualMessage = IllegalArgumentException.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	    
	    IllegalArgumentException = assertThrows(IllegalArgumentException.class, () -> 
	    {
	    	String expression = " 5 + 5 +";
			test.infixToPostfix(expression);
		});
	    actualMessage = IllegalArgumentException.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	    
	    IllegalArgumentException = assertThrows(IllegalArgumentException.class, () -> 
	    {
	    	String expression = "123 456";
			test.infixToPostfix(expression);
		});
	    actualMessage = IllegalArgumentException.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	    
	    IllegalArgumentException = assertThrows(IllegalArgumentException.class, () -> 
	    {
	    	String expression = "- - 998";
			test.infixToPostfix(expression);
		});
	    actualMessage = IllegalArgumentException.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	    
	    IllegalArgumentException = assertThrows(IllegalArgumentException.class, () -> 
	    {
	    	String expression = "+ 2 + 3";
			test.infixToPostfix(expression);
		});
	    actualMessage = IllegalArgumentException.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	    
	    IllegalArgumentException = assertThrows(IllegalArgumentException.class, () -> 
	    {
	    	String expression = "+ 6 5";
			test.infixToPostfix(expression);
		});
	    actualMessage = IllegalArgumentException.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	}
}