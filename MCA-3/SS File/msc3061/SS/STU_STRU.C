#include<stdio.h>
#include<conio.h>
#include<math.h>
struct student{
	int rollno;
	char name[10];
	int sub1,sub2,sub3,total;
};
void main(){

	struct student s[3];
	int i;
	clrscr();
	for(i=0;i<3;i++){
		printf("\n--------------------------");
		printf("\nENTER THE ROLLNO::");
		scanf("%d",&s[i].rollno);
		printf("\nENTER THE NAME::");
		scanf("%s",&s[i].name);
		printf("\nENTER THE MARKS FOR SUBJECT1::");
		scanf("%d",&s[i].sub1);
		printf("\nENTER THE MARKS FOR SUBJECT2::");
		scanf("%d",&s[i].sub2);
		printf("\nENTER THE MARKS FOR SUBJECT3::");
		scanf("%d",&s[i].sub3);
		s[i].total=s[i].sub1+s[i].sub2+s[i].sub3;
		//printf("\nTOTAL OF MARKS IS::%d",s[i].total);
	}
	for(i=0;i<3;i++){
		printf("\n--------------------------");
		printf("\nENTERED ROLLNO IS ::%d",s[i].rollno);
		printf("\nENTERED NAME IS ::%s",s[i].name);
		printf("\nENTERED MARKS FOR SUBJECT1 IS ::%d",s[i].sub1);
		printf("\nENTERED MARKS FOR SUBJECT2 IS ::%d",s[i].sub2);
		printf("\nENTERED MARKS FOR SUBJECT3 IS ::%d",s[i].sub3);
		printf("\nTOTAL OF MARKS IS::%d",s[i].total);
	}



	getch();
}