import java.io.*;
import java.net.*;

public class client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5555);

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String msg;
        while (true) {
            System.out.print("Enter message: ");
            msg = keyboard.readLine();
            out.println(msg);
            System.out.println("Server: " + in.readLine());

            if (msg.equalsIgnoreCase("exit")) break;
        }

        socket.close();
    }
}
