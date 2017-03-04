/*
 * Name:		Celena Williams
 * Asignment:   Program 4
 * Class:		CSCE 146
 * Semester:    Spring 2015
 * School:		USC Sumter
 */

public class BinarySearch {
    private int collection [] = new int [20];
    int target, mid, midMod, middle, index = 0;

    public BinarySearch () {
    }//END public BinarySearch ()

    public BinarySearch (int newArray [], int newTarget) {
        for (int i = 0; i < newArray.length; i++) {
            //sets all of collection equal to all of the new array
            collection [i] = newArray [i];
        }//END for (int i = 0; i < newArray.length; i++)

        target = newTarget;//sets the target

        //sends the first and last indices
        recursiveBinarySearch (0, collection.length - 1);
    }//END public BinarySearch (int newArray [], int newTarget)

    public void recursiveBinarySearch (int first, int last) {
        midMod = (first + last) % 2;

        if (midMod == 0)
            mid = (first + last) / 2;//creates the middle index
        else
            mid = (first + last + 1) / 2;//creates the middle index

        middle = collection [mid];//creates the middle value

        System.out.println ("first: " + collection [first] + " last: " + 
                            collection [last]);

        if (target == middle)
                index = mid;
        else {	
            //modifies the non-terminal portion of the array
            if (target < middle)
                recursiveBinarySearch (first, mid);
            if (target >  middle)
                recursiveBinarySearch (mid, last);
        }//END else
    }//END public void recursiveBinarySearch (int first, int last)
}//END public class BinarySearch