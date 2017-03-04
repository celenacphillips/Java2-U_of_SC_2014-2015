/*
 * Name:		Celena Williams
 * Asignment:   Program 5
 * Class:		CSCE 146
 * Semester:    Spring 2015
 * School:		USC Sumter
 */

public class Sort {	
    public static int [] selectionSort (int newArray [], int sorted) {
        //starts the sorting at the end
        for (int i = sorted; i > 1; i--) {
            int largestIndex = 0;

            //starts the checking at the beginning
            for (int j = 1; j < i; j++) {
                if (newArray [j] > newArray [largestIndex])
                    largestIndex = j;
            }//END for (int j = 1; j < i; j++)

            //creates a temp value to store values while sorting
            int temp = newArray [i - 1];
            newArray [i - 1] = newArray [largestIndex];//swaps the values
            newArray [largestIndex] = temp;//reassigns the value of temp

            sorted--;
            selectionSort (newArray, sorted);
        }//END for (int i = sorted; i > 1; i--)
        return newArray;
    }//END public static int [] selectionSort (int newArray [], int sorted)
}//END public class Sort