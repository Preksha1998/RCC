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
		putpixel(Round(x),Round(y),YELLOW);
	}
	return 0;
}
void main(){
	int gd=DETECT,gm;
	initgraph(&gd,&gm,"c:/tc/bgi");
	dda(150,200,150,250);
	dda(150,225,200,225);
	dda(200,200,200,250);
	dda(225,200,220,250);
	dda(225,200,260,200);
	dda(225,250,260,250);
	dda(225,225,260,225);
	dda(295,200,295,250);
	dda(295,250,330,250);
	dda(355,200,355,250);
	dda(355,250,395,250);
	dda(420,200,420,250);
	dda(420,250,465,250);
	dda(465,200,465,250);
	dda(420,200,465,200);
	getch();

}