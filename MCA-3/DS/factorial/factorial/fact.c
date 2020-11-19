#include<stdio.h>
#include<conio.h>

int factorial(int n)
{
	if(n >= 1)
	{
		return n * factorial(n-1);
	}
	else
	{
		return 1;
	}
}

void main2()
{
	int n;
	printf("Enter Number :");
	scanf("%d",&n);
	printf("\nFactorial of %d is %d..\n",n,factorial(n));
}