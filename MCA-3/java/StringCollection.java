import java.util.*;

class StringCollection {
	public static void main(String[] args) {
		
		String phrase = "The Quick";
		int vowels = 0;
		
		
		for(char ch : phrase.toCharArray())
		{
			ch = Character.toLowerCase(ch);
			if( ch== 'a' || ch== 'e' || ch== 'i' || ch== 'o' || ch== 'u')
			{
				++vowels;
				
			}	
		}
System.out.println("The Phrase contains " + vowels + " vowels.");				
		
	}
}