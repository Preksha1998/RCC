#include<stdio.h>

void read_data(int arr[],int n)
{
	int i;

	for(i=0; i<n; i++)
	{
		printf("\nEnter element %d: ",i+1);
		scanf("%d",&arr[i]);
	}
}

void selection_sort(int arr[],int n)
{
	int i,j,temp,mindex;

	for(i=0; i<n-1; i++)
	{
		mindex=i;
		for(j=i+1; j<n; j++)
		{
			if(arr[mindex]>arr[j])
				mindex=j;
		}
		temp=arr[i];
		arr[i]=arr[mindex];
		arr[mindex]=temp;
	}
}

void display(int arr[],int n)
{
	int i;

	for(i=0; i<n; i++)
	{
		printf("\nElement %d is: %d",i+1,arr[i]);
	}
}

void main()
{
	int n;
	int arr[50];
	
	printf("**************************** Selection Sort ****************************\n\n");
	printf("How many elemets: ");
	scanf("%d",&n);

	read_data(arr,n);

	selection_sort(arr,n);

	printf("\n\nSorted List:-\n");
	
	display(arr,n);

	printf("\n\n");
}