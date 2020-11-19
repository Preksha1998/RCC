#include<stdio.h>

void read_data(int arr[],int n)
{
	int i;

	for(i=0; i<n; i++)
	{
		printf("\nEnter Element %d: ",i+1);
		scanf("%d",&arr[i]);
	}
}

void bubble_sort(int arr[],int n)
{
	int i,j,temp;

	for(i=0; i<n-1; i++)
	{
		for(j=0; j<n-i-1; j++)
		{
			if(arr[j]>arr[j+1])
			{
				temp=arr[j];
				arr[j]=arr[j+1];
				arr[j+1]=temp;
			}
		}
	}
}

void display(int arr[],int n)
{
	int i;

	for(i=0; i<n; i++)
	{
		printf("\nElement %d: %d",i+1,arr[i]);
	}
}

void main()
{
	int n;
	int arr[50];

	printf("********************* Bubble Sort *********************\n\n");

	printf("How many elements: ");
	scanf("%d",&n);

	read_data(arr,n);
	
	bubble_sort(arr,n);
	
	printf("\n\nSorted List:-\n");
	
	display(arr,n);
	
	printf("\n\n");
}