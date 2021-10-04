import com.sun.deploy.net.MessageHeader;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import java.util.Scanner;


// THE FIRST SOLID PRINCIPLE I BROKE : *** Single responsibility ***
// HOW ?! ----> EX: IN THE getInstance METHODE IT DO 3 FUNCTIONS .-- I'M GONNA TO FIX THIS SOLID --

// AND THE OPEN CLOSED SOLID TO MAKE IT WORK ON ALL CONNECTIONS WITH OUT IF ELSE
public class Connection {

    private static Connection instance;


    public static List<String> allConnections = new ArrayList <String>(3);
    public static int numberConnections = 0;

    public static int counter=0;

    public static int increment()
    {
        counter++;
        return counter ;
    }

    public static int Decrement()
    {
        counter--;
        return counter ;
    }

    public static void send( String protocol ){
        System.out.println("this " + protocol + " protocol ");

    }
    public static synchronized Connection getInstance(String type) //
    {
        if (instance == null || allConnections.size()<3) {

            instance = new Connection();
            Connection.addConnectionToList(type);
            Connection.send(type) ;
            System.out.println("The list initially: " + allConnections);
        }

        else
            System.out.println(" This Connection Already  ");

        return instance;

    }

    public static void addConnectionToList(String protocol) {
        Connection.allConnections.add(protocol) ;
    }

    public static List<String> getCurrentConnections() {
        for (String val : allConnections) {
            System.out.println(val + " ");
        }
        return allConnections ;
    }


    public static void release( ) {

        if (instance == null ){
            System.out.println("2_ release METHODE --- Already the instance was Empty ");
        }
        else {
            Connection.Decrement();
            instance = null ;
            Connection.allConnections.clear();
            System.out.println("2 release METHODE instance will be destroyed  ");
        }

    }


    public static void main(String args[])


            throws java.io.IOException {
        int choice;
        Scanner sc = new Scanner(System.in);

        String T = "TELNET";
        String SS = "SSH" ;
        String H = "HTTP";
        String SC = "SCP" ;
        String F= "FTP" ;

        System.out.println("\n\n-------Syntax Generator for ------------");
        System.out.println("  1. ADD CONNECTION & SEND A MESSAGE ");
        System.out.println("  2. PRINT LIST OF CONNECTIONS ");
        System.out.println("  3. RELEASE ALL CONNECTIONS ");
        System.out.println("  4. Exit the program...\n");
        while (true) {

            System.out.println("\n---------------------------------\n" + "Choose one:");
            choice = sc.nextInt();


            System.out.println("");

            switch (choice) {
                case 1:
                    System.out.println("Choose Protocol ( T , SS , H , SC , F ):");
                    String Protocol = sc.next();
                    Connection HTTP1 = Connection.getInstance(Protocol);

                    break;
                case 2:
                    Connection.getCurrentConnections() ;
                    break;
                case 3:
                    Connection.release();
                    break;
                case 4:
                    System.out.println("THX FOR YOUR TIME .. !");
                    return;

            }
        }

    }
}