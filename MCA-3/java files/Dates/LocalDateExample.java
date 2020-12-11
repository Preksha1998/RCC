import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;

public class LocalDateExample {

	public static void main(String[] args) {
		
		//Current Date
		LocalDate today = LocalDate.now();
		System.out.println("Current Date="+today);
		
		//Creating LocalDate by providing input arguments
		LocalDate firstDay_2017 = LocalDate.of(2017, Month.JANUARY, 1);
		System.out.println("Specific Date =  " +firstDay_2017);
		
		
		//Try creating date by providing invalid inputs
		//LocalDate feb29_2017 = LocalDate.of(2017, Month.FEBRUARY, 29);
		//System.out.println("Feb Date =  " +feb29_2017);
		//Exception in thread "main" java.time.DateTimeException: 
		//Invalid date 'February 29' as '2017' is not a leap year
		
		//Current date in "Asia/Kolkata", you can get it from ZoneId javadoc
		LocalDate todayKolkata = LocalDate.now(ZoneId.of("Asia/Kolkata"));
		System.out.println("Current Date in IST = " +todayKolkata);

		//java.time.zone.ZoneRulesException: Unknown time-zone ID: IST
		//LocalDate todayIST = LocalDate.now(ZoneId.of("IST"));
		
		//Getting date from the base date i.e 01/01/1970
		LocalDate dateFromBase = LocalDate.ofEpochDay(365);
		System.out.println("365th day from base date= "+dateFromBase);
		
		LocalDate hundredDay2017 = LocalDate.ofYearDay(2017, 100);
		System.out.println("100th day of 2017="+hundredDay2017);
	}
}