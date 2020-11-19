#include<stdio.h>

int max=5,stack[5],top=-1;

void push()
{
	if(top==max-1)
	{
		printf("\n\nError, Stack Overflow.");
	}
	else
	{
		top++;
		printf("\n\nEnter a value to push: ");
		scanf("%d",&stack[top]);
		printf("\n\nValue %d Pushed Successfully.",stack[top]);
	}
}

void pop()
{
	if(top==-1)
	{
		printf("\n\nError, Stack Underflow.");
	}
	else
	{
		printf("\n\n%d value popped successfully!",stack[top]);
		top--;	
	}
}

void display()
{
	int i;

	if(top==-1)
	{
		printf("\n\nStack is empty!");
	}
	else
	{
		printf("\n\n************** Displaying Stack **************\n");

		for(i=top; i>=0; i--)
		{
			printf("\nValue %d is: %d",i+1,stack[i]);
		}
	}
}

void main()
{
	int input=0;

	while(input!=4)
	{
		printf("**************************** Stack Using Array ****************************\n\n");
		printf("\n1. Push");
		printf("\n2. Pop");
		printf("\n3. Display");
		printf("\n4. Exit");

		printf("\n\nEnter your choice: ");
		scanf("%d",&input);

		switch(input)
		{
			case 1:
				push();
				break;
			case 2:
				pop();
				break;
			case 3:
				display();
				break;
			case 4: 
				break;
			default:
				printf("\n\nInvalid choice, Please try again.");
		}
		printf("\n\n\n");
	}
}


/*

Output:-

**************************** Stack Using Array ****************************

1. Push
2. Pop
3. Display
4. Exit

Enter your choice: 3

Stack is empty!

**************************** Stack Using Array ****************************

1. Push
2. Pop
3. Display
4. Exit

Enter your choice: 1

Enter a value to push: 87

Value 87 Pushed Successfully.

**************************** Stack Using Array ****************************

1. Push
2. Pop
3. Display
4. Exit

Enter your choice: 1

Enter a value to push: 47

Value 47 Pushed Successfully.

**************************** Stack Using Array ****************************

1. Push
2. Pop
3. Display
4. Exit

Enter your choice: 3

************** Displaying Stack **************

Value 2 is: 47
Value 1 is: 87

**************************** Stack Using Array ****************************

1. Push
2. Pop
3. Display
4. Exit

Enter your choice: 2

47 value popped successfully!

*/