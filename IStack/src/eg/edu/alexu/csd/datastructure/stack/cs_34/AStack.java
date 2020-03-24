package eg.edu.alexu.csd.datastructure.stack.cs_34;

//This is the Array Based implementation for the stack
public class AStack implements IStack
{
	final static int CAPACITY = 1000;
	Object stack [];
	int top;
	
	AStack()
	{
		top = -1;
		stack = new Object [CAPACITY];
	}
	
	@Override
	public Object pop() 
	{
		if (isEmpty())throw new IllegalArgumentException("The stack is empty");
		Object element = stack[top];
		stack[top]=null;
		top--;
		return element;
	}

	@Override
	public Object peek() 
	{
		if (isEmpty())throw new IllegalArgumentException("The stack is empty");
		Object element = stack[top];
		return element;
	}

	@Override
	public void push(Object element) 
	{
		if(size()>=CAPACITY)throw new IllegalArgumentException("Stack Overflow");
		stack[top+1]=element;
		top++;
	}

	@Override
	public boolean isEmpty() 
	{
		return (size() ==0);
	}

	@Override
	public int size()
	{
		return top+1;
	}

}
