package assignments;
import java.util.Scanner;
public class EffectiveCostClient {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner scn=new Scanner(System.in);
char ch;
do{
//String name=scn.next();
////scn.nextLine();
//String type=scn.next();
//int price=scn.nextInt();
//int quantity = scn.nextInt();
EffectiveCost ef = new EffectiveCost();


//System.out.println("Do you want to enter details of any other item (y/n):");
ch=scn.next().charAt(0);
}while(ch=='y');
	}


}


class EffectiveCost {
    String name;
    String type;
    double price;
    double quantity;
    Scanner scn = new Scanner(System.in);
    public EffectiveCost() {
        name = scn.next();
        type = scn.next();
        price = scn.nextDouble();
        quantity = scn.nextDouble();

//        System.out.println(name + " " + type + " " + price + " " + quantity);
    }

    public void tax() throws Exception {
        if (price < 0) {
            throw new Exception("price cannot be negative");
        }
        if (type.equals("Raw")) {

    }
    else if (type.equals("Manufactured")) {

    } else if (type.equals("Imported")) {

    } else {
        throw new Exception("Wrong type input");
    }
    }

    private double raw(double price) {

        return (12.5 * price) / 100;
    }

    private double manufactured(int price) {
        double tax_12point5 = raw(price);
        return tax_12point5 + .02 * (price + tax_12point5);
    }

    private double Imported(int price) {
return 
    }
}

   
   

