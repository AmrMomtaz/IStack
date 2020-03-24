package eg.edu.alexu.csd.datastructure.stack.cs_34;

import java.util.Scanner;

public class UI_Stacks 
{

	public static void main(String[] args)
	{
		LStack stack = new LStack();
		Scanner input = new Scanner (System.in);
		while(true)
		{
			System.out.println("Please Select one of the operations:\n"
					+ "\n1.Push\n2.Pop\n3.Peek\n4.Get Size\n5.Check if empty");
			char in = input.next().charAt(0);
			switch(in)
			{
			case '1':
				System.out.println("Enter the element:");
				Object element = input.next();
				stack.push(element);
				break;
			case '2':
				element = stack.pop();
				System.out.println("The element is :");
				System.out.println(element);
				break;
			case '3':
				element = stack.peek();
				System.out.println("The element is :");
				System.out.println(element);
				break;
			case '4':
				System.out.println("The size = " +stack.size());
				break;
			case '5':
				System.out.println("Empty = " + stack.isEmpty());
				break;
				default :
					System.out.println("Wrong Input");
					break;
			}
			System.out.println("\n-----------------------\n");
		}
	}

}
