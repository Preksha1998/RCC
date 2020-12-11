interface events{
	void musicEvents();
	void danceEvents();
}
class music implements events{
	public void musicEvents(){
		System.out.println("INSIDE THE MUSIC EVENTS");
	}
	public void danceEvents(){};
}
class dance implements events{
	public void musicEvents(){};
	public void danceEvents(){
		System.out.println("INSIDE THE DANCE EVENTS");
	}
	
}
class exe6{
	public static void main(String argsp[]){
		music m=new music();
		dance d=new dance();
		System.out.println("FOR MUSIC CLASS::");
		m.musicEvents();
		m.danceEvents();
		System.out.println("FOR DANCE CLASS::");
		d.musicEvents();
		d.danceEvents();
	}
}