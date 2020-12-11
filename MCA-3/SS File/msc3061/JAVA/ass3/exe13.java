class game{
	void show(){
		System.out.println("IT'S A PARENT CLASS::GAME");
	}
}	
class cricket extends game{
	void show(){
		System.out.println("IT'S A CHILD CLASS CRICKET WHICH DERIVED FROM PARENT CLASS GAME");
	}
}
class tabletennis extends game{
	void show(){
		System.out.println("IT'S A CHILD CLASS TABLE TENNIS WHICH DERIVED FROM PARENT CLASS GAME");
	}
}
class exe13{
	public static void main(String args[]){
		game g=new game();
		cricket c=new cricket();
		tabletennis t=new tabletennis();
		g.show();
		c.show();
		t.show();
	}
}