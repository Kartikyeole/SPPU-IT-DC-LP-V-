import java.rmi.*;

interface ServerIntf extends Remote {
    // Syntax for method declaration: access_specifier return_type method_name(arguments...){ return value}

    public void sendsent(String sen1, String sen2) throws RemoteException;

    public int lengthsen(String sen) throws RemoteException;

    public String constring(String sen1, String sen2) throws RemoteException;

    public boolean palindrome(String a) throws RemoteException;

    public String Reversestr(String a) throws RemoteException;

    public boolean isequalstring(String str1, String str2) throws RemoteException;
}