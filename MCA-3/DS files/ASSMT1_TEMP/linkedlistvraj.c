#include<stdio.h>
#include<stdlib.h>

struct node
{
    int data;
    struct node* link;
};

struct node* root = NULL;


void nodetofirst(void);
void display(void);
int length();
void deletenode();

int main()
{
    int option;

    while(1)
    {
        printf("\n\n<-------------------Single Linked List-------------------->");
        printf("\n\n Enter Option No :-");
        printf("\n1. Add Node To First");
        printf("\n2. Display");
        printf("\n3. Count the Number of Nodes");
        printf("\n4. Delete a Node\n");
        scanf("%d",&option);

        switch (option)
        {
        case 1:
            nodetofirst();
            break;
        case 2:
            printf("\n\nNodes Data :-");
           display();
            break;
        case 3:
            int len;
            len = length();
            printf("\n\n Total Number of Nodes :- %d",len);
            break;
        case 4:
            deletenode();
            break;
        
        default:
        printf("\n\nInvalid Option");
            break;
        }
    }
    
}

void nodetofirst()
{
    struct node* temp ;
    temp =(struct node*)malloc(sizeof(struct node));
    printf("\nEnter The Data you want to add to this NODE :- ");
    scanf("%d",&temp->data);
    temp->link=NULL;
    if(root == NULL)
    {
        root = temp;
    }
    else
    {
        temp->link = root;
        root = temp;
    }
    printf("Added !!!!");

}

void display()
{
    struct node* temp;
    temp = root;
    if(temp == NULL)
    {
        printf("\nList is Empty");
    }
    else
    {
        while(temp != NULL)
        {
            printf("%d-->",temp->data);
            temp = temp->link;
        }
        printf("NULL");
        printf("\n\n");
    }
    
    
}

int length()
{
     struct node* temp;
     int count = 0;
    temp = root;

    
        while(temp != NULL)
        {
            count++;
            temp = temp->link;
        }
        
    return count;
}

void deletenode()
{
    struct node* temp;
    temp = root;
    if(temp == NULL)
    {
        printf("\nList is Empty");
    }
    else
    {
         while(temp != NULL)
        {
            printf("%d-->",temp->data);
            temp = temp->link;
        }
        printf("NULL");
        printf("\n\n");
        int loc ;
        printf("\n Enter the location u want to delete From above Nodes :- ");
        scanf("%d",&loc);
        if(loc > length())
        {
            printf("\nLocation Not Found");
        }
        else if(loc == 1)
        {   
            struct node* temp1;
            temp1 = root;
            root = temp1->link;
            temp1->link = NULL;
            free(temp1);
            printf("\nDeleted Successfully !!!!");
        }
        else
        {
            struct node* p=root,*q;
            int i = 1;
            if(i < loc - 1)
            {
                p = p->link;
                i++;
            }
            q = p->link;
            p->link = q->link;
            q->link = NULL;
            free(q);
            printf("/nDeleted Successfully !!!!");
        }
        
    }
}