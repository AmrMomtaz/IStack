package eg.edu.alexu.csd.datastructure.stack.cs_34;

//This is the Linked List implementation for the stack
public class LStack implements IStack
{
	StackNode top;
	int size;
	class StackNode
	{
		Object element;
		StackNode next;
		public Object get_element()
		{
			return element;
		}
		public StackNode get_next()
		{
			return next;
		}
		public void set_next(StackNode n)
		{
			this.next = n;
		}
		public void set_element (Object e)
		{
			this.element = e;
		}
	}
	LStack()
	{
		top = null;
		size = 0;
	}
	@Override
	public Object pop() 
	{
		if (isEmpty())throw new IllegalArgumentException("The stack is empty");
		Object element = top.get_element();
		top.set_element(null);
		top = top.get_next();
		size--;
		return element;
	}

	@Override
	public Object peek()
	{
		if (isEmpty())throw new IllegalArgumentException("The stack is empty");
		Object element = top.get_element();
		return element;
	}

	@Override
	public void push(Object element) 
	{
		StackNode new_node = new StackNode();
		new_node.set_element(element);
		new_node.set_next(top);
		top = new_node;
		size++;
	}

	@Override
	public boolean isEmpty() 
	{
		return (size==0);
	}

	@Override
	public int size() 
	{
		return size;
	}

}
