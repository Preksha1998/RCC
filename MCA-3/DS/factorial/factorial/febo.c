#include<stdio.h>
#include<conio.h>

int febonacci(int n)
{
	if(n <= 1)
	{
		return n;
	}
	else
	{
		return febonacci(n - 1) + febonacci(n - 2);
	}
}
void main1()
{
	int n,m= 0,i;
	printf("Enter Number of Terms :");
	scanf("%d",&n);
	printf("\nFebonacci Series : \n");
	for(i = 0; i <= n; i++)
	{
		printf("\t%d",febonacci(m));
		m++;
	}
}

