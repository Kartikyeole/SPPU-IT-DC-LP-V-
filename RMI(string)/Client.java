import java.rmi.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            String serverURL = "rmi://localhost/Server";
            ServerIntf serverIntf = (ServerIntf) Naming.lookup(serverURL);
            System.out.print("Enter First word: ");
            String sen1 = sc.next();
            System.out.print("Enter Second word: ");
            String sen2 = sc.next();
            System.out.println("First word Is: " + sen1);
            System.out.println("Second word Is: " + sen2);
            serverIntf.sendsent(sen1, sen2);
            System.out.println("--------------- Results ---------------");
            System.out.println("Length of First word Is: "
                    + serverIntf.lengthsen(sen1));
            System.out.println("Word is palindrome or not (" + sen1 + "): "
                    + serverIntf.palindrome(sen1));
            System.out.println("Reverse of First word Is: (" + sen1 + "): "
                    + serverIntf.Reversestr(sen1));
            System.out.println("Word is Equal/same or not: (" + sen1 + "): "
                    + serverIntf.isequalstring(sen1, sen2));
            System.out.println("concatenation of word Is: "
                    + serverIntf.constring(sen1, sen2));
        } catch (Exception e) {
            System.out.println("Exception Occurred At Client!" + e.getMessage());
        }
    }
}