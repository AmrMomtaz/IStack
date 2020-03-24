package eg.edu.alexu.csd.datastructure.stack.cs_34;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LStack_Tests 
{

	@Test
	void test1() 
	{
		LStack stack = new LStack();
		assertEquals(true, stack.isEmpty());
		stack.push(5);
		stack.push(3);
		assertEquals(2,stack.size());
		assertEquals(false, stack.isEmpty());
		assertEquals(stack.peek(), 3);
		assertEquals(2,stack.size());
		assertEquals(stack.pop(), 3);
		assertEquals(1, stack.size());
		assertEquals(stack.pop(), 5);
		assertEquals(true, stack.isEmpty());
	}
	@Test
	void test2() 
	{
		//Empty stack pop test
		LStack stack = new LStack();
		Exception IllegalArgumentException = assertThrows(IllegalArgumentException.class, () -> 
	    {
	    	stack.pop();
	    });
	    String expectedMessage = "The stack is empty";
	    String actualMessage = IllegalArgumentException.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	@Test
	void test3() 
	{
		//Empty stack peek test
		LStack stack = new LStack();
		Exception IllegalArgumentException = assertThrows(IllegalArgumentException.class, () -> 
	    {
	    	stack.peek();
	    });
	    String expectedMessage = "The stack is empty";
	    String actualMessage = IllegalArgumentException.getMessage();
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	@Test
	void test4()
	{
		LStack stack = new LStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		assertEquals(3, stack.size());
		String actual = "";
		while (stack.size()>0)
		{
			actual +=stack.pop();
		}
		assertEquals("321", actual);
	}

}
