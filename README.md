# IStack
Data Structure Assignment 5 // Name : Amr Ayman Ibrahim Momtaz // ID : 18011178

Notes:

1) I have implemented both Array Based and Linked List based Stacks in the program

2) The Capacity for the array based stacks is 1000

3) The Junit tests for the array based are the same for the linked list stacks excpect that I removed the stack overflow exception thrown in the array stack form the linked list based stacks(Since the linked list has a lot of capacity which is all the heap)

4) I have provided one user interface that uses the linked lists based stacks and if you want to try it with the Array based stacks you will have to change the class in the user interface only.

5) For the Evaluator application, I used both Linked list based stacks (For the evaluation part) and Array Based stacks (For the conversion between postfix and infix part).

6) It was mentioned in the problem statement that the program shouldn't crash under any circumstances so no expceptions will be thrown in both functions and instead there would be a boolean variable called error that will indicate if there is error occured and the program will handle any error.

7) In the evaluation part if there is more than one element in the stack it will be considered as error because it would be like we enterd 2 numbers without any operation between them ("a b = ?").
