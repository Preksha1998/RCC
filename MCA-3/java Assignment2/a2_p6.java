import java.util.Scanner ;

public class a2_p6 {
    public static void main(String[] args) {
        double dis_m ;
        double dis_km;
        double dis_mile;
        int hr; 
        int min;
        int sec;
        int t_m;
        int t_s;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Distance in meter : ");
        dis_m = sc.nextDouble();

        dis_km = dis_m / 1000 ;
        dis_mile = dis_m / 1609;

        
        System.out.println("Distance in meter =  " + dis_m);
        System.out.println("Distance in k_m = " + dis_km);
        System.out.println("Distance in mile =  " + dis_mile);
        

        System.out.println("Enter Hours : ");
        hr = sc.nextInt();
        System.out.println("Enter Minutes : ");
        min = sc.nextInt();
        System.out.println("Enter Seconds : ");
        sec = sc.nextInt();

        t_m = (hr*60) + min ;
        t_s = (t_m * 60)+ sec ;

        System.out.println("The Speed in m/sec is : "  + dis_m / t_s);
        System.out.println("The Speed in km/hr is : " + dis_km / hr);
        System.out.println("The Speed in mile/hr is : " + dis_mile /hr);




    }
}
