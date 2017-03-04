/*
 * Name:		Celena Williams
 * Assignment:  Program 7
 * Semester:    Spring 2015
 * School:		USC Sumter
 * Class:		CSCE 146
 */

import java.util.Scanner;

public class Homework7WilliamsCelena {
    private static int intArray [] = new int [10];

    public static void main (String [] args) {
        @SuppressWarnings("resource")
        Scanner scan = new Scanner (System.in);

        System.out.println ("Please enter 10 integers, followed by enter:");

        for (int i = 0; i < intArray.length; i++) {
            //creates an array of the input values
            intArray [i] = scan.nextInt ();
        }//END for (int i = 0; i < intArray.length; i++)

        for (int i = 0; i < intArray.length; i++) {
            if (i != intArray.length - 1)
                System.out.print (intArray [i] + ", ");//prints the values
            else
                System.out.print (intArray [i] + ".\n");//prints the values
        }//END for (int i = 0; i < intArray.length; i++)

        System.out.println ("Your numbers are sorted using: Quick Sorting");

        intArray = Sort.quickSort(intArray, 0, intArray.length-1, "full array");

        for (int i = 0; i < intArray.length; i++) {
            if (i != intArray.length - 1)
                System.out.print (intArray [i] + ", ");//prints values sorted 
            else
                System.out.print (intArray [i] + ".");//prints  values sorted
        }//END for (int i = 0; i < intArray.length; i++)
    }//END public static void main (String [] args)
}//END public class Homework7WilliamsCelena