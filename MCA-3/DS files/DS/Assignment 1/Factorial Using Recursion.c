#include<stdio.h>

int fact(int x)
{
	if(x==1)
	{
		return 1;
	}
	else
	{
		return x*fact(x-1);
	}
}

void main()
{
	int input;

	printf("Enter a number: ");
	scanf("%d",&input);

	printf("\n\nFactorial of %d is: %d",input,fact(input));
	
	printf("\n\n");
}