interface vehicle{
	void displaytype();
	void displaymodel();
	void displaymilege();
}
class two_wheeler implements vehicle{
	String model;
	double milege;
	two_wheeler(String model,double milege){
		this.model=model;
		this.milege=milege;
	}
	public void displaytype(){
		System.out.println("IT'S TWO-WHEELER CLASS");
	}
	public void displaymodel(){
		System.out.println("THE MODEL IS::"+model);
	} 
	public void displaymilege(){
		System.out.println("THE MILEGE IS::"+milege+"kmph");
	} 
}
class four_wheeler implements vehicle{
	String model;
	double milege;
	four_wheeler(String model,double milege){
		this.model=model;
		this.milege=milege;
	}
	public void displaytype(){
		System.out.println("IT'S FOUR-WHEELER CLASS");
	}
	public void displaymodel(){
		System.out.println("THE MODEL IS::"+model);
	} 
	public void displaymilege(){
		System.out.println("THE MILEGE IS::"+milege+"kmph");
	} 
}
class exe5{
	public static void main(String args[]){
		two_wheeler t=new two_wheeler("ACTIVA 3G",100);
		t.displaytype();
		t.displaymodel();
		t.displaymilege();
		System.out.println("----------------------------");
		four_wheeler f=new four_wheeler("FORD FIGO",200);
		f.displaytype();
		f.displaymodel();
		f.displaymilege();
	}
}