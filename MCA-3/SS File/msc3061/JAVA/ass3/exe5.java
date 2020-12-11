class box{
	int l,b,h;
	box(){
		System.out.println("DEFAULT CONSTRUCTER CALLED");
	}
	box(int n){
		l=b=h=n;
	
	}
	box(int l,int b,int h){
		this.l=l;
		this.b=b;
		this.h=h;
	}
	int volume(){
		return l*b*h;	
	}
}
class exe5{
	public static void main(String args[]){
	box b=new box();
	int vol;
	box b1=new box(2,2,2);
	vol=b1.volume();
	System.out.println("THE VOLUME OF BOX IS::"+vol);
	
	}

}