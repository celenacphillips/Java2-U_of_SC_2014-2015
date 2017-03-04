/*
 * Name:		Celena Williams
 * Assignment:  Program 7
 * Semester:    Spring 2015
 * School:		USC Sumter
 * Class:		CSCE 146
 */

public class Sort {
    public static int [] quickSort (int newArray [], int first, int last, 
                                    String message) {
        System.out.print ("\nNew call.\t");
        System.out.println (message);

        if (first >= last)//if the array is already sorted
            return newArray;

        int pivot = newArray [first];

        boolean found = false;
        int leftIndex = first, rightIndex = last;

        //checks for the smallest and largest values
        for (int i = first + 1; i < last && leftIndex <= rightIndex; i++) {		
            found = false;
            for (int j = leftIndex; j <= last && !found; j++) {
                if (newArray [j] > pivot) {
                    leftIndex = j;
                    found = true;
                }//END if (newArray [j] > pivot)
            }//END for (int j = leftIndex; j <= last && !found; j++)

            found = false;			
            for (int j = last; j >= first && !found; j--) {
                if (newArray [j] < pivot) {
                    rightIndex = j; 
                    found = true;
                }//END if (newArray [j] < pivot)
            }//END for (int j = last; j >= first && !found; j--)

            System.out.print ("Pre switch\t\t");
            for (int k = 0; k <= last; k++) {
                if (k != last)
                    System.out.print (newArray [k] + ", "); 
                else {
                    System.out.print (newArray [k] + ".");
                    System.out.print ("  leftIndex -> " + leftIndex);
                    System.out.print ("  rightIndex -> " + rightIndex + "\n");
                }//END else
            }//END for (int k = 0; k <= last; k++)

            System.out.print ("  !leftIndex -> " + leftIndex);
            System.out.print ("  !rightIndex -> " + rightIndex + "\n");

            if (leftIndex < rightIndex) {
                //switches the smallest and largest values
                int temp = newArray [leftIndex];
                newArray [leftIndex] = newArray [rightIndex];
                newArray [rightIndex] = temp;
            }//END if (leftIndex < rightIndex)

            System.out.print ("Post switch\t\t");
            for (int k = 0; k <= last; k++) {
                if (k != last)
                    System.out.print (newArray [k] + ", "); 
                else {
                    System.out.print (newArray [k] + ".");
                    System.out.print ("  leftIndex -> " + leftIndex);
                    System.out.print ("  rightIndex -> " + rightIndex + "\n");
                }//END else
            }//END for (int k = 0; k <= last; k++)
        }//END for (int i = first + 1; i < last && leftIndex <= rightIndex; i++)

        //switches the pivot and the rightIndex
        int temp = newArray [first];
        newArray [first] = newArray [rightIndex];
        newArray [rightIndex] = temp;

        System.out.print ("PIVOT SWITCH\t\t");
        for (int k = 0; k < newArray.length; k++) {
            if (k != newArray.length - 1)
                System.out.print (newArray [k] + ", "); 
            else
                System.out.print (newArray [k] + ".\n");
        }//END for (int k = 0; k < newArray.length; k++)

        quickSort (newArray, first, rightIndex - 1, "first part of the array");
        quickSort (newArray, rightIndex + 1, last, "last part of the array");

        return newArray;
    }//END  public static int [] quickSort (int....message)
}//END public class Sort