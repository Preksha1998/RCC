#include<stdio.h>
#include<conio.h>

void display(int arr[],int pos)
{
	int i;

	for(i=pos; i>=0; i--)
	{
		if(arr[i]!=0)
		{
			if(i==0)
			{
				if(arr[i]*1<0)
				printf("%d",arr[i]);
				else
				printf("+%d",arr[i]);
			}
			else if(i==1)
			{
				if(arr[i]*1<0)
				printf("%dx",arr[i]);
				else
				printf("+%dx",arr[i]);
			}
			else
			{
				if(arr[i]*1<0 || i==pos)
				printf("%dx^%d",arr[i],i);
				else
				printf("+%dx^%d",arr[i],i);
			}
		}
	}
}

void main()
{
	int i,j,term1,term2,sum,max;
	int t1[50],t2[50],ans[50];

	printf("******************* Polynomial Multiplication *******************\n");
	printf("\nNote:- Enter 0 wherever missing terms are there.\n\n");
	printf("\nEnter Highest degree of first equation: ");
	scanf("%d",&term1);
	printf("\nEnter Highest degree of second equation: ");
	scanf("%d",&term2);

	for(i=0; i<50; i++)
	{
		t1[i]=0;
		t2[i]=0;
		ans[i]=0;
	}

	max=term1>term2?term1:term2;

	printf("\n\nTerm 1:-\n");
	
	for(i=0; i<=term1; i++)
	{
		printf("\nEnter the Co-Effecient of X^%d: ",i);
		scanf("%d",&t1[i]);
	}

	printf("\n\nTerm 2:-\n");
	
	for(i=0; i<=term2; i++)
	{
		printf("\nEnter the Co-Effecient of X^%d: ",i);
		scanf("%d",&t2[i]);
	}

	for(i=0; i<=term1; i++)
	{
		for(j=0; j<=term2; j++) 
		{
			ans[i+j]+=t1[i]*t2[j];
		}
	}

	printf("\n\nAnswer: ");

	display(ans,term1+term2);

	printf("\n\n");
}

/*

Output:-

******************* Polynomial Multiplication *******************

Note:- Enter 0 wherever missing terms are there.


Enter Highest degree of first equation: 1

Enter Highest degree of second equation: 2


Term 1:-

Enter the Co-Effecient of X^0: -5

Enter the Co-Effecient of X^1: 1


Term 2:-

Enter the Co-Effecient of X^0: -6

Enter the Co-Effecient of X^1: 4

Enter the Co-Effecient of X^2: 1


Answer: 1x^3-1x^2-26x+30

*/