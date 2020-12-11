class stack{
	int a[]=new int[10];
	int n=9,top=0;
	void push(int i){
		if(top==n){
			System.out.println("Stack Overflow");
		}
		else{
			a[top]=i;
			top++;
		}
	}

	void pop(){
		if(top==0){
			System.out.println("Stack Underflow");
		}
		else{
			a[top]=0;
			top--;
		}
	}
	void display(){
		for(int i=0;i<top;i++){
			System.out.println(a[i]+" ");
		}
	}
	void search(int j){
			for(int i=0;i<top;i++){
			if(a[i]==j){
				System.out.println("Search Successful And The Element Is::"+" "+a[i]);
				return;
			}
		}
	System.out.println("Search UnSuccessful");	
	}
}
class exe1{
	public static void main(String args[]){
		stack s=new stack();
		for(int i=1;i<10;i++){
			s.push(i);
		}
		s.display();
		System.out.println("After pushing one element::");
		s.push(15);
		System.out.println("Pop The Element::");
		s.pop();
		s.display();
		System.out.println("Push The Element::");
		s.push(15);
		s.display();
		System.out.println("Search The Element::");
		s.search(15);
	}

}
