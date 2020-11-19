#include<stdio.h>
#include<malloc.h>

struct node
{
	int val;
	struct node *next,*prev;
};

struct node * create_node()
{
	struct node *node=NULL;
	node=(struct node *)malloc(sizeof(struct node));
	
	printf("\n\nEnter the value to insert: ");
	scanf("%d",&node->val);
	
	node->prev=node->next=NULL;

	if(node)
		return node;
	else
		printf("Error, Could not allocate memory.");
}

void insbeg(struct node **head)
{
	struct node *nd,*temp;

	if(*head==NULL)
	{
		*head=create_node();
		printf("\n\nNode Inserted Successfully!");
	}
	else
	{
		nd=*head;
		temp=create_node();
		temp->next=nd;
		nd->prev=temp;
		*head=temp;
		printf("\n\nValue %d inserted successfully.",temp->val);
	}
}

void insmid(struct node **head)
{
	int key;
	struct node *nd,*temp;

	if(*head==NULL)
	{
		*head=create_node();
		printf("\n\nNode Inserted Successfully!");
	}
	else
	{
		printf("\n\nEnter a value after which you want to insert: ");
		scanf("%d",&key);

		temp=*head;

		while(temp!=NULL)
		{
			if(temp->val==key)
			{
				break;
			}
			else
			{
				temp=temp->next;
			}
		}

		if(temp==NULL)
		{
			printf("\n\nNo such value found in the linked list, Exiting...");
		}
		else
		{
			if(temp->next!=NULL)
			{
				nd=create_node();
				nd->next=temp->next;
				temp->next->prev=nd;
				nd->prev=temp;
				temp->next=nd;
				printf("\n\n%d value inserted successfully!",nd->val);
			}
			else
			{
				nd=create_node();
				temp->next=nd;
				nd->prev=temp;
				printf("\n\n%d value inserted successfully!",nd->val);
			}
		}
	}
}

void insend(struct node **head)
{
	struct node *nd,*temp;

	if(*head==NULL)
	{
		*head=create_node();
		printf("\n\nNode Inserted Successfully!");
	}
	else
	{
		nd=*head;
		while(nd->next!=NULL)
		{
			nd=nd->next;
		}
		temp=create_node();
		nd->next=temp;
		temp->prev=nd;
		printf("\n\nValue %d inserted successfully.",temp->val);
	}
}

void delbeg(struct node **head)
{
	struct node *temp,*tmp;
	temp=tmp=*head;

	if(temp)
	{
		tmp=tmp->next;
		tmp->prev=NULL;
		*head=tmp;
		printf("\n\n%d Node Deleted Successfully!",temp->val);
		free(temp);
	}
	else
	{
		printf("\n\nNothing to delete, List is already empty!");
	}

}

void delmid(struct node **head)
{
	int key;
	struct node *temp=*head;
	
	if(temp==NULL)
	{
		printf("\n\nNothing to delete, List is already empty!");
	}
	else
	{
		printf("\n\nEnter a value you want to delete: ");
		scanf("%d",&key);
		
		temp=*head;

		while(temp!=NULL)
		{
			if(temp->val==key)
			{
				break;
			}
			else
			{
				temp=temp->next;
			}
		}

		if(temp==NULL)
		{
			printf("\n\nNo such value found in the linked list, Exiting...");
		}
		else
		{
			if(temp->next==NULL)
			{
				if(temp->prev)
				{
					temp->prev->next=NULL;
					printf("\n\n%d node deleted successfully!",temp->val);
					free(temp);
				}
				else
				{
					*head=NULL;
					printf("\n\n%d node deleted successfully!",temp->val);
					free(temp);
				}
			}
			else
			{
				temp->prev->next=temp->next;
				temp->next->prev=temp->prev;
				printf("\n\n%d node deleted successfully!",temp->val);
				free(temp);
			}
		}
	}
}

void delend(struct node **head)
{
	struct node *temp=*head,*slast;
	
	if(*head)
	{
		while(temp->next!=NULL)
		{
			temp=temp->next;
		}

		slast=temp->prev;

		if(slast==NULL)
			*head=NULL;
		else
		slast->next=NULL;

		printf("\n\n%d Node Deleted Successfully!",temp->val);
		free(temp);
	}
	else
	{
		printf("\n\nLinked List is already empty!");
	}
	
}

void forward_traverse(struct node *head)
{
	struct node *tmp=head;

	if(tmp)
	{
		printf("\n\nForward Traversal: ");
		while(tmp!=NULL)
		{
			printf(" %d ",tmp->val);
			tmp=tmp->next;
		}
	}
	else
	{
		printf("\n\nLinked List is Empty.");
	}
}

void backward_traverse(struct node *head)
{
	struct node *tmp=head;

	if(tmp)
	{
		printf("\n\nBackward Traversal: ");
		while(tmp->next!=NULL)
		{
			tmp=tmp->next;
		}

		while(tmp!=NULL)
		{
			printf(" %d ",tmp->val);
			tmp=tmp->prev;
		}
	}
	else
	{
		printf("\n\nLinked List is Empty.");
	}
}

void main()
{	
	struct node *head=NULL;
	int input=-1,val;

	while(input!=9)
	{
		printf("************************* Doubly Linked List *************************\n\n");
		printf("1. Insert at Beginning");
		printf("\n2. Insert at Middle");
		printf("\n3. Insert at End");
		printf("\n4. Delete from Beginning");
		printf("\n5. Delete from Middle");
		printf("\n6. Delete from End");
		printf("\n7. Forward Traversal.");
		printf("\n8. Backward Traversal.");
		printf("\n9. Exit");
		printf("\n\nEnter your choice: ");
		scanf("%d",&input);

		switch(input)
		{
		case 1:
			insbeg(&head);
			break;
		case 2:
			insmid(&head);
			break;
		case 3:
			insend(&head);
			break;
		case 4:
			delbeg(&head);
			break;
		case 5:
			delmid(&head);
			break;
		case 6:
			delend(&head);
			break;
		case 7:
			forward_traverse(head);
			break;
		case 8:
			backward_traverse(head);
			break;
		case 9:
			break;
		default:
			printf("\n\nInvalid Choice, Please try again!");
			break;
		}
		printf("\n\n");
	}
}
