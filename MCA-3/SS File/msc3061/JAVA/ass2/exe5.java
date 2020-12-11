class queue{
	int a[]=new int[10];
	static int f=-1;
	static int r=-1;
	void insert(int x){
		r++;
		if(r>9){
			System.out.println("QUEUE OVERFLOW");
		}
		else{
			if(r==0){
				f++;
			}
		a[r]=x;
		System.out.println("Successfully Inserted The Element");
		}
	}
	void delete(){
		if(f==-1){
			System.out.println("QUEUE UNDERFLOW");
		}
		else{
			System.out.println(a[f]+"::Is Deleted From Queue");
			a[f++]=0;
		}

	}
	void display(){
		if(f==-1){
			System.out.println("Queue Is Empty");
		}
		else{
			for(int j=f;j<=r;j++){
				System.out.println(" "+a[j]);
			}
		}
	}
	void search(int s){
		int x=0;
		if(f==-1){
			System.out.println("Queue Is Empty");
		}
		else{
			for(int j=f;j<=r;j++){
				if(a[j]==s){
					System.out.println("Element Found::"+s);
					x=1;
					break;
				}
			}
		if(x==0){
			System.out.println("Element Not Found::"+s);
		}
	   }
	}
}
class exe5{
	public static void main(String args[]){
	queue q=new queue();
	q.insert(5);
	q.display();
	q.insert(10);
	q.display();
	q.insert(20);
	q.display();
	q.insert(30);
	q.display();
	q.insert(40);
	q.display();
	q.delete();
	q.display();
	q.delete();
	q.display();
	q.search(30);
	q.search(50);
	}
		
}