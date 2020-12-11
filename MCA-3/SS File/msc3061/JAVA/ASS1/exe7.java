class exe7{
	public static void main(String args[]){
		int steps=7,i=0,j=1,sum=0;
		System.out.println("Fibonaki is::");
		while(steps>0){
			System.out.println(sum+"");
			sum=i+j;
			j=i;
			i=sum;
			steps--;
		}
	}

}