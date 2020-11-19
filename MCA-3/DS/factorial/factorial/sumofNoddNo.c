#include<stdio.h>
#include<conio.h>

int sum_odd_no(int n)
{
	if(n == 1)
	{
		return 1;
	}
	else
	{
		return(2 * n - 1 + sum_odd_no(n - 1));//1+3+5+7+9 if n = 5 sum = 25
	}
}

void main()
{
	int n;
	printf("Enter Nth term : ");
	scanf("%d",&n);
	printf("\nSum of Nth Odd Numbers = %d\n",sum_odd_no(n));
}