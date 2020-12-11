class exe6{
	public static void main(String args[]){
		int a[]={50,20,10,30,40,60,80,70,90,100};
		for(int i=0;i<10;i++){
			for(int j=0;j<9;j++){
				if(a[j]>a[j+1]){
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
		System.out.println("The Values After Sorting Is::");
		for(int i=0;i<10;i++){
			System.out.println(a[i]+" ");
		}


	}

}