#include<stdio.h>
#include<conio.h>
#include<String.h>
#include<ctype.h>
char key_word[][8]={"int","char","float","double"};
char operator_table[][3]={"+","-","*","/","=",",",";","++","--"};
char id_table[10][10];
char constant_int[10][10];
char constant_real[10][10];
int cnt_int=0,cnt_real=0,cnt_id=0;
void dfa(char str[]){
       char final_table[6][4][10]={{"state","letter","digit","dot"},
				    {"start","id","int","error"},
				    {"id","id","id","error"},
				    {"int","error","int","inter"},
				    {"inter","error","real","error"},
				    {"real","error","real","error"}};
	int i,j;
	char rowstate[10]="start";
	int row,col;
	char colstate[10];
	int len;
	len=strlen(str);
	/*for(i=0;i<6;i++){
		for(j=0;j<4;j++){
			printf("%s\t",final_table[i][j]);
		}
		printf("\n");
	} */
	for(i=0;i<len;i++){
		for(j=0;j<6;j++){
			if((strcmp(final_table[j][0],rowstate)==0)){
				row=j;
			}
		}
		if(str[i]>=48 && str[i]<=57){
			strcpy(colstate,"digit");
		}
		else if((str[i]>=65 && str[i]<=90) || (str[i]>=97 && str[i]<=122)){
			strcpy(colstate,"letter");
		}
		else if(str[i]==46){
			strcpy(colstate,"dot");
		}
		else{
			printf("\ninvalid");
			break;
		}
		for(j=0;j<4;j++){
			if((strcmp(final_table[0][j],colstate)==0)){
				col=j;
			}

		}
		strcpy(rowstate,final_table[row][col]);
		if((strcmp(rowstate,"error")==0)){
			break;
		}
	}
	if((strcmp(rowstate,"int"))==0){
		strcpy(constant_int[cnt_int],str);
		printf("<ci#%d>",cnt_int+1);
		cnt_int++;
	}
	else if((strcmp(rowstate,"real"))==0){
		strcpy(constant_real[cnt_real],str);
		printf("<cr#%d>",cnt_real+1);
		cnt_real++;
	}
	else if((strcmp(rowstate,"id"))==0){
		strcpy(id_table[cnt_id],str);
		printf("<id#%d>",cnt_id+1);
		cnt_id++;
	}

}
void main(){

	char str[50];
	int i,flag=0;
	char *temp;
	FILE *f;
	clrscr();
	f=fopen("z:/SS/scanner.txt","wt");
	printf("\nEnter The String::");
	scanf("%s",str);
	fprintf(f,"%s",str);
	fclose(f);
	f=fopen("z:/SS/scanner.txt","r");
	fscanf(f,"%s",str);
	temp=strtok(str,":");

	while(temp){
		flag=0;
		for(i=0;i<4;i++){
			if(strcmp(temp,key_word[i])==0){
			printf("<kw#%d>",i+1);
			flag=1;
			break;
			}
		}
		for(i=0;i<10;i++){
				if(strcmp(temp,operator_table[i])==0){
				printf("<op#%d>",i+1);
				flag=1;
				break;
				}
		}
		for(i=0;i<7;i++){
		 if(strcmp(temp,constant_int[i])==0){
			printf("<ci#%d>",i+1);
			flag=1;
			break;
		 }
		}
		for(i=0;i<10;i++){
		 if(strcmp(temp,constant_real[i])==0){
			printf("<cr#%d>",i+1);
			flag=1;
			break;
		 }
		}
		for(i=0;i<8;i++){
		 if(strcmp(temp,id_table[i])==0){
			printf("<id#%d>",i+1);
			flag=1;
			break;
		 }
		}
		if(flag!=1){
			dfa(temp);

		}
		temp=strtok(NULL,":");
	}
	getch();

}