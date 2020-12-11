class SSTAB{
	int symbolIndex;
	static int count = 0;
	
	void insert(int index){
		symbolIndex = index;
		count++;
	}
	
	void display(){
		System.out.println(symbolIndex);
	}
}