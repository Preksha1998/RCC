class cldemo{
	public static void main(String[] args){
		System.out.println("There are " + args.length + "command -line arg.");
		System.out.println("They are :");
		for(int i = 0; i < args.length; i++)
		System.out.println("arg [" + i + "] i : " + args[i]);
	}
}