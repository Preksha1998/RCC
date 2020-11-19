import java.util.*;

class LuckyStars {
	public static void main(String[] args) {
		
	String[] stars = {
		"Robert Redford"  , "Marilyn Monroe", "Boris Karloff"   , "Lassie", "Hopalong Cassidy", "Trigger"		
	};
	
	System.out.println("Your Luckey Stars for today is " + stars[(int)(stars.length * Math.random())]);
		
	}
}