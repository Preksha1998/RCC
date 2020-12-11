#include<stdio.h>
#include<conio.h>
#include<graphics.h>
#include<math.h>
void gentle(int xa,int ya,int xb,int yb){
	int dx,dy,x,y,xend;
	int p,twody,twodydx;
	float m;
	dx=abs(xa-xb);
	dy=abs(ya-yb);
	if(dx==0){
		m=(float)(dy);
	}
	else{
		m=(float)(dy/dx);
	}
	p=2*dy-dx;
	twody=2*dy;
	twodydx=2*(dy-dx);
	if(xa>xb){
		x=xb;
		y=yb;
		xend=xa;
	}
	else{
		x=xa;
		y=ya;
		xend=xb;
	}
	putpixel(x,y,1);
	while(x<xend){
		x++;
		if(p<0){
			p=p+twody;
		}
		else{
			if(m>0 && m<1){
				y++;
			}
			else if(m<0 && m>-1){
				y--;
			}
			p=p+twodydx;

		}
		putpixel(x,y,1);
	}

}
 void main(){
 int gd=DETECT,gm;
 initgraph(&gd,&gm,"c:/tc/bgi");
 gentle(150,100,50,200);
/* gentle(150,100,250,200);
 gentle(50,200,250,200);
 gentle(50,200,50,450);
 gentle(250,200,250,450);
 gentle(50,450,250,450);*/



 getch();
}




