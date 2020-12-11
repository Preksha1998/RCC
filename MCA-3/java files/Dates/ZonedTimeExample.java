import java.time.ZonedDateTime;  
   public class ZonedTimeExample{  
      public static void main(String[] args) {  
        ZonedDateTime zone =ZonedDateTime.now();  
        System.out.println(zone.getZone());  
      }   
    }  