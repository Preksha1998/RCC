#include<stdio.h>
#include<stdlib.h>

int prec(char c)
{
	if(c=='/' || c=='*')
	{
		return 2;
	}
	else if(c=='+' || c=='-')
	{
		return 1;
	}
	else
	{
		return 0;
	}
}

void main()
{
	int i=0,top=0;
	char str[50],stack[50];

	printf("Enter Infix Equation: ");
	scanf("%s",str);

	printf("\n\nPostfix is: ");
	while(str[i])
	{
		if((str[i]>='A' && str[i]<='Z') || (str[i]>='a' && str[i]<='z'))
		{
			printf("%c",str[i]);
		}
		else if(str[i]=='(' || str[i]=='[' || str[i]=='{')
		{
			top++;
			stack[top]=str[i];
		}
		else if(str[i]==')' || str[i]==']' || str[i]=='}')
		{
			switch(str[i])
			{
				case ')':
					while(stack[top]!='(')
					{
						printf("%c",stack[top]);
						top--;
					}
					top--;
					break;
				case ']':
					while(stack[top]!=']')
					{
						printf("%c",stack[top]);
						top--;
					}
					top--;
					break;
				case '}':
					while(stack[top]!='}')
					{
						printf("%c",stack[top]);
						top--;
					}
					top--;
					break;
			}
		}
		else if(str[i]=='+' || str[i]=='-' || str[i]=='*' || str[i]=='/')
		{
			while(prec(str[i])<=prec(stack[top]))
			{
				printf("%c",stack[top]);
				top--;
			}
			top++;
			stack[top]=str[i];			
		}
		else
		{
			printf("\n\nReason: %d",str[i]);
			printf("\n\nError, Invalid Character Found, Exiting...");
			exit(0);
		}
		i++;
	}

	// Print Left out elements in stack.
	while(top!=0)
	{
		printf("%c",stack[top]);
		top--;
	}
	printf("\n\n");
}

/*

Output:-

Enter Infix Equation: (A+((B+C)+(D+E)*F)/G)

Postfix is: ABC+DE+F*+G/+

*/