public class bitwise_operator{
	public static void main(String[] args){
		int a = 58;//111010
		int b = 13;//1101
		System.out.println(a & b );//8 = 1000
		System.out.println(a | b);//63=111111
		System.out.println(a ^ b );//55=11011
		System.out.println(~a);//-59
		System.out.println(a<<2);//232 = 11101000
		System.out.println(a>>2);//14 = 1110
		System.out.println(a>>>2);//14 
	}
}