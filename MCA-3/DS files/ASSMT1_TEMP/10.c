//create,insert at beg_middle(before and after)_end,count,delete from beg_middle(before and after)_end
#include<stdio.h>
struct list
{
	int num;
	struct list *nxt;
};
struct list* create1()
{
	struct list *tmp;
	tmp=(struct list *)malloc(sizeof(struct list));
	return tmp;
}
void insertbeg(struct list **strt,int n)
{
	struct list *nwnd;
	nwnd=create1();
	nwnd->num=n;
	nwnd->nxt=NULL;
	if(*strt != NULL)
		nwnd->nxt=*strt;
	*strt=nwnd;
	printf("\n First Node inserted Successfully\n");
}
void insertend(struct list **strt,int n)
{
	struct list *nwnd,*tmp;
	nwnd=create1();
	nwnd->num=n;
	nwnd->nxt=NULL;
	if(*strt == NULL)
	{
		*strt=nwnd;
		printf("\n First Node inserted Successfully\n");
	}
	else
	{
		for(tmp=*strt;tmp->nxt!=NULL;tmp=tmp->nxt);
		tmp->nxt=nwnd;
		printf("\n Node inserted at end Successfully \n");
	}
}
void deletebegg(struct list **strt)
{
	struct list *tmp;
	
	if(*strt==NULL)
		printf("\n LinkList is Empty");
	else 
	{
		tmp=*strt;
		if(tmp->nxt==NULL)
		{
			*strt=NULL;
			printf("\n First Node Deleted Successfully\n LinkList is Empty Now\n");
		}
		else
		{
			*strt=tmp->nxt;
			printf("\n First Node Deleted Successfully\n");
		}
		free(tmp);
	}
}
void deleteend(struct list **strt)
{
	struct list *tmp;
	tmp=*strt;
	if(*strt==NULL)
		printf("\n LinkList is Empty");
	else 
	{
		if(tmp->nxt==NULL)
		{
			free(tmp);
			*strt=NULL;
			printf("\n Last Node Deleted Successfully\n LinkList is Empty Now\n");
		}
		else 
		{
			for(tmp=*strt;tmp->nxt->nxt!=NULL;tmp=tmp->nxt);
			free(tmp->nxt);
			tmp->nxt=NULL;
			printf("\n End Node Deleted Successfully");
		}
	}
}

void display4(struct list *strt)
{
	struct list *tmp;
	if(strt==NULL)
		printf("\n LinkList is Empty");
	else
	{
		printf("\n Displaying Data Of LinkList");
		for(tmp=strt;tmp!=NULL;tmp=tmp->nxt)
			printf(" %d ",tmp->num);
	}
}
int srch(struct student *strt,int n)
{
	int flag=0;
	struct list *p;
	
	for(p=strt;p!=NULL;p=p->nxt)
	{
		if(p->num==n)
		{
			flag=1;
			break;
		}
	}
	if(flag==1)
		return 1;
	else
		return 0;
}
void insertbef(struct list **strt)
{
	struct list *tmp;
	struct list *nwnd;
	int n,bef,cnt=0;
	tmp=*strt;
	if(*strt==NULL)
		printf("\n LinkList is Empty");
	else
	{
		printf("\n Enter Number To be Inserted:");
		scanf("%d",&n);
		printf("\n Enter Number Before which u want to Insert Your New Number:");
		scanf("%d",&bef);
		if(srch(*strt,bef)==1)
		{
			//if new node is inserted before first node
			if(tmp->num==bef)
				insertbeg(&(*strt),n);
			else
			{
				nwnd=create1();
				nwnd->num=n;
				for(;tmp->nxt->num!=bef;tmp=tmp->nxt);
				nwnd->nxt=tmp->nxt;
				tmp->nxt=nwnd;
				printf("\n %d Number Inserted in Node Successfully\n",n);
			}
		}
		else
			printf("\n Number %d is not Present in Linklist\nPlz Enter A Present Number.",bef);
	}
}
void insertaf(struct list **strt)
{
	struct list *tmp;
	struct list *nwnd;
	int n,af;
	
	if(*strt==NULL)
		printf("\n LinkList is Empty");
	else
	{
		printf("\n Enter Number To be Inserted:");
		scanf("%d",&n);
		printf("\n Enter Number Before which u want to Insert Your New Number:");
		scanf("%d",&af);
		if(srch(*strt,af)==1)
		{
			for(tmp=*strt;tmp->num!=af;tmp=tmp->nxt);

			if(tmp->nxt==NULL) //if new node is inserted after last node
				insertend(&(*strt),n);
			else
			{
				nwnd=create1();
				nwnd->num=n;
				nwnd->nxt=tmp->nxt;
				tmp->nxt=nwnd;
				printf("\n %d Number Inserted in Node Successfully\n",n);
			}
		}
		else
			printf("\n Number %d is not Present in Linklist\nPlz Enter A Present Number.",af);
	}
}
void deletebef(struct list **strt)
{
	struct list *tmp,*tmp2;
	int bf;
	tmp=*strt;
	if(*strt==NULL)
		printf("\n LinkList is Empty");
	else
	{
		printf("\n Enter Number Before which u want to Delete Node:");
		scanf("%d",&bf);
		if(srch(*strt,bf)==1)
		{
			if(tmp->num==bf)//deletion before first node
				printf("\n There is no node before %d(first) node.\nPlz enter Number which have Before Node\n",bf);
			else if(tmp->nxt->num==bf) //deletion before second node
			{
				*strt=tmp->nxt;
				free(tmp);
				printf("\n Node deleted successfully");
			}
			else
			{
				for(;tmp->nxt->nxt->num!=bf;tmp=tmp->nxt);
				tmp2=tmp->nxt;
				tmp->nxt=tmp->nxt->nxt;
				free(tmp2);
				printf("\n Node deleted successfully");
			}
		}
		else
			printf("\n Number %d is not Present in Linklist\nPlz Enter A Present Number.",bf);
	}
}
void deleteaf(struct list **strt)
{
	struct list *tmp,*tmp2;
	int af;
	tmp=*strt;
	if(*strt==NULL)
		printf("\n LinkList is Empty");
	else
	{
		printf("\n Enter Number After which u want to Delete Node:");
		scanf("%d",&af);
		if(srch(*strt,af)==1)
		{
			if(tmp->num==af && tmp->nxt==NULL)//deletion after first node and no node is present after first node
				printf("\n There is no node after %d(first) node.\nPlz enter Number which have After Node\n",af);
			else if(tmp->num==af) //deletion after first node_deletion of second node.
			{
				tmp2=tmp->nxt;
				tmp->nxt=tmp->nxt->nxt;
				free(tmp2);
				printf("\n Node deleted successfully");
			}
			else
			{
				for(;tmp->num!=af;tmp=tmp->nxt);

				if(tmp->nxt==NULL) //There is no node for deletion after last node.
					printf("\n There is no node after %d(last) node.\nPlz enter Number which have After Node\n",af);

				else //If Middle node's number is given in input then it will go in this else code
				{
					tmp2=tmp->nxt;
					tmp->nxt=tmp->nxt->nxt;
					free(tmp2);
					printf("\n Node deleted successfully");
				}
			}
		}
		else
			printf("\n Number %d is not Present in Linklist\nPlz Enter A Present Number.",af);
	}
}

void cnt(struct list *strt)
{
	struct list *tmp;
	int cnt=0;
	if(strt==NULL)
		printf("\n LinkList is Empty");
	else
	{
		for(tmp=strt;tmp!=NULL;tmp=tmp->nxt,cnt++);
		printf("\n Number of Nodes are %d",cnt);
	}
}

void main10()
{
	struct list *strt=NULL;
	int n,num;
	do
	{
		printf("\n 1.Insert At Beginning");
		printf("\n 2.Insert At End");
		printf("\n 3.Delete From Beginning");
		printf("\n 4.Delete From End");
		printf("\n 5.Insert An Element Before the Given Element By you");
		printf("\n 6.Insert An Element After the Given Element By you");
		printf("\n 7.Delete An Element Before the Given Element By you");
		printf("\n 8.Delete An Element After the Given Element By you");
		printf("\n 9.Count Number of Nodes");
		printf("\n 10.Display");
		printf("\n 0.Exit");
		printf("\n Enter Any Number from Above Menu:");
		scanf("%d",&n);
		switch(n)
		{
			case 1:printf("\n Enter Number:");
				   scanf("%d",&num);
				   insertbeg(&strt,num);
				   break;
			case 2:printf("\n Enter Number:");
				   scanf("%d",&num);
				   insertend(&strt,num);
				   break;
			case 3:deletebegg(&strt);
				   break;
			case 4:deleteend(&strt);
				   break;
			case 5:insertbef(&strt);
				   break;
			case 6:insertaf(&strt);
				   break;
			case 7:deletebef(&strt);
				break;
			case 8:deleteaf(&strt);
				break;
			case 9:cnt(strt);
				break;
			case 10:display4(strt);
				   break;
			case 0:exit(0);
			default:printf("\n Enter a Valid Option");
		}
	}while(1);
}