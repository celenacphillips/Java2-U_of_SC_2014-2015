/*
 * Name:		Celena Williams
 * Assignment:  Program 3
 * Class:		CSCE 146
 * Semester:    Spring 2015
 * School:		USC Sumter
 */

public class QueueProgram {
    private QueueProgram successor, predecessor;
    private static boolean fixedCapacity;
    private static int capacity, size = 0;
    private int element;

    //creates the unlimited queue nodes
    public QueueProgram () {
        capacity = size;
        fixedCapacity = false;
        this.element = 0;
    }//END public QueueProgram ()

    //creates the limited queue nodes
    public QueueProgram (int theCapacity) {
        capacity = theCapacity;
        fixedCapacity = true;
        this.element = 0;
    }//END public QueueProgram (int theCapacity)

    //sets the predecessor
    public void setPredecessor (QueueProgram newPredecessor) {
        this.predecessor = newPredecessor;
    }//END public void setPredecessor (QueueProgram newPredecessor)

    //sets the successor
    public void setSuccessor (QueueProgram newSuccessor) {
        this.successor = newSuccessor;
    }//END public void setSuccessor (QueueProgram newSuccessor)

    //sets the size, depending on the style of queue
    public static void setSize (int newSize) {
        if (getFixedCapacity ())
            size = newSize;
        else {
            size = newSize;
            capacity = newSize;
        }//END else
    }//END public static void setSize (int newSize)

    //sets the element
    public void setElement (int newElement) {
        this.element = newElement;
    }//END public void setElement (int newElement)

    //gets the predecessor
    public QueueProgram getPredecessor () {
        return this.predecessor;
    }//END public QueueProgram getPredecessor ()

    //gets the successor
    public QueueProgram getSuccessor () {
        return this.successor;
    }//END public QueueProgram getSuccessor ()

    //gets the fixed capacity
    public static boolean getFixedCapacity () {
        return fixedCapacity;
    }//END public static boolean getFixedCapacity ()

    //gets the capacity
    public static int getCapacity () {
        return capacity;
    }//END public static int getCapacity ()

    //gets the size
    public static int getSize () {
        return size;
    }//END public static int getSize ()

    //gets the element
    public int getElement () {
        return this.element;
    }//END public int getElement ()
}//END public class QueueProgram