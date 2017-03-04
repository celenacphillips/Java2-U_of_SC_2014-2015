import java.util.Scanner;

/*
 * Name:		Celena Williams
 * Assignment:  Program 2
 * Class:		CSCE 146
 * Semester:    Spring 2015
 * School:		USC Sumter
 */

public class Homework2WilliamsCelena {
    private static StackProgram top;

    public static void main (String [] args) {
        create ();

        @SuppressWarnings("resource")
        Scanner scan = new Scanner (System.in);

        int done = 0;

        System.out.println ("Enter the number cooresponding to the method" + 
                            " you would like to use:" +
                            "\n1).push \t3).peek" +
                            "\n2).pop\t\t4).isEmpty" +
                            "\nOR -1 to exit" +
                            "\nOR 0 for list");

        while (done != -1) {
            //gets the value from the user, which method they would like to try
            int method = scan.nextInt ();
            int element;

            //allows easy collective calling to all the methods
            switch (method) {
                case -1:
                    done = -1;
                    break;
                case 0:
                    System.out.println ("Enter the number cooresponding to" + 
                                        " the method you would like to use:" +
                                        "\n1).push \t3).peek" +
                                        "\n2).pop\t\t4).isEmpty" +
                                        "\n\nOR -1 to exit\n");
                    break;
                case 1:
                    System.out.println ("Enter the next element you would " + 
                                        "like to add in your stack:");
                    element = scan.nextInt ();
                    push (element);//void
                    break;
                case 2:
                    if (StackProgram.getSize () != 0)
                        System.out.println ("The element popped is " + pop () + 
                                            " and the size is now " + 
                                            StackProgram.getSize () + ".");//int
                    else
                        System.out.println ("Is the stack empty? " + 
                                            isEmpty ());//boolean
                    break;
                case 3:
                    if (StackProgram.getSize () != 0)
                        System.out.println ("The element on top is " + peek () +
                                            " and the size is " + 
                                            StackProgram.getSize() + ".") ;//int
                    else
                        System.out.println ("Is the stack empty? " + 
                                            isEmpty ());//boolean
                    break;
                case 4:
                    System.out.println ("Is the stack empty? " + 
                                        isEmpty ());//boolean
                    break;
                default:
            }//END switch (method)
        }//END while (done != -1)
    }//END public static void main (String [] args)

    private static void create () {		
        System.out.println ("Enter the first element in your stack:");

        @SuppressWarnings("resource")
        Scanner scan = new Scanner (System.in);
        //predecessor = null		element = scan.nextInt ()
        top = new StackProgram (null, scan.nextInt ());
        StackProgram.setSize (1);//size = 1
        System.out.println ("The element is " + top.getElement () + 
                            " and the size of the stack is " + 
                            StackProgram.getSize () + ".");
    }//END private static void create ()

    //adds the user's element to the top and increases size by 1
    public static void push (int element) {
        StackProgram temp = new StackProgram ();

        temp.setElement (top.getElement ());
        temp.setPredecessor (top.getPredecessor ());
        //predecessor = temp		element = element
        top = new StackProgram (temp, element);
        StackProgram.setSize (StackProgram.getSize () + 1);//size += 1
        System.out.println ("The element pushed is " + top.getElement () + 
                            " and the size of the stack is now " + 
                            StackProgram.getSize () + ".");
    }//END public static void push (int element)

    //removes the top element and decreases size by 1
    public static int pop () {
        StackProgram temp = new StackProgram ();

        int element = top.getElement ();

        if (top.getPredecessor () != null) {
            temp.setElement (top.getPredecessor ().getElement ());
            temp.setPredecessor (top.getPredecessor ().getPredecessor ());
        }//END if (top.getPredecessor () != null)

        StackProgram.setSize (StackProgram.getSize () - 1);
        top.setElement (temp.getElement ());
        top.setPredecessor (temp.getPredecessor ());

        return element;
    }//END public static int pop ()

    //displays the top element
    public static int peek () {
        int element = top.getElement ();
        return element;
    }//END public static int peek ()

    //displays whether or not the stack is empty
    public static boolean isEmpty () {
        return (StackProgram.getSize () == 0);
    }//END public static boolean isEmpty ()
}//END public class Homework2WilliamsCelena