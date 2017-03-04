/*
 * Name:		Celena Williams
 * Assignment:  Program 2
 * Class:		CSCE 146
 * Semester:    Spring 2015
 * School:		USC Sumter
 */

public class StackProgram {
    private static int size;
    private int element;
    private StackProgram predecessor;

    public StackProgram () {
        this.element = 0;
        this.predecessor = null;
    }//END public StackProgram ()

    public StackProgram (StackProgram thePredecessor, int theElement) {
        this.predecessor = thePredecessor;
        this.element = theElement;
    }//END public StackProgram (StackProgram thePredecessor, int theElement)

    public StackProgram getPredecessor () {
        return this.predecessor;
    }//END public StackProgram getPredecessor ()

    public void setPredecessor (StackProgram newPredecessor) {
        this.predecessor = newPredecessor;
    }//END public void setPredecessor (StackProgram newPredecessor)

    public static int getSize () {
        if (size < 0)
            size = 0;

        return size;
    }//END public static int getSize ()

    public static void setSize (int number) {
        size = number;
    }//END public static void setSize (int number)

    public int getElement () {
        return this.element;
    }//END public int getElement ()

    public void setElement (int theElement) {
        this.element = theElement;
    }//END public void setElement (int theElement)
}//END public class StackProgram