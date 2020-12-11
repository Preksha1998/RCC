#include<stdio.h>
#include<conio.h>
#include<graphics.h>
#include<math.h>
#define Round(a) ((int)(a+0.5))
dda(int xa,int ya,int xb,int yb){
	int dx,dy,steps,xincr,yincr,x,y,i;
	dx=xb-xa;
	dy=yb-ya;
	if(abs(dx)>abs(dy)){
		steps=dx;
	}
	else{
		steps=dy;
	}
	xincr=dx/steps;
	yincr=dy/steps;
	x=xa;
	y=ya;
	putpixel(x,y,1);
	for(i=0;i<steps;i++){
		x=x+xincr;
		y=y+yincr;
		putpixel(Round(x),Round(y),1);
	}
	return 0;
}
void main(){
	int gd=DETECT,gm;
	int end1,end2,end3,end4;
	initgraph(&gd,&gm,"c:/tc/bgi");
	printf("\nENTER THE TWO END POINTS:");
	scanf("%d %d",&end1,&end2);
	printf("\nENTER THE TWO OTHER END POINTS:");
	scanf("%d %d",&end3,&end4);
	dda(end1,end2,end3,end4);
	getch();

}