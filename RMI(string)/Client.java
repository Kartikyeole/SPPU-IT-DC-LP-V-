
import java.rmi.Naming;
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

            System.out.println("\nFirst word: " + sen1);
            System.out.println("Second word: " + sen2);

            serverIntf.sendsent(sen1, sen2);

             System.out.println("\n\n\n");
            System.out.println("\n--------------- Results ---------------");
            System.out.println("Length of First word: " + serverIntf.lengthsen(sen1));
            System.out.println("Is Palindrome (" + sen1 + "): " + serverIntf.palindrome(sen1));
            System.out.println("Reversed First word: " + serverIntf.Reversestr(sen1));
            System.out.println("Words are Equal: " + serverIntf.isequalstring(sen1, sen2));
            System.out.println("Concatenated words: " + serverIntf.constring(sen1, sen2));

        } catch (Exception e) {
            System.out.println("Exception Occurred At Client: " + e.getMessage());
        }

        sc.close();
    }
}
