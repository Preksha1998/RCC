#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<ctype.h>
int first[10],second[10],res[10];

int expo_first()
{
    int expo;
    int power;
    printf("\n\nEnter exponent of X (if the exponent is 1 enter 1) : ");
    scanf("%d",&expo);
    printf("\nEnter the power of X (if the power is 1 enter 1) : ");
    scanf("%d",&power);
    if(power <=0)
    {
        printf("\n\nInvalid");
        return 0;
    }
    else
    {
        first[power] = expo;
    }
    return 0;
    
}
int expo_second()
{
    int expo;
    int power;
    printf("\n\nEnter exponent of X (if the exponent is 1 enter 1) : ");
    scanf("%d",&expo);
    printf("\nEnter the power of X (if the power is 1 enter 1) : ");
    scanf("%d",&power);
    if(power <=0)
    {
        printf("\n\nInvalid");
        return 0;
    }
    else
    {
        second[power] = expo;
    }
    return 0;
}
int main()
{
    int option,flag = 0,i,const1;

    printf("<--------------Polynomial Addition With Array------------->");
    while(1)
    {
        if(flag == 0)
        {   
            printf("\n\nFor First Polynomial Expression : ");
            printf("\n\nEnter the Option");
            printf("\n\n1. Add Exponent and power to X : ");
            printf("\n2. Add a Constant to the equation : \n(This can be entered ONCE only)\n");
            scanf("\n%d",&option);
            
            switch (option)
            {
            case 1:
                expo_first();
                printf("\n\nCurrent Expression Polynomial Expression : ");
                for(i = 10;i>0;i--)
                {
                    if(first[i] != 0)
                    {
                        if(first[i]>0)
                        {
                            printf("+%dx^%d",first[i],i);
                        }
                        if(first[i]<0)
                        {
                            printf("%dx^%d",first[i],i);
                        }
                        
                    }
                    
                  
                }
                break;
            case 2:
                printf("\n\nEnter the constatnt for the Polynomial Expression : ");
                scanf("%d",&const1);
                flag = 1;
                first[0] = const1;
                printf("\n\nCurrent Expression Polynomial Expression : ");
                 for(i = 10;i>=0;i--)
                 {
                    if(first[i] != 0)
                    {
                        if(first[i]>0 && i != 0)
                        {
                            printf("+%dx^%d",first[i],i);
                        }
                        if(first[i]<0 && i != 0)
                        {
                            printf("%dx^%d",first[i],i);
                        }
                        if(i == 0)
                        {   
                            if(first[i]>0)
                            {
                                printf("+%d",first[i]);
                            }
                            else
                            {
                                printf("%d",first[i]);
                            }
                            
                        }
                        
                    }
                    
                  
                 }
                /* for(i = 10;i>0;i--)
                 {
                     if(first[i] == NULL)
                     {
                         first[i] = 0;
                     }
                 }*/
                break;
            
            default:
                break;
            }
        }
        else if(flag == 1)
        {
            printf("\n\nFor Second Polynomial Expression : ");
            printf("\n\nEnter the Option");
            printf("\n\n1. Add Exponent and power to X : ");
            printf("\n2. Add a Constant to the equation : \n(This can be entered ONCE only)\n");
            scanf("\n%d",&option);

            switch (option)
            {
            case 1:
                expo_second();
                printf("\n\nCurrent Expression Polynomial Expression : ");
                for(i = 10;i>0;i--)
                {
                    if(second[i] != 0)
                    {
                        if(second[i]>0)
                        {
                            printf("+%dx^%d",second[i],i);
                        }
                        if(second[i]<0)
                        {
                            printf("%dx^%d",second[i],i);
                        }
                        
                    }
                    
                  
                }
                break;
            case 2:
                printf("\n\nEnter the constatnt for the Polynomial Expression : ");
                scanf("%d",&const1);
                flag = 3;
                second[0] = const1;
                printf("\n\nCurrent Expression Polynomial Expression : ");
                 for(i = 10;i>=0;i--)
                 {
                    if(second[i] != 0)
                    {
                        if(second[i]>0 && i != 0)
                        {
                            printf("+%dx^%d",second[i],i);
                        }
                        if(second[i]<0 && i != 0)
                        {
                            printf("%dx^%d",second[i],i);
                        }
                        if(i == 0)
                        {   
                            if(second[i]>0)
                            {
                                printf("+%d",second[i]);
                            }
                            else
                            {
                                printf("%d",second[i]);
                            }
                            
                        }
                        
                    }
                    
                  
                 }
                 break;
            default:
                break;
            }
        }
        else if(flag == 3)
        {
            printf("\n\nThe Sum of Two Polynomial is : \n");
            for(i = 10;i>=0;i--)
            {
                res[i] = first[i] + second[i];
                if(res[i] != 0)
                    {
                        if(res[i]>0 && i != 0)
                        {
                            printf("+%dx^%d",res[i],i);
                        }
                        if(res[i]<0 && i != 0)
                        {
                            printf("%dx^%d",res[i],i);
                        }
                        if(i == 0)
                        {   
                            if(res[i]>0)
                            {
                                printf("+%d",res[i]);
                            }
                            else
                            {
                                printf("%d",res[i]);
                            }
                            
                        }
                        
                    }
            }
            exit(0);
        }

      //  break;

        
        
    }
}