package src;

import java.util.ArrayList;
import java.util.Scanner;

import Details.InputReader;
import Details.Item;
import Details.TaxCalculation;
import Output.ConsoleOutputPrinter;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        char ch;
        ArrayList<Item> listofItem = new ArrayList<>();
        do {

            InputReader input = new InputReader();
            Item item = input.startReader(args);
            new TaxCalculation().typeTax(item);
            listofItem.add(item);
            System.out.println("Do you want to enter details of any other item (y/n):");
            ch = scn.next().charAt(0);
            args = null;
        } while (ch == 'y' || ch == 'Y');
        for (Item item : listofItem)
            new ConsoleOutputPrinter().toString(item);
        System.out.println("thanks");
    }

}
