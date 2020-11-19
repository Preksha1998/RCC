#include<stdio.h>
#include<conio.h>
struct tree
{
	int data;
	struct tree *left;
	struct tree *right;
};
void create_node(struct tree **root,int item)
{	
	struct tree *new_node;
	new_node=(struct tree *)malloc(sizeof(struct tree));
	new_node->left=NULL;
	new_node->right=NULL;
	new_node->data=item;
	if((*root)==NULL)
		(*root)=new_node;
	else
	{
		if(item<(*root)->data)
		{
			if((*root)->left==NULL)
			{
				(*root)->left=new_node;
				return;
			}
			create_node(&(*root)->left,item);
		}
		else if(item>(*root)->data)
		{
			if((*root)->right==NULL)
			{
				(*root)->right=new_node;
				return;
			}
			create_node(&(*root)->right,item);
		}
	}
}


int min(struct tree **root)
{
	struct tree *tempp;
	for(tempp=(*root);tempp->left!=NULL;tempp=tempp->left);
		return tempp->data;
}


struct tree* delete_node(struct tree *root,int data) 
{
	struct tree *temp;
	int n;
	if(root==NULL)
		printf("\n Element does not Exists...");
	else if(data>root->data)
		root->right=delete_node(root->right,data);
	else if(data<root->data)
		root->left=delete_node(root->left,data);
 	else
	{
		if(root->left!=NULL && root->right!=NULL)	  		{
			n=min(&root->right);
			root->data=n;
			root->right=delete_node(root->right,root->data);
		}
		else 
		{
			temp=root;
			if(root->left==NULL && root->right==NULL) 
				root=NULL;
			else									 
			{
				if(root->left==NULL)
					root=root->right;
				else if(root->right==NULL)
					root=root->left;
			}
			free(temp);
		}
	}
	return root;
}

int empty(int top)
{
	if(top==-1)
		return 1;
	else
		return 0;
}

void push(struct tree *stk[],struct tree *crnt,int *top)
{
	(*top)++;
	stk[*top]=crnt;
}

struct tree* pop(struct tree *stk[],int *top)
{
	struct tree *tmp;
	tmp=stk[*top];
	(*top)--;
	return tmp;
}

void inorder(struct tree **root)
{
	struct tree *crnt,*stk[100],*tmp;
	int top=-1;
	crnt=(*root);
	if(crnt==NULL)
		printf("\n node is not present in the tree....");
	else
	{
		while(1)
		{
			for(;crnt!=NULL;crnt=crnt->left)
				push(stk,crnt,&top);
			if(empty(top))
				break;
			crnt=pop(stk,&top);
			printf("%d ",crnt->data);
			crnt=crnt->right;
		}
	}
}


void main()
{
	struct tree *root=NULL;
	int n,item,i,ch=0;
	//printf("dffdg");
	while(ch==0)
	{
		printf("\n*** BINARY SEARCH TREE ***\n");
		printf("\n1. Create node :");
		printf("\n2. delete node :");
		printf("\nEnter your Choice :");
		scanf("%d",&ch);

		switch(ch)
		{
		case 1:printf("\n Enter how many node you want to enter:");
				   scanf("%d",&n);

				   for(i=0;i<n;i++)
	               {
					   printf("\nEnter node = ");
						scanf("%d",&item);
						create_node(&root,item);
				   }
				   break;
		
			case 2:printf("\n Enter Number which you want to be Deleted:");
					scanf("%d",&item);
					root=delete_node(root,item);
					break;
			case 3:inorder(&root);
					break;
			case 4: exit(0);
			default:printf("\n Invalid choice..Enter correct choice..");
					break;
		}
	}
}
