package eg.edu.alexu.csd.datastructure.stack.cs_34;

import java.util.Scanner;

public class ExpressionEvaluator_UI
{

	public static void main(String[] args) 
	{
		ExpressionEvaluator pr = new ExpressionEvaluator();
		Scanner input = new Scanner(System.in);
		while (true)
		{
			System.out.println("Please enter the operation you would like:"
					+ "\n1.Evaluate a postfix expression"
					+ "\n2.Convert Infix to Postfix");
			char in = input.next().charAt(0);
			System.out.println("\nEnter the expression:");
			input.nextLine();
			String expression = input.nextLine();
			switch(in)
			{
			case '1' :
				System.out.println("The result = " + pr.evaluate(expression));
				break;
			case '2' :
				System.out.println("The result = "+ pr.infixToPostfix(expression));
				break;
				default :
					System.out.println("Wrong Input");
					break;
			}
			System.out.println("\n---------------------\n");
		}
	}

}
