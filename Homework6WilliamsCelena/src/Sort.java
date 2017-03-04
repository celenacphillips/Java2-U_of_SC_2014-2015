/*
 * Name:		Celena Williams
 * Assignment:  Program 6
 * Semester:    Spring 2015
 * School:		USC Sumter
 * Class:		CSCE 146
 */

public class Sort {
    public static int [] insertionSort (int newArray [], int sorted, 
                                        int length) {
        //keeps the searching within the array
        while (sorted < length) {
            int target = newArray [sorted];//setstarget to current index
            int i;//allows i to have a larger scope than for loop

            //starts searching 1 less than sorted value
            for (i = sorted - 1; i > -1 && newArray [i] > target; i--) {
                newArray [i + 1] = newArray [i];
                //reassigns values from the greater index to the lesser index
            }//END for (i = sorted - 1; i > -1 && newArray [i] > target; i--)
            //reassigns the value of target before the recursive call
            newArray [i + 1] = target;

            sorted++;//increments the sorted value

            insertionSort (newArray, sorted, length);
        }//END while (sorted < length)
        return newArray;
    }//END public static int [] insertionSort (int...length)
}//END public class Sort