//import java.util.Locale; 
import java.util.Calendar; 
import java.util.GregorianCalendar;
import java.util.Locale;

public class Default { 
  public static void main(String[] args) { 
    //System.out.println(Locale.getDefault()); 
	//Date now = Calendar.getTime();
	
	GregorianCalendar c1 = new GregorianCalendar(1998, Calendar.MARCH, 10);
	
	//LocalDate today = LocalDate.now();
	
	//System.out.println("Today's Local date : " + now);
	System.out.println("Today's Calendar : " + c1);

  } 
} 