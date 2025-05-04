
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {
        try {
           // LocateRegistry.createRegistry(1099); // Start RMI registry programmatically
            ServerImpl serverImpl = new ServerImpl();
            Naming.rebind("Server", serverImpl);
            System.out.println("Server Started...");
        } catch (Exception e) {
            System.out.println("Exception Occurred At Server: " + e.getMessage());
        }
    }
}
