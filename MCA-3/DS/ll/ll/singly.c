#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
struct node
{
	int no;
	struct node *next;
};
void insert_beg(struct node **first_temp)
{
	struct node *n,*first;
	first = *first_temp;

	n = (struct node *)malloc(sizeof(struct node));
	printf("Enter value :");
	scanf("%d",&n->no);
	if(first == NULL)
	{
		first = n;
		first->next = NULL;
	}
	else
	{
		n->next = first;
		first = n;
	}
	printf("node is inserted Successfully!");
	return *first_temp = first; 
}

void insert_last(struct node **first_temp, struct node **last_temp)
{
	
}

void display(struct node *first)
{
	//printf("node is inserted Successfully!");
	printf("\nNode = %d",first->no);
}

void main()
{
	struct node *first = NULL, *last = NULL;
	insert_beg(&first);
	insert_last(&first,&last);
	display(first);
}