import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        // create a socket and connect to the server
        Socket socket = new Socket("localhost", 8080);
        System.out.println("Connected to server");

        // create input and output streams
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // read messages from the user and send to the server
        BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
        String message;
        while (true) {
            // read message from user and send to server
            System.out.print("Enter message to send to server: ");
            message = userIn.readLine();
            out.println(message);
            System.out.println("Sent message to server: " + message);

            // read message from server
            message = in.readLine();
            if (message == null) {
                break;
            }
            System.out.println("Received message from server: " + message);
        }

        // close the connection
        System.out.println("Closing connection");
        socket.close();
    }
}
