#include<stdio.h>
#include<conio.h>

int bubble_sort(int arr[],int n)
{
	int i,temp,j;
	for(i = 0; i < n-1; i++)
	{
		for(j = 0; j < n-i-1; j++)	
		{
			if(arr[j] > arr[j+1])
			{
				temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = temp;
			}
		}
	}	
		
	printf("\n\n\t\t*** SORTED ARRAY ***");
	for(i = 0; i < n ; i++)
	{
		printf("\n%d",arr[i]);
	}
}

void main()
{
	int arr[100],i,n;
	printf("Enter How Many element you want : ");
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
 	 bubble_sort(arr,n);
}
