/*2.  Write a program to create a singly linked list and display 
its elements in LIFO pattern.Also display the number of elements in the list.*/

#include<stdio.h>
#include<stdlib.h>
struct stack {
	int no;
	struct stack *next;
};

struct stack *insert_node(struct stack *first){
	struct stack *temp = (struct stack*)malloc(sizeof(struct stack));
	printf("Enter the elements:\n");
	scanf("%d",&temp->no);
	temp->next = NULL;
	if(first == NULL){
		first = temp ;
	}
	else{
		temp->next = first ;
		first = temp;
	}
	return first;
}

struct stack* delete_first(struct stack *first ){
	struct stack *temp;
	if(first == NULL){
		printf("Linkedlist is empty:\n");
	}
	else{
		if(first->next == NULL){
			free(first);
			first = NULL;
			printf("Now stack is empty:\n");
		}
		else{
			temp = first->next;
			free(first);
			first = temp;
			printf("Node deleted successfully:\n");
		}
		return(temp);	
	}	
}

void display(struct stack *first){
	struct stack *temp =first;
	if(first ==  NULL){
		printf("Linkedlist is empty:\n\n");
	}
	else{
		printf("\n========================\n");
		printf("NO");
		printf("\n========================\n");
		while(temp != NULL){
			printf("%d\n",temp->no);
			temp = temp->next;	
		}
	}
}
int main(){
	struct stack *first = NULL;
	int i,n,no = 1,cnt = 0;	
		while(no != 0){
			printf("\n\n1-> Enter the linked list in LIFO paattern:\n");
			printf("2-> Display the linkedlist:\n");
			printf("3-> Delete the first node from the list:\n");
			printf("0-> Exit\n");
			printf("\nEnter the no from above:\n");
			scanf("%d",&no);
			if(no == 1){
				first = insert_node(first);
				cnt++;
				printf("\nNode inserted successfully:\n");
			}
			if(no == 2){
				display(first);
				printf("\n Total no. of element in the list is %d ",cnt);
			}
			if(no == 3){
				first = delete_first(first);
				if(first != NULL){
					cnt--;
				}
			}
			if(no == 0){
				exit(1);
			}
		}
		
}
