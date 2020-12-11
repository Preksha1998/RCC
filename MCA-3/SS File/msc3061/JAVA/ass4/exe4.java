abstract class Animal{
	String Animalname,Animaltype,Animalsound;
	Animal(String a,String t,String s){
		Animalname=a;
		Animaltype=t;
		Animalsound=s;
	}
	abstract void display();

}
class Wild extends Animal{
	Wild(String a,String t,String s){
		super(a,t,s);
	}
	void display(){

		System.out.println("Animal's Name Is::"+Animalname);
		System.out.println("Animal's Type Is::"+Animaltype);
		System.out.println("Animal's Sound Is::"+Animalsound);
	}
}
class Domestic extends Animal{
	Domestic(String a,String t,String s){
		super(a,t,s);
	}
	void display(){

		System.out.println("Animal's Name Is::"+Animalname);
		System.out.println("Animal's Type Is::"+Animaltype);
		System.out.println("Animal's Sound Is::"+Animalsound);
	}
}
class exe4{
	public static void main(String args[]){
		Wild w=new Wild("TIGER","WILD","ROAR");
		w.display();
		Domestic d=new Domestic("DOG","DOMESTIC","BARK");
		d.display();
	}

}