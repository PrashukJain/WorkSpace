package main;

import java.io.IOException;
import java.util.Scanner;

public class main {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

//Step1: Take Input


		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		char ch;
		do {
			flightDetails object = new objectCreator().takeInput();
			controller control = new controller();
			control.readfile("AirIndia", object);
			control.readfile("indigo", object);
			control.readfile("JetAir", object);
			control.printer();
			control.typeofsort();
			control.printer();

			ch = scn.next().charAt(0);
		} while (ch != 'n');
		

//		
// file reading part // Build reader instance
//		CSVReader reader = new CSVReader(new FileReader("D:\\files\\AirIndia.csv"), '|', '"', 1);
//
//		String[] nextLine;
//		ArrayList<ArrayList<String>> arr = new ArrayList();
//		while ((nextLine = reader.readNext()) != null) {
//			ArrayList<String> newEntry = new ArrayList();
//			int firstindex = 0;
//			for (int i = 0; i < nextLine[0].length(); i++) {
//				char ch = nextLine[0].charAt(i);
//				if (ch != '|')
//					continue;
//				else {
//					newEntry.add(nextLine[0].substring(firstindex, i));
//					System.out.println(nextLine[0].substring(firstindex, i));
//					firstindex = i + 1;
//				}
//			}
//		}

	}

}
