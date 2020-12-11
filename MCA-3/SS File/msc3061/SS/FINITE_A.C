#include<stdio.h>
#include<conio.h>
#include<math.h>
#include<String.h>
#include<ctype.h>
void main(){
	FILE *f;
	int i,flag;
	char str[20];
	char *temp;
	char key_word[][8]={"int","char","float","double"};
	int count;
	clrscr();
	f=fopen("z:/SS/deterministic_finiteautometa.txt","wt");
	printf("\nEnter The String::");
	scanf("%s",str);
	fprintf(f,"%s",str);
	fclose(f);
	f=fopen("z:/SS/deterministic_finiteautometa.txt","r");
	fscanf(f,"%s",str);
	temp=strtok(str,":");
	count=0;
	while(temp){
		for(i=0,flag=0;i<4;i++){
		if(strcmp(temp,key_word[i])==0){
			count++;
			printf("\n%s is a keyword <kw#%d>",temp,count);
			flag=1;
			break;
		}
		}
		if(flag!=1){
			printf("\n%s is not a keyword",temp);
		}
		temp=strtok(NULL,":");
	}
	getch();
}