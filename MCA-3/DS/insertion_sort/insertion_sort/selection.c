#include<stdio.h>
#include<conio.h>

void selection(int arr[], int n)
{
	int i=0,j,min,loc,temp;
	
	for(i=0; i<n-1; i++)
	{
		min=arr[i];
		loc=i;
		for(j=i+1;j<n;j++)
		{
			if(min>arr[j]){
				min=arr[j];
				loc=j;
			}
		}
		temp=arr[i];
		arr[i]=arr[loc];
		arr[loc]=temp;
	}
		
}

void display(int arr[],int n)
{
	int i;
	printf("\n\t\t** SORTED ARAY **\n");
	for(i = 0; i < n; i++)
	{
		printf("\n%d",arr[i]);
	}	
}

void main()
{
	int arr[100],n,i;
	printf("Enter how many Element you want :");
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
	selection(arr,n);
	display(arr,n);
}