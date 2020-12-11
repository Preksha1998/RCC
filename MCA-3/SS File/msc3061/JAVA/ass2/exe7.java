class demo{
	int oopj,cg,se,clip;
	demo(int a,int b,int c,int d){
		oopj=a;
		cg=b;
		se=c;
		clip=d;
	}
	void display(){
		System.out.println("The Entered Values Are::");
		System.out.println("OOPJ::"+oopj+" "+"CG::"+cg+" "+"SE::"+se+" "+"CLIP::"+clip+" ");
	}
	void calculation(){
		String grade;
		int total=oopj+cg+se+clip;
		double per=total/4;	
		System.out.println("Total Is::"+total);
		System.out.println("Percentage Is::"+per);
		if(per>=80){
			grade="Distinction";
		}
		else if(per>=70 && per<80){
			grade="First Class";
		}
		else if(per>=60 && per<70){
			grade="Second Class";
		}
		else{
			grade="Third Class";
		}
		System.out.println("The Grade Is::"+grade);
	}	

}
class exe7{
	public static void main(String args[]){
	int oopj=60,cg=70,se=70,clip=80;
	demo d=new demo(oopj,cg,se,clip);
	d.display();
	d.calculation();
	}

}