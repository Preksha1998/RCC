final class game{
	final int i=10;
	
	final void gametype(){
		
		
		System.out.println("Call Of Final Mehod From Final Class");
		System.out.println("AFTER INCREMENT VALUE OF FINAL VARIABLE IS::"+i);
	}
}
class exe15{
	public static void main(String args[]){
		game g=new game();
		g.gametype();
	}
}