/*
 * Name:		Celena Williams
 * Asignment:	Program 5
 * Class:		CSCE 146
 * Semester:	Spring 2015
 * School:		USC Sumter
 */

import java.util.Scanner;

public class Homework5WilliamsCelena {
    private static int intArray [] = new int [10];

    public static void main (String [] args) {
        @SuppressWarnings("resource")
        Scanner scan = new Scanner (System.in);

        System.out.println ("Please enter 10 integers, followed by enter:");

        for (int i = 0; i < intArray.length; i++) {
            intArray [i] = scan.nextInt ();//creates an array ofinput values
        }//END for (int i = 0; i < intArray.length; i++)

        for (int i = 0; i < intArray.length; i++) {
            if (i != intArray.length - 1)
                System.out.print (intArray [i] + ", ");
            else
                System.out.print (intArray [i] + ".");
        }//END for (int i = 0; i < intArray.length; i++)

        System.out.println ("Your numbers are sorted using: Selection Sorting");

        for (int i = 0; i < intArray.length; i++) {
            if (i != intArray.length - 1)
                System.out.print (Sort.selectionSort (intArray, 10) [i] + ", ");
            else
                System.out.print (Sort.selectionSort (intArray, 10) [i] + ".");
        }//END for (int i = 0; i < intArray.length; i++)
    }//END public static void main (String [] args)
}//END public class Homework5WilliamsCelena