#include<stdio.h>
#include<malloc.h>

int max=5;

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
		printf("Error, Memory could not be allocated.");
}

void push(struct mynode **head,int *top)
{
	struct mynode *temp;

	if(*top==max-1)
	{
		printf("\n\nError, Stack Overflow.");
	}
	else
	{
		*top=*top+1;
		temp=create_node();
		temp->next=*head;
		*head=temp;
		printf("\n\nValue %d Pushed Successfully!",temp->value);
	}
}

void pop(struct mynode **head,int *top)
{
	int val;
	struct mynode *temp=*head;

	if(*head==NULL)
	{
		printf("\n\nStack is already empty!");
	}
	else
	{
		*head=temp->next;
		val=temp->value;
		free(temp);
		*top=*top-1;
		printf("\n\nValue %d Popped Successfully!",val);
	}
}

void display(struct mynode **head,int *top)
{
	int i;
	struct mynode *temp=*head;

	if(*head==NULL)
	{
		printf("\n\nStack is Empty.");
	}
	else
	{
		printf("\n\n**************** Displaying Data ****************\n\n");
		for(i=*top; i>=0; i--)
		{
			printf("\nValue %d is: %d",i+1,temp->value);
			temp=temp->next;
		}
	}
}

void main()
{
	int input=0,top=-1;
	struct mynode *head=NULL;


	while(input!=4)
	{
		printf("**************************** Stack Using Linked List ****************************\n\n");
		printf("\n1. Push");
		printf("\n2. Pop");
		printf("\n3. Display");
		printf("\n4. Exit");

		printf("\n\nEnter your choice: ");
		scanf("%d",&input);

		switch(input)
		{
			case 1:
				push(&head,&top);
				break;
			case 2:
				pop(&head,&top);
				break;
			case 3:
				display(&head,&top);
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

**************************** Stack Using Linked List ****************************


1. Push
2. Pop
3. Display
4. Exit

Enter your choice: 3


Stack is Empty.


**************************** Stack Using Linked List ****************************


1. Push
2. Pop
3. Display
4. Exit

Enter your choice: 2


Stack is already empty!


**************************** Stack Using Linked List ****************************


1. Push
2. Pop
3. Display
4. Exit

Enter your choice: 1

Enter the value to insert: 26


Value 26 Pushed Successfully!

*/