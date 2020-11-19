#include<stdio.h>
#include<malloc.h>

struct node
{
	struct node *left;
	int val;
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
	printf("\n\n\n");
}

void inorder(struct node *head)
{
	if(head==NULL)
	{
		return;
	}
	
	inorder(head->left);
	printf(" %d ",head->val);
	inorder(head->right);
}

void preorder(struct node *head)
{
	if(head==NULL)
	{
		return;
	}
	printf(" %d ",head->val);
	preorder(head->left);
	preorder(head->right);
}

void postorder(struct node *head)
{
	if(head==NULL)
	{
		return;
	}
	postorder(head->left);
	postorder(head->right);
	printf(" %d ",head->val);
}

void main()
{
	int input=0;
	struct node *head=NULL;

	while(input!=5)
	{
		printf("***************** Binary Search Tree *****************\n\n");
		printf("\n1. Insert Node");
		printf("\n2. Pre-Order Traversal");
		printf("\n3. In-Order Traversal");
		printf("\n4. Post-Order Traversal");
		printf("\n5. Exit");
		printf("\n\nEnter your choice: ");
		scanf("%d",&input);

		switch(input)
		{
			case 1:
					insert_data(&head);
				break;
			case 2:
				printf("\n\nPre-Order: ");
				preorder(head);
				printf("\n\n");
				break;
			case 3:
				printf("\n\nIn-Order: ");
				inorder(head);
				printf("\n\n");
				break;
			case 4: 
				printf("\n\nPost-Order: ");
				postorder(head);
				printf("\n\n");
				break;
			case 5:
				break;
			default:
				printf("\n\nError, Invalid choice.\n\n\n");
				break;
		}
	}

	printf("\n\n");
}