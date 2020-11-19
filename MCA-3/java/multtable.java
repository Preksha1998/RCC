class multtable{
	public static void main(String[] args){
		int i;
		int no = Integer.parseInt(args[0]);
		for(i = 1; i <= 10; i++)
		{
			System.out.println(no + " * " + i + " = " +no*i);
		}
	}
}