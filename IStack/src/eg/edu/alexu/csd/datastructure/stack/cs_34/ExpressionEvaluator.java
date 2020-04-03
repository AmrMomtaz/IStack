package eg.edu.alexu.csd.datastructure.stack.cs_34;

public class ExpressionEvaluator implements IExpressionEvaluator
{	
	int index = 0;
	private void skip_spaces(String expression)
	{
		while (index <expression.length() && 
				(expression.charAt(index)==' '||expression.charAt(index)=='\t'))
		{
			index++;
		}
	}
	private String get_next_number(String expression)
	{
		//This function gets the next number with all its digits
		String number = "";
		while (index <expression.length() - 1 && Character.isDigit(expression.charAt(index+1)))
		{
			number += expression.charAt(index+1);
			index++;
		}
		return number;
	}
	public String parenthesis (String expression,AStack stack,boolean number_assigned,Boolean dummy)
	{
		// This fuction deals with paranthese as if they were a number and evaluate it
		//using recusrive call of the main function
		String substring="";
		String Result="";
		int count = 0;
		index++;
		try
		{
			while (!(expression.charAt(index)==')' &&count == 0))
			{
				if(expression.charAt(index)=='(')count++;
				else if(expression.charAt(index)==')')count--;
				substring += expression.charAt(index);
				index++;
			}
			Result = new ExpressionEvaluator().infixToPostfix(substring);
		}
		catch(Exception e)
		{
			throw new IllegalArgumentException("Error: Wrong expression");
		}
		return Result;
	}
	@Override
	public String infixToPostfix(String expression) 
	{
		AStack stack = new AStack();
		String Result = "";
		expression = expression.strip();
		boolean number_assigned =false; boolean dummy = true;
		for (index = 0 ; index < expression.length() ; index++)
		{
			char ch = expression.charAt(index);
			if (ch == ' '|| ch =='\t')continue;
			else if (dummy && ch == '-')
			{
				index ++;
				Result += "0 ";
				try
				{
					if (expression.charAt(index)==' ')skip_spaces(expression);
					String number = expression.charAt(index) +get_next_number(expression);
					Result += number + " - ";
					if (number_assigned)
					{
						char op = (char) stack.pop();
						Result += "" + op + ' ';
					}
				}
				catch (Exception e)
				{
					throw new IllegalArgumentException("Error: Wrong expression");
				}
				dummy = false;
				number_assigned = true;
			}
			else if (Character.isDigit(ch) || ch == '(' || Character.isAlphabetic(ch))
			{
				String number;
				if (ch == '(')
				{
					number = parenthesis(expression, stack,	number_assigned, dummy);
				}else if (Character.isDigit(ch))
				{
					number = ch + get_next_number(expression);
				}
				else
				{
					number = ""+ch;
				}
				if (!number_assigned)
				{
					number_assigned = true;
					dummy = false;
					Result+= number + ' ';
				}
				else 
				{
					try 
					{
						char operator = (char)stack.pop();
						if ((operator == '+' || operator == '-')&& index < expression.length()-1)
						{
							index++;
							if (expression.charAt(index)==' ')skip_spaces(expression);
							char next_operator = expression.charAt(index);
							if (next_operator == '*' ||next_operator == '/')
							{
								index++;
								if (expression.charAt(index)==' ')skip_spaces(expression);
								String next_number= "";
								if (expression.charAt(index)=='(')
								{
									next_number = this.parenthesis(expression, stack, number_assigned, dummy);
								}
								else if (Character.isDigit(expression.charAt(index)))
								{
									next_number+=expression.charAt(index) + get_next_number(expression);
								}
								else if (Character.isAlphabetic(expression.charAt(index)))
								{
									next_number = "" + expression.charAt(index);
								}
								Result += number + ' ' + next_number + ' ' + next_operator
										+ ' ' + operator + ' ' ;
								dummy = false;
								continue;
							}
							else if(next_operator == '+' || next_operator =='-')
							{
								stack.push(next_operator);
							}
							else throw new IllegalArgumentException("Error: Wrong expression");
						}
						Result+= number + ' ' + operator + ' ';
						dummy = false;
					}
					catch(Exception e)
					{
						throw new IllegalArgumentException("Error: Wrong expression");
					}
				}
			}
			else if ((ch == '+'|| ch == '-'|| ch == '*'|| ch == '/') && number_assigned)
			{
				if (ch == '*'|| ch == '/')dummy =true;
				stack.push(ch);
			}
			else throw new IllegalArgumentException("Error: Wrong expression");
		}
		if (stack.size()!=0) throw new IllegalArgumentException("Error: Wrong expression");
		return Result.strip();
	}


	@Override
	public int evaluate(String expression) 
	{
		LStack stack = new LStack();
		float number=0; boolean number_assigned = false;
		expression = expression.strip();
		for (index = 0 ; index < expression.length() ; index++)
		{
			char ch = expression.charAt(index);
			if ((ch == ' '|| ch =='\t')&&!number_assigned) continue;
			else if ((ch == ' '|| ch =='\t')&&number_assigned)
			{
				stack.push(number);
				number =0;
				number_assigned = false;
			}
			else if (Character.isDigit(ch))
			{
				number*=10;
				number +=(float)Character.getNumericValue(ch);
				number_assigned = true;
			}
			else if (ch == '+'|| ch == '-'|| ch == '*'|| ch == '/')
			{
				if (number_assigned)
				{
					number_assigned = false;
					stack.push(number);
					number =0;
				}
				if (stack.size()<2) throw new IllegalArgumentException("Error: Wrong expression");
				float a = (float)(stack.pop());
				float b = (float)(stack.pop());
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
					if (a == 0)throw new ArithmeticException("Error: Can't divide by zero");
					stack.push(b/a);
				}
			}
			else throw new IllegalArgumentException("Error: Wrong expression");
		}
		if (stack.size()!=1) throw new IllegalArgumentException("Error: Wrong expression");
		int Result = (int)((float)stack.pop());
		return Result;
	}
}
