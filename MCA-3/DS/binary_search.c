#include<stdio.h>
#include<conio.h>

void binary_search(int arr[],int n)
{
	int first = 0, last = n-1,search;
	int mid = (first + last) / 2;
	printf("Enter Element you want to search :");
	scanf("%d",&search);
	while(first <= last)
	{
		if(arr[mid] == search)
		{
			printf("\n%d is found at location %d..",search,mid + 1);
			break;
		}
		else if(arr[mid] < search)
		{
			first = mid + 1;	
		}
		else
		{
			last = mid - 1;
		}
		mid = (first + last) / 2;	
	}
	if(first > last)
	{
		printf("\nArray is not sorted..");
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
	
	binary_search(arr,n);
}
