import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server{
    private ServerSocket serverSocket;

    public Server(ServerSocket serverSocket){
        this.serverSocket= serverSocket;
    }

    public void startServer(){
        try{
            while(!serverSocket.isClosed()){
                Socket socket= serverSocket.accept();
                System.out.println("A new client has connected.");
                clienthandler clienthandler= new clienthandler(socket);

                Thread thread= new Thread(clienthandler);
                thread.start();
            }
        }catch(IOException e){
            
        }
    }
    public void closeServerSocket(){
        try{
            if(serverSocket != null)
                serverSocket.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(1111);
        Server server = new Server(serverSocket);
        server.startServer();
    }
}