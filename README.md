# IStack
Data Structure Assignment 5 // Name : Amr Ayman Ibrahim Momtaz // ID : 18011178

Notes:

1) I have implemented both Array Based and Linked List based Stacks in the program

2) The Capacity for the array based stacks is 1000.

3) The Junit tests for the array based are the same for the linked list stacks excpect that I removed the stack overflow exception thrown in the array stack form the linked list based stacks.

4) I have provided one user interface that uses the linked lists based stacks and if you want to try it with the Array based stacks you will have to change the class in the user interface only.

5) For the Evaluator application, I used both Linked list based stacks (For the evaluation part) and Array Based stacks (For the conversion between postfix and infix part).

6) The problem will throw an exception if the user enters a wrong input like dividing by 0 or putting a wrong expression.

7) In the evaluating part, You SHOULD seperate the numbers with spaces to identify the number. For example "1 1 +" is 2 but "11+" will throw an error because it would be 11 + ? ... But if you forgot the spaces between the operators and numbers or operators itself it would be handeled.

8) For the evaulating part the inner variables of the function are float but in the end it would be casted to integer and returned by the function.

9) For the conversion part the function handeles negative numbers using dummy zero, and it supports multi-digit numbers, and for the input the program handles the spaces so you don't have to put them and if you put them it will be okay. (The input isn't restricted with a specific form.)
