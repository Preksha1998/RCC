import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class default_cal{
	public static void main(String args[]){
		System.out.println(Locale.getDefault());
		Date now = Calendar.getTime();
	}
}