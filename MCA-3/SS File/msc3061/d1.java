class game{
	int i;
	game(){
		System.out.println("Parent Class");
	}
	void gametype(){
		System.out.println("Game Are outdoor and indoor");
	}

}
class cricket extends game{
	int i;
	
	
	void gametype(){
		super.i=10;
		
		System.out.println("cricket is outdoor game"+super.i);
	}


}
class d1{

	public static void main(String args[]){
		game g=new game();
		game c=new cricket();
		g.gametype();
		c.gametype();
	}
}