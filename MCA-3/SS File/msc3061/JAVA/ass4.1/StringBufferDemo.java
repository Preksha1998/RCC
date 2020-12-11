class StringBufferDemo{
	public static void main(String args[]){
		StringBuffer sb1=new StringBuffer("core java");
		System.out.println(" " +sb1);
		StringBuffer sb2=new StringBuffer();
		System.out.println(" " +sb2.capacity()+" "+sb2.length());
		String s1="hetvee";
		System.out.println(" "+sb2.append(s1).append(" shah"));		
		
	}
}