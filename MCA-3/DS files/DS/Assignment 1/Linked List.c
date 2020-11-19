#include<stdio.h>
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
	
	printf("\n\nEnter the value to insert: ");
	scanf("%d",&node->value);
	
	node->next=NULL;
	if(node)
		return node;
	else
		printf("Error.");
}

void ins_beg(struct mynode **head)
{
	struct mynode *temp;

	temp=create_node();
	temp->next=*head;
	*head=temp;
	printf("\n\nValue %d Inserted Successfully!",temp->value);
}

void ins_end(struct mynode **head)
{
	struct mynode *temp=*head;

	while(temp->next!=NULL)
	{
		temp=temp->next;
	}

	temp->next=create_node();
	printf("\n\nValue %d Inserted Successfully!",temp->next->value);
}

void ins_mid(struct mynode **head)
{
	int pos,i,total=0,val;
	struct mynode *temp,*cur;

	printf("\nEnter position number to insert (starting from 1): ");
	scanf("%d",&pos);

	total=get_count(*head);

	if(*head==NULL || pos<2)
	{
		ins_beg(head);
	}
	else if(pos>total)
	{
		ins_end(head);
	}
	else
	{
		cur=*head;

		for(i=1; i<pos-1; i++)
		{
			cur=cur->next;
		}

		temp=cur->next;
		cur->next=create_node();
		cur=cur->next;
		cur->next=temp;
		printf("\n\nValue inserted successfully.");
	}
}

void del_beg(struct mynode **head)
{
	int val;
	struct mynode *temp=*head;

	if(*head==NULL)
	{
		printf("\n\nLinked List is already empty!");
	}
	else
	{
		*head=temp->next;
		val=temp->value;
		free(temp);
		printf("\n\nValue %d deleted successfully!",val);
	}
}

void del_end(struct mynode **head)
{
	int val;
	struct mynode *cur,*prev;

	if(*head==NULL)
	{
		printf("\n\nLinked List is already empty!");
	}
	else
	{
		cur=prev=*head;

		while(cur->next!=NULL)
		{
			prev=cur;
			cur=cur->next;
		}
		prev->next=NULL;
		val=cur->value;
		free(cur);
		printf("\n\nValue %d deleted successfully!",val);
	}
}

void del_mid(struct mynode **head)
{
	int pos,i,total=0,val;
	struct mynode *temp,*cur;

	total=get_count(*head);

	printf("\nEnter position number to delete (starting from 1): ");
	scanf("%d",&pos);

	if(*head==NULL)
	{
		printf("\n\nLinked List is already empty!");	
	}
	else if(pos<2)
	{
		del_beg(head);
	}
	else if(pos<=total)
	{
		cur=*head;

		for(i=1; i<pos-1; i++)
		{
			cur=cur->next;
		}

		temp=cur->next;
		cur->next=temp->next;
		printf("\n\nValue %d deleted successfully.",temp->value);
		free(temp);
	}
	else
	{
		printf("\n\nInvalid Position, Please Try Again!");
	}
}

int get_count(struct mynode *head)
{
	int count=0;

	if(head==NULL)
	{
		return count;
	}
	else
	{
		while(head)
		{
			count++;
			head=head->next;
		}
		return count;
	}
}

void display(struct mynode *head)
{
	int i=1;

	if(head==NULL)
	{
		printf("\n\nList is empty!");
	}
	else
	{
		printf("\n\n//========================= Displaying Data =========================//\n\n");
		while(head!=NULL)
		{
			printf("\nValue %d: %d",i,head->value);
			i++;
			head=head->next;
		}
		printf("\n\n//==================================================================//");
	}
}

void main()
{
	int input=0,cnt=0;
	struct mynode *head=NULL;

	while(input!=9)
	{
		printf("*******************************************************************\n");
		printf("*************************** Linked List ***************************\n");
		printf("*******************************************************************\n");
		printf("\n1. Insert at Beginning.");
		printf("\n2. Insert at Middle.");
		printf("\n3. Insert at End.");
		printf("\n4. Delete from Beginning.");
		printf("\n5. Delete from Middle.");
		printf("\n6. Delete from End.");
		printf("\n7. Count no of Nodes.");
		printf("\n8. Display Nodes.");
		printf("\n9. Exit.");
		printf("\n\nEnter your choice: ");
		scanf("%d",&input);

		switch(input)
		{
			case 1:
				ins_beg(&head);
				break;
			case 2:
				ins_mid(&head);
				break;
			case 3:
				ins_end(&head);
				break;
			case 4:
				del_beg(&head);
				break;
			case 5:
				del_mid(&head);
				break;
			case 6:
				del_end(&head);
				break;
			case 7:
				cnt=get_count(head);
				printf("\n\nTotal Nodes in Linked List: %d\n",cnt);
				break;
			case 8:
				display(head);
				break;
			case 9:
				break;
		}
		printf("\n\n");
	}
}

/*
Output:-

*******************************************************************
*************************** Linked List ***************************
*******************************************************************

1. Insert at Beginning.
2. Insert at Middle.
3. Insert at End.
4. Delete from Beginning.
5. Delete from Middle.
6. Delete from End.
7. Count no of Nodes.
8. Display Nodes.
9. Exit.

Enter your choice: 8


List is empty!

*******************************************************************
*************************** Linked List ***************************
*******************************************************************

1. Insert at Beginning.
2. Insert at Middle.
3. Insert at End.
4. Delete from Beginning.
5. Delete from Middle.
6. Delete from End.
7. Count no of Nodes.
8. Display Nodes.
9. Exit.

Enter your choice: 1


Enter the value to insert: 28


Value 28 Inserted Successfully!

*******************************************************************
*************************** Linked List ***************************
*******************************************************************

1. Insert at Beginning.
2. Insert at Middle.
3. Insert at End.
4. Delete from Beginning.
5. Delete from Middle.
6. Delete from End.
7. Count no of Nodes.
8. Display Nodes.
9. Exit.

Enter your choice: 3


Enter the value to insert: 87


Value 87 Inserted Successfully!

*******************************************************************
*************************** Linked List ***************************
*******************************************************************

1. Insert at Beginning.
2. Insert at Middle.
3. Insert at End.
4. Delete from Beginning.
5. Delete from Middle.
6. Delete from End.
7. Count no of Nodes.
8. Display Nodes.
9. Exit.

Enter your choice: 8


//========================= Displaying Data =========================//


Value 1: 28
Value 2: 87

//==================================================================//

*/