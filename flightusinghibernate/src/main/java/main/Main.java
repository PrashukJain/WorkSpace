package main;

import java.util.Scanner;

import input.UserInput;
import reader.FlightReader;
import reader.InputReader;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        char ch;
        // Thread thread = new Thread(new FileBackGroundThread());
        // thread.start();

        do {
            UserInput input = new InputReader().takeInput();
            FlightReader.readfile();
            // new ResultFinder().output(input);
            System.out.println("Want to Search more Flight ?(Y/N)");
            ch = scn.next().charAt(0);
        } while (ch != 'n' && ch != 'N');

    }

}
