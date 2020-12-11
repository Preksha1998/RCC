#include<stdio.h>
#include<conio.h>
#include<String.h>
#include<ctype.h>
char tbl[8][8][6]={
	{"lt","+","*","(",")","/","-","$"},
	{"+",">","<","<",">","<",">",">"},
	{"*",">",">","<",">",">",">",">"},
	{"(","<","<","<","=","<","<","error"},
	{")",">",">","error",">",">",">",">"},
	{"/",">",">","<",">",">",">",">"},
	{"-","<","<","<",">","<",">",">"},
	{"$","<","<","<","error","<","<","="}};
struct node{
  int data;
  struct node *left;
  struct node*right;
};
void main(){
	int i,j;
	clrscr();
	printf("\nOPERATOR PRECEDENCE TABLE");
	printf("\n-------------------------\n");
	for(i=0;i<8;i++){
		for(j=0;j<8;j++){
			printf("%s\t",tbl[i][j]);
		}
		printf("\n");
	}

	getch();

}