class p1_c{
	public static void main(String args[]){
		int i= 2;
		System.out.print("Prime Numbers : ");
		do{
			int j = 2;
			while(j <= i)
			{
				if(i % j == 0)
				{
					break;
				}
				j++;
			}
			if(i == j)
			{
				System.out.print(i + "  ");
			}
			i++;
		}while(i <= 50);
	}
}