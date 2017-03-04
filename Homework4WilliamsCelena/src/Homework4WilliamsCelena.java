/*
 * Name:		Celena Williams
 * Asignment:   Program 4
 * Class:		CSCE 146
 * Semester:    Spring 2015
 * School:		USC Sumter
 */

import java.util.Scanner;

public class Homework4WilliamsCelena {	
    public static void main (String [] args) {
        @SuppressWarnings("resource")
        Scanner scan = new Scanner (System.in);

        System.out.println ("Enter a value to search for: ");

        //creates an integer array with the values
        int intArray [] =  {	0,	5,	10,	15,	20,
                                25,	30,	35,	40,	45,
                                50,	55,	60,	65,	70,
                                75,	80,	85,	90,	95};

        BinarySearch search = new BinarySearch (intArray, scan.nextInt ());

        System.out.println ("The value " + search.target + " is at index " + 
                            search.index + ".");
    }//END public static void main (String [] args)
}//END public class Homework4WilliamsCelena