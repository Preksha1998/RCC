class threeDArray{
	public static void main(String args[]){
		int arr[][][] = {{
							{2,7,9},
							{3,6,1},
							{7,4,2} },
					   {
					  		{1,2,3},
					  		{4,5,6},
					  		{7,8,9} }, 
					  };

		for(int i = 0; i < 2; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				for(int k = 0; k < 3; k++)
				{
					System.out.print(arr[i][j][k] + "  ");
				}
			}
			System.out.println();
		}
	}
}