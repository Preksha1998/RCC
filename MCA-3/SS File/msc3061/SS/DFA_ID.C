#include<stdio.h>
#include<conio.h>
#include<String.h>
#include<ctype.h>
void main(){
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
	char str[50];
	int len;
	FILE *f;
	clrscr();
	f=fopen("x:/SS/autometa_id.txt","wt");
	printf("\nEnter The String::");
	scanf("%s",str);
	fprintf(f,"%s",str);
	fclose(f);
	f=fopen("x:/SS/autometa_id.txt","r");
	fscanf(f,"%s",str);
	len=strlen(str);
	for(i=0;i<6;i++){
		for(j=0;j<4;j++){
			printf("%s\t",final_table[i][j]);
		}
		printf("\n");
	}
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
	printf("\n output is::%s",rowstate);

	getch();

}