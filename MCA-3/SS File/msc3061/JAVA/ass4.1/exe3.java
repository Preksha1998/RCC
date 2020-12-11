abstract class shop{
	String item;
	double price,qty;
	shop(String a,double p,double q){
		item=a;
		price=p;
		qty=q;
	}
	abstract void show_bill();

}
class counter_shop extends shop{
	counter_shop(String a,double p,double q){
		super(a,p,q);
	}
	void show_bill(){
	double total;
	total=price*qty;
	System.out.println("ITEM'S NAME IS::"+item);
	System.out.println("ITEM'S PRICE IS::"+price);
	System.out.println("ITEM'S QUANTITY IS::"+qty);
	System.out.println("ITEM'S TOTAL IS::"+total);
	}
}
class exe3{
	public static void main(String args[]){
		counter_shop c=new counter_shop("BABYLIPS",200,10);
		c.show_bill();
	}
}