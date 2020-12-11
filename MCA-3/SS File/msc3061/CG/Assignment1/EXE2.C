//200 400 300 400
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
void steep(int xa,int ya,int xb,int yb){
	int dx,dy,x,y,yend;
	int p,twodx,twodxdy;
	float m;
	dx=abs(xa-xb);
	dy=abs(ya-yb);
	if(dx==0){
		m=(float)(dy);
	}
	else{
		m=((yb-ya)/(xb-xa));
	}
	p=2*dx-dy;
	twodx=2*dx;
	twodxdy=2*(dx-dy);
	if(ya>yb){
		x=xb;
		y=yb;
		yend=ya;
	}
	else{
		x=xa;
		y=ya;
		yend=yb;
	}
	putpixel(x,y,1);
	while(y<yend){
		y++;
		if(p<0){
			p=p+twodx;
		}
		else{
			if(m>=1){
				x++;
			}
			else if(m<=-1){
				x--;
			}
			p=p+twodxdy;

		}
		putpixel(x,y,1);
	}

}
void main(){
 int gd=DETECT,gm;
 int c1,c2,c3,c4,dx,dy;
 initgraph(&gd,&gm,"c:/tc/bgi");
 /*printf("\n ENTER FOUR CO-ORDINATES::");
 scanf("%d %d %d %d",&c1,&c2,&c3,&c4);
 dx=abs(c1-c3);
 dy=abs(c2-c4);
 if(dx>dy){
	gentle(c1,c2,c3,c4);
 }
 else{
	steep(c1,c2,c3,c4);
 }*/
 steep(150,100,50,200);
 steep(150,100,250,200);
 gentle(50,200,250,200);
 steep(50,200,50,450);
 steep(250,200,250,450);
 gentle(50,450,250,450);
 getch();
}




