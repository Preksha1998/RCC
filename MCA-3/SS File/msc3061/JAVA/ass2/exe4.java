class books{
	int bookno;
	String authorname;
	String bookname;
	String publication;
	float price;
	int edition;
	void addbook(int i,String a,String b,String p,float pr,int e){
		bookno=i;
		authorname=a;
		bookname=b;
		publication=p;
		price=pr;
		edition=e;
	}
	void removebook(){
		bookno=0;
		authorname=null;
		bookname=null;
		publication=null;
		price=0.0f;
		edition=0;
	}
	void search(books b[],int num){
		int flag=0;
		for(int i=0;i<3;i++){
			if(num==b[i].bookno){
			System.out.println("Book Is Found");
			System.out.println("BOOK NUMBER IS::"+b[i].bookno);
			System.out.println("AUTHOR NAME IS::"+b[i].authorname);
			System.out.println("BOOK NAME IS::"+b[i].bookname);
			System.out.println("PUBLICATION NAME IS::"+b[i].publication);
			System.out.println("PRICE IS::"+b[i].price);
			System.out.println("EDITION IS::"+b[i].edition);
			flag=1;
			break;
			}
			
		}
		if(flag==0){
			System.out.println("Book Is Not Found");
		}

	}
	void display(books b[]){
		for(int i=0;i<3;i++){
			if(b[i].bookno!=0){
			System.out.println("BOOK NUMBER IS::"+b[i].bookno);
			System.out.println("AUTHOR NAME IS::"+b[i].authorname);
			System.out.println("BOOK NAME IS::"+b[i].bookname);
			System.out.println("PUBLICATION NAME IS::"+b[i].publication);
			System.out.println("PRICE IS::"+b[i].price);
			System.out.println("EDITION IS::"+b[i].edition);
			}
		}
		
	}

}
class exe4{
	public static void main(String args[]){
		books b[]=new books[3];
		for(int i=0;i<3;i++){
			b[i]=new books();
		}
		b[0].addbook(1,"balaguruswamy","c++","mcgraw hill",600.5f,6);
		b[1].addbook(2,"balaguruswamy","c","mcgraw hill",600.5f,5);
		b[2].addbook(3,"balaguruswamy","c++","mcgraw hill",600.5f,4);
		System.out.println("------------------------------");
		b[0].display(b);
		System.out.println("------------------------------");
		System.out.println("After Removing Book::");
		b[0].removebook();
		b[0].display(b);
		System.out.println("------------------------------");
		System.out.println("Searching Book::");
		b[0].search(b,2);

		
	}

}