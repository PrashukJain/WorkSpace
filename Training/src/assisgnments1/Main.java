package assisgnments1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
//Step 1:- Get object of ItemDetail from INputReader
        // @step:- Caclculatetax.
        // Step3:-print details
        /**
         * input format: name,type,price,quantity
         */

        Scanner scn = new Scanner(System.in);
        char ch;
        do {
            InputReader input = new InputReader();
            input.startReader(args);

            System.out.println("Do you want to enter details of any other item (y/n):");
            ch = scn.next().charAt(0);

        } while (ch == 'y');
        System.out.println("thanks");
    }

}
