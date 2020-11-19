public class letterCheck{
	public static void main(String[] args){
		char symbol = 'A';
		symbol = (char) (128.0*math.random());

		if(symbol >= 'A'){
			if(symbol <= 'Z'){
				System.out.println("Yo have capital letter "+symbol);
			} else {
				if(symbol >= 'a'){
					if(symbol <= 'z'){
						System.out.println("You have small letter "+symbol);
					}
				}
				else{
					System.out.println("code is greater than a but not a letter");
				}
			}else{
				System.out.println("code is less than a but not letter");
			}
		}
	} else{
		System.out.println("Code is less than A so its not a letter");
	}
}