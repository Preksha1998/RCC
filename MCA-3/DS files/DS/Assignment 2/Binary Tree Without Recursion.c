#include<stdio.h>
#include<malloc.h>

struct node
{
	int val;
	struct node *left;
	struct node *right;
};

struct node * create_node()
{
	struct node *node=NULL;
	node=(struct node *)malloc(sizeof(struct node));
	
	printf("\n\nEnter the value to insert: ");
	scanf("%d",&node->val);
	
	node->left=NULL;
	node->right=NULL;

	if(node)
		return node;
	else
		printf("Error, Could not allocate memory.");
}

void insert_data(struct node **head)
{
	struct node *ptr,*mynode;

	if(*head==NULL)
	{
		mynode=create_node();
		*head=mynode;
		printf("\n\nValue %d inserted successfully!",mynode->val);
	}
	else
	{
		ptr=*head;
		mynode=create_node();

		while(ptr!=NULL)
		{
			if(ptr->val<mynode->val)
			{
				if(ptr->right==NULL)
				{
					ptr->right=mynode;
					printf("\n\nValue %d inserted successfully!",mynode->val);
					break;
				}
				else
				{
					ptr=ptr->right;
				}
			}
			else
			{
				if(ptr->left==NULL)
				{
					ptr->left=mynode;
					printf("\n\nValue %d inserted successfully!",mynode->val);
					break;
				}
				else
				{
					ptr=ptr->left;
				}
			}
		}
	}
}

void inorder(struct node *head)
{
	int top=-1;
	struct node *stack[50];
	struct node *cur=head;

	if(head==NULL)
	{
		printf("\nError, Binary Tree is Empty!");
	}
	else
	{
		printf("\nIn-Order: ");
		while(cur!=NULL || top!=-1)
		{
			while(cur!=NULL)
			{
				top++;
				stack[top]=cur;
				cur=cur->left;
			}

			printf(" %d ",stack[top]->val);
			cur=stack[top]->right;
			top--;	
		}
	}
}

void preorder(struct node *head)
{
	int top=-1;
	struct node *stack[50];
	struct node *cur=head;

	printf("\nPre-Order: ");

	while(cur!=NULL)
	{
		printf(" %d ",cur->val);
		if(cur->left)
		{
			top++;
			stack[top]=cur->right;
			cur=cur->left;
		}
		else if(cur->right)
		{
			cur=cur->right;
		}
		else
		{
			if(top==-1)
			{
				break;
			}
			else
			{
				cur=stack[top];
				top--;
			}
		}
	}
}

void postorder1(struct node *head) // Post Order Method 1 (Using Two Stacks)
{
	int st1=-1,st2=-1;
	struct node *s1[50],*s2[50];

	printf("\nPost-Order: ");

	st1++;
	s1[st1]=head;

	while(st1!=-1)
	{
		st2++;
		s2[st2]=s1[st1];
		st1--;
		if(s2[st2]->left)
		{
			st1++;
			s1[st1]=s2[st2]->left;
		}

		if(s2[st2]->right)
		{
			st1++;
			s1[st1]=s2[st2]->right;
		}
	}

	while(st2!=-1)
	{
		printf(" %d ",s2[st2]->val);
		st2--;
	}
}

void postorder2(struct node *head) // Post Order Method 2 (Using Single Stack)
{
	int top=-1;
	struct node *stack[50];
	struct node *cur=head;

	printf("\nPost-Order: ");

	while(1)
	{
		while(cur!=NULL)
		{
			if(cur->right)
			{
				top++;
				stack[top]=cur->right;
				top++;
				stack[top]=cur;
				cur=cur->left;
			}
			else
			{
				top++;
				stack[top]=cur;
				cur=cur->left;
			}
		}

		if(top==-1)
		{
			break;
		}
		else
		{
			cur=stack[top];
			top--;
			
			if(cur->right==stack[top])
			{
				stack[top]=cur;
				cur=cur->right;
			}
			else
			{
				printf(" %d ",cur->val);
				cur=NULL;
			}
		}
	}
}

int findmin(struct node *head)
{
	struct node *ptr=head;

	if(ptr)
	{
		while(ptr->left)
		{
			ptr=ptr->left;
		}
		return ptr->val;
	}
	else
	{
		return 0;
	}
}

int findmax(struct node *head)
{
	struct node *ptr=head;

	if(ptr)
	{
		while(ptr->right)
		{
			ptr=ptr->right;
		}
		return ptr->val;
	}
	else
	{
		return 0;
	}
}

void main()
{	
	struct node *head=NULL;
	int input=-1,val;

	while(input!=7)
	{
		printf("************************* Binary Tree Without Recursion *************************\n\n");
		printf("1. Insert Node");
		printf("\n2. In-Order Display");
		printf("\n3. Post-Order Display");
		printf("\n4. Pre-Order Display");
		printf("\n5. Print Minimum Element");
		printf("\n6. Print Maximum Element");
		printf("\n7. Exit");
		printf("\n\nEnter your choice: ");
		scanf("%d",&input);

		switch(input)
		{
		case 1:
			insert_data(&head);
			break;
		case 2:
			inorder(head);
			break;
		case 3:
			postorder2(head);
			break;
		case 4:
			preorder(head);
			break;
		case 5:
			val=findmin(head);
			if(val)
				printf("\n\nMinimum Element is: %d",val);
			else
				printf("\nTree is Empty.");
			break;
		case 6:
			val=findmax(head);
			if(val)
			printf("\n\nMaximum Element is: %d",val);
			else
				printf("\nTree is Empty.");
			break;
		case 7:
			break;
		default:
			printf("\n\nInvalid Choice, Please try again!");
			break;
		}
		printf("\n\n");
	}
}
