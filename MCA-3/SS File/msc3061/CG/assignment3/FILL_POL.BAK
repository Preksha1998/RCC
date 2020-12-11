#include<stdio.h>
#include<conio.h>
#include<math.h>
#include<graphics.h>
#define size 30
#define Round(a) ((int)(a+0.5))
#define n1 8
int free1=1,op,erase_flag=1;
int solid,edges,start_edge,end_edge,scan,scan_decrement,sides;
float hs,he,ws,we,h,w,x,y,df_op[size],df_x[size],df_y[size],df_pen_x,df_pen_y,frame_pen_x=0,frame_pen_y=0;
float ymax[n1],ymin[n1],dx[n1],xa[n1];
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
void putpoint(int op1,float x1,float y1){
	if(free1>size){
		printf("\n DISPLAY FILE IS FULL");
	}
	else{
		df_op[free1]=op1;
		df_x[free1]=x1;
		df_y[free1]=y1;
		free1++;
		//printf("\n%d %f %f",op1,x1,y1);
	}

}
void display_file_enter(int op1){
	putpoint(op1,df_pen_x,df_pen_y);
}
void getpoint(int n){

	op=df_op[n];
	x=df_x[n];
	y=df_y[n];

}

void move_abs(float x1,float y1){
	df_pen_x=x1;
	df_pen_y=y1;
	//printf("%f %f",df_pen_x,df_pen_y);
	display_file_enter(1);
}
void move_rel(float dx,float dy){
	df_pen_x+=dx;
	df_pen_y+=dy;
	display_file_enter(1);
}
void line_abs(float x1,float y1){
	df_pen_x=x1;
	df_pen_y=y1;
	display_file_enter(2);
}
void line_rel(float dx,float dy){
	df_pen_x+=dx;
	df_pen_y+=dy;
	display_file_enter(2);

}
float max(float x1,float y1){
	if(x1>y1){
		return x1;
	}
	else{
		return y1;
	}
}
float min(float x1,float y1){
	if(x1<y1){
		return x1;
	}
	else{
		return y1;
	}
}
void domove(float x1,float y1){
       //	printf("\n%f %f",x1,y1);
	frame_pen_x=max(ws,min(we,(x1*w+ws)));
	frame_pen_y=max(hs,min(he,(y1*h+hs)));
       //	printf("\n %f %f",frame_pen_x,frame_pen_y);
}
void doline(float x2,float y2){
	float x1=frame_pen_x,y1=frame_pen_y;
	int dx,dy;
	frame_pen_x=max(ws,min(we,(x2*w+ws)));
	frame_pen_y=max(hs,min(he,(y2*h+hs)));
       //	printf("\n %f %f",frame_pen_x,frame_pen_y);
	dx=(int)((abs)(x1-frame_pen_x));
	dy=(int)((abs)(y1-frame_pen_y));
	if(dx>dy){
	gentle((int)(getmaxx()-x1),(int)(getmaxy()-y1),(int)(getmaxx()-frame_pen_x),(int)(getmaxy()-frame_pen_y));
	}
	else{
	steep((int)(getmaxx()-x1),(int)(getmaxy()-y1),(int)(getmaxx()-frame_pen_x),(int)(getmaxy()-frame_pen_y));
	}


}

void poly_insert(float x1,float y1,float x2,float y2){
	int e=edges;
	float ym;
	ym=max(y1,y2);
	while((e!=1) && (ymax[e-1]<ym)){
		ymax[e]=ymax[e-1];
		ymin[e]=ymin[e-1];
		xa[e]=xa[e-1];
		dx[e]=dx[e-1];
		e--;
	}
	ymax[e]=ym;
	dx[e]=(((int)(x2)-(int)(x1))/(y2-y1))*(-scan_decrement);
	if(y1>y2){
		ymin[e]=y2;
		xa[e]=(int)(x1);
	}
	else{
		ymin[e]=y1;
		xa[e]=(int)(x2);
	}

}
void load_polygon(int i){
	float x1,y1,x2,y2;
	int k;
	getpoint(i);
	sides=df_op[i];
	x1=x*w+ws+0.5;
	y1=(int)(y*h+hs+0.5);
	i++;
	edges=1;
	for(k=0;k<=sides;k++){
		getpoint(i);
		x2=x*w+ws+0.5;
		y2=(int)(y*h+hs+0.5);
		if(y1==y2)
			x1=x2;
		else{
			poly_insert(x1,y1,x2,y2);
			edges=edges+1;
			x1=x2;
			y1=y2;
		}
		i++;

	}
	edges--;


}
void include(){
	int final_edge=edges;
	while(end_edge<=final_edge && ymax[end_edge]>=scan){
		end_edge++;
	}

}
void xsort(){
	int k,l;
	float t;
	for(k=start_edge;k<=end_edge-1;k++){
		l=k;
		while(l>start_edge && xa[l]<xa[l-1]){
			t=ymin[l];
			ymin[l]=ymin[l-1];
			ymin[l-1]=t;


			t=xa[l];
			xa[l]=xa[l-1];
			xa[l-1]=t;

			t=dx[l];
			dx[l]=dx[l-1];
			dx[l-1]=t;

			l--;

		}


	}
}
void fillin(float x1,float x2,float y1){
	if(x1==x2)
		return;
	for(x=x1;x<=x2;x++){
		putpixel(getmaxx()-x,getmaxy()-y1,RED);
	}
}
void fillscan(){
	float nx=(end_edge-start_edge)/2;
	int i,j=start_edge;
	for(i=1;i<=nx;i++){
		fillin(xa[j],xa[j+1],scan);
		j=j+2;
	}
}

void update_xvalues(int last_edge,int scan){
	int k1,k2=last_edge;
	for(k1=last_edge;k1>=start_edge;k1--){
		if(ymin[k1]<scan){
			xa[k2]=xa[k1]+dx[k1];
			if(k1!=k2){
			ymin[k2]=ymin[k1];
			dx[k2]=dx[k1];
			}
			k2=k2-1;
		}


	}
	start_edge=k2+1;


}
void fillpolygon(int index){
	load_polygon(index);
	if(edges<2){
		printf("\nerror");
	}
	scan=ymax[1];
	start_edge=1;
	end_edge=1;
	include();
	while(end_edge!=start_edge){
		xsort();
		fillscan();
		scan=scan-scan_decrement;
		update_xvalues(end_edge-1,scan);
		include();
	}
}
void dopolygon(float x,float y){
	if(solid==1){
	domove(x,y);
	fillpolygon(1);
	}
	else{
	domove(x,y);
	}
}
void polygon_abs(int n,float ax[],float ay[]){
	int i;
	if(n<3){
		printf("\nwrong polygon sides");
	}
	df_pen_x=ax[n-1];
	df_pen_y=ay[n-1];
	display_file_enter(n);
	for(i=0;i<n;i++){
		line_abs(ax[i],ay[i]);
	}
}
void interpret(int start,int count){
	int n;
	for(n=start;n<=count;n++){
		getpoint(n);

		if(op==1){
			domove(x,y);
		}
		else if(op==2){
			doline(x,y);
		}
		else{
			dopolygon(x,y);

		}
	}
}
void new_frame(){
	erase_flag=1;
}
void erase(){
	int i,j;
	for(i=0;i<getmaxx();i++){
		for(j=0;j<getmaxy();j++){
			putpixel(i,j,0);
		}
	}
}
void make_picture_current(){
	if(erase_flag==1){
	       //	erase();
	}
	erase_flag=0;
	if(free1>1){
		interpret(1,(free1-1));
	}
	free1=1;

}

void initialize(){
	free1=1,
	frame_pen_x=0,
	frame_pen_y=0,
	df_pen_x=0,
	df_pen_y=0,
	hs=0,
	he=getmaxx(),
	h=he-hs,
	ws=0,
	we=getmaxy(),
	w=we-ws,
	solid=1,
	scan_decrement=1;
}
void main(){
	int i,gd=DETECT,gm;
	float ax[]={0.2,0.2,0.1,0.1,0.4,0.4,0.3,0.3};
	float ay[]={0.1,0.3,0.3,0.4,0.4,0.3,0.3,0.1};
	initgraph(&gd,&gm,"c:/tc/bgi");
	initialize();
	new_frame();
	polygon_abs(8,ax,ay);
	make_picture_current();
	/*for(i=1;i<free1;i++){
		printf("\n%f %f %f",df_op[i],df_x[i],df_y[i]);
	} */
	getch();
}