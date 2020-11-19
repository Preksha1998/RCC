import java.util.Scanner;

class inventory {
    int item_id ;
    String name ;
    double price ;
    inventory(){

    }
}

class bill_item extends inventory{
    int quantity ; 
    double amount ;

    public void get_data(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter item id :");
        item_id = sc.nextInt();
        System.out.println("ENter name of the product :");
        name = sc.next();
        System.out.println("Enter the price of the product :");
        price = sc.nextDouble();
        System.out.println("Enter the quantity of the product :");
        quantity = sc.nextInt();

    }

    public void calculate_amount(){
        amount = (quantity * price );
    }

    public void generate_bill(){
        System.out.print(item_id + "\t\t" );
        System.out.print(name+ "\t"  );
        System.out.print(price + "\t" );
        System.out.print(quantity + "\t\t" );
        System.out.print(amount+ "\t" );

    }
}

public class a2_p11_a{
    public static void main(String args[]){
        int i = 0;
        bill_item[] b1 = new bill_item[10];
        for(i = 0 ; i < 2 ;i++){
            b1[i] = new bill_item();
            b1[i].get_data();
            b1[i].calculate_amount();
        }
        
        System.out.println("Item id " + "\t" + "Name" +   "\t" + "Price"  + "\t" + "Quantity" + "\t" + "Amount" ) ;
        for(i = 0 ; i < 2 ;i++){
            b1[i].generate_bill();
            System.out.println();
        }
    }
}
