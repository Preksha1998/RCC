#include<stdio.h>

void main()
{
	int input=0,front,rear,max=5,arr[5],i;
	front=rear=-1;
	
	for(i=0; i<5; i++)
	{
		arr[i]=-1;
	}

	while(input!=4)
	{
		printf("**************************** Queue Using Linked List ****************************\n\n");
		printf("\n1. Enqueue");
		printf("\n2. Dequeue");
		printf("\n3. Display");
		printf("\n4. Exit");

		printf("\n\nEnter your choice: ");
		scanf("%d",&input);

		switch(input)
		{
			case 1:
				
				if((front==0 && rear==max-1) || rear==front-1)
				{
					printf("\n\nError, Queue Overflow.");
				}
				else if(front==-1 && rear==-1)
				{
					front=rear=0;
					printf("\n\nEnter a value: ");
					scanf("%d",&arr[rear]);
					printf("\n\n%d inserted successfully.",arr[rear]);
				}
				else if(front!=0 && rear==max-1)
				{
					rear=0;
					printf("\n\nEnter a value: ");
					scanf("%d",&arr[rear]);
					printf("\n\n%d inserted successfully.",arr[rear]);
				}
				else
				{
					rear++;
					printf("\n\nEnter a value: ");
					scanf("%d",&arr[rear]);
					printf("\n\n%d inserted successfully.",arr[rear]);
				}
				break;
			case 2:
				if(front==-1 && rear==-1)
				{
					printf("\n\nError, Queue Underflow.");
				}
				else if(front==rear)
				{
					printf("Value %d deleted successfully.",arr[front]);
					arr[front]=-1;
					front=rear=-1;
				}
				else if(front==max-1)
				{
					printf("Value %d deleted successfully.",arr[front]);
					arr[front]=-1;
					front=0;
				}
				else
				{
					printf("Value %d deleted successfully.",arr[front]);
					arr[front]=-1;
					front++;
				}
				break;
			case 3:
				if(front!=-1 && rear!=-1)
				{
					printf("\n\n**************** Displaying Data ****************");
					for(i=0; i<5; i++)
					{
						printf("\nValue %d is: %d",i+1,arr[i]);
					}
					printf("\n\n*************************************************\n\n");
				}
				else
				{
					printf("\n\nError, Queue is empty.");
				}
				break;
			case 4:
				break;
			default:
				printf("\n\nInvalid choice, Please try again!");
				break;
		}
		printf("\n\n\n");
	}
}

/*
Output:-

**************************** Queue Using Linked List ****************************

1. Enqueue
2. Dequeue
3. Display
4. Exit

Enter your choice: 1

Enter a value: 26

26 inserted successfully.


**************************** Queue Using Linked List ****************************


1. Enqueue
2. Dequeue
3. Display
4. Exit

Enter your choice: 3

**************** Displaying Data ****************
Value 1 is: 26
Value 2 is: -1
Value 3 is: -1
Value 4 is: -1
Value 5 is: -1

**************************** Queue Using Linked List ****************************


1. Enqueue
2. Dequeue
3. Display
4. Exit

Enter your choice: 2
Value 26 deleted successfully.

*/