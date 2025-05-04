
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class ServerImpl extends UnicastRemoteObject implements ServerIntf {

    public ServerImpl() throws RemoteException {
        super();
    }

    public void sendsent(String sen1, String sen2) throws RemoteException {
        System.out.println("Received words: " + sen1 + " and " + sen2);
    }

    public int lengthsen(String sen) throws RemoteException {
        return sen.length();
    }

    public String constring(String sen1, String sen2) throws RemoteException {
        return sen1 + sen2;
    }

    public boolean palindrome(String a) throws RemoteException {
        StringBuilder sb = new StringBuilder(a);
        return a.equalsIgnoreCase(sb.reverse().toString());
    }

    public String Reversestr(String a) throws RemoteException {
        return new StringBuilder(a).reverse().toString();
    }

    public boolean isequalstring(String str1, String str2) throws RemoteException {
        return str1.equalsIgnoreCase(str2);
    }
}
