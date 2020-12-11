class sample{
	static int i=10;
	void display(){
		i++;
		System.out.println("STATIC DATA MEMBER IS CALLED::"+i);
	}
}
class exe6{
	public static void main(String args[]){
		sample s=new sample();
		s.display();
		System.out.println("VALUE OF STATIC DATA MEMBER FROM MAIN::"+sample.i);
				
	}

}