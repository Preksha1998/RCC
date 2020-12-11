class sample{
	void display(){
		System.out.println("DISPLAY FROM OUTER CLASS");
	}
	static class innerclass{
		void show(){
		System.out.println("DISPLAY FROM INNER STATIC CLASS");
		}
	}
}
class exe9{
	public static void main(String args[]){
	sample s=new sample();
	s.display();
	sample.innerclass i=new sample.innerclass();
	i.show();
	}
}