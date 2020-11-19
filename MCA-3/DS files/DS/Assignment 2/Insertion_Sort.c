#include<stdio.h> 

void get_data(int arr[],int n)
{
	int i;

	for(i=0; i<n; i++)
	{
		printf("\nEnter Element %d: ",i+1);
		scanf("%d",&arr[i]);
	}
}

void Insertion_Sort(int arr[], int n) 
{ 
    int i,key,j; 

    for (i=1; i<n; i++) 
	{ 
        key=arr[i]; 
        j = i-1; 
  
        while (j>=0 && arr[j]>key) 
		{ 
            arr[j+1] = arr[j]; 
            j = j-1; 
        } 
        arr[j+1]=key; 
    }
}
  
void display(int arr[], int n) 
{ 
    int i; 

    for(i=0; i<n; i++) 
	{
        printf("\nElement %d is: %d",i+1,arr[i]); 
	}
}
  
void main() 
{ 
    int arr[50],n;

	printf("*********************** Insertion Sort ***********************\n\n");
    printf("Enter the number of elements: ");
	scanf("%d",&n);

	get_data(arr,n);
    
	Insertion_Sort(arr,n); 
    
	printf("\n\nSorted List:-\n");
	display(arr,n); 

	printf("\n\n");
 } 
