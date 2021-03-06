#include<stdio.h>
#include<conio.h>
#include<graphics.h>
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
		m=((float)dy/(float)dx);
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
		m=((float)(yb-ya)/(float)(xb-xa));
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
void breshenham(int xa,int ya,int xb,int yb){

	int dx,dy;
	dx=abs(xa-xb);
	dy=abs(ya-yb);
	if(dx>dy)
	{
		gentle(xa,ya,xb,yb);
	}
	else
	{
		steep(xa,ya,xb,yb);
	}
}
void display_pic(int x[5][3],int e){
	int i,x1,y1,x2,y2;
	for(i=0;i<e;i++){
		if(i==(e-1)){
			x1=320+x[i][0];y1=240-x[i][1];
			x2=320+x[0][0];y2=240-x[0][1];
			breshenham(x1,y1,x2,y2);
		}
		else{
			x1=320+x[i][0];y1=240-x[i][1];
			x2=320+x[i+1][0];y2=240-x[i+1][1];
			breshenham(x1,y1,x2,y2);
		}
	}
}

void line1(){
	line(320,0,320,480);
	line(0,240,630,240);
}
void main(){
	int x[5][3],id[3][3],y[5][3],i,j,k,e,d,ch;

	int gd=DETECT,gm;
	initgraph(&gd,&gm,"c:/tc/bgi");
	printf("\n ENTER EDGES::");
	scanf("%d",&e);
	printf("\nENTER 1 FOR X-REFLECTION");
	printf("\nENTER 2 FOR Y-REFLECTION");
	printf("\nENTER 3 FOR XY-REFLECTION");

	printf("\nENTER A CHOICE::");
	scanf("%d",&ch);
	for(i=0;i<e;i++){
		for(j=0;j<2;j++){
			printf("\nENTER %d %d",i,j);
			scanf("%d",&x[i][j]);
		}
		x[i][2]=1;
	}
	cleardevice();
	line1();
	display_pic(x,e);
	if(ch==1){
		id[0][0]=1;id[0][1]=0;id[0][2]=0;
		id[1][0]=0;id[1][1]=-1;id[1][2]=0;
		id[2][0]=0;id[2][1]=0;id[2][2]=1;
	}
	else if(ch==2){
		id[0][0]=-1;id[0][1]=0;id[0][2]=0;
		id[1][0]=0;id[1][1]=1;id[1][2]=0;
		id[2][0]=0;id[2][1]=0;id[2][2]=1;
	}
	else if(ch==3){
		id[0][0]=-1;id[0][1]=0;id[0][2]=0;
		id[1][0]=0;id[1][1]=-1;id[1][2]=0;
		id[2][0]=0;id[2][1]=0;id[2][2]=1;
	}
	for(i=0;i<e;i++){
		for(j=0;j<3;j++){
			y[i][j]=0;
			for(k=0;k<3;k++){
				y[i][j]=y[i][j]+(x[i][k]*id[k][j]);
			}
		}
	}
		display_pic(y,e);
		getch();
}