#include<stdio.h>
void insertion_sort(int arr[],int n)
{
	int i,temp,j;
	for(i=1;i<n;i++)
	{
		temp=arr[i];
		j=i-1;

		while(j>=0 && arr[j]>temp)
		{
			arr[j+1]=arr[j];
			j--;
		}
		arr[j+1]=temp;
	}
}
void display(int arr[],int n)
{
	int i;
	printf("\n\t\t*** SORTED ARRAY\n");
	for(i=0;i<n;i++)
	{
		printf("\n%d",arr[i]);
	}
}
void main1()
{
	int n,i,arr[100],ele;
	printf("\n Enter How Many Number of Elements you want:");
	scanf("%d",&n);
	for(i=0;i<n;i++)
	{
		printf("\n Enter Number %d:",i+1);
		scanf("%d",&arr[i]);
	}

	for(i=0;i<n;i++)
	{
		printf("\nNumber %d = %d",i+1,arr[i]);
	}

	insertion_sort(arr,n);
	display(arr,n);
}

