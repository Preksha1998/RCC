#include<stdio.h>
#include<conio.h>
#include<graphics.h>
#include<math.h>
#define Round(a) ((int)(a+0.5))
dda(int xa,int ya,int xb,int yb){
	int dx,dy,steps,xincr,yincr,x,y,i;
	int l[]={1,1,1,0,0,0,0,1,1,1,0,0,0,0},cnt=1;
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
		if(l[cnt]==1){
		putpixel(Round(x),Round(y),YELLOW);
		}
		cnt++;
		if(cnt==10){
			cnt=1;
		}
	}
	return 0;
}
void main(){
	int gd=DETECT,gm;
	initgraph(&gd,&gm,"c:/tc/bgi");
	dda(50,200,250,200);
	//dda(150,100,50,200);
	//dda(150,100,250,200);
	//dda(250,200,250,450);
	getch();

}