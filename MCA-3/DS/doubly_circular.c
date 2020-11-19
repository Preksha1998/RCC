#include<stdio.h>
struct list
{
	struct list *prev;
	int num;
	struct list *nxt;
};
void ad_begg(struct list **lst,int n)
{
	struct list *nn;
	nn=(struct list *)malloc(sizeof(struct list));
	nn->num=n;
	if(*lst==NULL)
	{
		*lst=nn;
		nn->prev=nn;
		nn->nxt=nn;
	}
	else
	{
		nn->nxt=(*lst)->nxt;
		nn->prev=(*lst);
		(*lst)->nxt->prev=nn;
		(*lst)->nxt=nn;
	}
}
void ad_endd(struct list **lst,int n)
{
	struct list *nn;
	nn=(struct list *)malloc(sizeof(struct list));
	nn->num=n;
	if(*lst!=NULL)
	{
		nn->prev=*lst;
		nn->nxt=(*lst)->nxt;
		(*lst)->nxt=nn;
		*lst=nn;
		(*lst)->nxt->prev=nn;
	}
	else
	{
		*lst=nn;
		nn->prev=nn;
		nn->nxt=nn;
	}
}

int srch1(struct list *lst,int n)
{
	int flag=0;
	struct list *p;
	
	for(p=lst->nxt;p!=lst;p=p->nxt)
	{
		if(p->num==n)
		{
			flag=1;
			break;
		}
	}
	if(p->num==n) //checking last node value is equal to n
			flag=1;
	if(flag==1)
		return 1;
	else
		return 0;
}


void ad_bf(struct list **lst,int n,int val)
{
	struct list *tmp,*nn;
	if(srch1(*lst,val))
	{
		if((*lst)->nxt->num==val)
			ad_begg(&(*lst),n);
		else
		{
			for(tmp=(*lst)->nxt;tmp->num!=val;tmp=tmp->nxt);
			nn=(struct list *)malloc(sizeof(struct list));
			nn->num=n;
			nn->nxt=tmp;
			nn->prev=tmp->prev;
			tmp->prev->nxt=nn;
			tmp->prev=nn;
		}

	}
	else
		printf("\n Value Before Insertion not found");
}
void ad_af(struct list **lst,int n,int val)
{
	struct list *tmp,*nn;
	if(srch1(*lst,val))
	{
		if((*lst)->num==val)
			ad_endd(&(*lst),n);
		else
		{
			for(tmp=(*lst)->nxt;tmp->num!=val;tmp=tmp->nxt);
			nn=(struct list *)malloc(sizeof(struct list));
			nn->num=n;
			nn->prev=tmp;
			nn->nxt=tmp->nxt;
			tmp->nxt=nn;
			tmp->nxt->prev=nn;
			if(tmp==*lst)
				(*lst)=nn;
		}
	}
	else
		printf("\n Value After Insertion not found");
}
void dl_begg(struct list **lst)
{
	struct list *tmp;
	
	if(*lst==NULL)
		printf("\n LinkList is Empty");
	else 
	{
		tmp=(*lst)->nxt;
		if((*lst)->nxt==*lst)
			*lst=NULL;
		else
		{
			(*lst)->nxt=tmp->nxt;
			tmp->nxt->prev=*lst;
		}
		free(tmp);
	}
}

void dl_end(struct list **lst)
{
	struct list *tmp;
	
	if(*lst==NULL)
		printf("\n LinkList is Empty");
	else 
	{
		tmp=*lst;
		if((*lst)->nxt==*lst)
			*lst=NULL;
		else
		{
			(*lst)->prev->nxt=(*lst)->nxt;
			(*lst)->nxt->prev=(*lst)->prev;
			*lst=(*lst)->prev;
		}
		free(tmp);
	}	

}
void dl_val(struct list **lst,int n)
{
	struct list *tmp;
	
	if(*lst==NULL)
		printf("\n LinkList is Empty");
	else if(srch1(*lst,n))
	{
		tmp=(*lst)->nxt;
		if(tmp->num==n && tmp->prev==tmp) //There is only one node in list.deletion of first/last node
			*lst=NULL;
		else
		{
			for(;tmp->num!=n;tmp=tmp->nxt);
			tmp->prev->nxt=tmp->nxt;
			tmp->nxt->prev=tmp->prev;
			if(tmp==*lst) //deletion of last node
				*lst=(*lst)->prev;
		}
		free(tmp);
	}
	else
		printf("\n Deletion Number is Not Present");
}
void cr(struct list **lst)
{
	struct list *nn;
	int i,n,no;
	printf("\n How Many nodes u want to enter:");
	scanf("%d",&n);

	for(i=0;i<n;i++)
	{
		printf("\n Enter Number:");
		scanf("%d",&no);
		ad_endd(&(*lst),no);
	}
}
void dis(struct list **lst)
{
	struct list *t;
	if(*lst==NULL)
		printf("\n List is Empty");
	else
	{
		for(t=(*lst)->nxt;t!=(*lst);t=t->nxt)
			printf("%d  ",t->num);
		printf("%d  ",t->num);
	}
}

void main()
{
	int ch,n,val;
	struct list *last=NULL;

	while(1)
	{
		printf("\n************************* Doubly Circular Linked List *************************\n\n");
		printf("\n 1.Create List");
		printf("\n 2.Display");
		printf("\n 3.Add At Beginning");
		printf("\n 4.Add to End");
		printf("\n 5.Delete from beginning");
		printf("\n 6.Delete from end");
		printf("\n 7.Add After");
		printf("\n 8.Add Before");
		printf("\n 9.Delete Any Number");
		printf("\n 10.Exit");
		printf("\n Enter Your Choice:");
		scanf("%d",&ch);
		switch(ch)
		{
			case 1:cr(&last);
					break;
			case 2:dis(&last);
					break;
			case 3:printf("\n Enter Number To be Inserted:");
					scanf("%d",&n);
					ad_begg(&last,n);
				    break;
			case 4:printf("\n Enter Number To be Inserted:");
					scanf("%d",&n);
					ad_endd(&last,n);
					break;
			case 5:dl_begg(&last);
				    break;
			case 6:dl_end(&last);
				   break;
			case 7:if(last==NULL)
						printf("\n List is Empty");
					else
					{
						printf("\n After which number you want to insert value:");
						scanf("%d",&val);
						printf("\n Enter Number To be Inserted:");
						scanf("%d",&n);	
						ad_af(&last,n,val);
					}
					break;
			case 8:if(last==NULL)
						printf("\n List is Empty");
					else
					{
						printf("\n Before which number you want to insert value:");
						scanf("%d",&val);
						printf("\n Enter Number To be Inserted:");
						scanf("%d",&n);	
						ad_bf(&last,n,val);
					}
					break;  
			case 9:if(last==NULL)
						printf("\n List is Empty");
					else
					{
						printf("\n Enter Number To be Deleted:");
						scanf("%d",&n);
						dl_val(&last,n);
				    }
				   break;
			case 10:exit(0);
			default:printf("\n Invalid Option");
		}
	}
}

