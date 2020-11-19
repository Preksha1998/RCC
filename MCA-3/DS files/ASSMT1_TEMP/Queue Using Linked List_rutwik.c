#include<stdio.h>
#include<stdlib.h>
#include<malloc.h>

struct mynode
{
	int value;
	struct mynode *next;
};

struct mynode * create_node()
{
	struct mynode *node=NULL;

	node=(struct mynode *)malloc(sizeof(struct mynode));

	printf("\nEnter the value to insert: ");
	scanf("%d",&node->value);

	node->next=NULL;

	if(node)
		return node;
	else
		printf("Error.");
}

void enqueue(struct mynode **front,struct mynode **rear)
{
	if(*front==NULL && *rear==NULL)
	{
		*front=*rear=create_node();
		printf("\n\nValue inserted successfully.");
	}
	else
	{
		struct mynode *temp=*rear;
		temp->next=create_node();
		temp=temp->next;
		*rear=temp;
		printf("\n\nValue %d inserted successfully.",temp->value);
	}
}

void dequeue(struct mynode **front,struct mynode **rear)
{
	if(*front==NULL)
	{
		printf("\n\nQueue Underflow, No nodes to delete!");
	}
	else if(*front==*rear)
	{
		struct mynode *temp=*front;
		printf("\n\nValue %d deleted successfully!",temp->value);
		*front=*rear=NULL;
	}
	else
	{
		struct mynode *temp=*front;
		*front=temp->next;
		printf("\n\nValue %d deleted successfully!",temp->value);
		free(temp);
	}
}

void display(struct mynode *front)
{
	int i=1;

	if(front==NULL)
	{
		printf("\n\nQueue is empty!");
	}
	else
	{
		printf("\n\n//================ Displaying Data ================//\n\n");
		while(front!=NULL)
		{
			printf("\nValue %d: %d",i,front->value);
			i++;
			front=front->next;
		}
		printf("\n\n//=================================================//\n\n");
	}
}


void main()
{
	int input=0;
	struct mynode *front=NULL,*rear=NULL;
	
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
				enqueue(&front,&rear);
				break;
			case 2:
				dequeue(&front,&rear);
				break;
			case 3:
				display(front);
				break;
			case 4:
				exit(0);
				break;
			default:
				printf("\n\nInvalid choice, Please try again!");
				break;
		}
		printf("\n\n\n");
	}
}