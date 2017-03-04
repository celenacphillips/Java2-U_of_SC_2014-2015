 /*
 * Name:		Celena Williams
 * Assignment:  Homework1
 * Class:		CSCE 146
 * Semester:    Spring 2015
 * School:		USC Sumter
 * Date:		February 26, 2015
 */

public class DoublyLinkedList {
    private int element, index;
    private static int size;
    private DoublyLinkedList predecessor, successor;

    //template for all nodes
    public DoublyLinkedList () {
        this.element = 0;
        this.predecessor = null;
        this.successor = null;
        this.index = 0;
        size = 0;
    }//END public DoublyLinkedList ()

    //creates the nodes, FOR HEAD AND TAIL ONLY
    public DoublyLinkedList (DoublyLinkedList thePredecessor, 
                             DoublyLinkedList theSuccessor) {
        this.predecessor = thePredecessor;
        this.successor = theSuccessor;
    }//END public DoublyLinkedList (DoublyLinkedList...theSuccessor)

    //gets the element of the node, FOR ALL NODES --minus-- HEAD AND TAIL
    public int getElement () {
        return this.element;
    }//END public int getElement ()

    //sets the element of the node, FOR ALL NODES --minus-- HEAD AND TAIL
    public void setElement (int newElement) {
        this.element = newElement;
    }//END public void setElement (int newElement)

    //gets the predecessor of the node, FOR ALL NODES --minus-- HEAD AND TAIL
    public DoublyLinkedList getPredecessor () {
        return this.predecessor;
    }//END public DoublyLinkedList getPredecessor ()

    //sets the predecessor of the node, FOR ALL NODES --minus-- HEAD AND TAIL
    public void setPredecessor (DoublyLinkedList newPredecessor) {
        this.predecessor = newPredecessor;
    }//END public void setPredecessor (DoublyLinkedList newPredecessor)

    //gets the successor of the node, FOR ALL NODES --minus-- HEAD AND TAIL
    public DoublyLinkedList getSuccessor () {
        return this.successor;
    }//END public DoublyLinkedList getSuccessor ()

    //sets the successor of the node, FOR ALL NODES --minus-- HEAD AND TAIL
    public void setSuccessor (DoublyLinkedList newSuccessor) {
        this.successor = newSuccessor;
    }//END public void setSuccessor (DoublyLinkedList newSuccessor)

    //gets the index of the node, FOR ALL NODES --minus-- HEAD AND TAIL
    public int getIndex () {
        return this.index;
    }//END public int getIndex ()

    //sets the size of the list
    public static void setSize (int newSize) {
        size = newSize;
    }//END public static void setSize (int newSize)

    //gets the size of the list
    public static int getSize () {
        return size;
    }//END public static int getSize ()

    //gets the index of the node, FOR ALL NODES --minus-- HEAD AND TAIL
    public void setIndex (int newIndex) {
        this.index = newIndex;
    }//END public void setIndex (int newIndex)
}//END public class DoublyLinkedList