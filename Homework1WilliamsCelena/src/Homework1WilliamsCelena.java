import java.util.Scanner;

/*
 * Name:		Celena Williams
 * Assignment:  Homework1
 * Class:		CSCE 146
 * Semester:    Spring 2015
 * School:		USC Sumter
 * Date:		February 26, 2015
 */

public class Homework1WilliamsCelena {
    private static int size;
    private static DoublyLinkedList node [], head, tail;

    public Homework1WilliamsCelena () {
        size = 0;
        head = new DoublyLinkedList (null, null);
        tail = new DoublyLinkedList (null, null);
    }//END public Homework1WilliamsCelena ()

    public static void main (String [] args) {
        create ();
    }//END public static void main (String [] args)

    private static void create () {
        @SuppressWarnings("resource")
        Scanner scan = new Scanner (System.in);
        System.out.println ("Enter a number for the length of your list:");
        //gets the value from the user and sends it to the method
        DoublyLinkedList.setSize (scan.nextInt ());
        size = DoublyLinkedList.getSize ();//gets the value sent and stored it  

        //if the size is less than or  equal to 0
        if (size <= 0) {
            System.out.println ("ERROR! Cannot have a list smaller than or" + 
                                " equal to 0.");
            System.exit (0);
        }//END if (size <= 0)

        //creates a new DoublyLinkedList array node
        node = new DoublyLinkedList [size];

        System.out.println("For each node, enter an element and press [ENTER]");

        for (int i = 0; i < size; i++) {
            //creates a new DoublyLinkedList node
            node [i] = new DoublyLinkedList ();
            //gets the value from the user and sets it as the element
            node [i].setElement (scan.nextInt ());
            node [i].setIndex (i);//sets the index
        }//END for (int i = 0; i < size; i++)

        for (int i = 1; i < size; i++) {
            //sets the predecessor as the previous node
            node [i].setPredecessor (node [i - 1]);
            //sets the first node's predecessor as the head
            node [0].setPredecessor (head);
        }//END for (int i = 1; i < size; i++)

        for (int i = size - 2; i >= 0; i--) {
            //sets the successor as the next node
            node [i].setSuccessor (node [i + 1]);
            //sets the last node's successor as the tail
            node [size - 1].setSuccessor (tail);
        }//END for (int i = size - 2; i >= 0; i--)

        int done = 0;

        while (done != -1) {
            System.out.println ("Enter the number cooresponding to the method" + 
                                " you would like to use:" +
                                "\n1).add \t\t4).lastIndexOf" + 
                                "\n2).get\t\t5).remove" + 
                                "\n3).indexOf\t6).set" + 
                                "\n\nOR -1 to exit");
            //gets the value from the user, which method they would like to try
            int method = scan.nextInt ();
            int index, element;

            //allows easy collective calling to all the methods
            switch (method) {
                case -1:
                    done = -1;
                    break;
                case 1:
                    System.out.println ("Enter the index you would like to " + 
                                        "add at, followed by the element you " + 
                                        "would like to add");
                    index = scan.nextInt ();
                    element = scan.nextInt ();
                    if (index < 0 || index > size - 1) {
                        System.out.println ("ERROR! Cannot add outside the" + 
                                            " list!");
                        System.exit (0);
                    }//END if (index < 0 || index > size - 1)
                    add (index, element);//void
                    break;
                case 2:
                    System.out.println ("Enter the index you would like to " + 
                                        "get from");
                    index = scan.nextInt ();
                    if (index < 0 || index > size - 1) {
                        System.out.println ("ERROR! Cannot add outside the" + 
                                            " list!");
                        System.exit (0);
                    }//END if (index < 0 || index > size - 1)
                    System.out.println ("The element at index " + index + " is "
                                      + get (index));//int
                    break;
                case 3:
                    System.out.println ("Enter the element you would like to " + 
                                        "get the index of");
                    element = scan.nextInt ();
                    System.out.println ("The index of element " + element + 
                                        " is " + indexOf (element));//int
                    break;
                case 4:
                    System.out.println ("Enter the element you would like to" + 
                                        " get the last index of");
                    element = scan.nextInt ();
                    System.out.println ("The last index of element " + element +
                                        " is " + lastIndexOf (element));//int
                    break;
                case 5:
                    System.out.println ("Enter the index of the element you " + 
                                        "would like to remove");
                    index = scan.nextInt ();
                    if (index < 0 || index > size - 1) {
                        System.out.println ("ERROR! Cannot add outside the" + 
                                            " list!");
                        System.exit (0);
                    }//END if (index < 0 || index > size - 1)
                    remove (index);//void
                    break;
                case 6:
                    System.out.println ("Enter the index you would like to " + 
                                        "change, followed by the element you " + 
                                        "would like to change it to");
                    index = scan.nextInt ();
                    element = scan.nextInt ();
                    if (index < 0 || index > size - 1) {
                        System.out.println ("ERROR! Cannot add outside the" + 
                                            " list!");
                        System.exit (0);
                    }//END if (index < 0 || index > size - 1)
                    set (index, element);//void
                    break;
                default:
            }//END switch (method)
        }//END while (done != -1)
    }//END private static void create ()

    //sets size++, moves all nodes at index up one and adds new element at index
    public static void add (int theIndex, int newElement) {
        size++;
        //creates a temporary DoublyLinkedList
        DoublyLinkedList temp [] = new DoublyLinkedList [size];

        for (int i = 0; i < size; i++) {
            //creates a new DoublyLinkedList temp
            temp [i] = new DoublyLinkedList ();
            temp [i].setIndex (i);//sets the index
        }//END for (int i = 0; i < size; i++)

        //starts at the end of the list and gets the element from the node
        //[i - 1] and sets it as the temp [i]
        for (int i = size - 1; i > theIndex; i--) {
            temp [i].setElement (node [i - 1].getElement ());
        }//END for (int i = size - 1; i > theIndex; i--)

        //starts at the beginning of the list and gets the element from the 
        //node [i] and sets it as the temp [i]
        //sets the element at the specified index as the new specified element
        for (int i = 0; i < theIndex; i++) {
            temp [i].setElement (node [i].getElement ());
            temp [theIndex].setElement (newElement);
        }//END for (int i = 0; i < theIndex; i++)

        //sets the predecessors of the temp DoublyLinkedList
        for (int i = 1; i < size; i++) {
            temp [i].setPredecessor (temp [i - 1]);
            temp [0].setPredecessor (head);
        }//END for (int i = 1; i < size; i++)

        //sets the successors of the temp DoublyLinkedList
        for (int i = size - 2; i >= 0; i--) {
            temp [i].setSuccessor (temp [i + 1]);
            temp [size - 1].setSuccessor (tail);
        }//END for (int i = size - 2; i >= 0; i--)

        //creates a new DoublyLinkedList node with a size of +1
        node = new DoublyLinkedList [size];

        //assigns all values of temp to new node DoublyLinkedList
        for (int i = 0; i < size; i++) {
            node [i] = new DoublyLinkedList ();
            node [i].setElement (temp [i].getElement ());
            node [i].setIndex (temp [i].getIndex ());
            node [i].setPredecessor (temp [i].getPredecessor ());
            node [i].setSuccessor (temp [i].getSuccessor ());
        }//END for (int i = 0; i < size; i++)

        //shows the user what exactly has happened to the list
        for (int i = 0; i < size; i++) {
            System.out.println ("Index : " + node [i].getIndex () + 
                                "\tElement: " + node [i].getElement ());
        }//END for (int i = 0; i < size; i++)
    }//END public static void add (int theIndex, int newElement)

    //gets the element at the index
    public static int get (int theIndex) {
        return node [theIndex].getElement ();
    }//END public static int get (int theIndex)


    //gets the index of the element, or -1 if not in the list
    public static int indexOf (int theElement) {
        int index = -1;

        //starts at the end of the list, as to get the first occurrence
        for (int i = size - 1; i >= 0; i--) {
            if (node [i].getElement () == theElement)
                index = node [i].getIndex ();
        }//END for (int i = size - 1; i >= 0; i--)

        return index;
    }//END public static int indexOf (int theElement)


    //gets the last index of the element, or -1 if not in the list
    public static int lastIndexOf (int theElement) {
        int index = -1;

        //starts at the beginning of the list, as to get the last occurrence
        for (int i = 0; i < size; i++) {
            if (node [i].getElement () == theElement)
                index = node [i].getIndex ();
        }//END for (int i = 0; i < size; i++)

        return index;
    }//END public static int lastIndexOf (int theElement)


    //sets size--, move all nodes at index down 1 and subtracts element at index
    public static void remove (int theIndex) {
        size--;
        //creates a temporary DoublyLinkedList
        DoublyLinkedList temp [] = new DoublyLinkedList [size];

        for (int i = 0; i < size; i++) {
            //creates a new DoublyLinkedList temp
            temp [i] = new DoublyLinkedList ();
            temp [i].setIndex (i);//sets the index
        }//END for (int i = 0; i < size; i++)

        //starts at the beginning of the list and gets all the elements of 
        //node [i] (until the specified index), and stores in temp [i]
        for (int i = 0; i < theIndex; i++) {
            temp [i].setElement (node [i].getElement ());
        }//END for (int i = 0; i < theIndex; i++)

        //starts at the specified index and gets all the element of 
        //node [i + 1] and stores in temp [i]
        for (int i = theIndex; i < size; i++) {
            temp [i].setElement (node [i + 1].getElement ());
        }//END for (int i = theIndex; i < size; i++)

        //sets the predecessors of the temp DoublyLinkedList
        for (int i = 1; i < size; i++) {
            temp [i].setPredecessor (temp [i - 1]);
            temp [0].setPredecessor (head);
        }//END for (int i = 1; i < size; i++)

        //sets the successors of the temp DoublyLinkedList
        for (int i = size - 2; i >= 0; i--) {
            temp [i].setSuccessor (temp [i + 1]);
            temp [size - 1].setSuccessor (tail);
        }//END for (int i = size - 2; i >= 0; i--)

        //creates a new DoublyLinkedList node with a size of -1
        node = new DoublyLinkedList [size];

        //assigns all values of the temp to new node DoublyLinkedList
        for (int i = 0; i < size; i++) {
            node [i] = new DoublyLinkedList ();
            node [i].setElement (temp [i].getElement ());
            node [i].setIndex (temp [i].getIndex ());
            node [i].setPredecessor (temp [i].getPredecessor ());
            node [i].setSuccessor (temp [i].getSuccessor ());
        }//END for (int i = 0; i < size; i++)

        //shows the user what exactly has happened to the list
        for (int i = 0; i < size; i++) {
            System.out.println ("Index : " + node [i].getIndex () + 
                                "\tElement: " + node [i].getElement ());
        }//END for (int i = 0; i < size; i++)
    }//END public static void remove (int theIndex)

    //sets the element at the index
    public static void set (int theIndex, int newElement) {
        node [theIndex].setElement (newElement);

        //shows the user what exactly has happened to the list
        for (int i = 0; i < size; i++) {
            System.out.println ("Index : " + node [i].getIndex () + 
                                "\tElement: " + node [i].getElement ());
        }//END for (int i = 0; i < size; i++)
    }//END public static void set (int theIndex, int newElement)
}//END public class Homework1WilliamsCelena