class exe21{
	public static void main(String args[]){
		int a[]={50,20,10,30,40,60,80,70,90,100};
		int sum=0;
		int num=20,flag=0;
		double avg;
		for(int i=0;i<10;i++){
			sum+=a[i];
		}
		System.out.println("The Sum Is::"+sum+"");
		avg=sum/10;
		System.out.println("The Average Is::"+avg);
		for(int i=0;i<10;i++){
			if(num==a[i]){
				System.out.println("The Number Is Present"+num);
				flag=1;
				break;
			}
		}
		if(flag==0){
			System.out.println("The Number Is Not Present"+num);
		}
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