#include<stdio.h>
#include<conio.h>
#include<String.h>
#include<ctype.h>
struct ast{
	char val;
	struct ast *left;
	struct ast *right;
};
static int ssm=0,flag=0;

struct ast *proc_v(char input[]){
	struct ast *a_v;
	struct ast *new_node=(struct ast *)malloc(sizeof(struct ast));
	char nextsymb=input[ssm];
	if(isalpha(nextsymb)!=0){
		ssm++;
		new_node->val=nextsymb;
		new_node->left=NULL;
		new_node->right=NULL;
	}
	else{
		printf("\nERROR OCCUR IT'S NOT AN IDENTIFIER:: %c",nextsymb);
		flag++;
	}
	return new_node;

}
struct ast *proc_t(char input[]){
	struct ast *new_node;
	struct ast *a_t;
	struct ast *b_t;
	char nextsymb;
	char ch;
	//printf("\n%c",nextsymb);
	a_t=proc_v(input);
	nextsymb=input[ssm];
	while(nextsymb=='*' || nextsymb=='/'){
		ch=nextsymb;
		//printf("%c",ch);
		ssm++;
		b_t=proc_v(input);
		new_node=(struct ast *)malloc(sizeof(struct ast));
		new_node->val=ch;
		new_node->left=a_t;
		new_node->right=b_t;
		a_t=new_node;
		nextsymb=input[ssm];
	}
	return a_t;
}
struct ast *proc_e(char input[]){
	struct ast *new_node;
	struct ast *a_e;
	struct ast *b_e;
	char nextsymb,ch;
	//printf("\nVALUE OF SSM IS:: %d",ssm);
	a_e=proc_t(input);
	nextsymb=input[ssm];
	while(nextsymb=='+' || nextsymb=='-'){
		ch=nextsymb;
		//printf("\n%c",ch);
		ssm++;
		//printf("\n%d",ssm);
		b_e=proc_t(input);
		new_node=(struct ast *)malloc(sizeof(struct ast));
		new_node->val=ch;
		new_node->left=a_e;
		new_node->right=b_e;
		a_e=new_node;
		nextsymb=input[ssm];
	}
	return a_e;
}
void preorder(struct ast *node){
	if(node!=NULL){
		printf("\t %c",node->val);
		preorder(node->left);
		preorder(node->right);
	}

}

void main(){
	char input[30];
	struct ast *start=(struct ast *)malloc(sizeof(struct ast));
	clrscr();
	printf("\nENTER THE INPUT::");
	scanf("%s",input);
	start=proc_e(input);
	if(flag==0){
		preorder(start);
	}
	else{
		printf("\nERROR IN EXPRESSION::%s",input);
	}


	getch();
}