#include<stdio.h>
#include<malloc.h>

struct mynode
{
	int coeff;
	int power;
	struct mynode *next;
};

struct mynode * create_node()
{
	struct mynode *node=NULL;
	node=(struct mynode *)malloc(sizeof(struct mynode));
	node->next=NULL;
	if(node)
		return node;
	else
		printf("Error.");
}

void insert_node(struct mynode **head,struct mynode *value)
{
	if(*head==NULL)
	{
		*head=value;
	}
	else
	{
		struct mynode *temp=NULL;
		temp=*head;

		while(temp->next!=NULL)
		{
			temp=temp->next;
		}

		temp->next=value;
	}
}

void multiply(struct mynode **poly1,struct mynode **poly2,struct mynode **head)
{
	struct mynode *crn=NULL,*p,*q;

	p=*poly1;
	
	while(p!=NULL)
	{
		q=*poly2;

		while(q!=NULL)
		{
			crn=create_node();
			crn->coeff=p->coeff*q->coeff;
			crn->power=p->power+q->power;
			
			if(*head==NULL)
			{
				crn->next=NULL;
				*head=crn;
			}
			else
			{
				int flag=0;
				struct mynode *temp=*head;
		
				while(temp!=NULL)
				{
					if(temp->power==crn->power)
					{
						temp->coeff+=crn->coeff;
						flag=1;
					}
					temp=temp->next;
				}

				if(flag!=1)
				{
					crn->next=*head;
					*head=crn;
				}
			}
			q=q->next;
		}
		p=p->next;
	}
}

void display(struct mynode *head)
{
	struct mynode *anshead=head;

	while(anshead!=NULL)
	{
		if(anshead->coeff!=0)
		{
			if(anshead->power==0)
			{
				if(anshead->coeff>=0 && anshead!=head)
				{
					printf("+%d",anshead->coeff);
				}
				else
				{
					printf("%d",anshead->coeff);
				}
			}
			else if(anshead->power==1)
			{
				if(anshead->coeff>=0 && anshead!=head)
				{
					printf("+%dx",anshead->coeff);
				}
				else
				{
					printf("%dx",anshead->coeff);
				}
			}
			else
			{
				if(anshead->coeff>=0 && anshead!=head)
				{
					printf("+%dx^%d",anshead->coeff,anshead->power);
				}
				else
				{
					printf("%dx^%d",anshead->coeff,anshead->power);
				}
			}
		}
		anshead=anshead->next;
	}
}

void getdata(struct mynode **head,int terms)
{
	int i;
	struct mynode *crn,*poly1=*head;

	for(i=0; i<=terms; i++)
	{
		if(poly1==NULL)
		{
			poly1=create_node();
			poly1->power=i;
			printf("\nEnter the Co-Effecient of X^%d: ",i);
			scanf("%d",&poly1->coeff);
		}
		else
		{
			crn=create_node();
			printf("\nEnter the Co-Effecient of X^%d: ",i);
			scanf("%d",&crn->coeff);
			crn->power=i;
			insert_node(&poly1,crn);		
		}
	}
	*head=poly1;
}


void main()
{
	int term1,term2;
	struct mynode *poly1=NULL,*poly2=NULL,*ans=NULL;

	printf("Enter Highest Power in Polynomial 1: ");
	scanf("%d",&term1);
	printf("\n\nEnter Highest Power in Polynomial 2: ");
	scanf("%d",&term2);

	printf("\n\nPolynomial 1:-\n");
	getdata(&poly1,term1);

	printf("\n\nPolynomial 2:-\n");
	getdata(&poly2,term2);

	multiply(&poly1,&poly2,&ans);

	printf("\nAnswer: ");
	display(ans);
	printf("\n\n");
}

/*

Output:-

Enter Highest Power in Polynomial 1: 1


Enter Highest Power in Polynomial 2: 3


Polynomial 1:-

Enter the Co-Effecient of X^0: 3

Enter the Co-Effecient of X^1: 1


Polynomial 2:-

Enter the Co-Effecient of X^0: 1

Enter the Co-Effecient of X^1: 1

Enter the Co-Effecient of X^2: -4

Enter the Co-Effecient of X^3: 2

Answer: 2x^4+2x^3-11x^2+4x+3

*/