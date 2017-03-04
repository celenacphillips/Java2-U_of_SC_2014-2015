/*
 * Name:		Celena Williams
 * Assignment:  Program 3
 * Class:		CSCE 146
 * Semester:    Spring 2015
 * School:		USC Sumter
 */

import java.util.Scanner;

public class Homework3WilliamsCelena {
    private static QueueProgram frontU, rearU, queueL [];
    private static int front, rear;

    public static void main (String [] args) {
        @SuppressWarnings("resource")
        Scanner scan = new Scanner (System.in);

        System.out.println ("Would you like a limited (1) or " + 
                            "unlimited (2) queue?");
        int answer = scan.nextInt ();

        if (answer != 1 && answer != 2) {
            System.out.println("Error! Enter 1 for limited or 2 for unlimited");
            main (args);
        }//END if (answer != 1 && answer != 2)

        if (answer == 1)
            createLimited ();

        if (answer == 2)
            createUnlimited ();

        int done = 0;

        System.out.println ("Enter the number cooresponding to the method" + 
                            " you would like to use:" + 
                            "\n1).enqueue\t\t3).peek\t\t5).isFull" + 
                            "\n2).dequeue\t\t4).isEmpty" + 
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
                    System.out.println ("Enter the number cooresponding to " + 
                                        "the method you would like to use:" + 
                                        "\n1).enqueue\t\t3).peek\t\t5).isFull" + 
                                        "\n2).dequeue\t\t4).isEmpty" + 
                                        "\nOR -1 to exit");
                    break;
                case 1:
                    System.out.println ("Enter the next element you would " + 
                                        "like to add in your queue:");
                    element = scan.nextInt ();
                    enqueue (element);//void
                    System.out.println ("Enter 0 for list");
                    break;
                case 2:
                    if (QueueProgram.getSize () != 0)
                        System.out.println ("The element dequeued is " + 
                                            dequeue () + " and the size is now "
                                          + QueueProgram.getSize () + ".");//int
                    else
                        System.out.println ("Is the queue empty? " + 
                                            isEmpty ());//boolean
                    System.out.println ("Enter 0 for list");
                    break;
                case 3:
                    if (QueueProgram.getSize () != 0)
                        System.out.println ("The element in the front is " + 
                                            peek () + " and the size is " + 
                                            QueueProgram.getSize() + ".") ;//int
                    else
                        System.out.println ("Is the queue empty? " + 
                                            isEmpty ());//boolean
                    System.out.println ("Enter 0 for list");
                    break;
                case 4:
                    System.out.println ("Is the queue empty? " +
                                        isEmpty ());//boolean
                    System.out.println ("Enter 0 for list");
                    break;
                case 5:
                    System.out.println ("Is the queue full? " + 
                                        isFull ());//boolean)
                    System.out.println ("Enter 0 for list");
                default:
            }//END switch (method)
        }//END while (done != -1)
    }//END public static void main (String [] args)

    //creates the unlimited queue
    private static void createUnlimited () {
        @SuppressWarnings("resource")
        Scanner scan = new Scanner (System.in);

        System.out.println ("Enter the first element in your queue:");

        frontU = new QueueProgram ();
        rearU = new QueueProgram ();
        QueueProgram queueU = new QueueProgram ();

        queueU.setElement (scan.nextInt ());
        QueueProgram.setSize (1);
        System.out.println ("The element is " + queueU.getElement () + 
                            " and the size of the queue is " + 
                            QueueProgram.getSize ());

        frontU.setSuccessor (queueU);
        rearU.setPredecessor (queueU);

        queueU.setSuccessor (rearU);
        queueU.setPredecessor (frontU);
    }//END private static void createUnlimited ()

    //creates the limited queue
    private static void createLimited () {
        @SuppressWarnings("resource")
        Scanner scan = new Scanner (System.in);

        System.out.println ("Enter the capacity:");

        queueL = new QueueProgram [scan.nextInt ()];

        System.out.println ("Enter the integers:");

        for (int i = 0; i < queueL.length; i++) {
            queueL [i] = new QueueProgram (queueL.length);
            queueL [i].setElement (scan.nextInt ());
            QueueProgram.setSize (QueueProgram.getSize () + 1);

            front = 0;
            rear = queueL.length - 1;
        }//END for (int i = 0; i < queueL.length; i++)
    }//END private static void createLimited ()

    //adds the element to the rear and increases size by 1
    private static void enqueue (int newElement) {
        if (QueueProgram.getFixedCapacity ()) {
            if (QueueProgram.getCapacity () == QueueProgram.getSize ())
                System.out.println ("The queue is already at capacity. " + 
                                    "Element was not added.");
            else {
                QueueProgram.setSize (QueueProgram.getSize () + 1);

                if (QueueProgram.getSize () > 1)
                    //creates the circular array
                    rear = (rear + 1) % QueueProgram.getCapacity ();

                queueL [rear].setElement (newElement);

                System.out.println ("The element enqueued is " + 
                                    queueL [rear].getElement () + 
                                    " and the size of the queue is now " + 
                                    QueueProgram.getSize () + ".");
            }//END else
        }//END if (QueueProgram.getFixedCapacity ())
        else {
            QueueProgram queueU = new QueueProgram ();

            if (QueueProgram.getSize () != 0) {
                queueU.setElement (newElement);
                queueU.setSuccessor (rearU);
                queueU.setPredecessor (rearU.getPredecessor ());
                rearU.getPredecessor ().setSuccessor (queueU);
                rearU.setPredecessor (queueU);
            }//END if (QueueProgram.getSize () != 0)
            else {
                frontU.setSuccessor (queueU);
                rearU.setPredecessor (queueU);

                queueU.setElement (newElement);
                queueU.setSuccessor (rearU);
                queueU.setPredecessor (frontU);
            }//END else
            QueueProgram.setSize (QueueProgram.getSize () + 1);

            System.out.println ("The element enqueued is " + 
                                queueU.getElement () + 
                                " and the size of the queue is now " + 
                                QueueProgram.getSize () + ".");
        }//END else
    }//END private static void enqueue (int newElement)

    //removes the element from the front and decreases size by 1
    private static int dequeue () {
        int element = 0;

        if (QueueProgram.getFixedCapacity ()) {
            if (QueueProgram.getSize () == 0)
                System.out.println ("The queue is empty");
            else {
                element = queueL [front].getElement ();	
                QueueProgram.setSize (QueueProgram.getSize () - 1);
                queueL [front].setElement (-1);

                if (QueueProgram.getSize () > 0)
                    //creates the circular array
                    front = (front + 1) % QueueProgram.getCapacity ();
            }//END else
        }//END if (QueueProgram.getFixedCapacity ())
        else {
            if (frontU.getSuccessor () != null) {
                element = frontU.getSuccessor ().getElement ();
                frontU.setSuccessor (frontU.getSuccessor ().getSuccessor ());
                frontU.getSuccessor ().setPredecessor (frontU);
            }//END if (frontU.getSuccessor () != null)		
            QueueProgram.setSize (QueueProgram.getSize () - 1);
        }//END else
        return element;
    }//END private static int dequeue ()

    //shows the element at the front
    private static int peek () {
        int element = 0;

        if (QueueProgram.getFixedCapacity ()) {
            if (QueueProgram.getSize () == 0)
                System.out.println ("The queue is empty");
            else
                element = queueL [front].getElement ();
        }//END if (QueueProgram.getFixedCapacity ())
        else
            element = frontU.getSuccessor ().getElement ();

        return element;
    }//END private static int peek ()

    //checks if the queue is empty
    private static boolean isEmpty () {
        return QueueProgram.getSize () == 0;
    }//END private static boolean isEmpty ()

    //checks if the queue is full
    private static boolean isFull () {
        return (QueueProgram.getSize () == QueueProgram.getCapacity ()) && 
                (QueueProgram.getFixedCapacity () == true);
    }//END private static boolean isFull ()
}//END public class Homework3WilliamsCelena