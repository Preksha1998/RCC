import java.time.*;
//import java.time.ZonedDateTime;  
public class ZonedDateTimeExample{  
  public static void main(String[] args) {  
    ZonedDateTime zone =ZonedDateTime.now();  
		System.out.println(zone.getZone());  
  }   
}  
