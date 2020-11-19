#include<stdio.h>
#include <string.h>
int stack[10],top=-1;
char exp[100];

int push()
{
    int flag = 0;
    if(top==9)
    {
        printf("\nStack is Overflow..");
        
    }
    else
    {  
       char str[10];
       int valid;
        printf("\n Enter a single symbol from ( + - * / ): ");
        scanf("%s", str);
       
        if(strcmp(str,"(") == 0)
        {
            valid = 1;
        } 
        else if(strcmp(str,"+") == 0)
        {
            valid = 2;
        }
        else if(strcmp(str,"-") == 0)
        {
            valid = 2;
        }
        else if(strcmp(str,"*") == 0)
        {
            valid = 3;
        }
        else if(strcmp(str,"/") == 0)
        {
            valid = 3;
        }
        else if(strcmp(str,")") == 0)
        {
            valid = 5;
        }
        
        else
        {
            printf("\nInvalid Input...!");
            flag = 1;
        }


        if(top == -1 && strcmp(str,"(") != 0 && flag == 0) 
        {
            printf("\n\nExpression Must Start with '(' end with ')' ");
        }
        else
        {
                        if(stack[top] <= valid || valid == 1)
        {
            if(valid == 1)
            {
                top++;
                stack[top] = valid;
               exp[top] = str[0];
              // printf("%c",exp[top]);
            }
            if(valid == 2)
            {
                top++;
                stack[top] = valid;
                exp[top]=str[0];
               // printf("\nTop Value : %d",top);
            }
            if(valid == 3)
            {
                top++;
                stack[top] = valid;
               exp[top] = str[0];   
            }
            if(valid == 5)
            {
               printf("\nPopped Out  : ");
               
               
                while (stack[top] >= 1)
                {
                   // printf("\nStack no :- %d",stack[top]);
                    printf("\n%c",exp[top]);
                    
                    top--;
                    if(stack[top] == 1)
                    {
                        top--;
                        break;
                    }
                    
                }
                
            }
        } 
        
        
        if(stack[top]>valid && valid != 5 && valid !=1)
        {   
            printf("\nPopped Out  : ");
            while(stack[top] != 1)
            {   
                printf("\n%c",exp[top]);
                top--;
               // printf("\n%c",exp[top]);
                if(top == 0 )
                {
                    top++;
                    stack[top] = valid;
                    exp[top] = str[0];
                    break;
                }
            }
            
        }
        }
        
        

        
    }
    
    
}
int peep()
{
    if(top == -1)
    {
        printf("\nEmpty Stack....");
    }
    else
    {
        printf("\nTop expresion in Stack is  %c",exp[top]);
    }
    
    
}

int disp()
{
	int i;
    if(top == -1)
    {
        printf("\nEmpty Stack...");
    }
    else
    {
        printf("\n Expresion  is : ");
        for(i = 0;i <= top; i++)
        {
            printf("%c",exp[i]);
        } 
    }    
}


void main()
{
    int option;
    printf("Expression Must Start with '(' end with ')' ");
    for(;;)//for infinite loop
    {
        printf("\n\t\t\t*** Balancing Brackets ***");
        printf("\n1. Push the Symbol..");
        printf("\n2. Peep the Top Symbol..");
        printf("\n3. Display the current expresion..");
		printf("\n4.exit..");
		printf("\nEnter Your Choice :");
		scanf("%d",&option);
        switch (option)
        {
        case 1:
            push();
            break;
        case 2:
            peep();
            break;
        case 3:
            disp();
            break;
		case 4:
			exit(0);
			break;
        default:
            printf("\nInvalid Choice..!Please,enter valid option..");
            break;
        }
    }
   
}