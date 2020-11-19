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

void display(struct mynode *head)
{
	struct mynode *anshead=head,*prev,*curr,*forw;
	prev=NULL;
	curr=anshead;

	while(curr!=NULL)
	{
		forw=curr->next;
		curr->next=prev;
		prev=curr;
		curr=forw;
	}
	anshead=prev;
	head=anshead;

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
					printf("+%dx%d",anshead->coeff,anshead->power);
				}
				else
				{
					printf("%dx%d",anshead->coeff,anshead->power);
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
	struct mynode *poly1=NULL,*poly2=NULL,*crn=NULL,*p,*q,*ans=NULL;

	printf("Enter Highest Power in Polynomial 1: ");
	scanf("%d",&term1);
	printf("\n\nEnter Highest Power in Polynomial 2: ");
	scanf("%d",&term2);

	printf("\n\nPolynomial 1:-\n");
	getdata(&poly1,term1);

	printf("\n\nPolynomial 2:-\n");
	getdata(&poly2,term2);

	p=poly1;
	q=poly2;

	while(p!=NULL && q!=NULL)
	{
		crn=create_node();

		if(p->power==q->power)
		{
			crn->coeff=p->coeff+q->coeff;
			crn->power=p->power;
			crn->next=NULL;
			p=p->next;
			q=q->next;
		}
		else if(p->power>q->power)
		{
			crn->coeff=p->coeff;
			crn->power=p->power;
			crn->next=NULL;
			p=p->next;
		}
		else if(p->power<q->power)
		{
			crn->coeff=q->coeff;
			crn->power=q->power;
			crn->next=NULL;
			q=q->next;
		}

		if(ans==NULL)
		{
			ans=crn;
		}
		else
		{
			insert_node(&ans,crn);
		}
	}

	while(p!=NULL || q!=NULL)
	{
		crn=create_node();

		if(p!=NULL)
		{
			crn->coeff=p->coeff;
			crn->power=p->power;
			crn->next=NULL;
			insert_node(&ans,crn);
			p=p->next;
		}
		
		if(q!=NULL)
		{
			crn->coeff=q->coeff;
			crn->power=q->power;
			crn->next=NULL;
			insert_node(&ans,crn);
			q=q->next;
		}
	}

	printf("\n\nAnswer: ");
	display(ans);
	printf("\n\n");
}

/*

Output:-

Enter Highest Power in Polynomial 1: 2

Enter Highest Power in Polynomial 2: 2

Polynomial 1:-

Enter the Co-Effecient of X^0: -6

Enter the Co-Effecient of X^1: 5

Enter the Co-Effecient of X^2: 3

Polynomial 2:-

Enter the Co-Effecient of X^0: -9

Enter the Co-Effecient of X^1: 0

Enter the Co-Effecient of X^2: 7

Answer: 10x2+5x-15

*/