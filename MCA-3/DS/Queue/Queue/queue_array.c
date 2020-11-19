#include<stdio.h>
#include<conio.h>
int rear = -1,front = -1,val = 0,max = 10;
	int arr[100];
	
void push()
{
	if(rear == max - 1)
	{
		printf("\n\t QUEUE is OVERFLOW....\n");
	}
	else
	{
		if(front > rear)
		{
			front = rear = -1;
		}
		if(front == -1)
		{
			front++;
		}
		rear++;
		//printf("\nvalue of front is %d",front);
		//printf("\nValue of rear is %d",rear);
		printf("\nEnter value to Insert =  ");
		scanf("%d",&val);
		//printf("val = %d",val);
		arr[rear]=val;
		//printf("\narr[rear] = %d",arr[rear]);
	}
}

void pop()
{
	if(front > rear)
	{
		printf("\n\tQUEUE is UNDERFLOW..\n");
	}
	else if(front==-1)
	{
		printf("\n\tQUEUE is UNDERFLOW..\n");
	}
	else if(front==rear)
	{
		printf("\n\tQUEUE is EMPTY..\n");
	}
	else
	{
		val = arr[front];
		printf("\nPOPED Element = %d",arr[front]);
		front++;
	}			
}

void display()
{
	int i = front;
	printf("\n\t\t*** Display Data ***\n\n");
	for(i = front; i <= rear; i++)
	{
		printf("\nElement of %d is  %d",i,arr[i]);
	}

	if(front > rear)
	{
		printf("Queue is empty now: \n");
	}
	if(front < 0)
	{
		printf("Queue is underflow: \n");
	}
	/*while(i <= rear)
	{
		printf("%d\n",arr[i]);
		i++;
	}*/
}
void main()
{
	int choice = -1;

	printf("\n\t\t\t*** Queue using Array ***\n");
	//printf("Enter Max Value :");
	//scanf("%d",&max);

	while(choice != 4)
	{
		printf("\n1. Insert Element..\n2. Delete Element\n3. Display Element\n4.Exit\n");
		printf("\nEnter Your Choice : ");
		scanf("%d",&choice);
		switch(choice)
		{
			case 1 :
				{
					push();
					break;
				}
			case 2 :
				{
					pop();
					break;
				}
			case 3 : 
				{
					display();
					break;
				}
			case 4 :
				{
					exit(0);
					break;
				}
			default :
				{
					printf("\nInvalid Input..\n");
				}
		}
	}
}