#include<stdio.h>
#include<conio.h>

void lin_search(int arr[100],int n)
{
	int i,count = 0 ,search;
	printf("Enter which element you want to find :");
	scanf("%d",&search);
	for(i = 0; i < n; i++)
	{
		if(arr[i] == search)
		{
			printf("\n%d is located at position %d..",search,i+1);
			count++;
		}
	}	
	
	if(count == 0)
	{
		printf("\n%d is not present in the list..",search);
	}
	else
	{
		printf("\n%d is present %d times in the array..",search,count);
	}
}


void main()
{
	int arr[100], i,n;
	printf("Enter How many element you want : ");
	scanf("%d",&n);
	
	for(i = 0; i < n; i++)
	{
		printf("Enter Number %d = ",i+1);
		scanf("%d",&arr[i]);
	}
	
	for(i = 0; i < n; i++)
	{
		printf("Number %d = %d\n",i+1,arr[i]);
		
	}
	
	lin_search(arr,n);
}
