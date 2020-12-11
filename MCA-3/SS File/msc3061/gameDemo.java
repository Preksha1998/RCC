class game{
	void gametype(){
		System.out.println("Games Are Indoor And Outdoor");
	}

}
class cricket extends game{
	void gametype(){
		System.out.println("Cricket Is Outdoor Game");
	}

}
class gameDemo{
	public static void main(String args[]){
		game g=new game();
		game g1=new cricket();
		g.gametype();
		g1.gametype();
	}

}