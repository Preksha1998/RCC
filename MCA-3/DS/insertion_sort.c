#include<stdio.h>
void insertion(int a[],int n)
{
	int i,temp,j;
	for(i=1;i<n;i++)
	{
		temp=a[i];
		j=i-1;

		while(j>=0 && a[j]>temp)
		{
			a[j+1]=a[j];
			j--;
		}
		a[j+1]=temp;
	}
}
void display(int a[],int n)
{
	int i;
	printf("\n\t\t*** SORTED ARRAY\n");
	for(i=0;i<n;i++)
	{
		printf(" %d",a[i]);
	}
}
void main()
{
	int n,i,a[100],ele;
	printf("\n Enter Number of Elements:");
	scanf("%d",&n);
	for(i=0;i<n;i++)
	{
		printf("\n Enter Number%d:",i+1);
		scanf("%d",&a[i]);
	}
	insertion_sort(a,n);
	display(a,n);
}

