#include<stdio.h>
#include<conio.h>
int top = -1,ch=0,n;
int stack[100];
	
void push()
{
	int val;
	if(top >= n-1)
	{
		printf("STACK IS OVERFLOW..");
	}
	else
	{
		printf("Enter Value :");
		scanf("%d",&val);
		top++;
		stack[top] = val;
	}
}

void pop()
{
	if(top <= -1)
	{
		printf("\nStack is Underflow..");
	}
	else
	{
		printf("poped element = %d",stack[top]);
		top--;
	}
}

void dis()
{
	int i;
	if(top>= 0)
	{
		printf("\nElements in the STACK\n\n");
		for(i = top; i >= 0; i--)
		{
			printf("%d\n",stack[i]);
		}
	}
	else
	{
		printf("Stack is already empty...");
	}
}

void main1()
{
	printf("Enter The Size of stack :");
	scanf("%d",&n);
	while(ch != 4)
	{
		printf("\n1.PUSH\n2.POP\n3.DISPLAY\n4.EXIT\n");
		printf("Enter Your Choice : ");
		scanf("%d",&ch);
		switch(ch)
		{
			case 1 :
				{
					push();
					break;
				}
			case 2 :
				{
					pop();
					break;
				}
			case 3 : 
				{
					dis();
					break;
				}
			case 4 :
				{
					printf("TATA...Exiting...");
					break;
				}
			default :
			    {
			        printf("Enter Valid Choice Between 1 to 4...");
			    }
		}
	}
}