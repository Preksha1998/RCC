#include<stdio.h>
#include<conio.h>

void main()
{
	int i,term1,term2,min,max;
	int t1[50],t2[50],ans[50];

	printf("Enter Highest degree of first equation: ");
	scanf("%d",&term1);
	printf("\nEnter Highest degree of second equation: ");
	scanf("%d",&term2);

	for(i=0; i<50; i++)
	{
		t1[i]=0;
		t2[i]=0;
	}

	max=term1>term2?term1:term2;

	printf("\n\nEnter Equation 1:-\n");
	
	for(i=0; i<=term1; i++)
	{
		printf("\nEnter the Co-Effecient of X^%d: ",i);
		scanf("%d",&t1[i]);
	}

	printf("\n\nEnter Equation 2:-\n");
	
	for(i=0; i<=term2; i++)
	{
		printf("\nEnter the Co-Effecient of X^%d: ",i);
		scanf("%d",&t2[i]);
	}

	for(i=0; i<=max; i++)
	{
		ans[i]=t1[i]+t2[i];		
	}

	printf("\n\nResult is: ");
	
	for(i=max; i>=0; i--)
	{
		if(ans[i]!=0)
		{
			if(i==0)
			{
				if(ans[i]*1<0)
				printf("%d",ans[i]);
				else
				printf("+%d",ans[i]);
			}
			else if(i==1)
			{
				if(ans[i]*1<0)
				printf("%dx",ans[i]);
				else
				printf("+%dx",ans[i]);
			}
			else
			{
				if(ans[i]*1<0 || i==max)
				printf("%dx^%d",ans[i],i);
				else
				printf("+%dx^%d",ans[i],i);
			}
		}
	}
	printf("\n\n");
}

/*

Output:-

Enter Highest degree of first equation: 2

Enter Highest degree of second equation: 2


Enter Equation 1:-

Enter the Co-Effecient of X^0: -4

Enter the Co-Effecient of X^1: 3

Enter the Co-Effecient of X^2: 6


Enter Equation 2:-

Enter the Co-Effecient of X^0: -7

Enter the Co-Effecient of X^1: 0

Enter the Co-Effecient of X^2: 1


Result is: 7x^2+3x-11

*/