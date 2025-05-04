
import java.rmi.*;

public interface ServerIntf extends Remote {
    void sendsent(String sen1, String sen2) throws RemoteException;
    int lengthsen(String sen) throws RemoteException;
    String constring(String sen1, String sen2) throws RemoteException;
    boolean palindrome(String a) throws RemoteException;
    String Reversestr(String a) throws RemoteException;
    boolean isequalstring(String str1, String str2) throws RemoteException;
}
