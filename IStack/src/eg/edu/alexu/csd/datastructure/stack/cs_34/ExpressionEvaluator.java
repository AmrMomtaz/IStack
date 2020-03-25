package eg.edu.alexu.csd.datastructure.stack.cs_34;

public class ExpressionEvaluator implements IExpressionEvaluator
{
	public boolean error = false;
	
	@Override
	public String infixToPostfix(String expression) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int evaluate(String expression) 
	{
		LStack stack = new LStack();
		for (int i = 0 ; i < expression.length() ; i++)
		{
			char ch = expression.charAt(i);
			if (ch == ' ')continue;
			else if (Character.isDigit(ch))
			{
				stack.push(Character.getNumericValue(ch));
			}
			else if (ch == '+'|| ch == '-'|| ch == '*'|| ch == '/')
			{
				if (stack.size()<2)
				{
					error = true;
					return 0;
				}
				int a = (int)stack.pop();
				int b = (int)stack.pop();
				if (ch == '+')
				{
					stack.push(b+a);
				}else if (ch == '-')
				{
					stack.push(b-a);
				}else if (ch == '*')
				{
					stack.push(b*a);
				}else if (ch == '/')
				{
					stack.push(b/a);
				}
			}
			else 
			{
				error = true;
				return 0;
			}
		}
		if (stack.size()!=1)
		{
			error = true;
			return 0;
		}
		int Result = (int)stack.pop();
		return Result;
	}

}
