package eg.edu.alexu.csd.datastructure.stack.cs_34;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExpressionEvaluator_Tests {

	@Test
	void test1() 
	{
		//Evaluator test
		ExpressionEvaluator test = new ExpressionEvaluator();
		String expression = "6 2 / 3 - 4 2 * +";
		assertEquals(8, test.evaluate(expression));
		assertEquals(false, test.error);
		expression = "321++";
		assertEquals(6, test.evaluate(expression));
		expression = "223+++";
		assertEquals(0, test.evaluate(expression));
		assertEquals(true, test.error);
		test.error = false;
		expression = "2 3 4 * +";
		assertEquals(14, test.evaluate(expression));
		expression = "1 2 + 7 *";
		assertEquals(21, test.evaluate(expression));
		expression = "3333***";
		assertEquals(81, test.evaluate(expression));
		expression = "22/";
		assertEquals(1, test.evaluate(expression));
		expression = "54120****";
		assertEquals(0, test.evaluate(expression));
	}
	@Test
	void test2()
	{
		//Evaluator tests (error tests)
		ExpressionEvaluator test = new ExpressionEvaluator();
		String expression = "223+++";
		assertEquals(0, test.evaluate(expression));
		assertEquals(true, test.error);
		test.error = false;
		expression = "++";
		assertEquals(0, test.evaluate(expression));
		assertEquals(true, test.error);
		test.error = false;
		expression = "A";
		assertEquals(0, test.evaluate(expression));
		assertEquals(true, test.error);
		test.error = false;
		expression = "222";
		assertEquals(0, test.evaluate(expression));
		assertEquals(true, test.error);
		test.error = false;
		expression = "55d";
		assertEquals(0, test.evaluate(expression));
		assertEquals(true, test.error);
		test.error = false;
		expression = "5+5-3";
		assertEquals(0, test.evaluate(expression));
		assertEquals(true, test.error);
		test.error = false;
	}
}
