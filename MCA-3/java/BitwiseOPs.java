import static java.lang.Integer.toBinaryString;
public class BitWiseOPs{
	public static void main(String[] args) {
		int indecators = 0xFF07 ;
		int selectBit3 = 0x4; //MAsk to select the 3rd bit 

		//Try bitwise AND to select the 3rd bit in indecators 

		System.out.println("indecators 		=" + toBinaryString(indecators));
		System.out.println("selectBit3 		=" + toBinaryString(selectBit3));

		indecators &= selectBit3 ; 

		System.out.println("indecators &= selectBit3		=" + toBinaryString(indecators));

		// Try the bitwise OR to switch the third bit on

		indecators = 0xFF09;

		System.out.println("indecators 		=" + toBinaryString(indecators));
		System.out.println("selectBit3 		=" + toBinaryString(selectBit3));

		indecators |= selectBit3 ; 

		System.out.println("indecators &= selectBit3		=" + toBinaryString(indecators));

		//Now switch the 3rd bit off again

		indecators &= ~selectBit3 ;

		System.out.println("\nThe third bit in the previous value of indicators" + " has been switched off");
		System.out.println("indicators & ~selectBit3 = " + toBinaryString(indecators));

	}
}