#include<stdio.h>
#include<malloc.h>

void main()
{
	int input=-1,front,rear,max,val,i;
	int arr[10];

	front=-1;
	rear=-1;
	max=10;

	while(input!=4)
	{
		printf("\n\n// Queue Using Array //\n");
		printf("\n1. Insert");
		printf("\n2. Delete");
		printf("\n3. Display");
		printf("\n4. Exit");
		printf("\n\nEnter your choice: ");
		scanf("%d",&input);

		switch(input)
		{
			case 1:
				
				if(rear==max-1)
				{
					printf("\n\nError, Queue Overflow");
				}
				else
				{
					if(front==-1)
						front++;

					rear++;
					printf("\nValue of rear: %d",rear);
					printf("\n\nEnter value to insert: ");
					scanf("%d",&val);
					arr[rear]=val;
				}
				break;
			case 2:
				if(front==-1)
				{
					printf("\n\nQueue Underflow\n");
				}
				else if(front==rear)
				{
					front=rear=-1;
				}
				else
				{
					front++;
				}
				
				break;
			case 3:
				printf("\n\n***************** Displaying Data ********************\n\n");
				for(i=front; i<=rear; i++)
				{
					printf("\n%d",arr[i]);
				}
				printf("\n\n*****************************************************\n\n");
				break;
		}
	}
	printf("\n\n");
}

/*

Output:-

// Queue Using Array //

1. Insert
2. Delete
3. Display
4. Exit

Enter your choice: 1

Enter value to insert: 96

// Queue Using Array //

1. Insert
2. Delete
3. Display
4. Exit

Enter your choice: 3

***************** Displaying Data ********************

96

*****************************************************

// Queue Using Array //

1. Insert
2. Delete
3. Display
4. Exit

Enter your choice: 1

Enter value to insert: 87

// Queue Using Array //

1. Insert
2. Delete
3. Display
4. Exit

Enter your choice: 3

***************** Displaying Data ********************

96
87

*****************************************************

*/