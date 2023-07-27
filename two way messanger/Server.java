import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        // create a server socket and bind it to a port number
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        // accept incoming connections
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected: " + clientSocket.getInetAddress());

        // create input and output streams
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        // read messages from the client and send responses
        String message;
        BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            // read message from client
            message = in.readLine();
            if (message == null) {
                break;
            }
            System.out.println("Received message from client: " + message);

            // read message from user and send to client
            System.out.print("Enter message to send to client: ");
            String response = userIn.readLine();
            out.println(response);
            System.out.println("Sent message to client: " + response);
        }

        // close the connection
        System.out.println("Closing connection");
        clientSocket.close();
        serverSocket.close();
    }
}
