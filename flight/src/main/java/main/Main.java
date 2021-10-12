package main;

import java.io.IOException;
import java.util.Scanner;

import input.UserInput;
import output.ResultFinder;
import reader.InputReader;
import thread.FileBackGroundThread;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scn = new Scanner(System.in);
        char ch;
        Thread thread = new Thread(new FileBackGroundThread());
        thread.start();
        do {
            UserInput input = new InputReader().takeInput();
            new ResultFinder().output(input);
            System.out.println("Want to Search more Flight ?(Y/N)");
            ch = scn.next().charAt(0);
        } while (ch != 'n' && ch != 'N');

    }

}
